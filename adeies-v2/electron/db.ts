import { drizzle } from 'drizzle-orm/node-postgres'
import { Pool } from 'pg'
import * as schema from './schema'

let pool: Pool | null = null
let db: ReturnType<typeof drizzle> | null = null

export interface DbConfig {
  host: string
  port: number
  database: string
  user: string
  password: string
}

export function initDb(config: DbConfig): void {
  if (pool) {
    pool.end()
  }
  pool = new Pool({
    host: config.host,
    port: config.port,
    database: config.database,
    user: config.user,
    password: config.password,
    connectionTimeoutMillis: 5000
  })
  db = drizzle(pool, { schema })
}

export function getDb() {
  if (!db) throw new Error('Database not initialized. Configure connection first.')
  return db
}

export async function testConnection(config: DbConfig): Promise<{ ok: boolean; error?: string }> {
  const testPool = new Pool({
    host: config.host,
    port: config.port,
    database: config.database,
    user: config.user,
    password: config.password,
    connectionTimeoutMillis: 5000
  })
  try {
    const client = await testPool.connect()
    client.release()
    await testPool.end()
    return { ok: true }
  } catch (e: unknown) {
    await testPool.end().catch(() => {})
    return { ok: false, error: e instanceof Error ? e.message : String(e) }
  }
}

