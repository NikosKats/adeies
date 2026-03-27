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

export default function BaptismSpecificationView() {
  const { record, loading, navigate, id, exportPdf } = useModuleView('baptism_specifications')

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

  <div class="doc-title">Πράξις Προσδιορισμού</div>
  <div class="doc-subtitle">Τελέσεως τοῦ Μυστηρίου τοῦ Βαπτίσματος</div>
  <hr class="title-rule"/>

  <p class="body-text">
    Σήμερον τήν <b>${r.simeron_imera || ''}</b> τοῦ μηνός <b>${r.simeron_minas || ''}</b>
    τοῦ ἔτους <b>${r.simeron_etos || ''}</b>, ἐμφανίσθησαν ἐνώπιόν μου οἱ γονεῖς:
  </p>

  <div class="section">
    <div class="section-title">Γονείς</div>
    <table class="info-grid">
      <tr>
        <td class="lbl">1. Γονέας</td>
        <td><b>${r.goneis_1 || ''}</b></td>
        <td class="lbl">Αρ. Ταυτ.</td>
        <td>${r.goneis_1_id_arithmos || ''} &nbsp; (${r.goneis_1_id_ekdosi || ''})</td>
      </tr>
      <tr>
        <td class="lbl">2. Γονέας</td>
        <td><b>${r.goneis_2 || ''}</b></td>
        <td class="lbl">Αρ. Ταυτ.</td>
        <td>${r.goneis_2_id_arithmos || ''} &nbsp; (${r.goneis_2_id_ekdosi || ''})</td>
      </tr>
    </table>
  </div>

  <div class="section">
    <div class="section-title">Στοιχεία Τέκνου</div>
    <table class="info-grid">
      <tr><td class="lbl">Ονομασθέν</td><td colspan="3"><b>${r.teknon_onoma || ''}</b></td></tr>
      <tr>
        <td class="lbl">Ημερομηνία Γέννησης</td>
        <td>${r.teknon_gennitiki_imera || ''} ${r.teknon_gennitiki_minas || ''} ${r.teknon_gennitiki_etos || ''}</td>
        <td class="lbl">Νοσοκομείο</td>
        <td>${r.teknon_nosokomeio || ''} (${r.teknon_nosokomeio_etos || ''})</td>
      </tr>
      <tr>
        <td class="lbl">Αρ. Πράξης Ληξ.</td>
        <td>${r.lixiarxeio_praxis_arithmos || ''}</td>
        <td class="lbl">Τόμος / Έτος</td>
        <td>${r.lixiarxeio_tomos || ''} / ${r.lixiarxeio_etos || ''}</td>
      </tr>
    </table>
  </div>

  <div class="section">
    <div class="section-title">Βάπτισμα</div>
    <table class="info-grid">
      <tr>
        <td class="lbl">Ημερομηνία</td>
        <td><b>${r.baptisma_imera || ''} ${r.baptisma_minas || ''} ${r.baptisma_etos || ''}</b></td>
        <td class="lbl">Κατοικία</td>
        <td>${r.katoikia_odos || ''}</td>
      </tr>
    </table>
  </div>

  <div class="section">
    <div class="section-title">Ανάδοχος</div>
    <table class="info-grid">
      <tr><td class="lbl">Ονοματεπώνυμο</td><td colspan="3"><b>${r.anadoxos || ''}</b></td></tr>
      <tr>
        <td class="lbl">Γαμοχρονολογία</td>
        <td>${r.anadoxos_gamochronologia || ''}</td>
        <td class="lbl">Ναός Γάμου</td>
        <td>${r.anadoxos_gamonaos || ''}</td>
      </tr>
    </table>
  </div>

  <div class="doc-footer">
    Ἐν <b>${r.topos_ypovrolis || ''}</b>,
    τῇ <b>${r.imera_ypovrolis || ''}</b> ${r.etos_ypovrolis || ''}
  </div>

  <div class="signatures" style="margin-top:30px">
    <div class="sig-block">
      <div class="sig-title">Ο Εφημέριος</div>
      <div class="sig-line"></div>
    </div>
    <div class="sig-block">
      <div class="sig-title">Ο Πατήρ &amp; ἡ Μήτηρ</div>
      <div class="sig-line"></div>
    </div>
  </div>

</div>
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
