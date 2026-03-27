; Custom NSIS installer script for Adeies
; Shows a message after installation guiding the user to run the DB setup

!macro customInstall
  ; Create a shortcut to the DB setup script in Start Menu
  CreateShortcut "$SMPROGRAMS\Adeies\Ρύθμιση Βάσης Δεδομένων.lnk" \
    "powershell.exe" \
    "-ExecutionPolicy Bypass -File '$INSTDIR\resources\setup-db.ps1'" \
    "" 0

  ; Show post-install message
  MessageBox MB_ICONINFORMATION|MB_OK \
    "Η εφαρμογή Adeies εγκαταστάθηκε επιτυχώς!$\n$\n\
Για πρώτη χρήση:$\n\
1. Εγκαταστήστε την PostgreSQL (αν δεν είναι ήδη)$\n\
2. Εκτελέστε το 'Ρύθμιση Βάσης Δεδομένων' από το μενού Έναρξη$\n\
3. Ξεκινήστε το Adeies και συνδεθείτε$\n$\n\
Για βοήθεια ανατρέξτε στο μενού Βοήθεια μέσα στην εφαρμογή."
!macroend
