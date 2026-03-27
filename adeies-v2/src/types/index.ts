export interface DbConfig {
  host: string
  port: number
  database: string
  user: string
  password: string
}

export interface AppUser {
  id: number
  username: string
  full_name: string
  role: 'admin' | 'user'
}

export interface ApiResult<T = void> {
  ok: boolean
  error?: string
  data?: T
}

declare global {
  interface Window {
    api: {
      getDbConfig: () => Promise<DbConfig | null>
      testDbConnection: (config: DbConfig) => Promise<{ ok: boolean; error?: string }>
      saveDbConfig: (config: DbConfig) => Promise<{ ok: boolean; error?: string }>
      userSession: () => Promise<AppUser | null>
      userLogin: (username: string, password: string) => Promise<{ ok: boolean; error?: string; user?: AppUser }>
      userLogout: () => Promise<{ ok: boolean }>
      userList: () => Promise<(AppUser & { created_at: string })[]>
      userCreate: (data: { username: string; full_name: string; role: string; password: string }) => Promise<{ ok: boolean; error?: string }>
      userUpdate: (id: number, data: { full_name: string; role: string }) => Promise<{ ok: boolean; error?: string }>
      userChangePassword: (id: number, password: string) => Promise<{ ok: boolean; error?: string }>
      userDelete: (id: number) => Promise<{ ok: boolean; error?: string }>
      getStats: () => Promise<Record<string, number>>
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
