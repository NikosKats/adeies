/**
 * Migration script: adeies.db (SQLite) → PostgreSQL
 *
 * Usage:
 *   DATABASE_URL=postgresql://user:pass@host:5432/adeies \
 *   SQLITE_PATH=../adeies.db \
 *   npm run migrate:sqlite
 */

import { Database } from 'bun:sqlite'  // or use better-sqlite3 if not using bun
import { Pool } from 'pg'

const SQLITE_PATH = process.env.SQLITE_PATH ?? '../adeies.db'
const DATABASE_URL = process.env.DATABASE_URL ?? 'postgresql://adeies:adeies@localhost:5432/adeies'

// Field mappings: SQLite Field1..N → PostgreSQL column name

const baptismDeclarationMap: Record<string, string> = {
  Field1: 'iera_mitropolis', Field2: 'ieros_naos', Field3: 'arithmos_protokolou',
  Field4: 'efimerios', Field5: 'efimerios_naou',
  Field6: 'baptism_imera', Field7: 'baptism_minas', Field8: 'baptism_etos',
  Field9: 'baptism_imera_evdomadas', Field10: 'baptism_naos',
  Field11: 'pateras_onoma', Field12: 'mitera_eponymo_genous', Field13: 'mitera_onoma',
  Field14: 'katoikia', Field15: 'odos', Field16: 'arithmos_odou',
  Field17: 'gennitiki_imera', Field18: 'gennitiki_poli',
  Field19: 'lixiarxeio_praxis_arithmos', Field20: 'lixiarxeio_tomos', Field21: 'lixiarxeio_etos',
  Field22: 'lixiarchos', Field23: 'onoma_baptisthen',
  Field24: 'anadexamenos', Field25: 'anadexamenos_katoikia',
  Field26: 'anadexamenos_odos', Field27: 'anadexamenos_arithmos',
  Field28: 'efimerios_ypografi', Field29: 'pateras_ypografi',
  Field30: 'mitera_ypografi', Field31: 'anadoxos_ypografi'
}

const baptismSpecificationMap: Record<string, string> = {
  Field1: 'iera_mitropolis', Field2: 'ieros_naos', Field3: 'arithmos_protokolou',
  Field4: 'simeron_imera', Field5: 'simeron_minas', Field6: 'simeron_etos',
  Field7: 'goneis_1', Field8: 'goneis_1_id_arithmos', Field9: 'goneis_1_id_ekdosi',
  Field10: 'goneis_2', Field11: 'goneis_2_id_arithmos', Field12: 'goneis_2_id_ekdosi',
  Field13: 'teknon_gennitiki_imera', Field14: 'teknon_gennitiki_minas', Field15: 'teknon_gennitiki_etos',
  Field16: 'teknon_nosokomeio', Field17: 'teknon_nosokomeio_etos',
  Field18: 'lixiarxeio_praxis_arithmos', Field19: 'lixiarxeio_tomos', Field20: 'lixiarxeio_etos',
  Field21: 'teknon_onoma', Field22: 'baptisma_minas', Field23: 'katoikia_odos',
  Field24: 'baptisma_imera', Field25: 'baptisma_etos',
  Field26: 'anadoxos', Field27: 'anadoxos_gamochronologia', Field28: 'anadoxos_gamonaos',
  Field29: 'topos_ypovrolis', Field30: 'imera_ypovrolis', Field31: 'etos_ypovrolis'
}

