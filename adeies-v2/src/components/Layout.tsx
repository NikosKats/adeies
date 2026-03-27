import { Outlet, NavLink, useNavigate } from 'react-router-dom'
import { Church, FileText, Heart, ScrollText, HelpCircle, Users, Settings, LogOut, ChevronDown } from 'lucide-react'
import { useState, useRef, useEffect } from 'react'
import { useAuth } from '../context/AuthContext'
import { Toaster } from 'sonner'

const navItems = [
  { path: '/', label: 'Αρχική', icon: Church, exact: true },
  { path: '/baptism-declaration', label: 'Βαπτίσεως', icon: ScrollText },
  { path: '/baptism-specification', label: 'Προσδιορισμός', icon: FileText },
  { path: '/marriage', label: 'Γάμου', icon: Heart },
  { path: '/certificate-a', label: 'Αγαμία Α΄', icon: FileText },
  { path: '/certificate-b', label: 'Αγαμία Β΄', icon: FileText },
]

export default function Layout() {
  const navigate = useNavigate()
  const { user, logout } = useAuth()
  const [menuOpen, setMenuOpen] = useState(false)
  const menuRef = useRef<HTMLDivElement>(null)

  useEffect(() => {
    function handleClick(e: MouseEvent) {
      if (menuRef.current && !menuRef.current.contains(e.target as Node)) setMenuOpen(false)
    }
    document.addEventListener('mousedown', handleClick)
    return () => document.removeEventListener('mousedown', handleClick)
  }, [])

  const handleLogout = async () => {
    await logout()
    setMenuOpen(false)
  }

  return (
    <div className="flex flex-col h-screen overflow-hidden bg-slate-100">
      <Toaster position="top-right" richColors closeButton />

      <header className="bg-gradient-to-r from-blue-900 to-blue-800 text-white flex items-center justify-between px-5 h-14 shadow-lg flex-shrink-0">
        <button onClick={() => navigate('/')} className="flex items-center gap-2.5 hover:opacity-80 transition-opacity">
          <div className="w-8 h-8 bg-white/20 rounded-lg flex items-center justify-center">
            <Church size={18} />
          </div>
          <span className="font-bold text-sm tracking-wide hidden sm:block">Εκκλησιαστικό Σύστημα</span>
        </button>

        <div className="flex items-center gap-0.5">
          <button onClick={() => navigate('/help')} className="flex items-center gap-1.5 text-blue-200 hover:text-white hover:bg-white/10 px-3 py-1.5 rounded-lg transition-all text-sm">
            <HelpCircle size={15} /><span className="hidden sm:block">Βοήθεια</span>
          </button>
          {user?.role === 'admin' && (
            <button onClick={() => navigate('/users')} className="flex items-center gap-1.5 text-blue-200 hover:text-white hover:bg-white/10 px-3 py-1.5 rounded-lg transition-all text-sm">
              <Users size={15} /><span className="hidden sm:block">Χρήστες</span>
            </button>
          )}
          <button onClick={() => navigate('/settings')} className="flex items-center gap-1.5 text-blue-200 hover:text-white hover:bg-white/10 px-3 py-1.5 rounded-lg transition-all text-sm">
            <Settings size={15} /><span className="hidden sm:block">Ρυθμίσεις</span>
          </button>

          <div className="relative ml-1" ref={menuRef}>
            <button onClick={() => setMenuOpen((o) => !o)} className="flex items-center gap-2 text-white hover:bg-white/10 px-3 py-1.5 rounded-lg transition-all text-sm">
              <div className="w-7 h-7 bg-white/20 rounded-full flex items-center justify-center text-xs font-bold">
                {user?.full_name?.[0]?.toUpperCase() ?? '?'}
              </div>
              <span className="hidden sm:block max-w-[120px] truncate">{user?.full_name}</span>
              <ChevronDown size={13} className={`transition-transform ${menuOpen ? 'rotate-180' : ''}`} />
            </button>
            {menuOpen && (
              <div className="absolute right-0 top-full mt-1.5 w-48 bg-white rounded-xl shadow-xl border border-gray-100 py-1 z-50">
                <div className="px-3 py-2 border-b border-gray-100">
                  <p className="text-sm font-semibold text-gray-800">{user?.full_name}</p>
                  <p className="text-xs text-gray-400">{user?.role === 'admin' ? 'Διαχειριστής' : 'Χρήστης'}</p>
                </div>
                <button onClick={handleLogout} className="w-full flex items-center gap-2 px-3 py-2 text-sm text-red-600 hover:bg-red-50 transition-colors">
                  <LogOut size={14} />Αποσύνδεση
                </button>
              </div>
            )}
          </div>
        </div>
      </header>

      <nav className="bg-white border-b border-gray-200 px-4 flex gap-0.5 overflow-x-auto flex-shrink-0 shadow-sm">
        {navItems.map((item) => (
          <NavLink key={item.path} to={item.path} end={item.exact}
            className={({ isActive }) =>
              `flex items-center gap-1.5 px-3.5 py-3 text-sm font-medium whitespace-nowrap border-b-2 transition-all duration-150 ${
                isActive ? 'text-blue-700 border-blue-600 bg-blue-50/50' : 'text-gray-500 border-transparent hover:text-gray-800 hover:border-gray-300'
              }`}
          >
            <item.icon size={15} />{item.label}
          </NavLink>
        ))}
      </nav>

      <main className="flex-1 overflow-auto p-6"><Outlet /></main>
    </div>
  )
}
