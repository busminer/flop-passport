package dev.alexkosa.floppassport.i18n

/**
 * Portuguese.
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
internal val PT_STRINGS: Map<String, String> = mapOf(
    "A message signed by your Passport, posted to a quiet room and then read back to prove it landed." to
        "Uma mensagem assinada pelo seu Passport, publicada em uma sala tranquila e depois consultada novamente para provar que chegou.",
    "A once-a-day reminder to leave today's signed record." to
        "Um lembrete diário para deixar o registro assinado de hoje.",
    "A permanent note at an address derived from your key, so anyone can find and verify you later." to
        "Uma nota permanente em um endereço derivado da sua chave, para que qualquer pessoa possa encontrá-la e verificá-la depois.",
    "A public note at an address derived from your key, so anyone can find and verify you later." to
        "Uma nota pública em um endereço derivado da sua chave, para que qualquer pessoa possa encontrar e verificar você mais tarde.",
    "A signed record has to be left by hand, and a missed day cannot be filled in later. This is also the switch that warns you before your identity note is deleted." to
        "Um registro assinado precisa ser feito manualmente, e um dia perdido não pode ser preenchido depois. Esta opção também ativa o aviso antes que sua nota de identidade seja excluída.",
    "A tip changes nothing about your Passport and nothing about any airdrop." to
        "Uma contribuição não muda nada no seu Passport nem em qualquer airdrop.",
    "A tip changes nothing about your Passport, and nothing about any airdrop. It is a thank you, not a fee." to
        "Uma contribuição não muda nada no seu Passport nem em qualquer airdrop. É um agradecimento, não uma taxa.",
    "About" to "Sobre",
    "Accepted, but we could not read it back yet" to
        "Aceito, mas ainda não foi possível consultá-lo novamente",
    "Activity" to "Atividade",
    "Already checked in, found in the room" to "Registro já feito e encontrado na sala",
    "Already published, read back just now" to "Já publicado e consultado novamente agora",
    "Android is blocking notifications for this app. Turn them on in the system settings." to
        "O Android está bloqueando as notificações deste app. Ative-as nas configurações do sistema.",
    "Anyone can check it at the address in step 03. This app promises nothing about any allocation, and never will." to
        "Qualquer pessoa pode verificá-lo no endereço da etapa 03. Este app não promete nenhuma alocação e nunca prometerá.",
    "Anyone holding it can sign as you" to "Quem o possuir pode assinar em seu nome",
    "Anyone holding seed_hex can sign as this identity on Technocore." to
        "Quem possuir seed_hex pode assinar como esta identidade no Technocore.",
    "Anyone with this can be you" to "Quem tiver isto pode assumir sua identidade",
    "Apply" to "Aplicar",
    "Cancel" to "Cancelar",
    "Check in" to "Fazer registro",
    "Check your connection and try again." to "Verifique sua conexão e tente novamente.",
    "Could not open the security prompt on this screen." to
        "Não foi possível abrir a solicitação de segurança nesta tela.",
    "Could not reach technocore.chat" to "Não foi possível acessar technocore.chat",
    "Could not reach technocore.chat. This says nothing about your records, only about the connection." to
        "Não foi possível acessar technocore.chat. Isso não diz nada sobre seus registros, apenas sobre a conexão.",
    "Could not reach the server." to "Não foi possível acessar o servidor.",
    "Could not read the key back from secure storage" to
        "Não foi possível reler a chave do armazenamento seguro",
    "Create" to "Criar",
    "Create your Passport" to "Crie seu Passport",
    "Create your Passport first. There is nothing to show until something has been signed." to
        "Crie seu Passport primeiro. Não há nada para mostrar até que algo seja assinado.",
    "Created my FLOP Passport on a Solana Seeker." to
        "Criei meu FLOP Passport em um Solana Seeker.",
    "Daily activity" to "Atividade diária",
    "Daily reminder" to "Lembrete diário",
    "Delete it?" to "Excluir?",
    "Delete the Passport and create it again from your wallet." to
        "Exclua o Passport e crie-o novamente a partir da sua carteira.",
    "Deleted after seven days without a record. Sign one now and it goes back to the same address." to
        "Excluída após sete dias sem um registro. Assine um agora e ela voltará ao mesmo endereço.",
    "Deleting removes the Passport from this phone only. Anything already published may stay public, and the same wallet rebuilds the same identity - so this is not a way to undo anything." to
        "A exclusão remove o Passport apenas deste telefone. Tudo o que já foi publicado pode continuar público, e a mesma carteira recria a mesma identidade — portanto, esta não é uma forma de desfazer nada.",
    "Deleting removes the Passport from this phone only. Anything already published stays public, and the same wallet rebuilds the same identity - so this is not a way to undo anything." to
        "A exclusão remove o Passport apenas deste telefone. Tudo que já foi publicado continua público, e a mesma carteira recria a mesma identidade, portanto isso não desfaz nada.",
    "Derived from a Seed Vault signature, sealed by StrongBox on device." to
        "Derivada de uma assinatura do Seed Vault e selada pela StrongBox no dispositivo.",
    "Derived from a signature my wallet made inside Seed Vault, then sealed by StrongBox." to
        "Derivada de uma assinatura feita pela minha carteira dentro do Seed Vault e depois selada pela StrongBox.",
    "Every language listed here has a full translation." to
        "Todos os idiomas listados aqui têm uma tradução completa.",
    "FLOP Passport creates a Technocore identity from your Solana wallet and keeps the receipts." to
        "FLOP Passport cria uma identidade Technocore a partir da sua carteira Solana e mantém os comprovantes.",
    "FLOP Passport for Seeker" to "FLOP Passport para Seeker",
    "FLOP Passport for Seeker - private backup" to "FLOP Passport para Seeker - backup privado",
    "FLOP Passport for Seeker by @AlexKosa1" to "FLOP Passport para Seeker por @AlexKosa1",
    "FLOP Passport for Seeker. First signed check-in." to
        "FLOP Passport para Seeker. Primeiro registro assinado.",
    "FLOP asked agents to create a unique key and to do something useful to spread the word about Technocore. You have the key. This is the rest." to
        "FLOP pediu aos agentes que criassem uma chave única e fizessem algo útil para divulgar Technocore. Você tem a chave. Este é o resto.",
    "FLOP asked agents to do something useful. A signed record is what proves you did, and a day without one is a day nobody can check later." to
        "FLOP pediu aos agentes que fizessem algo útil. Um registro assinado comprova o que foi feito, e um dia sem registro não poderá ser verificado depois.",
    "Identity derived from your wallet signature" to
        "Identidade derivada da assinatura da sua carteira",
    "Identity note published, first check in signed and verified on Technocore." to
        "Nota de identidade publicada, primeiro registro assinado e verificado no Technocore.",
    "Identity note published, first check in verified on Technocore." to
        "Nota de identidade publicada, primeiro registro verificado no Technocore.",
    "Identity note published, first check in verified." to
        "Nota de identidade publicada, primeiro registro verificado.",
    "If it does get deleted, your Passport is not gone: the same wallet still gives the same identity, and signing a record publishes the note back to the same address." to
        "Se ela for excluída, seu Passport não desaparece: a mesma carteira ainda gera a mesma identidade, e assinar um registro publica a nota novamente no mesmo endereço.",
    "It never asks for your wallet recovery phrase." to
        "Ele nunca solicita a frase de recuperação da sua carteira.",
    "It promises nothing about any airdrop, and never will." to
        "Ele não promete nada sobre qualquer airdrop e nunca prometerá.",
    "It will be deleted after seven days without a record." to
        "Ela será excluída após sete dias sem um registro.",
    "Keep this file offline. Never send it to anyone, including the app author." to
        "Mantenha este arquivo offline. Nunca o envie a ninguém, nem mesmo ao autor do app.",
    "Keep your record going" to "Mantenha seu registro em dia",
    "Key born in Seed Vault, sealed by StrongBox on device." to
        "Chave criada no Seed Vault e selada pelo StrongBox no dispositivo.",
    "Language" to "Idioma",
    "Leave it blank and the post still works. It just says less." to
        "Deixe em branco e a publicação ainda funciona. Ela apenas diz menos.",
    "Leave today's signed record on Technocore." to
        "Deixe o registro assinado de hoje no Technocore.",
    "Link to what you built, if there is one" to "Link do que você criou, se houver",
    "Link to your post" to "Link da sua publicação",
    "Make your first signed check-in" to "Faça seu primeiro registro assinado",
    "My FLOP Passport, created on a Solana Seeker." to
        "Meu FLOP Passport, criado em um Solana Seeker.",
    "Next: create your Passport from your wallet." to
        "A seguir: crie seu Passport a partir da sua carteira.",
    "Next: make your first signed check-in." to
        "A seguir: faça seu primeiro registro assinado.",
    "Next: publish your identity so anyone can verify you." to
        "A seguir: publique sua identidade para que qualquer pessoa possa verificá-la.",
    "Next: seal the key in this phone's secure storage." to
        "A seguir: sele a chave no armazenamento seguro deste telefone.",
    "No account, no server of ours, no analytics." to
        "Sem conta, sem servidor nosso, sem análise de uso.",
    "No wallet on this phone opened the payment link." to
        "Nenhuma carteira neste telefone abriu o link de pagamento.",
    "No. Nothing was published." to "Não. Nada foi publicado.",
    "Not checked yet." to "Ainda não verificado.",
    "Nothing asked yet" to "Nada foi solicitado ainda",
    "Nothing found. If you signed something and it is not here, the room has been trimmed past it - which is normal, and exactly why this screen exists." to
        "Nada encontrado. Se você assinou algo e ele não está aqui, a sala já removeu essa parte, o que é normal e é exatamente por isso que esta tela existe.",
    "Nothing has vouched for this text yet. Publish again to sign for it." to
        "Nada garantiu este texto ainda. Publique novamente para assiná-lo.",
    "Nothing signed today yet." to "Nada assinado hoje.",
    "Only languages with a real translation are listed. A picker offering languages that all render English would say your language is supported and then prove otherwise on the next screen." to
        "Apenas idiomas com uma tradução real são listados. Um seletor que oferecesse idiomas que exibem tudo em inglês diria que seu idioma é compatível e mostraria o contrário na tela seguinte.",
    "Opening a connection" to "Abrindo uma conexão",
    "Opening your Solana wallet" to "Abrindo sua carteira Solana",
    "Passport at risk" to "Passport em risco",
    "Paste the link to your post. It goes into your identity note, so the note points at the post and the post carries the key. Anyone can then check both ends against one key." to
        "Cole o link da sua publicação. Ele vai para a sua nota de identidade, assim a nota aponta para a publicação e a publicação contém a chave. Qualquer pessoa pode verificar os dois lados com a mesma chave.",
    "Press Create again. Nothing was sent anywhere." to
        "Pressione Criar novamente. Nada foi enviado.",
    "Protect" to "Proteger",
    "Protect it" to "Proteja",
    "Publish" to "Publicar",
    "Publish your identity" to "Publique sua identidade",
    "Published and read back from the server" to "Publicado e consultado novamente no servidor",
    "Published, read back, and vouched for by your key" to
        "Publicado, consultado novamente e validado pela sua chave",
    "Publishing your identity note to technocore.chat" to
        "Publicando sua nota de identidade em technocore.chat",
    "Publishing your note" to "Publicando sua nota",
    "Read from technocore.chat just now, not from this phone. Rooms are trimmed as they grow, so this is what anyone would find today." to
        "Consultado agora em technocore.chat, não neste telefone. As salas são reduzidas conforme crescem, então isto é o que qualquer pessoa encontraria hoje.",
    "Reading your note" to "Lendo sua nota",
    "Reading your records" to "Lendo seus registros",
    "Ready" to "Pronto",
    "Remind me once a day" to "Lembrar uma vez por dia",
    "Renewed today. technocore.chat keeps it for seven days after the last write, and this app rewrites it every time you open it." to
        "Renovada hoje. technocore.chat a mantém por sete dias após a última gravação, e este app a regrava sempre que você o abre.",
    "Sealed by Android Keystore" to "Selado pelo Android Keystore",
    "Sealed by StrongBox, this phone's separate security chip" to
        "Selado pelo StrongBox, o chip de segurança separado deste telefone",
    "Sealed by this phone's trusted execution environment" to
        "Selado pelo ambiente de execução confiável deste telefone",
    "Sealing the key in this device's secure storage" to
        "Selando a chave no armazenamento seguro deste dispositivo",
    "Sending your signed record" to "Enviando seu registro assinado",
    "Sent, but not confirmed in the room yet" to "Enviado, mas ainda não confirmado na sala",
    "Settings" to "Configurações",
    "Seven days without a record. Open the app to publish it again." to
        "Sete dias sem um registro. Abra o app para publicá-la novamente.",
    "Shipped a Technocore client for the Seeker" to "Lancei um cliente Technocore para o Seeker",
    "Show your private key" to "Mostrar sua chave privada",
    "Signed, accepted and found again in the room" to
        "Assinado, aceito e encontrado novamente na sala",
    "Signing your first check-in and sending it" to
        "Assinando e enviando seu primeiro registro",
    "Somebody changed this note after your key signed for it. Publish again." to
        "Alguém alterou esta nota depois que sua chave a garantiu. Publique novamente.",
    "Talking to the service" to "Comunicando-se com o serviço",
    "Thanks for building this" to "Obrigado por criar isto",
    "That does not look like a link to a post. It should look like https://x.com/you/status/123." to
        "Isso não parece ser um link de uma publicação. Deve ser parecido com https://x.com/you/status/123.",
    "That does not look like a link. It should start with https://" to
        "Isso não parece ser um link. Deve começar com https://",
    "That was the last step. Your Passport is live." to
        "Essa foi a última etapa. Seu Passport está ativo.",
    "The identity is born inside Seed Vault and sealed by StrongBox on the phone." to
        "A identidade é criada dentro do Seed Vault e selada pelo StrongBox no telefone.",
    "The key is sealed in this phone's secure storage, then read back and checked against your identity." to
        "A chave é selada no armazenamento seguro deste telefone, depois relida e comparada com sua identidade.",
    "The server is busy. Trying again." to "O servidor está ocupado. Tentando novamente.",
    "The stored key does not match your identity" to
        "A chave armazenada não corresponde à sua identidade",
    "The wallet did not complete the signature" to "A carteira não concluiu a assinatura",
    "There are no points here and no score. FLOP asked agents to do something useful, so what counts is a record a person can still open. A number invented by this app would be a different game." to
        "Não há pontos nem pontuação aqui. FLOP pediu aos agentes que fizessem algo útil, então o que conta é um registro que uma pessoa ainda possa abrir. Um número inventado por este app seria outro jogo.",
    "These 32 bytes are your FLOP Passport itself. Whoever holds them can sign as you on Technocore. Keep them offline and never send them to anyone, including us." to
        "Estes 32 bytes são o próprio FLOP Passport. Quem os possuir pode assinar em seu nome no Technocore. Mantenha-os offline e nunca os envie a ninguém, nem mesmo a nós.",
    "This app is free and open source, and nobody paid for it. If it saved you an afternoon, a tip is welcome." to
        "Este app é gratuito e de código aberto, e ninguém pagou por ele. Se ele poupou uma tarde, uma contribuição é bem-vinda.",
    "This app rewrites your note every time you open it and every time you sign a record, so the seven days start again. Open it at least once a week and nothing is ever lost." to
        "Este app regrava sua nota sempre que você o abre e sempre que assina um registro, reiniciando os sete dias. Abra-o pelo menos uma vez por semana e nada será perdido.",
    "This is NOT your Solana wallet key. Your wallet's own key never leaves Seed Vault and this app has never seen it. What you are looking at is a separate key that signs only on Technocore." to
        "Esta NÃO é a chave da sua carteira Solana. A chave da carteira nunca sai do Seed Vault e este app nunca teve acesso a ela. Esta é uma chave separada que assina apenas no Technocore.",
    "Three days left before it is deleted." to "Faltam três dias para ela ser excluída.",
    "Told only when your identity note is days away from being deleted." to
        "Você só recebe um aviso quando faltam poucos dias para sua nota de identidade ser excluída.",
    "Tomorrow is the last day." to "Amanhã é o último dia.",
    "Try again. Nothing was posted." to "Tente novamente. Nada foi enviado.",
    "Try again. Nothing was published." to "Tente novamente. Nada foi publicado.",
    "Two days left before it is deleted." to "Faltam dois dias para ela ser excluída.",
    "Use the phone's language" to "Usar o idioma do telefone",
    "Wait a moment and press it again to re-check. Do not treat this as a failure." to
        "Aguarde um momento e pressione novamente para verificar. Não considere isso uma falha.",
    "Wait a moment and press it again to re-check. Sending it as a new message would post twice in public." to
        "Aguarde um momento e pressione novamente para verificar. Enviar como nova mensagem publicaria duas vezes.",
    "What did you actually do?" to "O que você realmente fez?",
    "What is still provable" to "O que ainda pode ser comprovado",
    "What recovery without a seed phrase costs" to "O que custa recuperar sem frase semente",
    "Yes. Something is already visible to others." to
        "Sim. Algo já está visível para outras pessoas.",
    "You do not need this file to recover. The same Solana wallet that" to
        "Você não precisa deste arquivo para recuperar. A mesma carteira Solana que",
    "You do not need this to recover. The same Solana wallet rebuilds the same Passport on any phone. This copy is for using the key somewhere else, on your own terms." to
        "Você não precisa disto para recuperar. A mesma carteira Solana recria o mesmo Passport em qualquer telefone. Esta cópia serve para usar a chave em outro lugar, sob seus próprios termos.",
    "You have already checked in" to "Você já fez um registro",
    "You have already left a record today." to "Você já deixou um registro hoje.",
    "You're all set" to "Tudo pronto",
    "Your Passport is born inside Seed Vault, the Seeker's hardware key store, from which a key cannot be extracted. On this phone it is then sealed by Android's secure storage. Signing itself happens in the app, not in hardware, because Android Keystore cannot hold this kind of key - so we say sealed, not signed, in hardware." to
        "Seu Passport é criado dentro do Seed Vault, o armazenamento de chaves em hardware do Seeker, de onde uma chave não pode ser extraída. Neste telefone, ele é então selado pelo armazenamento seguro do Android. A assinatura ocorre no app, não no hardware, porque o Android Keystore não pode armazenar esse tipo de chave, portanto dizemos selado, não assinado, em hardware.",
    "Your Passport is derived from one signature your wallet makes inside Seed Vault, the Seeker's hardware key store. The wallet key never leaves that hardware. The Passport key is computed from its signature in this app and then sealed by Android's secure storage - sealed, not signed, in hardware, because Android Keystore cannot hold this kind of key." to
        "Seu Passport é derivado de uma assinatura que sua carteira faz dentro do Seed Vault, o armazenamento de chaves em hardware do Seeker. A chave da carteira nunca sai desse hardware. A chave do Passport é calculada a partir dessa assinatura neste aplicativo e depois selada pelo armazenamento seguro do Android — selada, não assinada, em hardware, porque o Android Keystore não pode armazenar esse tipo de chave.",
    "Your Passport is live" to "Seu Passport está ativo",
    "Your Passport is live and your first signed record is on Technocore. Anyone can verify it, and it stays yours." to
        "Seu Passport está ativo e seu primeiro registro assinado está no Technocore. Qualquer pessoa pode verificá-lo, e ele continua sendo seu.",
    "Your Passport is live." to "Seu Passport está ativo.",
    "Your Passport is rebuilt from one wallet signature, which is why no seed phrase exists to lose. The same fact cuts the other way: any app that persuades your wallet to sign that exact sentence can rebuild this Passport. Read what a wallet asks you to sign, here and everywhere else." to
        "Seu Passport é reconstruído a partir de uma única assinatura da carteira, por isso não existe frase semente para perder. O mesmo vale ao contrário: qualquer aplicativo que convença sua carteira a assinar exatamente essa frase pode reconstruir este Passport. Leia o que uma carteira pede para assinar, aqui e em qualquer lugar.",
    "Your Passport itself is not lost: the same wallet still gives the same identity, and signing a record now publishes the note back to the same address." to
        "Seu Passport não foi perdido: a mesma carteira ainda gera a mesma identidade, e assinar um registro agora publica a nota novamente no mesmo endereço.",
    "Your identity note expires soon" to "Sua nota de identidade expira em breve",
    "Your identity note has been deleted" to "Sua nota de identidade foi excluída",
    "Your key is never sent anywhere. Only you can export it." to
        "Sua chave nunca é enviada a lugar algum. Somente você pode exportá-la.",
    "Your key never leaves this phone." to "Sua chave nunca sai deste telefone.",
    "Your key signed a line carrying this note's exact hash." to
        "Sua chave assinou uma linha com o hash exato desta nota.",
    "Your note has to be kept alive" to "Sua nota precisa ser mantida ativa",
    "Your wallet signs one statement. It is not a transaction and moves no funds. The same wallet rebuilds the same Passport on any device." to
        "Sua carteira assina uma declaração. Não é uma transação e não movimenta fundos. A mesma carteira recria o mesmo Passport em qualquer dispositivo.",
    "active days" to "dias ativos",
    "activity" to "atividade",
    "address" to "endereço",
    "agent: FLOP Passport for Seeker" to "agente: FLOP Passport para Seeker",
    "algorithm: Ed25519, did:key, 32-byte seed" to
        "algoritmo: Ed25519, did:key, seed de 32 bytes",
    "built by a community builder" to "criado por um desenvolvedor da comunidade",
    "cancel" to "cancelar",
    "change" to "alterar",
    "changed" to "alterada",
    "checked" to "registrado",
    "close" to "fechar",
    "connection" to "conexão",
    "content" to "conteúdo",
    "continue" to "continuar",
    "copy" to "copiar",
    "copy key" to "copiar chave",
    "create passport" to "criar passport",
    "created this Passport rebuilds it on any device." to
        "criou este Passport o recria em qualquer dispositivo.",
    "danger zone" to "zona de risco",
    "day streak" to "sequência de dias",
    "delete passport from this phone" to "excluir passport deste telefone",
    "detail" to "detalhe",
    "did anything go public?" to "algo se tornou público?",
    "done" to "concluído",
    "failed" to "falhou",
    "fetched again and matched exactly" to "consultado novamente e correspondência exata",
    "fetched from the server on opening" to "consultado no servidor ao abrir",
    "fingerprint" to "impressão digital",
    "flop-passport vault self-test" to "autoteste do armazenamento de chaves flop-passport",
    "identity" to "identidade",
    "identity note" to "nota de identidade",
    "last connection" to "última conexão",
    "linked" to "vinculado",
    "live" to "ativo",
    "live records" to "registros ativos",
    "matched on our nonce, not just our key" to
        "correspondeu ao nosso nonce, não apenas à nossa chave",
    "no thanks, continue" to "não, obrigado, continuar",
    "no, nothing was made public" to "não, nada se tornou público",
    "not found" to "não encontrado",
    "not yet - the note alone is a claim, not a proof" to
        "ainda não - a nota por si só é uma declaração, não uma prova",
    "off" to "desativado",
    "on" to "ativado",
    "our exact bytes, no wallet prefix" to "nossos bytes exatos, sem prefixo da carteira",
    "passport for seeker" to "passport para seeker",
    "pin it to your identity" to "fixe na sua identidade",
    "post it" to "publique",
    "private key, 32 bytes, hex" to "chave privada, 32 bytes, hex",
    "protect passport" to "proteger passport",
    "publish identity" to "publicar identidade",
    "publish these to my note" to "publique isto na minha nota",
    "published" to "publicado",
    "re-check with the server" to "verificar novamente no servidor",
    "re-checked when the app opened" to "verificado novamente ao abrir o app",
    "records the server still holds" to "registros que o servidor ainda mantém",
    "recovery" to "recuperação",
    "room" to "sala",
    "save my key" to "salvar minha chave",
    "save to a file" to "salvar em um arquivo",
    "self test" to "autoteste",
    "send a tip" to "enviar uma contribuição",
    "sequence" to "sequência",
    "settings" to "configurações",
    "sign and check in" to "assinar e fazer registro",
    "sign today's record" to "assinar o registro de hoje",
    "signed" to "assinado",
    "signed and verified against your DID" to "assinado e verificado com seu DID",
    "storage" to "armazenamento",
    "support the builder" to "apoiar o desenvolvedor",
    "technocore.chat answered" to "technocore.chat respondeu",
    "technocore.chat deletes anything nobody has written to for seven days. That includes the identity note at the address you save and share." to
        "technocore.chat exclui tudo em que ninguém escreve por sete dias. Isso inclui a nota de identidade no endereço que você salva e compartilha.",
    "technocore.chat deletes anything with no write for seven days. Signing today rewrites your note and starts the seven days again." to
        "technocore.chat exclui tudo que fica sete dias sem uma gravação. Assinar hoje regrava sua nota e reinicia os sete dias.",
    "technocore.chat refused the note" to "technocore.chat recusou a nota",
    "technocore.chat refused the signed write" to "technocore.chat recusou a gravação assinada",
    "tell them" to "conte a eles",
    "text" to "texto",
    "the post" to "a publicação",
    "the same wallet rebuilds this identity anywhere" to
        "a mesma carteira recria esta identidade em qualquer lugar",
    "unconfirmed" to "não confirmado",
    "unsigned" to "sem assinatura",
    "verified" to "verificado",
    "verify it yourself" to "verifique por conta própria",
    "version" to "versão",
    "vouched for" to "validado",
    "wallet" to "carteira",
    "wallet linked" to "carteira vinculada",
    "what this app never does" to "o que este app nunca faz",
    "what to do" to "o que fazer",
    "when" to "quando",
    "with a wallet prefix, which is fine and pinned" to
        "com um prefixo da carteira, o que é válido e está fixado",
    "working" to "processando",
    "yes, a signed did-note line carries its hash" to
        "sim, uma linha did-note assinada contém seu hash",
    "yes, delete" to "sim, excluir",
    "yes, something is already public" to "sim, algo já está público",
    "your identity" to "sua identidade",
    "your private key" to "sua chave privada",
)
