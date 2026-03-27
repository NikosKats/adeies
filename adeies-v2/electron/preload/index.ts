import { contextBridge, ipcRenderer } from 'electron'

contextBridge.exposeInMainWorld('api', {
  // Settings
  getDbConfig: () => ipcRenderer.invoke('db:get-config'),
  testDbConnection: (config: unknown) => ipcRenderer.invoke('db:test', config),
  saveDbConfig: (config: unknown) => ipcRenderer.invoke('db:save-config', config),

  // CRUD
  list: (table: string) => ipcRenderer.invoke('db:list', table),
  get: (table: string, id: number) => ipcRenderer.invoke('db:get', table, id),
  insert: (table: string, data: unknown) => ipcRenderer.invoke('db:insert', table, data),
  update: (table: string, id: number, data: unknown) => ipcRenderer.invoke('db:update', table, id, data),
  remove: (table: string, id: number) => ipcRenderer.invoke('db:delete', table, id),

  // PDF
  exportPdf: (html: string, filename: string) => ipcRenderer.invoke('pdf:export', html, filename)
})
