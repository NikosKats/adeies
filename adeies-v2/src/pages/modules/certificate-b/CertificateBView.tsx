import { useModuleView } from '../../../components/useModule'

function row(label: string, value: string | undefined) {
  return (
    <div className="flex gap-2 py-1 border-b border-gray-100">
      <span className="text-sm font-medium text-gray-600 w-56 flex-shrink-0">{label}:</span>
      <span className="text-sm text-gray-900">{value || '—'}</span>
    </div>
  )
}

export default function CertificateBView() {
  const { record, loading, navigate, id, exportPdf } = useModuleView('certificates_b')

  if (loading) return <div className="text-gray-500">Φόρτωση...</div>
  if (!record) return <div className="text-red-500">Η εγγραφή δεν βρέθηκε.</div>

  const r = record

  const generateHtml = () => `
<!DOCTYPE html><html lang="el"><head><meta charset="UTF-8"/>
<style>body{font-family:Arial,sans-serif;font-size:12pt;margin:2cm;}h1,h2{text-align:center;}.field{margin:8px 0;line-height:1.8;}</style>
</head><body>
  <h2>ΙΕΡΑ ΜΗΤΡΟΠΟΛΙΣ ${r.iera_mitropolis || ''}</h2>
  <h2>ΕΝΟΡΙΑΚΟΣ ΙΕΡΟΣ ΝΑΟΣ ${r.ieros_naos || ''}</h2>
  <p style="text-align:right">Αριθμ.Πρωτ.: <b>${r.arithmos_protokolou || ''}</b></p>
  <h1>ΠΙΣΤΟΠΟΙΗΤΙΚΟΝ ΑΓΑΜΙΑΣ (ΤΥΠΟΣ Β΄)</h1>
  <div class="field">
    Ὁ ὑπογεγραμμένος <b>${r.efimerios || ''}</b>,
    Ἐφημέριος τοῦ Ἱεροῦ Ναοῦ <b>${r.efimerios_naou || ''}</b>,
    βεβαιῶ ὃτι προσελθ <b>${r.proselthen || ''}</b> ἐνώπιόν μου
    ὁ ἢ ἡ <b>${r.agamos_onoma || ''}</b>,
  </div>
  <div class="field">
    τοῦ <b>${r.patros || ''}</b> καί τῆς <b>${r.mitros || ''}</b> τό γένος,
    γεννηθεί <b>${r.gennitiki_imera || ''}</b> ἐν <b>${r.gennitiki_poli || ''}</b>,
    τό ἒτος <b>${r.etos_genniseos || ''}</b>,
    ἐτῶν <b>${r.ilikia || ''}</b>, ἐπαγγέλματος <b>${r.epaggelma || ''}</b>.
  </div>
  <div class="field">ὑπέγραψε τήν συνημμένην δήλωσιν <b>${r.dilosi_imera || ''}</b></div>
  <h3>Οἲτινες προέβησαν εἰς τήν δήλωσιν:</h3>
  <div class="field">
    Δηλοῦμεν ὑπευθύνως ὃτι ὁ ἢ ἡ ἀνωτέρω διαμένει <b>${r.dilosi_katoikia || ''}</b> καί ἐπί τῆς ὁδοῦ <b>${r.dilosi_odos || ''}</b>
    τυγχάνει δέ ἂγαμος <b>${r.agamos_kata || ''}</b> καί δύναται νά συνάψη γάμον <b>${r.dynatos_gamos || ''}</b>.
  </div>
  <div class="field">Χορηγεῖται τό παρόν διά τήν ἒκδοσιν ἀδείας γάμου τ <b>${r.ekdosi_adeia || ''}</b>.</div>
  <div style="display:flex;justify-content:space-around;margin-top:30px;text-align:center">
    <div>ΟΙ ΜΑΡΤΥΡΕΣ (Υπογραφαί)<br/>1. <b>${r.martyras_ypografi_1 || ''}</b><br/>2. <b>${r.martyras_ypografi_2 || ''}</b></div>
    <div>Ο ΕΦΗΜΕΡΙΟΣ<br/><br/><br/></div>
  </div>
  <div style="text-align:right; margin-top:20px">
    Ἐν <b>${r.topos_ekdosis || ''}</b>, τῆ <b>${r.imera_ekdosis || ''}</b> 20<b>${r.etos_ekdosis || ''}</b>
  </div>
</body></html>`

  return (
    <div className="max-w-4xl">
      <div className="flex items-center gap-4 mb-6 flex-wrap">
        <button onClick={() => navigate('/certificate-b')} className="btn-secondary">← Πίσω</button>
        <h2 className="page-title mb-0">Πιστοποιητικό Αγαμίας Β΄ #{id}</h2>
        <div className="ml-auto flex gap-2">
          <button onClick={() => navigate(`/certificate-b/${id}/edit`)} className="btn-primary">Επεξεργασία</button>
          <button onClick={() => exportPdf(generateHtml(), `agamia-b-${id}.pdf`)} className="btn-secondary">📄 PDF</button>
        </div>
      </div>
      <div className="card">
        <h3 className="section-title">Στοιχεία Εκκλησίας</h3>
        {row('Ιερά Μητρόπολις', r.iera_mitropolis)}
        {row('Ιερός Ναός', r.ieros_naos)}
        {row('Αριθμ. Πρωτοκόλλου', r.arithmos_protokolou)}
        {row('Εφημέριος', r.efimerios)}
        <h3 className="section-title mt-4">Στοιχεία Αγάμου</h3>
        {row('Ονοματεπώνυμο', r.agamos_onoma)}
        {row('Πατρός', r.patros)}
        {row('Μητρός', r.mitros)}
        {row('Ηλικία', r.ilikia)}
        {row('Επάγγελμα', r.epaggelma)}
        {row('Ημερ. Γέννησης', r.gennitiki_imera)}
        {row('Τόπος Γέννησης', r.gennitiki_poli)}
        <h3 className="section-title mt-4">Μάρτυρες</h3>
        {row('Μάρτυρας 1', r.martyras_1)}
        {row('Ταυτότητα 1', r.martyras_1_id)}
        {row('Μάρτυρας 2', r.martyras_2)}
        {row('Ταυτότητα 2', r.martyras_2_id)}
        <h3 className="section-title mt-4">Έκδοση</h3>
        {row('Δύναται να συνάψη γάμον', r.dynatos_gamos)}
        {row('Τόπος & Ημερομηνία', `${r.topos_ekdosis || ''} ${r.imera_ekdosis || ''} 20${r.etos_ekdosis || ''}`)}
      </div>
    </div>
  )
}
