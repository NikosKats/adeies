import { useEffect, useState } from 'react'
import { useForm } from 'react-hook-form'
import { zodResolver } from '@hookform/resolvers/zod'
import { z } from 'zod'
import { useNavigate } from 'react-router-dom'
import FormField from '../components/FormField'

const schema = z.object({
  host: z.string().min(1, 'Υποχρεωτικό'),
  port: z.coerce.number().min(1).max(65535),
  database: z.string().min(1, 'Υποχρεωτικό'),
  user: z.string().min(1, 'Υποχρεωτικό'),
  password: z.string()
})

type FormData = z.infer<typeof schema>

interface Props {
  onSaved?: () => void
}

export default function Settings({ onSaved }: Props) {
  const navigate = useNavigate()
  const [status, setStatus] = useState<{ ok: boolean; message: string } | null>(null)
  const [testing, setTesting] = useState(false)
  const [saving, setSaving] = useState(false)

  const { register, handleSubmit, formState: { errors }, reset } = useForm<FormData>({
    resolver: zodResolver(schema),
    defaultValues: { host: 'localhost', port: 5432, database: 'adeies', user: 'adeies', password: '' }
  })

  useEffect(() => {
    window.api.getDbConfig().then((cfg) => {
      if (cfg) reset(cfg)
    })
  }, [reset])

  const onTest = handleSubmit(async (data) => {
    setTesting(true)
    setStatus(null)
    const result = await window.api.testDbConnection(data)
    setStatus(result.ok ? { ok: true, message: 'Η σύνδεση ήταν επιτυχής!' } : { ok: false, message: result.error ?? 'Αποτυχία σύνδεσης' })
    setTesting(false)
  })

  const onSave = handleSubmit(async (data) => {
    setSaving(true)
    setStatus(null)
    const result = await window.api.saveDbConfig(data)
    if (result.ok) {
      setStatus({ ok: true, message: 'Αποθηκεύτηκε! Η βάση είναι έτοιμη.' })
      onSaved?.()
      setTimeout(() => navigate('/'), 1000)
    } else {
      setStatus({ ok: false, message: result.error ?? 'Αποτυχία αποθήκευσης' })
    }
    setSaving(false)
  })

  return (
    <div className="max-w-lg mx-auto mt-8">
      <div className="card">
        <h2 className="page-title">⚙ Ρυθμίσεις Βάσης Δεδομένων</h2>
        <p className="text-sm text-gray-500 mb-6">
          Εισάγετε τα στοιχεία σύνδεσης για τον PostgreSQL διακομιστή στο τοπικό δίκτυο.
        </p>

        <form>
          <FormField label="Διεύθυνση διακομιστή (IP)" registration={register('host')} error={errors.host?.message} required placeholder="π.χ. 192.168.1.10" />
          <FormField label="Θύρα" registration={register('port')} error={errors.port?.message} required placeholder="5432" type="number" />
          <FormField label="Βάση δεδομένων" registration={register('database')} error={errors.database?.message} required placeholder="adeies" />
          <FormField label="Χρήστης" registration={register('user')} error={errors.user?.message} required placeholder="adeies" />
          <FormField label="Κωδικός" registration={register('password')} type="password" placeholder="(κενό αν δεν υπάρχει)" />

          {status && (
            <div className={`p-3 rounded mb-4 text-sm ${status.ok ? 'bg-green-50 text-green-700 border border-green-200' : 'bg-red-50 text-red-700 border border-red-200'}`}>
              {status.message}
            </div>
          )}

          <div className="flex gap-3 mt-6">
            <button type="button" onClick={onTest} disabled={testing} className="btn-secondary flex-1">
              {testing ? 'Έλεγχος...' : 'Δοκιμή Σύνδεσης'}
            </button>
            <button type="button" onClick={onSave} disabled={saving} className="btn-primary flex-1">
              {saving ? 'Αποθήκευση...' : 'Αποθήκευση & Σύνδεση'}
            </button>
          </div>
        </form>
      </div>
    </div>
  )
}
