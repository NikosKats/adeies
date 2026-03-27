import { useEffect } from 'react'
import { useForm } from 'react-hook-form'
import { zodResolver } from '@hookform/resolvers/zod'
import { z } from 'zod'
import FormField from '../../../components/FormField'
import { useModuleForm } from '../../../components/useModule'

const schema = z.object({
  iera_mitropolis: z.string().min(1, 'Υποχρεωτικό'),
  ieros_naos: z.string().min(1, 'Υποχρεωτικό'),
  arithmos_protokolou: z.string().min(1, 'Υποχρεωτικό'),
  efimerios: z.string().min(1, 'Υποχρεωτικό'),
  efimerios_naou: z.string().default(''),
  baptism_imera: z.string().min(1, 'Υποχρεωτικό'),
  baptism_minas: z.string().min(1, 'Υποχρεωτικό'),
  baptism_etos: z.string().min(1, 'Υποχρεωτικό'),
  baptism_imera_evdomadas: z.string().default(''),
  baptism_naos: z.string().default(''),
  pateras_onoma: z.string().min(1, 'Υποχρεωτικό'),
  mitera_eponymo_genous: z.string().default(''),
  mitera_onoma: z.string().min(1, 'Υποχρεωτικό'),
  katoikia: z.string().default(''),
  odos: z.string().default(''),
  arithmos_odou: z.string().default(''),
  gennitiki_imera: z.string().default(''),
  gennitiki_poli: z.string().default(''),
  lixiarxeio_praxis_arithmos: z.string().default(''),
  lixiarxeio_tomos: z.string().default(''),
  lixiarxeio_etos: z.string().default(''),
  lixiarchos: z.string().default(''),
  onoma_baptisthen: z.string().min(1, 'Υποχρεωτικό'),
  anadexamenos: z.string().min(1, 'Υποχρεωτικό'),
  anadexamenos_katoikia: z.string().default(''),
  anadexamenos_odos: z.string().default(''),
  anadexamenos_arithmos: z.string().default(''),
  efimerios_ypografi: z.string().default(''),
  pateras_ypografi: z.string().default(''),
  mitera_ypografi: z.string().default(''),
  anadoxos_ypografi: z.string().default('')
})

type FormData = z.infer<typeof schema>

