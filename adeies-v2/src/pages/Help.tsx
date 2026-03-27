import { Monitor, Database, Users, FileText, Download, Settings, ChevronRight, Terminal, Package, Wrench } from 'lucide-react'

function Section({ icon: Icon, title, children, accent = 'blue' }: { icon: React.ElementType; title: string; children: React.ReactNode; accent?: string }) {
  const colors: Record<string, string> = {
    blue: 'bg-blue-100 text-blue-700',
    green: 'bg-green-100 text-green-700',
    purple: 'bg-purple-100 text-purple-700',
    amber: 'bg-amber-100 text-amber-700',
    rose: 'bg-rose-100 text-rose-700',
  }
  return (
    <div className="card mb-4">
      <div className="flex items-center gap-3 mb-4">
        <div className={`w-9 h-9 rounded-xl flex items-center justify-center flex-shrink-0 ${colors[accent]}`}>
          <Icon size={18} />
        </div>
        <h3 className="text-base font-bold text-gray-900">{title}</h3>
      </div>
      <div className="text-sm text-gray-700 space-y-2 leading-relaxed">{children}</div>
    </div>
  )
}

function Step({ n, children }: { n: number; children: React.ReactNode }) {
  return (
    <div className="flex gap-3 items-start py-1.5">
      <span className="w-6 h-6 bg-blue-600 text-white text-xs font-bold rounded-full flex items-center justify-center flex-shrink-0 mt-0.5">{n}</span>
      <div className="flex-1">{children}</div>
    </div>
  )
}

function Code({ children }: { children: React.ReactNode }) {
  return <code className="bg-gray-100 text-blue-800 px-1.5 py-0.5 rounded text-xs font-mono">{children}</code>
}

function Block({ children }: { children: string }) {
  return (
    <pre className="bg-gray-900 text-green-400 text-xs rounded-xl p-4 overflow-x-auto font-mono leading-relaxed my-2 whitespace-pre-wrap">
      {children}
    </pre>
  )
}

function Note({ type = 'info', children }: { type?: 'info' | 'warn' | 'success' | 'danger'; children: React.ReactNode }) {
  const styles = {
    info: 'bg-blue-50 text-blue-800 border-blue-200',
    warn: 'bg-amber-50 text-amber-800 border-amber-200',
    success: 'bg-green-50 text-green-800 border-green-200',
    danger: 'bg-red-50 text-red-800 border-red-200',
  }
  return <div className={`rounded-lg px-4 py-3 border text-sm mt-2 ${styles[type]}`}>{children}</div>
}

