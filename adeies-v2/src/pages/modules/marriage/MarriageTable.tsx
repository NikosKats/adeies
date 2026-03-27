import DataTable from '../../../components/DataTable'
import { useModuleList } from '../../../components/useModule'

const columns = [
  { key: 'id', label: '#', width: '60px' },
  { key: 'arithmos_lixiarkis_praxis', label: 'Αριθμ. Πράξης' },
  { key: 'syzygos_eponymo', label: 'Σύζυγος (Επώνυμο)' },
  { key: 'syzygou_eponymo', label: 'Σύζυγος 2 (Επώνυμο)' },
  { key: 'gamos_etos', label: 'Έτος Γάμου' },
  { key: 'ieros_naos', label: 'Ιερός Ναός' }
]

export default function MarriageTable() {
  const { rows, loading, search, setSearch, remove } = useModuleList('marriage_declarations')

  return (
    <div>
      <h2 className="page-title">Δηλώσεις Γάμου</h2>
      <DataTable columns={columns} rows={rows} basePath="/marriage" onDelete={remove} loading={loading} searchValue={search} onSearch={setSearch} />
    </div>
  )
}
