import DataTable from '../../../components/DataTable'
import { useModuleList } from '../../../components/useModule'

const columns = [
  { key: 'id', label: '#', width: '60px' },
  { key: 'arithmos_protokolou', label: 'Αριθμ. Πρωτ.' },
  { key: 'agamos_onoma', label: 'Όνομα Αγάμου' },
  { key: 'ieros_naos', label: 'Ιερός Ναός' },
  { key: 'etos_ekdosis', label: 'Έτος Έκδοσης' }
]

export default function CertificateBTable() {
  const { rows, loading, search, setSearch, remove } = useModuleList('certificates_b')

  return (
    <div>
      <h2 className="page-title">Πιστοποιητικά Αγαμίας (Τύπος Β΄)</h2>
      <DataTable columns={columns} rows={rows} basePath="/certificate-b" onDelete={remove} loading={loading} searchValue={search} onSearch={setSearch} />
    </div>
  )
}
