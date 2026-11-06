package dev.alexkosa.floppassport.i18n

/**
 * Korean.
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
internal val KO_STRINGS: Map<String, String> = mapOf(
    "06  tell them" to "06  알려주기",
    "5 of 6" to "6단계 중 5단계",
    "A few more words, and it is yours. One real sentence is all this needs." to
        "몇 마디만 더 쓰면 됩니다. 진짜 문장 하나면 충분합니다.",
    "A few reminders about the last step, and then they stop." to "마지막 단계에 대한 몇 번의 알림, 그 뒤에는 멈춥니다.",
    "A little too long. Trim it and the whole post fits, key included." to
        "조금 깁니다. 줄이면 키까지 포함해 글 전체가 들어갑니다.",
    "A once-a-day reminder to leave today's signed record." to
        "오늘의 서명된 기록을 남기도록 하루에 한 번 알려 줍니다.",
    "A public note at an address derived from your key, so anyone can find and verify you later. This one goes to technocore.chat, which is someone else's public service: when it is busy it refuses, and pressing again is the answer. Two or three attempts is normal and means nothing is wrong with your phone." to
        "키에서 계산된 주소에 올리는 공개 노트입니다. 그래야 나중에 누구든 당신을 찾아 확인할 수 있습니다. 이 단계는 technocore.chat으로 갑니다. 남의 공용 서비스라 바쁠 때는 거절하며, 그럴 때의 답은 한 번 더 누르는 것입니다. 두세 번 시도는 정상이고, 휴대전화에는 아무 문제가 없다는 뜻입니다.",
    "A signed record has to be left by hand, and a missed day cannot be filled in later. This is also the switch that warns you before your identity note is deleted." to
        "서명된 기록은 직접 남겨야 하며, 놓친 날은 나중에 채울 수 없습니다. 이 설정을 켜면 신원 노트가 삭제되기 전에 알림도 받을 수 있습니다.",
    "A tip changes nothing about your Passport and nothing about any airdrop." to
        "후원금은 Passport나 에어드롭에 아무 영향도 주지 않습니다.",
    "A tip changes nothing about your Passport, and nothing about any airdrop. It is a thank you, not a fee." to
        "후원금은 Passport나 에어드롭에 아무 영향도 주지 않습니다. 수수료가 아니라 감사의 표시입니다.",
    "About" to "정보",
    "Accepted, but we could not read it back yet" to "수락됐지만 아직 다시 읽지 못했습니다",
    "Activity" to "활동",
    "All six done" to "여섯 단계 모두 완료",
    "Already checked in, found in the room" to "이미 서명 기록을 남겼으며 방에서 확인했습니다",
    "Already published, read back just now" to "이미 게시됐으며 방금 다시 읽었습니다",
    "Android is blocking notifications for this app. Turn them on in the system settings." to
        "Android가 이 앱의 알림을 차단하고 있습니다. 시스템 설정에서 알림을 켜세요.",
    "Anyone can check it at the address in step 03. This app promises nothing about any allocation, and never will." to
        "누구나 03단계의 주소에서 확인할 수 있습니다. 이 앱은 어떠한 할당도 약속하지 않으며 앞으로도 약속하지 않습니다.",
    "Anyone holding it can sign as you" to "이것을 가진 사람은 누구나 당신 명의로 서명할 수 있습니다",
    "Anyone holding seed_hex can sign as this identity on Technocore." to
        "seed_hex를 가진 사람은 누구나 Technocore에서 이 신원으로 서명할 수 있습니다.",
    "Anyone who looks it up sees a key and nothing else." to "찾아본 사람에게는 키 하나만 보이고 그 외에는 없습니다.",
    "Anyone with this can be you" to "이것을 가진 사람은 누구나 당신이 될 수 있습니다",
    "Apply" to "적용",
    "Cancel" to "취소",
    "Check in" to "서명 기록 남기기",
    "Check your connection and try again." to "연결을 확인하고 다시 시도하세요.",
    "Could not open the security prompt on this screen." to "이 화면에서 보안 확인 창을 열 수 없습니다.",
    "Could not reach technocore.chat" to "technocore.chat에 연결할 수 없습니다",
    "Could not reach technocore.chat. This says nothing about your records, only about the connection." to
        "technocore.chat에 연결할 수 없습니다. 이는 기록과 무관하며 연결 상태만을 나타냅니다.",
    "Could not reach the server." to "서버에 연결할 수 없습니다.",
    "Could not read the key back from secure storage" to "보안 키 저장소에서 키를 다시 읽을 수 없습니다",
    "Create" to "생성",
    "Create your Passport" to "Passport 생성",
    "Create your Passport first. There is nothing to show until something has been signed." to
        "먼저 Passport를 생성하세요. 서명된 항목이 생기기 전에는 표시할 내용이 없습니다.",
    "Daily activity" to "일일 활동",
    "Daily reminder" to "일일 알림",
    "Delete it?" to "삭제하시겠습니까?",
    "Deleting removes the Passport from this phone only. Anything already published may stay public, and the same wallet rebuilds the same identity - so this is not a way to undo anything." to
        "삭제하면 이 휴대전화에서만 Passport가 제거됩니다. 이미 게시된 내용은 계속 공개될 수 있으며, 같은 지갑으로 같은 신원을 다시 만들 수 있으므로 어떤 것도 되돌릴 수 없습니다.",
    "Did you post it?" to "게시하셨습니까?",
    "Every language listed here has a full translation." to "여기에 표시된 모든 언어는 전체 번역이 제공됩니다.",
    "FLOP Passport creates a Technocore identity from your Solana wallet and keeps the receipts." to
        "FLOP Passport는 Solana 지갑에서 Technocore 신원을 생성하고 확인 기록을 보관합니다.",
    "FLOP Passport for Seeker" to "Seeker용 FLOP Passport",
    "FLOP Passport for Seeker - private backup" to "Seeker용 FLOP Passport - 비공개 백업",
    "FLOP Passport for Seeker by @AlexKosa1" to "@AlexKosa1이 만든 Seeker용 FLOP Passport",
    "FLOP asked agents to do two things: create a unique key, and do something useful to spread the word about Technocore. The five steps above did the first. Nobody can do the second for you, so this writes the post and you decide whether to send it." to
        "FLOP은 에이전트에게 두 가지를 요청했습니다. 고유한 키를 만들고, Technocore를 알리는 데 도움이 되는 일을 하는 것입니다. 위의 다섯 단계에서 첫 번째 작업을 마쳤습니다. 두 번째 작업은 누구도 대신할 수 없으므로, 이 앱이 게시물을 작성하면 보낼지는 직접 결정하세요.",
    "Identity derived from your wallet signature" to "지갑 서명에서 파생된 신원",
    "If it does get deleted, your Passport is not gone: the same wallet still gives the same identity, and signing a record publishes the note back to the same address." to
        "노트가 삭제되더라도 Passport는 사라지지 않습니다. 같은 지갑에서는 여전히 같은 신원이 생성되며, 기록에 서명하면 같은 주소에 노트가 다시 게시됩니다.",
    "In one line: what you did, or why you set this up" to "한 줄로: 무엇을 했는지, 또는 왜 만들었는지",
    "It never asks for your wallet recovery phrase." to "지갑 복구 문구를 요청하지 않습니다.",
    "It promises nothing about any airdrop, and never will." to
        "어떠한 에어드롭도 약속하지 않으며 앞으로도 약속하지 않습니다.",
    "Keep this file offline. Never send it to anyone, including the app author." to
        "이 파일은 오프라인으로 보관하세요. 앱 제작자를 포함해 누구에게도 보내지 마세요.",
    "Language" to "언어",
    "Last reminder about this one." to "이 건에 대한 마지막 알림입니다.",
    "Make your first signed check-in" to "첫 번째 서명 기록 남기기",
    "Next: create your Passport from your wallet." to "다음: 지갑에서 Passport를 생성하세요.",
    "Next: make your first signed check-in." to "다음: 첫 번째 서명 기록을 남기세요.",
    "Next: publish your identity so anyone can verify you." to "다음: 누구나 검증할 수 있도록 신원을 게시하세요.",
    "Next: seal the key in this phone's secure storage." to "다음: 이 휴대전화의 보안 키 저장소에 키를 봉인하세요.",
    "No account, no server of ours, no analytics." to "계정도, 자체 서버도, 분석 기능도 없습니다.",
    "No wallet on this phone opened the payment link." to "이 휴대전화의 지갑에서 결제 링크를 열지 못했습니다.",
    "No. Nothing was published." to "아니요. 게시된 내용은 없습니다.",
    "Not checked yet." to "아직 확인하지 않았습니다.",
    "Not done. Your Passport is not attached to any public name yet, and this is the one step nobody can do for you." to
        "아직입니다. Passport는 아직 어떤 공개된 이름에도 연결되어 있지 않고, 이것은 아무도 대신해 줄 수 없는 단계입니다.",
    "Nothing asked yet" to "아직 요청한 내용이 없습니다",
    "Nothing found. If you signed something and it is not here, the room has been trimmed past it - which is normal, and exactly why this screen exists." to
        "찾은 내용이 없습니다. 서명한 항목이 여기에 없다면 방에서 오래된 기록이 정리된 것입니다. 이는 정상이며 바로 이 화면이 필요한 이유입니다.",
    "Nothing has vouched for this text yet. Publish again to sign for it." to
        "아직 이 텍스트를 보증한 것이 없습니다. 서명하려면 다시 게시하세요.",
    "Nothing is broken and nothing is lost. Your Passport works. When you want the public half of it, step 06 is waiting where you left it." to
        "고장난 것도, 잃어버린 것도 없습니다. Passport는 잘 작동합니다. 공개된 절반이 필요해지면 06단계가 그 자리에 그대로 있습니다.",
    "Nothing signed today yet." to "오늘은 아직 서명된 기록이 없습니다.",
    "One step left" to "한 단계 남았습니다",
    "Only languages with a real translation are listed. A picker offering languages that all render English would say your language is supported and then prove otherwise on the next screen." to
        "실제 번역이 있는 언어만 표시됩니다. 전부 영어로만 표시되는 언어까지 늘어놓은 선택기는 당신의 언어를 지원한다고 말해 놓고, 다음 화면에서 그렇지 않다는 것을 드러냅니다.",
    "Opening a connection" to "연결을 여는 중",
    "Opening your Solana wallet" to "Solana 지갑 여는 중",
    "Post your line, then come back and paste the link. That is what attaches your name to your key, and it is the half FLOP asked agents for." to
        "한 줄을 올리고, 돌아와서 링크를 붙여 넣으세요. 그것이 이름을 키에 붙여 주며, FLOP이 에이전트에게 요청한 절반입니다.",
    "Protect" to "보호",
    "Protect it" to "보호하기",
    "Publish" to "게시",
    "Publish your identity" to "신원 게시",
    "Published and read back from the server" to "게시 후 서버에서 다시 읽었습니다",
    "Published, read back, and vouched for by your key" to "게시하고 다시 읽었으며 키로 보증했습니다",
    "Publishing your identity note to technocore.chat" to "technocore.chat에 신원 노트 게시 중",
    "Publishing your note" to "노트를 게시하는 중",
    "Questions, answered in full" to "질문과 자세한 답변",
    "Read from technocore.chat just now, not from this phone. Rooms are trimmed as they grow, so this is what anyone would find today." to
        "이 휴대전화가 아니라 technocore.chat에서 방금 읽었습니다. 방은 커지면서 오래된 기록이 정리되므로, 현재 누구나 찾을 수 있는 내용은 이것입니다.",
    "Reading your note" to "노트를 읽는 중",
    "Reading your records" to "기록을 읽는 중",
    "Ready" to "준비됨",
    "Remind me once a day" to "하루에 한 번 알림",
    "Renewed today. technocore.chat keeps it for seven days after the last write, and this app rewrites it every time you open it." to
        "오늘 갱신되었습니다. technocore.chat은 마지막 작성 후 일주일 동안 노트를 보관하며, 이 앱은 열 때마다 노트를 다시 작성합니다.",
    "Sealed by Android Keystore" to "Android Keystore로 봉인됨",
    "Sealed by StrongBox, this phone's separate security chip" to
        "이 휴대전화의 별도 보안 칩인 StrongBox로 봉인됨",
    "Sealed by this phone's trusted execution environment" to "이 휴대전화의 신뢰 실행 환경으로 봉인됨",
    "Sealing the key in this device's secure storage" to "이 기기의 보안 키 저장소에 키 봉인 중",
    "Sending your signed record" to "서명된 기록을 전송하는 중",
    "Sent, but not confirmed in the room yet" to "전송됐지만 아직 방에서 확인되지 않았습니다",
    "Settings" to "설정",
    "Show your private key" to "개인 키 보기",
    "Signed, accepted and found again in the room" to "서명되고 수락됐으며 방에서 다시 확인했습니다",
    "Signing your first check-in and sending it" to "첫 기록에 서명하고 전송하는 중",
    "Somebody changed this note after your key signed for it. Publish again." to
        "키가 보증한 뒤에 누군가 이 노트를 변경했습니다. 다시 게시하세요.",
    "Still one step short" to "아직 한 단계가 모자랍니다",
    "Talking to the service" to "서비스와 통신하는 중",
    "Thanks for building this" to "제작자에게 감사 표시",
    "That does not look like a link to a post. It should look like https://x.com/you/status/123." to
        "게시물 링크처럼 보이지 않습니다. https://x.com/you/status/123 같은 형식이어야 합니다.",
    "The key is sealed in this phone's secure storage, then read back and checked against your identity." to
        "키는 이 휴대전화의 보안 키 저장소에 봉인된 뒤 다시 읽어 신원과 대조됩니다.",
    "The manual" to "사용 설명서",
    "The server is busy. Trying again." to "서버가 사용 중입니다. 다시 시도합니다.",
    "The stored key does not match your identity" to "저장된 키가 신원과 일치하지 않습니다",
    "The wallet did not complete the signature" to "지갑이 서명을 완료하지 않았습니다",
    "There are no points here and no score. FLOP asked agents to do something useful, so what counts is a record a person can still open. A number invented by this app would be a different game." to
        "여기에는 포인트도 점수도 없습니다. FLOP은 에이전트에게 유용한 일을 요청했으므로 중요한 것은 사람이 계속 열어 볼 수 있는 기록입니다. 이 앱이 임의로 만든 숫자는 다른 게임일 뿐입니다.",
    "These 32 bytes are your FLOP Passport itself. Whoever holds them can sign as you on Technocore. Keep them offline and never send them to anyone, including us." to
        "이 32바이트가 FLOP Passport 자체입니다. 이것을 가진 사람은 누구나 Technocore에서 당신 명의로 서명할 수 있습니다. 오프라인으로 보관하고 저희를 포함해 누구에게도 보내지 마세요.",
    "This app is free and open source, and nobody paid for it. If it saved you an afternoon, a tip is welcome." to
        "이 앱은 무료 오픈 소스이며 제작비를 지원한 곳은 없습니다. 이 앱으로 시간을 절약했다면 후원할 수 있습니다.",
    "This app is free and open source. If it was useful, you can send a tip to {name}. Your wallet opens and you choose the amount there." to
        "이 앱은 무료 오픈 소스입니다. 도움이 되었다면 {name}에게 후원금을 보낼 수 있습니다. 지갑이 열리고 금액은 거기에서 선택합니다.",
    "This app rewrites your note every time you open it and every time you sign a record, so the seven days start again. Open it at least once a week and nothing is ever lost." to
        "이 앱은 열 때마다, 그리고 기록에 서명할 때마다 노트를 다시 작성하므로 일주일이 다시 시작됩니다. 적어도 일주일에 한 번 앱을 열면 아무것도 사라지지 않습니다.",
    "This is NOT your Solana wallet key. Your wallet's own key never leaves Seed Vault and this app has never seen it. What you are looking at is a separate key that signs only on Technocore." to
        "이것은 Solana 지갑 키가 아닙니다. 지갑의 키는 Seed Vault를 벗어나지 않으며 이 앱은 해당 키를 본 적이 없습니다. 지금 보고 있는 것은 Technocore에서만 서명하는 별도의 키입니다.",
    "This line is what makes the post yours. Everything under it is the proof." to
        "이 한 줄이 이 글을 당신의 것으로 만듭니다. 그 아래는 전부 증거입니다.",
    "Three days left before it is deleted." to "삭제되기까지 사흘 남았습니다.",
    "Today cannot be added later" to "오늘은 나중에 채워 넣을 수 없습니다",
    "Told only when your identity note is days away from being deleted." to
        "신원 노트가 삭제되기 며칠 전일 때만 알려드립니다.",
    "Tomorrow is the last day." to "내일이 마지막 날입니다.",
    "Two days left before it is deleted." to "삭제되기까지 이틀 남았습니다.",
    "Unfinished setup" to "완료되지 않은 설정",
    "Use the phone's language" to "휴대전화의 언어 사용",
    "Wait a moment and press it again to re-check. Do not treat this as a failure." to
        "잠시 기다린 뒤 다시 눌러 확인하세요. 실패로 간주하지 마세요.",
    "Wait a moment and press it again to re-check. Sending it as a new message would post twice in public." to
        "잠시 기다린 뒤 다시 눌러 확인하세요. 새 메시지로 보내면 공개 기록이 두 번 게시됩니다.",
    "What is still provable" to "현재도 증명 가능한 항목",
    "What recovery without a seed phrase costs" to "시드 문구 없는 복구의 대가",
    "What to do and how often, why the identity expires, why this works on a Seeker, and what the catch is. Opens in your browser." to
        "무엇을 얼마나 자주 해야 하는지, 왜 신원이 만료되는지, 왜 Seeker에서 작동하는지, 주의할 점은 무엇인지 설명합니다. 브라우저에서 열립니다.",
    "Write one line only you would write. Posts that differ from each other by nothing but a key get read as farming, and that lands on the people who did the work." to
        "당신만 쓸 법한 한 줄을 쓰세요. 서로 키 하나만 다른 글들은 파밍으로 읽히고, 그 대가는 실제로 일한 사람들이 치릅니다.",
    "Yes. Something is already visible to others." to "예. 이미 다른 사람이 볼 수 있는 내용이 있습니다.",
    "You do not need this file to recover. The same Solana wallet that" to
        "복구에 이 파일은 필요하지 않습니다. 이 Passport를 생성한 동일한 Solana 지갑이",
    "You do not need this to recover. The same Solana wallet rebuilds the same Passport on any phone. This copy is for using the key somewhere else, on your own terms." to
        "복구에 이것은 필요하지 않습니다. 동일한 Solana 지갑으로 어느 휴대전화에서든 같은 Passport를 다시 만들 수 있습니다. 이 사본은 당신이 원하는 방식으로 다른 곳에서 키를 사용하기 위한 것입니다.",
    "You finished the five. The last one takes a minute." to "다섯 단계는 끝냈습니다. 마지막은 1분이면 됩니다.",
    "You have already checked in" to "이미 서명 기록을 남겼습니다",
    "You have already left a record today." to "오늘 이미 기록을 남겼습니다.",
    "You're all set" to "모든 설정이 완료됐습니다",
    "Your Passport has no name on it" to "Passport에는 이름이 없습니다",
    "Your Passport is derived from one signature your wallet makes inside Seed Vault, the Seeker's hardware key store. The wallet key never leaves that hardware. The Passport key is computed from its signature in this app and then sealed by Android's secure storage - sealed, not signed, in hardware, because Android Keystore cannot hold this kind of key." to
        "Passport는 Seeker의 하드웨어 키 저장소인 Seed Vault 안에서 지갑이 생성하는 하나의 서명에서 파생됩니다. 지갑 키는 해당 하드웨어를 벗어나지 않습니다. Passport 키는 이 앱에서 해당 서명으로 계산된 후 Android의 보안 저장소로 봉인됩니다. Android Keystore는 이런 종류의 키를 보관할 수 없으므로, 하드웨어에서 서명되는 것이 아니라 봉인됩니다.",
    "Your Passport is live" to "Passport가 활성화됐습니다",
    "Your Passport is live and your first signed record is on Technocore. Anyone can verify it, and it stays yours." to
        "Passport가 활성화됐으며 첫 번째 서명 기록이 Technocore에 있습니다. 누구나 검증할 수 있으며, 언제까지나 당신의 것입니다.",
    "Your Passport is live. One step left." to "Passport가 활성화됐습니다. 한 단계 남았습니다.",
    "Your Passport is rebuilt from one wallet signature, which is why no seed phrase exists to lose. The same fact cuts the other way: any app that persuades your wallet to sign that exact sentence can rebuild this Passport. Read what a wallet asks you to sign, here and everywhere else." to
        "Passport는 지갑 서명 하나로 다시 만들어집니다. 그래서 잃어버릴 시드 문구가 없습니다. 같은 사실이 반대로도 작용합니다. 지갑이 정확히 그 문장에 서명하도록 설득한 앱은 이 Passport를 다시 만들 수 있습니다. 지갑이 무엇에 서명하라고 요구하는지, 여기서도 다른 곳에서도 읽어 보세요.",
    "Your identity note expires soon" to "신원 노트가 곧 만료됩니다",
    "Your identity note has been deleted" to "신원 노트가 삭제되었습니다",
    "Your key is never sent anywhere. Only you can export it." to
        "키는 어디에도 전송되지 않습니다. 내보낼 수 있는 사람은 당신뿐입니다.",
    "Your key signed a line carrying this note's exact hash." to
        "키가 이 노트의 정확한 해시를 담은 줄에 서명했습니다.",
    "Your note has to be kept alive" to "노트를 유지해야 합니다",
    "Your post is in your identity note, at your key's own address." to
        "글은 당신 키의 주소에 있는 신원 노트 안에 있습니다.",
    "Your wallet signs one statement. It is not a transaction and moves no funds. The same wallet rebuilds the same Passport on any device." to
        "지갑은 하나의 문장에 서명합니다. 이는 거래가 아니며 자금을 이동하지 않습니다. 동일한 지갑으로 어느 기기에서든 같은 Passport를 다시 만들 수 있습니다.",
    "active days" to "활동 일수",
    "activity" to "활동",
    "address" to "주소",
    "algorithm: Ed25519, did:key, 32-byte seed" to "알고리즘: Ed25519, did:key, 32바이트 시드",
    "attach it" to "연결하기",
    "built by a community builder" to "커뮤니티 개발자가 제작",
    "cancel" to "취소",
    "change" to "변경",
    "changed" to "변경됨",
    "check again" to "다시 확인",
    "checked" to "확인됨",
    "close" to "닫기",
    "connection" to "연결",
    "content" to "내용",
    "continue" to "계속",
    "copy" to "복사",
    "copy key" to "키 복사",
    "create passport" to "Passport 생성",
    "created this Passport rebuilds it on any device." to
        "어느 기기에서든 같은 Passport를 다시 만들어 냅니다.",
    "danger zone" to "위험 구역",
    "day streak" to "연속 활동 일수",
    "delete passport from this phone" to "이 휴대전화에서 Passport 삭제",
    "detail" to "세부 정보",
    "did anything go public?" to "공개된 내용이 있습니까?",
    "done" to "완료",
    "failed" to "실패",
    "fetched again and matched exactly" to "다시 가져와 정확히 일치함",
    "fetched from the server on opening" to "열 때 서버에서 가져옴",
    "fingerprint" to "지문",
    "flop-passport vault self-test" to "flop-passport 키 저장소 자체 테스트",
    "identity" to "신원",
    "identity note" to "신원 노트",
    "language {code}" to "언어 {code}",
    "last connection" to "마지막 연결",
    "linked" to "연결됨",
    "live records" to "현재 공개 기록",
    "matched on our nonce, not just our key" to "키뿐 아니라 우리 논스도 일치함",
    "no thanks, continue" to "후원하지 않고 계속",
    "no, nothing was made public" to "아니요, 공개된 내용 없음",
    "nonce" to "논스",
    "not found" to "찾을 수 없음",
    "not yet" to "아직",
    "not yet - the note alone is a claim, not a proof" to "아직 아님 - 노트만으로는 주장일 뿐 증명이 아님",
    "off" to "끔",
    "on" to "켬",
    "open" to "열기",
    "our exact bytes, no wallet prefix" to "지갑 접두사 없이 정확한 원본 바이트",
    "passport for seeker" to "Seeker용 Passport",
    "pin it to your identity" to "신원에 고정",
    "private key, 32 bytes, hex" to "개인 키, 32바이트, 16진수",
    "protect passport" to "Passport 보호",
    "publish identity" to "신원 게시",
    "published" to "게시됨",
    "publishing" to "게시 중",
    "re-check with the server" to "서버에서 다시 확인",
    "re-checked when the app opened" to "앱을 열 때 다시 확인함",
    "records the server still holds" to "서버에 아직 남아 있는 기록",
    "recovery" to "복구",
    "room" to "방",
    "save to a file" to "파일로 저장",
    "say it another way" to "다르게 표현하기",
    "self test" to "자체 테스트",
    "send a tip" to "후원금 보내기",
    "send a tip in {token}" to "{token}(으)로 후원금 보내기",
    "send a tip to {name}" to "{name}에게 후원금 보내기",
    "sequence" to "순번",
    "settings" to "설정",
    "sign and check in" to "서명하고 기록 남기기",
    "sign today's record" to "오늘 기록에 서명",
    "signed" to "서명됨",
    "signed and verified against your DID" to "서명되고 DID와 대조해 검증됨",
    "step {n} {title} complete" to "{n}단계 {title} 완료",
    "step {n} {title} did not finish" to "{n}단계 {title} 완료되지 않음",
    "storage" to "저장소",
    "support the builder" to "개발자 후원",
    "technocore.chat answered" to "technocore.chat이 응답했습니다",
    "technocore.chat deletes anything nobody has written to for seven days. That includes the identity note at the address you save and share." to
        "technocore.chat은 일주일 동안 아무도 작성하지 않은 항목을 삭제합니다. 여기에는 저장하고 공유하는 주소의 신원 노트도 포함됩니다.",
    "technocore.chat refused the note" to "technocore.chat에서 노트를 거부함",
    "technocore.chat refused the signed write" to "technocore.chat에서 서명된 쓰기를 거부함",
    "text" to "텍스트",
    "the note changed between reads" to "두 번 읽는 사이에 노트가 바뀌었습니다",
    "the post" to "게시물",
    "the same wallet rebuilds this identity anywhere" to "동일한 지갑으로 어디서든 이 신원을 다시 생성",
    "try again" to "다시 시도",
    "unconfirmed" to "미확인",
    "unsigned" to "서명 없음",
    "verified" to "검증됨",
    "verify it yourself" to "직접 검증",
    "version" to "버전",
    "vouched for" to "보증됨",
    "wallet" to "지갑",
    "wallet linked" to "지갑 연결됨",
    "what this app never does" to "이 앱이 하지 않는 일",
    "what to do" to "해야 할 일",
    "when" to "시각",
    "working" to "처리 중",
    "yes, a signed did-note line carries its hash" to "예, 서명된 did-note 줄에 해시가 포함됨",
    "yes, delete" to "예, 삭제",
    "yes, something is already public" to "예, 이미 공개된 내용 있음",
    "your identity" to "당신의 신원",
    "your private key" to "당신의 개인 키",
    "{token} is preselected and you can switch it." to "{token}이(가) 미리 선택되어 있으며 변경할 수 있습니다.",
    "Try again. Nothing was sent anywhere." to
        "다시 시도하세요. 아무 데도 아무것도 보내지 않았습니다.",
    "Try again. technocore.chat is a public service and it refuses writes when it is busy, which has nothing to do with this app, your phone or your key. Two or three attempts is normal. Nothing was published." to
        "다시 시도하세요. technocore.chat은 공개 서비스이고 바쁠 때는 쓰기를 거부합니다. 이 앱이나 휴대전화, 키와는 상관없는 일입니다. 두세 번 시도하는 것은 정상입니다. 공개된 것은 없습니다.",
    "Try again. technocore.chat is a public service and it refuses writes when it is busy, which has nothing to do with this app, your phone or your key. Two or three attempts is normal. Nothing was posted." to
        "다시 시도하세요. technocore.chat은 공개 서비스이고 바쁠 때는 쓰기를 거부합니다. 이 앱이나 휴대전화, 키와는 상관없는 일입니다. 두세 번 시도하는 것은 정상입니다. 보낸 것은 없습니다.",
    "Could not reach technocore.chat. Check your connection and try again; nothing was lost." to
        "technocore.chat에 연결하지 못했습니다. 연결을 확인하고 다시 시도하세요. 잃어버린 것은 없습니다.",
    "The service took your record but has not shown it back yet. Press re-check in a moment; nothing needs signing again." to
        "서비스가 기록을 받았지만 아직 되돌려 보여 주지 않았습니다. 잠시 후 다시 확인을 누르세요. 다시 서명할 필요는 없습니다.",
    "technocore.chat refused the record. It refuses writes when it is busy - try again in a moment." to
        "technocore.chat이 기록을 거부했습니다. 바쁠 때는 쓰기를 거부합니다. 잠시 후 다시 시도하세요.",
    "technocore.chat did not take the change. It refuses writes when it is busy - press publish again in a moment. Your link is saved on this phone either way." to
        "technocore.chat이 변경을 받아들이지 않았습니다. 바쁠 때는 쓰기를 거부합니다. 잠시 후 게시를 다시 누르세요. 링크는 어느 쪽이든 이 휴대전화에 저장되어 있습니다.",
    "Not finished yet. Your Passport is not live until all five are green, and there is nothing complete for anyone to verify. Keep going." to
        "아직 끝나지 않았습니다. 다섯 가지가 모두 초록이 되기 전까지 Passport는 활성화되지 않고, 누군가 검증할 만한 완성된 것도 없습니다. 계속하세요.",
    "A message signed by your Passport, posted to a quiet room and then read back to prove it landed. Same service as step 03, same rule: if it refuses, press again. That is the service being busy, not a problem with your key." to
        "Passport로 서명한 메시지를 조용한 방에 올리고, 그것이 실제로 도착했음을 증명하기 위해 다시 읽어 옵니다. 03단계와 같은 서비스이고 규칙도 같습니다. 거부하면 다시 누르세요. 서비스가 바쁜 것이지 키에 문제가 있는 것이 아닙니다.",
    "Deleted after seven days with nothing written to it. Publish it now and it goes back to the same address." to
        "아무것도 쓰이지 않은 채 7일이 지나면 삭제됩니다. 지금 다시 공개하면 같은 주소로 돌아옵니다.",
    "Identity note at risk" to
        "신원 노트가 위험합니다",
    "In Settings, delete the Passport from this phone, then create it again from your wallet." to
        "설정에서 이 휴대전화의 Passport를 삭제한 뒤, 지갑으로 다시 만드세요.",
    "It is deleted after seven days with nothing written to it. Opening this app writes it." to
        "아무것도 쓰이지 않은 채 7일이 지나면 삭제됩니다. 이 앱을 여는 것 자체가 쓰기입니다.",
    "Maybe. The service accepted it, and this app could not read it back to be sure." to
        "그럴 수도 있습니다. 서비스는 받아들였지만, 이 앱이 다시 읽어 확인하지는 못했습니다.",
    "That was the last of the five. Your Passport is live. One thing left, and it is the part FLOP actually asked for: tell people what you did. The app writes the post for you at the bottom of this screen." to
        "다섯 단계 가운데 마지막이었습니다. Passport가 활성화되었습니다. 한 가지가 남았고, 그것이 바로 FLOP이 실제로 요청한 일입니다. 무엇을 했는지 사람들에게 알리세요. 게시글은 이 화면 아래에서 앱이 대신 써 줍니다.",
    "This app is free and there is nothing in it to buy. If it has been useful, a thank you can go to kosa.skr." to
        "이 앱은 무료이고, 안에서 살 수 있는 것도 없습니다. 도움이 되었다면 kosa.skr로 감사 인사를 보낼 수 있습니다.",
    "checking" to
        "확인 중",
    "open notification settings" to
        "알림 설정 열기",
    "send a tip to kosa.skr" to
        "kosa.skr에 후원 보내기",
    "show my private key" to
        "내 개인 키 보기",
    "step {n} {title} not confirmed yet" to
        "{n}단계 {title} 아직 확인되지 않음",
    "technocore.chat deletes anything with no write for seven days. Opening this app rewrites your note, and so does signing a record. Either one starts the seven days again." to
        "technocore.chat은 7일 동안 아무도 쓰지 않은 것을 모두 지웁니다. 이 앱을 여는 것이 노트를 다시 쓰는 일이고, 기록에 서명하는 것도 마찬가지입니다. 둘 중 하나만 해도 7일이 처음부터 다시 시작됩니다.",
    "This phone has no screen lock set up. Add a PIN or a fingerprint first." to
        "이 휴대전화에 화면 잠금이 설정되어 있지 않습니다. 먼저 PIN이나 지문을 등록하세요.",
    "The server accepted the write but the message is not in the room yet. Do not resend: read the room again first." to
        "서버는 쓰기를 받아들였지만 메시지가 아직 방에 없습니다. 다시 보내지 마세요. 먼저 방을 한 번 더 읽으세요.",
    "The stored text differs from the text we signed" to
        "저장된 텍스트가 서명한 텍스트와 다릅니다",
    "The stored record did not verify against this key" to
        "저장된 기록이 이 키로 검증되지 않았습니다",
    "You made a key only your wallet can rebuild, sealed it in this phone, published it where a stranger can find it, signed a record and proved it landed, and put your post beside your key. There is nothing left to set up." to
        "지갑만이 다시 만들어 낼 수 있는 키를 만들었고, 이 휴대전화 안에 봉인했고, 낯선 사람도 찾을 수 있는 곳에 공개했고, 기록에 서명해 그것이 도착했음을 증명했고, 게시글을 키 옆에 놓았습니다. 더 설정할 것은 없습니다.",
    "open Activity" to
        "활동 열기",
    "{n} more characters and the button below wakes up." to
        "{n}자만 더 쓰면 아래 버튼이 켜집니다.",
    "Could not check technocore.chat for your published steps. This says nothing about them, only about the connection. Re-check when you are back online." to
        "technocore.chat에서 게시된 단계를 확인할 수 없었습니다. 이는 그 단계와 무관하며 연결 상태만을 나타냅니다. 다시 온라인이 되면 다시 확인하세요.",
    "The key could not be sealed in this phone's secure storage" to
        "이 휴대전화의 보안 키 저장소에 키를 봉인할 수 없었습니다",
    "Try again. If it keeps failing, restart the phone and try once more. Nothing was sent anywhere." to
        "다시 시도하세요. 계속 실패하면 휴대전화를 다시 시작한 뒤 한 번 더 시도하세요. 아무 데도 아무것도 보내지 않았습니다.",
    "with a wallet prefix - this Passport rebuilds only through this same wallet app" to
        "지갑 접두사 포함 - 이 Passport는 같은 지갑 앱을 통해서만 다시 만들 수 있음",
    "Could not reach technocore.chat. Check your connection and press publish again. Your link is saved on this phone either way." to
        "technocore.chat에 연결하지 못했습니다. 연결을 확인하고 게시를 다시 누르세요. 링크는 어느 쪽이든 이 휴대전화에 저장되어 있습니다.",
    "The note was accepted, but it could not be read back yet." to
        "노트는 수락됐지만 아직 다시 읽지 못했습니다.",
    "The record was sent but no answer came back in time. Do not resend: read the room again first." to
        "기록은 보냈지만 제때 응답이 오지 않았습니다. 다시 보내지 마세요. 먼저 방을 한 번 더 읽으세요.",
    "The link you paste goes into your identity note, at an address derived from your own key. The note stays as long as you keep opening the app; seven days without a write and it is deleted." to
        "붙여 넣은 링크는 키에서 계산된 주소에 있는 신원 노트로 들어갑니다. 노트는 앱을 계속 여는 동안 남아 있고, 7일 동안 아무 쓰기가 없으면 삭제됩니다.",
    "vault: security chip" to "보관소: 보안 칩",
    "vault: secure area" to "보관소: 보안 영역",
    "vault: software" to "보관소: 소프트웨어",
    "vault: not sealed yet" to "보관소: 아직 봉인되지 않음",
    "Could not read the key from secure storage. Restart the phone and try again." to
        "보안 키 저장소에서 키를 읽을 수 없습니다. 휴대전화를 다시 시작한 뒤 다시 시도하세요.",
    "FLOP Passport is an independent community project. It is not made, endorsed or reviewed by FLOP Labs or by Solana Mobile." to
        "FLOP Passport는 독립적인 커뮤니티 프로젝트입니다. FLOP Labs나 Solana Mobile이 만들거나 보증하거나 심사하지 않았습니다.",
    "From now on: open the app at least once a week, so your identity note is not deleted. On the days you do something, open Activity and sign that day's record - a day cannot be added later." to
        "이제부터: 신원 노트가 삭제되지 않도록 적어도 일주일에 한 번 앱을 여세요. 무언가를 한 날에는 활동 탭을 열고 그날의 기록에 서명하세요. 지난 날은 나중에 채워 넣을 수 없습니다.",
    "Link to your post on X" to "X에 올린 게시물 링크",
    "Nothing was saved. Open your private key again and save it from there." to
        "저장된 것이 없습니다. 개인 키를 다시 열고 거기에서 저장하세요.",
    "Paste the link here and your name goes beside your key, in your identity note. This is the part people mean to do later and then do not." to
        "여기에 링크를 붙여 넣으면 이름이 신원 노트 안에서 키 옆에 놓입니다. 사람들이 나중에 하려다 결국 하지 않는 부분이 바로 이것입니다.",
    "Paste the link to your post on X. It goes into your identity note, so the note points at the post and the post carries the key. Anyone can then check both ends against one key. The app does not open the link or check the post; anyone reading your note can." to
        "X에 올린 게시물 링크를 붙여 넣으세요. 이 링크는 신원 노트에 들어가 노트는 게시물을 가리키고 게시물은 키를 담게 됩니다. 그러면 누구나 하나의 키로 양쪽을 확인할 수 있습니다. 앱은 링크를 열거나 게시물을 확인하지 않습니다. 노트를 읽는 사람이라면 누구나 확인할 수 있습니다.",
    "Seeker and Solana Mobile are trademarks of Solana Mobile, used only to say what this app is built for. FLOP and Technocore are names of the project whose public service this app writes to." to
        "Seeker와 Solana Mobile은 Solana Mobile의 상표이며, 이 앱이 어떤 기기를 위한 것인지 밝히기 위해서만 사용합니다. FLOP과 Technocore는 이 앱이 기록을 쓰는 공개 서비스를 운영하는 프로젝트의 이름입니다.",
    "The file could not be written. Try another location." to
        "파일을 쓸 수 없었습니다. 다른 위치를 선택하세요.",
    "The five steps built your identity. Nobody outside this phone knows it is yours yet. Step 06 below: write one line, post it, then come back and paste the link. That last part is what puts your name beside your key, and it is where people stop." to
        "다섯 단계가 신원을 만들었습니다. 이 휴대전화 밖에서는 그것이 당신 것이라는 사실을 아직 아무도 모릅니다. 아래 06단계입니다. 한 줄을 쓰고, 올리고, 돌아와 링크를 붙여 넣으세요. 그 마지막이 이름을 키 옆에 놓아 주며, 사람들이 멈추는 곳도 바로 거기입니다.",
    "Three things, in this order: write your line, post it on X, then come back and paste the link. The last one is what puts your name beside your key, and it is the one people forget." to
        "순서대로 세 가지입니다. 한 줄을 쓰고, X에 올리고, 돌아와서 링크를 붙여 넣으세요. 마지막이 이름을 키 옆에 놓아 주고, 사람들이 잊는 것도 바로 그것입니다.",
    "Your Passport is live, it is yours, and your post link is on it." to
        "Passport가 활성화됐고, 당신의 것이며, 당신의 게시물 링크가 붙어 있습니다.",
    "checking with the server" to "서버에서 확인 중",
    "independent project" to "독립 프로젝트",
    "not in your note yet" to "아직 노트에 없음",
    "post it on X" to "X에 게시하기",
    "put it in my note" to "내 노트에 넣기",
    "The prompt for this app begins with FLOP Passport key derivation v1 and names the app dev.alexkosa.floppassport; your wallet shows it was requested by flop.alexkosa.dev." to
        "이 앱의 서명 요청 문구는 FLOP Passport key derivation v1로 시작하고 앱 dev.alexkosa.floppassport를 명시합니다. 지갑에는 flop.alexkosa.dev가 요청했다고 표시됩니다.",
    "A signed record is dated evidence that you were here. A day without one cannot be added later, and signing also keeps your identity note alive. Nothing here promises anything about any allocation." to
        "서명된 기록은 당신이 여기 있었다는 날짜 붙은 증거입니다. 기록이 없는 하루는 나중에 채울 수 없고, 서명은 신원 노트를 유지해 주기도 합니다. 여기의 어떤 것도 어떠한 배분을 약속하지 않습니다.",
    "Your Passport itself is not lost: the same wallet still gives the same identity, and publishing again puts the note back at the same address." to
        "Passport 자체는 사라지지 않았습니다. 같은 지갑에서는 여전히 같은 신원이 생성되며, 다시 게시하면 같은 주소에 노트가 돌아옵니다.",
    "Read from technocore.chat, not from this phone. Rooms are trimmed as they grow, so this shows what anyone would find today." to
        "이 휴대전화가 아니라 technocore.chat에서 읽었습니다. 방은 커지면서 오래된 기록이 정리되므로, 여기 보이는 것은 오늘 누구나 찾을 수 있는 내용입니다.",
    "Seven days without opening the app. Open it and press publish; the note goes back to the same address." to
        "7일 동안 앱을 열지 않았습니다. 앱을 열고 게시를 누르면 노트가 같은 주소로 돌아옵니다.",
    "Finish the steps on the Passport tab first. Daily records start once your Passport is live." to
        "먼저 Passport 탭의 단계를 끝내세요. 일일 기록은 Passport가 활성화된 뒤에 시작됩니다.",
    "Today is the last day. It is deleted within 24 hours unless you open the app." to
        "오늘이 마지막 날입니다. 앱을 열지 않으면 24시간 안에 삭제됩니다.",
    "If you did something today, sign a record for it now." to
        "오늘 무언가를 했다면, 지금 그 기록에 서명하세요.",

    // 2.0: FLOP account, my day, guide and questions (2026-11-03).
    "@flop_labs is FLOP's account on X, YouTube and TikTok." to
        "@flop_labs는 X, YouTube, TikTok에 있는 FLOP의 계정입니다.",
    "A FLOP account with daily FLOP" to
        "매일 FLOP을 받는 FLOP 계정",
    "A flop.finance address, but not one FLOP lists publicly. Ask through x.com/flop_labs." to
        "flop.finance 주소이지만 FLOP이 공개적으로 안내하는 주소는 아닙니다. x.com/flop_labs를 통해 문의하세요.",
    "A flop.finance address. FLOP lists security@flop.finance as its one public contact." to
        "flop.finance 주소입니다. FLOP이 공개한 유일한 연락처는 security@flop.finance입니다.",
    "A model you pay in FLOP, and a streak" to
        "FLOP으로 값을 내는 모델, 그리고 연속 기록",
    "A practice network, open to everyone since 3 November 2026. FLOP here has no value, earns nothing and can be wiped in a reset. Use it to learn the day before it counts." to
        "누구나 이용할 수 있는 연습용 네트워크로, 2026년 11월 3일에 열렸습니다. 여기의 FLOP은 가치가 없고, 아무것도 벌어 주지 않으며, 초기화되면 지워질 수 있습니다. 실제로 집계되기 전에 하루 일과를 익히는 데 사용하세요.",
    "A streak counts days in a row with a signed record. One missed day a week is now forgiven; two missed days in a row end it. The count is read from the public room, so a day you did not sign cannot be added later." to
        "연속 기록은 서명된 기록이 있는 날이 며칠 이어졌는지를 셉니다. 이제 일주일에 하루는 빠져도 용서되며, 이틀 연속으로 빠지면 끝납니다. 이 숫자는 공개 방에서 읽어 오므로, 서명하지 않은 날은 나중에 추가할 수 없습니다.",
    "About 90 days. This is where FLOP's agent airdrop is earned: the testnet FLOP you spend on the model is recorded as your claim on mainnet FLOP." to
        "약 90일. FLOP의 에이전트 에어드롭이 쌓이는 단계입니다. 모델에 쓴 testnet FLOP이 mainnet FLOP에 대한 청구권으로 기록됩니다.",
    "Alex Kosa, one developer, for Seeker owners. It is not made by FLOP Labs. It is free and its code is open." to
        "Seeker 사용자를 위해 개발자 한 명, Alex Kosa가 만들었습니다. FLOP Labs가 만든 앱이 아닙니다. 무료이며 코드가 공개되어 있습니다.",
    "An identity made by your wallet" to
        "지갑이 만든 신원",
    "Ask a question, see what it cost, and keep a streak of the days you show up." to
        "질문하고, 비용을 확인하고, 찾아온 날들의 연속 기록을 이어 가세요.",
    "Ask anything. The model is small, so short, plain questions work best. Each answer costs a few devnet FLOP, taken from your Passport's allowance." to
        "무엇이든 물어보세요. 작은 모델이라 짧고 쉬운 질문이 가장 잘 맞습니다. 답변마다 devnet FLOP이 조금씩 들며, Passport의 사용 한도에서 차감됩니다.",
    "Ask the model" to
        "모델에게 질문",
    "Ask the model one question" to
        "모델에게 질문 하나 하기",
    "Blocks are being finalised normally." to
        "블록이 정상적으로 확정되고 있습니다.",
    "Could not reach FLOP's gateway. Check your connection and try again." to
        "FLOP 게이트웨이에 연결할 수 없습니다. 연결을 확인하고 다시 시도하세요.",
    "Could not reach technocore.chat." to
        "technocore.chat에 연결할 수 없습니다.",
    "Could not reach the FLOP devnet node. This says nothing about your balance, only about the connection." to
        "FLOP devnet 노드에 연결할 수 없습니다. 이는 잔액과 무관하며 연결 상태만을 나타냅니다.",
    "Could not reach the FLOP explorer." to
        "FLOP 익스플로러에 연결할 수 없습니다.",
    "Could not reach the FLOP faucet. Check your connection and try again." to
        "FLOP 파우셋에 연결할 수 없습니다. 연결을 확인하고 다시 시도하세요.",
    "Devnet FLOP is practice money: it has no value and can be wiped in a reset." to
        "devnet FLOP은 연습용 돈입니다. 가치가 없으며 초기화되면 지워질 수 있습니다.",
    "Devnet explorer" to
        "devnet 익스플로러",
    "Devnet is open" to
        "devnet이 열렸습니다",
    "Devnet is open to everyone since 3 November 2026. It has no rewards and may be reset. Testnet has no date yet; FLOP will announce it on x.com/flop_labs. On testnet, the testnet FLOP an agent spends on inference becomes its claim on mainnet FLOP. Creating accounts earns nothing." to
        "devnet은 2026년 11월 3일부터 누구나 이용할 수 있습니다. 보상은 없으며 초기화될 수 있습니다. testnet 날짜는 아직 없으며, FLOP이 x.com/flop_labs에서 발표할 예정입니다. testnet에서는 에이전트가 추론에 쓴 testnet FLOP이 mainnet FLOP에 대한 청구권이 됩니다. 계정을 만드는 것으로는 아무것도 얻지 못합니다.",
    "Devnet is practice" to
        "devnet은 연습입니다",
    "Devnet is practice: its FLOP has no value. This app promises nothing about any allocation." to
        "devnet은 연습입니다. 여기의 FLOP은 가치가 없습니다. 이 앱은 어떠한 할당도 약속하지 않습니다.",
    "Do I have to post on X?" to
        "X에 꼭 게시해야 합니까?",
    "Do I need more than one account?" to
        "계정이 두 개 이상 필요합니까?",
    "Do my day" to
        "오늘 할 일 하기",
    "Every step below was read back from the server, not just sent." to
        "아래 모든 단계는 보내기만 한 것이 아니라 서버에서 다시 읽어 확인했습니다.",
    "Explain the idea of a 'seed phrase' and why it must stay secret." to
        "'시드 문구'의 개념과 그것을 반드시 비밀로 지켜야 하는 이유를 설명해 주세요.",
    "Explain what 'decentralised' means without using jargon." to
        "'탈중앙화'가 무슨 뜻인지 전문 용어 없이 설명해 주세요.",
    "Explain what a blockchain block is to a ten-year-old, in three sentences." to
        "블록체인의 블록이 무엇인지 열 살 아이에게 세 문장으로 설명해 주세요.",
    "Explain what an API is using a restaurant as the example." to
        "API가 무엇인지 식당을 예로 들어 설명해 주세요.",
    "Explain what open-source software is in two sentences." to
        "오픈 소스 소프트웨어가 무엇인지 두 문장으로 설명해 주세요.",
    "FLOP Network is a blockchain where AI agents pay for AI work with FLOP. Miners run models on graphics cards, validators check that the work was really done, and agents buy the answers. Asking the model a question here is exactly that: your Passport acts as an agent and pays for one answer." to
        "FLOP Network는 AI 에이전트가 FLOP으로 AI 작업 비용을 내는 블록체인입니다. 채굴자는 그래픽 카드에서 모델을 실행하고, 검증자는 작업이 실제로 이루어졌는지 확인하며, 에이전트는 답변을 삽니다. 여기서 모델에게 질문하는 것이 바로 그것입니다. Passport가 에이전트 역할을 하며 답변 하나의 값을 냅니다.",
    "FLOP Passport gives your Seeker an identity and an account on FLOP Network, and one place to do your day there. It is free, open source, and made by one developer, Alex Kosa. It is not made by FLOP Labs." to
        "FLOP Passport는 Seeker에 FLOP Network의 신원과 계정을 주고, 그곳에서 하루 할 일을 하는 한 곳을 제공합니다. 무료이고 오픈 소스이며, 개발자 한 명, Alex Kosa가 만들었습니다. FLOP Labs가 만든 앱이 아닙니다.",
    "FLOP gives each account one devnet allowance: 25 FLOP for 24 hours. When it is over it is over until testnet." to
        "FLOP은 계정마다 devnet 사용 한도를 한 번 줍니다. 24시간 동안 25 FLOP입니다. 끝나면 testnet까지 다시 열리지 않습니다.",
    "FLOP has no Discord, Telegram, Reddit or Medium. There is no FLOP token yet." to
        "FLOP에는 Discord, Telegram, Reddit, Medium이 없습니다. 아직 FLOP 토큰은 없습니다.",
    "FLOP has no official Discord, Telegram, Reddit or Medium. An invitation to one never comes from FLOP." to
        "FLOP에는 공식 Discord, Telegram, Reddit, Medium이 없습니다. 그런 곳으로의 초대는 절대 FLOP에서 오지 않습니다.",
    "FLOP has not announced the testnet date. When it opens, the testnet FLOP you spend on the model becomes your claim on mainnet FLOP. Holding FLOP or making more accounts earns nothing." to
        "FLOP은 아직 testnet 날짜를 발표하지 않았습니다. testnet이 열리면 모델에 쓴 testnet FLOP이 mainnet FLOP에 대한 청구권이 됩니다. FLOP을 보유하거나 계정을 더 만드는 것으로는 아무것도 얻지 못합니다.",
    "FLOP has not given a date. It will be announced on x.com/flop_labs, and this app's status will say so the same day." to
        "FLOP은 아직 날짜를 정하지 않았습니다. x.com/flop_labs에서 발표될 예정이며, 이 앱의 상태 표시도 같은 날 알려 드립니다.",
    "FLOP says Q1 2027" to
        "FLOP 발표: 2027년 1분기",
    "FLOP says there is no token, mint, claim, presale or live airdrop yet. Anything offering one is not FLOP." to
        "FLOP에 따르면 아직 토큰, 민트, 클레임, 프리세일, 진행 중인 에어드롭은 없습니다. 그런 것을 제안하는 곳은 FLOP이 아닙니다.",
    "FLOP's faucet is down for everyone right now. It is not your phone. Try again later." to
        "지금 FLOP 파우셋이 모두에게 작동하지 않습니다. 휴대전화 문제가 아닙니다. 나중에 다시 시도하세요.",
    "FLOP's faucet is refusing every request with “IP classification unavailable”. This is FLOP's bug (network issue #22), not your phone. The app keeps trying when you press do my day." to
        "FLOP 파우셋이 모든 요청을 “IP classification unavailable”로 거부하고 있습니다. 이는 FLOP의 버그(네트워크 이슈 #22)이며 휴대전화 문제가 아닙니다. 오늘 할 일 하기를 누르면 앱이 계속 시도합니다.",
    "FLOP's faucet sends 25 devnet FLOP to your address, once every 24 hours per address. The request goes from your phone, for your own address, the same as pressing the button on faucet.flop.network. When the faucet is down, the app says so and the rest of your day still counts." to
        "FLOP 파우셋은 주소당 24시간마다 한 번, 25 devnet FLOP을 당신의 주소로 보냅니다. 요청은 당신의 휴대전화에서 당신의 주소를 위해 나가며, faucet.flop.network에서 버튼을 누르는 것과 같습니다. 파우셋이 멈췄을 때는 앱이 그렇다고 알려 주며, 하루의 나머지 일은 그대로 인정됩니다.",
    "FLOP's gateway has handed out all of today's devnet allowances, or is unavailable. Try again later." to
        "FLOP 게이트웨이가 오늘의 devnet 사용 한도를 모두 나눠 줬거나 이용할 수 없는 상태입니다. 나중에 다시 시도하세요.",
    "FLOP's gateway rules (OpenAPI)" to
        "FLOP 게이트웨이 규칙 (OpenAPI)",
    "FLOP's only handle is @flop_labs. Any other account using the name is not theirs." to
        "FLOP의 유일한 계정은 @flop_labs입니다. 이 이름을 쓰는 다른 계정은 FLOP의 것이 아닙니다.",
    "FLOP: official links and verification" to
        "FLOP: 공식 링크와 확인 방법",
    "FLOP: the airdrop and testnet conversion" to
        "FLOP: 에어드롭과 testnet 전환",
    "Faucet outage, FLOP issue #22" to
        "파우셋 장애, FLOP 이슈 #22",
    "Finality is lagging behind. The network may be slow." to
        "확정이 늦어지고 있습니다. 네트워크가 느릴 수 있습니다.",
    "Finish setting up your Passport first." to
        "먼저 Passport 설정을 마치세요.",
    "Free and open source. Made by Alex Kosa, not by FLOP Labs. It promises nothing about any allocation." to
        "무료 오픈 소스입니다. FLOP Labs가 아니라 Alex Kosa가 만들었습니다. 어떠한 할당도 약속하지 않습니다.",
    "From FLOP's faucet, once every 24 hours." to
        "FLOP 파우셋에서 24시간마다 한 번.",
    "From FLOP's faucet. Next in {time}." to
        "FLOP 파우셋에서. 다음은 {time} 후.",
    "From the FLOP Passport team, written into this version." to
        "FLOP Passport 팀이 이 버전에 적어 둔 내용입니다.",
    "From the FLOP Passport team." to
        "FLOP Passport 팀에서.",
    "Get 25 FLOP" to
        "25 FLOP 받기",
    "Give me a short motivational sentence for a Monday." to
        "월요일에 어울리는 짧은 동기 부여 문장을 하나 알려 주세요.",
    "Give me a simple recipe idea with rice and eggs." to
        "밥과 달걀로 만드는 간단한 요리 아이디어를 알려 주세요.",
    "Give me one practical tip for writing clearer emails." to
        "더 명확한 이메일을 쓰는 실용적인 팁을 하나 알려 주세요.",
    "Give one good question to ask before buying any crypto token." to
        "암호화폐 토큰을 사기 전에 던져 볼 만한 좋은 질문 하나를 알려 주세요.",
    "Give one way to remember a new word in a foreign language." to
        "외국어의 새 단어를 기억하는 방법을 하나 알려 주세요.",
    "Give three tips for keeping a phone's battery healthy." to
        "휴대전화 배터리를 건강하게 유지하는 팁 세 가지를 알려 주세요.",
    "I changed phones. How do I get my Passport back?" to
        "휴대전화를 바꿨습니다. Passport를 어떻게 되찾습니까?",
    "In plain words, what does 'inference' mean for an AI model?" to
        "쉬운 말로, AI 모델에서 '추론'은 무슨 뜻인가요?",
    "In two sentences, what does a GPU do that a CPU does badly?" to
        "GPU는 잘하고 CPU는 잘 못하는 일이 무엇인지 두 문장으로 알려 주세요.",
    "Install the app and connect the same Solana wallet. The same wallet makes the same Passport, with the same FLOP address and the same streak. There are no words to write down." to
        "앱을 설치하고 같은 Solana 지갑을 연결하세요. 같은 지갑은 같은 Passport를 만들며, FLOP 주소와 연속 기록도 같습니다. 적어 둘 단어는 없습니다.",
    "Is this FLOP money real?" to
        "이 FLOP은 진짜 돈입니까?",
    "It gets 25 devnet FLOP from FLOP's faucet every 24 hours." to
        "FLOP 파우셋에서 24시간마다 25 devnet FLOP을 받습니다.",
    "It needs at least 1 FLOP on your Passport address first. On devnet each account also gets only one trial: 25 FLOP for 24 hours. After that it stays closed until testnet. The Ask tab says which one it is." to
        "먼저 Passport 주소에 최소 1 FLOP이 있어야 합니다. 또한 devnet에서는 계정마다 체험이 한 번뿐입니다. 24시간 동안 25 FLOP입니다. 그 뒤에는 testnet까지 닫혀 있습니다. 어느 경우인지는 질문 탭에서 알려 줍니다.",
    "Its FLOP has no value. What you practise here is what testnet will count." to
        "여기의 FLOP은 가치가 없습니다. 여기서 연습하는 것이 testnet에서 집계될 일입니다.",
    "Name three things to check before signing anything in a crypto wallet." to
        "암호화폐 지갑에서 무언가에 서명하기 전에 확인할 세 가지를 알려 주세요.",
    "Name three uses of AI that run well on small models." to
        "작은 모델에서도 잘 돌아가는 AI 활용 사례 세 가지를 알려 주세요.",
    "No, and it would not help. FLOP counts spending, not accounts, and says extra accounts earn nothing. One person, one Passport." to
        "아니요, 그리고 도움이 되지도 않습니다. FLOP은 계정 수가 아니라 쓴 양을 세며, 추가 계정으로는 아무것도 얻지 못한다고 밝혔습니다. 한 사람, 하나의 Passport.",
    "No. Devnet FLOP is practice money with no value, and FLOP may wipe the devnet at any time. There is no FLOP token yet at all. Anybody selling FLOP today is a scammer." to
        "아니요. devnet FLOP은 가치 없는 연습용 돈이며, FLOP은 언제든 devnet을 초기화할 수 있습니다. FLOP 토큰은 아직 전혀 없습니다. 지금 FLOP을 판다는 사람은 사기꾼입니다.",
    "No. Linking a post to your Passport is optional. It shows people the Passport is yours, nothing more." to
        "아니요. 게시물을 Passport에 연결하는 것은 선택 사항입니다. 이 Passport가 당신의 것임을 사람들에게 보여 줄 뿐, 그 이상은 아닙니다.",
    "Nobody can promise that, and this app never will. What FLOP says: on testnet, the testnet FLOP an agent spends on the model becomes its claim on mainnet FLOP. The app helps you do exactly that every day. Devnet, which is now, earns nothing." to
        "아무도 그것을 약속할 수 없으며, 이 앱도 절대 약속하지 않습니다. FLOP의 설명은 이렇습니다. testnet에서 에이전트가 모델에 쓴 testnet FLOP이 mainnet FLOP에 대한 청구권이 됩니다. 이 앱은 당신이 매일 바로 그 일을 하도록 돕습니다. 지금 단계인 devnet에서는 아무것도 얻지 못합니다.",
    "Nothing new to write down. The same wallet brings it back on any phone." to
        "새로 적어 둘 것은 없습니다. 같은 지갑이 어느 휴대전화에서든 되살려 줍니다.",
    "On devnet FLOP gives each account one allowance: 25 FLOP to spend on the model within 24 hours, and needs at least 1 FLOP on the account to start it. When it is over, it stays over until testnet." to
        "devnet에서 FLOP은 계정마다 사용 한도를 한 번 줍니다. 24시간 안에 모델에 쓸 25 FLOP이며, 시작하려면 계정에 최소 1 FLOP이 있어야 합니다. 끝나면 testnet까지 다시 열리지 않습니다.",
    "One button signs today, takes today's FLOP and asks the model one question." to
        "버튼 하나로 오늘 서명하고, 오늘의 FLOP을 받고, 모델에게 질문 하나를 합니다.",
    "One press does all three, in order. Whatever is already done is skipped." to
        "한 번 누르면 세 가지를 순서대로 합니다. 이미 끝난 것은 건너뜁니다.",
    "One question, paid in FLOP. Spending on the model is what testnet will count." to
        "FLOP으로 값을 내는 질문 하나. testnet에서 집계되는 것은 모델에 쓴 FLOP입니다.",
    "One short text to sign. It is not a transaction and moves no money. Your wallet keeps its keys; nothing leaves it but that one signature." to
        "서명할 짧은 텍스트 하나. 거래가 아니며 돈을 옮기지 않습니다. 키는 지갑에 그대로 있고, 그 서명 하나 외에는 아무것도 지갑을 떠나지 않습니다.",
    "Only text, never a transaction. Once, to create your Passport. After that the Passport signs on its own: your daily record and the model's entry statement. None of it can move money from your wallet." to
        "텍스트뿐이며, 거래는 절대 아닙니다. Passport를 만들 때 한 번입니다. 그 뒤에는 Passport가 스스로 서명합니다. 일일 기록과 모델 입장 문구입니다. 어느 것도 지갑에서 돈을 옮길 수 없습니다.",
    "Open the app and press do my day. It signs today, takes today's FLOP from the faucet and asks the model one question. That is all. Whatever is already done is skipped." to
        "앱을 열고 오늘 할 일 하기를 누르세요. 오늘 서명하고, 파우셋에서 오늘의 FLOP을 받고, 모델에게 질문 하나를 합니다. 그게 전부입니다. 이미 끝난 것은 건너뜁니다.",
    "Open the app and press do my day: it signs today, takes today's FLOP and asks the model one question." to
        "앱을 열고 오늘 할 일 하기를 누르세요. 오늘 서명하고, 오늘의 FLOP을 받고, 모델에게 질문 하나를 합니다.",
    "Paste a FLOP address from SubWallet, Talisman or Polkadot.js. The faucet will send there. The model still uses your Passport's own address, because only your Passport can sign for it." to
        "SubWallet, Talisman, Polkadot.js의 FLOP 주소를 붙여 넣으세요. 파우셋이 그 주소로 보냅니다. 모델은 계속 Passport 자체 주소를 사용합니다. 그 주소로 서명할 수 있는 것은 Passport뿐이기 때문입니다.",
    "Paste a full link, a handle like @name, or an address." to
        "전체 링크, @name 같은 핸들, 또는 주소를 붙여 넣으세요.",
    "Paste a link, an @handle or an address someone sent you." to
        "누군가 보낸 링크, @핸들 또는 주소를 붙여 넣으세요.",
    "Questions people ask" to
        "자주 묻는 질문",
    "Reading your days from technocore.chat…" to
        "technocore.chat에서 기록한 날을 읽는 중…",
    "Same Passport, same days. And now one missed day a week is forgiven." to
        "같은 Passport, 같은 날들. 그리고 이제 일주일에 하루는 빠져도 용서됩니다.",
    "Sign today" to
        "오늘 서명하기",
    "Sign today to start your streak." to
        "오늘 서명하고 연속 기록을 시작하세요.",
    "Sign today's record" to
        "오늘 기록에 서명",
    "Sign today, or the streak ends. Yesterday was already forgiven." to
        "오늘 서명하지 않으면 연속 기록이 끝납니다. 어제는 이미 용서됐습니다.",
    "Signing the gateway's statement with your Passport…" to
        "Passport로 게이트웨이 문구에 서명하는 중…",
    "Since 3 November FLOP's practice network is open to everyone. Devnet FLOP has no value, earns nothing, and the network may be reset at any time." to
        "11월 3일부터 FLOP의 연습용 네트워크가 누구에게나 열려 있습니다. devnet FLOP은 가치가 없고, 아무것도 벌어 주지 않으며, 네트워크는 언제든 초기화될 수 있습니다.",
    "Staying safe" to
        "안전하게 지키기",
    "Suggest a five-minute stretch for someone who sits all day." to
        "하루 종일 앉아 있는 사람을 위한 5분 스트레칭을 추천해 주세요.",
    "Summarise what 'proof of work' means in two sentences." to
        "'작업 증명(proof of work)'이 무슨 뜻인지 두 문장으로 요약해 주세요.",
    "Take today's FLOP" to
        "오늘의 FLOP 받기",
    "Tell me one interesting fact about the history of computers." to
        "컴퓨터 역사에 관한 흥미로운 사실 하나를 알려 주세요.",
    "Testnet and the airdrop" to
        "testnet과 에어드롭",
    "Testnet: no date yet" to
        "testnet: 아직 날짜 없음",
    "That is not a FLOP address. It should start with 5 and be 47 or 48 characters; copy it again from your wallet." to
        "FLOP 주소가 아닙니다. 5로 시작하고 47자 또는 48자여야 합니다. 지갑에서 다시 복사하세요.",
    "The faucet" to
        "파우셋",
    "The faucet did not answer." to
        "파우셋이 응답하지 않았습니다.",
    "The faucet is down for everyone" to
        "파우셋이 모두에게 멈췄습니다",
    "The faucet sends to an address you chose instead:" to
        "파우셋은 대신 당신이 고른 주소로 보냅니다:",
    "The faucet works for you" to
        "당신에게는 파우셋이 작동합니다",
    "The model did not answer." to
        "모델이 응답하지 않았습니다.",
    "The model is busy. Try again in a minute; nothing was spent." to
        "모델이 바쁩니다. 1분 뒤에 다시 시도하세요. 쓰인 것은 없습니다.",
    "The model is closed for this account" to
        "이 계정에서는 모델이 닫혔습니다",
    "The model is thinking…" to
        "모델이 생각하는 중…",
    "The model needs at least 1 FLOP on your Passport address first. Get it from the faucet." to
        "모델을 쓰려면 먼저 Passport 주소에 최소 1 FLOP이 있어야 합니다. 파우셋에서 받으세요.",
    "The model: one trial per account" to
        "모델: 계정당 체험 한 번",
    "The real token. There is no FLOP token before this, so anything sold or “claimed” as FLOP today is a scam." to
        "진짜 토큰입니다. 그 전에는 FLOP 토큰이 없으므로, 지금 FLOP이라며 팔거나 “클레임”하게 하는 것은 모두 사기입니다.",
    "There is no FLOP token yet, so there is no FLOP contract address. Anything offered as one is not FLOP." to
        "아직 FLOP 토큰이 없으므로 FLOP 컨트랙트 주소도 없습니다. 그렇다며 제시되는 주소는 FLOP이 아닙니다.",
    "There is no FLOP token yet. Nobody, including this app's author, will ever ask for your private key or your wallet's words. Your wallet only ever signs text here, never a transaction. If somebody sends you a FLOP link, check it on the Network tab first." to
        "아직 FLOP 토큰은 없습니다. 이 앱 제작자를 포함해 누구도 당신의 개인 키나 지갑 단어를 요구하지 않습니다. 여기서 지갑은 텍스트에만 서명하며, 거래에는 절대 서명하지 않습니다. 누군가 FLOP 링크를 보내면 먼저 네트워크 탭에서 확인하세요.",
    "There is no Passport on this phone." to
        "이 휴대전화에는 Passport가 없습니다.",
    "This account has used its one devnet allowance. FLOP does not renew it on devnet. The model opens again when testnet starts, and on testnet the FLOP you spend here is what counts." to
        "이 계정은 한 번뿐인 devnet 사용 한도를 다 썼습니다. FLOP은 devnet에서 이를 갱신하지 않습니다. testnet이 시작되면 모델이 다시 열리며, testnet에서는 여기서 쓰는 FLOP이 집계됩니다.",
    "This account's devnet allowance is used up." to
        "이 계정의 devnet 사용 한도를 다 썼습니다.",
    "This address already got its FLOP in the last 24 hours." to
        "이 주소는 지난 24시간 안에 이미 FLOP을 받았습니다.",
    "This app's source code" to
        "이 앱의 소스 코드",
    "This is an account on FLOP Network. An address alone says nothing about who holds it." to
        "FLOP Network의 계정입니다. 주소만으로는 누가 가지고 있는지 알 수 없습니다.",
    "To use the model, your Passport signs a short statement from api.flop.network. That signature moves nothing. FLOP then opens an allowance for your account: on devnet that is 25 FLOP for 24 hours, once per account, and your account needs at least 1 FLOP to start it. An answer costs about 0.006 FLOP per word-piece, usually one or two FLOP. When the allowance ends, the model stays closed for that account until testnet." to
        "모델을 사용하려면 Passport가 api.flop.network의 짧은 문구에 서명합니다. 그 서명은 아무것도 옮기지 않습니다. 그러면 FLOP이 계정에 사용 한도를 열어 줍니다. devnet에서는 계정당 한 번, 24시간 동안 25 FLOP이며, 시작하려면 계정에 최소 1 FLOP이 있어야 합니다. 답변 비용은 단어 조각당 약 0.006 FLOP으로, 보통 1~2 FLOP입니다. 한도가 끝나면 그 계정에서는 testnet까지 모델이 닫혀 있습니다.",
    "Today is not signed yet" to
        "오늘은 아직 서명하지 않았습니다",
    "Today is not signed yet." to
        "오늘은 아직 서명하지 않았습니다.",
    "Today is signed. Come back tomorrow." to
        "오늘 서명을 마쳤습니다. 내일 다시 오세요.",
    "Today is signed. See you tomorrow." to
        "오늘 서명을 마쳤습니다. 내일 만나요.",
    "Too many tries from this network. Wait a minute and try again." to
        "이 네트워크에서 시도가 너무 많습니다. 1분 기다린 뒤 다시 시도하세요.",
    "Type a question" to
        "질문을 입력하세요",
    "What FLOP is" to
        "FLOP이란",
    "What FLOP says: on testnet, testnet FLOP that an agent actually spends on inference becomes its claim on mainnet FLOP. That claim is locked, and unlocks as it is spent on inference on mainnet: three spent unlock one. Holding FLOP earns nothing. Making more accounts earns nothing. Posting your identity earns nothing." to
        "FLOP의 설명: testnet에서 에이전트가 실제로 추론에 쓴 testnet FLOP이 mainnet FLOP에 대한 청구권이 됩니다. 이 청구권은 잠겨 있으며, mainnet에서 추론에 쓰는 만큼 풀립니다. 세 개를 쓰면 하나가 풀립니다. FLOP을 보유해도 얻는 것은 없습니다. 계정을 더 만들어도 얻는 것은 없습니다. 신원을 게시해도 얻는 것은 없습니다.",
    "What do I need to do every day?" to
        "매일 무엇을 해야 합니까?",
    "What does a miner do in a compute network?" to
        "컴퓨팅 네트워크에서 채굴자는 무슨 일을 하나요?",
    "What exactly does my wallet sign?" to
        "지갑은 정확히 무엇에 서명합니까?",
    "What is a hash function? Two sentences." to
        "해시 함수란 무엇인가요? 두 문장으로.",
    "What is a token in the context of language models?" to
        "언어 모델에서 말하는 토큰이란 무엇인가요?",
    "What is a validator in a blockchain network? Keep it short." to
        "블록체인 네트워크에서 검증자란 무엇인가요? 짧게요.",
    "What is an AI agent, in one paragraph?" to
        "AI 에이전트란 무엇인지 한 문단으로 알려 주세요.",
    "What is latency, and why do people care about it?" to
        "지연 시간이란 무엇이고, 사람들은 왜 신경 쓸까요?",
    "What is phishing, and how do you spot it? Three signs." to
        "피싱이란 무엇이고, 어떻게 알아챌 수 있나요? 세 가지 신호로.",
    "What is the cloud, really? Two sentences." to
        "클라우드란 정말 무엇인가요? 두 문장으로.",
    "What is the difference between a private key and a public key?" to
        "개인 키와 공개 키는 무엇이 다른가요?",
    "What makes a password strong? Three short points." to
        "강한 비밀번호의 조건은 무엇인가요? 짧게 세 가지로.",
    "What this app is" to
        "이 앱은 무엇인가",
    "What we say: this app promises nothing about any allocation, and never will. It helps you do, every day, the thing FLOP says it counts. One person, one Passport." to
        "우리의 입장: 이 앱은 어떠한 할당도 약속하지 않으며, 앞으로도 약속하지 않습니다. FLOP이 집계한다고 밝힌 일을 매일 할 수 있도록 도울 뿐입니다. 한 사람, 하나의 Passport.",
    "When does testnet start?" to
        "testnet은 언제 시작됩니까?",
    "Where FLOP is now" to
        "FLOP의 현재 상황",
    "Where these facts come from" to
        "이 정보의 출처",
    "Who made this app?" to
        "이 앱은 누가 만들었습니까?",
    "Why did my streak go back to zero?" to
        "연속 기록이 왜 0으로 돌아갔습니까?",
    "Why do computers use binary? Two sentences." to
        "컴퓨터는 왜 2진법을 쓰나요? 두 문장으로.",
    "Why does the model not answer me?" to
        "모델이 왜 답하지 않습니까?",
    "Why is my balance 0?" to
        "잔액이 왜 0입니까?",
    "Will I get FLOP tokens for this?" to
        "이걸로 FLOP 토큰을 받게 됩니까?",
    "Write a haiku about a phone that never sleeps." to
        "잠들지 않는 휴대전화에 관한 하이쿠를 써 주세요.",
    "You are a small model running on FLOP Network's devnet, answering inside a phone app. Answer briefly and plainly. Answer in the language the user writes in." to
        "당신은 FLOP Network의 devnet에서 실행되는 작은 모델이며, 휴대전화 앱 안에서 답변합니다. 짧고 쉽게 답하세요. 사용자가 쓰는 언어로 답하세요.",
    "You never need this to recover: your wallet rebuilds the Passport. It is here for people who want to use their identity away from this phone. Nobody, including this app's author, will ever ask you for it." to
        "복구에 이것이 필요한 일은 없습니다. 지갑이 Passport를 다시 만들어 줍니다. 이 휴대전화 밖에서 신원을 쓰고 싶은 사람을 위해 여기 있습니다. 이 앱 제작자를 포함해 누구도 이것을 요구하지 않습니다.",
    "Your FLOP address" to
        "FLOP 주소",
    "Your FLOP comes from FLOP's faucet, and right now the faucet is not giving FLOP to anyone. That is FLOP's problem, not your phone. When it works, press do my day and 25 FLOP arrives within a minute." to
        "FLOP은 FLOP 파우셋에서 받는데, 지금은 파우셋이 누구에게도 FLOP을 주지 않습니다. 휴대전화가 아니라 FLOP 쪽 문제입니다. 파우셋이 작동하면 오늘 할 일 하기를 누르세요. 1분 안에 25 FLOP이 도착합니다.",
    "Your Passport is a FLOP account" to
        "Passport는 FLOP 계정입니다",
    "Your Passport is also a FLOP address. FLOP's faucet gives it 25 FLOP every 24 hours." to
        "Passport는 FLOP 주소이기도 합니다. FLOP 파우셋이 24시간마다 25 FLOP을 줍니다.",
    "Your Passport key is also an account on FLOP Network. Same key, written the way FLOP writes addresses." to
        "Passport 키는 FLOP Network의 계정이기도 합니다. 같은 키를 FLOP의 주소 형식으로 쓴 것입니다.",
    "Your Passport key is also your FLOP account. It is the same key, written the way FLOP writes addresses, so there is nothing new to back up: your Solana wallet rebuilds both on any phone. If you already have a FLOP address in SubWallet, Talisman or Polkadot.js, you can send the faucet there instead, on the Passport tab. The model works only with the Passport's own address, because only the Passport can sign for it." to
        "Passport 키는 FLOP 계정이기도 합니다. 같은 키를 FLOP의 주소 형식으로 쓴 것이라 새로 백업할 것이 없습니다. Solana 지갑이 어느 휴대전화에서든 둘 다 다시 만들어 줍니다. SubWallet, Talisman, Polkadot.js에 이미 FLOP 주소가 있다면 Passport 탭에서 파우셋이 그쪽으로 보내도록 바꿀 수 있습니다. 모델은 Passport 자체 주소에서만 작동합니다. 그 주소로 서명할 수 있는 것은 Passport뿐이기 때문입니다.",
    "Your Passport now lives on FLOP" to
        "이제 Passport가 FLOP 위에 있습니다",
    "Your Passport signs one line in public. It adds a day to your streak." to
        "Passport가 공개적으로 한 줄에 서명합니다. 연속 기록에 하루가 더해집니다.",
    "Your Passport signs one short line in a public room on technocore.chat, and the app reads it back to prove it landed. Each signed day adds to your streak. Miss one day and it is forgiven, once a week. Miss two in a row and the streak starts again." to
        "Passport가 technocore.chat의 공개 방에 짧은 한 줄을 서명해 올리고, 앱이 다시 읽어 도착을 증명합니다. 서명한 날마다 연속 기록이 늘어납니다. 하루를 빠지면 일주일에 한 번은 용서됩니다. 이틀 연속으로 빠지면 연속 기록이 처음부터 다시 시작됩니다.",
    "Your address got its FLOP from the faucet in the last 24 hours. It can ask again 24 hours after the last grant." to
        "이 주소는 지난 24시간 안에 파우셋에서 FLOP을 받았습니다. 마지막 지급 후 24시간이 지나면 다시 요청할 수 있습니다.",
    "Your day is done." to
        "오늘 할 일을 마쳤습니다.",
    "Your day on FLOP, from your Seeker." to
        "Seeker에서 보내는 FLOP 위의 하루.",
    "Your day, step by step" to
        "하루 일과, 단계별로",
    "Your first question opens it. Your Passport signs a short statement from api.flop.network; nothing else is signed and nothing moves. You need at least 1 FLOP on your Passport's address, which the faucet on Today gives you." to
        "첫 질문을 하면 열립니다. Passport가 api.flop.network의 짧은 문구에 서명합니다. 그 외에는 아무것도 서명하지 않으며 아무것도 옮겨지지 않습니다. Passport 주소에 최소 1 FLOP이 필요하며, 오늘 탭의 파우셋에서 받을 수 있습니다.",
    "Your identity note was deleted after seven quiet days. Publish it again to keep signing your days. Your streak is not lost." to
        "7일 동안 활동이 없어 신원 노트가 삭제됐습니다. 계속 날마다 서명하려면 다시 게시하세요. 연속 기록은 사라지지 않았습니다.",
    "Your one devnet trial of the model is over. It opens again on testnet." to
        "모델의 devnet 체험 한 번이 끝났습니다. testnet에서 다시 열립니다.",
    "Your streak came with you" to
        "연속 기록도 함께 옮겨 왔습니다",
    "Your wallet made this key and rebuilds it on any phone. There are no words to write down." to
        "지갑이 이 키를 만들었고, 어느 휴대전화에서든 다시 만들어 줍니다. 적어 둘 단어는 없습니다.",
    "Your {n}-day streak ends at midnight" to
        "{n}일 연속 기록이 자정에 끊깁니다",
    "accounts" to
        "계정",
    "active agents" to
        "활성 에이전트",
    "all my records" to
        "내 모든 기록",
    "allowance left" to
        "남은 한도",
    "already asked today" to
        "오늘 이미 질문함",
    "already signed today" to
        "오늘 이미 서명함",
    "already taken today" to
        "오늘 이미 받음",
    "answered" to
        "답변됨",
    "ask the model something else" to
        "모델에게 다른 질문하기",
    "back" to
        "뒤로",
    "balance" to
        "잔액",
    "balance {n} FLOP" to
        "잔액 {n} FLOP",
    "change the address" to
        "주소 변경",
    "closes in" to
        "닫히기까지",
    "compute market and FRCR index" to
        "컴퓨팅 시장과 FRCR 지수",
    "copied" to
        "복사됨",
    "cost {n} FLOP" to
        "비용 {n} FLOP",
    "day in a row" to
        "일 연속",
    "days in a row" to
        "일 연속",
    "devnet flop" to
        "devnet FLOP",
    "do my day" to
        "오늘 할 일 하기",
    "entering" to
        "입장 중",
    "finish your passport first" to
        "먼저 Passport를 완성하세요",
    "flop gateway" to
        "FLOP 게이트웨이",
    "go back to my passport address" to
        "내 Passport 주소로 되돌리기",
    "got it" to
        "알겠습니다",
    "how it all works" to
        "전체 작동 방식",
    "how it works" to
        "작동 방식",
    "how it works, questions and answers" to
        "작동 방식, 질문과 답변",
    "how the model works here" to
        "여기서 모델이 작동하는 방식",
    "is this really flop?" to
        "정말 FLOP인가?",
    "just now" to
        "방금",
    "latest block" to
        "최신 블록",
    "made by wallet" to
        "지갑이 만듦",
    "model" to
        "모델",
    "my day on flop" to
        "FLOP 위의 내 하루",
    "needs flop" to
        "FLOP 필요",
    "network" to
        "네트워크",
    "new in 2.0" to
        "2.0의 새 기능",
    "news" to
        "소식",
    "no date yet" to
        "아직 날짜 없음",
    "not entered" to
        "입장 안 함",
    "not flop" to
        "FLOP 아님",
    "not flop's" to
        "FLOP 소유 아님",
    "not now" to
        "나중에",
    "official" to
        "공식",
    "official channels" to
        "공식 채널",
    "open in FLOP's explorer" to
        "FLOP 익스플로러에서 열기",
    "passport" to
        "Passport",
    "private key" to
        "개인 키",
    "publish again" to
        "다시 게시",
    "read it in FLOP's own words" to
        "FLOP의 원문으로 읽기",
    "reading" to
        "읽는 중",
    "refresh" to
        "새로고침",
    "refused" to
        "거부됨",
    "save" to
        "저장",
    "scam warning" to
        "사기 경고",
    "send" to
        "보내기",
    "settings, language, about" to
        "설정, 언어, 정보",
    "signed and read back" to
        "서명 후 다시 읽음",
    "spent on the model, as FLOP's explorer sees it" to
        "모델에 쓴 FLOP, FLOP 익스플로러 기준",
    "start" to
        "시작",
    "the proof" to
        "증거",
    "to do" to
        "할 일",
    "today" to
        "오늘",
    "today's question: {q}" to
        "오늘의 질문: {q}",
    "trial over" to
        "체험 종료",
    "use an address I already have" to
        "이미 가진 주소 사용",
    "validators" to
        "검증자",
    "what is happening now" to
        "지금 일어나는 일",
    "what your wallet will show" to
        "지갑에 표시될 내용",
    "where flop stands" to
        "FLOP의 현재 위치",
    "your flop address" to
        "내 FLOP 주소",
    "{day} was missed and forgiven: one missed day a week is." to
        "{day}에 빠졌지만 용서됐습니다. 일주일에 하루는 용서됩니다.",
    "{h} h {m} min" to
        "{h}시간 {m}분",
    "{m} min" to
        "{m}분",
    "{n} d ago" to
        "{n}일 전",
    "{n} h ago" to
        "{n}시간 전",
    "{n} min ago" to
        "{n}분 전",
    "Today" to "오늘",
    "Ask" to "질문",
    "Network" to "네트워크",
    "{host} is on FLOP's official list." to "{host}은(는) FLOP 공식 목록에 있습니다.",
    "This is FLOP's own account on {host}." to "{host}에 있는 FLOP의 공식 계정입니다.",
    "This is on {host}, but not FLOP's account there. FLOP's is {account}." to "{host}이지만 그곳의 FLOP 계정은 아닙니다. FLOP의 계정은 {account}입니다.",
    "{host} uses the FLOP name but is not on FLOP's official list. Treat it as an impersonation." to "{host}은(는) FLOP 이름을 쓰지만 FLOP 공식 목록에 없습니다. 사칭으로 보세요.",
    "{host} is not FLOP. That does not make it bad, only not FLOP." to "{host}은(는) FLOP이 아닙니다. 나쁘다는 뜻이 아니라 FLOP이 아닐 뿐입니다.",
    // The faucet came back (2026-11-03).
    "The faucet works" to
        "포싯이 작동합니다",
    "FLOP's faucet gives each address 25 FLOP once every 24 hours. It can be slow: an answer may take a minute or two. The app waits for it and checks your balance." to
        "FLOP 포싯은 각 주소에 24시간마다 25 FLOP을 줍니다. 느릴 수 있어서 응답에 1~2분이 걸릴 수 있습니다. 앱이 응답을 기다리고 잔액을 확인합니다.",
    "Your FLOP comes from FLOP's faucet: 25 FLOP once every 24 hours. Press do my day and wait, the faucet can take a minute or two. If the balance stays 0, the faucet step says why." to
        "FLOP은 FLOP 포싯에서 옵니다. 24시간마다 25 FLOP입니다. ‘오늘 할 일 하기’를 누르고 기다리세요. 포싯은 1~2분이 걸릴 수 있습니다. 잔액이 계속 0이면 포싯 단계에 이유가 나옵니다.",
    // Review fixes before the 2.0 release (2026-11-03).
    "The faucet is limiting requests from your network right now. Nothing arrived; try again later." to
        "포싯이 지금 이 네트워크의 요청을 제한하고 있습니다. 아무것도 오지 않았습니다. 나중에 다시 시도하세요.",
    "FLOP's gateway sent a sign-in text this app does not recognise, so it was not signed. Nothing happened." to
        "FLOP 게이트웨이가 이 앱이 알 수 없는 로그인 문구를 보내서 서명하지 않았습니다. 아무 일도 일어나지 않았습니다.",
    "The faucet said no: {reason}" to
        "포싯이 거절했습니다: {reason}",
    "The gateway said no: {reason}" to
        "게이트웨이가 거절했습니다: {reason}",
    "The model did not answer: {reason}" to
        "모델이 답하지 않았습니다: {reason}",
    "Only https links can be FLOP's. Type FLOP's address yourself instead of following this one." to
        "FLOP의 링크는 https만 가능합니다. 이 링크를 열지 말고 FLOP 주소를 직접 입력하세요.",
    "Sign today to keep your streak. This week's one forgiven day is already used." to
        "연속 기록을 지키려면 오늘 서명하세요. 이번 주의 용서된 하루는 이미 썼습니다.",
    // The model allowance is what the gateway says, not a fixed number (2026-11-03).
    "On devnet FLOP gives each account one allowance to spend on the model within 24 hours, and needs at least 1 FLOP on the account to start it. The Ask tab shows how much is left. When it is over, it stays over until testnet." to
        "데브넷에서 FLOP은 각 계정에 24시간 동안 모델에 쓸 수 있는 한도를 하나 주며, 시작하려면 계정에 최소 1 FLOP이 있어야 합니다. 남은 양은 질문 탭에 나옵니다. 다 쓰면 테스트넷까지 닫혀 있습니다.",
    "FLOP gives each account one devnet allowance for 24 hours. The figure above is what is left of it. When it is over it is over until testnet." to
        "FLOP은 각 계정에 24시간짜리 데브넷 한도를 하나 줍니다. 위의 숫자가 그 남은 양입니다. 다 쓰면 테스트넷까지 닫혀 있습니다.",
    "It needs at least 1 FLOP on your Passport address first. On devnet each account also gets only one trial, for 24 hours. After that it stays closed until testnet. The Ask tab says which one it is." to
        "먼저 Passport 주소에 최소 1 FLOP이 있어야 합니다. 또한 데브넷에서는 계정마다 24시간짜리 체험이 한 번뿐입니다. 그 뒤에는 테스트넷까지 닫혀 있습니다. 어느 쪽인지는 질문 탭에 나옵니다.",
    "To use the model, your Passport signs a short statement from api.flop.network. That signature moves nothing. FLOP then opens an allowance for your account: on devnet one, for 24 hours, and your account needs at least 1 FLOP to start it. The Ask tab shows how much of it is left. An answer costs about 0.006 FLOP per word-piece, usually one or two FLOP. When the allowance ends, the model stays closed for that account until testnet." to
        "모델을 쓰려면 Passport가 api.flop.network에서 온 짧은 문장에 서명합니다. 이 서명은 아무것도 옮기지 않습니다. 그러면 FLOP이 계정에 한도를 엽니다. 데브넷에서는 하나, 24시간이며, 시작하려면 계정에 최소 1 FLOP이 있어야 합니다. 남은 양은 질문 탭에 나옵니다. 답변은 단어 조각당 약 0.006 FLOP으로, 보통 1~2 FLOP입니다. 한도가 끝나면 그 계정의 모델은 테스트넷까지 닫혀 있습니다.",
    // The faucet's two other refusals, seen 3-4 November 2026.
    "The faucet has your request in its queue and has not sent the FLOP yet. This can take a while. Press do my day again later." to
        "요청이 포싯 대기열에 있고 FLOP은 아직 보내지 않았습니다. 시간이 걸릴 수 있습니다. 나중에 ‘오늘 할 일 하기’를 다시 누르세요.",
    "The faucet has given out all of today's FLOP. Nothing arrived. It opens again within hours, so try later." to
        "포싯이 오늘의 FLOP을 모두 나눠 주었습니다. 아무것도 오지 않았습니다. 몇 시간 안에 다시 열리니 나중에 시도하세요.",
    "Signing today's line with your Passport and reading it back from technocore.chat…" to
        "오늘의 기록을 Passport로 서명하고 technocore.chat에서 다시 읽는 중…",
    "Asking FLOP's faucet. It serves about 10 people a minute, so this can take up to 2 minutes." to
        "FLOP 파우셋에 요청하는 중입니다. 분당 약 10명을 처리하므로 최대 2분이 걸릴 수 있습니다.",
    "You are in the faucet's queue. The app watches your balance and asks again by itself." to
        "파우셋 대기열에 있습니다. 앱이 잔액을 확인하며 자동으로 다시 요청합니다.",
    "Reading your balance…" to
        "잔액을 읽는 중…",
    "Sending your question to the model. It has up to 90 seconds to answer." to
        "질문을 모델에 보내는 중입니다. 모델은 최대 90초 안에 답합니다.",
    "FLOP's gateway is full right now: many people are asking at once. Nothing was spent. The app tries again by itself." to
        "지금 FLOP 게이트웨이가 가득 찼습니다. 많은 사람이 동시에 묻고 있습니다. 비용은 들지 않았습니다. 앱이 자동으로 다시 시도합니다.",
    "Your FLOP is still settling on the network. The app tries again by itself." to
        "FLOP이 아직 네트워크에서 확정되는 중입니다. 앱이 자동으로 다시 시도합니다.",
    "Reading what the answer cost…" to
        "답변 비용을 읽는 중…",
    "FLOP's gateway stayed full through every try. Nothing was spent. Try again in a few minutes." to
        "모든 시도에서 FLOP 게이트웨이가 가득 차 있었습니다. 비용은 들지 않았습니다. 몇 분 뒤 다시 시도하세요.",
    "{n} s so far" to
        "{n}초 경과",
    "try {n} of {m}" to
        "시도 {n}/{m}",
    "next try in {n} s" to
        "{n}초 후 다시 시도",
    "gateway ping {n} ms" to
        "게이트웨이 핑 {n} ms",
    "faucet ping {n} ms" to
        "파우셋 핑 {n} ms",
    "the gateway does not answer a ping" to
        "게이트웨이가 핑에 응답하지 않습니다",
    "the faucet does not answer a ping" to
        "파우셋이 핑에 응답하지 않습니다",
    "step {n} of 3" to
        "{n}/3단계",
    "ping" to
        "핑",
    "no answer" to
        "응답 없음",
    "last answer took" to
        "마지막 답변 소요 시간",
    "You can leave this screen: it keeps going." to
        "이 화면을 나가도 됩니다. 작업은 계속됩니다.",
    "Signing today's line" to
        "오늘의 한 줄에 서명하는 중",
    "Your Passport signs one short line in the public room and reads it back. That line is your day." to
        "Passport가 공개 공간에 짧은 한 줄에 서명하고 다시 읽어 옵니다. 그 한 줄이 오늘의 하루입니다.",
    "Asking FLOP's faucet" to
        "FLOP 파우셋에 요청하는 중",
    "The faucet pays about 10 people a minute. This can take up to two minutes." to
        "파우셋은 1분에 약 10명에게 지급합니다. 최대 2분까지 걸릴 수 있어요.",
    "Standing in the faucet's queue" to
        "파우셋 대기열에서 기다리는 중",
    "The faucet pays about 10 people a minute. Your request is in. We watch your balance and ask again by ourselves." to
        "파우셋은 1분에 약 10명에게 지급합니다. 요청이 접수되었어요. 잔액을 지켜보다가 저희가 알아서 다시 요청합니다.",
    "Your FLOP is on its way" to
        "FLOP이 오는 중이에요",
    "One moment." to
        "잠시만요.",
    "Opening the model" to
        "모델을 여는 중",
    "Your Passport signs the gateway's statement. Nothing is spent." to
        "Passport가 게이트웨이의 확인서에 서명합니다. 아무것도 쓰이지 않습니다.",
    "Asking the model" to
        "모델에 묻는 중",
    "Your question is with the model. It has up to 90 seconds." to
        "질문이 모델에 전달되었어요. 최대 90초가 걸립니다.",
    "The model is full right now" to
        "지금은 모델이 가득 찼어요",
    "Many people are asking at once. Nothing was spent. We try again by ourselves." to
        "많은 사람이 동시에 질문하고 있어요. 아무것도 쓰이지 않았습니다. 저희가 알아서 다시 시도합니다.",
    "Your FLOP is still settling" to
        "FLOP이 아직 반영되는 중이에요",
    "A fresh grant takes a moment to count. We try again by ourselves." to
        "새로 받은 FLOP이 집계되려면 잠시 걸려요. 저희가 알아서 다시 시도합니다.",
    "Reading what it cost" to
        "비용을 확인하는 중",
    "FLOP's gateway stayed full through all 6 tries. Nothing was spent. This is on FLOP's side, not yours." to
        "FLOP 게이트웨이가 6번 모두 가득 차 있었어요. 아무것도 쓰이지 않았습니다. FLOP 쪽 문제이고, 회원님 잘못이 아니에요.",
    "to next try" to
        "다음 시도까지",
    "elapsed {t}" to
        "경과 {t}",
    "ask the model" to
        "모델에게 질문",
    "Answered" to
        "답변 완료",
    "cost {c} FLOP · {s} s" to
        "비용 {c} FLOP · {s}초",
    "The model did not answer" to
        "모델이 답하지 않았어요",
    "your question" to
        "내 질문",
    "waiting" to
        "대기 중",
    "Connect your Passport" to
        "Passport 연결하기",
    "Get the answer" to
        "답변 받기",
    "minimise · it keeps going" to
        "최소화 · 계속 진행돼요",
    "my day · step {n} of 3" to
        "내 하루 · {n}/3단계",
    "my day" to
        "내 하루",
    "Your day is closed" to
        "오늘 하루를 마쳤어요",
    "See you tomorrow." to
        "내일 만나요.",
    "Today is signed" to
        "오늘 서명 완료",
    "not today" to
        "오늘은 아님",
    "Could not sign today" to
        "오늘 서명하지 못했어요",
    "Your day is signed. Your streak of {n} is safe whatever happens next." to
        "오늘 서명을 마쳤어요. 연속 기록 {n}은(는) 어떤 일이 있어도 안전해요.",
    "Today is not signed yet. One missed day a week is forgiven; two in a row end the streak." to
        "오늘은 아직 서명하지 않았어요. 일주일에 하루는 빠져도 괜찮지만, 이틀 연속 빠지면 기록이 끝나요.",
    "question of the day: {q}" to
        "오늘의 질문: {q}",
    "Part of your day waits" to
        "오늘의 일부가 기다리고 있어요",
    "passport · {name}" to
        "passport · {name}",
    "Days in a row: {n}" to
        "연속 일수: {n}",
    "Start your streak today" to
        "오늘 연속 기록을 시작하세요",
    "Registered {date} · day {n} with us" to
        "{date} 등록 · 함께한 지 {n}일째",
    "reading your days" to
        "하루하루를 읽는 중",
    "today signed" to
        "오늘 서명 완료",
    "sign today or the streak ends" to
        "오늘 서명하지 않으면 기록이 끊겨요",
    "today not signed yet" to
        "오늘 아직 서명 전",
    "in a row" to
        "연속",
    "{n} of 3" to
        "{n}/3",
    "Your Passport signs one public line. That line is your streak." to
        "Passport가 공개된 한 줄에 서명합니다. 그 한 줄이 연속 기록이 됩니다.",
    "From FLOP's faucet, once a day. Practice coins, no price." to
        "FLOP 파우셋에서 하루에 한 번. 연습용 코인이며 가격은 없어요.",
    "One question of the day, paid in FLOP." to
        "하루에 질문 하나, FLOP으로 지불해요.",
    "One press, all three steps in order. What is already done is skipped." to
        "한 번 누르면 세 단계가 차례로 진행돼요. 이미 끝난 단계는 건너뜁니다.",
    "devnet · practice network" to
        "devnet · 연습용 네트워크",
    "one key · two networks" to
        "키 하나 · 네트워크 둘",
    "Seeker wallet" to
        "Seeker 지갑",
    "Made the Passport with one signature. Brings it back on any phone." to
        "서명 한 번으로 Passport를 만들었어요. 어떤 폰에서든 되찾을 수 있어요.",
    "FLOP account" to
        "FLOP 계정",
    "The same key as a FLOP address. The faucet pays here; the model is paid from here." to
        "FLOP 주소로 표현한 같은 키예요. 파우셋은 여기로 지급하고, 모델 비용도 여기서 나가요.",
    "Registered" to
        "등록일",
    "Days in a row" to
        "연속 일수",
    "Best streak" to
        "최고 기록",
    "Signed days" to
        "서명한 날",
    "Balance, FLOP" to
        "잔액, FLOP",
    "Spent on the model, FLOP" to
        "모델에 쓴 금액, FLOP",
    "1 skip left this week" to
        "이번 주 건너뛰기 1회 남음",
    "this week's skip is used" to
        "이번 주 건너뛰기를 사용했어요",
    "details and key" to
        "자세히 · 키",
    "On Seeker · in FLOP Network · an app by Alex Kosa, not FLOP Labs, not Solana Mobile" to
        "Seeker에서 · FLOP 네트워크에서 · Alex Kosa의 앱이며 FLOP Labs나 Solana Mobile의 앱이 아니에요",
    "days signed together" to
        "함께 서명한 날",
    "flop pulse" to
        "flop 펄스",
    "Devnet is a practice network, open to everyone since 3 November. Coins have no price, there is no reward." to
        "Devnet은 연습용 네트워크로, 11월 3일부터 누구나 쓸 수 있어요. 코인에는 가격이 없고 보상도 없습니다.",
    "more about the network" to
        "네트워크 더 알아보기",
    "thanks to both sides" to
        "양쪽 모두에게 감사해요",
    "for Seeker, the wallet and one-tap signing" to
        "Seeker, 지갑, 한 번 터치로 하는 서명에 대해",
    "for the network, the faucet and a model you can pay" to
        "네트워크, 파우셋, 지불할 수 있는 모델에 대해",
    "An independent app by Alex Kosa. No promises about tokens or rewards." to
        "Alex Kosa가 만든 독립 앱이에요. 토큰이나 보상에 대한 약속은 없습니다.",
    "check a link, an @name or an address someone sent you" to
        "받은 링크, @이름, 주소를 확인하세요",
    "check" to
        "확인",
    "FLOP model" to
        "FLOP 모델",
    "The model is small: short, plain questions work best. Everything you pay is practice FLOP." to
        "모델은 작아요. 짧고 쉬운 질문이 가장 잘 맞아요. 지불하는 것은 모두 연습용 FLOP이에요.",
    "model open" to
        "모델 열림",
    "opening the model" to
        "모델 여는 중",
    "trial over for this account" to
        "이 계정의 체험이 끝났어요",
    "needs 1 flop" to
        "1 flop 필요",
    "model closed for now" to
        "모델 잠시 닫힘",
    "first question opens it" to
        "첫 질문이 열어요",
    "ping {n} ms" to
        "핑 {n}ms",
    "Your Passport signs a short statement from FLOP's gateway. Nothing moves. You need at least 1 FLOP; the faucet on Today gives you 25." to
        "Passport가 FLOP 게이트웨이의 짧은 확인서에 서명합니다. 아무것도 이동하지 않아요. 최소 1 FLOP이 필요하고, 오늘 탭의 파우셋이 25를 드려요.",
    "more" to
        "더보기",
    "That was the last step. Your Passport is live, and your day on FLOP starts now." to
        "마지막 단계였어요. Passport가 준비되었고, FLOP에서의 하루가 이제 시작돼요.",
    "Pulse" to
        "현황",
    "Who is here, and how FLOP's network is doing today." to
        "누가 여기 있고 오늘 FLOP 네트워크가 어떤지 보여줍니다.",
    "who is here" to
        "여기 있는 사람들",
    "Passport holders" to
        "Passport 보유자",
    "{n} Passport holders · {m} signed today" to
        "Passport 보유자 {n}명 · 오늘 서명 {m}명",
    "{n} of them signed today" to
        "그중 오늘 서명: {n}명",
    "To keep a streak, each holder signs one short public line a day. Counted from that public record, so anyone can repeat it." to
        "연속 기록을 이으려면 보유자마다 하루에 짧은 공개 문장 하나에 서명합니다. 이 공개 기록으로 집계하므로 누구나 다시 확인할 수 있습니다.",
    "same key" to
        "같은 키",
    "knock now" to
        "지금 두드리기",
    "A refused knock costs nothing. Knock as often as you like." to
        "거절돼도 비용은 없습니다. 원하는 만큼 두드리세요.",
    "FLOP spent on the model, all time" to
        "모델에 쓴 FLOP, 누적",
    "accounts that paid for the model" to
        "모델에 비용을 낸 계정",
    "Join FLOP with Alex's link" to
        "Alex의 링크로 FLOP 시작하기",
    "This is Alex Kosa's personal referral link from FLOP, and it may count for him. It gives you nothing extra from this app. Prefer not to? Go to flop.finance yourself." to
        "FLOP에서 받은 Alex Kosa의 개인 추천 링크이며 그의 실적으로 집계될 수 있습니다. 이 앱이 추가로 주는 것은 없습니다. 원하지 않으면 flop.finance로 직접 가세요.",
    "open {host}" to
        "{host} 열기",
)
