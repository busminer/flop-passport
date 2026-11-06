package dev.alexkosa.floppassport.i18n

/**
 * Spanish.
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
internal val ES_STRINGS: Map<String, String> = mapOf(
    "06  tell them" to "06  cuéntales",
    "5 of 6" to "5 de 6",
    "A few more words, and it is yours. One real sentence is all this needs." to
        "Unas palabras más y ya es tuya. Basta con una frase de verdad.",
    "A few reminders about the last step, and then they stop." to
        "Unos pocos recordatorios sobre el último paso, y luego se acaban.",
    "A little too long. Trim it and the whole post fits, key included." to
        "Un poco largo. Recórtalo y el post entero cabe, clave incluida.",
    "A once-a-day reminder to leave today's signed record." to
        "Un recordatorio diario para dejar el registro firmado de hoy.",
    "A public note at an address derived from your key, so anyone can find and verify you later. This one goes to technocore.chat, which is someone else's public service: when it is busy it refuses, and pressing again is the answer. Two or three attempts is normal and means nothing is wrong with your phone." to
        "Una nota pública en una dirección calculada a partir de tu clave, para que cualquiera pueda encontrarte y verificarte después. Esta va a technocore.chat, que es un servicio público de otra gente: cuando está ocupado rechaza, y la respuesta es volver a pulsar. Dos o tres intentos es lo normal y significa que tu teléfono está bien.",
    "A signed record has to be left by hand, and a missed day cannot be filled in later. This is also the switch that warns you before your identity note is deleted." to
        "Debes dejar un registro firmado manualmente, y no puedes recuperar más adelante un día perdido. Esta opción también activa el aviso antes de que se elimine tu nota de identidad.",
    "A tip changes nothing about your Passport and nothing about any airdrop." to
        "Una propina no cambia nada de tu Passport ni de ningún airdrop.",
    "A tip changes nothing about your Passport, and nothing about any airdrop. It is a thank you, not a fee." to
        "Una propina no cambia nada de tu Passport ni de ningún airdrop. Es un agradecimiento, no una tarifa.",
    "About" to "Acerca de",
    "Accepted, but we could not read it back yet" to
        "Aceptado, pero aún no pudimos volver a leerlo",
    "Activity" to "Actividad",
    "All six done" to "Los seis, hechos",
    "Already checked in, found in the room" to "Registro ya firmado y encontrado en la sala",
    "Already published, read back just now" to "Ya publicado y leído de nuevo ahora mismo",
    "Android is blocking notifications for this app. Turn them on in the system settings." to
        "Android está bloqueando las notificaciones de esta aplicación. Actívalas en los ajustes del sistema.",
    "Anyone can check it at the address in step 03. This app promises nothing about any allocation, and never will." to
        "Cualquiera puede comprobarlo en la dirección del paso 03. Esta aplicación no promete ninguna asignación ni lo hará nunca.",
    "Anyone holding it can sign as you" to "Quien lo tenga puede firmar como tú",
    "Anyone holding seed_hex can sign as this identity on Technocore." to
        "Quien tenga seed_hex puede firmar como esta identidad en Technocore.",
    "Anyone who looks it up sees a key and nothing else." to
        "Quien lo consulte ve una clave y nada más.",
    "Anyone with this can be you" to "Quien tenga esto puede hacerse pasar por ti",
    "Apply" to "Aplicar",
    "Cancel" to "Cancelar",
    "Check in" to "Dejar un registro",
    "Check your connection and try again." to "Comprueba la conexión e inténtalo de nuevo.",
    "Could not open the security prompt on this screen." to
        "No se pudo abrir la solicitud de seguridad en esta pantalla.",
    "Could not reach technocore.chat" to "No se pudo acceder a technocore.chat",
    "Could not reach technocore.chat. This says nothing about your records, only about the connection." to
        "No se pudo acceder a technocore.chat. Esto no dice nada sobre tus registros, solo sobre la conexión.",
    "Could not reach the server." to "No se pudo contactar con el servidor.",
    "Could not read the key back from secure storage" to
        "No se pudo volver a leer la clave del almacenamiento seguro",
    "Create" to "Crear",
    "Create your Passport" to "Crea tu Passport",
    "Create your Passport first. There is nothing to show until something has been signed." to
        "Crea primero tu Passport. No hay nada que mostrar hasta que se haya firmado algo.",
    "Daily activity" to "Actividad diaria",
    "Daily reminder" to "Recordatorio diario",
    "Delete it?" to "¿Eliminarlo?",
    "Deleting removes the Passport from this phone only. Anything already published may stay public, and the same wallet rebuilds the same identity - so this is not a way to undo anything." to
        "Eliminar solo borra el Passport de este teléfono. Lo que ya se haya publicado puede seguir siendo público, y la misma cartera reconstruye la misma identidad; por tanto, esto no permite deshacer nada.",
    "Did you post it?" to "¿Lo publicaste?",
    "Every language listed here has a full translation." to
        "Todos los idiomas de esta lista tienen una traducción completa.",
    "FLOP Passport creates a Technocore identity from your Solana wallet and keeps the receipts." to
        "FLOP Passport crea una identidad de Technocore a partir de tu cartera Solana y conserva los comprobantes.",
    "FLOP Passport for Seeker" to "FLOP Passport para Seeker",
    "FLOP Passport for Seeker - private backup" to
        "FLOP Passport para Seeker - copia de seguridad privada",
    "FLOP Passport for Seeker by @AlexKosa1" to "FLOP Passport para Seeker por @AlexKosa1",
    "FLOP asked agents to do two things: create a unique key, and do something useful to spread the word about Technocore. The five steps above did the first. Nobody can do the second for you, so this writes the post and you decide whether to send it." to
        "FLOP pidió a los agentes que hicieran dos cosas: crear una clave única y hacer algo útil para dar a conocer Technocore. Los cinco pasos anteriores hicieron lo primero. Nadie puede hacer lo segundo por ti, así que esto escribe la publicación y tú decides si enviarla.",
    "Identity derived from your wallet signature" to
        "Identidad derivada de la firma de tu cartera",
    "If it does get deleted, your Passport is not gone: the same wallet still gives the same identity, and signing a record publishes the note back to the same address." to
        "Si se elimina, tu Passport no desaparece: la misma cartera sigue generando la misma identidad, y firmar un registro vuelve a publicar la nota en la misma dirección.",
    "In one line: what you did, or why you set this up" to
        "En una línea: qué hiciste, o por qué lo creaste",
    "It never asks for your wallet recovery phrase." to
        "Nunca pide la frase de recuperación de tu cartera.",
    "It promises nothing about any airdrop, and never will." to
        "No promete nada sobre ningún airdrop ni lo hará nunca.",
    "Keep this file offline. Never send it to anyone, including the app author." to
        "Mantén este archivo sin conexión. Nunca lo envíes a nadie, ni siquiera al autor de la aplicación.",
    "Language" to "Idioma",
    "Last reminder about this one." to "Último recordatorio sobre esto.",
    "Make your first signed check-in" to "Deja tu primer registro firmado",
    "Next: create your Passport from your wallet." to
        "Siguiente: crea tu Passport desde tu cartera.",
    "Next: make your first signed check-in." to "Siguiente: deja tu primer registro firmado.",
    "Next: publish your identity so anyone can verify you." to
        "Siguiente: publica tu identidad para que cualquiera pueda verificarte.",
    "Next: seal the key in this phone's secure storage." to
        "Siguiente: sella la clave en el almacenamiento seguro de este teléfono.",
    "No account, no server of ours, no analytics." to
        "Sin cuenta, sin servidor propio y sin analíticas.",
    "No wallet on this phone opened the payment link." to
        "Ninguna cartera de este teléfono abrió el enlace de pago.",
    "No. Nothing was published." to "No. No se publicó nada.",
    "Not checked yet." to "Aún no comprobado.",
    "Not done. Your Passport is not attached to any public name yet, and this is the one step nobody can do for you." to
        "Sin hacer. Tu Passport todavía no está ligado a ningún nombre público, y este es el paso que nadie puede dar por ti.",
    "Nothing asked yet" to "Aún no se ha solicitado nada",
    "Nothing found. If you signed something and it is not here, the room has been trimmed past it - which is normal, and exactly why this screen exists." to
        "No se encontró nada. Si firmaste algo y no aparece aquí, la sala ya lo ha descartado, lo cual es normal y es precisamente el motivo de esta pantalla.",
    "Nothing has vouched for this text yet. Publish again to sign for it." to
        "Nada ha respaldado este texto todavía. Publica de nuevo para firmarlo.",
    "Nothing is broken and nothing is lost. Your Passport works. When you want the public half of it, step 06 is waiting where you left it." to
        "No hay nada roto ni nada perdido. Tu Passport funciona. Cuando quieras su mitad pública, el paso 06 sigue donde lo dejaste.",
    "Nothing signed today yet." to "Aún no se ha firmado nada hoy.",
    "One step left" to "Queda un paso",
    "Only languages with a real translation are listed. A picker offering languages that all render English would say your language is supported and then prove otherwise on the next screen." to
        "Solo se muestran idiomas con una traducción real. Un selector que ofreciera idiomas que se muestran todos en inglés diría que tu idioma es compatible y demostraría lo contrario en la pantalla siguiente.",
    "Opening a connection" to "Abriendo una conexión",
    "Opening your Solana wallet" to "Abriendo tu cartera Solana",
    "Post your line, then come back and paste the link. That is what attaches your name to your key, and it is the half FLOP asked agents for." to
        "Publica tu línea y vuelve a pegar el enlace. Eso es lo que une tu nombre a tu clave, y es la mitad que FLOP pidió a los agentes.",
    "Protect" to "Proteger",
    "Protect it" to "Protégelo",
    "Publish" to "Publicar",
    "Publish your identity" to "Publica tu identidad",
    "Published and read back from the server" to "Publicado y leído de nuevo desde el servidor",
    "Published, read back, and vouched for by your key" to
        "Publicado, leído de nuevo y respaldado por tu clave",
    "Publishing your identity note to technocore.chat" to
        "Publicando tu nota de identidad en technocore.chat",
    "Publishing your note" to "Publicando tu nota",
    "Questions, answered in full" to "Preguntas, respondidas por completo",
    "Read from technocore.chat just now, not from this phone. Rooms are trimmed as they grow, so this is what anyone would find today." to
        "Leído ahora mismo desde technocore.chat, no desde este teléfono. Las salas se recortan al crecer, así que esto es lo que cualquiera encontraría hoy.",
    "Reading your note" to "Leyendo tu nota",
    "Reading your records" to "Leyendo tus registros",
    "Ready" to "Listo",
    "Remind me once a day" to "Recordármelo una vez al día",
    "Renewed today. technocore.chat keeps it for seven days after the last write, and this app rewrites it every time you open it." to
        "Renovada hoy. technocore.chat la conserva durante siete días desde la última vez que se escribió en ella, y esta aplicación vuelve a escribirla cada vez que la abres.",
    "Sealed by Android Keystore" to "Sellado por Android Keystore",
    "Sealed by StrongBox, this phone's separate security chip" to
        "Sellado por StrongBox, el chip de seguridad independiente de este teléfono",
    "Sealed by this phone's trusted execution environment" to
        "Sellado por el entorno de ejecución de confianza de este teléfono",
    "Sealing the key in this device's secure storage" to
        "Sellando la clave en el almacenamiento seguro de este dispositivo",
    "Sending your signed record" to "Enviando tu registro firmado",
    "Sent, but not confirmed in the room yet" to "Enviado, pero aún no confirmado en la sala",
    "Settings" to "Ajustes",
    "Show your private key" to "Mostrar tu clave privada",
    "Signed, accepted and found again in the room" to
        "Firmado, aceptado y encontrado de nuevo en la sala",
    "Signing your first check-in and sending it" to "Firmando y enviando tu primer registro",
    "Somebody changed this note after your key signed for it. Publish again." to
        "Alguien cambió esta nota después de que tu clave la respaldara. Publica de nuevo.",
    "Still one step short" to "Todavía falta un paso",
    "Talking to the service" to "Comunicándose con el servicio",
    "Thanks for building this" to "Gracias por crear esto",
    "That does not look like a link to a post. It should look like https://x.com/you/status/123." to
        "Eso no parece un enlace a una publicación. Debería ser similar a https://x.com/you/status/123.",
    "The key is sealed in this phone's secure storage, then read back and checked against your identity." to
        "La clave se sella en el almacenamiento seguro de este teléfono, se vuelve a leer y se compara con tu identidad.",
    "The manual" to "El manual",
    "The server is busy. Trying again." to "El servidor está ocupado. Intentándolo de nuevo.",
    "The stored key does not match your identity" to
        "La clave almacenada no coincide con tu identidad",
    "The wallet did not complete the signature" to "La cartera no completó la firma",
    "There are no points here and no score. FLOP asked agents to do something useful, so what counts is a record a person can still open. A number invented by this app would be a different game." to
        "Aquí no hay puntos ni puntuación. FLOP pidió a los agentes que hicieran algo útil, así que lo que cuenta es un registro que una persona aún pueda abrir. Un número inventado por esta aplicación sería otro juego.",
    "These 32 bytes are your FLOP Passport itself. Whoever holds them can sign as you on Technocore. Keep them offline and never send them to anyone, including us." to
        "Estos 32 bytes son tu propio FLOP Passport. Quien los tenga puede firmar como tú en Technocore. Mantenlos sin conexión y nunca se los envíes a nadie, tampoco a nosotros.",
    "This app is free and open source, and nobody paid for it. If it saved you an afternoon, a tip is welcome." to
        "Esta aplicación es gratuita y de código abierto, y nadie pagó por crearla. Si te ahorró una tarde, puedes dejar una propina.",
    "This app is free and open source. If it was useful, you can send a tip to {name}. Your wallet opens and you choose the amount there." to
        "Esta aplicación es gratuita y de código abierto. Si te resultó útil, puedes enviar una propina a {name}. Tu cartera se abre y allí eliges el importe.",
    "This app rewrites your note every time you open it and every time you sign a record, so the seven days start again. Open it at least once a week and nothing is ever lost." to
        "Esta aplicación vuelve a escribir tu nota cada vez que la abres y cada vez que firmas un registro, por lo que el plazo de siete días comienza de nuevo. Ábrela al menos una vez por semana y nunca se perderá nada.",
    "This is NOT your Solana wallet key. Your wallet's own key never leaves Seed Vault and this app has never seen it. What you are looking at is a separate key that signs only on Technocore." to
        "Esta NO es la clave de tu cartera Solana. La clave de tu cartera nunca sale de Seed Vault y esta aplicación nunca la ha visto. Lo que estás viendo es una clave independiente que solo firma en Technocore.",
    "This line is what makes the post yours. Everything under it is the proof." to
        "Esta línea es lo que hace tuyo el post. Todo lo de abajo es la prueba.",
    "Three days left before it is deleted." to "Quedan tres días para que se elimine.",
    "Today cannot be added later" to "Hoy no se puede añadir después",
    "Told only when your identity note is days away from being deleted." to
        "Solo recibirás un aviso cuando falten pocos días para que se elimine tu nota de identidad.",
    "Tomorrow is the last day." to "Mañana es el último día.",
    "Two days left before it is deleted." to "Quedan dos días para que se elimine.",
    "Unfinished setup" to "Configuración sin terminar",
    "Use the phone's language" to "Usar el idioma del teléfono",
    "Wait a moment and press it again to re-check. Do not treat this as a failure." to
        "Espera un momento y vuelve a pulsarlo para comprobarlo de nuevo. No lo consideres un fallo.",
    "Wait a moment and press it again to re-check. Sending it as a new message would post twice in public." to
        "Espera un momento y vuelve a pulsarlo para comprobarlo de nuevo. Enviarlo como un mensaje nuevo lo publicaría dos veces.",
    "What is still provable" to "Lo que aún puede demostrarse",
    "What recovery without a seed phrase costs" to "Lo que cuesta recuperar sin frase semilla",
    "What to do and how often, why the identity expires, why this works on a Seeker, and what the catch is. Opens in your browser." to
        "Qué hacer y con qué frecuencia, por qué caduca la identidad, por qué funciona en un Seeker y cuál es la pega. Se abre en tu navegador.",
    "Write one line only you would write. Posts that differ from each other by nothing but a key get read as farming, and that lands on the people who did the work." to
        "Escribe una línea que solo tú escribirías. Los posts que se diferencian entre sí únicamente por una clave se leen como granjeo, y eso recae sobre quienes sí hicieron el trabajo.",
    "Yes. Something is already visible to others." to
        "Sí. Algo ya es visible para otras personas.",
    "You do not need this file to recover. The same Solana wallet that" to
        "No necesitas este archivo para recuperarlo. La misma cartera Solana que",
    "You do not need this to recover. The same Solana wallet rebuilds the same Passport on any phone. This copy is for using the key somewhere else, on your own terms." to
        "No necesitas esto para recuperarlo. La misma cartera Solana reconstruye el mismo Passport en cualquier teléfono. Esta copia sirve para usar la clave en otro lugar, en tus propios términos.",
    "You finished the five. The last one takes a minute." to
        "Terminaste los cinco. El último lleva un minuto.",
    "You have already checked in" to "Ya has dejado un registro",
    "You have already left a record today." to "Ya has dejado un registro hoy.",
    "You're all set" to "Todo está listo",
    "Your Passport has no name on it" to "Tu Passport no lleva ningún nombre",
    "Your Passport is derived from one signature your wallet makes inside Seed Vault, the Seeker's hardware key store. The wallet key never leaves that hardware. The Passport key is computed from its signature in this app and then sealed by Android's secure storage - sealed, not signed, in hardware, because Android Keystore cannot hold this kind of key." to
        "Tu Passport se deriva de una firma que tu cartera crea dentro de Seed Vault, el almacén de claves de hardware del Seeker. La clave de la cartera nunca sale de ese hardware. La clave del Passport se calcula a partir de esa firma en esta aplicación y luego se sella mediante el almacenamiento seguro de Android: se sella, no se firma, en hardware, porque Android Keystore no admite este tipo de clave.",
    "Your Passport is live" to "Tu Passport está activo",
    "Your Passport is live and your first signed record is on Technocore. Anyone can verify it, and it stays yours." to
        "Tu Passport está activo y tu primer registro firmado está en Technocore. Cualquiera puede verificarlo y sigue siendo tuyo.",
    "Your Passport is live. One step left." to "Tu Passport está activo. Queda un paso.",
    "Your Passport is rebuilt from one wallet signature, which is why no seed phrase exists to lose. The same fact cuts the other way: any app that persuades your wallet to sign that exact sentence can rebuild this Passport. Read what a wallet asks you to sign, here and everywhere else." to
        "Tu Passport se reconstruye a partir de una sola firma de la cartera, por eso no hay ninguna frase semilla que perder. Lo mismo vale al revés: cualquier aplicación que convenza a tu cartera de firmar esa frase exacta puede reconstruir este Passport. Lee lo que una cartera te pide firmar, aquí y en todas partes.",
    "Your identity note expires soon" to "Tu nota de identidad caduca pronto",
    "Your identity note has been deleted" to "Tu nota de identidad ha sido eliminada",
    "Your key is never sent anywhere. Only you can export it." to
        "Tu clave nunca se envía a ningún sitio. Solo tú puedes exportarla.",
    "Your key signed a line carrying this note's exact hash." to
        "Tu clave firmó una línea con el hash exacto de esta nota.",
    "Your note has to be kept alive" to "Debes mantener activa tu nota",
    "Your post is in your identity note, at your key's own address." to
        "Tu post está en tu nota de identidad, en la propia dirección de tu clave.",
    "Your wallet signs one statement. It is not a transaction and moves no funds. The same wallet rebuilds the same Passport on any device." to
        "Tu cartera firma una declaración. No es una transacción ni mueve fondos. La misma cartera reconstruye el mismo Passport en cualquier dispositivo.",
    "active days" to "días activos",
    "activity" to "actividad",
    "address" to "dirección",
    "algorithm: Ed25519, did:key, 32-byte seed" to
        "algoritmo: Ed25519, did:key, semilla de 32 bytes",
    "attach it" to "adjuntar",
    "built by a community builder" to "creado por un desarrollador de la comunidad",
    "cancel" to "cancelar",
    "change" to "cambiar",
    "changed" to "modificada",
    "check again" to "volver a comprobar",
    "checked" to "comprobado",
    "close" to "cerrar",
    "connection" to "conexión",
    "content" to "contenido",
    "continue" to "continuar",
    "copy" to "copiar",
    "copy key" to "copiar clave",
    "create passport" to "crear passport",
    "created this Passport rebuilds it on any device." to
        "creó este Passport lo reconstruye en cualquier dispositivo.",
    "danger zone" to "zona de peligro",
    "day streak" to "racha de días",
    "delete passport from this phone" to "eliminar passport de este teléfono",
    "detail" to "detalle",
    "did anything go public?" to "¿se hizo público algo?",
    "done" to "listo",
    "failed" to "fallido",
    "fetched again and matched exactly" to "obtenido de nuevo y con coincidencia exacta",
    "fetched from the server on opening" to "obtenido del servidor al abrir",
    "fingerprint" to "huella digital",
    "flop-passport vault self-test" to "autoprueba del almacén flop-passport",
    "identity" to "identidad",
    "identity note" to "nota de identidad",
    "language {code}" to "idioma {code}",
    "last connection" to "última conexión",
    "linked" to "vinculado",
    "live records" to "registros activos",
    "matched on our nonce, not just our key" to
        "coincidencia con nuestro nonce, no solo con nuestra clave",
    "no thanks, continue" to "no, gracias; continuar",
    "no, nothing was made public" to "no, nada se hizo público",
    "nonce" to "nonce",
    "not found" to "no encontrado",
    "not yet" to "todavía no",
    "not yet - the note alone is a claim, not a proof" to
        "aún no; la nota por sí sola es una afirmación, no una prueba",
    "off" to "desactivado",
    "on" to "activado",
    "open" to "abrir",
    "our exact bytes, no wallet prefix" to "nuestros bytes exactos, sin prefijo de cartera",
    "passport for seeker" to "passport para seeker",
    "pin it to your identity" to "fíjalo a tu identidad",
    "private key, 32 bytes, hex" to "clave privada, 32 bytes, hexadecimal",
    "protect passport" to "proteger passport",
    "publish identity" to "publicar identidad",
    "published" to "publicado",
    "publishing" to "publicando",
    "re-check with the server" to "comprobar de nuevo con el servidor",
    "re-checked when the app opened" to "comprobado de nuevo al abrir la aplicación",
    "records the server still holds" to "registros que el servidor aún conserva",
    "recovery" to "recuperación",
    "room" to "sala",
    "save to a file" to "guardar en un archivo",
    "say it another way" to "decirlo de otra forma",
    "self test" to "autoprueba",
    "send a tip" to "enviar una propina",
    "send a tip in {token}" to "enviar una propina en {token}",
    "send a tip to {name}" to "enviar una propina a {name}",
    "sequence" to "secuencia",
    "settings" to "ajustes",
    "sign and check in" to "firmar y dejar un registro",
    "sign today's record" to "firmar el registro de hoy",
    "signed" to "firmado",
    "signed and verified against your DID" to "firmado y verificado con tu DID",
    "step {n} {title} complete" to "paso {n} {title} completado",
    "step {n} {title} did not finish" to "paso {n} {title} no se completó",
    "storage" to "almacenamiento",
    "support the builder" to "apoyar al desarrollador",
    "technocore.chat answered" to "technocore.chat respondió",
    "technocore.chat deletes anything nobody has written to for seven days. That includes the identity note at the address you save and share." to
        "technocore.chat elimina todo aquello en lo que nadie haya escrito durante siete días. Esto incluye la nota de identidad de la dirección que guardas y compartes.",
    "technocore.chat refused the note" to "technocore.chat rechazó la nota",
    "technocore.chat refused the signed write" to
        "technocore.chat rechazó la escritura firmada",
    "text" to "texto",
    "the note changed between reads" to "la nota cambió entre lecturas",
    "the post" to "la publicación",
    "the same wallet rebuilds this identity anywhere" to
        "la misma cartera reconstruye esta identidad en cualquier lugar",
    "try again" to "reintentar",
    "unconfirmed" to "sin confirmar",
    "unsigned" to "sin firmar",
    "verified" to "verificado",
    "verify it yourself" to "verifícalo tú mismo",
    "version" to "versión",
    "vouched for" to "respaldado",
    "wallet" to "cartera",
    "wallet linked" to "cartera vinculada",
    "what this app never does" to "lo que esta aplicación nunca hace",
    "what to do" to "qué hacer",
    "when" to "cuándo",
    "working" to "procesando",
    "yes, a signed did-note line carries its hash" to
        "sí, una línea did-note firmada contiene su hash",
    "yes, delete" to "sí, eliminar",
    "yes, something is already public" to "sí, algo ya es público",
    "your identity" to "tu identidad",
    "your private key" to "tu clave privada",
    "{token} is preselected and you can switch it." to
        "{token} está preseleccionado y puedes cambiarlo.",
    "Try again. Nothing was sent anywhere." to
        "Inténtalo de nuevo. No se envió nada a ninguna parte.",
    "Try again. technocore.chat is a public service and it refuses writes when it is busy, which has nothing to do with this app, your phone or your key. Two or three attempts is normal. Nothing was published." to
        "Inténtalo de nuevo. technocore.chat es un servicio público y rechaza escrituras cuando está ocupado, lo que no tiene nada que ver con esta app, tu teléfono ni tu clave. Dos o tres intentos es lo normal. No se publicó nada.",
    "Try again. technocore.chat is a public service and it refuses writes when it is busy, which has nothing to do with this app, your phone or your key. Two or three attempts is normal. Nothing was posted." to
        "Inténtalo de nuevo. technocore.chat es un servicio público y rechaza escrituras cuando está ocupado, lo que no tiene nada que ver con esta app, tu teléfono ni tu clave. Dos o tres intentos es lo normal. No se envió nada.",
    "Could not reach technocore.chat. Check your connection and try again; nothing was lost." to
        "No se pudo conectar con technocore.chat. Revisa tu conexión e inténtalo de nuevo; no se perdió nada.",
    "The service took your record but has not shown it back yet. Press re-check in a moment; nothing needs signing again." to
        "El servicio aceptó tu registro pero todavía no lo devuelve. Pulsa volver a comprobar en un momento; no hace falta firmar nada otra vez.",
    "technocore.chat refused the record. It refuses writes when it is busy - try again in a moment." to
        "technocore.chat rechazó el registro. Rechaza escrituras cuando está ocupado; inténtalo de nuevo en un momento.",
    "Not finished yet. Your Passport is not live until all five are green, and there is nothing complete for anyone to verify. Keep going." to
        "Aún no está terminado. Tu Passport no está activo hasta que los cinco estén en verde, y no hay nada completo que nadie pueda verificar. Sigue.",
    "A message signed by your Passport, posted to a quiet room and then read back to prove it landed. Same service as step 03, same rule: if it refuses, press again. That is the service being busy, not a problem with your key." to
        "Un mensaje firmado por tu Passport, publicado en una sala tranquila y luego leído de vuelta para probar que llegó. El mismo servicio que en el paso 03 y la misma regla: si rechaza, pulsa otra vez. Es el servicio estando ocupado, no un problema con tu clave.",
    "Deleted after seven days with nothing written to it. Publish it now and it goes back to the same address." to
        "Se borra a los siete días sin que se escriba nada en ella. Publícala ahora y vuelve a la misma dirección.",
    "Identity note at risk" to
        "Tu nota de identidad corre peligro",
    "In Settings, delete the Passport from this phone, then create it again from your wallet." to
        "En Ajustes, borra el Passport de este teléfono y créalo otra vez desde tu cartera.",
    "It is deleted after seven days with nothing written to it. Opening this app writes it." to
        "Se borra a los siete días sin que se escriba nada en ella. Abrir esta app ya escribe en ella.",
    "Maybe. The service accepted it, and this app could not read it back to be sure." to
        "Puede que sí. El servicio lo aceptó, pero esta app no pudo volver a leerlo para asegurarse.",
    "That was the last of the five. Your Passport is live. One thing left, and it is the part FLOP actually asked for: tell people what you did. The app writes the post for you at the bottom of this screen." to
        "Ese fue el último de los cinco. Tu Passport está activo. Queda una cosa, y es justo lo que FLOP pidió: cuéntale a la gente lo que hiciste. La app escribe la publicación por ti al final de esta pantalla.",
    "This app is free and there is nothing in it to buy. If it has been useful, a thank you can go to kosa.skr." to
        "Esta app es gratis y no hay nada que comprar dentro. Si te ha servido, puedes mandar un gracias a kosa.skr.",
    "checking" to
        "comprobando",
    "open notification settings" to
        "abrir ajustes de notificaciones",
    "send a tip to kosa.skr" to
        "enviar una propina a kosa.skr",
    "show my private key" to
        "mostrar mi clave privada",
    "step {n} {title} not confirmed yet" to
        "el paso {n} {title} aún no está confirmado",
    "technocore.chat deletes anything with no write for seven days. Opening this app rewrites your note, and so does signing a record. Either one starts the seven days again." to
        "technocore.chat borra todo aquello en lo que nadie ha escrito durante siete días. Abrir esta app reescribe tu nota, y firmar un registro también. Cualquiera de las dos cosas empieza los siete días de nuevo.",
    "This phone has no screen lock set up. Add a PIN or a fingerprint first." to
        "Este teléfono no tiene bloqueo de pantalla. Configura primero un PIN o una huella.",
    "The server accepted the write but the message is not in the room yet. Do not resend: read the room again first." to
        "El servidor aceptó la escritura, pero el mensaje aún no está en la sala. No lo vuelvas a enviar: lee la sala otra vez primero.",
    "The stored text differs from the text we signed" to
        "El texto guardado no coincide con el que firmamos",
    "The stored record did not verify against this key" to
        "El registro guardado no se verifica con esta clave",
    "You made a key only your wallet can rebuild, sealed it in this phone, published it where a stranger can find it, signed a record and proved it landed, and put your post beside your key. There is nothing left to set up." to
        "Creaste una clave que solo tu cartera puede reconstruir, la sellaste en este teléfono, la publicaste donde un desconocido puede encontrarla, firmaste un registro y probaste que llegó, y pusiste tu publicación junto a tu clave. No queda nada por configurar.",
    "open Activity" to
        "abrir Actividad",
    "{n} more characters and the button below wakes up." to
        "{n} caracteres más y el botón de abajo se activa.",
    "A signed record is dated evidence that you were here. A day without one cannot be added later, and signing also keeps your identity note alive. Nothing here promises anything about any allocation." to
        "Un registro firmado es una prueba fechada de que estuviste aquí. Un día sin registro no se puede añadir después, y firmar también mantiene viva tu nota de identidad. Nada aquí promete ninguna asignación.",
    "Could not check technocore.chat for your published steps. This says nothing about them, only about the connection. Re-check when you are back online." to
        "No se pudo consultar a technocore.chat sobre tus pasos publicados. Esto no dice nada sobre ellos, solo sobre la conexión. Vuelve a comprobarlo cuando tengas conexión.",
    "Could not reach technocore.chat. Check your connection and press publish again. Your link is saved on this phone either way." to
        "No se pudo conectar con technocore.chat. Comprueba tu conexión y pulsa publicar de nuevo. Tu enlace queda guardado en este teléfono de todos modos.",
    "Could not read the key from secure storage. Restart the phone and try again." to
        "No se pudo leer la clave del almacenamiento seguro. Reinicia el teléfono e inténtalo de nuevo.",
    "FLOP Passport is an independent community project. It is not made, endorsed or reviewed by FLOP Labs or by Solana Mobile." to
        "FLOP Passport es un proyecto independiente de la comunidad. No está hecho, respaldado ni revisado por FLOP Labs ni por Solana Mobile.",
    "Finish the steps on the Passport tab first. Daily records start once your Passport is live." to
        "Termina primero los pasos en la pestaña Passport. Los registros diarios empiezan cuando tu Passport esté activo.",
    "From now on: open the app at least once a week, so your identity note is not deleted. On the days you do something, open Activity and sign that day's record - a day cannot be added later." to
        "A partir de ahora: abre la app al menos una vez a la semana, para que tu nota de identidad no se borre. Los días que hagas algo, abre Actividad y firma el registro de ese día; un día no se puede añadir después.",
    "If you did something today, sign a record for it now." to
        "Si hoy hiciste algo, firma un registro ahora.",
    "Link to your post on X" to
        "Enlace a tu publicación en X",
    "Nothing was saved. Open your private key again and save it from there." to
        "No se guardó nada. Abre tu clave privada de nuevo y guárdala desde ahí.",
    "Paste the link here and your name goes beside your key, in your identity note. This is the part people mean to do later and then do not." to
        "Pega el enlace aquí y tu nombre quedará junto a tu clave, en tu nota de identidad. Esta es la parte que la gente piensa hacer luego y después no hace.",
    "Paste the link to your post on X. It goes into your identity note, so the note points at the post and the post carries the key. Anyone can then check both ends against one key. The app does not open the link or check the post; anyone reading your note can." to
        "Pega el enlace a tu publicación en X. Va a tu nota de identidad, de modo que la nota apunta a la publicación y la publicación lleva la clave. Así cualquiera puede comprobar ambos extremos con una sola clave. La app no abre el enlace ni comprueba la publicación; cualquiera que lea tu nota puede hacerlo.",
    "Read from technocore.chat, not from this phone. Rooms are trimmed as they grow, so this shows what anyone would find today." to
        "Se lee de technocore.chat, no de este teléfono. Las salas se recortan a medida que crecen, así que esto muestra lo que cualquiera encontraría hoy.",
    "Seeker and Solana Mobile are trademarks of Solana Mobile, used only to say what this app is built for. FLOP and Technocore are names of the project whose public service this app writes to." to
        "Seeker y Solana Mobile son marcas de Solana Mobile, usadas solo para decir para qué está hecha esta app. FLOP y Technocore son nombres del proyecto a cuyo servicio público escribe esta app.",
    "Seven days without opening the app. Open it and press publish; the note goes back to the same address." to
        "Siete días sin abrir la app. Ábrela y pulsa publicar; la nota vuelve a la misma dirección.",
    "The file could not be written. Try another location." to
        "No se pudo escribir el archivo. Prueba otra ubicación.",
    "The five steps built your identity. Nobody outside this phone knows it is yours yet. Step 06 below: write one line, post it, then come back and paste the link. That last part is what puts your name beside your key, and it is where people stop." to
        "Los cinco pasos construyeron tu identidad. Fuera de este teléfono nadie sabe aún que es tuya. Paso 06 abajo: escribe una línea, publícala y vuelve a pegar el enlace. Esa última parte es lo que pone tu nombre junto a tu clave, y es donde la gente se detiene.",
    "The key could not be sealed in this phone's secure storage" to
        "No se pudo sellar la clave en el almacenamiento seguro de este teléfono",
    "The link you paste goes into your identity note, at an address derived from your own key. The note stays as long as you keep opening the app; seven days without a write and it is deleted." to
        "El enlace que pegas va a tu nota de identidad, en una dirección derivada de tu propia clave. La nota se mantiene mientras sigas abriendo la app; siete días sin una escritura y se borra.",
    "The note was accepted, but it could not be read back yet." to
        "La nota fue aceptada, pero aún no se pudo leer de vuelta.",
    "The record was sent but no answer came back in time. Do not resend: read the room again first." to
        "El registro se envió pero no llegó respuesta a tiempo. No lo reenvíes: vuelve a leer la sala primero.",
    "Three things, in this order: write your line, post it on X, then come back and paste the link. The last one is what puts your name beside your key, and it is the one people forget." to
        "Tres cosas, en este orden: escribe tu línea, publícala en X y vuelve a pegar el enlace. La última es la que pone tu nombre junto a tu clave, y es la que la gente olvida.",
    "Today is the last day. It is deleted within 24 hours unless you open the app." to
        "Hoy es el último día. Se borra en las próximas 24 horas a menos que abras la app.",
    "Try again. If it keeps failing, restart the phone and try once more. Nothing was sent anywhere." to
        "Inténtalo de nuevo. Si sigue fallando, reinicia el teléfono y prueba una vez más. No se envió nada a ningún sitio.",
    "Your Passport is live, it is yours, and your post link is on it." to
        "Tu Passport está activo, es tuyo y el enlace a tu publicación está en él.",
    "Your Passport itself is not lost: the same wallet still gives the same identity, and publishing again puts the note back at the same address." to
        "Tu Passport en sí no se ha perdido: el mismo monedero sigue dando la misma identidad, y publicar de nuevo devuelve la nota a la misma dirección.",
    "checking with the server" to
        "comprobando con el servidor",
    "independent project" to
        "proyecto independiente",
    "not in your note yet" to
        "aún no está en tu nota",
    "post it on X" to
        "publicar en X",
    "put it in my note" to
        "ponerlo en mi nota",
    "technocore.chat did not take the change. It refuses writes when it is busy - press publish again in a moment. Your link is saved on this phone either way." to
        "technocore.chat no aceptó el cambio. Rechaza escrituras cuando está ocupado; pulsa publicar de nuevo en un momento. Tu enlace queda guardado en este teléfono de todos modos.",
    "vault: not sealed yet" to
        "bóveda: aún sin sellar",
    "vault: secure area" to
        "bóveda: zona segura",
    "vault: security chip" to
        "bóveda: chip de seguridad",
    "vault: software" to
        "bóveda: software",
    "with a wallet prefix - this Passport rebuilds only through this same wallet app" to
        "con prefijo del monedero: este Passport solo se reconstruye con esta misma app de monedero",
    "The prompt for this app begins with FLOP Passport key derivation v1 and names the app dev.alexkosa.floppassport; your wallet shows it was requested by flop.alexkosa.dev." to
        "La solicitud de esta app empieza con FLOP Passport key derivation v1 y nombra la app dev.alexkosa.floppassport; tu monedero muestra que la pidió flop.alexkosa.dev.",

    // 2.0: FLOP account, my day, guide and questions (2026-11-03).
    "@flop_labs is FLOP's account on X, YouTube and TikTok." to
        "@flop_labs es la cuenta de FLOP en X, YouTube y TikTok.",
    "A FLOP account with daily FLOP" to
        "Una cuenta de FLOP con FLOP cada día",
    "A flop.finance address, but not one FLOP lists publicly. Ask through x.com/flop_labs." to
        "Una dirección de flop.finance, pero no una que FLOP publique. Pregunta a través de x.com/flop_labs.",
    "A flop.finance address. FLOP lists security@flop.finance as its one public contact." to
        "Una dirección de flop.finance. FLOP indica security@flop.finance como su único contacto público.",
    "A model you pay in FLOP, and a streak" to
        "Un modelo que pagas en FLOP, y una racha",
    "A practice network, open to everyone since 3 November 2026. FLOP here has no value, earns nothing and can be wiped in a reset. Use it to learn the day before it counts." to
        "Una red de práctica, abierta a todos desde el 3 de noviembre de 2026. Aquí el FLOP no tiene valor, no da nada y puede borrarse en un reinicio. Úsala para aprender el día antes de que cuente.",
    "A streak counts days in a row with a signed record. One missed day a week is now forgiven; two missed days in a row end it. The count is read from the public room, so a day you did not sign cannot be added later." to
        "Una racha cuenta los días seguidos con un registro firmado. Ahora se perdona un día perdido por semana; dos días perdidos seguidos la terminan. La cuenta se lee de la sala pública, así que un día que no firmaste no se puede añadir después.",
    "About 90 days. This is where FLOP's agent airdrop is earned: the testnet FLOP you spend on the model is recorded as your claim on mainnet FLOP." to
        "Unos 90 días. Aquí es donde se gana el airdrop de agentes de FLOP: el FLOP de testnet que gastas en el modelo queda registrado como tu derecho sobre FLOP de mainnet.",
    "Alex Kosa, one developer, for Seeker owners. It is not made by FLOP Labs. It is free and its code is open." to
        "Alex Kosa, un único desarrollador, para los dueños de un Seeker. No está hecha por FLOP Labs. Es gratuita y su código es abierto.",
    "An identity made by your wallet" to
        "Una identidad creada por tu cartera",
    "Ask a question, see what it cost, and keep a streak of the days you show up." to
        "Haz una pregunta, mira cuánto costó y mantén una racha de los días que apareces.",
    "Ask anything. The model is small, so short, plain questions work best. Each answer costs a few devnet FLOP, taken from your Passport's allowance." to
        "Pregunta lo que quieras. El modelo es pequeño, así que funcionan mejor las preguntas cortas y sencillas. Cada respuesta cuesta unos pocos FLOP de devnet, que salen del cupo de tu Passport.",
    "Ask the model" to
        "Preguntar al modelo",
    "Ask the model one question" to
        "Hazle una pregunta al modelo",
    "Blocks are being finalised normally." to
        "Los bloques se están finalizando con normalidad.",
    "Could not reach FLOP's gateway. Check your connection and try again." to
        "No se pudo acceder a la pasarela de FLOP. Comprueba la conexión e inténtalo de nuevo.",
    "Could not reach technocore.chat." to
        "No se pudo acceder a technocore.chat.",
    "Could not reach the FLOP devnet node. This says nothing about your balance, only about the connection." to
        "No se pudo acceder al nodo de devnet de FLOP. Esto no dice nada sobre tu saldo, solo sobre la conexión.",
    "Could not reach the FLOP explorer." to
        "No se pudo acceder al explorador de FLOP.",
    "Could not reach the FLOP faucet. Check your connection and try again." to
        "No se pudo acceder al faucet de FLOP. Comprueba la conexión e inténtalo de nuevo.",
    "Devnet FLOP is practice money: it has no value and can be wiped in a reset." to
        "El FLOP de devnet es dinero de práctica: no tiene valor y puede borrarse en un reinicio.",
    "Devnet explorer" to
        "Explorador de devnet",
    "Devnet is open" to
        "La devnet está abierta",
    "Devnet is open to everyone since 3 November 2026. It has no rewards and may be reset. Testnet has no date yet; FLOP will announce it on x.com/flop_labs. On testnet, the testnet FLOP an agent spends on inference becomes its claim on mainnet FLOP. Creating accounts earns nothing." to
        "La devnet está abierta a todos desde el 3 de noviembre de 2026. No tiene recompensas y puede reiniciarse. La testnet aún no tiene fecha; FLOP la anunciará en x.com/flop_labs. En la testnet, el FLOP de testnet que un agente gasta en inferencia se convierte en su derecho sobre FLOP de mainnet. Crear cuentas no da nada.",
    "Devnet is practice" to
        "La devnet es práctica",
    "Devnet is practice: its FLOP has no value. This app promises nothing about any allocation." to
        "La devnet es práctica: su FLOP no tiene valor. Esta app no promete ninguna asignación.",
    "Do I have to post on X?" to
        "¿Tengo que publicar en X?",
    "Do I need more than one account?" to
        "¿Necesito más de una cuenta?",
    "Do my day" to
        "Completar mi día",
    "Every step below was read back from the server, not just sent." to
        "Cada paso de abajo se volvió a leer desde el servidor, no solo se envió.",
    "Explain the idea of a 'seed phrase' and why it must stay secret." to
        "Explica la idea de una 'frase semilla' y por qué debe mantenerse en secreto.",
    "Explain what 'decentralised' means without using jargon." to
        "Explica qué significa 'descentralizado' sin usar jerga.",
    "Explain what a blockchain block is to a ten-year-old, in three sentences." to
        "Explica qué es un bloque de una blockchain a un niño de diez años, en tres frases.",
    "Explain what an API is using a restaurant as the example." to
        "Explica qué es una API usando un restaurante como ejemplo.",
    "Explain what open-source software is in two sentences." to
        "Explica qué es el software de código abierto en dos frases.",
    "FLOP Network is a blockchain where AI agents pay for AI work with FLOP. Miners run models on graphics cards, validators check that the work was really done, and agents buy the answers. Asking the model a question here is exactly that: your Passport acts as an agent and pays for one answer." to
        "FLOP Network es una blockchain donde los agentes de IA pagan con FLOP por trabajo de IA. Los mineros ejecutan modelos en tarjetas gráficas, los validadores comprueban que el trabajo se hizo de verdad y los agentes compran las respuestas. Hacerle una pregunta al modelo aquí es exactamente eso: tu Passport actúa como agente y paga por una respuesta.",
    "FLOP Passport gives your Seeker an identity and an account on FLOP Network, and one place to do your day there. It is free, open source, and made by one developer, Alex Kosa. It is not made by FLOP Labs." to
        "FLOP Passport le da a tu Seeker una identidad y una cuenta en FLOP Network, y un solo lugar donde completar tu día allí. Es gratuita, de código abierto y está hecha por un único desarrollador, Alex Kosa. No está hecha por FLOP Labs.",
    "FLOP gives each account one devnet allowance: 25 FLOP for 24 hours. When it is over it is over until testnet." to
        "FLOP da a cada cuenta un único cupo de devnet: 25 FLOP durante 24 horas. Cuando se acaba, se acaba hasta la testnet.",
    "FLOP has no Discord, Telegram, Reddit or Medium. There is no FLOP token yet." to
        "FLOP no tiene Discord, Telegram, Reddit ni Medium. Todavía no existe ningún token FLOP.",
    "FLOP has no official Discord, Telegram, Reddit or Medium. An invitation to one never comes from FLOP." to
        "FLOP no tiene Discord, Telegram, Reddit ni Medium oficiales. Una invitación a uno de ellos nunca viene de FLOP.",
    "FLOP has not announced the testnet date. When it opens, the testnet FLOP you spend on the model becomes your claim on mainnet FLOP. Holding FLOP or making more accounts earns nothing." to
        "FLOP no ha anunciado la fecha de la testnet. Cuando abra, el FLOP de testnet que gastes en el modelo se convertirá en tu derecho sobre FLOP de mainnet. Tener FLOP o crear más cuentas no da nada.",
    "FLOP has not given a date. It will be announced on x.com/flop_labs, and this app's status will say so the same day." to
        "FLOP no ha dado una fecha. Se anunciará en x.com/flop_labs, y el estado de esta app lo dirá el mismo día.",
    "FLOP says Q1 2027" to
        "Según FLOP, T1 de 2027",
    "FLOP says there is no token, mint, claim, presale or live airdrop yet. Anything offering one is not FLOP." to
        "FLOP dice que todavía no hay token, mint, claim, preventa ni airdrop activo. Cualquier cosa que ofrezca uno no es FLOP.",
    "FLOP's faucet is down for everyone right now. It is not your phone. Try again later." to
        "El faucet de FLOP no funciona ahora mismo para nadie. No es tu teléfono. Inténtalo más tarde.",
    "FLOP's faucet is refusing every request with “IP classification unavailable”. This is FLOP's bug (network issue #22), not your phone. The app keeps trying when you press do my day." to
        "El faucet de FLOP rechaza todas las solicitudes con “IP classification unavailable”. Es un fallo de FLOP (incidencia #22 de la red), no de tu teléfono. La app sigue intentándolo cuando pulsas completar mi día.",
    "FLOP's faucet sends 25 devnet FLOP to your address, once every 24 hours per address. The request goes from your phone, for your own address, the same as pressing the button on faucet.flop.network. When the faucet is down, the app says so and the rest of your day still counts." to
        "El faucet de FLOP envía 25 FLOP de devnet a tu dirección, una vez cada 24 horas por dirección. La solicitud sale de tu teléfono, para tu propia dirección, igual que pulsar el botón en faucet.flop.network. Cuando el faucet no funciona, la app lo dice y el resto de tu día sigue contando.",
    "FLOP's gateway has handed out all of today's devnet allowances, or is unavailable. Try again later." to
        "La pasarela de FLOP ya ha repartido todos los cupos de devnet de hoy, o no está disponible. Inténtalo más tarde.",
    "FLOP's gateway rules (OpenAPI)" to
        "Reglas de la pasarela de FLOP (OpenAPI)",
    "FLOP's only handle is @flop_labs. Any other account using the name is not theirs." to
        "La única cuenta de FLOP es @flop_labs. Cualquier otra cuenta que use el nombre no es suya.",
    "FLOP: official links and verification" to
        "FLOP: enlaces oficiales y verificación",
    "FLOP: the airdrop and testnet conversion" to
        "FLOP: el airdrop y la conversión de testnet",
    "Faucet outage, FLOP issue #22" to
        "Caída del faucet, incidencia #22 de FLOP",
    "Finality is lagging behind. The network may be slow." to
        "La finalidad va con retraso. La red puede estar lenta.",
    "Finish setting up your Passport first." to
        "Termina primero de configurar tu Passport.",
    "Free and open source. Made by Alex Kosa, not by FLOP Labs. It promises nothing about any allocation." to
        "Gratuita y de código abierto. Hecha por Alex Kosa, no por FLOP Labs. No promete ninguna asignación.",
    "From FLOP's faucet, once every 24 hours." to
        "Del faucet de FLOP, una vez cada 24 horas.",
    "From FLOP's faucet. Next in {time}." to
        "Del faucet de FLOP. El siguiente, en {time}.",
    "From the FLOP Passport team, written into this version." to
        "Del equipo de FLOP Passport, escrito en esta versión.",
    "From the FLOP Passport team." to
        "Del equipo de FLOP Passport.",
    "Get 25 FLOP" to
        "Recibir 25 FLOP",
    "Give me a short motivational sentence for a Monday." to
        "Dame una frase motivadora corta para un lunes.",
    "Give me a simple recipe idea with rice and eggs." to
        "Dame una idea de receta sencilla con arroz y huevos.",
    "Give me one practical tip for writing clearer emails." to
        "Dame un consejo práctico para escribir correos más claros.",
    "Give one good question to ask before buying any crypto token." to
        "Dime una buena pregunta que hacerse antes de comprar cualquier token cripto.",
    "Give one way to remember a new word in a foreign language." to
        "Dime una forma de recordar una palabra nueva en un idioma extranjero.",
    "Give three tips for keeping a phone's battery healthy." to
        "Dame tres consejos para mantener sana la batería de un teléfono.",
    "I changed phones. How do I get my Passport back?" to
        "Cambié de teléfono. ¿Cómo recupero mi Passport?",
    "In plain words, what does 'inference' mean for an AI model?" to
        "En pocas palabras, ¿qué significa 'inferencia' para un modelo de IA?",
    "In two sentences, what does a GPU do that a CPU does badly?" to
        "En dos frases, ¿qué hace una GPU que una CPU hace mal?",
    "Install the app and connect the same Solana wallet. The same wallet makes the same Passport, with the same FLOP address and the same streak. There are no words to write down." to
        "Instala la app y conecta la misma cartera Solana. La misma cartera crea el mismo Passport, con la misma dirección FLOP y la misma racha. No hay palabras que apuntar.",
    "Is this FLOP money real?" to
        "¿Este dinero FLOP es real?",
    "It gets 25 devnet FLOP from FLOP's faucet every 24 hours." to
        "Recibe 25 FLOP de devnet del faucet de FLOP cada 24 horas.",
    "It needs at least 1 FLOP on your Passport address first. On devnet each account also gets only one trial: 25 FLOP for 24 hours. After that it stays closed until testnet. The Ask tab says which one it is." to
        "Primero necesita al menos 1 FLOP en la dirección de tu Passport. En devnet, además, cada cuenta tiene una sola prueba: 25 FLOP durante 24 horas. Después queda cerrado hasta la testnet. La pestaña Preguntar indica cuál de los dos casos es.",
    "Its FLOP has no value. What you practise here is what testnet will count." to
        "Su FLOP no tiene valor. Lo que practicas aquí es lo que contará la testnet.",
    "Name three things to check before signing anything in a crypto wallet." to
        "Nombra tres cosas que comprobar antes de firmar algo en una cartera cripto.",
    "Name three uses of AI that run well on small models." to
        "Nombra tres usos de la IA que funcionan bien en modelos pequeños.",
    "No, and it would not help. FLOP counts spending, not accounts, and says extra accounts earn nothing. One person, one Passport." to
        "No, y no serviría. FLOP cuenta el gasto, no las cuentas, y dice que las cuentas extra no dan nada. Una persona, un Passport.",
    "No. Devnet FLOP is practice money with no value, and FLOP may wipe the devnet at any time. There is no FLOP token yet at all. Anybody selling FLOP today is a scammer." to
        "No. El FLOP de devnet es dinero de práctica sin valor, y FLOP puede borrar la devnet en cualquier momento. Todavía no existe ningún token FLOP. Quien venda FLOP hoy es un estafador.",
    "No. Linking a post to your Passport is optional. It shows people the Passport is yours, nothing more." to
        "No. Vincular una publicación a tu Passport es opcional. Muestra a la gente que el Passport es tuyo, nada más.",
    "Nobody can promise that, and this app never will. What FLOP says: on testnet, the testnet FLOP an agent spends on the model becomes its claim on mainnet FLOP. The app helps you do exactly that every day. Devnet, which is now, earns nothing." to
        "Nadie puede prometer eso, y esta app nunca lo hará. Lo que dice FLOP: en la testnet, el FLOP de testnet que un agente gasta en el modelo se convierte en su derecho sobre FLOP de mainnet. La app te ayuda a hacer exactamente eso cada día. La devnet, que es lo que hay ahora, no da nada.",
    "Nothing new to write down. The same wallet brings it back on any phone." to
        "Nada nuevo que apuntar. La misma cartera lo recupera en cualquier teléfono.",
    "On devnet FLOP gives each account one allowance: 25 FLOP to spend on the model within 24 hours, and needs at least 1 FLOP on the account to start it. When it is over, it stays over until testnet." to
        "En devnet, FLOP da a cada cuenta un cupo: 25 FLOP para gastar en el modelo en 24 horas, y hace falta al menos 1 FLOP en la cuenta para empezarlo. Cuando se acaba, sigue acabado hasta la testnet.",
    "One button signs today, takes today's FLOP and asks the model one question." to
        "Un botón firma el día de hoy, toma el FLOP de hoy y le hace una pregunta al modelo.",
    "One press does all three, in order. Whatever is already done is skipped." to
        "Una pulsación hace las tres cosas, en orden. Lo que ya esté hecho se salta.",
    "One question, paid in FLOP. Spending on the model is what testnet will count." to
        "Una pregunta, pagada en FLOP. Gastar en el modelo es lo que contará la testnet.",
    "One short text to sign. It is not a transaction and moves no money. Your wallet keeps its keys; nothing leaves it but that one signature." to
        "Un texto corto para firmar. No es una transacción y no mueve dinero. Tu cartera conserva sus claves; de ella no sale nada más que esa firma.",
    "Only text, never a transaction. Once, to create your Passport. After that the Passport signs on its own: your daily record and the model's entry statement. None of it can move money from your wallet." to
        "Solo texto, nunca una transacción. Una vez, para crear tu Passport. Después, el Passport firma por sí mismo: tu registro diario y la declaración de entrada del modelo. Nada de eso puede mover dinero de tu cartera.",
    "Open the app and press do my day. It signs today, takes today's FLOP from the faucet and asks the model one question. That is all. Whatever is already done is skipped." to
        "Abre la app y pulsa completar mi día. Firma el día de hoy, toma el FLOP de hoy del faucet y le hace una pregunta al modelo. Eso es todo. Lo que ya esté hecho se salta.",
    "Open the app and press do my day: it signs today, takes today's FLOP and asks the model one question." to
        "Abre la app y pulsa completar mi día: firma el día de hoy, toma el FLOP de hoy y le hace una pregunta al modelo.",
    "Paste a FLOP address from SubWallet, Talisman or Polkadot.js. The faucet will send there. The model still uses your Passport's own address, because only your Passport can sign for it." to
        "Pega una dirección FLOP de SubWallet, Talisman o Polkadot.js. El faucet enviará ahí. El modelo sigue usando la dirección propia de tu Passport, porque solo tu Passport puede firmar por ella.",
    "Paste a full link, a handle like @name, or an address." to
        "Pega un enlace completo, un usuario como @name o una dirección.",
    "Paste a link, an @handle or an address someone sent you." to
        "Pega un enlace, un @usuario o una dirección que alguien te haya enviado.",
    "Questions people ask" to
        "Preguntas que hace la gente",
    "Reading your days from technocore.chat…" to
        "Leyendo tus días de technocore.chat…",
    "Same Passport, same days. And now one missed day a week is forgiven." to
        "Mismo Passport, mismos días. Y ahora se perdona un día perdido por semana.",
    "Sign today" to
        "Firmar hoy",
    "Sign today to start your streak." to
        "Firma hoy para empezar tu racha.",
    "Sign today's record" to
        "Firma el registro de hoy",
    "Sign today, or the streak ends. Yesterday was already forgiven." to
        "Firma hoy o la racha termina. Ayer ya se perdonó.",
    "Signing the gateway's statement with your Passport…" to
        "Firmando la declaración de la pasarela con tu Passport…",
    "Since 3 November FLOP's practice network is open to everyone. Devnet FLOP has no value, earns nothing, and the network may be reset at any time." to
        "Desde el 3 de noviembre la red de práctica de FLOP está abierta a todos. El FLOP de devnet no tiene valor, no da nada y la red puede reiniciarse en cualquier momento.",
    "Staying safe" to
        "Cómo protegerte",
    "Suggest a five-minute stretch for someone who sits all day." to
        "Sugiere un estiramiento de cinco minutos para alguien que pasa todo el día sentado.",
    "Summarise what 'proof of work' means in two sentences." to
        "Resume qué significa 'prueba de trabajo' en dos frases.",
    "Take today's FLOP" to
        "Toma el FLOP de hoy",
    "Tell me one interesting fact about the history of computers." to
        "Cuéntame un dato curioso sobre la historia de la informática.",
    "Testnet and the airdrop" to
        "La testnet y el airdrop",
    "Testnet: no date yet" to
        "Testnet: aún sin fecha",
    "That is not a FLOP address. It should start with 5 and be 47 or 48 characters; copy it again from your wallet." to
        "Eso no es una dirección FLOP. Debe empezar por 5 y tener 47 o 48 caracteres; cópiala otra vez desde tu cartera.",
    "The faucet" to
        "El faucet",
    "The faucet did not answer." to
        "El faucet no respondió.",
    "The faucet is down for everyone" to
        "El faucet no funciona para nadie",
    "The faucet sends to an address you chose instead:" to
        "En su lugar, el faucet envía a una dirección que elegiste:",
    "The faucet works for you" to
        "El faucet funciona para ti",
    "The model did not answer." to
        "El modelo no respondió.",
    "The model is busy. Try again in a minute; nothing was spent." to
        "El modelo está ocupado. Inténtalo de nuevo en un minuto; no se gastó nada.",
    "The model is closed for this account" to
        "El modelo está cerrado para esta cuenta",
    "The model is thinking…" to
        "El modelo está pensando…",
    "The model needs at least 1 FLOP on your Passport address first. Get it from the faucet." to
        "El modelo necesita primero al menos 1 FLOP en la dirección de tu Passport. Consíguelo en el faucet.",
    "The model: one trial per account" to
        "El modelo: una prueba por cuenta",
    "The real token. There is no FLOP token before this, so anything sold or “claimed” as FLOP today is a scam." to
        "El token real. No hay ningún token FLOP antes de esto, así que todo lo que hoy se venda o se “reclame” como FLOP es una estafa.",
    "There is no FLOP token yet, so there is no FLOP contract address. Anything offered as one is not FLOP." to
        "Todavía no existe ningún token FLOP, así que no hay dirección de contrato de FLOP. Cualquier cosa que se ofrezca como tal no es FLOP.",
    "There is no FLOP token yet. Nobody, including this app's author, will ever ask for your private key or your wallet's words. Your wallet only ever signs text here, never a transaction. If somebody sends you a FLOP link, check it on the Network tab first." to
        "Todavía no existe ningún token FLOP. Nadie, ni siquiera el autor de esta app, te pedirá nunca tu clave privada ni las palabras de tu cartera. Aquí tu cartera solo firma texto, nunca una transacción. Si alguien te envía un enlace de FLOP, compruébalo primero en la pestaña Red.",
    "There is no Passport on this phone." to
        "No hay ningún Passport en este teléfono.",
    "This account has used its one devnet allowance. FLOP does not renew it on devnet. The model opens again when testnet starts, and on testnet the FLOP you spend here is what counts." to
        "Esta cuenta ya usó su único cupo de devnet. FLOP no lo renueva en devnet. El modelo vuelve a abrirse cuando empiece la testnet, y en la testnet lo que cuenta es el FLOP que gastes aquí.",
    "This account's devnet allowance is used up." to
        "El cupo de devnet de esta cuenta se ha agotado.",
    "This address already got its FLOP in the last 24 hours." to
        "Esta dirección ya recibió su FLOP en las últimas 24 horas.",
    "This app's source code" to
        "Código fuente de esta app",
    "This is an account on FLOP Network. An address alone says nothing about who holds it." to
        "Esta es una cuenta en FLOP Network. Una dirección por sí sola no dice nada de quién la tiene.",
    "To use the model, your Passport signs a short statement from api.flop.network. That signature moves nothing. FLOP then opens an allowance for your account: on devnet that is 25 FLOP for 24 hours, once per account, and your account needs at least 1 FLOP to start it. An answer costs about 0.006 FLOP per word-piece, usually one or two FLOP. When the allowance ends, the model stays closed for that account until testnet." to
        "Para usar el modelo, tu Passport firma una breve declaración de api.flop.network. Esa firma no mueve nada. Luego FLOP abre un cupo para tu cuenta: en devnet son 25 FLOP durante 24 horas, una vez por cuenta, y tu cuenta necesita al menos 1 FLOP para empezarlo. Una respuesta cuesta unos 0,006 FLOP por fragmento de palabra, normalmente uno o dos FLOP. Cuando el cupo se acaba, el modelo queda cerrado para esa cuenta hasta la testnet.",
    "Today is not signed yet" to
        "Hoy aún no está firmado",
    "Today is not signed yet." to
        "Hoy aún no está firmado.",
    "Today is signed. Come back tomorrow." to
        "Hoy ya está firmado. Vuelve mañana.",
    "Today is signed. See you tomorrow." to
        "Hoy ya está firmado. Hasta mañana.",
    "Too many tries from this network. Wait a minute and try again." to
        "Demasiados intentos desde esta red. Espera un minuto e inténtalo de nuevo.",
    "Type a question" to
        "Escribe una pregunta",
    "What FLOP is" to
        "Qué es FLOP",
    "What FLOP says: on testnet, testnet FLOP that an agent actually spends on inference becomes its claim on mainnet FLOP. That claim is locked, and unlocks as it is spent on inference on mainnet: three spent unlock one. Holding FLOP earns nothing. Making more accounts earns nothing. Posting your identity earns nothing." to
        "Lo que dice FLOP: en la testnet, el FLOP de testnet que un agente gasta de verdad en inferencia se convierte en su derecho sobre FLOP de mainnet. Ese derecho está bloqueado y se desbloquea a medida que se gasta en inferencia en mainnet: tres gastados desbloquean uno. Tener FLOP no da nada. Crear más cuentas no da nada. Publicar tu identidad no da nada.",
    "What do I need to do every day?" to
        "¿Qué tengo que hacer cada día?",
    "What does a miner do in a compute network?" to
        "¿Qué hace un minero en una red de cómputo?",
    "What exactly does my wallet sign?" to
        "¿Qué firma exactamente mi cartera?",
    "What is a hash function? Two sentences." to
        "¿Qué es una función hash? En dos frases.",
    "What is a token in the context of language models?" to
        "¿Qué es un token en el contexto de los modelos de lenguaje?",
    "What is a validator in a blockchain network? Keep it short." to
        "¿Qué es un validador en una red blockchain? Sé breve.",
    "What is an AI agent, in one paragraph?" to
        "¿Qué es un agente de IA, en un párrafo?",
    "What is latency, and why do people care about it?" to
        "¿Qué es la latencia y por qué le importa a la gente?",
    "What is phishing, and how do you spot it? Three signs." to
        "¿Qué es el phishing y cómo se detecta? Tres señales.",
    "What is the cloud, really? Two sentences." to
        "¿Qué es la nube, de verdad? En dos frases.",
    "What is the difference between a private key and a public key?" to
        "¿Cuál es la diferencia entre una clave privada y una clave pública?",
    "What makes a password strong? Three short points." to
        "¿Qué hace que una contraseña sea segura? Tres puntos breves.",
    "What this app is" to
        "Qué es esta app",
    "What we say: this app promises nothing about any allocation, and never will. It helps you do, every day, the thing FLOP says it counts. One person, one Passport." to
        "Lo que decimos nosotros: esta app no promete ninguna asignación, ni lo hará nunca. Te ayuda a hacer, cada día, lo que FLOP dice que cuenta. Una persona, un Passport.",
    "When does testnet start?" to
        "¿Cuándo empieza la testnet?",
    "Where FLOP is now" to
        "Dónde está FLOP ahora",
    "Where these facts come from" to
        "De dónde salen estos datos",
    "Who made this app?" to
        "¿Quién hizo esta app?",
    "Why did my streak go back to zero?" to
        "¿Por qué mi racha volvió a cero?",
    "Why do computers use binary? Two sentences." to
        "¿Por qué los ordenadores usan binario? En dos frases.",
    "Why does the model not answer me?" to
        "¿Por qué el modelo no me responde?",
    "Why is my balance 0?" to
        "¿Por qué mi saldo es 0?",
    "Will I get FLOP tokens for this?" to
        "¿Recibiré tokens FLOP por esto?",
    "Write a haiku about a phone that never sleeps." to
        "Escribe un haiku sobre un teléfono que nunca duerme.",
    "You are a small model running on FLOP Network's devnet, answering inside a phone app. Answer briefly and plainly. Answer in the language the user writes in." to
        "Eres un modelo pequeño que funciona en la devnet de FLOP Network y respondes dentro de una app de teléfono. Responde de forma breve y sencilla. Responde en el idioma en que escribe el usuario.",
    "You never need this to recover: your wallet rebuilds the Passport. It is here for people who want to use their identity away from this phone. Nobody, including this app's author, will ever ask you for it." to
        "Nunca necesitas esto para recuperarlo: tu cartera reconstruye el Passport. Está aquí para quien quiera usar su identidad fuera de este teléfono. Nadie, ni siquiera el autor de esta app, te lo pedirá nunca.",
    "Your FLOP address" to
        "Tu dirección FLOP",
    "Your FLOP comes from FLOP's faucet, and right now the faucet is not giving FLOP to anyone. That is FLOP's problem, not your phone. When it works, press do my day and 25 FLOP arrives within a minute." to
        "Tu FLOP viene del faucet de FLOP, y ahora mismo el faucet no da FLOP a nadie. Es un problema de FLOP, no de tu teléfono. Cuando funcione, pulsa completar mi día y llegarán 25 FLOP en menos de un minuto.",
    "Your Passport is a FLOP account" to
        "Tu Passport es una cuenta de FLOP",
    "Your Passport is also a FLOP address. FLOP's faucet gives it 25 FLOP every 24 hours." to
        "Tu Passport también es una dirección FLOP. El faucet de FLOP le da 25 FLOP cada 24 horas.",
    "Your Passport key is also an account on FLOP Network. Same key, written the way FLOP writes addresses." to
        "La clave de tu Passport también es una cuenta en FLOP Network. La misma clave, escrita como FLOP escribe las direcciones.",
    "Your Passport key is also your FLOP account. It is the same key, written the way FLOP writes addresses, so there is nothing new to back up: your Solana wallet rebuilds both on any phone. If you already have a FLOP address in SubWallet, Talisman or Polkadot.js, you can send the faucet there instead, on the Passport tab. The model works only with the Passport's own address, because only the Passport can sign for it." to
        "La clave de tu Passport también es tu cuenta de FLOP. Es la misma clave, escrita como FLOP escribe las direcciones, así que no hay nada nuevo que respaldar: tu cartera Solana reconstruye ambas en cualquier teléfono. Si ya tienes una dirección FLOP en SubWallet, Talisman o Polkadot.js, puedes hacer que el faucet envíe allí, en la pestaña Passport. El modelo solo funciona con la dirección propia del Passport, porque solo el Passport puede firmar por ella.",
    "Your Passport now lives on FLOP" to
        "Tu Passport ahora vive en FLOP",
    "Your Passport signs one line in public. It adds a day to your streak." to
        "Tu Passport firma una línea en público. Suma un día a tu racha.",
    "Your Passport signs one short line in a public room on technocore.chat, and the app reads it back to prove it landed. Each signed day adds to your streak. Miss one day and it is forgiven, once a week. Miss two in a row and the streak starts again." to
        "Tu Passport firma una línea corta en una sala pública de technocore.chat, y la app la vuelve a leer para probar que llegó. Cada día firmado suma a tu racha. Si fallas un día, se perdona, una vez por semana. Si fallas dos seguidos, la racha empieza de nuevo.",
    "Your address got its FLOP from the faucet in the last 24 hours. It can ask again 24 hours after the last grant." to
        "Tu dirección recibió su FLOP del faucet en las últimas 24 horas. Puede volver a pedirlo 24 horas después de la última entrega.",
    "Your day is done." to
        "Tu día está completo.",
    "Your day on FLOP, from your Seeker." to
        "Tu día en FLOP, desde tu Seeker.",
    "Your day, step by step" to
        "Tu día, paso a paso",
    "Your first question opens it. Your Passport signs a short statement from api.flop.network; nothing else is signed and nothing moves. You need at least 1 FLOP on your Passport's address, which the faucet on Today gives you." to
        "Tu primera pregunta abre el cupo. Tu Passport firma una breve declaración de api.flop.network; no se firma nada más y no se mueve nada. Necesitas al menos 1 FLOP en la dirección de tu Passport, que te da el faucet en Hoy.",
    "Your identity note was deleted after seven quiet days. Publish it again to keep signing your days. Your streak is not lost." to
        "Tu nota de identidad se eliminó tras siete días sin actividad. Publícala de nuevo para seguir firmando tus días. No has perdido tu racha.",
    "Your one devnet trial of the model is over. It opens again on testnet." to
        "Tu única prueba del modelo en devnet ha terminado. Vuelve a abrirse en la testnet.",
    "Your streak came with you" to
        "Tu racha vino contigo",
    "Your wallet made this key and rebuilds it on any phone. There are no words to write down." to
        "Tu cartera creó esta clave y la reconstruye en cualquier teléfono. No hay palabras que apuntar.",
    "Your {n}-day streak ends at midnight" to
        "Tu racha de {n} días termina a medianoche",
    "accounts" to
        "cuentas",
    "active agents" to
        "agentes activos",
    "all my records" to
        "todos mis registros",
    "allowance left" to
        "cupo restante",
    "already asked today" to
        "ya preguntado hoy",
    "already signed today" to
        "ya firmado hoy",
    "already taken today" to
        "ya recibido hoy",
    "answered" to
        "respondido",
    "ask the model something else" to
        "preguntar otra cosa al modelo",
    "back" to
        "atrás",
    "balance" to
        "saldo",
    "balance {n} FLOP" to
        "saldo {n} FLOP",
    "change the address" to
        "cambiar la dirección",
    "closes in" to
        "cierra en",
    "compute market and FRCR index" to
        "mercado de cómputo e índice FRCR",
    "copied" to
        "copiado",
    "cost {n} FLOP" to
        "costó {n} FLOP",
    "day in a row" to
        "día seguido",
    "days in a row" to
        "días seguidos",
    "devnet flop" to
        "flop de devnet",
    "do my day" to
        "completar mi día",
    "entering" to
        "entrando",
    "finish your passport first" to
        "termina primero tu passport",
    "flop gateway" to
        "pasarela flop",
    "go back to my passport address" to
        "volver a la dirección de mi passport",
    "got it" to
        "entendido",
    "how it all works" to
        "cómo funciona todo",
    "how it works" to
        "cómo funciona",
    "how it works, questions and answers" to
        "cómo funciona, preguntas y respuestas",
    "how the model works here" to
        "cómo funciona aquí el modelo",
    "is this really flop?" to
        "¿es de verdad flop?",
    "just now" to
        "ahora mismo",
    "latest block" to
        "último bloque",
    "made by wallet" to
        "creada por la cartera",
    "model" to
        "modelo",
    "my day on flop" to
        "mi día en flop",
    "needs flop" to
        "necesita flop",
    "network" to
        "red",
    "new in 2.0" to
        "novedades de 2.0",
    "news" to
        "noticias",
    "no date yet" to
        "aún sin fecha",
    "not entered" to
        "sin entrar",
    "not flop" to
        "no es flop",
    "not flop's" to
        "no es de flop",
    "not now" to
        "ahora no",
    "official" to
        "oficial",
    "official channels" to
        "canales oficiales",
    "open in FLOP's explorer" to
        "abrir en el explorador de FLOP",
    "private key" to
        "clave privada",
    "publish again" to
        "publicar de nuevo",
    "read it in FLOP's own words" to
        "léelo en palabras de FLOP",
    "reading" to
        "leyendo",
    "refresh" to
        "actualizar",
    "refused" to
        "rechazado",
    "save" to
        "guardar",
    "scam warning" to
        "aviso de estafa",
    "send" to
        "enviar",
    "settings, language, about" to
        "ajustes, idioma, acerca de",
    "signed and read back" to
        "firmado y leído de nuevo",
    "spent on the model, as FLOP's explorer sees it" to
        "gastado en el modelo, según el explorador de FLOP",
    "start" to
        "empezar",
    "the proof" to
        "la prueba",
    "to do" to
        "pendiente",
    "today" to
        "hoy",
    "today's question: {q}" to
        "pregunta de hoy: {q}",
    "trial over" to
        "prueba terminada",
    "use an address I already have" to
        "usar una dirección que ya tengo",
    "validators" to
        "validadores",
    "what is happening now" to
        "qué pasa ahora",
    "what your wallet will show" to
        "lo que mostrará tu cartera",
    "where flop stands" to
        "en qué punto está flop",
    "your flop address" to
        "tu dirección flop",
    "{day} was missed and forgiven: one missed day a week is." to
        "{day} se perdió y se perdonó: se perdona un día perdido por semana.",
    "{n} d ago" to
        "hace {n} d",
    "{n} h ago" to
        "hace {n} h",
    "{n} min ago" to
        "hace {n} min",
    "Today" to "Hoy",
    "Ask" to "Preguntar",
    "Network" to "Red",
    "{host} is on FLOP's official list." to "{host} está en la lista oficial de FLOP.",
    "This is FLOP's own account on {host}." to "Esta es la cuenta propia de FLOP en {host}.",
    "This is on {host}, but not FLOP's account there. FLOP's is {account}." to "Esto es {host}, pero no la cuenta de FLOP allí. La de FLOP es {account}.",
    "{host} uses the FLOP name but is not on FLOP's official list. Treat it as an impersonation." to "{host} usa el nombre FLOP pero no está en la lista oficial de FLOP. Trátalo como una suplantación.",
    "{host} is not FLOP. That does not make it bad, only not FLOP." to "{host} no es FLOP. Eso no lo hace malo, solo que no es FLOP.",
    // The faucet came back (2026-11-03).
    "The faucet works" to
        "El faucet funciona",
    "FLOP's faucet gives each address 25 FLOP once every 24 hours. It can be slow: an answer may take a minute or two. The app waits for it and checks your balance." to
        "El faucet de FLOP da a cada dirección 25 FLOP una vez cada 24 horas. Puede ser lento: una respuesta puede tardar uno o dos minutos. La app la espera y revisa tu saldo.",
    "Your FLOP comes from FLOP's faucet: 25 FLOP once every 24 hours. Press do my day and wait, the faucet can take a minute or two. If the balance stays 0, the faucet step says why." to
        "Tus FLOP vienen del faucet de FLOP: 25 FLOP una vez cada 24 horas. Pulsa «completar mi día» y espera, el faucet puede tardar uno o dos minutos. Si el saldo sigue en 0, el paso del faucet dice por qué.",
    // Review fixes before the 2.0 release (2026-11-03).
    "The faucet is limiting requests from your network right now. Nothing arrived; try again later." to
        "El faucet está limitando las solicitudes desde tu red ahora mismo. No llegó nada; inténtalo más tarde.",
    "FLOP's gateway sent a sign-in text this app does not recognise, so it was not signed. Nothing happened." to
        "La pasarela de FLOP envió un texto de acceso que esta app no reconoce, así que no se firmó. No pasó nada.",
    "The faucet said no: {reason}" to
        "El faucet dijo que no: {reason}",
    "The gateway said no: {reason}" to
        "La pasarela dijo que no: {reason}",
    "The model did not answer: {reason}" to
        "El modelo no respondió: {reason}",
    "Only https links can be FLOP's. Type FLOP's address yourself instead of following this one." to
        "Solo los enlaces https pueden ser de FLOP. Escribe tú mismo la dirección de FLOP en vez de seguir este enlace.",
    "Sign today to keep your streak. This week's one forgiven day is already used." to
        "Firma hoy para mantener tu racha. El único día perdonado de esta semana ya se usó.",
    // The model allowance is what the gateway says, not a fixed number (2026-11-03).
    "On devnet FLOP gives each account one allowance to spend on the model within 24 hours, and needs at least 1 FLOP on the account to start it. The Ask tab shows how much is left. When it is over, it stays over until testnet." to
        "En devnet FLOP da a cada cuenta una asignación para gastar en el modelo durante 24 horas, y la cuenta necesita al menos 1 FLOP para empezar. La pestaña Preguntar muestra cuánto queda. Cuando se acaba, sigue así hasta testnet.",
    "FLOP gives each account one devnet allowance for 24 hours. The figure above is what is left of it. When it is over it is over until testnet." to
        "FLOP da a cada cuenta una asignación de devnet durante 24 horas. La cifra de arriba es lo que queda. Cuando se acaba, sigue así hasta testnet.",
    "It needs at least 1 FLOP on your Passport address first. On devnet each account also gets only one trial, for 24 hours. After that it stays closed until testnet. The Ask tab says which one it is." to
        "Primero tu dirección de Passport necesita al menos 1 FLOP. Además, en devnet cada cuenta tiene solo una prueba, durante 24 horas. Después queda cerrado hasta testnet. La pestaña Preguntar dice cuál de las dos es.",
    "To use the model, your Passport signs a short statement from api.flop.network. That signature moves nothing. FLOP then opens an allowance for your account: on devnet one, for 24 hours, and your account needs at least 1 FLOP to start it. The Ask tab shows how much of it is left. An answer costs about 0.006 FLOP per word-piece, usually one or two FLOP. When the allowance ends, the model stays closed for that account until testnet." to
        "Para usar el modelo, tu Passport firma una breve declaración de api.flop.network. Esa firma no mueve nada. Luego FLOP abre una asignación para tu cuenta: en devnet una, durante 24 horas, y tu cuenta necesita al menos 1 FLOP para empezar. La pestaña Preguntar muestra cuánto queda. Una respuesta cuesta unos 0,006 FLOP por fragmento de palabra, normalmente uno o dos FLOP. Cuando la asignación termina, el modelo queda cerrado para esa cuenta hasta testnet.",
    // The faucet's two other refusals, seen 3-4 November 2026.
    "The faucet has your request in its queue and has not sent the FLOP yet. This can take a while. Press do my day again later." to
        "Tu solicitud está en la cola del faucet y aún no ha enviado los FLOP. Puede tardar. Pulsa «completar mi día» otra vez más tarde.",
    "The faucet has given out all of today's FLOP. Nothing arrived. It opens again within hours, so try later." to
        "El faucet ya repartió todos los FLOP de hoy. No llegó nada. Vuelve a abrir en unas horas, inténtalo más tarde.",
    "Signing today's line with your Passport and reading it back from technocore.chat…" to
        "Firmando la línea de hoy con tu Passport y leyéndola de vuelta en technocore.chat…",
    "Asking FLOP's faucet. It serves about 10 people a minute, so this can take up to 2 minutes." to
        "Pidiendo al faucet de FLOP. Atiende a unas 10 personas por minuto, así que puede tardar hasta 2 minutos.",
    "You are in the faucet's queue. The app watches your balance and asks again by itself." to
        "Estás en la cola del faucet. La app vigila tu saldo y vuelve a pedir por sí sola.",
    "Reading your balance…" to
        "Leyendo tu saldo…",
    "Sending your question to the model. It has up to 90 seconds to answer." to
        "Enviando tu pregunta al modelo. Tiene hasta 90 segundos para responder.",
    "FLOP's gateway is full right now: many people are asking at once. Nothing was spent. The app tries again by itself." to
        "La pasarela de FLOP está llena ahora: muchas personas preguntan a la vez. No se ha gastado nada. La app lo reintenta por sí sola.",
    "Your FLOP is still settling on the network. The app tries again by itself." to
        "Tus FLOP aún se están confirmando en la red. La app lo reintenta por sí sola.",
    "Reading what the answer cost…" to
        "Leyendo cuánto costó la respuesta…",
    "FLOP's gateway stayed full through every try. Nothing was spent. Try again in a few minutes." to
        "La pasarela de FLOP siguió llena en todos los intentos. No se ha gastado nada. Inténtalo en unos minutos.",
    "{n} s so far" to
        "{n} s transcurridos",
    "try {n} of {m}" to
        "intento {n} de {m}",
    "next try in {n} s" to
        "próximo intento en {n} s",
    "gateway ping {n} ms" to
        "ping de la pasarela {n} ms",
    "faucet ping {n} ms" to
        "ping del faucet {n} ms",
    "the gateway does not answer a ping" to
        "la pasarela no responde al ping",
    "the faucet does not answer a ping" to
        "el faucet no responde al ping",
    "step {n} of 3" to
        "paso {n} de 3",
    "ping" to
        "ping",
    "no answer" to
        "sin respuesta",
    "last answer took" to
        "la última respuesta tardó",
    "You can leave this screen: it keeps going." to
        "Puedes salir de esta pantalla: seguirá en marcha.",
    "Signing today's line" to
        "Firmando la línea de hoy",
    "Your Passport signs one short line in the public room and reads it back. That line is your day." to
        "Tu Passport firma una línea corta en la sala pública y la vuelve a leer. Esa línea es tu día.",
    "Asking FLOP's faucet" to
        "Pidiendo al faucet de FLOP",
    "The faucet pays about 10 people a minute. This can take up to two minutes." to
        "El faucet atiende a unas 10 personas por minuto. Puede tardar hasta dos minutos.",
    "Standing in the faucet's queue" to
        "En la cola del faucet",
    "The faucet pays about 10 people a minute. Your request is in. We watch your balance and ask again by ourselves." to
        "El faucet atiende a unas 10 personas por minuto. Tu solicitud ya está dentro. Vigilamos tu saldo y volvemos a pedir por nuestra cuenta.",
    "Your FLOP is on its way" to
        "Tu FLOP está en camino",
    "One moment." to
        "Un momento.",
    "Opening the model" to
        "Abriendo el modelo",
    "Your Passport signs the gateway's statement. Nothing is spent." to
        "Tu Passport firma la declaración de la pasarela. No se gasta nada.",
    "Asking the model" to
        "Preguntando al modelo",
    "Your question is with the model. It has up to 90 seconds." to
        "Tu pregunta está con el modelo. Tiene hasta 90 segundos.",
    "The model is full right now" to
        "El modelo está lleno ahora",
    "Many people are asking at once. Nothing was spent. We try again by ourselves." to
        "Mucha gente pregunta a la vez. No se gastó nada. Lo intentamos de nuevo por nuestra cuenta.",
    "Your FLOP is still settling" to
        "Tu FLOP aún se está asentando",
    "A fresh grant takes a moment to count. We try again by ourselves." to
        "Un ingreso reciente tarda un momento en contarse. Lo intentamos de nuevo por nuestra cuenta.",
    "Reading what it cost" to
        "Leyendo lo que costó",
    "FLOP's gateway stayed full through all 6 tries. Nothing was spent. This is on FLOP's side, not yours." to
        "La pasarela de FLOP estuvo llena en los 6 intentos. No se gastó nada. Es cosa de FLOP, no tuya.",
    "to next try" to
        "al próximo intento",
    "elapsed {t}" to
        "transcurrido {t}",
    "ask the model" to
        "preguntar al modelo",
    "Answered" to
        "Respondido",
    "cost {c} FLOP · {s} s" to
        "costó {c} FLOP · {s} s",
    "The model did not answer" to
        "El modelo no respondió",
    "your question" to
        "tu pregunta",
    "waiting" to
        "esperando",
    "Connect your Passport" to
        "Conecta tu Passport",
    "Get the answer" to
        "Obtener la respuesta",
    "minimise · it keeps going" to
        "minimizar · sigue en marcha",
    "my day · step {n} of 3" to
        "mi día · paso {n} de 3",
    "my day" to
        "mi día",
    "Your day is closed" to
        "Tu día está cerrado",
    "See you tomorrow." to
        "Hasta mañana.",
    "Today is signed" to
        "Hoy está firmado",
    "not today" to
        "hoy no",
    "Could not sign today" to
        "No se pudo firmar hoy",
    "Your day is signed. Your streak of {n} is safe whatever happens next." to
        "Tu día está firmado. Tu racha de {n} está a salvo pase lo que pase.",
    "Today is not signed yet. One missed day a week is forgiven; two in a row end the streak." to
        "Hoy aún no está firmado. Se perdona un día perdido por semana; dos seguidos acaban con la racha.",
    "question of the day: {q}" to
        "pregunta del día: {q}",
    "Part of your day waits" to
        "Una parte de tu día espera",
    "passport · {name}" to
        "passport · {name}",
    "Days in a row: {n}" to
        "Días seguidos: {n}",
    "Start your streak today" to
        "Empieza tu racha hoy",
    "Registered {date} · day {n} with us" to
        "Registrado {date} · día {n} con nosotros",
    "reading your days" to
        "leyendo tus días",
    "today signed" to
        "hoy firmado",
    "sign today or the streak ends" to
        "firma hoy o la racha termina",
    "today not signed yet" to
        "hoy aún sin firmar",
    "in a row" to
        "seguidos",
    "{n} of 3" to
        "{n} de 3",
    "Your Passport signs one public line. That line is your streak." to
        "Tu Passport firma una línea pública. Esa línea es tu racha.",
    "From FLOP's faucet, once a day. Practice coins, no price." to
        "Del faucet de FLOP, una vez al día. Monedas de práctica, sin precio.",
    "One question of the day, paid in FLOP." to
        "Una pregunta del día, pagada en FLOP.",
    "One press, all three steps in order. What is already done is skipped." to
        "Una pulsación, los tres pasos en orden. Lo que ya está hecho se omite.",
    "devnet · practice network" to
        "devnet · red de práctica",
    "one key · two networks" to
        "una clave · dos redes",
    "Seeker wallet" to
        "Wallet Seeker",
    "Made the Passport with one signature. Brings it back on any phone." to
        "Creó el Passport con una firma. Lo recupera en cualquier teléfono.",
    "FLOP account" to
        "Cuenta FLOP",
    "The same key as a FLOP address. The faucet pays here; the model is paid from here." to
        "La misma clave como dirección FLOP. El faucet paga aquí; el modelo se paga desde aquí.",
    "Registered" to
        "Registrado",
    "Days in a row" to
        "Días seguidos",
    "Best streak" to
        "Mejor racha",
    "Signed days" to
        "Días firmados",
    "Balance, FLOP" to
        "Saldo, FLOP",
    "Spent on the model, FLOP" to
        "Gastado en el modelo, FLOP",
    "1 skip left this week" to
        "queda 1 perdón esta semana",
    "this week's skip is used" to
        "el perdón de esta semana está usado",
    "details and key" to
        "detalles y clave",
    "On Seeker · in FLOP Network · an app by Alex Kosa, not FLOP Labs, not Solana Mobile" to
        "En Seeker · en la red FLOP · una app de Alex Kosa, no de FLOP Labs ni de Solana Mobile",
    "days signed together" to
        "días firmados juntos",
    "flop pulse" to
        "pulso flop",
    "Devnet is a practice network, open to everyone since 3 November. Coins have no price, there is no reward." to
        "Devnet es una red de práctica, abierta a todos desde el 3 de noviembre. Las monedas no tienen precio y no hay recompensa.",
    "more about the network" to
        "más sobre la red",
    "thanks to both sides" to
        "gracias a ambas partes",
    "for Seeker, the wallet and one-tap signing" to
        "por Seeker, la wallet y la firma con un toque",
    "for the network, the faucet and a model you can pay" to
        "por la red, el faucet y un modelo al que se puede pagar",
    "An independent app by Alex Kosa. No promises about tokens or rewards." to
        "Una app independiente de Alex Kosa. Sin promesas sobre tokens ni recompensas.",
    "check a link, an @name or an address someone sent you" to
        "comprueba un enlace, un @nombre o una dirección que te enviaron",
    "check" to
        "comprobar",
    "FLOP model" to
        "Modelo FLOP",
    "The model is small: short, plain questions work best. Everything you pay is practice FLOP." to
        "El modelo es pequeño: las preguntas cortas y sencillas funcionan mejor. Todo lo que pagas es FLOP de práctica.",
    "model open" to
        "modelo abierto",
    "opening the model" to
        "abriendo el modelo",
    "trial over for this account" to
        "prueba terminada en esta cuenta",
    "needs 1 flop" to
        "necesita 1 flop",
    "model closed for now" to
        "modelo cerrado por ahora",
    "first question opens it" to
        "la primera pregunta lo abre",
    "ping {n} ms" to
        "ping {n} ms",
    "Your Passport signs a short statement from FLOP's gateway. Nothing moves. You need at least 1 FLOP; the faucet on Today gives you 25." to
        "Tu Passport firma una breve declaración de la pasarela de FLOP. No se mueve nada. Necesitas al menos 1 FLOP; el faucet en Hoy te da 25.",
    "more" to
        "más",
    "That was the last step. Your Passport is live, and your day on FLOP starts now." to
        "Ese fue el último paso. Tu Passport está activo y tu día en FLOP empieza ahora.",
    "Pulse" to
        "Pulso",
    "Who is here, and how FLOP's network is doing today." to
        "Quién está aquí y cómo va hoy la red de FLOP.",
    "who is here" to
        "quién está aquí",
    "Passport holders" to
        "titulares de Passport",
    "{n} Passport holders · {m} signed today" to
        "Titulares de Passport: {n} · firmaron hoy: {m}",
    "{n} of them signed today" to
        "de ellos firmaron hoy: {n}",
    "To keep a streak, each holder signs one short public line a day. Counted from that public record, so anyone can repeat it." to
        "Para mantener la racha, cada titular firma una línea pública corta al día. Contado desde ese registro público, cualquiera puede repetirlo.",
    "same key" to
        "misma clave",
    "knock now" to
        "llamar ahora",
    "A refused knock costs nothing. Knock as often as you like." to
        "Un rechazo no cuesta nada. Llama las veces que quieras.",
    "FLOP spent on the model, all time" to
        "FLOP gastado en el modelo, en total",
    "accounts that paid for the model" to
        "cuentas que pagaron el modelo",
    "Join FLOP with Alex's link" to
        "Entra en FLOP con el enlace de Alex",
    "This is Alex Kosa's personal referral link from FLOP, and it may count for him. It gives you nothing extra from this app. Prefer not to? Go to flop.finance yourself." to
        "Este es el enlace de referido personal de Alex Kosa de FLOP, y puede contar para él. Esta app no te da nada extra por usarlo. ¿Prefieres que no? Ve tú mismo a flop.finance.",
    "open {host}" to
        "abrir {host}",
)
