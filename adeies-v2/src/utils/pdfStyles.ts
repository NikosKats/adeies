export const pdfStyles = `
  @import url('https://fonts.googleapis.com/css2?family=IM+Fell+English:ital@0;1&display=swap');

  * { box-sizing: border-box; margin: 0; padding: 0; }

  body {
    font-family: Georgia, 'Times New Roman', serif;
    font-size: 11.5pt;
    line-height: 1.75;
    color: #1a1a1a;
    background: #fff;
    padding: 1.6cm 2cm;
  }

  .page {
    border: 2.5px double #2c3e6b;
    padding: 1cm 1.4cm;
    min-height: 25cm;
    position: relative;
  }

  /* ── Header ── */
  .header {
    text-align: center;
    border-bottom: 1.5px solid #2c3e6b;
    padding-bottom: 10px;
    margin-bottom: 14px;
  }
  .header .cross {
    font-size: 20pt;
    color: #2c3e6b;
    line-height: 1;
    display: block;
    margin-bottom: 4px;
  }
  .header .mitropolis {
    font-size: 12pt;
    font-weight: bold;
    letter-spacing: 0.04em;
    text-transform: uppercase;
    color: #2c3e6b;
  }
  .header .naos {
    font-size: 11pt;
    color: #333;
    margin-top: 2px;
  }

  /* ── Protocol number ── */
  .protokolo {
    text-align: right;
    font-size: 10pt;
    color: #444;
    margin-bottom: 8px;
  }
  .protokolo b { color: #1a1a1a; }

  /* ── Document title ── */
  .doc-title {
    text-align: center;
    font-size: 15pt;
    font-weight: bold;
    letter-spacing: 0.08em;
    text-transform: uppercase;
    color: #2c3e6b;
    margin: 16px 0 4px;
  }
  .doc-subtitle {
    text-align: center;
    font-size: 10pt;
    color: #666;
    margin-bottom: 18px;
    letter-spacing: 0.04em;
  }
  .title-rule {
    border: none;
    border-top: 1px solid #2c3e6b;
    margin: 0 auto 18px;
    width: 60%;
    opacity: 0.5;
  }

  /* ── Body text ── */
  .body-text {
    text-align: justify;
    text-indent: 2em;
    margin-bottom: 10px;
    hyphens: auto;
  }
  .body-text b { font-style: normal; }

  .center-emphasis {
    text-align: center;
    font-size: 13pt;
    font-weight: bold;
    margin: 16px 0;
    color: #2c3e6b;
    letter-spacing: 0.06em;
  }

  /* ── Sections ── */
  .section {
    margin-top: 14px;
    padding-top: 10px;
    border-top: 1px dashed #aab;
  }
  .section-title {
    font-size: 9.5pt;
    font-weight: bold;
    letter-spacing: 0.1em;
    text-transform: uppercase;
    color: #2c3e6b;
    margin-bottom: 6px;
  }

  /* ── Witness / info table ── */
  .info-grid {
    width: 100%;
    border-collapse: collapse;
    margin: 10px 0;
    font-size: 10.5pt;
  }
  .info-grid td {
    padding: 3px 6px;
    vertical-align: top;
  }
  .info-grid .lbl {
    font-weight: bold;
    color: #444;
    width: 38%;
    white-space: nowrap;
  }

  /* ── Signatures ── */
  .signatures {
    display: flex;
    justify-content: space-around;
    margin-top: 40px;
    gap: 16px;
  }
  .sig-block {
    text-align: center;
    flex: 1;
  }
  .sig-block .sig-title {
    font-size: 9pt;
    font-weight: bold;
    letter-spacing: 0.08em;
    text-transform: uppercase;
    color: #2c3e6b;
    margin-bottom: 36px;
  }
  .sig-block .sig-line {
    border-top: 1px solid #333;
    width: 80%;
    margin: 0 auto 4px;
  }
  .sig-block .sig-name {
    font-size: 9.5pt;
    color: #333;
  }

  /* ── Date/place footer ── */
  .doc-footer {
    text-align: right;
    margin-top: 24px;
    font-size: 10.5pt;
    color: #333;
    border-top: 1px solid #ddd;
    padding-top: 10px;
  }
`
