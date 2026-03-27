import { useEffect } from 'react'
import { useForm } from 'react-hook-form'
import { zodResolver } from '@hookform/resolvers/zod'
import { z } from 'zod'
import FormField from '../../../components/FormField'
import { useModuleForm } from '../../../components/useModule'

const s = z.string().default('')
const req = z.string().min(1, 'Υποχρεωτικό')

const schema = z.object({
  iera_mitropoli: req, arithmos_lixiarkis_praxis: s, tomos: s, etos: s,
  ieros_naos: req, dimotiko_topiko: s, dimos_dimotiki_enotita: s, nomos: s,
  arithmos_vivliou: s, iereus: req, iereus_eniporias: s,
  gamos_imera: s, gamos_minas: s, gamos_etos: s, gamos_ora: s,
  dogma: s, dogma_tagseis: s,
  syzygos_eponymo: req, syzygou_eponymo: req,
  syzygos_onoma: req, syzygou_onoma: req,
  syzygos_epaggelma: s, syzygou_epaggelma: s,
  syzygos_thriskevma: s, syzygou_thriskevma: s,
  syzygos_ithagenia: s, syzygou_ithagenia: s,
  syzygos_afm: s, syzygou_afm: s,
  syzygos_amka: s, syzygou_amka: s,
  syzygos_foreas_asfalisys: s, syzygou_foreas_asfalisys: s,
  syzygos_topos_gennisis: s, syzygou_topos_gennisis: s,
  syzygos_nomos_gennisis: s, syzygou_nomos_gennisis: s,
  syzygos_dimos_gennisis: s, syzygou_dimos_gennisis: s,
  syzygos_dimotiki_gennisis: s, syzygou_dimotiki_gennisis: s,
  syzygos_chora_gennisis: s, syzygou_chora_gennisis: s,
  syzygos_chronologia_gennisis: s, syzygou_chronologia_gennisis: s,
  syzygos_katikia_nomos: s, syzygou_katikia_nomos: s,
  syzygos_katikia_dimos: s, syzygou_katikia_dimos: s,
  syzygos_katikia_dimotiki: s, syzygou_katikia_dimotiki: s,
  syzygos_katikia_chora: s, syzygou_katikia_chora: s,
  syzygos_dimotis_dimos: s, syzygou_dimotis_dimos: s,
  syzygos_dimotis_nomos: s, syzygou_dimotis_nomos: s,
  syzygos_dimotis_arithmos: s, syzygou_dimotis_arithmos: s,
  syzygos_pateras: s, syzygou_pateras: s,
  syzygos_mitera: s, syzygou_mitera: s,
  zeygos_katikia: s, zeygos_katikia_2: s,
  zeygos_nomos: s, zeygos_nomos_2: s,
  zeygos_dimos: s, zeygos_dimos_2: s,
  zeygos_dimotiki: s, zeygos_dimotiki_2: s,
  zeygos_topiki: s, zeygos_topiki_2: s,
  zeygos_chora: s, zeygos_chora_2: s,
  eponymo_teknon: s, eponymo_teknon_2: s,
  syzygos_oik_katastasi: s, syzygou_oik_katastasi: s,
  syzygos_vathmos_gamou: s, syzygou_vathmos_gamou: s,
  syzygos_ekpaideusi: s, syzygou_ekpaideusi: s,
  syzygos_arithmos_adeia_gamou: s, syzygos_ieras_mitropoli_adeia: s,
  syzygou_arithmos_adeia_gamou: s, syzygou_ieras_mitropoli_adeia: s,
  syzygos_arithmos_paravolo: s, syzygou_arithmos_paravolo: s
})

type FormData = z.infer<typeof schema>

function TwoCol({ children }: { children: React.ReactNode }) {
  return <div className="grid grid-cols-2 gap-x-6">{children}</div>
}

