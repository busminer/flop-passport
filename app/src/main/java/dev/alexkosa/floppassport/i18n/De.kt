package dev.alexkosa.floppassport.i18n

/**
 * German.
 *
 * The key is the English sentence exactly as the screen produces it, so a change to the
 * English orphans the entry here rather than letting the two drift apart silently. Anything
 * missing renders English, which keeps a gap cosmetic instead of breaking a screen.
 *
 * Product and protocol names stay in Latin script on purpose - FLOP, Seeker, Seed Vault,
 * StrongBox, Technocore, did:key, SKR. They are what a person sees everywhere else on the
 * phone, and translating them would make this app the only place they are called something
 * different.
 *
 * Generated from the phrase catalogue and checked for lost product names, eaten leading
 * spaces and entries left in English; the wording was then read through.
 */
internal val DE_STRINGS: Map<String, String> = mapOf(
    "06  tell them" to "06  weitersagen",
    "A message signed by your Passport, posted to a quiet room and then read back to prove it landed." to
        "Eine von Ihrem Passport signierte Nachricht, die in einem ruhigen Raum veröffentlicht und anschließend zurückgelesen wird, um ihre Ankunft zu belegen.",
    "A once-a-day reminder to leave today's signed record." to
        "Eine tägliche Erinnerung, den heutigen signierten Eintrag zu hinterlassen.",
    "A permanent note at an address derived from your key, so anyone can find and verify you later." to
        "Eine dauerhafte Notiz unter einer von Ihrem Schlüssel abgeleiteten Adresse, damit Sie später jeder finden und verifizieren kann.",
    "A public note at an address derived from your key, so anyone can find and verify you later." to
        "Eine öffentliche Notiz unter einer aus Ihrem Schlüssel abgeleiteten Adresse, damit jeder Sie später finden und verifizieren kann.",
    "A signed record has to be left by hand, and a missed day cannot be filled in later. This is also the switch that warns you before your identity note is deleted." to
        "Ein signierter Eintrag muss von Hand hinterlassen werden. Ein versäumter Tag kann später nicht nachgetragen werden. Mit diesem Schalter wirst du außerdem gewarnt, bevor deine Identitätsnotiz gelöscht wird.",
    "A tip changes nothing about your Passport and nothing about any airdrop." to
        "Ein Trinkgeld ändert nichts an Ihrem Passport und nichts an einem Airdrop.",
    "A tip changes nothing about your Passport, and nothing about any airdrop. It is a thank you, not a fee." to
        "Ein Trinkgeld ändert nichts an Ihrem Passport und nichts an einem Airdrop. Es ist ein Dankeschön, keine Gebühr.",
    "About" to "Über",
    "Accepted, but we could not read it back yet" to
        "Akzeptiert, aber noch nicht zurückgelesen",
    "Activity" to "Aktivität",
    "Already checked in, found in the room" to "Eintrag bereits erstellt und im Raum gefunden",
    "Already published, read back just now" to
        "Bereits veröffentlicht und gerade zurückgelesen",
    "Android is blocking notifications for this app. Turn them on in the system settings." to
        "Android blockiert Benachrichtigungen für diese App. Aktivieren Sie sie in den Systemeinstellungen.",
    "Anyone can check it at the address in step 03. This app promises nothing about any allocation, and never will." to
        "Jeder kann dies unter der Adresse aus Schritt 03 prüfen. Diese App verspricht keine Zuteilung und wird dies niemals tun.",
    "Anyone holding it can sign as you" to "Jeder, der ihn besitzt, kann als Sie signieren",
    "Anyone holding seed_hex can sign as this identity on Technocore." to
        "Jeder, der seed_hex besitzt, kann auf Technocore als diese Identität signieren.",
    "Anyone with this can be you" to "Jeder mit diesem Schlüssel kann als Sie auftreten",
    "Apply" to "Übernehmen",
    "Cancel" to "Abbrechen",
    "Check in" to "Eintrag erstellen",
    "Check your connection and try again." to
        "Prüfen Sie Ihre Verbindung und versuchen Sie es erneut.",
    "Could not open the security prompt on this screen." to
        "Die Sicherheitsabfrage konnte auf diesem Bildschirm nicht geöffnet werden.",
    "Could not reach technocore.chat" to "technocore.chat war nicht erreichbar",
    "Could not reach technocore.chat. This says nothing about your records, only about the connection." to
        "technocore.chat war nicht erreichbar. Dies sagt nichts über Ihre Einträge aus, sondern nur über die Verbindung.",
    "Could not reach the server." to "Der Server war nicht erreichbar.",
    "Could not read the key back from secure storage" to
        "Der Schlüssel konnte nicht aus dem sicheren Speicher zurückgelesen werden",
    "Create" to "Erstellen",
    "Create your Passport" to "Erstellen Sie Ihren Passport",
    "Create your Passport first. There is nothing to show until something has been signed." to
        "Erstellen Sie zuerst Ihren Passport. Solange nichts signiert wurde, gibt es nichts anzuzeigen.",
    "Created my FLOP Passport on a Solana Seeker." to
        "Meinen FLOP Passport auf einem Solana Seeker erstellt.",
    "Daily activity" to "Tägliche Aktivität",
    "Daily reminder" to "Tägliche Erinnerung",
    "Delete it?" to "Löschen?",
    "Delete the Passport and create it again from your wallet." to
        "Löschen Sie den Passport und erstellen Sie ihn erneut aus Ihrer Wallet.",
    "Deleted after seven days without a record. Sign one now and it goes back to the same address." to
        "Nach sieben Tagen ohne Eintrag gelöscht. Signiere jetzt einen und sie erscheint wieder unter derselben Adresse.",
    "Deleting removes the Passport from this phone only. Anything already published may stay public, and the same wallet rebuilds the same identity - so this is not a way to undo anything." to
        "Beim Löschen wird der Passport nur von diesem Telefon entfernt. Bereits veröffentlichte Inhalte können öffentlich bleiben, und dieselbe Wallet stellt dieselbe Identität wieder her - dies macht also nichts rückgängig.",
    "Deleting removes the Passport from this phone only. Anything already published stays public, and the same wallet rebuilds the same identity - so this is not a way to undo anything." to
        "Beim Löschen wird der Passport nur von diesem Telefon entfernt. Bereits Veröffentliches bleibt öffentlich, und dieselbe Wallet stellt dieselbe Identität wieder her - damit lässt sich nichts rückgängig machen.",
    "Derived from a Seed Vault signature, sealed by StrongBox on device." to
        "Aus einer Seed Vault-Signatur abgeleitet und auf dem Gerät durch StrongBox versiegelt.",
    "Derived from a signature my wallet made inside Seed Vault, then sealed by StrongBox." to
        "Aus einer Signatur abgeleitet, die meine Wallet in Seed Vault erstellt hat, dann durch StrongBox versiegelt.",
    "Every language listed here has a full translation." to
        "Jede hier aufgeführte Sprache ist vollständig übersetzt.",
    "FLOP Passport creates a Technocore identity from your Solana wallet and keeps the receipts." to
        "FLOP Passport erstellt aus Ihrer Solana-Wallet eine Technocore-Identität und bewahrt die Belege auf.",
    "FLOP Passport for Seeker" to "FLOP Passport für Seeker",
    "FLOP Passport for Seeker - private backup" to
        "FLOP Passport für Seeker - private Sicherung",
    "FLOP Passport for Seeker by @AlexKosa1" to "FLOP Passport für Seeker von @AlexKosa1",
    "FLOP Passport for Seeker. First signed check-in." to
        "FLOP Passport für Seeker. Erster signierter Eintrag.",
    "FLOP asked agents to do something useful. A signed record is what proves you did, and a day without one is a day nobody can check later." to
        "FLOP hat Agenten gebeten, etwas Nützliches zu tun. Ein signierter Eintrag belegt, dass Sie es getan haben, und ein Tag ohne Eintrag kann später von niemandem überprüft werden.",
    "FLOP asked agents to do two things: create a unique key, and do something useful to spread the word about Technocore. The five steps above did the first. Nobody can do the second for you, so this writes the post and you decide whether to send it." to
        "FLOP hat Agenten um zwei Dinge gebeten: einen einzigartigen Schlüssel zu erstellen und etwas Sinnvolles zu tun, um Technocore bekannter zu machen. Die fünf Schritte oben haben das Erste erledigt. Das Zweite kann dir niemand abnehmen, deshalb schreibt die App den Beitrag und du entscheidest, ob du ihn veröffentlichst.",
    "Identity derived from your wallet signature" to
        "Aus Ihrer Wallet-Signatur abgeleitete Identität",
    "Identity note published, first check in signed and verified on Technocore." to
        "Identitätsnotiz veröffentlicht, erster Eintrag signiert und auf Technocore verifiziert.",
    "Identity note published, first check in verified on Technocore." to
        "Identitätsnotiz veröffentlicht, erster Eintrag auf Technocore verifiziert.",
    "Identity note published, first check in verified." to
        "Identitätsnotiz veröffentlicht, erster Eintrag verifiziert.",
    "If it does get deleted, your Passport is not gone: the same wallet still gives the same identity, and signing a record publishes the note back to the same address." to
        "Falls sie doch gelöscht wird, ist dein Passport nicht weg: Dieselbe Wallet erzeugt weiterhin dieselbe Identität. Wenn du einen Eintrag signierst, wird die Notiz wieder unter derselben Adresse veröffentlicht.",
    "It never asks for your wallet recovery phrase." to
        "Die App fragt niemals nach der Wiederherstellungsphrase Ihrer Wallet.",
    "It promises nothing about any airdrop, and never will." to
        "Sie verspricht nichts in Bezug auf einen Airdrop und wird dies niemals tun.",
    "It will be deleted after seven days without a record." to
        "Sie wird nach sieben Tagen ohne Eintrag gelöscht.",
    "Keep this file offline. Never send it to anyone, including the app author." to
        "Bewahren Sie diese Datei offline auf. Senden Sie sie niemals an jemanden, auch nicht an den App-Autor.",
    "Keep your record going" to "Setzen Sie Ihre Aufzeichnung fort",
    "Key born in Seed Vault, sealed by StrongBox on device." to
        "Schlüssel in Seed Vault erzeugt und auf dem Gerät durch StrongBox versiegelt.",
    "Language" to "Sprache",
    "Leave it blank and the post still works. It just says less." to
        "Lass das Feld leer, und der Post funktioniert trotzdem. Er sagt dann nur weniger.",
    "Leave today's signed record on Technocore." to
        "Hinterlassen Sie den heutigen signierten Eintrag auf Technocore.",
    "Link to what you built, if there is one" to "Link zu deinem Projekt, falls vorhanden",
    "Link to your post" to "Link zu deinem Post",
    "Make your first signed check-in" to "Erstellen Sie Ihren ersten signierten Eintrag",
    "My FLOP Passport, created on a Solana Seeker." to
        "Mein FLOP Passport, erstellt auf einem Solana Seeker.",
    "Next: create your Passport from your wallet." to
        "Als Nächstes: Erstellen Sie Ihren Passport aus Ihrer Wallet.",
    "Next: make your first signed check-in." to
        "Als Nächstes: Erstellen Sie Ihren ersten signierten Eintrag.",
    "Next: publish your identity so anyone can verify you." to
        "Als Nächstes: Veröffentlichen Sie Ihre Identität, damit jeder sie verifizieren kann.",
    "Next: seal the key in this phone's secure storage." to
        "Als Nächstes: Versiegeln Sie den Schlüssel im sicheren Speicher dieses Telefons.",
    "No account, no server of ours, no analytics." to
        "Kein Konto, kein eigener Server, keine Analysen.",
    "No wallet on this phone opened the payment link." to
        "Keine Wallet auf diesem Telefon hat den Zahlungslink geöffnet.",
    "No. Nothing was published." to "Nein. Es wurde nichts veröffentlicht.",
    "Not checked yet." to "Noch nicht geprüft.",
    "Nothing asked yet" to "Noch nichts gefragt",
    "Nothing found. If you signed something and it is not here, the room has been trimmed past it - which is normal, and exactly why this screen exists." to
        "Nichts gefunden. Wenn Sie etwas signiert haben und es hier fehlt, wurde es aus dem Raum entfernt - das ist normal und genau dafür gibt es diesen Bildschirm.",
    "Nothing has vouched for this text yet. Publish again to sign for it." to
        "Für diesen Text hat noch nichts gebürgt. Veröffentlichen Sie erneut, um ihn zu signieren.",
    "Nothing signed today yet." to "Heute wurde noch nichts signiert.",
    "Only languages with a real translation are listed. A picker offering languages that all render English would say your language is supported and then prove otherwise on the next screen." to
        "Es werden nur Sprachen mit einer echten Übersetzung aufgeführt. Eine Auswahl, deren Sprachen alle auf Englisch angezeigt werden, würde Ihre Sprache als unterstützt angeben und auf dem nächsten Bildschirm das Gegenteil zeigen.",
    "Opening a connection" to "Verbindung wird hergestellt",
    "Opening your Solana wallet" to "Ihre Solana-Wallet wird geöffnet",
    "Optional, and the part that actually counts." to
        "Optional, aber der Teil, der wirklich zählt.",
    "Passport at risk" to "Passport gefährdet",
    "Paste the link to your post. It goes into your identity note, so the note points at the post and the post carries the key. Anyone can then check both ends against one key." to
        "Füge den Link zu deinem Post ein. Er kommt in deine Identitätsnotiz, sodass die Notiz auf den Post verweist und der Post den Schlüssel enthält. Dann kann jeder beide Seiten mit demselben Schlüssel prüfen.",
    "Press Create again. Nothing was sent anywhere." to
        "Drücken Sie erneut auf Erstellen. Es wurde nichts versendet.",
    "Protect" to "Schützen",
    "Protect it" to "Schützen",
    "Publish" to "Veröffentlichen",
    "Publish your identity" to "Veröffentlichen Sie Ihre Identität",
    "Published and read back from the server" to "Veröffentlicht und vom Server zurückgelesen",
    "Published, read back, and vouched for by your key" to
        "Veröffentlicht, zurückgelesen und durch Ihren Schlüssel bestätigt",
    "Publishing your identity note to technocore.chat" to
        "Ihre Identitätsnotiz wird auf technocore.chat veröffentlicht",
    "Publishing your note" to "Ihre Notiz wird veröffentlicht",
    "Questions, answered in full" to "Fragen, ausführlich beantwortet",
    "Read from technocore.chat just now, not from this phone. Rooms are trimmed as they grow, so this is what anyone would find today." to
        "Gerade von technocore.chat gelesen, nicht von diesem Telefon. Räume werden beim Wachsen gekürzt, daher würde dies heute jeder finden.",
    "Reading your note" to "Ihre Notiz wird gelesen",
    "Reading your records" to "Ihre Datensätze werden gelesen",
    "Ready" to "Bereit",
    "Remind me once a day" to "Einmal täglich erinnern",
    "Renewed today. technocore.chat keeps it for seven days after the last write, and this app rewrites it every time you open it." to
        "Heute erneuert. technocore.chat bewahrt sie sieben Tage nach dem letzten Schreiben auf. Diese App schreibt sie jedes Mal neu, wenn du sie öffnest.",
    "Sealed by Android Keystore" to "Durch Android Keystore versiegelt",
    "Sealed by StrongBox, this phone's separate security chip" to
        "Durch StrongBox versiegelt, den separaten Sicherheitschip dieses Telefons",
    "Sealed by this phone's trusted execution environment" to
        "Durch die vertrauenswürdige Ausführungsumgebung dieses Telefons versiegelt",
    "Sealing the key in this device's secure storage" to
        "Der Schlüssel wird im sicheren Speicher dieses Geräts versiegelt",
    "Sending your signed record" to "Ihr signierter Datensatz wird gesendet",
    "Sent, but not confirmed in the room yet" to "Gesendet, aber im Raum noch nicht bestätigt",
    "Settings" to "Einstellungen",
    "Seven days without a record. Open the app to publish it again." to
        "Sieben Tage ohne Eintrag. Öffne die App, um sie erneut zu veröffentlichen.",
    "Shipped a Technocore client for the Seeker" to
        "Einen Technocore-Client für den Seeker veröffentlicht",
    "Show your private key" to "Privaten Schlüssel anzeigen",
    "Signed, accepted and found again in the room" to
        "Signiert, akzeptiert und erneut im Raum gefunden",
    "Signing your first check-in and sending it" to
        "Ihr erster Eintrag wird signiert und gesendet",
    "Somebody changed this note after your key signed for it. Publish again." to
        "Jemand hat diese Notiz geändert, nachdem Ihr Schlüssel für sie gebürgt hat. Erneut veröffentlichen.",
    "Talking to the service" to "Kommunikation mit dem Dienst",
    "Thanks for building this" to "Danke für die Entwicklung",
    "That does not look like a link to a post. It should look like https://x.com/you/status/123." to
        "Das sieht nicht wie ein Link zu einem Post aus. Er sollte so aussehen: https://x.com/you/status/123.",
    "That does not look like a link. It should start with https://" to
        "Das sieht nicht wie ein Link aus. Er sollte mit https:// beginnen",
    "That was the last step. Your Passport is live. One thing left, and it is the part FLOP actually asked for: tell people what you did. The app writes the post for you at the bottom of this screen." to
        "Das war der letzte Schritt. Dein Passport ist aktiv. Eine Sache fehlt noch, und genau darum hat FLOP gebeten: Erzähle anderen, was du gemacht hast. Die App schreibt den Beitrag unten auf diesem Bildschirm für dich.",
    "The identity is born inside Seed Vault and sealed by StrongBox on the phone." to
        "Die Identität entsteht in Seed Vault und wird auf dem Telefon durch StrongBox versiegelt.",
    "The key is sealed in this phone's secure storage, then read back and checked against your identity." to
        "Der Schlüssel wird im sicheren Speicher dieses Telefons versiegelt, dann zurückgelesen und mit Ihrer Identität abgeglichen.",
    "The manual" to "Das Handbuch",
    "The server is busy. Trying again." to "Der Server ist beschäftigt. Neuer Versuch.",
    "The stored key does not match your identity" to
        "Der gespeicherte Schlüssel stimmt nicht mit Ihrer Identität überein",
    "The wallet did not complete the signature" to
        "Die Wallet hat die Signatur nicht abgeschlossen",
    "There are no points here and no score. FLOP asked agents to do something useful, so what counts is a record a person can still open. A number invented by this app would be a different game." to
        "Hier gibt es weder Punkte noch einen Punktestand. FLOP bat Agents, etwas Nützliches zu tun, daher zählt ein Eintrag, den eine Person weiterhin öffnen kann. Eine von dieser App erfundene Zahl wäre ein anderes Spiel.",
    "These 32 bytes are your FLOP Passport itself. Whoever holds them can sign as you on Technocore. Keep them offline and never send them to anyone, including us." to
        "Diese 32 Bytes sind Ihr FLOP Passport selbst. Wer sie besitzt, kann auf Technocore als Sie signieren. Bewahren Sie sie offline auf und senden Sie sie niemals an jemanden, auch nicht an uns.",
    "This app is free and open source, and nobody paid for it. If it saved you an afternoon, a tip is welcome." to
        "Diese App ist kostenlos und quelloffen, und niemand hat dafür bezahlt. Wenn sie Ihnen einen Nachmittag erspart hat, ist ein Trinkgeld willkommen.",
    "This app is free and open source. If it was useful, you can send a tip to {name}. Your wallet opens and you choose the amount there." to
        "Diese App ist kostenlos und quelloffen. Wenn sie nützlich war, können Sie {name} ein Trinkgeld senden. Ihre Wallet öffnet sich, und den Betrag wählen Sie dort.",
    "This app is free and there is nothing in it to buy. If it has been useful, kosa.skr is where a thank you goes." to
        "Diese App ist kostenlos und es gibt nichts zu kaufen. Wenn sie dir geholfen hat, kannst du dich bei kosa.skr bedanken.",
    "This app rewrites your note every time you open it and every time you sign a record, so the seven days start again. Open it at least once a week and nothing is ever lost." to
        "Diese App schreibt deine Notiz jedes Mal neu, wenn du sie öffnest oder einen Eintrag signierst. Dadurch beginnen die sieben Tage erneut. Öffne sie mindestens einmal pro Woche, dann geht nichts verloren.",
    "This is NOT your Solana wallet key. Your wallet's own key never leaves Seed Vault and this app has never seen it. What you are looking at is a separate key that signs only on Technocore." to
        "Dies ist NICHT der Schlüssel Ihrer Solana-Wallet. Der eigene Schlüssel Ihrer Wallet verlässt Seed Vault nie, und diese App hat ihn nie gesehen. Sie sehen einen separaten Schlüssel, der nur auf Technocore signiert.",
    "Three days left before it is deleted." to "Noch drei Tage, bevor sie gelöscht wird.",
    "Told only when your identity note is days away from being deleted." to
        "Du wirst nur benachrichtigt, wenn deine Identitätsnotiz kurz vor dem Löschen steht.",
    "Tomorrow is the last day." to "Morgen ist der letzte Tag.",
    "Try again. Nothing was posted." to "Versuchen Sie es erneut. Es wurde nichts eingestellt.",
    "Try again. Nothing was published." to
        "Versuchen Sie es erneut. Es wurde nichts veröffentlicht.",
    "Two days left before it is deleted." to "Noch zwei Tage, bevor sie gelöscht wird.",
    "Use the phone's language" to "Sprache des Telefons verwenden",
    "Wait a moment and press it again to re-check. Do not treat this as a failure." to
        "Warten Sie einen Moment und drücken Sie erneut, um nochmals zu prüfen. Betrachten Sie dies nicht als Fehler.",
    "Wait a moment and press it again to re-check. Sending it as a new message would post twice in public." to
        "Warten Sie einen Moment und drücken Sie erneut, um nochmals zu prüfen. Als neue Nachricht gesendet, würde der Eintrag zweimal öffentlich erscheinen.",
    "What did you actually do?" to "Was hast du tatsächlich gemacht?",
    "What is still provable" to "Was weiterhin nachweisbar ist",
    "What recovery without a seed phrase costs" to
        "Was die Wiederherstellung ohne Seed-Phrase kostet",
    "What to do and how often, why the identity expires, why this works on a Seeker, and what the catch is. Opens in your browser." to
        "Was zu tun ist und wie oft, warum die Identität abläuft, warum das auf einem Seeker funktioniert und wo der Haken ist. Wird in deinem Browser geöffnet.",
    "Yes. Something is already visible to others." to
        "Ja. Etwas ist bereits für andere sichtbar.",
    "You do not need this file to recover. The same Solana wallet that" to
        "Sie benötigen diese Datei nicht zur Wiederherstellung. Dieselbe Solana-Wallet, die",
    "You do not need this to recover. The same Solana wallet rebuilds the same Passport on any phone. This copy is for using the key somewhere else, on your own terms." to
        "Sie benötigen dies nicht zur Wiederherstellung. Dieselbe Solana-Wallet stellt auf jedem Telefon denselben Passport wieder her. Diese Kopie dient dazu, den Schlüssel andernorts nach Ihren eigenen Bedingungen zu verwenden.",
    "You have already checked in" to "Sie haben bereits einen Eintrag erstellt",
    "You have already left a record today." to
        "Sie haben heute bereits einen Eintrag hinterlassen.",
    "You're all set" to "Alles ist bereit",
    "Your Passport is born inside Seed Vault, the Seeker's hardware key store, from which a key cannot be extracted. On this phone it is then sealed by Android's secure storage. Signing itself happens in the app, not in hardware, because Android Keystore cannot hold this kind of key - so we say sealed, not signed, in hardware." to
        "Ihr Passport entsteht in Seed Vault, dem Hardware-Schlüsselspeicher des Seeker, aus dem kein Schlüssel extrahiert werden kann. Auf diesem Telefon wird er anschließend durch den sicheren Speicher von Android versiegelt. Das Signieren selbst erfolgt in der App, nicht in der Hardware, da Android Keystore diesen Schlüsseltyp nicht speichern kann - daher sagen wir in Hardware versiegelt, nicht signiert.",
    "Your Passport is derived from one signature your wallet makes inside Seed Vault, the Seeker's hardware key store. The wallet key never leaves that hardware. The Passport key is computed from its signature in this app and then sealed by Android's secure storage - sealed, not signed, in hardware, because Android Keystore cannot hold this kind of key." to
        "Ihr Passport wird aus einer Signatur abgeleitet, die Ihre Wallet in Seed Vault, dem Hardware-Schlüsselspeicher des Seeker, erstellt. Der Wallet-Schlüssel verlässt diese Hardware nie. Der Passport-Schlüssel wird in dieser App aus der Signatur berechnet und dann durch den sicheren Speicher von Android versiegelt - in Hardware versiegelt, nicht signiert, da Android Keystore diese Art von Schlüssel nicht speichern kann.",
    "Your Passport is live" to "Ihr Passport ist aktiv",
    "Your Passport is live and your first signed record is on Technocore. Anyone can verify it, and it stays yours." to
        "Ihr Passport ist aktiv und Ihr erster signierter Eintrag befindet sich auf Technocore. Jeder kann ihn verifizieren, und er bleibt Ihrer.",
    "Your Passport is live." to "Ihr Passport ist aktiv.",
    "Your Passport is rebuilt from one wallet signature, which is why no seed phrase exists to lose. The same fact cuts the other way: any app that persuades your wallet to sign that exact sentence can rebuild this Passport. Read what a wallet asks you to sign, here and everywhere else." to
        "Ihr Passport wird aus einer einzigen Wallet-Signatur wiederhergestellt — deshalb gibt es keine Seed-Phrase, die verloren gehen kann. Das gilt auch umgekehrt: jede App, die Ihre Wallet dazu bringt, genau diesen Satz zu signieren, kann diesen Passport wiederherstellen. Lesen Sie, was eine Wallet Sie signieren lässt, hier und überall sonst.",
    "Your Passport itself is not lost: the same wallet still gives the same identity, and signing a record now publishes the note back to the same address." to
        "Dein Passport selbst ist nicht verloren: Dieselbe Wallet erzeugt weiterhin dieselbe Identität. Wenn du jetzt einen Eintrag signierst, wird die Notiz wieder unter derselben Adresse veröffentlicht.",
    "Your identity note expires soon" to "Deine Identitätsnotiz läuft bald ab",
    "Your identity note has been deleted" to "Deine Identitätsnotiz wurde gelöscht",
    "Your key is never sent anywhere. Only you can export it." to
        "Ihr Schlüssel wird niemals übertragen. Nur Sie können ihn exportieren.",
    "Your key never leaves this phone." to "Ihr Schlüssel verlässt dieses Telefon nie.",
    "Your key signed a line carrying this note's exact hash." to
        "Ihr Schlüssel hat eine Zeile mit dem exakten Hash dieser Notiz signiert.",
    "Your note has to be kept alive" to "Deine Notiz muss aktiv bleiben",
    "Your wallet signs one statement. It is not a transaction and moves no funds. The same wallet rebuilds the same Passport on any device." to
        "Ihre Wallet signiert eine Erklärung. Dies ist keine Transaktion und bewegt keine Mittel. Dieselbe Wallet stellt auf jedem Gerät denselben Passport wieder her.",
    "active days" to "aktive Tage",
    "activity" to "aktivität",
    "address" to "adresse",
    "agent: FLOP Passport for Seeker" to "Agent: FLOP Passport für Seeker",
    "algorithm: Ed25519, did:key, 32-byte seed" to
        "Algorithmus: Ed25519, did:key, 32-Byte-Seed",
    "built by a community builder" to "von einem Community-Entwickler erstellt",
    "cancel" to "abbrechen",
    "change" to "ändern",
    "changed" to "geändert",
    "check again" to "noch einmal prüfen",
    "checked" to "geprüft",
    "close" to "schließen",
    "connection" to "verbindung",
    "content" to "inhalt",
    "continue" to "fortfahren",
    "copy" to "Kopieren",
    "copy key" to "Schlüssel kopieren",
    "create passport" to "Passport erstellen",
    "created this Passport rebuilds it on any device." to
        "diesen Passport erstellt hat, stellt ihn auf jedem Gerät wieder her.",
    "danger zone" to "Gefahrenbereich",
    "day streak" to "Tagesserie",
    "delete passport from this phone" to "Passport von diesem Telefon löschen",
    "did anything go public?" to "Wurde etwas öffentlich?",
    "done" to "fertig",
    "failed" to "fehlgeschlagen",
    "fetched again and matched exactly" to "erneut abgerufen und exakt abgeglichen",
    "fetched from the server on opening" to "beim Öffnen vom Server abgerufen",
    "fingerprint" to "fingerabdruck",
    "flop-passport vault self-test" to "flop-passport Schlüsselspeicher-Selbsttest",
    "identity" to "identität",
    "identity note" to "Identitätsnotiz",
    "last connection" to "letzte verbindung",
    "linked" to "Verknüpft",
    "live records" to "aktive Einträge",
    "matched on our nonce, not just our key" to
        "anhand unserer Nonce abgeglichen, nicht nur unseres Schlüssels",
    "no thanks, continue" to "nein danke, fortfahren",
    "no, nothing was made public" to "nein, nichts wurde öffentlich gemacht",
    "not found" to "nicht gefunden",
    "not yet - the note alone is a claim, not a proof" to
        "noch nicht - die Notiz allein ist eine Behauptung, kein Nachweis",
    "off" to "aus",
    "on" to "an",
    "open" to "Öffnen",
    "our exact bytes, no wallet prefix" to "unsere exakten Bytes, ohne Wallet-Präfix",
    "passport for seeker" to "Passport für Seeker",
    "pin it to your identity" to "An Identität heften",
    "post it" to "Posten",
    "private key, 32 bytes, hex" to "privater Schlüssel, 32 Bytes, Hex",
    "protect passport" to "Passport schützen",
    "publish identity" to "Identität veröffentlichen",
    "publish these to my note" to "In meiner Notiz veröffentlichen",
    "published" to "veröffentlicht",
    "re-check with the server" to "erneut beim Server prüfen",
    "re-checked when the app opened" to "beim Öffnen der App erneut geprüft",
    "records the server still holds" to "Einträge, die der Server noch vorhält",
    "recovery" to "wiederherstellung",
    "room" to "raum",
    "save my key" to "meinen Schlüssel speichern",
    "save to a file" to "in Datei speichern",
    "say it another way" to "anders formulieren",
    "self test" to "Selbsttest",
    "send a tip" to "Trinkgeld senden",
    "send a tip in {token}" to "Trinkgeld in {token} senden",
    "send a tip to {name}" to "Trinkgeld an {name} senden",
    "sequence" to "sequenz",
    "settings" to "einstellungen",
    "sign and check in" to "signieren und Eintrag erstellen",
    "sign today's record" to "heutigen Eintrag signieren",
    "signed" to "signiert",
    "signed and verified against your DID" to "signiert und anhand Ihrer DID verifiziert",
    "storage" to "speicher",
    "support the builder" to "Entwickler unterstützen",
    "technocore.chat answered" to "technocore.chat hat geantwortet",
    "technocore.chat deletes anything nobody has written to for seven days. That includes the identity note at the address you save and share." to
        "technocore.chat löscht alles, worauf sieben Tage lang niemand geschrieben hat. Das gilt auch für die Identitätsnotiz unter der Adresse, die du speicherst und teilst.",
    "technocore.chat deletes anything with no write for seven days. Signing today rewrites your note and starts the seven days again." to
        "technocore.chat löscht alles, worauf sieben Tage lang nichts geschrieben wurde. Wenn du heute signierst, wird deine Notiz neu geschrieben und die sieben Tage beginnen erneut.",
    "technocore.chat refused the note" to "technocore.chat hat die Notiz abgelehnt",
    "technocore.chat refused the signed write" to
        "technocore.chat hat den signierten Eintrag abgelehnt",
    "the post" to "Der Post",
    "the same wallet rebuilds this identity anywhere" to
        "dieselbe Wallet stellt diese Identität überall wieder her",
    "try again" to "noch einmal versuchen",
    "unconfirmed" to "unbestätigt",
    "unsigned" to "nicht signiert",
    "verified" to "verifiziert",
    "verify it yourself" to "selbst verifizieren",
    "vouched for" to "bestätigt",
    "wallet linked" to "Wallet verknüpft",
    "what this app never does" to "was diese App niemals tut",
    "what to do" to "was zu tun ist",
    "when" to "wann",
    "with a wallet prefix, which is fine and pinned" to
        "mit einem Wallet-Präfix, der zulässig und fest hinterlegt ist",
    "working" to "wird verarbeitet",
    "yes, a signed did-note line carries its hash" to
        "ja, eine signierte did-note-Zeile enthält ihren Hash",
    "yes, delete" to "ja, löschen",
    "yes, something is already public" to "ja, etwas ist bereits öffentlich",
    "your identity" to "Ihre Identität",
    "your private key" to "Ihr privater Schlüssel",
    "{token} is preselected and you can switch it." to
        "{token} ist vorausgewählt und kann gewechselt werden.",
)
