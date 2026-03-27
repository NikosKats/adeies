import { useModuleView } from '../../../components/useModule'

function row(label: string, value: string | undefined) {
  return (
    <div className="flex gap-2 py-1 border-b border-gray-100">
      <span className="text-sm font-medium text-gray-600 w-56 flex-shrink-0">{label}:</span>
      <span className="text-sm text-gray-900">{value || '—'}</span>
    </div>
  )
}

export default function CertificateAView() {
  const { record, loading, navigate, id, exportPdf } = useModuleView('certificates_a')

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
  <h1>ΠΙΣΤΟΠΟΙΗΤΙΚΟΝ ΑΓΑΜΙΑΣ (ΤΥΠΟΣ Α΄)</h1>
  <div class="field">
    Ὁ ὑπογεγραμμένος <b>${r.efimerios || ''}</b>,
    Ἐφημέριος τοῦ Ἱεροῦ Ναοῦ <b>${r.efimerios_naou || ''}</b>,
    πιστοποιῶ ὑπευθύνως ὃτι:
  </div>
  <div class="field">
    ὁ ἢ ἡ <b>${r.agamos_onoma || ''}</b>,
    τοῦ <b>${r.patros || ''}</b> καί τῆς <b>${r.mitros || ''}</b> τό γένος,
    γεννηθεί <b>${r.gennitiki_imera || ''}</b> ἐν <b>${r.gennitiki_poli || ''}</b>,
    τό ἒτος <b>${r.etos_genniseos || ''}</b>,
  </div>
  <div class="field">
    καί ἐν τῆ ἡμετέρα ἐνορία διαμέν <b>${r.katoikia_apo || ''}</b> ἀπό τοῦ ἒτους <b>${r.katoikia_etos || ''}</b>
    (ὁδός <b>${r.odos || ''}</b> ἀρ. <b>${r.arithmos_odou || ''}</b>),
    ἐτῶν <b>${r.ilikia || ''}</b>, ἐπαγγέλματος <b>${r.epaggelma || ''}</b>,
    καί χριστιαν <b>${r.christianos || ''}</b> ὀρθόδοξος,
    τυγχάνει ἂγαμος <b>${r.agamos_kata || ''}</b>
    καί δύναται νά συνάψη γάμον <b>${r.dynatos_gamos || ''}</b>.
  </div>
  <div class="field">
    Χορηγεῖται τό παρόν διά τήν ἒκδοσιν ἀδείας γάμου τ <b>${r.ekdosi_adeia || ''}</b>.
  </div>
  <div style="text-align:right; margin-top:20px">
    Ἐν <b>${r.topos_ekdosis || ''}</b>, τῆ <b>${r.imera_ekdosis || ''}</b> 20<b>${r.etos_ekdosis || ''}</b>
  </div>
  <div style="text-align:center; margin-top:50px"><b>Ο ΕΦΗΜΕΡΙΟΣ</b></div>
</body></html>`

  return (
    <div className="max-w-4xl">
      <div className="flex items-center gap-4 mb-6 flex-wrap">
        <button onClick={() => navigate('/certificate-a')} className="btn-secondary">← Πίσω</button>
        <h2 className="page-title mb-0">Πιστοποιητικό Αγαμίας Α΄ #{id}</h2>
        <div className="ml-auto flex gap-2">
          <button onClick={() => navigate(`/certificate-a/${id}/edit`)} className="btn-primary">Επεξεργασία</button>
          <button onClick={() => exportPdf(generateHtml(), `agamia-a-${id}.pdf`)} className="btn-secondary">📄 PDF</button>
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
        {row('Ημερομηνία Γέννησης', r.gennitiki_imera)}
        {row('Τόπος Γέννησης', r.gennitiki_poli)}
        {row('Έτος Γέννησης', r.etos_genniseos)}
        {row('Διαμένει στην Ενορία από', r.katoikia_etos)}
        {row('Οδός/Αριθμός', `${r.odos || ''} ${r.arithmos_odou || ''}`)}
        <h3 className="section-title mt-4">Έκδοση</h3>
        {row('Δύναται να συνάψη γάμον', r.dynatos_gamos)}
        {row('Για έκδοση άδειας γάμου', r.ekdosi_adeia)}
        {row('Τόπος & Ημερομηνία', `${r.topos_ekdosis || ''} ${r.imera_ekdosis || ''} 20${r.etos_ekdosis || ''}`)}
      </div>
    </div>
  )
}
