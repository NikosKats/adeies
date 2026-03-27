import { useEffect } from 'react'
import { useForm } from 'react-hook-form'
import { zodResolver } from '@hookform/resolvers/zod'
import { z } from 'zod'
import FormField from '../../../components/FormField'
import { useModuleForm } from '../../../components/useModule'

const s = z.string().default('')
const req = z.string().min(1, 'Υποχρεωτικό')

const schema = z.object({
  iera_mitropolis: req, ieros_naos: req, arithmos_protokolou: req,
  efimerios: req, efimerios_naou: s,
  proselthen: s, agamos_onoma: req,
  patros: s, mitros: s,
  gennitikos_topos: s, gennitiki_imera: s, gennitiki_poli: s, etos_genniseos: s,
  katoikia_apo: s, katoikia_etos: s, odos: s, arithmos_odou: s,
  ilikia: s, epaggelma: s, christianos: s, dilosi_imera: s,
  martyras_1: s, martyras_1_id: s, martyras_1_astynomia: s,
  martyras_2: s, martyras_2_id: s, martyras_2_astynomia: s,
  dilosi_katoikia: s, dilosi_enthen: s, dilosi_odos: s,
  agamos_kata: s, dynatos_gamos: s, ekdosi_adeia: s,
  martyras_ypografi_1: s, martyras_ypografi_2: s,
  ekdosi_adeia_2: s,
  topos_ekdosis: s, imera_ekdosis: s, etos_ekdosis: s
})

type FormData = z.infer<typeof schema>

