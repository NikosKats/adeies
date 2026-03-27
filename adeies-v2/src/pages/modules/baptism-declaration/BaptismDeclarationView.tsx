import { useModuleView } from '../../../components/useModule'

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

  const generateHtml = () => `
<!DOCTYPE html>
<html lang="el">
<head>
  <meta charset="UTF-8"/>
  <style>
    body { font-family: Arial, sans-serif; font-size: 12pt; margin: 2cm; }
    h1 { text-align: center; font-size: 14pt; }
    h2 { text-align: center; font-size: 13pt; }
    .field { margin: 6px 0; }
    .label { font-weight: bold; }
    .section { margin-top: 16px; border-top: 1px solid #333; padding-top: 8px; }
    .signatures { display: flex; justify-content: space-around; margin-top: 40px; }
    .sig { text-align: center; }
  </style>
</head>
<body>
  <h1>ΙΕΡΑ ΜΗΤΡΟΠΟΛΙΣ ${r.iera_mitropolis || ''}</h1>
  <h2>ΙΕΡΟΣ ΝΑΟΣ ${r.ieros_naos || ''}</h2>
  <p style="text-align:right">Αριθμ.Πρωτ.: <b>${r.arithmos_protokolou || ''}</b></p>
  <h2>ΔΗΛΩΣΗ ΒΑΠΤΙΣΕΩΣ</h2>
  <div class="field">
    Ὁ ὑπογεγραμμένος Ἱερεύς <b>${r.efimerios || ''}</b>,
    Ἐφημέριος τοῦ Ἱεροῦ Ναοῦ <b>${r.efimerios_naou || ''}</b>,
    δηλῶ ὃτι σήμερον τήν <b>${r.baptism_imera || ''}</b> τοῦ μηνός <b>${r.baptism_minas || ''}</b>
    τοῦ ἒτους <b>${r.baptism_etos || ''}</b>, ἡμέραν <b>${r.baptism_imera_evdomadas || ''}</b>,
    ἐν τῶ Ἱερῶ Ναῶ <b>${r.baptism_naos || ''}</b>
  </div>
  <h2 style="margin-top:16px">ΕΒΑΠΤΙΣΑ</h2>
  <div class="field">
    κατά τοὺς Ἱερούς Κανόνας τῆς Ὁρθοδόξου Ἀνατολικῆς Ἐκκλησίας
    τό τέκνον τοῦ <b>${r.pateras_onoma || ''}</b>
    καί τῆς <b>${r.mitera_onoma || ''}</b> τό γένος <b>${r.mitera_eponymo_genous || ''}</b>,
    κατοίκων <b>${r.katoikia || ''}</b> ὁδός <b>${r.odos || ''}</b> ἀριθμ. <b>${r.arithmos_odou || ''}</b>,
    γεννηθέν τῆ <b>${r.gennitiki_imera || ''}</b> ἔν <b>${r.gennitiki_poli || ''}</b>,
    κατά τήν ὑπ'ἀριθμ. <b>${r.lixiarxeio_praxis_arithmos || ''}</b> τόμος <b>${r.lixiarxeio_tomos || ''}</b>
    τοῦ <b>${r.lixiarxeio_etos || ''}</b> ἔτους πρᾶξιν Γεννήσεως τοῦ κ. Ληξιάρχου <b>${r.lixiarchos || ''}</b>,
  </div>
  <div class="field" style="text-align:center; font-size:14pt; margin:16px 0">
    Ὀνομασθέν <b>${r.onoma_baptisthen || ''}</b>
  </div>
  <div class="field">
    ὑπό τοῦ/ης ἀναδεξαμένου/ης αὐτό ἐκ τῆς Ἱερᾶς Κολυμβήθρας
    <b>${r.anadexamenos || ''}</b>,
    κατοίκου <b>${r.anadexamenos_katoikia || ''}</b>
    ὁδός <b>${r.anadexamenos_odos || ''}</b> ἀριθμ. <b>${r.anadexamenos_arithmos || ''}</b>
  </div>
  <div class="signatures">
    <div class="sig">
      <p>Ο ΕΦΗΜΕΡΙΟΣ</p>
      <br/><br/>
      <p>${r.efimerios_ypografi || ''}</p>
    </div>
    <div class="sig">
      <p>Ο ΠΑΤΗΡ ΚΑΙ Η ΜΗΤΗΡ</p>
      <br/><br/>
      <p>${r.pateras_ypografi || ''}</p>
      <p>${r.mitera_ypografi || ''}</p>
    </div>
    <div class="sig">
      <p>Ο ΑΝΑΔΟΧΟΣ</p>
      <br/><br/>
      <p>${r.anadoxos_ypografi || ''}</p>
    </div>
  </div>
</body>
</html>`

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
