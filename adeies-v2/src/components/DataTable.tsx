import { useNavigate } from 'react-router-dom'

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
      {/* Search */}
      {onSearch !== undefined && (
        <div className="mb-4">
          <input
            type="text"
            placeholder="Αναζήτηση..."
            value={searchValue}
            onChange={(e) => onSearch(e.target.value)}
            className="form-input max-w-xs"
          />
        </div>
      )}

      {/* Actions */}
      <div className="mb-4">
        <button onClick={() => navigate(`${basePath}/new`)} className="btn-primary">
          + Νέα Εγγραφή
        </button>
      </div>

      {loading ? (
        <div className="text-gray-500 py-8 text-center">Φόρτωση...</div>
      ) : rows.length === 0 ? (
        <div className="text-gray-500 py-8 text-center card">Δεν υπάρχουν εγγραφές.</div>
      ) : (
        <div className="overflow-x-auto rounded-lg border border-gray-200 shadow-sm">
          <table className="w-full bg-white">
            <thead>
              <tr>
                {columns.map((col) => (
                  <th key={col.key} className="table-th" style={col.width ? { width: col.width } : {}}>
                    {col.label}
                  </th>
                ))}
                <th className="table-th" style={{ width: '120px' }}>Ενέργειες</th>
              </tr>
            </thead>
            <tbody>
              {rows.map((row) => (
                <tr key={row.id} className="table-row" onClick={() => navigate(`${basePath}/${row.id}`)}>
                  {columns.map((col) => (
                    <td key={col.key} className="table-td">
                      {row[col.key] || '—'}
                    </td>
                  ))}
                  <td className="table-td" onClick={(e) => e.stopPropagation()}>
                    <div className="flex gap-2">
                      <button
                        onClick={() => navigate(`${basePath}/${row.id}/edit`)}
                        className="text-blue-600 hover:text-blue-800 text-sm font-medium"
                      >
                        Επεξ.
                      </button>
                      {onDelete && (
                        <button
                          onClick={() => {
                            if (confirm('Διαγραφή εγγραφής;')) onDelete(Number(row.id))
                          }}
                          className="text-red-600 hover:text-red-800 text-sm font-medium"
                        >
                          Διαγρ.
                        </button>
                      )}
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </div>
  )
}