export default function CertificateBForm() {
  const { isEdit, defaultValues, submit, navigate } = useModuleForm('certificates_b')
  const { register, handleSubmit, formState: { errors }, reset } = useForm<FormData>({ resolver: zodResolver(schema) })

  useEffect(() => { if (defaultValues !== null) reset(defaultValues as FormData) }, [defaultValues, reset])
  if (defaultValues === null) return <div className="text-gray-500">Φόρτωση...</div>

  const onSubmit = handleSubmit((data) => submit(data, '/certificate-b'))

  return (
    <div className="max-w-4xl">
      <div className="flex items-center gap-4 mb-6">
        <button onClick={() => navigate('/certificate-b')} className="btn-secondary">← Πίσω</button>
        <h2 className="page-title mb-0">{isEdit ? 'Επεξεργασία' : 'Νέο'} Πιστοποιητικό Αγαμίας Β΄</h2>
      </div>

      <form onSubmit={onSubmit} className="card">
        <h3 className="section-title">Στοιχεία Εκκλησίας</h3>
        <div className="grid grid-cols-2 gap-x-6">
          <FormField label="Ιερά Μητρόπολις" registration={register('iera_mitropolis')} error={errors.iera_mitropolis?.message} required />
          <FormField label="Ενοριακός Ιερός Ναός" registration={register('ieros_naos')} error={errors.ieros_naos?.message} required />
          <FormField label="Αριθμ. Πρωτοκόλλου" registration={register('arithmos_protokolou')} error={errors.arithmos_protokolou?.message} required />
          <FormField label="Ο υπογεγραμμένος (Εφημέριος)" registration={register('efimerios')} error={errors.efimerios?.message} required />
          <FormField label="Εφημέριος Ιερού Ναού" registration={register('efimerios_naou')} />
        </div>

        <h3 className="section-title mt-4">Στοιχεία Αγάμου</h3>
        <div className="grid grid-cols-2 gap-x-6">
          <FormField label="Προσελθ..." registration={register('proselthen')} />
          <FormField label="Ονοματεπώνυμο Αγάμου" registration={register('agamos_onoma')} error={errors.agamos_onoma?.message} required />
          <FormField label="Πατρός" registration={register('patros')} />
          <FormField label="Μητρός (τό γένος)" registration={register('mitros')} />
          <FormField label="Τόπος Γέννησης" registration={register('gennitikos_topos')} />
          <FormField label="Ημέρα Γέννησης" registration={register('gennitiki_imera')} />
          <FormField label="Πόλη Γέννησης" registration={register('gennitiki_poli')} />
          <FormField label="Έτος Γέννησης" registration={register('etos_genniseos')} />
          <FormField label="Ηλικία (ετών)" registration={register('ilikia')} />
          <FormField label="Επάγγελμα" registration={register('epaggelma')} />
          <FormField label="Χριστιανός/ή" registration={register('christianos')} />
          <FormField label="Ημερομηνία Δήλωσης" registration={register('dilosi_imera')} />
        </div>

        <h3 className="section-title mt-4">Κατοικία</h3>
        <div className="grid grid-cols-2 gap-x-6">
          <FormField label="Διαμένει (από)" registration={register('katoikia_apo')} />
          <FormField label="Από του έτους" registration={register('katoikia_etos')} />
          <FormField label="Οδός" registration={register('odos')} />
          <FormField label="Αριθμός" registration={register('arithmos_odou')} />
        </div>

        <h3 className="section-title mt-4">Μάρτυρες</h3>
        <div className="grid grid-cols-2 gap-x-6">
          <FormField label="Μάρτυρας 1 (Πλήρη Στοιχεία)" registration={register('martyras_1')} />
          <FormField label="Αριθμός Ταυτότητας 1" registration={register('martyras_1_id')} />
          <FormField label="Αστυνομικό Τμήμα 1" registration={register('martyras_1_astynomia')} />
          <FormField label="Μάρτυρας 2 (Πλήρη Στοιχεία)" registration={register('martyras_2')} />
          <FormField label="Αριθμός Ταυτότητας 2" registration={register('martyras_2_id')} />
          <FormField label="Αστυνομικό Τμήμα 2" registration={register('martyras_2_astynomia')} />
        </div>

        <h3 className="section-title mt-4">Δήλωση Μαρτύρων</h3>
        <div className="grid grid-cols-1 gap-x-6">
          <FormField label="Διαμένει (κατοικία αναφοράς)" registration={register('dilosi_katoikia')} />
          <FormField label="Επί της οδού" registration={register('dilosi_odos')} />
          <FormField label="Εντεύθεν" registration={register('dilosi_enthen')} />
          <FormField label="Τυγχάνει άγαμος/η (κατά)" registration={register('agamos_kata')} />
          <FormField label="Δύναται να συνάψη γάμον" registration={register('dynatos_gamos')} />
          <FormField label="Χορηγείται για έκδοση άδειας γάμου" registration={register('ekdosi_adeia')} />
          <FormField label="Χορηγείται για έκδοση άδειας γάμου (2)" registration={register('ekdosi_adeia_2')} />
        </div>

        <h3 className="section-title mt-4">Υπογραφές Μαρτύρων</h3>
        <div className="grid grid-cols-2 gap-x-6">
          <FormField label="Υπογραφή Μάρτυρα 1" registration={register('martyras_ypografi_1')} />
          <FormField label="Υπογραφή Μάρτυρα 2" registration={register('martyras_ypografi_2')} />
        </div>

        <h3 className="section-title mt-4">Τόπος & Ημερομηνία Έκδοσης</h3>
        <div className="grid grid-cols-3 gap-x-6">
          <FormField label="Εν (τόπος)" registration={register('topos_ekdosis')} />
          <FormField label="Τη (ημέρα/μήνας)" registration={register('imera_ekdosis')} />
          <FormField label="Έτος" registration={register('etos_ekdosis')} />
        </div>

        <div className="flex gap-3 mt-6 pt-4 border-t border-gray-200">
          <button type="submit" className="btn-primary">{isEdit ? 'Αποθήκευση Αλλαγών' : 'Έκδοση Πιστοποιητικού'}</button>
          <button type="button" onClick={() => navigate('/certificate-b')} className="btn-secondary">Ακύρωση</button>
        </div>
      </form>
    </div>
  )
}
