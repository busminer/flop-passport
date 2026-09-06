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
)