const marriageMap: Record<string, string> = {
  Field1: 'iera_mitropoli', Field2: 'arithmos_lixiarkis_praxis',
  Field3: 'tomos', Field4: 'etos',
  Field5: 'ieros_naos', Field6: 'dimotiko_topiko', Field7: 'dimos_dimotiki_enotita',
  Field8: 'nomos', Field9: 'arithmos_vivliou', Field10: 'iereus', Field11: 'iereus_eniporias',
  Field12: 'gamos_imera', Field13: 'gamos_minas', Field14: 'gamos_etos', Field15: 'gamos_ora',
  Field16: 'dogma', Field17: 'dogma_tagseis',
  Field18: 'syzygos_eponymo', Field19: 'syzygou_eponymo',
  Field20: 'syzygos_onoma', Field21: 'syzygou_onoma',
  Field22: 'syzygos_epaggelma', Field23: 'syzygou_epaggelma',
  Field24: 'syzygos_thriskevma', Field25: 'syzygou_thriskevma',
  Field26: 'syzygos_ithagenia', Field27: 'syzygou_ithagenia',
  Field28: 'syzygos_afm', Field29: 'syzygou_afm',
  Field30: 'syzygos_amka', Field31: 'syzygou_amka',
  Field32: 'syzygos_foreas_asfalisys', Field33: 'syzygou_foreas_asfalisys',
  Field34: 'syzygos_topos_gennisis', Field35: 'syzygou_topos_gennisis',
  Field36: 'syzygos_nomos_gennisis', Field37: 'syzygou_nomos_gennisis',
  Field38: 'syzygos_dimos_gennisis', Field39: 'syzygou_dimos_gennisis',
  Field40: 'syzygos_dimotiki_gennisis', Field41: 'syzygou_dimotiki_gennisis',
  Field42: 'syzygos_chora_gennisis', Field43: 'syzygou_chora_gennisis',
  Field44: 'syzygos_chronologia_gennisis', Field45: 'syzygou_chronologia_gennisis',
  Field46: 'syzygos_katikia_nomos', Field47: 'syzygou_katikia_nomos',
  Field48: 'syzygos_katikia_dimos', Field49: 'syzygou_katikia_dimos',
  Field50: 'syzygos_katikia_dimotiki', Field51: 'syzygou_katikia_dimotiki',
  Field52: 'syzygos_katikia_chora', Field53: 'syzygou_katikia_chora',
  Field56: 'syzygos_dimotis_dimos', Field57: 'syzygou_dimotis_dimos',
  Field58: 'syzygos_dimotis_nomos', Field59: 'syzygou_dimotis_nomos',
  Field60: 'syzygos_dimotis_arithmos', Field61: 'syzygou_dimotis_arithmos',
  Field62: 'syzygos_pateras', Field63: 'syzygou_pateras',
  Field64: 'syzygos_mitera', Field65: 'syzygou_mitera',
  Field66: 'zeygos_katikia', Field67: 'zeygos_katikia_2',
  Field68: 'zeygos_nomos', Field69: 'zeygos_nomos_2',
  Field70: 'zeygos_dimos', Field71: 'zeygos_dimos_2',
  Field72: 'zeygos_dimotiki', Field73: 'zeygos_dimotiki_2',
  Field74: 'zeygos_topiki', Field75: 'zeygos_topiki_2',
  Field76: 'zeygos_chora', Field77: 'zeygos_chora_2',
  Field78: 'eponymo_teknon', Field79: 'eponymo_teknon_2',
  Field80: 'syzygos_vathmos_gamou', Field81: 'syzygou_vathmos_gamou',
  Field82: 'syzygos_arithmos_adeia_gamou', Field83: 'syzygos_ieras_mitropoli_adeia',
  Field84: 'syzygou_arithmos_adeia_gamou', Field85: 'syzygou_ieras_mitropoli_adeia',
  Field86: 'syzygos_arithmos_paravolo', Field87: 'syzygou_arithmos_paravolo',
  CheckBox1: 'syzygos_oik_katastasi', CheckBox2: 'syzygou_oik_katastasi',
  CheckBox3: 'syzygos_ekpaideusi', CheckBox4: 'syzygou_ekpaideusi'
}

const certAMap: Record<string, string> = {
  Field1: 'iera_mitropolis', Field2: 'ieros_naos', Field3: 'arithmos_protokolou',
  Field4: 'efimerios', Field5: 'efimerios_naou', Field6: 'agamos_onoma',
  Field7: 'patros', Field8: 'mitros', Field9: 'gennitikos_topos',
  Field10: 'gennitiki_imera', Field11: 'gennitiki_poli', Field12: 'etos_genniseos',
  Field13: 'katoikia_apo', Field14: 'katoikia_etos', Field15: 'odos', Field16: 'arithmos_odou',
  Field17: 'ilikia', Field18: 'epaggelma', Field19: 'christianos', Field20: 'agamos_kata',
  Field21: 'dynatos_gamos', Field22: 'ekdosi_adeia',
  Field23: 'topos_ekdosis', Field24: 'imera_ekdosis', Field25: 'etos_ekdosis'
}

