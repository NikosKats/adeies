# Adeies v2 — Setup Guide

Church Records Management System (Electron + React + PostgreSQL)

---

## Prerequisites

| Tool | Version | Notes |
|------|---------|-------|
| Node.js | 20+ | https://nodejs.org |
| npm | 9+ | Included with Node.js |
| PostgreSQL | 16+ | One install per office LAN server |

---

## macOS

### 1. Install PostgreSQL

```bash
brew install postgresql@16
brew services start postgresql@16
```

If you don't have Homebrew: https://brew.sh

### 2. Create the database

```bash
psql postgres -c "CREATE USER adeies WITH PASSWORD 'adeies';"
psql postgres -c "CREATE DATABASE adeies OWNER adeies;"
```

### 3. Get the code

```bash
git clone https://github.com/NikosKats/adeies.git
cd adeies/adeies-v2
git checkout claude/create-new-branch-S5Mo6
npm install
```

### 4. Run

```bash
npm run dev
```

---

## Windows

### 1. Install PostgreSQL

1. Download the installer from https://www.postgresql.org/download/windows/
2. Run the installer — use these settings:
   - Port: `5432`
   - Username: `postgres`
   - Password: choose anything (this is the admin password)
3. PostgreSQL will run automatically as a Windows Service on every startup.

### 2. Create the database

Open **pgAdmin** (installed with PostgreSQL) or open **SQL Shell (psql)** from the Start Menu and run:

```sql
CREATE USER adeies WITH PASSWORD 'adeies';
CREATE DATABASE adeies OWNER adeies;
```

### 3. Install Node.js

Download and install from https://nodejs.org (LTS version).

### 4. Get the code

Open **Command Prompt** or **PowerShell**:

```cmd
git clone https://github.com/NikosKats/adeies.git
cd adeies\adeies-v2
git checkout claude/create-new-branch-S5Mo6
npm install
```

If you don't have Git, download it from https://git-scm.com

### 5. Run

```cmd
npm run dev
```

---

## Linux (Ubuntu / Debian)

### 1. Install PostgreSQL and Node.js

```bash
sudo apt update
sudo apt install -y postgresql-16 nodejs npm
sudo systemctl enable postgresql
sudo systemctl start postgresql
```

For other distros, see:
- PostgreSQL: https://www.postgresql.org/download/linux/
- Node.js: https://nodejs.org/en/download/package-manager

### 2. Create the database

```bash
sudo -u postgres psql -c "CREATE USER adeies WITH PASSWORD 'adeies';"
sudo -u postgres psql -c "CREATE DATABASE adeies OWNER adeies;"
```

### 3. Get the code

```bash
git clone https://github.com/NikosKats/adeies.git
cd adeies/adeies-v2
git checkout claude/create-new-branch-S5Mo6
npm install
```

### 4. Run

```bash
npm run dev
```

> **Note:** If running as root (e.g. in a container), add the `--no-sandbox` flag:
> ```bash
> npx electron-vite dev -- --no-sandbox
> ```

---

## First Launch

On first launch you will see the **Settings screen**. Enter your database connection details:

| Field | Default value |
|-------|---------------|
| Host | `localhost` (or the server PC's IP on LAN) |
| Port | `5432` |
| Database | `adeies` |
| Username | `adeies` |
| Password | `adeies` |

Click **Test Connection** to verify, then **Save**. The app will create all tables automatically and redirect to the home screen.

---

## Multi-user / LAN Setup

If multiple computers share the same data:

1. Install PostgreSQL on **one PC only** (the server).
2. Allow remote connections — in `pg_hba.conf` add:
   ```
   host    adeies    adeies    192.168.1.0/24    md5
   ```
3. In `postgresql.conf` set:
   ```
   listen_addresses = '*'
   ```
4. Restart PostgreSQL.
5. On every other PC: install Node.js, clone the repo, run `npm install`.
6. On first launch, enter the **server PC's local IP** (e.g. `192.168.1.10`) as the Host.

---

## Migrating Data from the Old App

If you have an existing `adeies.db` SQLite file from the old Java application:

```bash
SQLITE_PATH=/path/to/adeies.db \
DATABASE_URL=postgresql://adeies:adeies@localhost:5432/adeies \
npm run migrate:sqlite
```

On Windows (PowerShell):

```powershell
$env:SQLITE_PATH="C:\path\to\adeies.db"
$env:DATABASE_URL="postgresql://adeies:adeies@localhost:5432/adeies"
npm run migrate:sqlite
```

---

## Build a Standalone Installer

### Windows (.exe)

```cmd
npm run dist
```

The installer will be created at `dist-installer\Adeies Setup x.x.x.exe`.

### macOS (.dmg)

```bash
npm run dist
```

The `.dmg` will be created at `dist-installer/Adeies-x.x.x.dmg`.

---

## Troubleshooting

**"Cannot connect to database"**
- Make sure PostgreSQL is running: `brew services list` (Mac) or `services.msc` (Windows)
- Check the host/port/credentials in Settings

**App opens but shows blank screen**
- Run `npm run dev` again and check the terminal for errors

**"ENOENT: no such file or directory, electron"**
- Run `npm install` first

**Port 5432 already in use**
- Another PostgreSQL instance may be running. Check with `lsof -i :5432` (Mac/Linux) or Task Manager (Windows)
