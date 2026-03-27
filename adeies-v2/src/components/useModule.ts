import { useState, useEffect, useCallback } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import { TableName } from '../types'

export function useModuleList(table: TableName) {
  const [rows, setRows] = useState<Record<string, string>[]>([])
  const [loading, setLoading] = useState(true)
  const [search, setSearch] = useState('')
  const navigate = useNavigate()

  const load = useCallback(async () => {
    setLoading(true)
    try {
      const data = await window.api.list(table)
      setRows(data)
    } finally {
      setLoading(false)
    }
  }, [table])

  useEffect(() => { load() }, [load])

  const remove = async (id: number) => {
    await window.api.remove(table, id)
    await load()
  }

  const filtered = search
    ? rows.filter((r) => Object.values(r).some((v) => v?.toLowerCase().includes(search.toLowerCase())))
    : rows

  return { rows: filtered, loading, search, setSearch, remove, navigate, reload: load }
}

export function useModuleForm(table: TableName) {
  const { id } = useParams<{ id: string }>()
  const navigate = useNavigate()
  const [defaultValues, setDefaultValues] = useState<Record<string, string> | null>(null)
  const isEdit = !!id

  useEffect(() => {
    if (id) {
      window.api.get(table, Number(id)).then((data) => setDefaultValues(data ?? {}))
    } else {
      setDefaultValues({})
    }
  }, [id, table])

  const submit = async (data: Record<string, string>, backPath: string) => {
    if (isEdit) {
      await window.api.update(table, Number(id), data)
    } else {
      await window.api.insert(table, data)
    }
    navigate(backPath)
  }

  return { isEdit, defaultValues, submit, navigate, id: id ? Number(id) : null }
}

export function useModuleView(table: TableName) {
  const { id } = useParams<{ id: string }>()
  const navigate = useNavigate()
  const [record, setRecord] = useState<Record<string, string> | null>(null)
  const [loading, setLoading] = useState(true)

  useEffect(() => {
    if (id) {
      window.api.get(table, Number(id)).then((data) => {
        setRecord(data)
        setLoading(false)
      })
    }
  }, [id, table])

  const exportPdf = async (html: string, filename: string) => {
    const result = await window.api.exportPdf(html, filename)
    if (!result.ok && !result.canceled) alert('Σφάλμα εξαγωγής PDF: ' + result.error)
  }

  return { record, loading, navigate, id: id ? Number(id) : null, exportPdf }
}
