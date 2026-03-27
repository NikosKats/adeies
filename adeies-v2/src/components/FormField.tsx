import { UseFormRegisterReturn } from 'react-hook-form'

interface Props {
  label: string
  registration: UseFormRegisterReturn
  error?: string
  required?: boolean
  type?: string
  placeholder?: string
  className?: string
}

export default function FormField({
  label,
  registration,
  error,
  required,
  type = 'text',
  placeholder,
  className = ''
}: Props) {
  return (
    <div className={`mb-4 ${className}`}>
      <label className="form-label">
        {label}
        {required && <span className="text-red-500 ml-1">*</span>}
      </label>
      <input
        type={type}
        placeholder={placeholder}
        {...registration}
        className={`form-input ${error ? 'border-red-500 focus:ring-red-500' : ''}`}
      />
      {error && <p className="mt-1 text-xs text-red-600">{error}</p>}
    </div>
  )
}
