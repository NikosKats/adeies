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
  simeron_imera: z.string().default(''),
  simeron_minas: z.string().default(''),
  simeron_etos: z.string().default(''),
  goneis_1: z.string().min(1, 'Υποχρεωτικό'),
  goneis_1_id_arithmos: z.string().default(''),
  goneis_1_id_ekdosi: z.string().default(''),
  goneis_2: z.string().default(''),
  goneis_2_id_arithmos: z.string().default(''),
  goneis_2_id_ekdosi: z.string().default(''),
  teknon_gennitiki_imera: z.string().default(''),
  teknon_gennitiki_minas: z.string().default(''),
  teknon_gennitiki_etos: z.string().default(''),
  teknon_nosokomeio: z.string().default(''),
  teknon_nosokomeio_etos: z.string().default(''),
  lixiarxeio_praxis_arithmos: z.string().default(''),
  lixiarxeio_tomos: z.string().default(''),
  lixiarxeio_etos: z.string().default(''),
  teknon_onoma: z.string().min(1, 'Υποχρεωτικό'),
  baptisma_minas: z.string().default(''),
  katoikia_odos: z.string().default(''),
  baptisma_imera: z.string().default(''),
  baptisma_etos: z.string().default(''),
  anadoxos: z.string().default(''),
  anadoxos_gamochronologia: z.string().default(''),
  anadoxos_gamonaos: z.string().default(''),
  topos_ypovrolis: z.string().default(''),
  imera_ypovrolis: z.string().default(''),
  etos_ypovrolis: z.string().default('')
})

type FormData = z.infer<typeof schema>

export default function BaptismSpecificationForm() {
  const { isEdit, defaultValues, submit, navigate } = useModuleForm('baptism_specifications')
  const { register, handleSubmit, formState: { errors }, reset } = useForm<FormData>({ resolver: zodResolver(schema) })

  useEffect(() => { if (defaultValues !== null) reset(defaultValues as FormData) }, [defaultValues, reset])
  if (defaultValues === null) return <div className="text-gray-500">Φόρτωση...</div>

  const onSubmit = handleSubmit((data) => submit(data, '/baptism-specification'))

  return (
    <div className="max-w-4xl">
      <div className="flex items-center gap-4 mb-6">
        <button onClick={() => navigate('/baptism-specification')} className="btn-secondary">← Πίσω</button>
        <h2 className="page-title mb-0">{isEdit ? 'Επεξεργασία' : 'Νέα'} Πράξη Προσδιορισμού Βαπτίσεως</h2>
      </div>

      <form onSubmit={onSubmit} className="card">
        <h3 className="section-title">Στοιχεία Εκκλησίας</h3>
        <div className="grid grid-cols-2 gap-x-6">
          <FormField label="Ιερά Μητρόπολις" registration={register('iera_mitropolis')} error={errors.iera_mitropolis?.message} required />
          <FormField label="Ιερός Ναός" registration={register('ieros_naos')} error={errors.ieros_naos?.message} required />
          <FormField label="Αριθμ. Πρωτοκόλλου" registration={register('arithmos_protokolou')} error={errors.arithmos_protokolou?.message} required />
        </div>

        <h3 className="section-title mt-4">Ημερομηνία Δήλωσης</h3>
        <div className="grid grid-cols-3 gap-x-6">
          <FormField label="Ημέρα" registration={register('simeron_imera')} />
          <FormField label="Μήνας" registration={register('simeron_minas')} />
          <FormField label="Έτος" registration={register('simeron_etos')} />
        </div>

        <h3 className="section-title mt-4">Στοιχεία Γονέων</h3>
        <div className="grid grid-cols-2 gap-x-6">
          <FormField label="Γονέας 1 (Πατέρας)" registration={register('goneis_1')} error={errors.goneis_1?.message} required />
          <FormField label="Αρ. Ταυτότητας 1" registration={register('goneis_1_id_arithmos')} />
          <FormField label="Χρον. Έκδοσης 1" registration={register('goneis_1_id_ekdosi')} />
          <FormField label="Γονέας 2 (Μητέρα)" registration={register('goneis_2')} />
          <FormField label="Αρ. Ταυτότητας 2" registration={register('goneis_2_id_arithmos')} />
          <FormField label="Χρον. Έκδοσης 2" registration={register('goneis_2_id_ekdosi')} />
        </div>

        <h3 className="section-title mt-4">Στοιχεία Τέκνου</h3>
        <div className="grid grid-cols-2 gap-x-6">
          <FormField label="Όνομα Τέκνου" registration={register('teknon_onoma')} error={errors.teknon_onoma?.message} required />
          <FormField label="Ημέρα Γέννησης" registration={register('teknon_gennitiki_imera')} />
          <FormField label="Μήνας Γέννησης" registration={register('teknon_gennitiki_minas')} />
          <FormField label="Έτος Γέννησης" registration={register('teknon_gennitiki_etos')} />
          <FormField label="Νοσοκομείο" registration={register('teknon_nosokomeio')} />
          <FormField label="Έτος Νοσοκομείου" registration={register('teknon_nosokomeio_etos')} />
        </div>

        <h3 className="section-title mt-4">Ληξιαρχείο</h3>
        <div className="grid grid-cols-3 gap-x-6">
          <FormField label="Αριθμ. Πράξης" registration={register('lixiarxeio_praxis_arithmos')} />
          <FormField label="Τόμος" registration={register('lixiarxeio_tomos')} />
          <FormField label="Έτος" registration={register('lixiarxeio_etos')} />
        </div>

        <h3 className="section-title mt-4">Βάπτισμα</h3>
        <div className="grid grid-cols-3 gap-x-6">
          <FormField label="Ημέρα Βαπτίσματος" registration={register('baptisma_imera')} />
          <FormField label="Μήνας Βαπτίσματος" registration={register('baptisma_minas')} />
          <FormField label="Έτος Βαπτίσματος" registration={register('baptisma_etos')} />
        </div>

        <h3 className="section-title mt-4">Ανάδοχος</h3>
        <div className="grid grid-cols-2 gap-x-6">
          <FormField label="Ανάδοχος" registration={register('anadoxos')} />
          <FormField label="Χρονολογία Γάμου Αναδόχου" registration={register('anadoxos_gamochronologia')} />
          <FormField label="Ναός Γάμου Αναδόχου" registration={register('anadoxos_gamonaos')} />
          <FormField label="Κατοικία" registration={register('katoikia_odos')} />
        </div>

        <h3 className="section-title mt-4">Τόπος & Ημερομηνία Υποβολής</h3>
        <div className="grid grid-cols-3 gap-x-6">
          <FormField label="Τόπος" registration={register('topos_ypovrolis')} />
          <FormField label="Ημέρα" registration={register('imera_ypovrolis')} />
          <FormField label="Έτος" registration={register('etos_ypovrolis')} />
        </div>

        <div className="flex gap-3 mt-6 pt-4 border-t border-gray-200">
          <button type="submit" className="btn-primary">{isEdit ? 'Αποθήκευση Αλλαγών' : 'Υποβολή'}</button>
          <button type="button" onClick={() => navigate('/baptism-specification')} className="btn-secondary">Ακύρωση</button>
        </div>
      </form>
    </div>
  )
}