export default function MarriageForm() {
  const { isEdit, defaultValues, submit, navigate } = useModuleForm('marriage_declarations')
  const { register, handleSubmit, formState: { errors }, reset } = useForm<FormData>({ resolver: zodResolver(schema) })

  useEffect(() => { if (defaultValues !== null) reset(defaultValues as FormData) }, [defaultValues, reset])
  if (defaultValues === null) return <div className="text-gray-500">Φόρτωση...</div>

  const onSubmit = handleSubmit((data) => submit(data, '/marriage'))

  return (
    <div className="max-w-5xl">
      <div className="flex items-center gap-4 mb-6">
        <button onClick={() => navigate('/marriage')} className="btn-secondary">← Πίσω</button>
        <h2 className="page-title mb-0">{isEdit ? 'Επεξεργασία' : 'Νέα'} Δήλωση Γάμου</h2>
      </div>

      <form onSubmit={onSubmit} className="card space-y-2">
        <h3 className="section-title">Στοιχεία Εκκλησίας</h3>
        <TwoCol>
          <FormField label="Ιερά Μητρόπολη" registration={register('iera_mitropoli')} error={errors.iera_mitropoli?.message} required />
          <FormField label="Ιερός Ναός" registration={register('ieros_naos')} error={errors.ieros_naos?.message} required />
          <FormField label="Αριθμ. Ληξ. Πράξης Γάμου" registration={register('arithmos_lixiarkis_praxis')} />
          <FormField label="Τόμος" registration={register('tomos')} />
          <FormField label="Έτος" registration={register('etos')} />
          <FormField label="Δημοτικό/Τοπικό Διαμέρισμα" registration={register('dimotiko_topiko')} />
          <FormField label="Δήμος/Δημοτική Ενότητα" registration={register('dimos_dimotiki_enotita')} />
          <FormField label="Νομός" registration={register('nomos')} />
          <FormField label="Αριθμ. Βιβλίου" registration={register('arithmos_vivliou')} />
          <FormField label="Ιερέας" registration={register('iereus')} error={errors.iereus?.message} required />
          <FormField label="Ιερέας Ενορίας" registration={register('iereus_eniporias')} />
        </TwoCol>

        <h3 className="section-title mt-4">Ημερομηνία & Τελεστής</h3>
        <div className="grid grid-cols-4 gap-x-6">
          <FormField label="Ημέρα" registration={register('gamos_imera')} />
          <FormField label="Μήνας" registration={register('gamos_minas')} />
          <FormField label="Έτος" registration={register('gamos_etos')} />
          <FormField label="Ώρα" registration={register('gamos_ora')} />
        </div>
        <TwoCol>
          <FormField label="Δόγμα" registration={register('dogma')} />
          <FormField label="Τάξη Δόγματος" registration={register('dogma_tagseis')} />
        </TwoCol>

        <h3 className="section-title mt-4">Στοιχεία Συζύγων</h3>
        <div className="bg-blue-50 p-3 rounded mb-2 text-xs text-blue-700 font-medium">Αριστερά: Σύζυγος (Άνδρας) — Δεξιά: Σύζυγος (Γυναίκα)</div>
        <TwoCol>
          <FormField label="1. Επώνυμο Συζύγου" registration={register('syzygos_eponymo')} error={errors.syzygos_eponymo?.message} required />
          <FormField label="1. Επώνυμο Συζύγου (Γυν.)" registration={register('syzygou_eponymo')} error={errors.syzygou_eponymo?.message} required />
          <FormField label="2. Όνομα Συζύγου" registration={register('syzygos_onoma')} error={errors.syzygos_onoma?.message} required />
          <FormField label="2. Όνομα Συζύγου (Γυν.)" registration={register('syzygou_onoma')} error={errors.syzygou_onoma?.message} required />
          <FormField label="3. Επάγγελμα" registration={register('syzygos_epaggelma')} />
          <FormField label="3. Επάγγελμα (Γυν.)" registration={register('syzygou_epaggelma')} />
          <FormField label="4. Θρήσκευμα & Δόγμα" registration={register('syzygos_thriskevma')} />
          <FormField label="4. Θρήσκευμα & Δόγμα (Γυν.)" registration={register('syzygou_thriskevma')} />
          <FormField label="5. Ιθαγένεια" registration={register('syzygos_ithagenia')} />
          <FormField label="5. Ιθαγένεια (Γυν.)" registration={register('syzygou_ithagenia')} />
          <FormField label="6. ΑΦΜ" registration={register('syzygos_afm')} />
          <FormField label="6. ΑΦΜ (Γυν.)" registration={register('syzygou_afm')} />
          <FormField label="7. ΑΜΚΑ" registration={register('syzygos_amka')} />
          <FormField label="7. ΑΜΚΑ (Γυν.)" registration={register('syzygou_amka')} />
          <FormField label="8. Φορείς Ασφάλισης" registration={register('syzygos_foreas_asfalisys')} />
          <FormField label="8. Φορείς Ασφάλισης (Γυν.)" registration={register('syzygou_foreas_asfalisys')} />
        </TwoCol>

        <h3 className="section-title mt-4">9. Τόπος Γέννησης</h3>
        <TwoCol>
          <FormField label="Τόπος Γέννησης Συζύγου" registration={register('syzygos_topos_gennisis')} />
          <FormField label="Τόπος Γέννησης (Γυν.)" registration={register('syzygou_topos_gennisis')} />
          <FormField label="Νομός Γέννησης" registration={register('syzygos_nomos_gennisis')} />
          <FormField label="Νομός Γέννησης (Γυν.)" registration={register('syzygou_nomos_gennisis')} />
          <FormField label="Δήμος Γέννησης" registration={register('syzygos_dimos_gennisis')} />
          <FormField label="Δήμος Γέννησης (Γυν.)" registration={register('syzygou_dimos_gennisis')} />
          <FormField label="Χώρα Εξωτερικού" registration={register('syzygos_chora_gennisis')} />
          <FormField label="Χώρα Εξωτερικού (Γυν.)" registration={register('syzygou_chora_gennisis')} />
        </TwoCol>

        <h3 className="section-title mt-4">10. Χρονολογία Γέννησης</h3>
        <TwoCol>
          <FormField label="Χρον. Γέννησης Συζύγου" registration={register('syzygos_chronologia_gennisis')} />
          <FormField label="Χρον. Γέννησης (Γυν.)" registration={register('syzygou_chronologia_gennisis')} />
        </TwoCol>

        <h3 className="section-title mt-4">11. Μόνιμη Κατοικία (προ γάμου)</h3>
        <TwoCol>
          <FormField label="Νομός Κατοικίας" registration={register('syzygos_katikia_nomos')} />
          <FormField label="Νομός Κατοικίας (Γυν.)" registration={register('syzygou_katikia_nomos')} />
          <FormField label="Δήμος Κατοικίας" registration={register('syzygos_katikia_dimos')} />
          <FormField label="Δήμος Κατοικίας (Γυν.)" registration={register('syzygou_katikia_dimos')} />
          <FormField label="Χώρα Εξωτερικού" registration={register('syzygos_katikia_chora')} />
          <FormField label="Χώρα Εξωτερικού (Γυν.)" registration={register('syzygou_katikia_chora')} />
        </TwoCol>

        <h3 className="section-title mt-4">12-15. Δημοτολόγιο & Γονείς</h3>
        <TwoCol>
          <FormField label="12. Δήμος Δημότης" registration={register('syzygos_dimotis_dimos')} />
          <FormField label="12. Δήμος Δημότης (Γυν.)" registration={register('syzygou_dimotis_dimos')} />
          <FormField label="Αριθμ. Δημοτολογίου" registration={register('syzygos_dimotis_arithmos')} />
          <FormField label="Αριθμ. Δημοτολογίου (Γυν.)" registration={register('syzygou_dimotis_arithmos')} />
          <FormField label="13. Όνομα Πατέρα" registration={register('syzygos_pateras')} />
          <FormField label="13. Όνομα Πατέρα (Γυν.)" registration={register('syzygou_pateras')} />
          <FormField label="14. Όνομα Μητέρας" registration={register('syzygos_mitera')} />
          <FormField label="14. Όνομα Μητέρας (Γυν.)" registration={register('syzygou_mitera')} />
        </TwoCol>

        <h3 className="section-title mt-4">15. Κατοικία Ζεύγους</h3>
        <TwoCol>
          <FormField label="Κατοικία Ζεύγους" registration={register('zeygos_katikia')} />
          <FormField label="Κατοικία Ζεύγους 2" registration={register('zeygos_katikia_2')} />
          <FormField label="Νομός Ζεύγους" registration={register('zeygos_nomos')} />
          <FormField label="Νομός Ζεύγους 2" registration={register('zeygos_nomos_2')} />
          <FormField label="Δήμος Ζεύγους" registration={register('zeygos_dimos')} />
          <FormField label="Χώρα Εξωτερικού" registration={register('zeygos_chora')} />
        </TwoCol>

        <h3 className="section-title mt-4">16-21. Λοιπά Στοιχεία</h3>
        <TwoCol>
          <FormField label="16. Επώνυμο Τέκνων" registration={register('eponymo_teknon')} />
          <FormField label="16. Επώνυμο Τέκνων 2" registration={register('eponymo_teknon_2')} />
          <FormField label="17. Οικογ. Κατάσταση Συζύγου" registration={register('syzygos_oik_katastasi')} placeholder="Άγαμος / Χήρος / Διαζευγμένος" />
          <FormField label="17. Οικογ. Κατάσταση (Γυν.)" registration={register('syzygou_oik_katastasi')} placeholder="Άγαμη / Χήρα / Διαζευγμένη" />
          <FormField label="18. Βαθμός Γάμου Συζύγου" registration={register('syzygos_vathmos_gamou')} placeholder="πρώτος / δεύτερος / τρίτος" />
          <FormField label="18. Βαθμός Γάμου (Γυν.)" registration={register('syzygou_vathmos_gamou')} />
          <FormField label="19. Εκπαίδευση Συζύγου" registration={register('syzygos_ekpaideusi')} />
          <FormField label="19. Εκπαίδευση (Γυν.)" registration={register('syzygou_ekpaideusi')} />
          <FormField label="20. Αριθμ. Άδειας Γάμου Άνδρα" registration={register('syzygos_arithmos_adeia_gamou')} />
          <FormField label="Ιεράς Μητροπόλεως (Άνδρας)" registration={register('syzygos_ieras_mitropoli_adeia')} />
          <FormField label="20. Αριθμ. Άδειας Γάμου Γυναίκας" registration={register('syzygou_arithmos_adeia_gamou')} />
          <FormField label="Ιεράς Μητροπόλεως (Γυναίκα)" registration={register('syzygou_ieras_mitropoli_adeia')} />
          <FormField label="21. Αριθμ. Παραβόλου Άνδρα" registration={register('syzygos_arithmos_paravolo')} />
          <FormField label="21. Αριθμ. Παραβόλου Γυναίκας" registration={register('syzygou_arithmos_paravolo')} />
        </TwoCol>

        <div className="flex gap-3 mt-6 pt-4 border-t border-gray-200">
          <button type="submit" className="btn-primary">{isEdit ? 'Αποθήκευση Αλλαγών' : 'Υποβολή Δήλωσης'}</button>
          <button type="button" onClick={() => navigate('/marriage')} className="btn-secondary">Ακύρωση</button>
        </div>
      </form>
    </div>
  )
}
