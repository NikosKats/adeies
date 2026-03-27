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

export default function BaptismDeclarationView() {
  const { record, loading, navigate, id, exportPdf } = useModuleView('baptism_declarations')

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

  <div class="doc-title">Δήλωσις Βαπτίσεως</div>
  <hr class="title-rule"/>

  <p class="body-text">
    Ὁ ὑπογεγραμμένος Ἱερεύς <b>${r.efimerios || ''}</b>,
    Ἐφημέριος τοῦ Ἱεροῦ Ναοῦ <b>${r.efimerios_naou || ''}</b>,
    δηλῶ ὃτι σήμερον τήν <b>${r.baptism_imera || ''}</b> τοῦ μηνός <b>${r.baptism_minas || ''}</b>
    τοῦ ἒτους <b>${r.baptism_etos || ''}</b>, ἡμέραν <b>${r.baptism_imera_evdomadas || ''}</b>,
    ἐν τῷ Ἱερῷ Ναῷ <b>${r.baptism_naos || ''}</b>
  </p>

  <div class="center-emphasis">— ΕΒΑΠΤΙΣΑ —</div>

  <p class="body-text">
    κατά τοὺς Ἱερούς Κανόνας τῆς Ὀρθοδόξου Ἀνατολικῆς Ἐκκλησίας
    τό τέκνον τοῦ <b>${r.pateras_onoma || ''}</b>
    καί τῆς <b>${r.mitera_onoma || ''}</b> τό γένος <b>${r.mitera_eponymo_genous || ''}</b>,
    κατοίκων <b>${r.katoikia || ''}</b>, ὁδός <b>${r.odos || ''}</b> ἀριθμ. <b>${r.arithmos_odou || ''}</b>,
    γεννηθέν τῇ <b>${r.gennitiki_imera || ''}</b> ἐν <b>${r.gennitiki_poli || ''}</b>,
    κατά τήν ὑπ' ἀριθμ. <b>${r.lixiarxeio_praxis_arithmos || ''}</b>,
    τόμος <b>${r.lixiarxeio_tomos || ''}</b> τοῦ <b>${r.lixiarxeio_etos || ''}</b> ἔτους
    πρᾶξιν Γεννήσεως τοῦ κ. Ληξιάρχου <b>${r.lixiarchos || ''}</b>.
  </p>

  <div class="center-emphasis">✦ &nbsp; ${r.onoma_baptisthen || ''} &nbsp; ✦</div>

  <p class="body-text">
    ὑπό τοῦ/ης ἀναδεξαμένου/ης αὐτό ἐκ τῆς Ἱερᾶς Κολυμβήθρας
    <b>${r.anadexamenos || ''}</b>,
    κατοίκου <b>${r.anadexamenos_katoikia || ''}</b>,
    ὁδός <b>${r.anadexamenos_odos || ''}</b> ἀριθμ. <b>${r.anadexamenos_arithmos || ''}</b>.
  </p>

  <div class="signatures">
    <div class="sig-block">
      <div class="sig-title">Ο Εφημέριος</div>
      <div class="sig-line"></div>
      <div class="sig-name">${r.efimerios_ypografi || ''}</div>
    </div>
    <div class="sig-block">
      <div class="sig-title">Ο Πατήρ &amp; ἡ Μήτηρ</div>
      <div class="sig-line"></div>
      <div class="sig-name">${r.pateras_ypografi || ''}</div>
      <div class="sig-name">${r.mitera_ypografi || ''}</div>
    </div>
    <div class="sig-block">
      <div class="sig-title">Ο Ανάδοχος</div>
      <div class="sig-line"></div>
      <div class="sig-name">${r.anadoxos_ypografi || ''}</div>
    </div>
  </div>

</div>
</body></html>`

  return (
    <div className="max-w-4xl">
      <div className="flex items-center gap-4 mb-6 flex-wrap">
        <button onClick={() => navigate('/baptism-declaration')} className="btn-secondary">← Πίσω</button>
        <h2 className="page-title mb-0">Δήλωση Βαπτίσεως #{id}</h2>
        <div className="ml-auto flex gap-2">
          <button onClick={() => navigate(`/baptism-declaration/${id}/edit`)} className="btn-primary">Επεξεργασία</button>
          <button onClick={() => exportPdf(generateHtml(), `baptism-${id}.pdf`)} className="btn-secondary">📄 Εξαγωγή PDF</button>
        </div>
      </div>

      <div className="card">
        <h3 className="section-title">Στοιχεία Εκκλησίας</h3>
        {row('Ιερά Μητρόπολις', r.iera_mitropolis)}
        {row('Ιερός Ναός', r.ieros_naos)}
        {row('Αριθμ. Πρωτοκόλλου', r.arithmos_protokolou)}
        {row('Εφημέριος', r.efimerios)}

        <h3 className="section-title mt-4">Βαπτίστηκε</h3>
        {row('Ημέρα', r.baptism_imera)}
        {row('Μήνας', r.baptism_minas)}
        {row('Έτος', r.baptism_etos)}
        {row('Ναός Βαπτίσεως', r.baptism_naos)}

        <h3 className="section-title mt-4">Βαπτισθείς</h3>
        {row('Όνομα', r.onoma_baptisthen)}
        {row('Πατέρας', r.pateras_onoma)}
        {row('Μητέρα', r.mitera_onoma)}
        {row('Ημερομηνία Γέννησης', r.gennitiki_imera)}
        {row('Πόλη Γέννησης', r.gennitiki_poli)}

        <h3 className="section-title mt-4">Ανάδοχος</h3>
        {row('Ανάδοχος', r.anadexamenos)}
        {row('Κατοικία', r.anadexamenos_katoikia)}
      </div>
    </div>
  )
}
