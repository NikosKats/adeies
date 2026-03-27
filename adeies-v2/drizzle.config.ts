import { defineConfig } from 'drizzle-kit'

export default defineConfig({
  schema: './electron/schema.ts',
  out: './drizzle',
  dialect: 'postgresql',
  dbCredentials: {
    url: process.env.DATABASE_URL || 'postgresql://adeies:adeies@localhost:5432/adeies'
  }
})
