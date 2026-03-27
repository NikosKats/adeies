# Adeies — Αυτόματη Ρύθμιση Βάσης Δεδομένων (Windows)
# Εκτελέστε ως Διαχειριστής (Run as Administrator)

$ErrorActionPreference = "Stop"

Write-Host ""
Write-Host "======================================" -ForegroundColor Cyan
Write-Host "  Adeies — Ρύθμιση Βάσης Δεδομένων" -ForegroundColor Cyan
Write-Host "======================================" -ForegroundColor Cyan
Write-Host ""

# ── 1. Check / Install PostgreSQL ───────────────────────────────────────────
$pgPath = "C:\Program Files\PostgreSQL\16\bin"
$pgAvailable = Test-Path "$pgPath\psql.exe"

if (-not $pgAvailable) {
    Write-Host "► PostgreSQL δεν βρέθηκε. Εγκατάσταση μέσω winget..." -ForegroundColor Yellow

    # Try winget first (Windows 10/11)
    try {
        winget install --id PostgreSQL.PostgreSQL.16 --silent --accept-source-agreements --accept-package-agreements
        Write-Host "  Αναμονή για ολοκλήρωση εγκατάστασης..." -ForegroundColor Gray
        Start-Sleep -Seconds 30
    } catch {
        Write-Host ""
        Write-Host "  Αποτυχία αυτόματης εγκατάστασης." -ForegroundColor Red
        Write-Host "  Κατεβάστε χειροκίνητα από: https://www.postgresql.org/download/windows/" -ForegroundColor Yellow
        Write-Host "  Μετά την εγκατάσταση εκτελέστε ξανά αυτό το script." -ForegroundColor Yellow
        Read-Host "Πατήστε Enter για έξοδο"
        exit 1
    }

    $pgAvailable = Test-Path "$pgPath\psql.exe"
    if (-not $pgAvailable) {
        Write-Host "  PostgreSQL δεν βρέθηκε μετά την εγκατάσταση. Δοκιμάστε χειροκίνητα." -ForegroundColor Red
        Read-Host "Πατήστε Enter για έξοδο"
        exit 1
    }
}

Write-Host "✓ PostgreSQL βρέθηκε στο: $pgPath" -ForegroundColor Green

# ── 2. Add psql to PATH for this session ────────────────────────────────────
$env:Path = "$pgPath;$env:Path"

# ── 3. Get postgres superuser password ──────────────────────────────────────
Write-Host ""
$pgPassword = Read-Host "Εισάγετε τον κωδικό του postgres superuser (που ορίσατε κατά την εγκατάσταση)" -AsSecureString
$pgPasswordPlain = [Runtime.InteropServices.Marshal]::PtrToStringAuto(
    [Runtime.InteropServices.Marshal]::SecureStringToBSTR($pgPassword))

$env:PGPASSWORD = $pgPasswordPlain

# ── 4. Create user and database ─────────────────────────────────────────────
Write-Host ""
Write-Host "► Δημιουργία χρήστη 'adeies'..." -ForegroundColor Yellow

try {
    & "$pgPath\psql.exe" -U postgres -c "CREATE USER adeies WITH PASSWORD 'adeies';" 2>$null
    Write-Host "  ✓ Χρήστης δημιουργήθηκε." -ForegroundColor Green
} catch {
    Write-Host "  (Ο χρήστης υπάρχει ήδη — συνέχεια)" -ForegroundColor Gray
}

try {
    & "$pgPath\psql.exe" -U postgres -c "CREATE DATABASE adeies OWNER adeies;" 2>$null
    Write-Host "  ✓ Βάση δεδομένων δημιουργήθηκε." -ForegroundColor Green
} catch {
    Write-Host "  (Η βάση υπάρχει ήδη — συνέχεια)" -ForegroundColor Gray
}

& "$pgPath\psql.exe" -U postgres -c "GRANT ALL PRIVILEGES ON DATABASE adeies TO adeies;" 2>$null

# ── 5. Ensure PostgreSQL starts automatically ────────────────────────────────
Write-Host ""
Write-Host "► Ρύθμιση αυτόματης εκκίνησης PostgreSQL..." -ForegroundColor Yellow
try {
    Set-Service -Name "postgresql-x64-16" -StartupType Automatic
    Start-Service -Name "postgresql-x64-16" -ErrorAction SilentlyContinue
    Write-Host "  ✓ Η PostgreSQL θα ξεκινά αυτόματα με τον υπολογιστή." -ForegroundColor Green
} catch {
    Write-Host "  (Παρακαλώ βεβαιωθείτε ότι η υπηρεσία PostgreSQL εκτελείται)" -ForegroundColor Yellow
}

# ── Done ─────────────────────────────────────────────────────────────────────
$env:PGPASSWORD = ""
Write-Host ""
Write-Host "======================================" -ForegroundColor Green
Write-Host "  Η ρύθμιση ολοκληρώθηκε επιτυχώς!" -ForegroundColor Green
Write-Host "======================================" -ForegroundColor Green
Write-Host ""
Write-Host "Στοιχεία σύνδεσης για το Adeies:" -ForegroundColor Cyan
Write-Host "  Host:     localhost" -ForegroundColor White
Write-Host "  Port:     5432" -ForegroundColor White
Write-Host "  Database: adeies" -ForegroundColor White
Write-Host "  Username: adeies" -ForegroundColor White
Write-Host "  Password: adeies" -ForegroundColor White
Write-Host ""
Write-Host "Ξεκινήστε το Adeies και χρησιμοποιήστε τα παραπάνω στοιχεία." -ForegroundColor Yellow
Write-Host ""
Read-Host "Πατήστε Enter για έξοδο"
