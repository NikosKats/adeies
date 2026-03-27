import { useModuleView } from '../../../components/useModule'

function row(label: string, value: string | undefined) {
  return (
    <div className="flex gap-2 py-1 border-b border-gray-100">
      <span className="text-sm font-medium text-gray-600 w-64 flex-shrink-0">{label}:</span>
      <span className="text-sm text-gray-900">{value || '—'}</span>
    </div>
  )
}

export default function MarriageView() {
  const { record, loading, navigate, id, exportPdf } = useModuleView('marriage_declarations')

  if (loading) return <div className="text-gray-500">Φόρτωση...</div>
  if (!record) return <div className="text-red-500">Η εγγραφή δεν βρέθηκε.</div>

  const r = record

  const generateHtml = () => `
<!DOCTYPE html><html lang="el"><head><meta charset="UTF-8"/>
<style>
  body{font-family:Arial,sans-serif;font-size:11pt;margin:1.5cm;}
  h1,h2{text-align:center;} table{width:100%;border-collapse:collapse;}
  td{padding:3px 6px;border-bottom:1px solid #eee;font-size:10pt;}
  .label{font-weight:bold;width:40%;}
  .section{font-weight:bold;background:#f0f0f0;padding:4px 6px;margin-top:10px;}
</style></head><body>
  <h1>ΔΗΛΩΣΗ ΤΕΛΕΣΗΣ ΘΡΗΣΚΕΥΤΙΚΟΥ ΓΑΜΟΥ</h1>
  <h2>ΙΕΡΑ ΜΗΤΡΟΠΟΛΗ ${r.iera_mitropoli || ''} — ΙΕΡΟΣ ΝΑΟΣ ${r.ieros_naos || ''}</h2>
  <p>Αριθμ. Ληξ. Πράξης Γάμου: <b>${r.arithmos_lixiarkis_praxis || ''}</b> | Τόμος: ${r.tomos || ''} | Έτος: ${r.etos || ''}</p>
  <p>Ο ιερέας <b>${r.iereus || ''}</b> δηλώνω ότι σήμερα στις <b>${r.gamos_imera || ''} ${r.gamos_minas || ''} ${r.gamos_etos || ''}</b> ώρα <b>${r.gamos_ora || ''}</b> τέλεσα το μυστήριο του γάμου των κάτωθεν:</p>
  <div class="section">ΣΤΟΙΧΕΙΑ ΣΥΖΥΓΟΥ</div>
  <table>
    <tr><td class="label">Επώνυμο</td><td>${r.syzygos_eponymo || ''}</td><td class="label">Όνομα</td><td>${r.syzygos_onoma || ''}</td></tr>
    <tr><td class="label">Επάγγελμα</td><td>${r.syzygos_epaggelma || ''}</td><td class="label">ΑΦΜ</td><td>${r.syzygos_afm || ''}</td></tr>
    <tr><td class="label">ΑΜΚΑ</td><td>${r.syzygos_amka || ''}</td><td class="label">Ιθαγένεια</td><td>${r.syzygos_ithagenia || ''}</td></tr>
    <tr><td class="label">Χρον. Γέννησης</td><td>${r.syzygos_chronologia_gennisis || ''}</td><td class="label">Τόπος Γέννησης</td><td>${r.syzygos_topos_gennisis || ''}</td></tr>
    <tr><td class="label">Πατέρας</td><td>${r.syzygos_pateras || ''}</td><td class="label">Μητέρα</td><td>${r.syzygos_mitera || ''}</td></tr>
    <tr><td class="label">Οικογ. Κατάσταση</td><td>${r.syzygos_oik_katastasi || ''}</td><td class="label">Βαθμός Γάμου</td><td>${r.syzygos_vathmos_gamou || ''}</td></tr>
    <tr><td class="label">Αρ. Άδειας Γάμου</td><td>${r.syzygos_arithmos_adeia_gamou || ''}</td><td class="label">Αρ. Παραβόλου</td><td>${r.syzygos_arithmos_paravolo || ''}</td></tr>
  </table>
  <div class="section">ΣΤΟΙΧΕΙΑ ΣΥΖΥΓΟΥ (ΓΥΝΑΙΚΑ)</div>
  <table>
    <tr><td class="label">Επώνυμο</td><td>${r.syzygou_eponymo || ''}</td><td class="label">Όνομα</td><td>${r.syzygou_onoma || ''}</td></tr>
    <tr><td class="label">Επάγγελμα</td><td>${r.syzygou_epaggelma || ''}</td><td class="label">ΑΦΜ</td><td>${r.syzygou_afm || ''}</td></tr>
    <tr><td class="label">ΑΜΚΑ</td><td>${r.syzygou_amka || ''}</td><td class="label">Ιθαγένεια</td><td>${r.syzygou_ithagenia || ''}</td></tr>
    <tr><td class="label">Χρον. Γέννησης</td><td>${r.syzygou_chronologia_gennisis || ''}</td><td class="label">Τόπος Γέννησης</td><td>${r.syzygou_topos_gennisis || ''}</td></tr>
    <tr><td class="label">Πατέρας</td><td>${r.syzygou_pateras || ''}</td><td class="label">Μητέρα</td><td>${r.syzygou_mitera || ''}</td></tr>
    <tr><td class="label">Οικογ. Κατάσταση</td><td>${r.syzygou_oik_katastasi || ''}</td><td class="label">Βαθμός Γάμου</td><td>${r.syzygou_vathmos_gamou || ''}</td></tr>
    <tr><td class="label">Αρ. Άδειας Γάμου</td><td>${r.syzygou_arithmos_adeia_gamou || ''}</td><td class="label">Αρ. Παραβόλου</td><td>${r.syzygou_arithmos_paravolo || ''}</td></tr>
  </table>
  <div style="margin-top:40px;display:flex;justify-content:space-around;text-align:center">
    <div>Οι Σύζυγοι<br/><br/>(υπογραφή)</div>
    <div>Οι Παράνυμφοι<br/><br/>(υπογραφή)</div>
    <div>Ο Ιερέας<br/><br/>(υπογραφή και σφραγίδα)</div>
  </div>
</body></html>`

  return (
    <div className="max-w-5xl">
      <div className="flex items-center gap-4 mb-6 flex-wrap">
        <button onClick={() => navigate('/marriage')} className="btn-secondary">← Πίσω</button>
        <h2 className="page-title mb-0">Δήλωση Γάμου #{id}</h2>
        <div className="ml-auto flex gap-2">
          <button onClick={() => navigate(`/marriage/${id}/edit`)} className="btn-primary">Επεξεργασία</button>
          <button onClick={() => exportPdf(generateHtml(), `gamos-${id}.pdf`)} className="btn-secondary">📄 PDF</button>
        </div>
      </div>
      <div className="card">
        <h3 className="section-title">Στοιχεία Εκκλησίας</h3>
        {row('Ιερά Μητρόπολη', r.iera_mitropoli)}
        {row('Ιερός Ναός', r.ieros_naos)}
        {row('Αριθμ. Πράξης Γάμου', r.arithmos_lixiarkis_praxis)}
        {row('Ιερέας', r.iereus)}
        {row('Ημερομηνία Γάμου', `${r.gamos_imera || ''} ${r.gamos_minas || ''} ${r.gamos_etos || ''} ${r.gamos_ora || ''}`)}

        <h3 className="section-title mt-4">Σύζυγος (Άνδρας)</h3>
        {row('Επώνυμο', r.syzygos_eponymo)}
        {row('Όνομα', r.syzygos_onoma)}
        {row('Επάγγελμα', r.syzygos_epaggelma)}
        {row('ΑΦΜ', r.syzygos_afm)}
        {row('ΑΜΚΑ', r.syzygos_amka)}
        {row('Χρον. Γέννησης', r.syzygos_chronologia_gennisis)}
        {row('Τόπος Γέννησης', r.syzygos_topos_gennisis)}
        {row('Πατέρας', r.syzygos_pateras)}
        {row('Μητέρα', r.syzygos_mitera)}
        {row('Οικογ. Κατάσταση', r.syzygos_oik_katastasi)}
        {row('Βαθμός Γάμου', r.syzygos_vathmos_gamou)}

        <h3 className="section-title mt-4">Σύζυγος (Γυναίκα)</h3>
        {row('Επώνυμο', r.syzygou_eponymo)}
        {row('Όνομα', r.syzygou_onoma)}
        {row('Επάγγελμα', r.syzygou_epaggelma)}
        {row('ΑΦΜ', r.syzygou_afm)}
        {row('ΑΜΚΑ', r.syzygou_amka)}
        {row('Χρον. Γέννησης', r.syzygou_chronologia_gennisis)}
        {row('Τόπος Γέννησης', r.syzygou_topos_gennisis)}
        {row('Πατέρας', r.syzygou_pateras)}
        {row('Μητέρα', r.syzygou_mitera)}
        {row('Οικογ. Κατάσταση', r.syzygou_oik_katastasi)}
        {row('Βαθμός Γάμου', r.syzygou_vathmos_gamou)}
      </div>
    </div>
  )
}
