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
    "06  tell them" to "06  conte a eles",
    "5 of 6" to "5 de 6",
    "A few more words, and it is yours. One real sentence is all this needs." to
        "Mais algumas palavras e ela é sua. Basta uma frase de verdade.",
    "A few reminders about the last step, and then they stop." to
        "Alguns lembretes sobre o último passo, e depois eles param.",
    "A little too long. Trim it and the whole post fits, key included." to
        "Um pouco longo. Corte um pouco e o post inteiro cabe, chave incluída.",
    "A once-a-day reminder to leave today's signed record." to
        "Um lembrete diário para deixar o registro assinado de hoje.",
    "A public note at an address derived from your key, so anyone can find and verify you later. This one goes to technocore.chat, which is someone else's public service: when it is busy it refuses, and pressing again is the answer. Two or three attempts is normal and means nothing is wrong with your phone." to
        "Uma nota pública num endereço calculado a partir da sua chave, para que qualquer um possa encontrar e verificar você depois. Esta vai para o technocore.chat, que é um serviço público de outra gente: quando está ocupado ele recusa, e a resposta é apertar de novo. Duas ou três tentativas é o normal e quer dizer que o seu telefone está bem.",
    "A signed record has to be left by hand, and a missed day cannot be filled in later. This is also the switch that warns you before your identity note is deleted." to
        "Um registro assinado precisa ser feito manualmente, e um dia perdido não pode ser preenchido depois. Esta opção também ativa o aviso antes que sua nota de identidade seja excluída.",
    "A tip changes nothing about your Passport and nothing about any airdrop." to
        "Uma gorjeta não muda nada no seu Passport nem em qualquer airdrop.",
    "A tip changes nothing about your Passport, and nothing about any airdrop. It is a thank you, not a fee." to
        "Uma gorjeta não muda nada no seu Passport nem em qualquer airdrop. É um agradecimento, não uma taxa.",
    "About" to "Sobre",
    "Accepted, but we could not read it back yet" to
        "Aceito, mas ainda não foi possível consultá-lo novamente",
    "Activity" to "Atividade",
    "All six done" to "Todos os seis concluídos",
    "Already checked in, found in the room" to "Registro já feito e encontrado na sala",
    "Already published, read back just now" to "Já publicado e consultado novamente agora",
    "Android is blocking notifications for this app. Turn them on in the system settings." to
        "O Android está bloqueando as notificações deste app. Ative-as nas configurações do sistema.",
    "Anyone can check it at the address in step 03. This app promises nothing about any allocation, and never will." to
        "Qualquer pessoa pode verificá-lo no endereço do passo 03. Este app não promete nenhuma alocação e nunca prometerá.",
    "Anyone holding it can sign as you" to "Quem o possuir pode assinar em seu nome",
    "Anyone holding seed_hex can sign as this identity on Technocore." to
        "Quem possuir seed_hex pode assinar como esta identidade no Technocore.",
    "Anyone who looks it up sees a key and nothing else." to
        "Quem procurar vê uma chave e mais nada.",
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
    "Daily activity" to "Atividade diária",
    "Daily reminder" to "Lembrete diário",
    "Delete it?" to "Excluir?",
    "Deleting removes the Passport from this phone only. Anything already published may stay public, and the same wallet rebuilds the same identity - so this is not a way to undo anything." to
        "A exclusão remove o Passport apenas deste telefone. Tudo o que já foi publicado pode continuar público, e a mesma carteira recria a mesma identidade — portanto, esta não é uma forma de desfazer nada.",
    "Did you post it?" to "Você publicou?",
    "Every language listed here has a full translation." to
        "Todos os idiomas listados aqui têm uma tradução completa.",
    "FLOP Passport creates a Technocore identity from your Solana wallet and keeps the receipts." to
        "FLOP Passport cria uma identidade Technocore a partir da sua carteira Solana e mantém os comprovantes.",
    "FLOP Passport for Seeker" to "FLOP Passport para Seeker",
    "FLOP Passport for Seeker - private backup" to "FLOP Passport para Seeker - backup privado",
    "FLOP Passport for Seeker by @AlexKosa1" to "FLOP Passport para Seeker por @AlexKosa1",
    "FLOP asked agents to do two things: create a unique key, and do something useful to spread the word about Technocore. The five steps above did the first. Nobody can do the second for you, so this writes the post and you decide whether to send it." to
        "A FLOP pediu aos agentes duas coisas: criar uma chave única e fazer algo útil para divulgar o Technocore. Os cinco passos acima fizeram a primeira. Ninguém pode fazer a segunda por você, então o app escreve a publicação e você decide se quer enviá-la.",
    "Identity derived from your wallet signature" to
        "Identidade derivada da assinatura da sua carteira",
    "If it does get deleted, your Passport is not gone: the same wallet still gives the same identity, and signing a record publishes the note back to the same address." to
        "Se ela for excluída, seu Passport não desaparece: a mesma carteira ainda gera a mesma identidade, e assinar um registro publica a nota novamente no mesmo endereço.",
    "In one line: what you did, or why you set this up" to
        "Em uma linha: o que você fez, ou por que criou isto",
    "It never asks for your wallet recovery phrase." to
        "Ele nunca solicita a frase de recuperação da sua carteira.",
    "It promises nothing about any airdrop, and never will." to
        "Ele não promete nada sobre qualquer airdrop e nunca prometerá.",
    "Keep this file offline. Never send it to anyone, including the app author." to
        "Mantenha este arquivo offline. Nunca o envie a ninguém, nem mesmo ao autor do app.",
    "Language" to "Idioma",
    "Last reminder about this one." to "Último lembrete sobre isso.",
    "Make your first signed check-in" to "Faça seu primeiro registro assinado",
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
    "Not done. Your Passport is not attached to any public name yet, and this is the one step nobody can do for you." to
        "Não feito. Seu Passport ainda não está ligado a nenhum nome público, e este é o passo que ninguém dá por você.",
    "Nothing asked yet" to "Nada foi solicitado ainda",
    "Nothing found. If you signed something and it is not here, the room has been trimmed past it - which is normal, and exactly why this screen exists." to
        "Nada encontrado. Se você assinou algo e ele não está aqui, a sala já removeu essa parte, o que é normal e é exatamente por isso que esta tela existe.",
    "Nothing has vouched for this text yet. Publish again to sign for it." to
        "Nada ainda respalda este texto. Publique novamente para assiná-lo.",
    "Nothing is broken and nothing is lost. Your Passport works. When you want the public half of it, step 06 is waiting where you left it." to
        "Nada quebrou e nada se perdeu. Seu Passport funciona. Quando quiser a metade pública dele, o passo 06 continua onde você parou.",
    "Nothing signed today yet." to "Nada assinado hoje ainda.",
    "One step left" to "Falta um passo",
    "Only languages with a real translation are listed. A picker offering languages that all render English would say your language is supported and then prove otherwise on the next screen." to
        "Apenas idiomas com uma tradução real são listados. Um seletor que oferecesse idiomas que exibem tudo em inglês diria que seu idioma é compatível e mostraria o contrário na tela seguinte.",
    "Opening a connection" to "Abrindo uma conexão",
    "Opening your Solana wallet" to "Abrindo sua carteira Solana",
    "Post your line, then come back and paste the link. That is what attaches your name to your key, and it is the half FLOP asked agents for." to
        "Publique sua linha e volte para colar o link. É isso que liga o seu nome à sua chave, e é a metade que a FLOP pediu aos agentes.",
    "Protect" to "Proteger",
    "Protect it" to "Proteja",
    "Publish" to "Publicar",
    "Publish your identity" to "Publique sua identidade",
    "Published and read back from the server" to "Publicado e consultado novamente no servidor",
    "Published, read back, and vouched for by your key" to
        "Publicado, consultado novamente e respaldado pela sua chave",
    "Publishing your identity note to technocore.chat" to
        "Publicando sua nota de identidade em technocore.chat",
    "Publishing your note" to "Publicando sua nota",
    "Questions, answered in full" to "Perguntas, respondidas por completo",
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
    "Show your private key" to "Mostrar sua chave privada",
    "Signed, accepted and found again in the room" to
        "Assinado, aceito e encontrado novamente na sala",
    "Signing your first check-in and sending it" to
        "Assinando e enviando seu primeiro registro",
    "Somebody changed this note after your key signed for it. Publish again." to
        "Alguém alterou esta nota depois que sua chave a respaldou. Publique novamente.",
    "Still one step short" to "Ainda falta um passo",
    "Talking to the service" to "Comunicando-se com o serviço",
    "Thanks for building this" to "Obrigado por criar isto",
    "That does not look like a link to a post. It should look like https://x.com/you/status/123." to
        "Isso não parece ser um link de uma publicação. Deve ser parecido com https://x.com/you/status/123.",
    "The key is sealed in this phone's secure storage, then read back and checked against your identity." to
        "A chave é selada no armazenamento seguro deste telefone, depois relida e comparada com sua identidade.",
    "The manual" to "O manual",
    "The server is busy. Trying again." to "O servidor está ocupado. Tentando novamente.",
    "The stored key does not match your identity" to
        "A chave armazenada não corresponde à sua identidade",
    "The wallet did not complete the signature" to "A carteira não concluiu a assinatura",
    "There are no points here and no score. FLOP asked agents to do something useful, so what counts is a record a person can still open. A number invented by this app would be a different game." to
        "Não há pontos nem pontuação aqui. A FLOP pediu aos agentes que fizessem algo útil, então o que conta é um registro que uma pessoa ainda possa abrir. Um número inventado por este app seria outro jogo.",
    "These 32 bytes are your FLOP Passport itself. Whoever holds them can sign as you on Technocore. Keep them offline and never send them to anyone, including us." to
        "Estes 32 bytes são o próprio FLOP Passport. Quem os possuir pode assinar em seu nome no Technocore. Mantenha-os offline e nunca os envie a ninguém, nem mesmo a nós.",
    "This app is free and open source, and nobody paid for it. If it saved you an afternoon, a tip is welcome." to
        "Este app é gratuito e de código aberto, e ninguém pagou por ele. Se ele poupou uma tarde sua, uma gorjeta é bem-vinda.",
    "This app is free and open source. If it was useful, you can send a tip to {name}. Your wallet opens and you choose the amount there." to
        "Este app é gratuito e de código aberto. Se ele foi útil, você pode enviar uma gorjeta para {name}. Sua carteira abre e você escolhe o valor lá.",
    "This app rewrites your note every time you open it and every time you sign a record, so the seven days start again. Open it at least once a week and nothing is ever lost." to
        "Este app regrava sua nota sempre que você o abre e sempre que assina um registro, reiniciando os sete dias. Abra-o pelo menos uma vez por semana e nada será perdido.",
    "This is NOT your Solana wallet key. Your wallet's own key never leaves Seed Vault and this app has never seen it. What you are looking at is a separate key that signs only on Technocore." to
        "Esta NÃO é a chave da sua carteira Solana. A chave da carteira nunca sai do Seed Vault e este app nunca teve acesso a ela. Esta é uma chave separada que assina apenas no Technocore.",
    "This line is what makes the post yours. Everything under it is the proof." to
        "Esta linha é o que torna o post seu. Tudo abaixo dela é a prova.",
    "Three days left before it is deleted." to "Faltam três dias para ela ser excluída.",
    "Today cannot be added later" to "O dia de hoje não dá para acrescentar depois",
    "Told only when your identity note is days away from being deleted." to
        "Você só recebe um aviso quando faltam poucos dias para sua nota de identidade ser excluída.",
    "Tomorrow is the last day." to "Amanhã é o último dia.",
    "Two days left before it is deleted." to "Faltam dois dias para ela ser excluída.",
    "Unfinished setup" to "Configuração inacabada",
    "Use the phone's language" to "Usar o idioma do telefone",
    "Wait a moment and press it again to re-check. Do not treat this as a failure." to
        "Aguarde um momento e pressione novamente para verificar. Não considere isso uma falha.",
    "Wait a moment and press it again to re-check. Sending it as a new message would post twice in public." to
        "Aguarde um momento e pressione novamente para verificar. Enviar como nova mensagem publicaria duas vezes.",
    "What is still provable" to "O que ainda pode ser comprovado",
    "What recovery without a seed phrase costs" to "O que custa recuperar sem frase-semente",
    "What to do and how often, why the identity expires, why this works on a Seeker, and what the catch is. Opens in your browser." to
        "O que fazer e com que frequência, por que a identidade expira, por que isso funciona em um Seeker e qual é o porém. Abre no seu navegador.",
    "Write one line only you would write. Posts that differ from each other by nothing but a key get read as farming, and that lands on the people who did the work." to
        "Escreva uma linha que só você escreveria. Posts que diferem entre si por nada além de uma chave são lidos como farm, e isso sobra para quem realmente fez o trabalho.",
    "Yes. Something is already visible to others." to
        "Sim. Algo já está visível para outras pessoas.",
    "You do not need this file to recover. The same Solana wallet that" to
        "Você não precisa deste arquivo para recuperar. A mesma carteira Solana que",
    "You do not need this to recover. The same Solana wallet rebuilds the same Passport on any phone. This copy is for using the key somewhere else, on your own terms." to
        "Você não precisa disto para recuperar. A mesma carteira Solana recria o mesmo Passport em qualquer telefone. Esta cópia serve para usar a chave em outro lugar, sob seus próprios termos.",
    "You finished the five. The last one takes a minute." to
        "Você terminou os cinco. O último leva um minuto.",
    "You have already checked in" to "Você já fez um registro",
    "You have already left a record today." to "Você já deixou um registro hoje.",
    "You're all set" to "Tudo pronto",
    "Your Passport has no name on it" to "Seu Passport não tem nome nenhum",
    "Your Passport is derived from one signature your wallet makes inside Seed Vault, the Seeker's hardware key store. The wallet key never leaves that hardware. The Passport key is computed from its signature in this app and then sealed by Android's secure storage - sealed, not signed, in hardware, because Android Keystore cannot hold this kind of key." to
        "Seu Passport é derivado de uma assinatura que sua carteira faz dentro do Seed Vault, o armazenamento de chaves em hardware do Seeker. A chave da carteira nunca sai desse hardware. A chave do Passport é calculada a partir dessa assinatura neste aplicativo e depois selada pelo armazenamento seguro do Android — selada, não assinada, em hardware, porque o Android Keystore não pode armazenar esse tipo de chave.",
    "Your Passport is live" to "Seu Passport está ativo",
    "Your Passport is live and your first signed record is on Technocore. Anyone can verify it, and it stays yours." to
        "Seu Passport está ativo e seu primeiro registro assinado está no Technocore. Qualquer pessoa pode verificá-lo, e ele continua sendo seu.",
    "Your Passport is live. One step left." to "Seu Passport está ativo. Falta um passo.",
    "Your Passport is rebuilt from one wallet signature, which is why no seed phrase exists to lose. The same fact cuts the other way: any app that persuades your wallet to sign that exact sentence can rebuild this Passport. Read what a wallet asks you to sign, here and everywhere else." to
        "Seu Passport é reconstruído a partir de uma única assinatura da carteira, por isso não existe frase-semente para perder. O mesmo vale ao contrário: qualquer aplicativo que convença sua carteira a assinar exatamente essa frase pode reconstruir este Passport. Leia o que uma carteira pede para assinar, aqui e em qualquer lugar.",
    "Your identity note expires soon" to "Sua nota de identidade expira em breve",
    "Your identity note has been deleted" to "Sua nota de identidade foi excluída",
    "Your key is never sent anywhere. Only you can export it." to
        "Sua chave nunca é enviada a lugar algum. Somente você pode exportá-la.",
    "Your key signed a line carrying this note's exact hash." to
        "Sua chave assinou uma linha com o hash exato desta nota.",
    "Your note has to be kept alive" to "Sua nota precisa ser mantida ativa",
    "Your post is in your identity note, at your key's own address." to
        "Seu post está na sua nota de identidade, no endereço da sua própria chave.",
    "Your wallet signs one statement. It is not a transaction and moves no funds. The same wallet rebuilds the same Passport on any device." to
        "Sua carteira assina uma declaração. Não é uma transação e não movimenta fundos. A mesma carteira recria o mesmo Passport em qualquer dispositivo.",
    "active days" to "dias ativos",
    "activity" to "atividade",
    "address" to "endereço",
    "algorithm: Ed25519, did:key, 32-byte seed" to
        "algoritmo: Ed25519, did:key, seed de 32 bytes",
    "attach it" to "anexar",
    "built by a community builder" to "criado por um desenvolvedor da comunidade",
    "cancel" to "cancelar",
    "change" to "alterar",
    "changed" to "alterada",
    "check again" to "conferir de novo",
    "checked" to "conferido",
    "close" to "fechar",
    "connection" to "conexão",
    "content" to "conteúdo",
    "continue" to "continuar",
    "copy" to "copiar",
    "copy key" to "copiar chave",
    "create passport" to "criar passport",
    "created this Passport rebuilds it on any device." to
        "criou este Passport o recria em qualquer dispositivo.",
    "danger zone" to "zona de perigo",
    "day streak" to "sequência de dias",
    "delete passport from this phone" to "excluir passport deste telefone",
    "detail" to "detalhe",
    "did anything go public?" to "algo se tornou público?",
    "done" to "concluído",
    "failed" to "falhou",
    "fetched again and matched exactly" to "consultado novamente e idêntico",
    "fetched from the server on opening" to "consultado no servidor ao abrir",
    "fingerprint" to "impressão digital",
    "flop-passport vault self-test" to "autoteste do armazenamento de chaves flop-passport",
    "identity" to "identidade",
    "identity note" to "nota de identidade",
    "language {code}" to "idioma {code}",
    "last connection" to "última conexão",
    "linked" to "vinculado",
    "live records" to "registros ativos",
    "matched on our nonce, not just our key" to
        "correspondeu ao nosso nonce, não apenas à nossa chave",
    "no thanks, continue" to "não, obrigado, continuar",
    "no, nothing was made public" to "não, nada se tornou público",
    "nonce" to "nonce",
    "not found" to "não encontrado",
    "not yet" to "ainda não",
    "not yet - the note alone is a claim, not a proof" to
        "ainda não - a nota por si só é uma declaração, não uma prova",
    "off" to "desativado",
    "on" to "ativado",
    "open" to "abrir",
    "our exact bytes, no wallet prefix" to "nossos bytes exatos, sem prefixo da carteira",
    "passport for seeker" to "passport para seeker",
    "pin it to your identity" to "fixar na sua identidade",
    "private key, 32 bytes, hex" to "chave privada, 32 bytes, hex",
    "protect passport" to "proteger passport",
    "publish identity" to "publicar identidade",
    "published" to "publicado",
    "publishing" to "publicando",
    "re-check with the server" to "verificar novamente no servidor",
    "re-checked when the app opened" to "verificado novamente ao abrir o app",
    "records the server still holds" to "registros que o servidor ainda mantém",
    "recovery" to "recuperação",
    "room" to "sala",
    "save to a file" to "salvar em um arquivo",
    "say it another way" to "dizer de outro jeito",
    "self test" to "autoteste",
    "send a tip" to "enviar uma gorjeta",
    "send a tip in {token}" to "enviar uma gorjeta em {token}",
    "send a tip to {name}" to "enviar uma gorjeta para {name}",
    "sequence" to "sequência",
    "settings" to "configurações",
    "sign and check in" to "assinar e fazer registro",
    "sign today's record" to "assinar o registro de hoje",
    "signed" to "assinado",
    "signed and verified against your DID" to "assinado e verificado com seu DID",
    "step {n} {title} complete" to "passo {n} {title} concluído",
    "step {n} {title} did not finish" to "passo {n} {title} não terminou",
    "storage" to "armazenamento",
    "support the builder" to "apoiar o desenvolvedor",
    "technocore.chat answered" to "technocore.chat respondeu",
    "technocore.chat deletes anything nobody has written to for seven days. That includes the identity note at the address you save and share." to
        "technocore.chat exclui tudo em que ninguém escreve por sete dias. Isso inclui a nota de identidade no endereço que você salva e compartilha.",
    "technocore.chat refused the note" to "technocore.chat recusou a nota",
    "technocore.chat refused the signed write" to "technocore.chat recusou a gravação assinada",
    "text" to "texto",
    "the note changed between reads" to "a nota mudou entre as leituras",
    "the post" to "a publicação",
    "the same wallet rebuilds this identity anywhere" to
        "a mesma carteira recria esta identidade em qualquer lugar",
    "try again" to "tentar de novo",
    "unconfirmed" to "não confirmado",
    "unsigned" to "sem assinatura",
    "verified" to "verificado",
    "verify it yourself" to "verificar por conta própria",
    "version" to "versão",
    "vouched for" to "respaldado",
    "wallet" to "carteira",
    "wallet linked" to "carteira vinculada",
    "what this app never does" to "o que este app nunca faz",
    "what to do" to "o que fazer",
    "when" to "quando",
    "working" to "processando",
    "yes, a signed did-note line carries its hash" to
        "sim, uma linha did-note assinada contém seu hash",
    "yes, delete" to "sim, excluir",
    "yes, something is already public" to "sim, algo já está público",
    "your identity" to "sua identidade",
    "your private key" to "sua chave privada",
    "{token} is preselected and you can switch it." to
        "{token} já vem selecionado e você pode trocar.",
    "Try again. Nothing was sent anywhere." to
        "Tente de novo. Nada foi enviado para lugar nenhum.",
    "Try again. technocore.chat is a public service and it refuses writes when it is busy, which has nothing to do with this app, your phone or your key. Two or three attempts is normal. Nothing was published." to
        "Tente de novo. A technocore.chat é um serviço público e recusa escritas quando está sobrecarregada, o que não tem nada a ver com este app, seu telefone ou sua chave. Duas ou três tentativas é o normal. Nada foi publicado.",
    "Try again. technocore.chat is a public service and it refuses writes when it is busy, which has nothing to do with this app, your phone or your key. Two or three attempts is normal. Nothing was posted." to
        "Tente de novo. A technocore.chat é um serviço público e recusa escritas quando está sobrecarregada, o que não tem nada a ver com este app, seu telefone ou sua chave. Duas ou três tentativas é o normal. Nada foi enviado.",
    "Could not reach technocore.chat. Check your connection and try again; nothing was lost." to
        "Não foi possível alcançar a technocore.chat. Verifique sua conexão e tente de novo; nada foi perdido.",
    "The service took your record but has not shown it back yet. Press re-check in a moment; nothing needs signing again." to
        "O serviço aceitou seu registro mas ainda não o mostrou de volta. Toque em verificar novamente daqui a pouco; não é preciso assinar nada outra vez.",
    "technocore.chat refused the record. It refuses writes when it is busy - try again in a moment." to
        "A technocore.chat recusou o registro. Ela recusa escritas quando está sobrecarregada; tente de novo daqui a pouco.",
    "Not finished yet. Your Passport is not live until all five are green, and there is nothing complete for anyone to verify. Keep going." to
        "Ainda não terminou. Seu Passport não fica ativo até que os cinco estejam verdes, e não há nada completo para ninguém verificar. Continue.",
    "A message signed by your Passport, posted to a quiet room and then read back to prove it landed. Same service as step 03, same rule: if it refuses, press again. That is the service being busy, not a problem with your key." to
        "Uma mensagem assinada pelo seu Passport, publicada numa sala tranquila e depois lida de volta para provar que chegou. O mesmo serviço do passo 03 e a mesma regra: se recusar, toque de novo. É o serviço estando ocupado, não um problema com sua chave.",
    "Deleted after seven days with nothing written to it. Publish it now and it goes back to the same address." to
        "É apagada após sete dias sem nada escrito nela. Publique agora e ela volta para o mesmo endereço.",
    "Identity note at risk" to
        "Sua nota de identidade em risco",
    "In Settings, delete the Passport from this phone, then create it again from your wallet." to
        "Nas Configurações, apague o Passport deste telefone e crie-o de novo a partir da sua carteira.",
    "It is deleted after seven days with nothing written to it. Opening this app writes it." to
        "É apagada após sete dias sem nada escrito nela. Abrir este app já escreve nela.",
    "Maybe. The service accepted it, and this app could not read it back to be sure." to
        "Talvez. O serviço aceitou, mas este app não conseguiu ler de volta para ter certeza.",
    "That was the last of the five. Your Passport is live. One thing left, and it is the part FLOP actually asked for: tell people what you did. The app writes the post for you at the bottom of this screen." to
        "Esse foi o último dos cinco. Seu Passport está ativo. Falta uma coisa, e é justamente o que a FLOP pediu: conte às pessoas o que você fez. O app escreve a publicação para você no fim desta tela.",
    "This app is free and there is nothing in it to buy. If it has been useful, a thank you can go to kosa.skr." to
        "Este app é gratuito e não há nada para comprar nele. Se ele foi útil, um obrigado pode ir para kosa.skr.",
    "checking" to
        "verificando",
    "open notification settings" to
        "abrir configurações de notificação",
    "send a tip to kosa.skr" to
        "enviar uma gorjeta para kosa.skr",
    "show my private key" to
        "mostrar minha chave privada",
    "step {n} {title} not confirmed yet" to
        "passo {n} {title} ainda não confirmado",
    "technocore.chat deletes anything with no write for seven days. Opening this app rewrites your note, and so does signing a record. Either one starts the seven days again." to
        "A technocore.chat apaga tudo em que ninguém escreveu por sete dias. Abrir este app reescreve sua nota, e assinar um registro também. Qualquer uma das duas recomeça os sete dias.",
    "This phone has no screen lock set up. Add a PIN or a fingerprint first." to
        "Este telefone não tem bloqueio de tela. Configure primeiro um PIN ou uma digital.",
    "The server accepted the write but the message is not in the room yet. Do not resend: read the room again first." to
        "O servidor aceitou a escrita, mas a mensagem ainda não está na sala. Não reenvie: leia a sala de novo primeiro.",
    "The stored text differs from the text we signed" to
        "O texto guardado não corresponde ao que assinamos",
    "The stored record did not verify against this key" to
        "O registro guardado não confere com esta chave",
    "You made a key only your wallet can rebuild, sealed it in this phone, published it where a stranger can find it, signed a record and proved it landed, and put your post beside your key. There is nothing left to set up." to
        "Você criou uma chave que só a sua carteira consegue reconstruir, selou-a neste telefone, publicou-a onde um desconhecido pode encontrá-la, assinou um registro e provou que ele chegou, e colocou sua publicação ao lado da sua chave. Não sobrou nada para configurar.",
    "open Activity" to
        "abrir Atividade",
    "{n} more characters and the button below wakes up." to
        "Mais {n} caracteres e o botão abaixo acorda.",
    "A signed record is dated evidence that you were here. A day without one cannot be added later, and signing also keeps your identity note alive. Nothing here promises anything about any allocation." to
        "Um registro assinado é uma prova datada de que você esteve aqui. Um dia sem registro não pode ser acrescentado depois, e assinar também mantém sua nota de identidade viva. Nada aqui promete qualquer alocação.",
    "Could not check technocore.chat for your published steps. This says nothing about them, only about the connection. Re-check when you are back online." to
        "Não foi possível consultar o technocore.chat sobre seus passos publicados. Isso não diz nada sobre eles, só sobre a conexão. Verifique novamente quando estiver on-line.",
    "Could not reach technocore.chat. Check your connection and press publish again. Your link is saved on this phone either way." to
        "Não foi possível alcançar o technocore.chat. Verifique sua conexão e toque em publicar de novo. Seu link fica salvo neste telefone de qualquer forma.",
    "Could not read the key from secure storage. Restart the phone and try again." to
        "Não foi possível ler a chave do armazenamento seguro. Reinicie o telefone e tente de novo.",
    "FLOP Passport is an independent community project. It is not made, endorsed or reviewed by FLOP Labs or by Solana Mobile." to
        "O FLOP Passport é um projeto independente da comunidade. Não é feito, endossado nem revisado pela FLOP Labs nem pela Solana Mobile.",
    "Finish the steps on the Passport tab first. Daily records start once your Passport is live." to
        "Termine primeiro os passos na aba Passport. Os registros diários começam quando seu Passport estiver ativo.",
    "From now on: open the app at least once a week, so your identity note is not deleted. On the days you do something, open Activity and sign that day's record - a day cannot be added later." to
        "Daqui em diante: abra o app pelo menos uma vez por semana, para que sua nota de identidade não seja apagada. Nos dias em que fizer algo, abra Atividade e assine o registro daquele dia; um dia não pode ser acrescentado depois.",
    "If you did something today, sign a record for it now." to
        "Se você fez algo hoje, assine um registro agora.",
    "Link to your post on X" to
        "Link da sua publicação no X",
    "Nothing was saved. Open your private key again and save it from there." to
        "Nada foi salvo. Abra sua chave privada de novo e salve a partir dali.",
    "Paste the link here and your name goes beside your key, in your identity note. This is the part people mean to do later and then do not." to
        "Cole o link aqui e seu nome fica ao lado da sua chave, na sua nota de identidade. Essa é a parte que as pessoas pretendem fazer depois e acabam não fazendo.",
    "Paste the link to your post on X. It goes into your identity note, so the note points at the post and the post carries the key. Anyone can then check both ends against one key. The app does not open the link or check the post; anyone reading your note can." to
        "Cole o link da sua publicação no X. Ele entra na sua nota de identidade, de modo que a nota aponta para a publicação e a publicação carrega a chave. Assim qualquer pessoa pode conferir as duas pontas com uma só chave. O app não abre o link nem verifica a publicação; quem ler sua nota pode fazer isso.",
    "Read from technocore.chat, not from this phone. Rooms are trimmed as they grow, so this shows what anyone would find today." to
        "Lido do technocore.chat, não deste telefone. As salas são aparadas conforme crescem, então isto mostra o que qualquer pessoa encontraria hoje.",
    "Seeker and Solana Mobile are trademarks of Solana Mobile, used only to say what this app is built for. FLOP and Technocore are names of the project whose public service this app writes to." to
        "Seeker e Solana Mobile são marcas da Solana Mobile, usadas apenas para dizer para que este app foi feito. FLOP e Technocore são nomes do projeto em cujo serviço público este app escreve.",
    "Seven days without opening the app. Open it and press publish; the note goes back to the same address." to
        "Sete dias sem abrir o app. Abra-o e toque em publicar; a nota volta para o mesmo endereço.",
    "The file could not be written. Try another location." to
        "O arquivo não pôde ser gravado. Tente outro local.",
    "The five steps built your identity. Nobody outside this phone knows it is yours yet. Step 06 below: write one line, post it, then come back and paste the link. That last part is what puts your name beside your key, and it is where people stop." to
        "Os cinco passos construíram sua identidade. Fora deste telefone ninguém sabe ainda que ela é sua. Passo 06 abaixo: escreva uma linha, publique, depois volte e cole o link. Essa última parte é o que põe seu nome ao lado da sua chave, e é onde as pessoas param.",
    "The key could not be sealed in this phone's secure storage" to
        "Não foi possível selar a chave no armazenamento seguro deste telefone",
    "The link you paste goes into your identity note, at an address derived from your own key. The note stays as long as you keep opening the app; seven days without a write and it is deleted." to
        "O link que você cola entra na sua nota de identidade, num endereço derivado da sua própria chave. A nota permanece enquanto você continuar abrindo o app; sete dias sem uma escrita e ela é apagada.",
    "The note was accepted, but it could not be read back yet." to
        "A nota foi aceita, mas ainda não pôde ser lida de volta.",
    "The record was sent but no answer came back in time. Do not resend: read the room again first." to
        "O registro foi enviado, mas nenhuma resposta chegou a tempo. Não reenvie: leia a sala de novo primeiro.",
    "Three things, in this order: write your line, post it on X, then come back and paste the link. The last one is what puts your name beside your key, and it is the one people forget." to
        "Três coisas, nesta ordem: escreva sua linha, publique no X, depois volte e cole o link. A última é o que põe seu nome ao lado da sua chave, e é a que as pessoas esquecem.",
    "Today is the last day. It is deleted within 24 hours unless you open the app." to
        "Hoje é o último dia. Ela é apagada em 24 horas, a menos que você abra o app.",
    "Try again. If it keeps failing, restart the phone and try once more. Nothing was sent anywhere." to
        "Tente de novo. Se continuar falhando, reinicie o telefone e tente mais uma vez. Nada foi enviado a lugar nenhum.",
    "Your Passport is live, it is yours, and your post link is on it." to
        "Seu Passport está ativo, é seu, e o link da sua publicação está nele.",
    "Your Passport itself is not lost: the same wallet still gives the same identity, and publishing again puts the note back at the same address." to
        "Seu Passport em si não se perdeu: a mesma carteira ainda dá a mesma identidade, e publicar de novo recoloca a nota no mesmo endereço.",
    "checking with the server" to
        "verificando com o servidor",
    "independent project" to
        "projeto independente",
    "not in your note yet" to
        "ainda não está na sua nota",
    "post it on X" to
        "publicar no X",
    "put it in my note" to
        "colocar na minha nota",
    "technocore.chat did not take the change. It refuses writes when it is busy - press publish again in a moment. Your link is saved on this phone either way." to
        "O technocore.chat não aceitou a alteração. Ele recusa escritas quando está ocupado; toque em publicar de novo daqui a pouco. Seu link fica salvo neste telefone de qualquer forma.",
    "vault: not sealed yet" to
        "cofre: ainda não selado",
    "vault: secure area" to
        "cofre: área segura",
    "vault: security chip" to
        "cofre: chip de segurança",
    "vault: software" to
        "cofre: software",
    "with a wallet prefix - this Passport rebuilds only through this same wallet app" to
        "com prefixo da carteira — este Passport só se reconstrói pelo mesmo app de carteira",
    "The prompt for this app begins with FLOP Passport key derivation v1 and names the app dev.alexkosa.floppassport; your wallet shows it was requested by flop.alexkosa.dev." to
        "O pedido deste app começa com FLOP Passport key derivation v1 e nomeia o app dev.alexkosa.floppassport; sua carteira mostra que ele foi solicitado por flop.alexkosa.dev.",

    // 2.0: FLOP account, my day, guide and questions (2026-11-03).
    "@flop_labs is FLOP's account on X, YouTube and TikTok." to
        "@flop_labs é a conta da FLOP no X, no YouTube e no TikTok.",
    "A FLOP account with daily FLOP" to
        "Uma conta FLOP com FLOP todo dia",
    "A flop.finance address, but not one FLOP lists publicly. Ask through x.com/flop_labs." to
        "Um endereço flop.finance, mas não um que a FLOP divulgue publicamente. Pergunte por x.com/flop_labs.",
    "A flop.finance address. FLOP lists security@flop.finance as its one public contact." to
        "Um endereço flop.finance. A FLOP indica security@flop.finance como seu único contato público.",
    "A model you pay in FLOP, and a streak" to
        "Um modelo que você paga em FLOP, e uma sequência",
    "A practice network, open to everyone since 3 November 2026. FLOP here has no value, earns nothing and can be wiped in a reset. Use it to learn the day before it counts." to
        "Uma rede de treino, aberta a todos desde 3 de novembro de 2026. Aqui o FLOP não tem valor, não rende nada e pode ser apagado num reset. Use-a para aprender o dia antes que ele conte.",
    "A streak counts days in a row with a signed record. One missed day a week is now forgiven; two missed days in a row end it. The count is read from the public room, so a day you did not sign cannot be added later." to
        "Uma sequência conta os dias seguidos com um registro assinado. Agora um dia perdido por semana é perdoado; dois dias perdidos seguidos a encerram. A contagem é lida da sala pública, então um dia que você não assinou não pode ser acrescentado depois.",
    "About 90 days. This is where FLOP's agent airdrop is earned: the testnet FLOP you spend on the model is recorded as your claim on mainnet FLOP." to
        "Cerca de 90 dias. É aqui que se ganha o airdrop de agentes da FLOP: o FLOP da testnet que você gasta no modelo fica registrado como seu direito a FLOP da mainnet.",
    "Alex Kosa, one developer, for Seeker owners. It is not made by FLOP Labs. It is free and its code is open." to
        "Alex Kosa, um único desenvolvedor, para donos de Seeker. Não é feito pela FLOP Labs. É gratuito e o código é aberto.",
    "An identity made by your wallet" to
        "Uma identidade criada pela sua carteira",
    "Ask a question, see what it cost, and keep a streak of the days you show up." to
        "Faça uma pergunta, veja quanto custou e mantenha uma sequência dos dias em que você aparece.",
    "Ask anything. The model is small, so short, plain questions work best. Each answer costs a few devnet FLOP, taken from your Passport's allowance." to
        "Pergunte o que quiser. O modelo é pequeno, então perguntas curtas e simples funcionam melhor. Cada resposta custa alguns FLOP da devnet, tirados da cota do seu Passport.",
    "Ask the model" to
        "Perguntar ao modelo",
    "Ask the model one question" to
        "Faça uma pergunta ao modelo",
    "Blocks are being finalised normally." to
        "Os blocos estão sendo finalizados normalmente.",
    "Could not reach FLOP's gateway. Check your connection and try again." to
        "Não foi possível acessar o gateway da FLOP. Verifique sua conexão e tente novamente.",
    "Could not reach technocore.chat." to
        "Não foi possível acessar technocore.chat.",
    "Could not reach the FLOP devnet node. This says nothing about your balance, only about the connection." to
        "Não foi possível acessar o nó da devnet da FLOP. Isso não diz nada sobre seu saldo, apenas sobre a conexão.",
    "Could not reach the FLOP explorer." to
        "Não foi possível acessar o explorador da FLOP.",
    "Could not reach the FLOP faucet. Check your connection and try again." to
        "Não foi possível acessar o faucet da FLOP. Verifique sua conexão e tente novamente.",
    "Devnet FLOP is practice money: it has no value and can be wiped in a reset." to
        "O FLOP da devnet é dinheiro de treino: não tem valor e pode ser apagado num reset.",
    "Devnet explorer" to
        "Explorador da devnet",
    "Devnet is open" to
        "A devnet está aberta",
    "Devnet is open to everyone since 3 November 2026. It has no rewards and may be reset. Testnet has no date yet; FLOP will announce it on x.com/flop_labs. On testnet, the testnet FLOP an agent spends on inference becomes its claim on mainnet FLOP. Creating accounts earns nothing." to
        "A devnet está aberta a todos desde 3 de novembro de 2026. Ela não tem recompensas e pode ser reiniciada. A testnet ainda não tem data; a FLOP vai anunciá-la em x.com/flop_labs. Na testnet, o FLOP da testnet que um agente gasta em inferência vira seu direito a FLOP da mainnet. Criar contas não rende nada.",
    "Devnet is practice" to
        "A devnet é treino",
    "Devnet is practice: its FLOP has no value. This app promises nothing about any allocation." to
        "A devnet é treino: o FLOP dela não tem valor. Este app não promete nenhuma alocação.",
    "Do I have to post on X?" to
        "Preciso publicar no X?",
    "Do I need more than one account?" to
        "Preciso de mais de uma conta?",
    "Do my day" to
        "Completar meu dia",
    "Every step below was read back from the server, not just sent." to
        "Cada passo abaixo foi lido de volta do servidor, não apenas enviado.",
    "Explain the idea of a 'seed phrase' and why it must stay secret." to
        "Explique a ideia de uma 'frase-semente' e por que ela precisa ficar em segredo.",
    "Explain what 'decentralised' means without using jargon." to
        "Explique o que significa 'descentralizado' sem usar jargão.",
    "Explain what a blockchain block is to a ten-year-old, in three sentences." to
        "Explique o que é um bloco de blockchain para uma criança de dez anos, em três frases.",
    "Explain what an API is using a restaurant as the example." to
        "Explique o que é uma API usando um restaurante como exemplo.",
    "Explain what open-source software is in two sentences." to
        "Explique o que é software de código aberto em duas frases.",
    "FLOP Network is a blockchain where AI agents pay for AI work with FLOP. Miners run models on graphics cards, validators check that the work was really done, and agents buy the answers. Asking the model a question here is exactly that: your Passport acts as an agent and pays for one answer." to
        "A FLOP Network é uma blockchain onde agentes de IA pagam com FLOP por trabalho de IA. Mineradores rodam modelos em placas de vídeo, validadores conferem se o trabalho foi mesmo feito e os agentes compram as respostas. Fazer uma pergunta ao modelo aqui é exatamente isso: seu Passport age como um agente e paga por uma resposta.",
    "FLOP Passport gives your Seeker an identity and an account on FLOP Network, and one place to do your day there. It is free, open source, and made by one developer, Alex Kosa. It is not made by FLOP Labs." to
        "O FLOP Passport dá ao seu Seeker uma identidade e uma conta na FLOP Network, e um só lugar para completar seu dia lá. É gratuito, de código aberto e feito por um único desenvolvedor, Alex Kosa. Não é feito pela FLOP Labs.",
    "FLOP gives each account one devnet allowance: 25 FLOP for 24 hours. When it is over it is over until testnet." to
        "A FLOP dá a cada conta uma única cota da devnet: 25 FLOP por 24 horas. Quando acaba, acabou até a testnet.",
    "FLOP has no Discord, Telegram, Reddit or Medium. There is no FLOP token yet." to
        "A FLOP não tem Discord, Telegram, Reddit nem Medium. Ainda não existe nenhum token FLOP.",
    "FLOP has no official Discord, Telegram, Reddit or Medium. An invitation to one never comes from FLOP." to
        "A FLOP não tem Discord, Telegram, Reddit nem Medium oficiais. Um convite para um deles nunca vem da FLOP.",
    "FLOP has not announced the testnet date. When it opens, the testnet FLOP you spend on the model becomes your claim on mainnet FLOP. Holding FLOP or making more accounts earns nothing." to
        "A FLOP não anunciou a data da testnet. Quando ela abrir, o FLOP da testnet que você gastar no modelo vira seu direito a FLOP da mainnet. Ter FLOP ou criar mais contas não rende nada.",
    "FLOP has not given a date. It will be announced on x.com/flop_labs, and this app's status will say so the same day." to
        "A FLOP não deu uma data. Ela será anunciada em x.com/flop_labs, e o status deste app vai mostrar isso no mesmo dia.",
    "FLOP says Q1 2027" to
        "Segundo a FLOP, 1º trimestre de 2027",
    "FLOP says there is no token, mint, claim, presale or live airdrop yet. Anything offering one is not FLOP." to
        "A FLOP diz que ainda não há token, mint, claim, pré-venda nem airdrop ativo. Qualquer coisa que ofereça um não é a FLOP.",
    "FLOP's faucet is down for everyone right now. It is not your phone. Try again later." to
        "O faucet da FLOP está fora do ar para todos agora. Não é o seu telefone. Tente mais tarde.",
    "FLOP's faucet is refusing every request with “IP classification unavailable”. This is FLOP's bug (network issue #22), not your phone. The app keeps trying when you press do my day." to
        "O faucet da FLOP está recusando todo pedido com “IP classification unavailable”. É um bug da FLOP (issue #22 da rede), não do seu telefone. O app continua tentando quando você toca em completar meu dia.",
    "FLOP's faucet sends 25 devnet FLOP to your address, once every 24 hours per address. The request goes from your phone, for your own address, the same as pressing the button on faucet.flop.network. When the faucet is down, the app says so and the rest of your day still counts." to
        "O faucet da FLOP envia 25 FLOP da devnet para o seu endereço, uma vez a cada 24 horas por endereço. O pedido sai do seu telefone, para o seu próprio endereço, igual a tocar no botão em faucet.flop.network. Quando o faucet está fora do ar, o app avisa e o resto do seu dia continua contando.",
    "FLOP's gateway has handed out all of today's devnet allowances, or is unavailable. Try again later." to
        "O gateway da FLOP já distribuiu todas as cotas da devnet de hoje, ou está indisponível. Tente mais tarde.",
    "FLOP's gateway rules (OpenAPI)" to
        "Regras do gateway da FLOP (OpenAPI)",
    "FLOP's only handle is @flop_labs. Any other account using the name is not theirs." to
        "O único perfil da FLOP é @flop_labs. Qualquer outra conta usando o nome não é deles.",
    "FLOP: official links and verification" to
        "FLOP: links oficiais e verificação",
    "FLOP: the airdrop and testnet conversion" to
        "FLOP: o airdrop e a conversão da testnet",
    "Faucet outage, FLOP issue #22" to
        "Faucet fora do ar, issue #22 da FLOP",
    "Finality is lagging behind. The network may be slow." to
        "A finalidade está atrasada. A rede pode estar lenta.",
    "Finish setting up your Passport first." to
        "Termine de configurar seu Passport primeiro.",
    "Free and open source. Made by Alex Kosa, not by FLOP Labs. It promises nothing about any allocation." to
        "Gratuito e de código aberto. Feito por Alex Kosa, não pela FLOP Labs. Não promete nenhuma alocação.",
    "From FLOP's faucet, once every 24 hours." to
        "Do faucet da FLOP, uma vez a cada 24 horas.",
    "From FLOP's faucet. Next in {time}." to
        "Do faucet da FLOP. O próximo em {time}.",
    "From the FLOP Passport team, written into this version." to
        "Da equipe do FLOP Passport, escrito nesta versão.",
    "From the FLOP Passport team." to
        "Da equipe do FLOP Passport.",
    "Get 25 FLOP" to
        "Receber 25 FLOP",
    "Give me a short motivational sentence for a Monday." to
        "Me dê uma frase motivacional curta para uma segunda-feira.",
    "Give me a simple recipe idea with rice and eggs." to
        "Me dê uma ideia de receita simples com arroz e ovos.",
    "Give me one practical tip for writing clearer emails." to
        "Me dê uma dica prática para escrever e-mails mais claros.",
    "Give one good question to ask before buying any crypto token." to
        "Diga uma boa pergunta para fazer antes de comprar qualquer token cripto.",
    "Give one way to remember a new word in a foreign language." to
        "Diga uma forma de lembrar uma palavra nova em um idioma estrangeiro.",
    "Give three tips for keeping a phone's battery healthy." to
        "Dê três dicas para manter saudável a bateria do celular.",
    "I changed phones. How do I get my Passport back?" to
        "Troquei de telefone. Como recupero meu Passport?",
    "In plain words, what does 'inference' mean for an AI model?" to
        "Em palavras simples, o que significa 'inferência' para um modelo de IA?",
    "In two sentences, what does a GPU do that a CPU does badly?" to
        "Em duas frases, o que uma GPU faz que uma CPU faz mal?",
    "Install the app and connect the same Solana wallet. The same wallet makes the same Passport, with the same FLOP address and the same streak. There are no words to write down." to
        "Instale o app e conecte a mesma carteira Solana. A mesma carteira gera o mesmo Passport, com o mesmo endereço FLOP e a mesma sequência. Não há palavras para anotar.",
    "Is this FLOP money real?" to
        "Esse dinheiro em FLOP é de verdade?",
    "It gets 25 devnet FLOP from FLOP's faucet every 24 hours." to
        "Ele recebe 25 FLOP da devnet do faucet da FLOP a cada 24 horas.",
    "It needs at least 1 FLOP on your Passport address first. On devnet each account also gets only one trial: 25 FLOP for 24 hours. After that it stays closed until testnet. The Ask tab says which one it is." to
        "Primeiro é preciso ter pelo menos 1 FLOP no endereço do seu Passport. Na devnet, cada conta também tem só um teste: 25 FLOP por 24 horas. Depois disso ele fica fechado até a testnet. A aba Perguntar diz qual dos dois casos é.",
    "Its FLOP has no value. What you practise here is what testnet will count." to
        "O FLOP dela não tem valor. O que você treina aqui é o que a testnet vai contar.",
    "Name three things to check before signing anything in a crypto wallet." to
        "Cite três coisas para conferir antes de assinar qualquer coisa numa carteira cripto.",
    "Name three uses of AI that run well on small models." to
        "Cite três usos de IA que funcionam bem em modelos pequenos.",
    "No, and it would not help. FLOP counts spending, not accounts, and says extra accounts earn nothing. One person, one Passport." to
        "Não, e não ajudaria. A FLOP conta o gasto, não as contas, e diz que contas extras não rendem nada. Uma pessoa, um Passport.",
    "No. Devnet FLOP is practice money with no value, and FLOP may wipe the devnet at any time. There is no FLOP token yet at all. Anybody selling FLOP today is a scammer." to
        "Não. O FLOP da devnet é dinheiro de treino sem valor, e a FLOP pode apagar a devnet a qualquer momento. Ainda não existe nenhum token FLOP. Quem vende FLOP hoje é golpista.",
    "No. Linking a post to your Passport is optional. It shows people the Passport is yours, nothing more." to
        "Não. Vincular uma publicação ao seu Passport é opcional. Isso mostra às pessoas que o Passport é seu, nada mais.",
    "Nobody can promise that, and this app never will. What FLOP says: on testnet, the testnet FLOP an agent spends on the model becomes its claim on mainnet FLOP. The app helps you do exactly that every day. Devnet, which is now, earns nothing." to
        "Ninguém pode prometer isso, e este app nunca vai prometer. O que a FLOP diz: na testnet, o FLOP da testnet que um agente gasta no modelo vira seu direito a FLOP da mainnet. O app ajuda você a fazer exatamente isso todo dia. A devnet, que é o que existe agora, não rende nada.",
    "Nothing new to write down. The same wallet brings it back on any phone." to
        "Nada novo para anotar. A mesma carteira o traz de volta em qualquer telefone.",
    "On devnet FLOP gives each account one allowance: 25 FLOP to spend on the model within 24 hours, and needs at least 1 FLOP on the account to start it. When it is over, it stays over until testnet." to
        "Na devnet, a FLOP dá a cada conta uma cota: 25 FLOP para gastar no modelo em 24 horas, e é preciso ter pelo menos 1 FLOP na conta para começar. Quando acaba, continua encerrada até a testnet.",
    "One button signs today, takes today's FLOP and asks the model one question." to
        "Um botão assina o dia de hoje, pega o FLOP de hoje e faz uma pergunta ao modelo.",
    "One press does all three, in order. Whatever is already done is skipped." to
        "Um toque faz as três coisas, em ordem. O que já estiver feito é pulado.",
    "One question, paid in FLOP. Spending on the model is what testnet will count." to
        "Uma pergunta, paga em FLOP. Gastar no modelo é o que a testnet vai contar.",
    "One short text to sign. It is not a transaction and moves no money. Your wallet keeps its keys; nothing leaves it but that one signature." to
        "Um texto curto para assinar. Não é uma transação e não movimenta dinheiro. Sua carteira guarda as próprias chaves; nada sai dela além dessa assinatura.",
    "Only text, never a transaction. Once, to create your Passport. After that the Passport signs on its own: your daily record and the model's entry statement. None of it can move money from your wallet." to
        "Só texto, nunca uma transação. Uma vez, para criar seu Passport. Depois disso o Passport assina sozinho: seu registro diário e a declaração de entrada do modelo. Nada disso pode movimentar dinheiro da sua carteira.",
    "Open the app and press do my day. It signs today, takes today's FLOP from the faucet and asks the model one question. That is all. Whatever is already done is skipped." to
        "Abra o app e toque em completar meu dia. Ele assina o dia de hoje, pega o FLOP de hoje no faucet e faz uma pergunta ao modelo. Só isso. O que já estiver feito é pulado.",
    "Open the app and press do my day: it signs today, takes today's FLOP and asks the model one question." to
        "Abra o app e toque em completar meu dia: ele assina o dia de hoje, pega o FLOP de hoje e faz uma pergunta ao modelo.",
    "Paste a FLOP address from SubWallet, Talisman or Polkadot.js. The faucet will send there. The model still uses your Passport's own address, because only your Passport can sign for it." to
        "Cole um endereço FLOP do SubWallet, Talisman ou Polkadot.js. O faucet vai enviar para lá. O modelo continua usando o endereço próprio do seu Passport, porque só o seu Passport pode assinar por ele.",
    "Paste a full link, a handle like @name, or an address." to
        "Cole um link completo, um perfil como @name ou um endereço.",
    "Paste a link, an @handle or an address someone sent you." to
        "Cole um link, um @perfil ou um endereço que alguém enviou para você.",
    "Questions people ask" to
        "Perguntas que as pessoas fazem",
    "Reading your days from technocore.chat…" to
        "Lendo seus dias no technocore.chat…",
    "Same Passport, same days. And now one missed day a week is forgiven." to
        "Mesmo Passport, mesmos dias. E agora um dia perdido por semana é perdoado.",
    "Sign today" to
        "Assinar hoje",
    "Sign today to start your streak." to
        "Assine hoje para começar sua sequência.",
    "Sign today's record" to
        "Assine o registro de hoje",
    "Sign today, or the streak ends. Yesterday was already forgiven." to
        "Assine hoje ou a sequência termina. Ontem já foi perdoado.",
    "Signing the gateway's statement with your Passport…" to
        "Assinando a declaração do gateway com seu Passport…",
    "Since 3 November FLOP's practice network is open to everyone. Devnet FLOP has no value, earns nothing, and the network may be reset at any time." to
        "Desde 3 de novembro a rede de treino da FLOP está aberta a todos. O FLOP da devnet não tem valor, não rende nada, e a rede pode ser reiniciada a qualquer momento.",
    "Staying safe" to
        "Como se proteger",
    "Suggest a five-minute stretch for someone who sits all day." to
        "Sugira um alongamento de cinco minutos para quem fica sentado o dia todo.",
    "Summarise what 'proof of work' means in two sentences." to
        "Resuma o que significa 'prova de trabalho' em duas frases.",
    "Take today's FLOP" to
        "Pegue o FLOP de hoje",
    "Tell me one interesting fact about the history of computers." to
        "Me conte um fato curioso sobre a história dos computadores.",
    "Testnet and the airdrop" to
        "A testnet e o airdrop",
    "Testnet: no date yet" to
        "Testnet: ainda sem data",
    "That is not a FLOP address. It should start with 5 and be 47 or 48 characters; copy it again from your wallet." to
        "Isso não é um endereço FLOP. Ele deve começar com 5 e ter 47 ou 48 caracteres; copie de novo da sua carteira.",
    "The faucet" to
        "O faucet",
    "The faucet did not answer." to
        "O faucet não respondeu.",
    "The faucet is down for everyone" to
        "O faucet está fora do ar para todos",
    "The faucet sends to an address you chose instead:" to
        "Em vez disso, o faucet envia para um endereço que você escolheu:",
    "The faucet works for you" to
        "O faucet funciona para você",
    "The model did not answer." to
        "O modelo não respondeu.",
    "The model is busy. Try again in a minute; nothing was spent." to
        "O modelo está ocupado. Tente de novo em um minuto; nada foi gasto.",
    "The model is closed for this account" to
        "O modelo está fechado para esta conta",
    "The model is thinking…" to
        "O modelo está pensando…",
    "The model needs at least 1 FLOP on your Passport address first. Get it from the faucet." to
        "O modelo precisa primeiro de pelo menos 1 FLOP no endereço do seu Passport. Pegue no faucet.",
    "The model: one trial per account" to
        "O modelo: um teste por conta",
    "The real token. There is no FLOP token before this, so anything sold or “claimed” as FLOP today is a scam." to
        "O token real. Não existe token FLOP antes disso, então qualquer coisa vendida ou “resgatada” como FLOP hoje é golpe.",
    "There is no FLOP token yet, so there is no FLOP contract address. Anything offered as one is not FLOP." to
        "Ainda não existe token FLOP, então não há endereço de contrato da FLOP. Qualquer coisa oferecida como tal não é a FLOP.",
    "There is no FLOP token yet. Nobody, including this app's author, will ever ask for your private key or your wallet's words. Your wallet only ever signs text here, never a transaction. If somebody sends you a FLOP link, check it on the Network tab first." to
        "Ainda não existe token FLOP. Ninguém, nem mesmo o autor deste app, vai pedir sua chave privada ou as palavras da sua carteira. Aqui sua carteira só assina texto, nunca uma transação. Se alguém enviar um link da FLOP, confira primeiro na aba Rede.",
    "There is no Passport on this phone." to
        "Não há nenhum Passport neste telefone.",
    "This account has used its one devnet allowance. FLOP does not renew it on devnet. The model opens again when testnet starts, and on testnet the FLOP you spend here is what counts." to
        "Esta conta já usou sua única cota da devnet. A FLOP não a renova na devnet. O modelo abre de novo quando a testnet começar, e na testnet o que conta é o FLOP que você gastar aqui.",
    "This account's devnet allowance is used up." to
        "A cota da devnet desta conta acabou.",
    "This address already got its FLOP in the last 24 hours." to
        "Este endereço já recebeu seu FLOP nas últimas 24 horas.",
    "This app's source code" to
        "Código-fonte deste app",
    "This is an account on FLOP Network. An address alone says nothing about who holds it." to
        "Esta é uma conta na FLOP Network. Um endereço sozinho não diz nada sobre quem o controla.",
    "To use the model, your Passport signs a short statement from api.flop.network. That signature moves nothing. FLOP then opens an allowance for your account: on devnet that is 25 FLOP for 24 hours, once per account, and your account needs at least 1 FLOP to start it. An answer costs about 0.006 FLOP per word-piece, usually one or two FLOP. When the allowance ends, the model stays closed for that account until testnet." to
        "Para usar o modelo, seu Passport assina uma declaração curta de api.flop.network. Essa assinatura não movimenta nada. Depois a FLOP abre uma cota para sua conta: na devnet são 25 FLOP por 24 horas, uma vez por conta, e sua conta precisa de pelo menos 1 FLOP para começar. Uma resposta custa cerca de 0,006 FLOP por pedaço de palavra, normalmente um ou dois FLOP. Quando a cota acaba, o modelo fica fechado para essa conta até a testnet.",
    "Today is not signed yet" to
        "Hoje ainda não foi assinado",
    "Today is not signed yet." to
        "Hoje ainda não foi assinado.",
    "Today is signed. Come back tomorrow." to
        "Hoje já foi assinado. Volte amanhã.",
    "Today is signed. See you tomorrow." to
        "Hoje já foi assinado. Até amanhã.",
    "Too many tries from this network. Wait a minute and try again." to
        "Tentativas demais a partir desta rede. Espere um minuto e tente de novo.",
    "Type a question" to
        "Digite uma pergunta",
    "What FLOP is" to
        "O que é a FLOP",
    "What FLOP says: on testnet, testnet FLOP that an agent actually spends on inference becomes its claim on mainnet FLOP. That claim is locked, and unlocks as it is spent on inference on mainnet: three spent unlock one. Holding FLOP earns nothing. Making more accounts earns nothing. Posting your identity earns nothing." to
        "O que a FLOP diz: na testnet, o FLOP da testnet que um agente realmente gasta em inferência vira seu direito a FLOP da mainnet. Esse direito fica bloqueado e é desbloqueado conforme é gasto em inferência na mainnet: três gastos desbloqueiam um. Ter FLOP não rende nada. Criar mais contas não rende nada. Publicar sua identidade não rende nada.",
    "What do I need to do every day?" to
        "O que eu preciso fazer todo dia?",
    "What does a miner do in a compute network?" to
        "O que um minerador faz numa rede de computação?",
    "What exactly does my wallet sign?" to
        "O que exatamente minha carteira assina?",
    "What is a hash function? Two sentences." to
        "O que é uma função hash? Em duas frases.",
    "What is a token in the context of language models?" to
        "O que é um token no contexto de modelos de linguagem?",
    "What is a validator in a blockchain network? Keep it short." to
        "O que é um validador numa rede blockchain? Seja breve.",
    "What is an AI agent, in one paragraph?" to
        "O que é um agente de IA, em um parágrafo?",
    "What is latency, and why do people care about it?" to
        "O que é latência e por que as pessoas se importam com ela?",
    "What is phishing, and how do you spot it? Three signs." to
        "O que é phishing e como reconhecer? Três sinais.",
    "What is the cloud, really? Two sentences." to
        "O que é a nuvem, de verdade? Em duas frases.",
    "What is the difference between a private key and a public key?" to
        "Qual é a diferença entre uma chave privada e uma chave pública?",
    "What makes a password strong? Three short points." to
        "O que torna uma senha forte? Três pontos curtos.",
    "What this app is" to
        "O que é este app",
    "What we say: this app promises nothing about any allocation, and never will. It helps you do, every day, the thing FLOP says it counts. One person, one Passport." to
        "O que nós dizemos: este app não promete nenhuma alocação, e nunca vai prometer. Ele ajuda você a fazer, todo dia, aquilo que a FLOP diz que conta. Uma pessoa, um Passport.",
    "When does testnet start?" to
        "Quando começa a testnet?",
    "Where FLOP is now" to
        "Onde a FLOP está agora",
    "Where these facts come from" to
        "De onde vêm estes fatos",
    "Who made this app?" to
        "Quem fez este app?",
    "Why did my streak go back to zero?" to
        "Por que minha sequência voltou a zero?",
    "Why do computers use binary? Two sentences." to
        "Por que os computadores usam binário? Em duas frases.",
    "Why does the model not answer me?" to
        "Por que o modelo não me responde?",
    "Why is my balance 0?" to
        "Por que meu saldo está em 0?",
    "Will I get FLOP tokens for this?" to
        "Vou ganhar tokens FLOP por isso?",
    "Write a haiku about a phone that never sleeps." to
        "Escreva um haicai sobre um celular que nunca dorme.",
    "You are a small model running on FLOP Network's devnet, answering inside a phone app. Answer briefly and plainly. Answer in the language the user writes in." to
        "Você é um modelo pequeno rodando na devnet da FLOP Network, respondendo dentro de um app de celular. Responda de forma breve e simples. Responda no idioma em que o usuário escreve.",
    "You never need this to recover: your wallet rebuilds the Passport. It is here for people who want to use their identity away from this phone. Nobody, including this app's author, will ever ask you for it." to
        "Você nunca precisa disto para recuperar: sua carteira reconstrói o Passport. Está aqui para quem quer usar a identidade fora deste telefone. Ninguém, nem mesmo o autor deste app, vai pedir isso a você.",
    "Your FLOP address" to
        "Seu endereço FLOP",
    "Your FLOP comes from FLOP's faucet, and right now the faucet is not giving FLOP to anyone. That is FLOP's problem, not your phone. When it works, press do my day and 25 FLOP arrives within a minute." to
        "Seu FLOP vem do faucet da FLOP, e agora o faucet não está dando FLOP para ninguém. O problema é da FLOP, não do seu telefone. Quando ele funcionar, toque em completar meu dia e 25 FLOP chegam em menos de um minuto.",
    "Your Passport is a FLOP account" to
        "Seu Passport é uma conta FLOP",
    "Your Passport is also a FLOP address. FLOP's faucet gives it 25 FLOP every 24 hours." to
        "Seu Passport também é um endereço FLOP. O faucet da FLOP dá a ele 25 FLOP a cada 24 horas.",
    "Your Passport key is also an account on FLOP Network. Same key, written the way FLOP writes addresses." to
        "A chave do seu Passport também é uma conta na FLOP Network. A mesma chave, escrita do jeito que a FLOP escreve endereços.",
    "Your Passport key is also your FLOP account. It is the same key, written the way FLOP writes addresses, so there is nothing new to back up: your Solana wallet rebuilds both on any phone. If you already have a FLOP address in SubWallet, Talisman or Polkadot.js, you can send the faucet there instead, on the Passport tab. The model works only with the Passport's own address, because only the Passport can sign for it." to
        "A chave do seu Passport também é a sua conta FLOP. É a mesma chave, escrita do jeito que a FLOP escreve endereços, então não há nada novo para guardar em backup: sua carteira Solana reconstrói as duas em qualquer telefone. Se você já tem um endereço FLOP no SubWallet, Talisman ou Polkadot.js, pode fazer o faucet enviar para lá, na aba Passport. O modelo só funciona com o endereço próprio do Passport, porque só o Passport pode assinar por ele.",
    "Your Passport now lives on FLOP" to
        "Seu Passport agora vive na FLOP",
    "Your Passport signs one line in public. It adds a day to your streak." to
        "Seu Passport assina uma linha em público. Isso soma um dia à sua sequência.",
    "Your Passport signs one short line in a public room on technocore.chat, and the app reads it back to prove it landed. Each signed day adds to your streak. Miss one day and it is forgiven, once a week. Miss two in a row and the streak starts again." to
        "Seu Passport assina uma linha curta numa sala pública do technocore.chat, e o app a lê de volta para provar que chegou. Cada dia assinado soma à sua sequência. Se você perder um dia, ele é perdoado, uma vez por semana. Se perder dois seguidos, a sequência recomeça.",
    "Your address got its FLOP from the faucet in the last 24 hours. It can ask again 24 hours after the last grant." to
        "Seu endereço recebeu FLOP do faucet nas últimas 24 horas. Ele pode pedir de novo 24 horas depois da última entrega.",
    "Your day is done." to
        "Seu dia está completo.",
    "Your day on FLOP, from your Seeker." to
        "Seu dia na FLOP, direto do seu Seeker.",
    "Your day, step by step" to
        "Seu dia, passo a passo",
    "Your first question opens it. Your Passport signs a short statement from api.flop.network; nothing else is signed and nothing moves. You need at least 1 FLOP on your Passport's address, which the faucet on Today gives you." to
        "Sua primeira pergunta abre a cota. Seu Passport assina uma declaração curta de api.flop.network; nada mais é assinado e nada se move. Você precisa de pelo menos 1 FLOP no endereço do seu Passport, que o faucet em Hoje dá para você.",
    "Your identity note was deleted after seven quiet days. Publish it again to keep signing your days. Your streak is not lost." to
        "Sua nota de identidade foi excluída depois de sete dias sem atividade. Publique de novo para continuar assinando seus dias. Sua sequência não se perdeu.",
    "Your one devnet trial of the model is over. It opens again on testnet." to
        "Seu único teste do modelo na devnet acabou. Ele abre de novo na testnet.",
    "Your streak came with you" to
        "Sua sequência veio junto",
    "Your wallet made this key and rebuilds it on any phone. There are no words to write down." to
        "Sua carteira criou esta chave e a reconstrói em qualquer telefone. Não há palavras para anotar.",
    "Your {n}-day streak ends at midnight" to
        "Sua sequência de {n} dias termina à meia-noite",
    "accounts" to
        "contas",
    "active agents" to
        "agentes ativos",
    "all my records" to
        "todos os meus registros",
    "allowance left" to
        "cota restante",
    "already asked today" to
        "já perguntado hoje",
    "already signed today" to
        "já assinado hoje",
    "already taken today" to
        "já recebido hoje",
    "answered" to
        "respondido",
    "ask the model something else" to
        "perguntar outra coisa ao modelo",
    "back" to
        "voltar",
    "balance" to
        "saldo",
    "balance {n} FLOP" to
        "saldo {n} FLOP",
    "change the address" to
        "alterar o endereço",
    "closes in" to
        "fecha em",
    "compute market and FRCR index" to
        "mercado de computação e índice FRCR",
    "copied" to
        "copiado",
    "cost {n} FLOP" to
        "custou {n} FLOP",
    "day in a row" to
        "dia seguido",
    "days in a row" to
        "dias seguidos",
    "devnet flop" to
        "flop da devnet",
    "do my day" to
        "completar meu dia",
    "entering" to
        "entrando",
    "finish your passport first" to
        "termine seu passport primeiro",
    "flop gateway" to
        "gateway flop",
    "go back to my passport address" to
        "voltar ao endereço do meu passport",
    "got it" to
        "entendi",
    "how it all works" to
        "como tudo funciona",
    "how it works" to
        "como funciona",
    "how it works, questions and answers" to
        "como funciona, perguntas e respostas",
    "how the model works here" to
        "como o modelo funciona aqui",
    "is this really flop?" to
        "é mesmo a flop?",
    "just now" to
        "agora mesmo",
    "latest block" to
        "último bloco",
    "made by wallet" to
        "criada pela carteira",
    "model" to
        "modelo",
    "my day on flop" to
        "meu dia na flop",
    "needs flop" to
        "precisa de flop",
    "network" to
        "rede",
    "new in 2.0" to
        "novidades da 2.0",
    "news" to
        "notícias",
    "no date yet" to
        "ainda sem data",
    "not entered" to
        "não entrou",
    "not flop" to
        "não é a flop",
    "not flop's" to
        "não é da flop",
    "not now" to
        "agora não",
    "official" to
        "oficial",
    "official channels" to
        "canais oficiais",
    "open in FLOP's explorer" to
        "abrir no explorador da FLOP",
    "private key" to
        "chave privada",
    "publish again" to
        "publicar de novo",
    "read it in FLOP's own words" to
        "leia nas palavras da própria FLOP",
    "reading" to
        "lendo",
    "refresh" to
        "atualizar",
    "refused" to
        "recusado",
    "save" to
        "salvar",
    "scam warning" to
        "alerta de golpe",
    "send" to
        "enviar",
    "settings, language, about" to
        "configurações, idioma, sobre",
    "signed and read back" to
        "assinado e lido de volta",
    "spent on the model, as FLOP's explorer sees it" to
        "gasto no modelo, segundo o explorador da FLOP",
    "start" to
        "começar",
    "the proof" to
        "a prova",
    "to do" to
        "pendente",
    "today" to
        "hoje",
    "today's question: {q}" to
        "pergunta de hoje: {q}",
    "trial over" to
        "teste encerrado",
    "use an address I already have" to
        "usar um endereço que já tenho",
    "validators" to
        "validadores",
    "what is happening now" to
        "o que está acontecendo agora",
    "what your wallet will show" to
        "o que sua carteira vai mostrar",
    "where flop stands" to
        "onde a flop está",
    "your flop address" to
        "seu endereço flop",
    "{day} was missed and forgiven: one missed day a week is." to
        "{day} foi perdido e perdoado: um dia perdido por semana é perdoado.",
    "{n} d ago" to
        "há {n} d",
    "{n} h ago" to
        "há {n} h",
    "{n} min ago" to
        "há {n} min",
    "Today" to "Hoje",
    "Ask" to "Perguntar",
    "Network" to "Rede",
    "{host} is on FLOP's official list." to "{host} está na lista oficial da FLOP.",
    "This is FLOP's own account on {host}." to "Esta é a conta da própria FLOP em {host}.",
    "This is on {host}, but not FLOP's account there. FLOP's is {account}." to "Isto é {host}, mas não é a conta da FLOP lá. A da FLOP é {account}.",
    "{host} uses the FLOP name but is not on FLOP's official list. Treat it as an impersonation." to "{host} usa o nome FLOP, mas não está na lista oficial da FLOP. Trate como uma imitação.",
    "{host} is not FLOP. That does not make it bad, only not FLOP." to "{host} não é a FLOP. Isso não o torna ruim, só não é a FLOP.",
    // The faucet came back (2026-11-03).
    "The faucet works" to
        "O faucet funciona",
    "FLOP's faucet gives each address 25 FLOP once every 24 hours. It can be slow: an answer may take a minute or two. The app waits for it and checks your balance." to
        "O faucet da FLOP dá a cada endereço 25 FLOP uma vez a cada 24 horas. Pode ser lento: uma resposta pode levar um ou dois minutos. O app espera por ela e confere seu saldo.",
    "Your FLOP comes from FLOP's faucet: 25 FLOP once every 24 hours. Press do my day and wait, the faucet can take a minute or two. If the balance stays 0, the faucet step says why." to
        "Seus FLOP vêm do faucet da FLOP: 25 FLOP uma vez a cada 24 horas. Toque em “completar meu dia” e espere, o faucet pode levar um ou dois minutos. Se o saldo continuar 0, o passo do faucet diz por quê.",
    // Review fixes before the 2.0 release (2026-11-03).
    "The faucet is limiting requests from your network right now. Nothing arrived; try again later." to
        "O faucet está limitando pedidos da sua rede agora. Nada chegou; tente mais tarde.",
    "FLOP's gateway sent a sign-in text this app does not recognise, so it was not signed. Nothing happened." to
        "O gateway da FLOP enviou um texto de acesso que este app não reconhece, então ele não foi assinado. Nada aconteceu.",
    "The faucet said no: {reason}" to
        "O faucet recusou: {reason}",
    "The gateway said no: {reason}" to
        "O gateway recusou: {reason}",
    "The model did not answer: {reason}" to
        "O modelo não respondeu: {reason}",
    "Only https links can be FLOP's. Type FLOP's address yourself instead of following this one." to
        "Só links https podem ser da FLOP. Digite você mesmo o endereço da FLOP em vez de seguir este link.",
    "Sign today to keep your streak. This week's one forgiven day is already used." to
        "Assine hoje para manter sua sequência. O único dia perdoado desta semana já foi usado.",
    // The model allowance is what the gateway says, not a fixed number (2026-11-03).
    "On devnet FLOP gives each account one allowance to spend on the model within 24 hours, and needs at least 1 FLOP on the account to start it. The Ask tab shows how much is left. When it is over, it stays over until testnet." to
        "Na devnet a FLOP dá a cada conta uma cota para gastar no modelo durante 24 horas, e a conta precisa de pelo menos 1 FLOP para começar. A aba Perguntar mostra quanto resta. Quando acaba, fica assim até a testnet.",
    "FLOP gives each account one devnet allowance for 24 hours. The figure above is what is left of it. When it is over it is over until testnet." to
        "A FLOP dá a cada conta uma cota de devnet por 24 horas. O número acima é o que resta dela. Quando acaba, fica assim até a testnet.",
    "It needs at least 1 FLOP on your Passport address first. On devnet each account also gets only one trial, for 24 hours. After that it stays closed until testnet. The Ask tab says which one it is." to
        "Primeiro o endereço do seu Passport precisa de pelo menos 1 FLOP. Além disso, na devnet cada conta tem só uma tentativa, por 24 horas. Depois fica fechado até a testnet. A aba Perguntar diz qual dos dois é.",
    "To use the model, your Passport signs a short statement from api.flop.network. That signature moves nothing. FLOP then opens an allowance for your account: on devnet one, for 24 hours, and your account needs at least 1 FLOP to start it. The Ask tab shows how much of it is left. An answer costs about 0.006 FLOP per word-piece, usually one or two FLOP. When the allowance ends, the model stays closed for that account until testnet." to
        "Para usar o modelo, seu Passport assina uma declaração curta de api.flop.network. Essa assinatura não move nada. Então a FLOP abre uma cota para sua conta: na devnet uma, por 24 horas, e sua conta precisa de pelo menos 1 FLOP para começar. A aba Perguntar mostra quanto resta. Uma resposta custa cerca de 0,006 FLOP por pedaço de palavra, geralmente um ou dois FLOP. Quando a cota termina, o modelo fica fechado para essa conta até a testnet.",
    // The faucet's two other refusals, seen 3-4 November 2026.
    "The faucet has your request in its queue and has not sent the FLOP yet. This can take a while. Press do my day again later." to
        "Seu pedido está na fila do faucet e os FLOP ainda não foram enviados. Pode demorar. Toque em “completar meu dia” de novo mais tarde.",
    "The faucet has given out all of today's FLOP. Nothing arrived. It opens again within hours, so try later." to
        "O faucet já distribuiu todos os FLOP de hoje. Nada chegou. Ele reabre em algumas horas, tente mais tarde.",
    "Signing today's line with your Passport and reading it back from technocore.chat…" to
        "Assinando a linha de hoje com seu Passport e lendo de volta no technocore.chat…",
    "Asking FLOP's faucet. It serves about 10 people a minute, so this can take up to 2 minutes." to
        "Pedindo ao faucet da FLOP. Ele atende cerca de 10 pessoas por minuto, então pode levar até 2 minutos.",
    "You are in the faucet's queue. The app watches your balance and asks again by itself." to
        "Você está na fila do faucet. O app acompanha seu saldo e pede de novo sozinho.",
    "Reading your balance…" to
        "Lendo seu saldo…",
    "Sending your question to the model. It has up to 90 seconds to answer." to
        "Enviando sua pergunta ao modelo. Ele tem até 90 segundos para responder.",
    "FLOP's gateway is full right now: many people are asking at once. Nothing was spent. The app tries again by itself." to
        "O gateway da FLOP está cheio agora: muita gente perguntando ao mesmo tempo. Nada foi gasto. O app tenta de novo sozinho.",
    "Your FLOP is still settling on the network. The app tries again by itself." to
        "Seus FLOP ainda estão sendo confirmados na rede. O app tenta de novo sozinho.",
    "Reading what the answer cost…" to
        "Lendo quanto custou a resposta…",
    "FLOP's gateway stayed full through every try. Nothing was spent. Try again in a few minutes." to
        "O gateway da FLOP continuou cheio em todas as tentativas. Nada foi gasto. Tente de novo em alguns minutos.",
    "{n} s so far" to
        "{n} s até agora",
    "try {n} of {m}" to
        "tentativa {n} de {m}",
    "next try in {n} s" to
        "próxima tentativa em {n} s",
    "gateway ping {n} ms" to
        "ping do gateway {n} ms",
    "faucet ping {n} ms" to
        "ping do faucet {n} ms",
    "the gateway does not answer a ping" to
        "o gateway não responde ao ping",
    "the faucet does not answer a ping" to
        "o faucet não responde ao ping",
    "step {n} of 3" to
        "etapa {n} de 3",
    "ping" to
        "ping",
    "no answer" to
        "sem resposta",
    "last answer took" to
        "a última resposta levou",
    "You can leave this screen: it keeps going." to
        "Você pode sair desta tela: continua funcionando.",
    "Signing today's line" to
        "Assinando a linha de hoje",
    "Your Passport signs one short line in the public room and reads it back. That line is your day." to
        "Seu Passport assina uma linha curta na sala pública e a lê de volta. Essa linha é o seu dia.",
    "Asking FLOP's faucet" to
        "Pedindo ao faucet da FLOP",
    "The faucet pays about 10 people a minute. This can take up to two minutes." to
        "O faucet atende cerca de 10 pessoas por minuto. Pode levar até dois minutos.",
    "Standing in the faucet's queue" to
        "Na fila do faucet",
    "The faucet pays about 10 people a minute. Your request is in. We watch your balance and ask again by ourselves." to
        "O faucet atende cerca de 10 pessoas por minuto. Seu pedido já entrou. Acompanhamos seu saldo e pedimos de novo por conta própria.",
    "Your FLOP is on its way" to
        "Seu FLOP está a caminho",
    "One moment." to
        "Um momento.",
    "Opening the model" to
        "Abrindo o modelo",
    "Your Passport signs the gateway's statement. Nothing is spent." to
        "Seu Passport assina a declaração do gateway. Nada é gasto.",
    "Asking the model" to
        "Perguntando ao modelo",
    "Your question is with the model. It has up to 90 seconds." to
        "Sua pergunta está com o modelo. Ele tem até 90 segundos.",
    "The model is full right now" to
        "O modelo está cheio agora",
    "Many people are asking at once. Nothing was spent. We try again by ourselves." to
        "Muita gente pergunta ao mesmo tempo. Nada foi gasto. Tentamos de novo por conta própria.",
    "Your FLOP is still settling" to
        "Seu FLOP ainda está assentando",
    "A fresh grant takes a moment to count. We try again by ourselves." to
        "Um crédito novo leva um instante para contar. Tentamos de novo por conta própria.",
    "Reading what it cost" to
        "Lendo quanto custou",
    "FLOP's gateway stayed full through all 6 tries. Nothing was spent. This is on FLOP's side, not yours." to
        "O gateway da FLOP ficou cheio nas 6 tentativas. Nada foi gasto. Isso é do lado da FLOP, não do seu.",
    "to next try" to
        "até a próxima tentativa",
    "elapsed {t}" to
        "decorrido {t}",
    "ask the model" to
        "perguntar ao modelo",
    "Answered" to
        "Respondido",
    "cost {c} FLOP · {s} s" to
        "custou {c} FLOP · {s} s",
    "The model did not answer" to
        "O modelo não respondeu",
    "your question" to
        "sua pergunta",
    "waiting" to
        "aguardando",
    "Connect your Passport" to
        "Conecte seu Passport",
    "Get the answer" to
        "Obter a resposta",
    "minimise · it keeps going" to
        "minimizar · continua em andamento",
    "my day · step {n} of 3" to
        "meu dia · passo {n} de 3",
    "my day" to
        "meu dia",
    "Your day is closed" to
        "Seu dia está fechado",
    "See you tomorrow." to
        "Até amanhã.",
    "Today is signed" to
        "Hoje está assinado",
    "not today" to
        "hoje não",
    "Could not sign today" to
        "Não foi possível assinar hoje",
    "Your day is signed. Your streak of {n} is safe whatever happens next." to
        "Seu dia está assinado. Sua sequência de {n} está segura, aconteça o que acontecer.",
    "Today is not signed yet. One missed day a week is forgiven; two in a row end the streak." to
        "Hoje ainda não está assinado. Um dia perdido por semana é perdoado; dois seguidos encerram a sequência.",
    "question of the day: {q}" to
        "pergunta do dia: {q}",
    "Part of your day waits" to
        "Parte do seu dia espera",
    "passport · {name}" to
        "passport · {name}",
    "Days in a row: {n}" to
        "Dias seguidos: {n}",
    "Start your streak today" to
        "Comece sua sequência hoje",
    "Registered {date} · day {n} with us" to
        "Registrado em {date} · dia {n} conosco",
    "reading your days" to
        "lendo seus dias",
    "today signed" to
        "hoje assinado",
    "sign today or the streak ends" to
        "assine hoje ou a sequência acaba",
    "today not signed yet" to
        "hoje ainda sem assinar",
    "in a row" to
        "seguidos",
    "{n} of 3" to
        "{n} de 3",
    "Your Passport signs one public line. That line is your streak." to
        "Seu Passport assina uma linha pública. Essa linha é a sua sequência.",
    "From FLOP's faucet, once a day. Practice coins, no price." to
        "Do faucet da FLOP, uma vez por dia. Moedas de prática, sem preço.",
    "One question of the day, paid in FLOP." to
        "Uma pergunta do dia, paga em FLOP.",
    "One press, all three steps in order. What is already done is skipped." to
        "Um toque, os três passos em ordem. O que já foi feito é pulado.",
    "devnet · practice network" to
        "devnet · rede de prática",
    "one key · two networks" to
        "uma chave · duas redes",
    "Seeker wallet" to
        "Carteira Seeker",
    "Made the Passport with one signature. Brings it back on any phone." to
        "Criou o Passport com uma assinatura. Traz de volta em qualquer telefone.",
    "FLOP account" to
        "Conta FLOP",
    "The same key as a FLOP address. The faucet pays here; the model is paid from here." to
        "A mesma chave como endereço FLOP. O faucet paga aqui; o modelo é pago daqui.",
    "Registered" to
        "Registrado",
    "Days in a row" to
        "Dias seguidos",
    "Best streak" to
        "Melhor sequência",
    "Signed days" to
        "Dias assinados",
    "Balance, FLOP" to
        "Saldo, FLOP",
    "Spent on the model, FLOP" to
        "Gasto no modelo, FLOP",
    "1 skip left this week" to
        "resta 1 perdão esta semana",
    "this week's skip is used" to
        "o perdão desta semana foi usado",
    "details and key" to
        "detalhes e chave",
    "On Seeker · in FLOP Network · an app by Alex Kosa, not FLOP Labs, not Solana Mobile" to
        "No Seeker · na rede FLOP · um app de Alex Kosa, não da FLOP Labs nem da Solana Mobile",
    "days signed together" to
        "dias assinados juntos",
    "flop pulse" to
        "pulso flop",
    "Devnet is a practice network, open to everyone since 3 November. Coins have no price, there is no reward." to
        "A devnet é uma rede de prática, aberta a todos desde 3 de novembro. As moedas não têm preço e não há recompensa.",
    "more about the network" to
        "mais sobre a rede",
    "thanks to both sides" to
        "obrigado aos dois lados",
    "for Seeker, the wallet and one-tap signing" to
        "pelo Seeker, a carteira e a assinatura com um toque",
    "for the network, the faucet and a model you can pay" to
        "pela rede, o faucet e um modelo que se pode pagar",
    "An independent app by Alex Kosa. No promises about tokens or rewards." to
        "Um app independente de Alex Kosa. Sem promessas sobre tokens ou recompensas.",
    "check a link, an @name or an address someone sent you" to
        "verifique um link, um @nome ou um endereço que alguém enviou",
    "check" to
        "verificar",
    "FLOP model" to
        "Modelo FLOP",
    "The model is small: short, plain questions work best. Everything you pay is practice FLOP." to
        "O modelo é pequeno: perguntas curtas e simples funcionam melhor. Tudo o que você paga é FLOP de prática.",
    "model open" to
        "modelo aberto",
    "opening the model" to
        "abrindo o modelo",
    "trial over for this account" to
        "teste encerrado para esta conta",
    "needs 1 flop" to
        "precisa de 1 flop",
    "model closed for now" to
        "modelo fechado por ora",
    "first question opens it" to
        "a primeira pergunta o abre",
    "ping {n} ms" to
        "ping {n} ms",
    "Your Passport signs a short statement from FLOP's gateway. Nothing moves. You need at least 1 FLOP; the faucet on Today gives you 25." to
        "Seu Passport assina uma breve declaração do gateway da FLOP. Nada se move. Você precisa de pelo menos 1 FLOP; o faucet em Hoje dá 25.",
    "more" to
        "mais",
    "That was the last step. Your Passport is live, and your day on FLOP starts now." to
        "Esse foi o último passo. Seu Passport está ativo e seu dia na FLOP começa agora.",
    "Pulse" to
        "Pulso",
    "Who is here, and how FLOP's network is doing today." to
        "Quem está aqui e como vai a rede FLOP hoje.",
    "who is here" to
        "quem está aqui",
    "Passport holders" to
        "titulares de Passport",
    "{n} Passport holders · {m} signed today" to
        "Titulares de Passport: {n} · assinaram hoje: {m}",
    "{n} of them signed today" to
        "deles assinaram hoje: {n}",
    "To keep a streak, each holder signs one short public line a day. Counted from that public record, so anyone can repeat it." to
        "Para manter a sequência, cada titular assina uma linha pública curta por dia. Contado a partir desse registro público, qualquer pessoa pode repetir.",
    "same key" to
        "mesma chave",
    "knock now" to
        "bater agora",
    "A refused knock costs nothing. Knock as often as you like." to
        "Uma recusa não custa nada. Bata quantas vezes quiser.",
    "FLOP spent on the model, all time" to
        "FLOP gasto no modelo, no total",
    "accounts that paid for the model" to
        "contas que pagaram o modelo",
    "Join FLOP with Alex's link" to
        "Entre na FLOP pelo link do Alex",
    "This is Alex Kosa's personal referral link from FLOP, and it may count for him. It gives you nothing extra from this app. Prefer not to? Go to flop.finance yourself." to
        "Este é o link de indicação pessoal de Alex Kosa da FLOP, e pode contar para ele. Este app não dá nada a mais por usá-lo. Prefere não usar? Vá você mesmo a flop.finance.",
    "open {host}" to
        "abrir {host}",
)
