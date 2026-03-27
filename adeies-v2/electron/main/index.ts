import { app, BrowserWindow, ipcMain, shell, dialog } from 'electron'
import { join } from 'path'
import Store from 'electron-store'
import { initDb, testConnection, runMigrations, getDb, DbConfig } from '../db'
import {
  baptismDeclarations,
  baptismSpecifications,
  marriageDeclarations,
  certificatesA,
  certificatesB
} from '../schema'
import { eq } from 'drizzle-orm'
import { writeFile } from 'fs/promises'

const store = new Store<{ dbConfig: DbConfig }>()

let mainWindow: BrowserWindow | null = null

function createWindow(): void {
  mainWindow = new BrowserWindow({
    width: 1280,
    height: 800,
    minWidth: 1024,
    minHeight: 600,
    webPreferences: {
      preload: join(__dirname, '../preload/index.js'),
      sandbox: false,
      contextIsolation: true
    },
    title: 'Άδειες - Εκκλησιαστικό Σύστημα',
    show: false
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

  // Auto-init DB if config is saved
  const savedConfig = store.get('dbConfig')
  if (savedConfig) {
    try {
      initDb(savedConfig)
      await runMigrations()
    } catch {
      // Will show settings screen to user
    }
  }

  app.on('activate', () => {
    if (BrowserWindow.getAllWindows().length === 0) createWindow()
  })
})

app.on('window-all-closed', () => {
  if (process.platform !== 'darwin') app.quit()
})

// ── Settings / Connection ────────────────────────────────────────────────────

ipcMain.handle('db:get-config', () => store.get('dbConfig') ?? null)

ipcMain.handle('db:test', async (_e, config: DbConfig) => testConnection(config))

ipcMain.handle('db:save-config', async (_e, config: DbConfig) => {
  const result = await testConnection(config)
  if (!result.ok) return result
  store.set('dbConfig', config)
  initDb(config)
  await runMigrations()
  return { ok: true }
})

// ── Generic CRUD helpers ─────────────────────────────────────────────────────

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

// ── PDF Export ───────────────────────────────────────────────────────────────

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
