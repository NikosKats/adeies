import { useModuleView } from '../../../components/useModule'

function row(label: string, value: string | undefined) {
  return (
    <div className="flex gap-2 py-1 border-b border-gray-100">
      <span className="text-sm font-medium text-gray-600 w-56 flex-shrink-0">{label}:</span>
      <span className="text-sm text-gray-900">{value || '—'}</span>
    </div>
  )
}

export default function BaptismSpecificationView() {
  const { record, loading, navigate, id, exportPdf } = useModuleView('baptism_specifications')

  if (loading) return <div className="text-gray-500">Φόρτωση...</div>
  if (!record) return <div className="text-red-500">Η εγγραφή δεν βρέθηκε.</div>

  const r = record

  const generateHtml = () => `
<!DOCTYPE html><html lang="el"><head><meta charset="UTF-8"/>
<style>body{font-family:Arial,sans-serif;font-size:12pt;margin:2cm;}h1,h2{text-align:center;}.field{margin:6px 0;}</style>
</head><body>
  <h1>ΕΛΛΗΝΙΚΗ ΔΗΜΟΚΡΑΤΙΑ</h1>
  <h1>ΙΕΡΑ ΜΗΤΡΟΠΟΛΙΣ ${r.iera_mitropolis || ''}</h1>
  <h2>ΙΕΡΟΣ ΝΑΟΣ ${r.ieros_naos || ''}</h2>
  <p style="text-align:right">Αριθμ.Πρωτ.: <b>${r.arithmos_protokolou || ''}</b></p>
  <h2>ΠΡΑΞΙΣ ΠΡΟΣΔΙΟΡΙΣΜΟΥ ΤΕΛΕΣΕΩΣ ΤΟΥ ΜΥΣΤΗΡΙΟΥ ΤΟΥ ΒΑΠΤΙΣΜΑΤΟΣ</h2>
  <div class="field">Σήμερον την <b>${r.simeron_imera || ''}</b> του μηνός <b>${r.simeron_minas || ''}</b> του <b>${r.simeron_etos || ''}</b></div>
  <div class="field">εμφανίσθησαν ενώπιον εμού οι γονείς:</div>
  <div class="field">1) <b>${r.goneis_1 || ''}</b> Αρ.Ταυτ. ${r.goneis_1_id_arithmos || ''}</div>
  <div class="field">2) <b>${r.goneis_2 || ''}</b> Αρ.Ταυτ. ${r.goneis_2_id_arithmos || ''}</div>
  <div class="field">Α) Το τέκνο <b>${r.teknon_onoma || ''}</b> γεννηθέν <b>${r.teknon_gennitiki_imera || ''}</b> <b>${r.teknon_gennitiki_minas || ''}</b> <b>${r.teknon_gennitiki_etos || ''}</b> στο Νοσοκομείο <b>${r.teknon_nosokomeio || ''}</b></div>
  <div class="field">Αριθμ. Πράξης Ληξ.: ${r.lixiarxeio_praxis_arithmos || ''} Τόμος: ${r.lixiarxeio_tomos || ''} Έτος: ${r.lixiarxeio_etos || ''}</div>
  <div class="field">ΕΠΙΘΥΜΟΥΝ να το βαπτίσουν: <b>${r.baptisma_imera || ''}</b> <b>${r.baptisma_minas || ''}</b> <b>${r.baptisma_etos || ''}</b></div>
  <div class="field">Β) Ανάδοχος: <b>${r.anadoxos || ''}</b>, ετέλεσε γάμο κατά: ${r.anadoxos_gamochronologia || ''} στον Ναό: ${r.anadoxos_gamonaos || ''}</div>
  <div style="margin-top:40px;text-align:right">Εν ${r.topos_ypovrolis || ''}, τη ${r.imera_ypovrolis || ''} ${r.etos_ypovrolis || ''}</div>
  <div style="margin-top:40px;text-align:center"><b>Ο ΕΦΗΜΕΡΙΟΣ</b></div>
</body></html>`

  return (
    <div className="max-w-4xl">
      <div className="flex items-center gap-4 mb-6 flex-wrap">
        <button onClick={() => navigate('/baptism-specification')} className="btn-secondary">← Πίσω</button>
        <h2 className="page-title mb-0">Προσδιορισμός Βαπτίσεως #{id}</h2>
        <div className="ml-auto flex gap-2">
          <button onClick={() => navigate(`/baptism-specification/${id}/edit`)} className="btn-primary">Επεξεργασία</button>
          <button onClick={() => exportPdf(generateHtml(), `prosd-baptism-${id}.pdf`)} className="btn-secondary">📄 PDF</button>
        </div>
      </div>
      <div className="card">
        <h3 className="section-title">Στοιχεία Εκκλησίας</h3>
        {row('Ιερά Μητρόπολις', r.iera_mitropolis)}
        {row('Ιερός Ναός', r.ieros_naos)}
        {row('Αριθμ. Πρωτοκόλλου', r.arithmos_protokolou)}
        <h3 className="section-title mt-4">Γονείς</h3>
        {row('Γονέας 1', r.goneis_1)}
        {row('Γονέας 2', r.goneis_2)}
        <h3 className="section-title mt-4">Τέκνο</h3>
        {row('Όνομα', r.teknon_onoma)}
        {row('Ημερομηνία Γέννησης', `${r.teknon_gennitiki_imera || ''} ${r.teknon_gennitiki_minas || ''} ${r.teknon_gennitiki_etos || ''}`)}
        {row('Νοσοκομείο', r.teknon_nosokomeio)}
        <h3 className="section-title mt-4">Βάπτισμα</h3>
        {row('Ημερομηνία Βαπτίσματος', `${r.baptisma_imera || ''} ${r.baptisma_minas || ''} ${r.baptisma_etos || ''}`)}
        {row('Ανάδοχος', r.anadoxos)}
      </div>
    </div>
  )
}
