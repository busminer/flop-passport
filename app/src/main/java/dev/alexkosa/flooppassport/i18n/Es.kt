package dev.alexkosa.flooppassport.i18n

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
    "A message signed by your Passport, posted to a quiet room and then read back to prove it landed." to
        "Un mensaje firmado por su Passport, publicado en una sala tranquila y después leído de nuevo para demostrar que llegó.",
    "A once-a-day reminder to leave today's signed record." to
        "Un recordatorio diario para dejar el registro firmado de hoy.",
    "A permanent note at an address derived from your key, so anyone can find and verify you later." to
        "Una nota permanente en una dirección derivada de su clave, para que cualquiera pueda encontrarla y verificar su identidad después.",
    "A signed record has to be left by hand, and a missed day cannot be filled in later." to
        "Un registro firmado debe dejarse manualmente, y un día omitido no puede añadirse después.",
    "A tip changes nothing about your Passport and nothing about any airdrop." to
        "Una propina no cambia nada de su Passport ni de ningún airdrop.",
    "A tip changes nothing about your Passport, and nothing about any airdrop. It is a thank you, not a fee." to
        "Una propina no cambia nada de su Passport ni de ningún airdrop. Es un agradecimiento, no una tarifa.",
    "About" to "Acerca de",
    "Accepted, but we could not read it back yet" to
        "Aceptado, pero aún no pudimos volver a leerlo",
    "Activity" to "Actividad",
    "Already checked in, found in the room" to "Registro ya firmado y encontrado en la sala",
    "Already published, read back just now" to "Ya publicado y leído de nuevo ahora mismo",
    "Android is blocking notifications for this app. Turn them on in the system settings." to
        "Android está bloqueando las notificaciones de esta aplicación. Actívelas en los ajustes del sistema.",
    "Anyone can check it at the address in step 03. This app promises nothing about any allocation, and never will." to
        "Cualquiera puede comprobarlo en la dirección del paso 03. Esta aplicación no promete ninguna asignación ni lo hará nunca.",
    "Anyone holding it can sign as you" to "Quien lo tenga puede firmar como usted",
    "Anyone holding seed_hex can sign as this identity on Technocore." to
        "Quien tenga seed_hex puede firmar como esta identidad en Technocore.",
    "Anyone with this can be you" to "Quien tenga esto puede hacerse pasar por usted",
    "Apply" to "Aplicar",
    "Cancel" to "Cancelar",
    "Check in" to "Dejar un registro",
    "Check your connection and try again." to "Compruebe la conexión e inténtelo de nuevo.",
    "Could not open the security prompt on this screen." to
        "No se pudo abrir la solicitud de seguridad en esta pantalla.",
    "Could not reach technocore.chat" to "No se pudo acceder a technocore.chat",
    "Could not reach technocore.chat. This says nothing about your records, only about the connection." to
        "No se pudo acceder a technocore.chat. Esto no indica nada sobre sus registros, solo sobre la conexión.",
    "Could not reach the server." to "No se pudo contactar con el servidor.",
    "Could not read the key back from secure storage" to
        "No se pudo volver a leer la clave del almacenamiento seguro",
    "Create" to "Crear",
    "Create your Passport" to "Cree su Passport",
    "Create your Passport first. There is nothing to show until something has been signed." to
        "Cree primero su Passport. No hay nada que mostrar hasta que se haya firmado algo.",
    "Created my FLOP Passport on a Solana Seeker." to
        "He creado mi FLOP Passport en un Solana Seeker.",
    "Daily activity" to "Actividad diaria",
    "Daily reminder" to "Recordatorio diario",
    "Delete it?" to "¿Eliminarlo?",
    "Delete the Passport and create it again from your wallet." to
        "Elimine el Passport y vuelva a crearlo desde su cartera.",
    "Deleting removes the Passport from this phone only. Anything already published stays public, and the same wallet rebuilds the same identity - so this is not a way to undo anything." to
        "Al eliminarlo, el Passport solo se borra de este teléfono. Todo lo ya publicado sigue siendo público, y la misma cartera reconstruye la misma identidad; por tanto, esto no deshace nada.",
    "Every language listed here has a full translation." to
        "Todos los idiomas de esta lista tienen una traducción completa.",
    "FLOP Passport creates a Technocore identity from your Solana wallet and keeps the receipts." to
        "FLOP Passport crea una identidad de Technocore a partir de su cartera Solana y conserva los comprobantes.",
    "FLOP Passport for Seeker" to "FLOP Passport para Seeker",
    "FLOP Passport for Seeker - private backup" to
        "FLOP Passport para Seeker - copia de seguridad privada",
    "FLOP Passport for Seeker by @AlexKosa1" to "FLOP Passport para Seeker por @AlexKosa1",
    "FLOP Passport for Seeker. First signed check-in." to
        "FLOP Passport para Seeker. Primer registro firmado.",
    "FLOP asked agents to do something useful. A signed record is what proves you did, and a day without one is a day nobody can check later." to
        "FLOP pidió a los agentes que hicieran algo útil. Un registro firmado demuestra que lo hizo, y un día sin uno es un día que nadie podrá comprobar después.",
    "Identity derived from your wallet signature" to
        "Identidad derivada de la firma de su cartera",
    "Identity note published, first check in signed and verified on Technocore." to
        "Nota de identidad publicada; primer registro firmado y verificado en Technocore.",
    "Identity note published, first check in verified on Technocore." to
        "Nota de identidad publicada; primer registro verificado en Technocore.",
    "Identity note published, first check in verified." to
        "Nota de identidad publicada; primer registro verificado.",
    "It never asks for your wallet recovery phrase." to
        "Nunca solicita la frase de recuperación de su cartera.",
    "It promises nothing about any airdrop, and never will." to
        "No promete nada sobre ningún airdrop ni lo hará nunca.",
    "Keep this file offline. Never send it to anyone, including the app author." to
        "Mantenga este archivo sin conexión. Nunca lo envíe a nadie, incluido el autor de la aplicación.",
    "Keep your record going" to "Mantenga activo su registro",
    "Key born in Seed Vault, sealed by StrongBox on device." to
        "Clave creada en Seed Vault y sellada por StrongBox en el dispositivo.",
    "Language" to "Idioma",
    "Leave today's signed record on Technocore." to
        "Deje el registro firmado de hoy en Technocore.",
    "Make your first signed check-in" to "Cree su primer registro firmado",
    "My FLOP Passport, created on a Solana Seeker." to
        "Mi FLOP Passport, creado en un Solana Seeker.",
    "Next: create your Passport from your wallet." to
        "Siguiente: cree su Passport desde su cartera.",
    "Next: make your first signed check-in." to "Siguiente: cree su primer registro firmado.",
    "Next: publish your identity so anyone can verify you." to
        "Siguiente: publique su identidad para que cualquiera pueda verificarla.",
    "Next: seal the key in this phone's secure storage." to
        "Siguiente: selle la clave en el almacenamiento seguro de este teléfono.",
    "No account, no server of ours, no analytics." to
        "Sin cuenta, sin servidor propio y sin analíticas.",
    "No wallet on this phone opened the payment link." to
        "Ninguna cartera de este teléfono abrió el enlace de pago.",
    "No. Nothing was published." to "No. No se publicó nada.",
    "Not checked yet." to "Aún no comprobado.",
    "Nothing asked yet" to "Aún no se ha solicitado nada",
    "Nothing found. If you signed something and it is not here, the room has been trimmed past it - which is normal, and exactly why this screen exists." to
        "No se encontró nada. Si firmó algo y no aparece aquí, la sala ya lo ha descartado, lo cual es normal y es precisamente el motivo de esta pantalla.",
    "Nothing signed today yet." to "Aún no se ha firmado nada hoy.",
    "Only languages with a real translation are listed. A picker offering languages that all render English would say your language is supported and then prove otherwise on the next screen." to
        "Solo se muestran idiomas con una traducción real. Un selector que ofreciera idiomas que se muestran todos en inglés indicaría que su idioma es compatible y demostraría lo contrario en la pantalla siguiente.",
    "Opening a connection" to "Abriendo una conexión",
    "Opening your Solana wallet" to "Abriendo su cartera Solana",
    "Press Create again. Nothing was sent anywhere." to
        "Pulse Crear de nuevo. No se envió nada.",
    "Protect" to "Proteger",
    "Protect it" to "Protéjalo",
    "Publish" to "Publicar",
    "Publish your identity" to "Publique su identidad",
    "Published and read back from the server" to "Publicado y leído de nuevo desde el servidor",
    "Published, read back, and vouched for by your key" to
        "Publicado, leído de nuevo y avalado por su clave",
    "Publishing your identity note to technocore.chat" to
        "Publicando su nota de identidad en technocore.chat",
    "Publishing your note" to "Publicando su nota",
    "Read from technocore.chat just now, not from this phone. Rooms are trimmed as they grow, so this is what anyone would find today." to
        "Leído ahora mismo desde technocore.chat, no desde este teléfono. Las salas se recortan al crecer, así que esto es lo que cualquiera encontraría hoy.",
    "Reading your note" to "Leyendo su nota",
    "Reading your records" to "Leyendo sus registros",
    "Ready" to "Listo",
    "Remind me once a day" to "Recordármelo una vez al día",
    "Sealed by Android Keystore" to "Sellado por Android Keystore",
    "Sealed by StrongBox, this phone's separate security chip" to
        "Sellado por StrongBox, el chip de seguridad independiente de este teléfono",
    "Sealed by this phone's trusted execution environment" to
        "Sellado por el entorno de ejecución de confianza de este teléfono",
    "Sealing the key in this device's secure storage" to
        "Sellando la clave en el almacenamiento seguro de este dispositivo",
    "Sending your signed record" to "Enviando su registro firmado",
    "Sent, but not confirmed in the room yet" to "Enviado, pero aún no confirmado en la sala",
    "Settings" to "Ajustes",
    "Show your private key" to "Mostrar su clave privada",
    "Signed, accepted and found again in the room" to
        "Firmado, aceptado y encontrado de nuevo en la sala",
    "Signing your first check-in and sending it" to "Firmando y enviando su primer registro",
    "Talking to the service" to "Comunicándose con el servicio",
    "Thanks for building this" to "Gracias por crear esto",
    "That was the last step. Your Passport is live." to
        "Ese era el último paso. Su Passport está activo.",
    "The identity is born inside Seed Vault and sealed by StrongBox on the phone." to
        "La identidad se crea dentro de Seed Vault y queda sellada por StrongBox en el teléfono.",
    "The key is sealed in this phone's secure storage, then read back and checked against your identity." to
        "La clave se sella en el almacenamiento seguro de este teléfono, se vuelve a leer y se compara con su identidad.",
    "The server is busy. Trying again." to "El servidor está ocupado. Intentándolo de nuevo.",
    "The stored key does not match your identity" to
        "La clave almacenada no coincide con su identidad",
    "The wallet did not complete the signature" to "La cartera no completó la firma",
    "There are no points here and no score. FLOP asked agents to do something useful, so what counts is a record a person can still open. A number invented by this app would be a different game." to
        "Aquí no hay puntos ni puntuación. FLOP pidió a los agentes que hicieran algo útil, así que lo que cuenta es un registro que una persona aún pueda abrir. Un número inventado por esta aplicación sería otro juego.",
    "These 32 bytes are your FLOP Passport itself. Whoever holds them can sign as you on Technocore. Keep them offline and never send them to anyone, including us." to
        "Estos 32 bytes son su propio FLOP Passport. Quien los tenga puede firmar como usted en Technocore. Manténgalos sin conexión y nunca se los envíe a nadie, tampoco a nosotros.",
    "This app is free and open source, and nobody paid for it. If it saved you an afternoon, a tip is welcome." to
        "Esta aplicación es gratuita y de código abierto, y nadie pagó por crearla. Si le ahorró una tarde, puede dejar una propina.",
    "This is NOT your Solana wallet key. Your wallet's own key never leaves Seed Vault and this app has never seen it. What you are looking at is a separate key that signs only on Technocore." to
        "Esta NO es la clave de su cartera Solana. La clave de la cartera nunca sale de Seed Vault y esta aplicación nunca la ha visto. Lo que está viendo es una clave independiente que solo firma en Technocore.",
    "Try again. Nothing was posted." to "Inténtelo de nuevo. No se publicó nada.",
    "Try again. Nothing was published." to "Inténtelo de nuevo. No se publicó nada.",
    "Use the phone's language" to "Usar el idioma del teléfono",
    "Wait a moment and press it again to re-check. Do not treat this as a failure." to
        "Espere un momento y vuelva a pulsarlo para comprobarlo de nuevo. No lo considere un fallo.",
    "Wait a moment and press it again to re-check. Sending it as a new message would post twice in public." to
        "Espere un momento y vuelva a pulsarlo para comprobarlo de nuevo. Enviarlo como un mensaje nuevo lo publicaría dos veces.",
    "What is still provable" to "Lo que aún puede demostrarse",
    "Yes. Something is already visible to others." to
        "Sí. Algo ya es visible para otras personas.",
    "You do not need this file to recover. The same Solana wallet that" to
        "No necesita este archivo para recuperarlo. La misma cartera Solana que",
    "You do not need this to recover. The same Solana wallet rebuilds the same Passport on any phone. This copy is for using the key somewhere else, on your own terms." to
        "No necesita esto para recuperarlo. La misma cartera Solana reconstruye el mismo Passport en cualquier teléfono. Esta copia permite usar la clave en otro lugar, bajo sus propias condiciones.",
    "You have already checked in" to "Ya ha dejado un registro",
    "You have already left a record today." to "Ya ha dejado un registro hoy.",
    "You're all set" to "Todo está listo",
    "Your Passport is born inside Seed Vault, the Seeker's hardware key store, from which a key cannot be extracted. On this phone it is then sealed by Android's secure storage. Signing itself happens in the app, not in hardware, because Android Keystore cannot hold this kind of key - so we say sealed, not signed, in hardware." to
        "Su Passport se crea dentro de Seed Vault, el almacén de claves por hardware de Seeker, del que no se puede extraer una clave. En este teléfono queda después sellado por el almacenamiento seguro de Android. La firma se realiza en la aplicación, no en el hardware, porque Android Keystore no puede guardar este tipo de clave; por eso decimos sellado, no firmado, en el hardware.",
    "Your Passport is live" to "Su Passport está activo",
    "Your Passport is live and your first signed record is on Technocore. Anyone can verify it, and it stays yours." to
        "Su Passport está activo y su primer registro firmado está en Technocore. Cualquiera puede verificarlo y sigue siendo suyo.",
    "Your Passport is live." to "Su Passport está activo.",
    "Your key never leaves this phone." to "Su clave nunca sale de este teléfono.",
    "Your wallet signs one statement. It is not a transaction and moves no funds. The same wallet rebuilds the same Passport on any device." to
        "Su cartera firma una declaración. No es una transacción ni mueve fondos. La misma cartera reconstruye el mismo Passport en cualquier dispositivo.",
    "active days" to "días activos",
    "activity" to "actividad",
    "address" to "dirección",
    "agent: FLOP Passport for Seeker" to "agente: FLOP Passport para Seeker",
    "algorithm: Ed25519, did:key, 32-byte seed" to
        "algoritmo: Ed25519, did:key, semilla de 32 bytes",
    "built by a community builder" to "creado por un desarrollador de la comunidad",
    "cancel" to "cancelar",
    "change" to "cambiar",
    "checked" to "comprobado",
    "close" to "cerrar",
    "connection" to "conexión",
    "content" to "contenido",
    "continue" to "continuar",
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
    "floop-passport vault self-test" to "autoprueba del almacén floop-passport",
    "identity" to "identidad",
    "identity note" to "nota de identidad",
    "last connection" to "última conexión",
    "live" to "activo",
    "live records" to "registros activos",
    "matched on our nonce, not just our key" to
        "coincidencia con nuestro nonce, no solo con nuestra clave",
    "no thanks, continue" to "no, gracias; continuar",
    "no, nothing was made public" to "no, nada se hizo público",
    "not found" to "no encontrado",
    "not yet - the note alone is a claim, not a proof" to
        "aún no; la nota por sí sola es una afirmación, no una prueba",
    "off" to "desactivado",
    "on" to "activado",
    "our exact bytes, no wallet prefix" to "nuestros bytes exactos, sin prefijo de cartera",
    "passport for seeker" to "passport para seeker",
    "private key, 32 bytes, hex" to "clave privada, 32 bytes, hexadecimal",
    "protect passport" to "proteger passport",
    "publish identity" to "publicar identidad",
    "published" to "publicado",
    "re-check with the server" to "comprobar de nuevo con el servidor",
    "re-checked when the app opened" to "comprobado de nuevo al abrir la aplicación",
    "records the server still holds" to "registros que el servidor aún conserva",
    "recovery" to "recuperación",
    "room" to "sala",
    "save my key" to "guardar mi clave",
    "save to a file" to "guardar en un archivo",
    "self test" to "autoprueba",
    "send a tip" to "enviar una propina",
    "sequence" to "secuencia",
    "settings" to "ajustes",
    "sign and check in" to "firmar y dejar un registro",
    "sign today's record" to "firmar el registro de hoy",
    "signed" to "firmado",
    "signed and verified against your DID" to "firmado y verificado con su DID",
    "storage" to "almacenamiento",
    "support the builder" to "apoyar al desarrollador",
    "technocore.chat answered" to "technocore.chat respondió",
    "technocore.chat refused the note" to "technocore.chat rechazó la nota",
    "technocore.chat refused the signed write" to
        "technocore.chat rechazó la escritura firmada",
    "text" to "texto",
    "the same wallet rebuilds this identity anywhere" to
        "la misma cartera reconstruye esta identidad en cualquier lugar",
    "unconfirmed" to "sin confirmar",
    "verified" to "verificado",
    "verify it yourself" to "verifíquelo usted mismo",
    "version" to "versión",
    "vouched for" to "avalado",
    "wallet" to "cartera",
    "wallet linked" to "cartera vinculada",
    "what this app never does" to "lo que esta aplicación nunca hace",
    "what to do" to "qué hacer",
    "when" to "cuándo",
    "with a wallet prefix, which is fine and pinned" to
        "con un prefijo de cartera, que es válido y está fijado",
    "working" to "procesando",
    "yes, a signed did-note line carries its hash" to
        "sí, una línea did-note firmada contiene su hash",
    "yes, delete" to "sí, eliminar",
    "yes, something is already public" to "sí, algo ya es público",
    "your identity" to "su identidad",
    "your private key" to "su clave privada",
)
