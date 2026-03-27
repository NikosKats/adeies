import { useNavigate } from 'react-router-dom'

const modules = [
  { path: '/baptism-declaration', icon: '✝', title: 'Δήλωση Βαπτίσεως', desc: 'Καταχώρηση και διαχείριση δηλώσεων βαπτίσεως' },
  { path: '/baptism-specification', icon: '📋', title: 'Προσδιορισμός Βαπτίσεως', desc: 'Πράξεις προσδιορισμού τελέσεως βαπτίσματος' },
  { path: '/marriage', icon: '💍', title: 'Δήλωση Γάμου', desc: 'Δηλώσεις τελέσεως θρησκευτικού γάμου' },
  { path: '/certificate-a', icon: '📄', title: 'Πιστοποιητικό Αγαμίας Α΄', desc: 'Έκδοση πιστοποιητικών αγαμίας τύπου Α' },
  { path: '/certificate-b', icon: '📃', title: 'Πιστοποιητικό Αγαμίας Β΄', desc: 'Έκδοση πιστοποιητικών αγαμίας τύπου Β' }
]

export default function Home() {
  const navigate = useNavigate()

  return (
    <div>
      <h2 className="page-title">Αρχικό Μενού</h2>
      <div className="grid grid-cols-1 sm:grid-cols-2 xl:grid-cols-3 gap-4">
        {modules.map((m) => (
          <button
            key={m.path}
            onClick={() => navigate(m.path)}
            className="card text-left hover:shadow-md hover:border-blue-300 transition-all cursor-pointer group"
          >
            <div className="text-3xl mb-3">{m.icon}</div>
            <h3 className="text-base font-semibold text-gray-900 group-hover:text-blue-700 mb-1">{m.title}</h3>
            <p className="text-sm text-gray-500">{m.desc}</p>
          </button>
        ))}
      </div>
    </div>
  )
}
