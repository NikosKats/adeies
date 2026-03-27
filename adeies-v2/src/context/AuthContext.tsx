import { createContext, useContext, useEffect, useState, ReactNode } from 'react'

export interface AppUser {
  id: number
  username: string
  full_name: string
  role: 'admin' | 'user'
}

interface AuthContextType {
  user: AppUser | null
  loading: boolean
  login: (username: string, password: string) => Promise<{ ok: boolean; error?: string }>
  logout: () => Promise<void>
}

const AuthContext = createContext<AuthContextType | null>(null)

export function AuthProvider({ children }: { children: ReactNode }) {
  const [user, setUser] = useState<AppUser | null>(null)
  const [loading, setLoading] = useState(true)

  useEffect(() => {
    window.api.userSession().then((u) => {
      setUser(u)
      setLoading(false)
    })
  }, [])

  const login = async (username: string, password: string) => {
    const result = await window.api.userLogin(username, password)
    if (result.ok && result.user) {
      setUser(result.user)
    }
    return result
  }

  const logout = async () => {
    await window.api.userLogout()
    setUser(null)
  }

  return (
    <AuthContext.Provider value={{ user, loading, login, logout }}>
      {children}
    </AuthContext.Provider>
  )
}

export function useAuth() {
  const ctx = useContext(AuthContext)
  if (!ctx) throw new Error('useAuth must be used within AuthProvider')
  return ctx
}