export default function BaptismDeclarationForm() {
  const { isEdit, defaultValues, submit, navigate } = useModuleForm('baptism_declarations')
  const { register, handleSubmit, formState: { errors }, reset } = useForm<FormData>({
    resolver: zodResolver(schema)
  })

  useEffect(() => {
    if (defaultValues !== null) reset(defaultValues as FormData)
  }, [defaultValues, reset])

  if (defaultValues === null) return <div className="text-gray-500">Φόρτωση...</div>

  const onSubmit = handleSubmit((data) => submit(data, '/baptism-declaration'))

  return (
    <div className="max-w-4xl">
      <div className="flex items-center gap-4 mb-6">
        <button onClick={() => navigate('/baptism-declaration')} className="btn-secondary">← Πίσω</button>
        <h2 className="page-title mb-0">{isEdit ? 'Επεξεργασία' : 'Νέα'} Δήλωση Βαπτίσεως</h2>
      </div>

      <form onSubmit={onSubmit} className="card">
        <h3 className="section-title">Στοιχεία Εκκλησίας</h3>
        <div className="grid grid-cols-2 gap-x-6">
          <FormField label="Ιερά Μητρόπολις" registration={register('iera_mitropolis')} error={errors.iera_mitropolis?.message} required />
          <FormField label="Ιερός Ναός" registration={register('ieros_naos')} error={errors.ieros_naos?.message} required />
          <FormField label="Αριθμ. Πρωτοκόλλου" registration={register('arithmos_protokolou')} error={errors.arithmos_protokolou?.message} required />
          <FormField label="Εφημέριος (υπογεγραμμένος)" registration={register('efimerios')} error={errors.efimerios?.message} required />
          <FormField label="Εφημέριος του Ιερού Ναού" registration={register('efimerios_naou')} />
        </div>

        <h3 className="section-title mt-4">Ημερομηνία Βαπτίσεως</h3>
        <div className="grid grid-cols-4 gap-x-6">
          <FormField label="Ημέρα" registration={register('baptism_imera')} error={errors.baptism_imera?.message} required />
          <FormField label="Μήνας" registration={register('baptism_minas')} error={errors.baptism_minas?.message} required />
          <FormField label="Έτος" registration={register('baptism_etos')} error={errors.baptism_etos?.message} required />
          <FormField label="Ημέρα Εβδομάδας" registration={register('baptism_imera_evdomadas')} />
        </div>
        <div className="grid grid-cols-2 gap-x-6">
          <FormField label="Ιερός Ναός Βαπτίσεως" registration={register('baptism_naos')} />
        </div>

        <h3 className="section-title mt-4">Στοιχεία Γονέων</h3>
        <div className="grid grid-cols-2 gap-x-6">
          <FormField label="Πατέρας (Όνομα & Επώνυμο)" registration={register('pateras_onoma')} error={errors.pateras_onoma?.message} required />
          <FormField label="Μητέρα (Όνομα & Επώνυμο)" registration={register('mitera_onoma')} error={errors.mitera_onoma?.message} required />
          <FormField label="Επώνυμο Γένους Μητέρας" registration={register('mitera_eponymo_genous')} />
          <FormField label="Κατοικία" registration={register('katoikia')} />
          <FormField label="Οδός" registration={register('odos')} />
          <FormField label="Αριθμός" registration={register('arithmos_odou')} />
        </div>

        <h3 className="section-title mt-4">Στοιχεία Βαπτισθέντος</h3>
        <div className="grid grid-cols-2 gap-x-6">
          <FormField label="Όνομα Βαπτισθέντος" registration={register('onoma_baptisthen')} error={errors.onoma_baptisthen?.message} required />
          <FormField label="Ημερομηνία Γέννησης" registration={register('gennitiki_imera')} />
          <FormField label="Πόλη Γέννησης" registration={register('gennitiki_poli')} />
        </div>

        <h3 className="section-title mt-4">Ληξιαρχείο</h3>
        <div className="grid grid-cols-3 gap-x-6">
          <FormField label="Αριθμ. Πράξης Γεννήσεως" registration={register('lixiarxeio_praxis_arithmos')} />
          <FormField label="Τόμος" registration={register('lixiarxeio_tomos')} />
          <FormField label="Έτος" registration={register('lixiarxeio_etos')} />
          <FormField label="Ληξίαρχος" registration={register('lixiarchos')} className="col-span-3" />
        </div>

        <h3 className="section-title mt-4">Ανάδοχος</h3>
        <div className="grid grid-cols-2 gap-x-6">
          <FormField label="Ανάδοχος (Όνομα & Επώνυμο)" registration={register('anadexamenos')} error={errors.anadexamenos?.message} required />
          <FormField label="Κατοικία Αναδόχου" registration={register('anadexamenos_katoikia')} />
          <FormField label="Οδός Αναδόχου" registration={register('anadexamenos_odos')} />
          <FormField label="Αριθμός Αναδόχου" registration={register('anadexamenos_arithmos')} />
        </div>

        <h3 className="section-title mt-4">Υπογραφές</h3>
        <div className="grid grid-cols-2 gap-x-6">
          <FormField label="Ο Εφημέριος" registration={register('efimerios_ypografi')} />
          <FormField label="Ο Πατήρ" registration={register('pateras_ypografi')} />
          <FormField label="Η Μητήρ" registration={register('mitera_ypografi')} />
          <FormField label="Ο Ανάδοχος" registration={register('anadoxos_ypografi')} />
        </div>

        <div className="flex gap-3 mt-6 pt-4 border-t border-gray-200">
          <button type="submit" className="btn-primary">{isEdit ? 'Αποθήκευση Αλλαγών' : 'Υποβολή Δήλωσης'}</button>
          <button type="button" onClick={() => navigate('/baptism-declaration')} className="btn-secondary">Ακύρωση</button>
        </div>
      </form>
    </div>
  )
}
