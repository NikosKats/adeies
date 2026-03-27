import { Monitor, Database, Users, FileText, Download, Settings, ChevronRight, Terminal } from 'lucide-react'

function Section({ icon: Icon, title, children }: { icon: React.ElementType; title: string; children: React.ReactNode }) {
  return (
    <div className="card mb-4">
      <div className="flex items-center gap-3 mb-4">
        <div className="w-9 h-9 bg-blue-100 text-blue-700 rounded-xl flex items-center justify-center flex-shrink-0">
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
    <pre className="bg-gray-900 text-green-400 text-xs rounded-xl p-4 overflow-x-auto font-mono leading-relaxed my-2">
      {children}
    </pre>
  )
}

export default function Help() {
  return (
    <div className="max-w-3xl">
      <div className="flex items-center gap-3 mb-6">
        <h2 className="page-title mb-0">Βοήθεια & Οδηγίες</h2>
      </div>

      <Section icon={Monitor} title="Εγκατάσταση σε Mac">
        <Step n={1}>
          Εγκαταστήστε το <strong>Homebrew</strong> (αν δεν το έχετε):
          <Block>{'/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"'}</Block>
        </Step>
        <Step n={2}>
          Εγκαταστήστε το <strong>PostgreSQL 16</strong> και το <strong>Node.js</strong>:
          <Block>{'brew install postgresql@16 node\nbrew services start postgresql@16'}</Block>
        </Step>
        <Step n={3}>
          Δημιουργήστε τη βάση δεδομένων:
          <Block>{'psql postgres -c "CREATE USER adeies WITH PASSWORD \'adeies\';"\npsql postgres -c "CREATE DATABASE adeies OWNER adeies;"'}</Block>
        </Step>
        <Step n={4}>
          Κατεβάστε και εκκινήστε την εφαρμογή:
          <Block>{'git clone https://github.com/NikosKats/adeies.git\ncd adeies/adeies-v2\ngit checkout claude/create-new-branch-S5Mo6\nnpm install\nnpm run dev'}</Block>
        </Step>
      </Section>

      <Section icon={Monitor} title="Εγκατάσταση σε Windows">
        <Step n={1}>Κατεβάστε και εγκαταστήστε το <strong>PostgreSQL 16</strong> από το <strong>postgresql.org/download/windows</strong>. Στην εγκατάσταση χρησιμοποιήστε port <Code>5432</Code>.</Step>
        <Step n={2}>Κατεβάστε και εγκαταστήστε το <strong>Node.js LTS</strong> από το <strong>nodejs.org</strong>.</Step>
        <Step n={3}>
          Ανοίξτε το <strong>pgAdmin</strong> ή το SQL Shell και εκτελέστε:
          <Block>{'CREATE USER adeies WITH PASSWORD \'adeies\';\nCREATE DATABASE adeies OWNER adeies;'}</Block>
        </Step>
        <Step n={4}>
          Ανοίξτε το <strong>Command Prompt</strong> ή PowerShell:
          <Block>{'git clone https://github.com/NikosKats/adeies.git\ncd adeies\\adeies-v2\ngit checkout claude/create-new-branch-S5Mo6\nnpm install\nnpm run dev'}</Block>
        </Step>
      </Section>

      <Section icon={Database} title="Ρυθμίσεις Βάσης Δεδομένων">
        <p>Στην πρώτη εκκίνηση εμφανίζεται η οθόνη ρυθμίσεων. Συμπληρώστε:</p>
        <div className="mt-2 space-y-1 bg-gray-50 rounded-xl p-4 font-mono text-xs">
          <div><span className="text-gray-500 w-32 inline-block">Host:</span> <span className="font-semibold">localhost</span></div>
          <div><span className="text-gray-500 w-32 inline-block">Port:</span> <span className="font-semibold">5432</span></div>
          <div><span className="text-gray-500 w-32 inline-block">Database:</span> <span className="font-semibold">adeies</span></div>
          <div><span className="text-gray-500 w-32 inline-block">Username:</span> <span className="font-semibold">adeies</span></div>
          <div><span className="text-gray-500 w-32 inline-block">Password:</span> <span className="font-semibold">adeies</span></div>
        </div>
        <p className="mt-3">Πατήστε <strong>Δοκιμή Σύνδεσης</strong> για επαλήθευση, μετά <strong>Αποθήκευση & Σύνδεση</strong>.</p>
        <p className="mt-2 text-amber-700 bg-amber-50 rounded-lg px-3 py-2">
          <strong>Πολλαπλοί χρήστες (LAN):</strong> Εγκαταστήστε PostgreSQL σε <em>ένα</em> PC. Στους υπόλοιπους υπολογιστές βάλτε την IP του server αντί για <Code>localhost</Code>.
        </p>
      </Section>

      <Section icon={Users} title="Διαχείριση Χρηστών">
        <p>Η εφαρμογή υποστηρίζει δύο ρόλους:</p>
        <ul className="mt-2 space-y-1 ml-4">
          <li><ChevronRight size={12} className="inline mr-1 text-blue-500" /><strong>Διαχειριστής (admin):</strong> Πλήρης πρόσβαση + δημιουργία/διαγραφή χρηστών</li>
          <li><ChevronRight size={12} className="inline mr-1 text-blue-500" /><strong>Χρήστης (user):</strong> Καταχώρηση και επεξεργασία εγγραφών, εξαγωγή PDF</li>
        </ul>
        <p className="mt-3">
          <strong>Πρώτη σύνδεση:</strong> χρήστης <Code>admin</Code> / κωδικός <Code>admin123</Code>
        </p>
        <p className="mt-2 text-red-700 bg-red-50 rounded-lg px-3 py-2">
          <strong>Αλλάξτε τον κωδικό admin αμέσως!</strong> Μεταβείτε στο μενού <strong>Χρήστες</strong> <ChevronRight size={12} className="inline" /> κλικ στο εικονίδιο κλειδιού.
        </p>
        <p className="mt-3">Για να δημιουργήσετε νέο χρήστη: <strong>Χρήστες</strong> → <strong>Νέος Χρήστης</strong> → Συμπληρώστε όνομα, username, κωδικό, ρόλο.</p>
      </Section>

      <Section icon={FileText} title="Χρήση της Εφαρμογής">
        <p className="font-semibold text-gray-800 mb-2">Καταχώρηση νέας εγγραφής:</p>
        <Step n={1}>Επιλέξτε κατηγορία από το μενού (π.χ. Δήλωση Βαπτίσεως).</Step>
        <Step n={2}>Κλικ <strong>+ Νέα Εγγραφή</strong>.</Step>
        <Step n={3}>Συμπληρώστε τα πεδία και πατήστε <strong>Έκδοση</strong>.</Step>

        <p className="font-semibold text-gray-800 mt-4 mb-2">Εξαγωγή PDF:</p>
        <Step n={1}>Ανοίξτε μια εγγραφή κάνοντας κλικ πάνω της.</Step>
        <Step n={2}>Κλικ <strong>📄 PDF</strong> πάνω δεξιά.</Step>
        <Step n={3}>Επιλέξτε φάκελο αποθήκευσης και πατήστε <strong>Save</strong>.</Step>

        <p className="font-semibold text-gray-800 mt-4 mb-2">Αναζήτηση εγγραφών:</p>
        <p>Χρησιμοποιήστε το πεδίο αναζήτησης πάνω από κάθε πίνακα για φιλτράρισμα.</p>
      </Section>

      <Section icon={Download} title="Μετάπτωση Παλαιών Δεδομένων (SQLite)">
        <p>Αν έχετε αρχείο <Code>adeies.db</Code> από την παλιά εφαρμογή Java, εκτελέστε:</p>
        <Block>{'# Mac / Linux\nSQLITE_PATH=/path/to/adeies.db \\\nDATABASE_URL=postgresql://adeies:adeies@localhost:5432/adeies \\\nnpm run migrate:sqlite\n\n# Windows (PowerShell)\n$env:SQLITE_PATH="C:\\path\\to\\adeies.db"\n$env:DATABASE_URL="postgresql://adeies:adeies@localhost:5432/adeies"\nnpm run migrate:sqlite'}</Block>
        <p className="text-green-700 bg-green-50 rounded-lg px-3 py-2 mt-2">
          Το script μεταφέρει αυτόματα όλες τις εγγραφές από τα 5 παλαιά tables.
        </p>
      </Section>

      <Section icon={Settings} title="Τεχνικές Πληροφορίες">
        <div className="grid grid-cols-2 gap-2 text-xs">
          {[
            ['Framework', 'Electron 28 + React 18'],
            ['Γλώσσα', 'TypeScript'],
            ['Βάση Δεδομένων', 'PostgreSQL 16'],
            ['UI', 'Tailwind CSS'],
            ['Φόρμες', 'React Hook Form + Zod'],
            ['PDF', 'Electron printToPDF'],
          ].map(([k, v]) => (
            <div key={k} className="bg-gray-50 rounded-lg p-2.5">
              <div className="text-gray-400 text-xs">{k}</div>
              <div className="font-semibold text-gray-800">{v}</div>
            </div>
          ))}
        </div>
      </Section>

      <div className="flex items-center gap-2 text-xs text-gray-400 mt-4 justify-center pb-4">
        <Terminal size={12} />
        <span>Adeies v2.0 — Εκκλησιαστικό Σύστημα Διαχείρισης</span>
      </div>
    </div>
  )
}
