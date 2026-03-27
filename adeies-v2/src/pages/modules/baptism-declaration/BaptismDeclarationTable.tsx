import DataTable from '../../../components/DataTable'
import { useModuleList } from '../../../components/useModule'

const columns = [
  { key: 'id', label: '#', width: '60px' },
  { key: 'arithmos_protokolou', label: 'Αριθμ. Πρωτ.' },
  { key: 'onoma_baptisthen', label: 'Όνομα Βαπτισθέντος' },
  { key: 'pateras_onoma', label: 'Πατέρας' },
  { key: 'baptism_etos', label: 'Έτος' },
  { key: 'ieros_naos', label: 'Ιερός Ναός' }
]

export default function BaptismDeclarationTable() {
  const { rows, loading, search, setSearch, remove } = useModuleList('baptism_declarations')

  return (
    <div>
      <h2 className="page-title">Δηλώσεις Βαπτίσεως</h2>
      <DataTable
        columns={columns}
        rows={rows}
        basePath="/baptism-declaration"
        onDelete={remove}
        loading={loading}
        searchValue={search}
        onSearch={setSearch}
      />
    </div>
  )
}
