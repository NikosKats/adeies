import { useState } from 'react'
import { Church, LogIn } from 'lucide-react'
import { useAuth } from '../context/AuthContext'

export default function Login() {
  const { login } = useAuth()
  const [username, setUsername] = useState('')
  const [password, setPassword] = useState('')
  const [error, setError] = useState('')
  const [loading, setLoading] = useState(false)

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault()
    setError('')
    setLoading(true)
    const result = await login(username, password)
    if (!result.ok) setError(result.error ?? 'Σφάλμα σύνδεσης.')
    setLoading(false)
  }

  return (
    <div className="min-h-screen bg-gradient-to-br from-blue-950 via-blue-900 to-blue-800 flex items-center justify-center p-4">
      <div className="w-full max-w-sm">
        {/* Logo */}
        <div className="text-center mb-8">
          <div className="inline-flex items-center justify-center w-16 h-16 bg-white/10 rounded-2xl mb-4 backdrop-blur-sm border border-white/20">
            <Church size={32} className="text-white" />
          </div>
          <h1 className="text-2xl font-bold text-white tracking-tight">Εκκλησιαστικό Σύστημα</h1>
          <p className="text-blue-300 text-sm mt-1">Διαχείριση Εκκλησιαστικών Εγγράφων</p>
        </div>

        {/* Card */}
        <div className="bg-white rounded-2xl shadow-2xl p-8">
          <h2 className="text-lg font-bold text-gray-900 mb-6">Σύνδεση</h2>

          <form onSubmit={handleSubmit} className="space-y-4">
            <div>
              <label className="form-label">Όνομα Χρήστη</label>
              <input
                type="text"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
                className="form-input"
                placeholder="admin"
                autoFocus
                required
              />
            </div>
            <div>
              <label className="form-label">Κωδικός</label>
              <input
                type="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                className="form-input"
                placeholder="••••••••"
                required
              />
            </div>

            {error && (
              <div className="bg-red-50 text-red-700 text-sm px-4 py-3 rounded-lg border border-red-200">
                {error}
              </div>
            )}

            <button
              type="submit"
              disabled={loading}
              className="w-full btn-primary justify-center py-2.5 mt-2"
            >
              <LogIn size={16} />
              {loading ? 'Σύνδεση...' : 'Σύνδεση'}
            </button>
          </form>

          <p className="text-xs text-gray-400 text-center mt-6">
            Πρώτη σύνδεση: χρήστης <code className="bg-gray-100 px-1 rounded">admin</code> / κωδικός <code className="bg-gray-100 px-1 rounded">admin123</code>
          </p>
        </div>
      </div>
    </div>
  )
}