export async function runMigrations(): Promise<void> {
  const client = await pool!.connect()
  try {
    await client.query(`
      CREATE TABLE IF NOT EXISTS baptism_declarations (
        id SERIAL PRIMARY KEY,
        iera_mitropolis TEXT, ieros_naos TEXT, arithmos_protokolou TEXT,
        efimerios TEXT, efimerios_naou TEXT, baptism_imera TEXT, baptism_minas TEXT,
        baptism_etos TEXT, baptism_imera_evdomadas TEXT, baptism_naos TEXT,
        pateras_onoma TEXT, mitera_eponymo_genous TEXT, mitera_onoma TEXT,
        katoikia TEXT, odos TEXT, arithmos_odou TEXT, gennitiki_imera TEXT,
        gennitiki_poli TEXT, lixiarxeio_praxis_arithmos TEXT, lixiarxeio_tomos TEXT,
        lixiarxeio_etos TEXT, lixiarchos TEXT, onoma_baptisthen TEXT,
        anadexamenos TEXT, anadexamenos_katoikia TEXT, anadexamenos_odos TEXT,
        anadexamenos_arithmos TEXT, efimerios_ypografi TEXT, pateras_ypografi TEXT,
        mitera_ypografi TEXT, anadoxos_ypografi TEXT,
        created_at TIMESTAMPTZ DEFAULT NOW(), updated_at TIMESTAMPTZ DEFAULT NOW()
      );

      CREATE TABLE IF NOT EXISTS baptism_specifications (
        id SERIAL PRIMARY KEY,
        iera_mitropolis TEXT, ieros_naos TEXT, arithmos_protokolou TEXT,
        simeron_imera TEXT, simeron_minas TEXT, simeron_etos TEXT,
        goneis_1 TEXT, goneis_1_id_arithmos TEXT, goneis_1_id_ekdosi TEXT,
        goneis_2 TEXT, goneis_2_id_arithmos TEXT, goneis_2_id_ekdosi TEXT,
        teknon_gennitiki_imera TEXT, teknon_gennitiki_minas TEXT, teknon_gennitiki_etos TEXT,
        teknon_nosokomeio TEXT, teknon_nosokomeio_etos TEXT,
        lixiarxeio_praxis_arithmos TEXT, lixiarxeio_tomos TEXT, lixiarxeio_etos TEXT,
        teknon_onoma TEXT, baptisma_minas TEXT, katoikia_odos TEXT,
        baptisma_imera TEXT, baptisma_etos TEXT, anadoxos TEXT,
        anadoxos_gamochronologia TEXT, anadoxos_gamonaos TEXT,
        topos_ypovrolis TEXT, imera_ypovrolis TEXT, etos_ypovrolis TEXT,
        created_at TIMESTAMPTZ DEFAULT NOW(), updated_at TIMESTAMPTZ DEFAULT NOW()
      );

      CREATE TABLE IF NOT EXISTS marriage_declarations (
        id SERIAL PRIMARY KEY,
        iera_mitropoli TEXT, arithmos_lixiarkis_praxis TEXT, tomos TEXT, etos TEXT,
        ieros_naos TEXT, dimotiko_topiko TEXT, dimos_dimotiki_enotita TEXT, nomos TEXT,
        arithmos_vivliou TEXT, iereus TEXT, iereus_eniporias TEXT,
        gamos_imera TEXT, gamos_minas TEXT, gamos_etos TEXT, gamos_ora TEXT,
        dogma TEXT, dogma_tagseis TEXT,
        syzygos_eponymo TEXT, syzygou_eponymo TEXT, syzygos_onoma TEXT, syzygou_onoma TEXT,
        syzygos_epaggelma TEXT, syzygou_epaggelma TEXT,
        syzygos_thriskevma TEXT, syzygou_thriskevma TEXT,
        syzygos_ithagenia TEXT, syzygou_ithagenia TEXT,
        syzygos_afm TEXT, syzygou_afm TEXT, syzygos_amka TEXT, syzygou_amka TEXT,
        syzygos_foreas_asfalisys TEXT, syzygou_foreas_asfalisys TEXT,
        syzygos_topos_gennisis TEXT, syzygou_topos_gennisis TEXT,
        syzygos_nomos_gennisis TEXT, syzygou_nomos_gennisis TEXT,
        syzygos_dimos_gennisis TEXT, syzygou_dimos_gennisis TEXT,
        syzygos_dimotiki_gennisis TEXT, syzygou_dimotiki_gennisis TEXT,
        syzygos_chora_gennisis TEXT, syzygou_chora_gennisis TEXT,
        syzygos_chronologia_gennisis TEXT, syzygou_chronologia_gennisis TEXT,
        syzygos_katikia_nomos TEXT, syzygou_katikia_nomos TEXT,
        syzygos_katikia_dimos TEXT, syzygou_katikia_dimos TEXT,
        syzygos_katikia_dimotiki TEXT, syzygou_katikia_dimotiki TEXT,
        syzygos_katikia_chora TEXT, syzygou_katikia_chora TEXT,
        syzygos_dimotis_dimos TEXT, syzygou_dimotis_dimos TEXT,
        syzygos_dimotis_nomos TEXT, syzygou_dimotis_nomos TEXT,
        syzygos_dimotis_arithmos TEXT, syzygou_dimotis_arithmos TEXT,
        syzygos_pateras TEXT, syzygou_pateras TEXT,
        syzygos_mitera TEXT, syzygou_mitera TEXT,
        zeygos_katikia TEXT, zeygos_katikia_2 TEXT,
        zeygos_nomos TEXT, zeygos_nomos_2 TEXT,
        zeygos_dimos TEXT, zeygos_dimos_2 TEXT,
        zeygos_dimotiki TEXT, zeygos_dimotiki_2 TEXT,
        zeygos_topiki TEXT, zeygos_topiki_2 TEXT,
        zeygos_chora TEXT, zeygos_chora_2 TEXT,
        eponymo_teknon TEXT, eponymo_teknon_2 TEXT,
        syzygos_oik_katastasi TEXT, syzygou_oik_katastasi TEXT,
        syzygos_vathmos_gamou TEXT, syzygou_vathmos_gamou TEXT,
        syzygos_ekpaideusi TEXT, syzygou_ekpaideusi TEXT,
        syzygos_arithmos_adeia_gamou TEXT, syzygos_ieras_mitropoli_adeia TEXT,
        syzygou_arithmos_adeia_gamou TEXT, syzygou_ieras_mitropoli_adeia TEXT,
        syzygos_arithmos_paravolo TEXT, syzygou_arithmos_paravolo TEXT,
        created_at TIMESTAMPTZ DEFAULT NOW(), updated_at TIMESTAMPTZ DEFAULT NOW()
      );

      CREATE TABLE IF NOT EXISTS certificates_a (
        id SERIAL PRIMARY KEY,
        iera_mitropolis TEXT, ieros_naos TEXT, arithmos_protokolou TEXT,
        efimerios TEXT, efimerios_naou TEXT, agamos_onoma TEXT,
        patros TEXT, mitros TEXT, gennitikos_topos TEXT,
        gennitiki_imera TEXT, gennitiki_poli TEXT, etos_genniseos TEXT,
        katoikia_apo TEXT, katoikia_etos TEXT, odos TEXT, arithmos_odou TEXT,
        ilikia TEXT, epaggelma TEXT, christianos TEXT, agamos_kata TEXT,
        dynatos_gamos TEXT, ekdosi_adeia TEXT, topos_ekdosis TEXT,
        imera_ekdosis TEXT, etos_ekdosis TEXT,
        created_at TIMESTAMPTZ DEFAULT NOW(), updated_at TIMESTAMPTZ DEFAULT NOW()
      );

      CREATE TABLE IF NOT EXISTS certificates_b (
        id SERIAL PRIMARY KEY,
        iera_mitropolis TEXT, ieros_naos TEXT, arithmos_protokolou TEXT,
        efimerios TEXT, efimerios_naou TEXT, proselthen TEXT, agamos_onoma TEXT,
        patros TEXT, mitros TEXT, gennitikos_topos TEXT,
        gennitiki_imera TEXT, gennitiki_poli TEXT, etos_genniseos TEXT,
        katoikia_apo TEXT, katoikia_etos TEXT, odos TEXT, arithmos_odou TEXT,
        ilikia TEXT, epaggelma TEXT, christianos TEXT, dilosi_imera TEXT,
        martyras_1 TEXT, martyras_1_id TEXT, martyras_1_astynomia TEXT,
        martyras_2 TEXT, martyras_2_id TEXT, martyras_2_astynomia TEXT,
        dilosi_katoikia TEXT, dilosi_enthen TEXT, dilosi_odos TEXT,
        agamos_kata TEXT, dynatos_gamos TEXT, ekdosi_adeia TEXT,
        martyras_ypografi_1 TEXT, martyras_ypografi_2 TEXT,
        ekdosi_adeia_2 TEXT, topos_ekdosis TEXT, imera_ekdosis TEXT, etos_ekdosis TEXT,
        created_at TIMESTAMPTZ DEFAULT NOW(), updated_at TIMESTAMPTZ DEFAULT NOW()
      );
    `)
  } finally {
    client.release()
  }
}
