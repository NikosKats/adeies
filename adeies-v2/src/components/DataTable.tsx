import { useNavigate } from 'react-router-dom'
import { Plus, Pencil, Trash2, Search, FileX } from 'lucide-react'

interface Column {
  key: string
  label: string
  width?: string
}

interface Props {
  columns: Column[]
  rows: Record<string, string>[]
  basePath: string
  onDelete?: (id: number) => void
  loading?: boolean
  searchValue?: string
  onSearch?: (v: string) => void
}

export default function DataTable({ columns, rows, basePath, onDelete, loading, searchValue, onSearch }: Props) {
  const navigate = useNavigate()

  return (
    <div>
      <div className="flex items-center gap-3 mb-5">
        {onSearch !== undefined && (
          <div className="relative flex-1 max-w-xs">
            <Search size={15} className="absolute left-3 top-1/2 -translate-y-1/2 text-gray-400" />
            <input
              type="text"
              placeholder="Αναζήτηση..."
              value={searchValue}
              onChange={(e) => onSearch(e.target.value)}
              className="form-input pl-9"
            />
          </div>
        )}
        <button onClick={() => navigate(`${basePath}/new`)} className="btn-primary ml-auto">
          <Plus size={16} />Νέα Εγγραφή
        </button>
      </div>

      {loading ? (
        <div className="card text-center py-16 text-gray-400">
          <div className="animate-spin w-8 h-8 border-2 border-blue-500 border-t-transparent rounded-full mx-auto mb-3" />
          Φόρτωση...
        </div>
      ) : rows.length === 0 ? (
        <div className="card text-center py-16">
          <FileX size={40} className="text-gray-300 mx-auto mb-3" />
          <p className="text-gray-500 font-medium">Δεν υπάρχουν εγγραφές</p>
          <p className="text-gray-400 text-sm mt-1">Κλικ "+ Νέα Εγγραφή" για να ξεκινήσετε</p>
        </div>
      ) : (
        <div className="overflow-x-auto rounded-xl border border-gray-200 shadow-sm bg-white">
          <table className="w-full">
            <thead>
              <tr>
                {columns.map((col) => (
                  <th key={col.key} className="table-th" style={col.width ? { width: col.width } : {}}>
                    {col.label}
                  </th>
                ))}
                <th className="table-th" style={{ width: '90px' }}>Ενέργειες</th>
              </tr>
            </thead>
            <tbody>
              {rows.map((row) => (
                <tr key={row.id} className="table-row" onClick={() => navigate(`${basePath}/${row.id}`)}>
                  {columns.map((col) => (
                    <td key={col.key} className="table-td">{row[col.key] || '—'}</td>
                  ))}
                  <td className="table-td" onClick={(e) => e.stopPropagation()}>
                    <div className="flex gap-1">
                      <button
                        onClick={() => navigate(`${basePath}/${row.id}/edit`)}
                        className="p-1.5 text-blue-600 hover:bg-blue-50 rounded-lg transition-colors"
                        title="Επεξεργασία"
                      >
                        <Pencil size={14} />
                      </button>
                      {onDelete && (
                        <button
                          onClick={() => { if (confirm('Διαγραφή εγγραφής;')) onDelete(Number(row.id)) }}
                          className="p-1.5 text-red-500 hover:bg-red-50 rounded-lg transition-colors"
                          title="Διαγραφή"
                        >
                          <Trash2 size={14} />
                        </button>
                      )}
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
          <div className="px-4 py-2.5 bg-gray-50 border-t border-gray-100 text-xs text-gray-400">
            {rows.length} {rows.length === 1 ? 'εγγραφή' : 'εγγραφές'}
          </div>
        </div>
      )}
    </div>
  )
}
