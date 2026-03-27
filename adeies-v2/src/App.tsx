import { useEffect, useState } from 'react'
import { HashRouter, Routes, Route, Navigate } from 'react-router-dom'
import Layout from './components/Layout'
import Home from './pages/Home'
import Settings from './pages/Settings'
import BaptismDeclarationForm from './pages/modules/baptism-declaration/BaptismDeclarationForm'
import BaptismDeclarationTable from './pages/modules/baptism-declaration/BaptismDeclarationTable'
import BaptismDeclarationView from './pages/modules/baptism-declaration/BaptismDeclarationView'
import BaptismSpecificationForm from './pages/modules/baptism-specification/BaptismSpecificationForm'
import BaptismSpecificationTable from './pages/modules/baptism-specification/BaptismSpecificationTable'
import BaptismSpecificationView from './pages/modules/baptism-specification/BaptismSpecificationView'
import MarriageForm from './pages/modules/marriage/MarriageForm'
import MarriageTable from './pages/modules/marriage/MarriageTable'
import MarriageView from './pages/modules/marriage/MarriageView'
import CertificateAForm from './pages/modules/certificate-a/CertificateAForm'
import CertificateATable from './pages/modules/certificate-a/CertificateATable'
import CertificateAView from './pages/modules/certificate-a/CertificateAView'
import CertificateBForm from './pages/modules/certificate-b/CertificateBForm'
import CertificateBTable from './pages/modules/certificate-b/CertificateBTable'
import CertificateBView from './pages/modules/certificate-b/CertificateBView'

export default function App() {
  const [hasConfig, setHasConfig] = useState<boolean | null>(null)

  useEffect(() => {
    window.api.getDbConfig().then((cfg) => setHasConfig(cfg !== null))
  }, [])

  if (hasConfig === null) {
    return (
      <div className="flex items-center justify-center h-screen bg-gray-50">
        <div className="text-gray-500">Φόρτωση...</div>
      </div>
    )
  }

  return (
    <HashRouter>
      <Routes>
        {!hasConfig ? (
          <>
            <Route path="/settings" element={<Settings onSaved={() => setHasConfig(true)} />} />
            <Route path="*" element={<Navigate to="/settings" replace />} />
          </>
        ) : (
          <Route element={<Layout />}>
            <Route path="/" element={<Home />} />
            <Route path="/settings" element={<Settings onSaved={() => setHasConfig(true)} />} />

            {/* Δήλωση Βαπτίσεως */}
            <Route path="/baptism-declaration" element={<BaptismDeclarationTable />} />
            <Route path="/baptism-declaration/new" element={<BaptismDeclarationForm />} />
            <Route path="/baptism-declaration/:id" element={<BaptismDeclarationView />} />
            <Route path="/baptism-declaration/:id/edit" element={<BaptismDeclarationForm />} />

            {/* Προσδιορισμός Βαπτίσεως */}
            <Route path="/baptism-specification" element={<BaptismSpecificationTable />} />
            <Route path="/baptism-specification/new" element={<BaptismSpecificationForm />} />
            <Route path="/baptism-specification/:id" element={<BaptismSpecificationView />} />
            <Route path="/baptism-specification/:id/edit" element={<BaptismSpecificationForm />} />

            {/* Δήλωση Γάμου */}
            <Route path="/marriage" element={<MarriageTable />} />
            <Route path="/marriage/new" element={<MarriageForm />} />
            <Route path="/marriage/:id" element={<MarriageView />} />
            <Route path="/marriage/:id/edit" element={<MarriageForm />} />

            {/* Πιστοποιητικό Αγαμίας Α */}
            <Route path="/certificate-a" element={<CertificateATable />} />
            <Route path="/certificate-a/new" element={<CertificateAForm />} />
            <Route path="/certificate-a/:id" element={<CertificateAView />} />
            <Route path="/certificate-a/:id/edit" element={<CertificateAForm />} />

            {/* Πιστοποιητικό Αγαμίας Β */}
            <Route path="/certificate-b" element={<CertificateBTable />} />
            <Route path="/certificate-b/new" element={<CertificateBForm />} />
            <Route path="/certificate-b/:id" element={<CertificateBView />} />
            <Route path="/certificate-b/:id/edit" element={<CertificateBForm />} />

            <Route path="*" element={<Navigate to="/" replace />} />
          </Route>
        )}
      </Routes>
    </HashRouter>
  )
}
