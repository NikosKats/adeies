import DataTable from '../../../components/DataTable'
import { useModuleList } from '../../../components/useModule'

const columns = [
  { key: 'id', label: '#', width: '60px' },
  { key: 'arithmos_protokolou', label: 'Αριθμ. Πρωτ.' },
  { key: 'teknon_onoma', label: 'Όνομα Τέκνου' },
  { key: 'goneis_1', label: 'Γονέας 1' },
  { key: 'simeron_etos', label: 'Έτος' },
  { key: 'ieros_naos', label: 'Ιερός Ναός' }
]

export default function BaptismSpecificationTable() {
  const { rows, loading, search, setSearch, remove } = useModuleList('baptism_specifications')

  return (
    <div>
      <h2 className="page-title">Προσδιορισμός Βαπτίσεως</h2>
      <DataTable columns={columns} rows={rows} basePath="/baptism-specification" onDelete={remove} loading={loading} searchValue={search} onSearch={setSearch} />
    </div>
  )
}
