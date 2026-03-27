import { app, BrowserWindow, ipcMain, shell, dialog } from 'electron'
import { join } from 'path'
import Store from 'electron-store'
import { initDb, testConnection, runMigrations, ensureDefaultAdmin, getDb, getPool, DbConfig } from '../db'
import {
  baptismDeclarations,
  baptismSpecifications,
  marriageDeclarations,
  certificatesA,
  certificatesB
} from '../schema'
import { eq } from 'drizzle-orm'
import { writeFile } from 'fs/promises'
import bcrypt from 'bcryptjs'

interface SessionUser {
  id: number
  username: string
  full_name: string
  role: 'admin' | 'user'
}

const store = new Store<{ dbConfig: DbConfig; session: SessionUser | null }>()

let mainWindow: BrowserWindow | null = null

function createWindow(): void {
  mainWindow = new BrowserWindow({
    width: 1280,
    height: 820,
    minWidth: 1024,
    minHeight: 640,
    webPreferences: {
      preload: join(__dirname, '../preload/index.js'),
      sandbox: false,
      contextIsolation: true
    },
    title: 'Adeies — Εκκλησιαστικό Σύστημα',
    show: false,
    titleBarStyle: process.platform === 'darwin' ? 'hiddenInset' : 'default'
  })

  mainWindow.on('ready-to-show', () => mainWindow!.show())
  mainWindow.webContents.setWindowOpenHandler(({ url }) => {
    shell.openExternal(url)
    return { action: 'deny' }
  })

  if (process.env['ELECTRON_RENDERER_URL']) {
    mainWindow.loadURL(process.env['ELECTRON_RENDERER_URL'])
  } else {
    mainWindow.loadFile(join(__dirname, '../../dist/renderer/index.html'))
  }
}

app.whenReady().then(async () => {
  createWindow()
  const savedConfig = store.get('dbConfig')
  if (savedConfig) {
    try {
      initDb(savedConfig)
      await runMigrations()
      await ensureDefaultAdmin()
    } catch {
      // Will show settings screen
    }
  }
  app.on('activate', () => {
    if (BrowserWindow.getAllWindows().length === 0) createWindow()
  })
})

app.on('window-all-closed', () => {
  if (process.platform !== 'darwin') app.quit()
})

// ── DB Settings ──────────────────────────────────────────────────────────────

ipcMain.handle('db:get-config', () => store.get('dbConfig') ?? null)
ipcMain.handle('db:test', async (_e, config: DbConfig) => testConnection(config))
ipcMain.handle('db:save-config', async (_e, config: DbConfig) => {
  const result = await testConnection(config)
  if (!result.ok) return result
  store.set('dbConfig', config)
  initDb(config)
  await runMigrations()
  await ensureDefaultAdmin()
  return { ok: true }
})

// ── Auth ─────────────────────────────────────────────────────────────────────

ipcMain.handle('user:session', () => store.get('session') ?? null)

ipcMain.handle('user:login', async (_e, username: string, password: string) => {
  try {
    const pool = getPool()
    const res = await pool.query(
      `SELECT id, username, full_name, role, password_hash FROM app_users WHERE username = $1`,
      [username]
    )
    if (res.rows.length === 0) return { ok: false, error: 'Λανθασμένο όνομα χρήστη ή κωδικός.' }
    const row = res.rows[0]
    const valid = await bcrypt.compare(password, row.password_hash)
    if (!valid) return { ok: false, error: 'Λανθασμένο όνομα χρήστη ή κωδικός.' }
    const user: SessionUser = { id: row.id, username: row.username, full_name: row.full_name, role: row.role }
    store.set('session', user)
    return { ok: true, user }
  } catch (e) {
    return { ok: false, error: e instanceof Error ? e.message : String(e) }
  }
})

ipcMain.handle('user:logout', () => {
  store.delete('session')
  return { ok: true }
})

// ── User Management (admin) ───────────────────────────────────────────────────

ipcMain.handle('user:list', async () => {
  const pool = getPool()
  const res = await pool.query(`SELECT id, username, full_name, role, created_at FROM app_users ORDER BY id`)
  return res.rows
})

ipcMain.handle('user:create', async (_e, data: { username: string; full_name: string; role: string; password: string }) => {
  try {
    const pool = getPool()
    const hash = await bcrypt.hash(data.password, 10)
    const res = await pool.query(
      `INSERT INTO app_users (username, full_name, role, password_hash) VALUES ($1, $2, $3, $4) RETURNING id, username, full_name, role`,
      [data.username, data.full_name, data.role, hash]
    )
    return { ok: true, user: res.rows[0] }
  } catch (e: unknown) {
    const msg = e instanceof Error ? e.message : String(e)
    return { ok: false, error: msg.includes('unique') ? 'Το όνομα χρήστη υπάρχει ήδη.' : msg }
  }
})