const certBMap: Record<string, string> = {
  Field1: 'iera_mitropolis', Field2: 'ieros_naos', Field3: 'arithmos_protokolou',
  Field4: 'efimerios', Field5: 'efimerios_naou', Field6: 'proselthen', Field7: 'agamos_onoma',
  Field8: 'patros', Field9: 'mitros', Field10: 'gennitikos_topos',
  Field11: 'gennitiki_imera', Field12: 'gennitiki_poli', Field13: 'etos_genniseos',
  Field14: 'katoikia_apo', Field15: 'katoikia_etos', Field16: 'odos', Field17: 'arithmos_odou',
  Field18: 'ilikia', Field19: 'epaggelma', Field20: 'christianos', Field21: 'dilosi_imera',
  Field22: 'martyras_1', Field23: 'martyras_1_id', Field24: 'martyras_1_astynomia',
  Field25: 'martyras_2', Field26: 'martyras_2_id', Field27: 'martyras_2_astynomia',
  Field28: 'dilosi_katoikia', Field29: 'dilosi_enthen', Field30: 'dilosi_odos',
  Field31: 'agamos_kata', Field32: 'dynatos_gamos', Field33: 'ekdosi_adeia',
  Field34: 'martyras_ypografi_1', Field35: 'martyras_ypografi_2',
  Field36: 'ekdosi_adeia_2', Field37: 'topos_ekdosis', Field38: 'imera_ekdosis'
  // Field38 → etos_ekdosis missing in original schema; field38 maps to imera_ekdosis based on FXML ordering
}

function mapRow(sqliteRow: Record<string, unknown>, fieldMap: Record<string, string>): Record<string, string> {
  const result: Record<string, string> = {}
  for (const [sqliteKey, pgKey] of Object.entries(fieldMap)) {
    const val = sqliteRow[sqliteKey]
    result[pgKey] = val != null ? String(val) : ''
  }
  return result
}

async function migrate() {
  console.log('Opening SQLite:', SQLITE_PATH)
  const sqlite = new Database(SQLITE_PATH, { readonly: true })

  console.log('Connecting to PostgreSQL:', DATABASE_URL)
  const pool = new Pool({ connectionString: DATABASE_URL })

  const tables = [
    { sqlite: 'dataBaptisis', pg: 'baptism_declarations', map: baptismDeclarationMap },
    { sqlite: 'dataProsdBaptisis', pg: 'baptism_specifications', map: baptismSpecificationMap },
    { sqlite: 'dataGamou', pg: 'marriage_declarations', map: marriageMap },
    { sqlite: 'dataAgamiasA', pg: 'certificates_a', map: certAMap },
    { sqlite: 'dataAgamiasB', pg: 'certificates_b', map: certBMap }
  ]

  for (const { sqlite: sqliteTable, pg: pgTable, map } of tables) {
    const rows = sqlite.prepare(`SELECT * FROM ${sqliteTable}`).all() as Record<string, unknown>[]
    console.log(`\nMigrating ${sqliteTable} (${rows.length} rows) → ${pgTable}`)

    for (const sqliteRow of rows) {
      const pgRow = mapRow(sqliteRow, map)
      const cols = Object.keys(pgRow)
      const vals = cols.map((_, i) => `$${i + 1}`)
      const sql = `INSERT INTO ${pgTable} (${cols.join(', ')}) VALUES (${vals.join(', ')})`
      await pool.query(sql, Object.values(pgRow))
      process.stdout.write('.')
    }
    console.log(` done.`)
  }

  sqlite.close()
  await pool.end()
  console.log('\n✅ Migration complete!')
}

migrate().catch((err) => {
  console.error('Migration failed:', err)
  process.exit(1)
})
