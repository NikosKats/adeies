import { Outlet, NavLink, useNavigate } from 'react-router-dom'

const navItems = [
  { path: '/', label: 'Αρχική', exact: true },
  { path: '/baptism-declaration', label: 'Δήλωση Βαπτίσεως' },
  { path: '/baptism-specification', label: 'Προσδιορισμός Βαπτίσεως' },
  { path: '/marriage', label: 'Δήλωση Γάμου' },
  { path: '/certificate-a', label: 'Αγαμία Α΄' },
  { path: '/certificate-b', label: 'Αγαμία Β΄' }
]

export default function Layout() {
  const navigate = useNavigate()

  return (
    <div className="flex flex-col h-screen overflow-hidden">
      {/* Top bar */}
      <header className="bg-blue-800 text-white flex items-center justify-between px-6 py-3 shadow-md flex-shrink-0">
        <h1 className="text-lg font-bold tracking-wide">⛪ Εκκλησιαστικό Σύστημα Διαχείρισης</h1>
        <button
          onClick={() => navigate('/settings')}
          className="text-blue-200 hover:text-white text-sm transition-colors"
        >
          ⚙ Ρυθμίσεις
        </button>
      </header>

      {/* Nav */}
      <nav className="bg-blue-900 px-4 flex gap-1 flex-shrink-0">
        {navItems.map((item) => (
          <NavLink
            key={item.path}
            to={item.path}
            end={item.exact}
            className={({ isActive }) =>
              `px-4 py-2 text-sm font-medium transition-colors ${
                isActive
                  ? 'text-white border-b-2 border-white'
                  : 'text-blue-200 hover:text-white hover:border-b-2 hover:border-blue-300'
              }`
            }
          >
            {item.label}
          </NavLink>
        ))}
      </nav>

      {/* Content */}
      <main className="flex-1 overflow-auto p-6 bg-gray-50">
        <Outlet />
      </main>
    </div>
  )
}
