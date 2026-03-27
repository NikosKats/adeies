import { useModuleView } from '../../../components/useModule'
import { pdfStyles } from '../../../utils/pdfStyles'

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

  const generateHtml = () => `<!DOCTYPE html>
<html lang="el"><head><meta charset="UTF-8"/>
<style>${pdfStyles}</style>
</head><body>
<div class="page">

  <div class="header">
    <span class="cross">✝</span>
    <div class="mitropolis">Ιερά Μητρόπολις ${r.iera_mitropolis || ''}</div>
    <div class="naos">Ενοριακός Ιερός Ναός ${r.ieros_naos || ''}</div>
  </div>

  <div class="protokolo">Αριθμ. Πρωτ.: <b>${r.arithmos_protokolou || ''}</b></div>

  <div class="doc-title">Πιστοποιητικόν Αγαμίας</div>
  <div class="doc-subtitle">Τύπος Β΄</div>
  <hr class="title-rule"/>

  <p class="body-text">
    Ὁ ὑπογεγραμμένος <b>${r.efimerios || ''}</b>,
    Ἐφημέριος τοῦ Ἱεροῦ Ναοῦ <b>${r.efimerios_naou || ''}</b>,
    βεβαιῶ ὃτι προσελθ<b>${r.proselthen || ''}</b> ἐνώπιόν μου
    ὁ ἢ ἡ <b>${r.agamos_onoma || ''}</b>,
  </p>

  <p class="body-text">
    τοῦ <b>${r.patros || ''}</b> καί τῆς <b>${r.mitros || ''}</b> τό γένος,
    γεννηθείς/εῖσα <b>${r.gennitiki_imera || ''}</b> ἐν <b>${r.gennitiki_poli || ''}</b>,
    τό ἔτος <b>${r.etos_genniseos || ''}</b>,
    ἐτῶν <b>${r.ilikia || ''}</b>, ἐπαγγέλματος <b>${r.epaggelma || ''}</b>.
  </p>

  <p class="body-text">
    ὑπέγραψε τήν συνημμένην δήλωσιν <b>${r.dilosi_imera || ''}</b>
  </p>

  <div class="section">
    <div class="section-title">Δήλωσις Μαρτύρων</div>
    <p class="body-text" style="text-indent:0">
      Δηλοῦμεν ὑπευθύνως ὃτι ὁ ἢ ἡ ἀνωτέρω διαμένει <b>${r.dilosi_katoikia || ''}</b>
      καί ἐπί τῆς ὁδοῦ <b>${r.dilosi_odos || ''}</b>
      τυγχάνει δέ ἄγαμος/η <b>${r.agamos_kata || ''}</b>
      καί δύναται νά συνάψῃ γάμον <b>${r.dynatos_gamos || ''}</b>.
    </p>
    <table class="info-grid" style="margin-top:8px">
      <tr>
        <td class="lbl">Μάρτυρας 1</td>
        <td><b>${r.martyras_1 || ''}</b></td>
        <td class="lbl">Αρ. Ταυτ.</td>
        <td>${r.martyras_1_id || ''} (${r.martyras_1_astynomia || ''})</td>
      </tr>
      <tr>
        <td class="lbl">Μάρτυρας 2</td>
        <td><b>${r.martyras_2 || ''}</b></td>
        <td class="lbl">Αρ. Ταυτ.</td>
        <td>${r.martyras_2_id || ''} (${r.martyras_2_astynomia || ''})</td>
      </tr>
    </table>
  </div>

  <p class="body-text" style="margin-top:12px">
    Χορηγεῖται τό παρόν διά τήν ἔκδοσιν ἀδείας γάμου τ<b>${r.ekdosi_adeia || ''}</b>.
  </p>

  <div class="doc-footer">
    Ἐν <b>${r.topos_ekdosis || ''}</b>,
    τῇ <b>${r.imera_ekdosis || ''}</b> 20<b>${r.etos_ekdosis || ''}</b>
  </div>

  <div class="signatures">
    <div class="sig-block">
      <div class="sig-title">Μάρτυρες (Υπογραφαί)</div>
      <div class="sig-line"></div>
      <div class="sig-name">1. ${r.martyras_ypografi_1 || ''}</div>
      <div style="margin-top:16px"><div class="sig-line"></div></div>
      <div class="sig-name">2. ${r.martyras_ypografi_2 || ''}</div>
    </div>
    <div class="sig-block">
      <div class="sig-title">Ο Εφημέριος</div>
      <div class="sig-line"></div>
    </div>
  </div>

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
