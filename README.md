# adeies
Βοήθεια & Οδηγίες

Εγκατάσταση Production — Τελικός Χρήστης (Συνιστάται)
Αυτός είναι ο ευκολότερος τρόπος. Κατεβάστε τον έτοιμο installer και το script ρύθμισης.
Windows (.exe installer)
1
Κατεβάστε και εκτελέστε το setup-db-windows.ps1 ως Διαχειριστής:
Δεξί κλικ στο αρχείο → "Εκτέλεση με PowerShell ως Διαχειριστής"
Εγκαθιστά αυτόματα την PostgreSQL (αν δεν υπάρχει) και δημιουργεί τη βάση
2
Εκτελέστε το Adeies-Setup.exe — επόμενο, επόμενο, τέλος.
3
Ανοίξτε το Adeies από το Desktop. Στις Ρυθμίσεις, πατήστε Δοκιμή Σύνδεσης και Αποθήκευση.
4
Συνδεθείτε: admin / admin123 — αλλάξτε τον κωδικό αμέσως!
macOS (.dmg)
1
Εκτελέστε το setup script σε Terminal:
bash setup-db-mac.sh
2
Ανοίξτε το Adeies.dmg και σύρτε την εφαρμογή στο Applications.
3
Ανοίξτε το Adeies, συνδεθείτε με admin / admin123.
macOS: Αν εμφανιστεί "δεν μπορεί να ανοιχτεί", πηγαίνετε Ρυθμίσεις Συστήματος → Απόρρητο & Ασφάλεια → "Άνοιγμα Ούτως ή Άλλως".

Δημιουργία Installer από Πηγαίο Κώδικα (Για Προγραμματιστές)
Χρειάζεστε: Node.js 20+, Git, και ενεργή σύνδεση internet.
1
Κλωνοποιήστε και εγκαταστήστε:
git clone https://github.com/NikosKats/adeies.git
cd adeies/adeies-v2
git checkout claude/create-new-branch-S5Mo6
npm install
2
Δημιουργία installer για το τρέχον λειτουργικό:
# Windows (.exe)
npm run dist:win

# macOS (.dmg)
npm run dist:mac

# Linux (.AppImage)
npm run dist:linux
Τα αρχεία δημιουργούνται στο φάκελο dist-installer/.
Το npm run dist:win δημιουργεί αυτόματα το εικονίδιο, κάνει build και πακετάρει τον installer.

Εγκατάσταση σε Windows (Development)
1
Εκτελέστε το scripts/setup-db-windows.ps1 ως Διαχειριστής.
2
Εγκαταστήστε Node.js LTS από nodejs.org και Git από git-scm.com.
3
git clone https://github.com/NikosKats/adeies.git
cd adeies\adeies-v2
git checkout claude/create-new-branch-S5Mo6
npm install
npm run dev

Εγκατάσταση σε macOS (Development)
1
bash scripts/setup-db-mac.sh
2
git clone https://github.com/NikosKats/adeies.git
cd adeies/adeies-v2
git checkout claude/create-new-branch-S5Mo6
npm install
npm run dev

Ρυθμίσεις Βάσης Δεδομένων
Τα προεπιλεγμένα στοιχεία σύνδεσης (μετά το setup script):
Host: localhost
Port: 5432
Database: adeies
Username: adeies
Password: adeies
Πολλαπλοί χρήστες (LAN): Εγκαταστήστε PostgreSQL σε ένα μόνο PC (server). Στους υπόλοιπους υπολογιστές βάλτε την IP του server αντί για localhost. Παράδειγμα: 192.168.1.10

Διαχείριση Χρηστών
Δύο ρόλοι χρηστών:
Διαχειριστής: Πλήρης πρόσβαση + δημιουργία/διαγραφή χρηστών
Χρήστης: Καταχώρηση εγγραφών, επεξεργασία, εξαγωγή PDF
Αλλάξτε τον κωδικό admin αμέσως μετά την πρώτη σύνδεση!Μεταβείτε: Χρήστες → 🔑 (εικονίδιο κλειδιού) → Νέος κωδικός.
Δημιουργία νέου χρήστη:
1
Κεφαλίδα → Χρήστες (εμφανίζεται μόνο σε admin)
2
Κλικ "Νέος Χρήστης"
3
Συμπληρώστε: Ονοματεπώνυμο, username, κωδικό, ρόλο

Χρήση της Εφαρμογής
Καταχώρηση νέας εγγραφής:
1
Επιλέξτε κατηγορία από το μενού (π.χ. Δήλωση Βαπτίσεως)
2
Κλικ + Νέα Εγγραφή
3
Συμπληρώστε τα πεδία και πατήστε Έκδοση Πιστοποιητικού
Εξαγωγή PDF:
1
Κλικ πάνω σε μια εγγραφή για προβολή
2
Κλικ 📄 PDF πάνω δεξιά
3
Επιλέξτε φάκελο αποθήκευσης

Μετάπτωση από Παλαιά Εφαρμογή (SQLite)
Αν έχετε αρχείο adeies.db από την παλιά εφαρμογή Java:
# Mac / Linux
SQLITE_PATH=/path/to/adeies.db \
DATABASE_URL=postgresql://adeies:adeies@localhost:5432/adeies \
npm run migrate:sqlite

# Windows PowerShell
$env:SQLITE_PATH="C:\path\to\adeies.db"
$env:DATABASE_URL="postgresql://adeies:adeies@localhost:5432/adeies"
npm run migrate:sqlite
Μεταφέρει αυτόματα όλα τα δεδομένα (βαπτίσεις, γάμοι, πιστοποιητικά) στη νέα PostgreSQL.

Τεχνικές Πληροφορίες
Framework
Electron 28 + React 18
Γλώσσα
TypeScript
Βάση Δεδομένων
PostgreSQL 16
UI
Tailwind CSS + lucide-react
Φόρμες
React Hook Form + Zod
PDF
Electron printToPDF
Auth
bcryptjs + electron-store
Installer
electron-builder (NSIS/DMG)

Adeies v2.0 — Εκκλησιαστικό Σύστημα Διαχείρισης
