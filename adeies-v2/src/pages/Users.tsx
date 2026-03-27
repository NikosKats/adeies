import { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { UserPlus, Pencil, Trash2, KeyRound, ShieldCheck, User } from 'lucide-react'
import { useAuth } from '../context/AuthContext'
import { toast } from 'sonner'
import type { AppUser } from '../types'

type UserRow = AppUser & { created_at: string }

export default function Users() {
  const navigate = useNavigate()
  const { user: currentUser } = useAuth()
  const [users, setUsers] = useState<UserRow[]>([])
  const [loading, setLoading] = useState(true)
  const [modal, setModal] = useState<'create' | 'edit' | 'password' | null>(null)
  const [selected, setSelected] = useState<UserRow | null>(null)

  // Form state
  const [form, setForm] = useState({ username: '', full_name: '', role: 'user', password: '', confirmPassword: '' })

  useEffect(() => {
    if (currentUser?.role !== 'admin') { navigate('/'); return }
    load()
  }, [])

  const load = async () => {
    setLoading(true)
    const rows = await window.api.userList()
    setUsers(rows)
    setLoading(false)
  }

  const openCreate = () => {
    setForm({ username: '', full_name: '', role: 'user', password: '', confirmPassword: '' })
    setSelected(null)
    setModal('create')
  }

  const openEdit = (u: UserRow) => {
    setForm({ username: u.username, full_name: u.full_name, role: u.role, password: '', confirmPassword: '' })
    setSelected(u)
    setModal('edit')
  }

  const openPassword = (u: UserRow) => {
    setForm({ username: u.username, full_name: u.full_name, role: u.role, password: '', confirmPassword: '' })
    setSelected(u)
    setModal('password')
  }

  const handleCreate = async () => {
    if (!form.username || !form.full_name || !form.password) return toast.error('Συμπληρώστε όλα τα πεδία.')
    if (form.password !== form.confirmPassword) return toast.error('Οι κωδικοί δεν ταιριάζουν.')
    const res = await window.api.userCreate({ username: form.username, full_name: form.full_name, role: form.role, password: form.password })
    if (!res.ok) return toast.error(res.error ?? 'Σφάλμα δημιουργίας.')
    toast.success('Ο χρήστης δημιουργήθηκε.')
    setModal(null)
    load()
  }

  const handleEdit = async () => {
    if (!selected) return
    const res = await window.api.userUpdate(selected.id, { full_name: form.full_name, role: form.role })
    if (!res.ok) return toast.error(res.error ?? 'Σφάλμα αποθήκευσης.')
    toast.success('Τα στοιχεία αποθηκεύτηκαν.')
    setModal(null)
    load()
  }

  const handlePassword = async () => {
    if (!selected) return
    if (!form.password) return toast.error('Εισάγετε νέο κωδικό.')
    if (form.password !== form.confirmPassword) return toast.error('Οι κωδικοί δεν ταιριάζουν.')
    const res = await window.api.userChangePassword(selected.id, form.password)
    if (!res.ok) return toast.error(res.error ?? 'Σφάλμα αλλαγής κωδικού.')
    toast.success('Ο κωδικός άλλαξε.')
    setModal(null)
  }

  const handleDelete = async (u: UserRow) => {
    if (u.id === currentUser?.id) return toast.error('Δεν μπορείτε να διαγράψετε τον εαυτό σας.')
    if (!confirm(`Διαγραφή χρήστη "${u.full_name}";`)) return
    const res = await window.api.userDelete(u.id)
    if (!res.ok) return toast.error(res.error ?? 'Σφάλμα διαγραφής.')
    toast.success('Ο χρήστης διαγράφηκε.')
    load()
  }

  const f = (field: keyof typeof form, val: string) => setForm((p) => ({ ...p, [field]: val }))

  return (
    <div className="max-w-4xl">
      <div className="flex items-center justify-between mb-6">
        <h2 className="page-title mb-0">Διαχείριση Χρηστών</h2>
        <button onClick={openCreate} className="btn-primary">
          <UserPlus size={16} />Νέος Χρήστης
        </button>
      </div>

      {loading ? (
        <div className="text-gray-400 text-center py-12">Φόρτωση...</div>
      ) : (
        <div className="card p-0 overflow-hidden">
          <table className="w-full">
            <thead>
              <tr>
                <th className="table-th">Ονοματεπώνυμο</th>
                <th className="table-th">Όνομα Χρήστη</th>
                <th className="table-th">Ρόλος</th>
                <th className="table-th">Δημιουργήθηκε</th>
                <th className="table-th w-36">Ενέργειες</th>
              </tr>
            </thead>
            <tbody>
              {users.map((u) => (
                <tr key={u.id} className="hover:bg-gray-50">
                  <td className="table-td font-medium">
                    <div className="flex items-center gap-2">
                      <div className="w-8 h-8 rounded-full bg-blue-100 text-blue-700 flex items-center justify-center text-sm font-bold">
                        {u.full_name[0]}
                      </div>
                      {u.full_name}
                      {u.id === currentUser?.id && <span className="badge badge-user ml-1">εσείς</span>}
                    </div>
                  </td>
                  <td className="table-td text-gray-500 font-mono text-xs">{u.username}</td>
                  <td className="table-td">
                    <span className={u.role === 'admin' ? 'badge-admin' : 'badge-user'}>
                      {u.role === 'admin' ? <><ShieldCheck size={11} /> Διαχειριστής</> : <><User size={11} /> Χρήστης</>}
                    </span>
                  </td>
                  <td className="table-td text-gray-400 text-xs">
                    {new Date(u.created_at).toLocaleDateString('el-GR')}
                  </td>
                  <td className="table-td">
                    <div className="flex gap-1">
                      <button onClick={() => openEdit(u)} className="p-1.5 text-blue-600 hover:bg-blue-50 rounded-lg transition-colors" title="Επεξεργασία">
                        <Pencil size={14} />
                      </button>
                      <button onClick={() => openPassword(u)} className="p-1.5 text-amber-600 hover:bg-amber-50 rounded-lg transition-colors" title="Αλλαγή Κωδικού">
                        <KeyRound size={14} />
                      </button>
                      <button onClick={() => handleDelete(u)} className="p-1.5 text-red-500 hover:bg-red-50 rounded-lg transition-colors" title="Διαγραφή">
                        <Trash2 size={14} />
                      </button>
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}

      {/* Modal */}
      {modal && (
        <div className="fixed inset-0 bg-black/50 flex items-center justify-center z-50 p-4">
          <div className="bg-white rounded-2xl shadow-2xl w-full max-w-md p-6">
            <h3 className="text-lg font-bold text-gray-900 mb-5">
              {modal === 'create' ? 'Νέος Χρήστης' : modal === 'edit' ? 'Επεξεργασία Χρήστη' : 'Αλλαγή Κωδικού'}
            </h3>

            <div className="space-y-4">
              {modal === 'create' && (
                <div>
                  <label className="form-label">Όνομα Χρήστη</label>
                  <input className="form-input" value={form.username} onChange={(e) => f('username', e.target.value)} placeholder="π.χ. ioannis" />
                </div>
              )}
              {modal !== 'password' && (
                <>
                  <div>
                    <label className="form-label">Ονοματεπώνυμο</label>
                    <input className="form-input" value={form.full_name} onChange={(e) => f('full_name', e.target.value)} placeholder="π.χ. Ιωάννης Παπαδόπουλος" />
                  </div>
                  <div>
                    <label className="form-label">Ρόλος</label>
                    <select className="form-input" value={form.role} onChange={(e) => f('role', e.target.value)}>
                      <option value="user">Χρήστης</option>
                      <option value="admin">Διαχειριστής</option>
                    </select>
                  </div>
                </>
              )}
              {(modal === 'create' || modal === 'password') && (
                <>
                  <div>
                    <label className="form-label">{modal === 'password' ? 'Νέος Κωδικός' : 'Κωδικός'}</label>
                    <input type="password" className="form-input" value={form.password} onChange={(e) => f('password', e.target.value)} />
                  </div>
                  <div>
                    <label className="form-label">Επιβεβαίωση Κωδικού</label>
                    <input type="password" className="form-input" value={form.confirmPassword} onChange={(e) => f('confirmPassword', e.target.value)} />
                  </div>
                </>
              )}
            </div>

            <div className="flex gap-3 mt-6">
              <button
                onClick={modal === 'create' ? handleCreate : modal === 'edit' ? handleEdit : handlePassword}
                className="btn-primary flex-1 justify-center"
              >
                {modal === 'create' ? 'Δημιουργία' : modal === 'edit' ? 'Αποθήκευση' : 'Αλλαγή Κωδικού'}
              </button>
              <button onClick={() => setModal(null)} className="btn-secondary">Ακύρωση</button>
            </div>
          </div>
        </div>
      )}
    </div>
  )
}
