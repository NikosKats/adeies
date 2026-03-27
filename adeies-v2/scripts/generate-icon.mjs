/**
 * Generates build/icon.png — a 1024x1024 church cross icon.
 * Run: node scripts/generate-icon.mjs
 */
import sharp from 'sharp'
import { mkdirSync } from 'fs'

mkdirSync('build', { recursive: true })

const size = 1024
const r = 160  // corner radius of background square

const svg = `<svg width="${size}" height="${size}" viewBox="0 0 ${size} ${size}" xmlns="http://www.w3.org/2000/svg">
  <!-- Background -->
  <rect width="${size}" height="${size}" rx="${r}" fill="#1e3a8a"/>
  <rect width="${size}" height="${size}" rx="${r}" fill="url(#grad)"/>
  <defs>
    <linearGradient id="grad" x1="0" y1="0" x2="1" y2="1">
      <stop offset="0%" stop-color="#1d4ed8"/>
      <stop offset="100%" stop-color="#1e3a8a"/>
    </linearGradient>
  </defs>

  <!-- Subtle inner glow ring -->
  <rect x="32" y="32" width="${size - 64}" height="${size - 64}" rx="${r - 16}"
        fill="none" stroke="white" stroke-opacity="0.08" stroke-width="4"/>

  <!-- Orthodox cross -->
  <!-- Vertical bar -->
  <rect x="432" y="160" width="160" height="704" rx="24" fill="white"/>
  <!-- Horizontal bar (upper) -->
  <rect x="192" y="296" width="640" height="140" rx="24" fill="white"/>
  <!-- Horizontal bar (lower — smaller) -->
  <rect x="272" y="584" width="480" height="100" rx="20" fill="white" opacity="0.4"/>
</svg>`

await sharp(Buffer.from(svg)).png().toFile('build/icon.png')
console.log('✅  build/icon.png generated (1024×1024)')