export default function Help() {
  return (
    <div className="max-w-3xl pb-8">
      <h2 className="page-title">Βοήθεια & Οδηγίες</h2>

      {/* ── PRODUCTION INSTALL (most important) ─────────────────────────── */}
      <Section icon={Package} title="Εγκατάσταση Production — Τελικός Χρήστης (Συνιστάται)" accent="green">
        <Note type="success">
          <strong>Αυτός είναι ο ευκολότερος τρόπος.</strong> Κατεβάστε τον έτοιμο installer και το script ρύθμισης.
        </Note>

        <p className="font-semibold text-gray-800 mt-4 mb-2">Windows (.exe installer)</p>
        <Step n={1}>
          Κατεβάστε και εκτελέστε το <Code>setup-db-windows.ps1</Code> ως <strong>Διαχειριστής</strong>:
          <ul className="mt-1 ml-4 list-disc text-gray-600 space-y-1">
            <li>Δεξί κλικ στο αρχείο → "Εκτέλεση με PowerShell ως Διαχειριστής"</li>
            <li>Εγκαθιστά αυτόματα την PostgreSQL (αν δεν υπάρχει) και δημιουργεί τη βάση</li>
          </ul>
        </Step>
        <Step n={2}>Εκτελέστε το <Code>Adeies-Setup.exe</Code> — επόμενο, επόμενο, τέλος.</Step>
        <Step n={3}>Ανοίξτε το Adeies από το Desktop. Στις Ρυθμίσεις, πατήστε <strong>Δοκιμή Σύνδεσης</strong> και <strong>Αποθήκευση</strong>.</Step>
        <Step n={4}>Συνδεθείτε: <Code>admin</Code> / <Code>admin123</Code> — αλλάξτε τον κωδικό αμέσως!</Step>

        <p className="font-semibold text-gray-800 mt-5 mb-2">macOS (.dmg)</p>
        <Step n={1}>
          Εκτελέστε το setup script σε Terminal:
          <Block>{'bash setup-db-mac.sh'}</Block>
        </Step>
        <Step n={2}>Ανοίξτε το <Code>Adeies.dmg</Code> και σύρτε την εφαρμογή στο Applications.</Step>
        <Step n={3}>Ανοίξτε το Adeies, συνδεθείτε με <Code>admin</Code> / <Code>admin123</Code>.</Step>
        <Note type="warn">
          <strong>macOS:</strong> Αν εμφανιστεί "δεν μπορεί να ανοιχτεί", πηγαίνετε Ρυθμίσεις Συστήματος → Απόρρητο & Ασφάλεια → "Άνοιγμα Ούτως ή Άλλως".
        </Note>
      </Section>

      {/* ── BUILD FROM SOURCE ────────────────────────────────────────────── */}
      <Section icon={Wrench} title="Δημιουργία Installer από Πηγαίο Κώδικα (Για Προγραμματιστές)" accent="purple">
        <Note type="info">
          Χρειάζεστε: Node.js 20+, Git, και ενεργή σύνδεση internet.
        </Note>
        <Step n={1}>
          Κλωνοποιήστε και εγκαταστήστε:
          <Block>{'git clone https://github.com/NikosKats/adeies.git\ncd adeies/adeies-v2\ngit checkout claude/create-new-branch-S5Mo6\nnpm install'}</Block>
        </Step>
        <Step n={2}>
          Δημιουργία installer για το τρέχον λειτουργικό:
          <Block>{'# Windows (.exe)\nnpm run dist:win\n\n# macOS (.dmg)\nnpm run dist:mac\n\n# Linux (.AppImage)\nnpm run dist:linux'}</Block>
          Τα αρχεία δημιουργούνται στο φάκελο <Code>dist-installer/</Code>.
        </Step>
        <Note type="success">
          Το <Code>npm run dist:win</Code> δημιουργεί αυτόματα το εικονίδιο, κάνει build και πακετάρει τον installer.
        </Note>
      </Section>

      {/* ── WINDOWS DEV SETUP ────────────────────────────────────────────── */}
      <Section icon={Monitor} title="Εγκατάσταση σε Windows (Development)" accent="blue">
        <Step n={1}>Εκτελέστε το <Code>scripts/setup-db-windows.ps1</Code> ως Διαχειριστής.</Step>
        <Step n={2}>Εγκαταστήστε Node.js LTS από <strong>nodejs.org</strong> και Git από <strong>git-scm.com</strong>.</Step>
        <Step n={3}>
          <Block>{'git clone https://github.com/NikosKats/adeies.git\ncd adeies\\adeies-v2\ngit checkout claude/create-new-branch-S5Mo6\nnpm install\nnpm run dev'}</Block>
        </Step>
      </Section>

      {/* ── MAC DEV SETUP ───────────────────────────────────────────────── */}
      <Section icon={Monitor} title="Εγκατάσταση σε macOS (Development)" accent="blue">
        <Step n={1}>
          <Block>{'bash scripts/setup-db-mac.sh'}</Block>
        </Step>
        <Step n={2}>
          <Block>{'git clone https://github.com/NikosKats/adeies.git\ncd adeies/adeies-v2\ngit checkout claude/create-new-branch-S5Mo6\nnpm install\nnpm run dev'}</Block>
        </Step>
      </Section>

      {/* ── DB SETTINGS ─────────────────────────────────────────────────── */}
      <Section icon={Database} title="Ρυθμίσεις Βάσης Δεδομένων" accent="amber">
        <p>Τα προεπιλεγμένα στοιχεία σύνδεσης (μετά το setup script):</p>
        <div className="mt-2 bg-gray-900 text-green-400 rounded-xl p-4 font-mono text-xs space-y-1">
          <div><span className="text-gray-500">Host:     </span>localhost</div>
          <div><span className="text-gray-500">Port:     </span>5432</div>
          <div><span className="text-gray-500">Database: </span>adeies</div>
          <div><span className="text-gray-500">Username: </span>adeies</div>
          <div><span className="text-gray-500">Password: </span>adeies</div>
        </div>
        <Note type="warn">
          <strong>Πολλαπλοί χρήστες (LAN):</strong> Εγκαταστήστε PostgreSQL σε <em>ένα μόνο</em> PC (server).
          Στους υπόλοιπους υπολογιστές βάλτε την <strong>IP του server</strong> αντί για <Code>localhost</Code>.
          Παράδειγμα: <Code>192.168.1.10</Code>
        </Note>
      </Section>

      {/* ── USER MANAGEMENT ─────────────────────────────────────────────── */}
      <Section icon={Users} title="Διαχείριση Χρηστών" accent="purple">
        <p>Δύο ρόλοι χρηστών:</p>
        <ul className="mt-2 space-y-1 ml-2">
          <li><ChevronRight size={12} className="inline mr-1 text-purple-500" /><strong>Διαχειριστής:</strong> Πλήρης πρόσβαση + δημιουργία/διαγραφή χρηστών</li>
          <li><ChevronRight size={12} className="inline mr-1 text-blue-500" /><strong>Χρήστης:</strong> Καταχώρηση εγγραφών, επεξεργασία, εξαγωγή PDF</li>
        </ul>
        <Note type="danger">
          <strong>Αλλάξτε τον κωδικό admin αμέσως μετά την πρώτη σύνδεση!</strong>
          Μεταβείτε: Χρήστες → <KeyRound size={12} className="inline" /> (εικονίδιο κλειδιού) → Νέος κωδικός.
        </Note>
        <p className="mt-3 font-semibold">Δημιουργία νέου χρήστη:</p>
        <Step n={1}>Κεφαλίδα → Χρήστες (εμφανίζεται μόνο σε admin)</Step>
        <Step n={2}>Κλικ "Νέος Χρήστης"</Step>
        <Step n={3}>Συμπληρώστε: Ονοματεπώνυμο, username, κωδικό, ρόλο</Step>
      </Section>

      {/* ── HOW TO USE ──────────────────────────────────────────────────── */}
      <Section icon={FileText} title="Χρήση της Εφαρμογής" accent="blue">
        <p className="font-semibold text-gray-800 mb-2">Καταχώρηση νέας εγγραφής:</p>
        <Step n={1}>Επιλέξτε κατηγορία από το μενού (π.χ. Δήλωση Βαπτίσεως)</Step>
        <Step n={2}>Κλικ <strong>+ Νέα Εγγραφή</strong></Step>
        <Step n={3}>Συμπληρώστε τα πεδία και πατήστε <strong>Έκδοση Πιστοποιητικού</strong></Step>

        <p className="font-semibold text-gray-800 mt-4 mb-2">Εξαγωγή PDF:</p>
        <Step n={1}>Κλικ πάνω σε μια εγγραφή για προβολή</Step>
        <Step n={2}>Κλικ <strong>📄 PDF</strong> πάνω δεξιά</Step>
        <Step n={3}>Επιλέξτε φάκελο αποθήκευσης</Step>
      </Section>

      {/* ── SQLITE MIGRATION ────────────────────────────────────────────── */}
      <Section icon={Download} title="Μετάπτωση από Παλαιά Εφαρμογή (SQLite)" accent="amber">
        <p>Αν έχετε αρχείο <Code>adeies.db</Code> από την παλιά εφαρμογή Java:</p>
        <Block>{'# Mac / Linux\nSQLITE_PATH=/path/to/adeies.db \\\nDATABASE_URL=postgresql://adeies:adeies@localhost:5432/adeies \\\nnpm run migrate:sqlite\n\n# Windows PowerShell\n$env:SQLITE_PATH="C:\\path\\to\\adeies.db"\n$env:DATABASE_URL="postgresql://adeies:adeies@localhost:5432/adeies"\nnpm run migrate:sqlite'}</Block>
        <Note type="success">Μεταφέρει αυτόματα όλα τα δεδομένα (βαπτίσεις, γάμοι, πιστοποιητικά) στη νέα PostgreSQL.</Note>
      </Section>

      {/* ── TECH INFO ───────────────────────────────────────────────────── */}
      <Section icon={Settings} title="Τεχνικές Πληροφορίες" accent="blue">
        <div className="grid grid-cols-2 gap-2 text-xs">
          {[
            ['Framework', 'Electron 28 + React 18'],
            ['Γλώσσα', 'TypeScript'],
            ['Βάση Δεδομένων', 'PostgreSQL 16'],
            ['UI', 'Tailwind CSS + lucide-react'],
            ['Φόρμες', 'React Hook Form + Zod'],
            ['PDF', 'Electron printToPDF'],
            ['Auth', 'bcryptjs + electron-store'],
            ['Installer', 'electron-builder (NSIS/DMG)'],
          ].map(([k, v]) => (
            <div key={k} className="bg-gray-50 rounded-lg p-2.5">
              <div className="text-gray-400 text-xs">{k}</div>
              <div className="font-semibold text-gray-800">{v}</div>
            </div>
          ))}
        </div>
      </Section>

      <div className="flex items-center gap-2 text-xs text-gray-400 justify-center">
        <Terminal size={12} />
        <span>Adeies v2.0 — Εκκλησιαστικό Σύστημα Διαχείρισης</span>
      </div>
    </div>
  )
}

function KeyRound({ size, className }: { size: number; className?: string }) {
  return <span className={className} style={{ fontSize: size }}> 🔑</span>
}
