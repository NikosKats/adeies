import DataTable from '../../../components/DataTable'
import { useModuleList } from '../../../components/useModule'

const columns = [
  { key: 'id', label: '#', width: '60px' },
  { key: 'arithmos_protokolou', label: 'Αριθμ. Πρωτ.' },
  { key: 'agamos_onoma', label: 'Όνομα Αγάμου' },
  { key: 'ieros_naos', label: 'Ιερός Ναός' },
  { key: 'etos_ekdosis', label: 'Έτος Έκδοσης' }
]

export default function CertificateATable() {
  const { rows, loading, search, setSearch, remove } = useModuleList('certificates_a')

  return (
    <div>
      <h2 className="page-title">Πιστοποιητικά Αγαμίας (Τύπος Α΄)</h2>
      <DataTable columns={columns} rows={rows} basePath="/certificate-a" onDelete={remove} loading={loading} searchValue={search} onSearch={setSearch} />
    </div>
  )
}
