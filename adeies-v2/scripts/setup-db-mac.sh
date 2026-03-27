#!/bin/bash
# Adeies — Αυτόματη Ρύθμιση Βάσης Δεδομένων (macOS)

set -e

echo ""
echo "======================================"
echo "  Adeies — Ρύθμιση Βάσης Δεδομένων"
echo "======================================"
echo ""

# ── 1. Install Homebrew if missing ──────────────────────────────────────────
if ! command -v brew &>/dev/null; then
  echo "► Homebrew δεν βρέθηκε. Εγκατάσταση..."
  /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
  # Add to PATH for Apple Silicon
  eval "$(/opt/homebrew/bin/brew shellenv)" 2>/dev/null || true
fi
echo "✓ Homebrew: $(brew --version | head -1)"

# ── 2. Install PostgreSQL 16 if missing ─────────────────────────────────────
if ! brew list postgresql@16 &>/dev/null; then
  echo ""
  echo "► Εγκατάσταση PostgreSQL 16..."
  brew install postgresql@16
fi
echo "✓ PostgreSQL 16 εγκατεστημένο"

# ── 3. Start PostgreSQL ─────────────────────────────────────────────────────
echo ""
echo "► Εκκίνηση PostgreSQL..."
brew services start postgresql@16
sleep 3

# Add pg binaries to PATH
export PATH="/opt/homebrew/opt/postgresql@16/bin:/usr/local/opt/postgresql@16/bin:$PATH"

# ── 4. Create user and database ─────────────────────────────────────────────
echo ""
echo "► Δημιουργία χρήστη 'adeies'..."
psql postgres -c "CREATE USER adeies WITH PASSWORD 'adeies';" 2>/dev/null || echo "  (Ο χρήστης υπάρχει ήδη)"

echo "► Δημιουργία βάσης δεδομένων 'adeies'..."
psql postgres -c "CREATE DATABASE adeies OWNER adeies;" 2>/dev/null || echo "  (Η βάση υπάρχει ήδη)"
psql postgres -c "GRANT ALL PRIVILEGES ON DATABASE adeies TO adeies;" 2>/dev/null || true

# ── Done ─────────────────────────────────────────────────────────────────────
echo ""
echo "======================================"
echo "  Η ρύθμιση ολοκληρώθηκε! ✓"
echo "======================================"
echo ""
echo "Στοιχεία σύνδεσης για το Adeies:"
echo "  Host:     localhost"
echo "  Port:     5432"
echo "  Database: adeies"
echo "  Username: adeies"
echo "  Password: adeies"
echo ""
echo "Ξεκινήστε το Adeies και χρησιμοποιήστε τα παραπάνω στοιχεία."
echo ""