ipcMain.handle('user:update', async (_e, id: number, data: { full_name: string; role: string }) => {
  try {
    const pool = getPool()
    await pool.query(
      `UPDATE app_users SET full_name = $1, role = $2, updated_at = NOW() WHERE id = $3`,
      [data.full_name, data.role, id]
    )
    return { ok: true }
  } catch (e) {
    return { ok: false, error: e instanceof Error ? e.message : String(e) }
  }
})

ipcMain.handle('user:change-password', async (_e, id: number, newPassword: string) => {
  try {
    const pool = getPool()
    const hash = await bcrypt.hash(newPassword, 10)
    await pool.query(`UPDATE app_users SET password_hash = $1, updated_at = NOW() WHERE id = $2`, [hash, id])
    return { ok: true }
  } catch (e) {
    return { ok: false, error: e instanceof Error ? e.message : String(e) }
  }
})

ipcMain.handle('user:delete', async (_e, id: number) => {
  try {
    const pool = getPool()
    await pool.query(`DELETE FROM app_users WHERE id = $1`, [id])
    return { ok: true }
  } catch (e) {
    return { ok: false, error: e instanceof Error ? e.message : String(e) }
  }
})

// ── Stats ────────────────────────────────────────────────────────────────────

ipcMain.handle('db:stats', async () => {
  const pool = getPool()
  const tables = ['baptism_declarations', 'baptism_specifications', 'marriage_declarations', 'certificates_a', 'certificates_b']
  const counts: Record<string, number> = {}
  for (const t of tables) {
    const res = await pool.query(`SELECT COUNT(*) FROM ${t}`)
    counts[t] = parseInt(res.rows[0].count)
  }
  return counts
})

// ── Generic CRUD ─────────────────────────────────────────────────────────────

type TableName = 'baptism_declarations' | 'baptism_specifications' | 'marriage_declarations' | 'certificates_a' | 'certificates_b'

function getTable(name: TableName) {
  const map = {
    baptism_declarations: baptismDeclarations,
    baptism_specifications: baptismSpecifications,
    marriage_declarations: marriageDeclarations,
    certificates_a: certificatesA,
    certificates_b: certificatesB
  }
  return map[name]
}

ipcMain.handle('db:list', async (_e, table: TableName) => {
  const db = getDb()
  return db.select().from(getTable(table) as typeof baptismDeclarations).orderBy()
})

ipcMain.handle('db:get', async (_e, table: TableName, id: number) => {
  const db = getDb()
  const t = getTable(table) as typeof baptismDeclarations
  const rows = await db.select().from(t).where(eq(t.id, id))
  return rows[0] ?? null
})

ipcMain.handle('db:insert', async (_e, table: TableName, data: Record<string, string>) => {
  const db = getDb()
  const t = getTable(table) as typeof baptismDeclarations
  const rows = await db.insert(t).values(data as never).returning()
  return rows[0]
})

ipcMain.handle('db:update', async (_e, table: TableName, id: number, data: Record<string, string>) => {
  const db = getDb()
  const t = getTable(table) as typeof baptismDeclarations
  const rows = await db.update(t).set({ ...data, updated_at: new Date() } as never).where(eq(t.id, id)).returning()
  return rows[0]
})

ipcMain.handle('db:delete', async (_e, table: TableName, id: number) => {
  const db = getDb()
  const t = getTable(table) as typeof baptismDeclarations
  await db.delete(t).where(eq(t.id, id))
  return { ok: true }
})

// ── PDF Export ────────────────────────────────────────────────────────────────

ipcMain.handle('pdf:export', async (_e, html: string, defaultFilename: string) => {
  if (!mainWindow) return { ok: false, error: 'No window' }
  const { filePath, canceled } = await dialog.showSaveDialog(mainWindow, {
    defaultPath: defaultFilename,
    filters: [{ name: 'PDF', extensions: ['pdf'] }]
  })
  if (canceled || !filePath) return { ok: false, canceled: true }

  const win = new BrowserWindow({ show: false })
  await win.loadURL(`data:text/html;charset=utf-8,${encodeURIComponent(html)}`)
  const pdf = await win.webContents.printToPDF({ printBackground: true, pageSize: 'A4' })
  win.close()
  await writeFile(filePath, pdf)
  return { ok: true, filePath }
})
