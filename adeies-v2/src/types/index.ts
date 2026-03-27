export interface DbConfig {
  host: string
  port: number
  database: string
  user: string
  password: string
}

export interface ApiResult<T = void> {
  ok: boolean
  error?: string
  data?: T
}

// Declare global api exposed by preload
declare global {
  interface Window {
    api: {
      getDbConfig: () => Promise<DbConfig | null>
      testDbConnection: (config: DbConfig) => Promise<{ ok: boolean; error?: string }>
      saveDbConfig: (config: DbConfig) => Promise<{ ok: boolean; error?: string }>
      list: (table: string) => Promise<Record<string, string>[]>
      get: (table: string, id: number) => Promise<Record<string, string> | null>
      insert: (table: string, data: Record<string, string>) => Promise<Record<string, string>>
      update: (table: string, id: number, data: Record<string, string>) => Promise<Record<string, string>>
      remove: (table: string, id: number) => Promise<{ ok: boolean }>
      exportPdf: (html: string, filename: string) => Promise<{ ok: boolean; filePath?: string; canceled?: boolean; error?: string }>
    }
  }
}

export type TableName =
  | 'baptism_declarations'
  | 'baptism_specifications'
  | 'marriage_declarations'
  | 'certificates_a'
  | 'certificates_b'
