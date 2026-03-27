import { useNavigate } from 'react-router-dom'
import { useEffect, useState } from 'react'
import { ScrollText, FileText, Heart, BookOpen } from 'lucide-react'
import { useAuth } from '../context/AuthContext'

const modules = [
  { path: '/baptism-declaration', icon: ScrollText, label: 'Δήλωση Βαπτίσεως', desc: 'Καταχώρηση δηλώσεων βαπτίσεως', stat: 'baptism_declarations', light: 'bg-blue-50 text-blue-600' },
  { path: '/baptism-specification', icon: FileText, label: 'Προσδιορισμός Βαπτίσεως', desc: 'Πράξεις προσδιορισμού βαπτίσματος', stat: 'baptism_specifications', light: 'bg-indigo-50 text-indigo-600' },
  { path: '/marriage', icon: Heart, label: 'Δήλωση Γάμου', desc: 'Δηλώσεις θρησκευτικού γάμου', stat: 'marriage_declarations', light: 'bg-rose-50 text-rose-600' },
  { path: '/certificate-a', icon: FileText, label: 'Πιστοποιητικό Αγαμίας Α΄', desc: 'Πιστοποιητικά αγαμίας τύπου Α', stat: 'certificates_a', light: 'bg-emerald-50 text-emerald-600' },
  { path: '/certificate-b', icon: BookOpen, label: 'Πιστοποιητικό Αγαμίας Β΄', desc: 'Πιστοποιητικά αγαμίας τύπου Β', stat: 'certificates_b', light: 'bg-amber-50 text-amber-600' },
]

export default function Home() {
  const navigate = useNavigate()
  const { user } = useAuth()
  const [stats, setStats] = useState<Record<string, number>>({})

  useEffect(() => {
    window.api.getStats().then(setStats).catch(() => {})
  }, [])

  const total = Object.values(stats).reduce((a, b) => a + b, 0)

  return (
    <div>
      <div className="mb-8">
        <h2 className="text-2xl font-bold text-gray-900 tracking-tight">Καλωσήρθατε, {user?.full_name} 👋</h2>
        <p className="text-gray-500 mt-1 text-sm">Σύστημα Διαχείρισης Εκκλησιαστικών Εγγράφων</p>
      </div>

      <div className="bg-gradient-to-r from-blue-700 to-blue-600 rounded-2xl p-6 mb-6 text-white shadow-lg">
        <p className="text-blue-200 text-sm font-medium uppercase tracking-wide">Σύνολο Εγγραφών</p>
        <p className="text-5xl font-bold mt-1">{total}</p>
        <p className="text-blue-200 text-sm mt-2">σε όλες τις κατηγορίες</p>
      </div>

      <div className="grid grid-cols-1 sm:grid-cols-2 xl:grid-cols-3 gap-4">
        {modules.map((m) => (
          <button key={m.path} onClick={() => navigate(m.path)}
            className="bg-white rounded-xl border border-gray-100 shadow-sm p-5 text-left hover:shadow-md hover:border-blue-200 transition-all duration-200 group"
          >
            <div className="flex items-start justify-between mb-4">
              <div className={`w-11 h-11 rounded-xl ${m.light} flex items-center justify-center`}>
                <m.icon size={20} />
              </div>
              <span className="text-2xl font-bold text-gray-800 group-hover:text-blue-700 transition-colors">
                {stats[m.stat] ?? '—'}
              </span>
            </div>
            <h3 className="text-sm font-semibold text-gray-900 group-hover:text-blue-700 transition-colors mb-1">{m.label}</h3>
            <p className="text-xs text-gray-400">{m.desc}</p>
          </button>
        ))}
      </div>
    </div>
  )
}
