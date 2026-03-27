import { contextBridge, ipcRenderer } from 'electron'

contextBridge.exposeInMainWorld('api', {
  // DB Settings
  getDbConfig: () => ipcRenderer.invoke('db:get-config'),
  testDbConnection: (config: unknown) => ipcRenderer.invoke('db:test', config),
  saveDbConfig: (config: unknown) => ipcRenderer.invoke('db:save-config', config),

  // Auth
  userSession: () => ipcRenderer.invoke('user:session'),
  userLogin: (username: string, password: string) => ipcRenderer.invoke('user:login', username, password),
  userLogout: () => ipcRenderer.invoke('user:logout'),

  // User management
  userList: () => ipcRenderer.invoke('user:list'),
  userCreate: (data: unknown) => ipcRenderer.invoke('user:create', data),
  userUpdate: (id: number, data: unknown) => ipcRenderer.invoke('user:update', id, data),
  userChangePassword: (id: number, password: string) => ipcRenderer.invoke('user:change-password', id, password),
  userDelete: (id: number) => ipcRenderer.invoke('user:delete', id),

  // Stats
  getStats: () => ipcRenderer.invoke('db:stats'),

  // CRUD
  list: (table: string) => ipcRenderer.invoke('db:list', table),
  get: (table: string, id: number) => ipcRenderer.invoke('db:get', table, id),
  insert: (table: string, data: unknown) => ipcRenderer.invoke('db:insert', table, data),
  update: (table: string, id: number, data: unknown) => ipcRenderer.invoke('db:update', table, id, data),
  remove: (table: string, id: number) => ipcRenderer.invoke('db:delete', table, id),

  // PDF
  exportPdf: (html: string, filename: string) => ipcRenderer.invoke('pdf:export', html, filename)
})
