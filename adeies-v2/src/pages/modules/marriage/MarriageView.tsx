import { useModuleView } from '../../../components/useModule'
import { pdfStyles } from '../../../utils/pdfStyles'

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

  const generateHtml = () => `<!DOCTYPE html>
<html lang="el"><head><meta charset="UTF-8"/>
<style>
${pdfStyles}
.couple-grid {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 0 24px;
  margin: 10px 0;
}
.couple-col-header {
  font-size: 9.5pt;
  font-weight: bold;
  letter-spacing: 0.08em;
  text-transform: uppercase;
  color: #2c3e6b;
  border-bottom: 1px solid #2c3e6b;
  padding-bottom: 3px;
  margin-bottom: 6px;
}
.couple-field { font-size: 10pt; margin-bottom: 4px; }
.couple-field .lbl { color: #555; font-size: 9pt; display: block; }
.couple-field b { font-size: 10.5pt; }
</style>
</head><body>
<div class="page">

  <div class="header">
    <span class="cross">✝</span>
    <div class="mitropolis">Ιερά Μητρόπολη ${r.iera_mitropoli || ''}</div>
    <div class="naos">Ενοριακός Ιερός Ναός ${r.ieros_naos || ''}</div>
  </div>

  <div class="protokolo">
    Αρ. Ληξ. Πράξης: <b>${r.arithmos_lixiarkis_praxis || ''}</b> &nbsp;|&nbsp;
    Τόμος: <b>${r.tomos || ''}</b> &nbsp;|&nbsp;
    Έτος: <b>${r.etos || ''}</b>
  </div>

  <div class="doc-title">Δήλωσις Τελέσεως Θρησκευτικοῦ Γάμου</div>
  <hr class="title-rule"/>

  <p class="body-text">
    Ὁ ὑπογεγραμμένος Ἱερεύς <b>${r.iereus || ''}</b>
    (ἐνιπορίας: <b>${r.iereus_eniporias || ''}</b>),
    δηλῶ ὅτι σήμερα <b>${r.gamos_imera || ''} ${r.gamos_minas || ''} ${r.gamos_etos || ''}</b>
    ὥρα <b>${r.gamos_ora || ''}</b>, ἐν τῷ Ἱερῷ Ναῷ <b>${r.ieros_naos || ''}</b>
    (${r.dimotiko_topiko || ''}, Δῆμος ${r.dimos_dimotiki_enotita || ''}, Νομός ${r.nomos || ''}),
    ἐτέλεσα τό Μυστήριον τοῦ Γάμου τῶν κάτωθι:
  </p>

  <div class="section">
    <div class="couple-grid">
      <div>
        <div class="couple-col-header">Σύζυγος (Άνδρας)</div>
        <div class="couple-field"><span class="lbl">Επώνυμο &amp; Όνομα</span><b>${r.syzygos_eponymo || ''} ${r.syzygos_onoma || ''}</b></div>
        <div class="couple-field"><span class="lbl">Επάγγελμα</span>${r.syzygos_epaggelma || ''}</div>
        <div class="couple-field"><span class="lbl">Θρήσκευμα</span>${r.syzygos_thriskevma || ''}</div>
        <div class="couple-field"><span class="lbl">Ιθαγένεια</span>${r.syzygos_ithagenia || ''}</div>
        <div class="couple-field"><span class="lbl">ΑΦΜ / ΑΜΚΑ</span>${r.syzygos_afm || ''} / ${r.syzygos_amka || ''}</div>
        <div class="couple-field"><span class="lbl">Χρον. Γέννησης</span>${r.syzygos_chronologia_gennisis || ''}</div>
        <div class="couple-field"><span class="lbl">Τόπος Γέννησης</span>${r.syzygos_topos_gennisis || ''}, ${r.syzygos_nomos_gennisis || ''}</div>
        <div class="couple-field"><span class="lbl">Πατέρας</span>${r.syzygos_pateras || ''}</div>
        <div class="couple-field"><span class="lbl">Μητέρα</span>${r.syzygos_mitera || ''}</div>
        <div class="couple-field"><span class="lbl">Οικογ. Κατάσταση</span>${r.syzygos_oik_katastasi || ''}</div>
        <div class="couple-field"><span class="lbl">Βαθμός Γάμου</span>${r.syzygos_vathmos_gamou || ''}</div>
        <div class="couple-field"><span class="lbl">Αρ. Άδειας Γάμου</span>${r.syzygos_arithmos_adeia_gamou || ''}</div>
        <div class="couple-field"><span class="lbl">Αρ. Παραβόλου</span>${r.syzygos_arithmos_paravolo || ''}</div>
      </div>
      <div>
        <div class="couple-col-header">Σύζυγος (Γυναίκα)</div>
        <div class="couple-field"><span class="lbl">Επώνυμο &amp; Όνομα</span><b>${r.syzygou_eponymo || ''} ${r.syzygou_onoma || ''}</b></div>
        <div class="couple-field"><span class="lbl">Επάγγελμα</span>${r.syzygou_epaggelma || ''}</div>
        <div class="couple-field"><span class="lbl">Θρήσκευμα</span>${r.syzygou_thriskevma || ''}</div>
        <div class="couple-field"><span class="lbl">Ιθαγένεια</span>${r.syzygou_ithagenia || ''}</div>
        <div class="couple-field"><span class="lbl">ΑΦΜ / ΑΜΚΑ</span>${r.syzygou_afm || ''} / ${r.syzygou_amka || ''}</div>
        <div class="couple-field"><span class="lbl">Χρον. Γέννησης</span>${r.syzygou_chronologia_gennisis || ''}</div>
        <div class="couple-field"><span class="lbl">Τόπος Γέννησης</span>${r.syzygou_topos_gennisis || ''}, ${r.syzygou_nomos_gennisis || ''}</div>
        <div class="couple-field"><span class="lbl">Πατέρας</span>${r.syzygou_pateras || ''}</div>
        <div class="couple-field"><span class="lbl">Μητέρα</span>${r.syzygou_mitera || ''}</div>
        <div class="couple-field"><span class="lbl">Οικογ. Κατάσταση</span>${r.syzygou_oik_katastasi || ''}</div>
        <div class="couple-field"><span class="lbl">Βαθμός Γάμου</span>${r.syzygou_vathmos_gamou || ''}</div>
        <div class="couple-field"><span class="lbl">Αρ. Άδειας Γάμου</span>${r.syzygou_arithmos_adeia_gamou || ''}</div>
        <div class="couple-field"><span class="lbl">Αρ. Παραβόλου</span>${r.syzygou_arithmos_paravolo || ''}</div>
      </div>
    </div>
  </div>

  <div class="section">
    <div class="section-title">Κατοικία Ζεύγους</div>
    <table class="info-grid">
      <tr>
        <td class="lbl">Κατοικία</td>
        <td>${r.zeygos_katikia || ''} ${r.zeygos_katikia_2 || ''}</td>
        <td class="lbl">Δήμος</td>
        <td>${r.zeygos_dimos || ''} ${r.zeygos_dimos_2 || ''}</td>
      </tr>
      <tr>
        <td class="lbl">Νομός</td>
        <td>${r.zeygos_nomos || ''} ${r.zeygos_nomos_2 || ''}</td>
        <td class="lbl">Χώρα</td>
        <td>${r.zeygos_chora || ''} ${r.zeygos_chora_2 || ''}</td>
      </tr>
      <tr>
        <td class="lbl">Επώνυμο Τέκνων</td>
        <td colspan="3">${r.eponymo_teknon || ''} ${r.eponymo_teknon_2 || ''}</td>
      </tr>
    </table>
  </div>

  <div class="signatures">
    <div class="sig-block">
      <div class="sig-title">Οι Σύζυγοι</div>
      <div class="sig-line"></div>
    </div>
    <div class="sig-block">
      <div class="sig-title">Οι Παράνυμφοι</div>
      <div class="sig-line"></div>
    </div>
    <div class="sig-block">
      <div class="sig-title">Ο Ιερεύς</div>
      <div class="sig-line"></div>
      <div class="sig-name" style="font-size:8pt;color:#888">(υπογραφή &amp; σφραγίδα)</div>
    </div>
  </div>

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
