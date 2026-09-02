package dev.alexkosa.flooppassport.i18n

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
    "A message signed by your Passport, posted to a quiet room and then read back to prove it landed." to
        "Passport로 암호학적 서명된 메시지를 조용한 방에 게시한 뒤 다시 읽어 도착했음을 증명합니다.",
    "A permanent note at an address derived from your key, so anyone can find and verify you later." to
        "키에서 파생된 주소에 남기는 영구 메모로, 나중에 누구나 신원을 찾아 검증할 수 있습니다.",
    "A tip changes nothing about your Passport and nothing about any airdrop." to
        "후원금은 Passport나 에어드롭에 아무 영향도 주지 않습니다.",
    "A tip changes nothing about your Passport, and nothing about any airdrop. It is a thank you, not a fee." to
        "후원금은 Passport나 에어드롭에 아무 영향도 주지 않습니다. 수수료가 아니라 감사의 표시입니다.",
    "About" to "정보",
    "Accepted, but we could not read it back yet" to "수락됐지만 아직 다시 읽지 못했습니다",
    "Activity" to "활동",
    "Already checked in, found in the room" to "이미 서명 기록을 남겼으며 방에서 확인했습니다",
    "Already published, read back just now" to "이미 게시됐으며 방금 다시 읽었습니다",
    "Anyone can check it at the address in step 03. This app promises nothing about any allocation, and never will." to
        "누구나 03단계의 주소에서 확인할 수 있습니다. 이 앱은 어떠한 할당도 약속하지 않으며 앞으로도 약속하지 않습니다.",
    "Anyone holding it can sign as you" to "이를 가진 사람은 누구나 사용자의 신원으로 서명할 수 있습니다",
    "Anyone holding seed_hex can sign as this identity on Technocore." to
        "seed_hex를 가진 사람은 누구나 Technocore에서 이 신원으로 서명할 수 있습니다.",
    "Anyone with this can be you" to "이를 가진 사람은 누구나 사용자의 신원이 될 수 있습니다",
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
    "Created my FLOP Passport on a Solana Seeker." to "Solana Seeker에서 FLOP Passport를 생성했습니다.",
    "Delete it?" to "삭제하시겠습니까?",
    "Delete the Passport and create it again from your wallet." to
        "Passport를 삭제하고 지갑에서 다시 생성하세요.",
    "Deleting removes the Passport from this phone only. Anything already published stays public, and the same wallet rebuilds the same identity - so this is not a way to undo anything." to
        "삭제하면 이 휴대전화에서만 Passport가 제거됩니다. 이미 게시된 내용은 계속 공개되며 같은 지갑으로 동일한 신원을 다시 만들 수 있으므로, 이 작업으로 이전 기록을 되돌릴 수는 없습니다.",
    "Every language listed here has a full translation." to "여기에 표시된 모든 언어는 전체 번역이 제공됩니다.",
    "FLOP Passport creates a Technocore identity from your Solana wallet and keeps the receipts." to
        "FLOP Passport는 Solana 지갑에서 Technocore 신원을 생성하고 확인 기록을 보관합니다.",
    "FLOP Passport for Seeker" to "Seeker용 FLOP Passport",
    "FLOP Passport for Seeker - private backup" to "Seeker용 FLOP Passport - 비공개 백업",
    "FLOP Passport for Seeker by @AlexKosa1" to "@AlexKosa1이 만든 Seeker용 FLOP Passport",
    "FLOP Passport for Seeker. First signed check-in." to "Seeker용 FLOP Passport. 첫 번째 서명 기록.",
    "Identity derived from your wallet signature" to "지갑 서명에서 파생된 신원",
    "Identity note published, first check in signed and verified on Technocore." to
        "신원 메모가 게시됐으며 첫 기록이 서명되고 Technocore에서 검증됐습니다.",
    "Identity note published, first check in verified on Technocore." to
        "신원 메모가 게시됐으며 첫 기록이 Technocore에서 검증됐습니다.",
    "Identity note published, first check in verified." to "신원 메모가 게시됐으며 첫 기록이 검증됐습니다.",
    "It never asks for your wallet recovery phrase." to "지갑 복구 문구를 요청하지 않습니다.",
    "It promises nothing about any airdrop, and never will." to
        "어떠한 에어드롭도 약속하지 않으며 앞으로도 약속하지 않습니다.",
    "Keep this file offline. Never send it to anyone, including the app author." to
        "이 파일은 오프라인으로 보관하세요. 앱 제작자를 포함해 누구에게도 보내지 마세요.",
    "Key born in Seed Vault, sealed by StrongBox on device." to
        "Seed Vault에서 생성되고 기기의 StrongBox로 봉인된 키입니다.",
    "Language" to "언어",
    "Make your first signed check-in" to "첫 번째 서명 기록 남기기",
    "My FLOP Passport, created on a Solana Seeker." to "Solana Seeker에서 생성한 FLOP Passport입니다.",
    "Next: create your Passport from your wallet." to "다음: 지갑에서 Passport를 생성하세요.",
    "Next: make your first signed check-in." to "다음: 첫 번째 서명 기록을 남기세요.",
    "Next: publish your identity so anyone can verify you." to "다음: 누구나 검증할 수 있도록 신원을 게시하세요.",
    "Next: seal the key in this phone's secure storage." to "다음: 이 휴대전화의 보안 키 저장소에 키를 봉인하세요.",
    "No account, no server of ours, no analytics." to "계정도, 자체 서버도, 분석 기능도 없습니다.",
    "No wallet on this phone opened the payment link." to "이 휴대전화의 지갑에서 결제 링크를 열지 못했습니다.",
    "No. Nothing was published." to "아니요. 게시된 내용은 없습니다.",
    "Not checked yet." to "아직 확인하지 않았습니다.",
    "Nothing asked yet" to "아직 요청한 내용이 없습니다",
    "Nothing found. If you signed something and it is not here, the room has been trimmed past it - which is normal, and exactly why this screen exists." to
        "찾은 내용이 없습니다. 서명한 항목이 여기에 없다면 방에서 오래된 기록이 정리된 것입니다. 이는 정상이며 바로 이 화면이 필요한 이유입니다.",
    "Nothing signed today yet." to "오늘은 아직 서명된 기록이 없습니다.",
    "Only languages with a real translation are listed. A picker offering languages that all render English would say your language is supported and then prove otherwise on the next screen." to
        "실제 번역이 있는 언어만 표시됩니다. 모든 언어를 영어로 표시하는 선택기는 해당 언어를 지원한다고 안내하지만 다음 화면에서는 그렇지 않음을 보여줍니다.",
    "Opening a connection" to "연결을 여는 중",
    "Opening your Solana wallet" to "Solana 지갑 여는 중",
    "Press Create again. Nothing was sent anywhere." to "생성을 다시 누르세요. 어디에도 전송된 내용은 없습니다.",
    "Protect" to "보호",
    "Protect it" to "보호하기",
    "Publish" to "게시",
    "Publish your identity" to "신원 게시",
    "Published and read back from the server" to "게시 후 서버에서 다시 읽었습니다",
    "Published, read back, and vouched for by your key" to "게시하고 다시 읽었으며 키로 보증했습니다",
    "Publishing your identity note to technocore.chat" to "technocore.chat에 신원 메모 게시 중",
    "Publishing your note" to "노트를 게시하는 중",
    "Read from technocore.chat just now, not from this phone. Rooms are trimmed as they grow, so this is what anyone would find today." to
        "이 휴대전화가 아니라 technocore.chat에서 방금 읽었습니다. 방은 커지면서 오래된 기록이 정리되므로, 현재 누구나 찾을 수 있는 내용은 이것입니다.",
    "Reading your note" to "노트를 읽는 중",
    "Reading your records" to "기록을 읽는 중",
    "Ready" to "준비됨",
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
    "Talking to the service" to "서비스와 통신하는 중",
    "Thanks for building this" to "제작자에게 감사 표시",
    "That was the last step. Your Passport is live." to "마지막 단계가 완료됐습니다. Passport가 활성화됐습니다.",
    "The identity is born inside Seed Vault and sealed by StrongBox on the phone." to
        "신원은 Seed Vault 안에서 생성되고 휴대전화의 StrongBox로 봉인됩니다.",
    "The key is sealed in this phone's secure storage, then read back and checked against your identity." to
        "키는 이 휴대전화의 보안 키 저장소에 봉인된 뒤 다시 읽어 신원과 대조됩니다.",
    "The server is busy. Trying again." to "서버가 사용 중입니다. 다시 시도합니다.",
    "The stored key does not match your identity" to "저장된 키가 신원과 일치하지 않습니다",
    "The wallet did not complete the signature" to "지갑이 서명을 완료하지 않았습니다",
    "There are no points here and no score. FLOP asked agents to do something useful, so what counts is a record a person can still open. A number invented by this app would be a different game." to
        "여기에는 포인트도 점수도 없습니다. FLOP는 에이전트에게 유용한 일을 요청했으므로 중요한 것은 사람이 계속 열어 볼 수 있는 기록입니다. 이 앱이 임의로 만든 숫자는 다른 게임일 뿐입니다.",
    "These 32 bytes are your FLOP Passport itself. Whoever holds them can sign as you on Technocore. Keep them offline and never send them to anyone, including us." to
        "이 32바이트가 FLOP Passport 자체입니다. 이를 가진 사람은 누구나 Technocore에서 사용자의 신원으로 서명할 수 있습니다. 오프라인으로 보관하고 저희를 포함해 누구에게도 보내지 마세요.",
    "This app is free and open source, and nobody paid for it. If it saved you an afternoon, a tip is welcome." to
        "이 앱은 무료 오픈 소스이며 제작비를 지원한 곳은 없습니다. 이 앱으로 시간을 절약했다면 후원할 수 있습니다.",
    "This is NOT your Solana wallet key. Your wallet's own key never leaves Seed Vault and this app has never seen it. What you are looking at is a separate key that signs only on Technocore." to
        "이것은 Solana 지갑 키가 아닙니다. 지갑의 키는 Seed Vault를 벗어나지 않으며 이 앱은 해당 키를 본 적이 없습니다. 지금 보고 있는 것은 Technocore에서만 서명하는 별도의 키입니다.",
    "Try again. Nothing was posted." to "다시 시도하세요. 게시된 내용은 없습니다.",
    "Try again. Nothing was published." to "다시 시도하세요. 공개된 내용은 없습니다.",
    "Use the phone's language" to "휴대전화의 언어 사용",
    "Wait a moment and press it again to re-check. Do not treat this as a failure." to
        "잠시 기다린 뒤 다시 눌러 확인하세요. 실패로 간주하지 마세요.",
    "Wait a moment and press it again to re-check. Sending it as a new message would post twice in public." to
        "잠시 기다린 뒤 다시 눌러 확인하세요. 새 메시지로 보내면 공개 기록이 두 번 게시됩니다.",
    "What is still provable" to "현재도 증명 가능한 항목",
    "Yes. Something is already visible to others." to "예. 이미 다른 사람이 볼 수 있는 내용이 있습니다.",
    "You do not need this file to recover. The same Solana wallet that" to
        "복구에 이 파일은 필요하지 않습니다. 동일한 Solana 지갑이",
    "You do not need this to recover. The same Solana wallet rebuilds the same Passport on any phone. This copy is for using the key somewhere else, on your own terms." to
        "복구에 이것은 필요하지 않습니다. 동일한 Solana 지갑으로 어느 휴대전화에서든 같은 Passport를 다시 만들 수 있습니다. 이 사본은 사용자가 원하는 방식으로 다른 곳에서 키를 사용하기 위한 것입니다.",
    "You have already checked in" to "이미 서명 기록을 남겼습니다",
    "You have already left a record today." to "오늘 이미 기록을 남겼습니다.",
    "You're all set" to "모든 설정이 완료됐습니다",
    "Your Passport is born inside Seed Vault, the Seeker's hardware key store, from which a key cannot be extracted. On this phone it is then sealed by Android's secure storage. Signing itself happens in the app, not in hardware, because Android Keystore cannot hold this kind of key - so we say sealed, not signed, in hardware." to
        "Passport는 키를 추출할 수 없는 Seeker의 하드웨어 키 저장소인 Seed Vault 안에서 생성됩니다. 이후 이 휴대전화에서는 Android의 보안 저장소로 봉인됩니다. Android Keystore는 이 종류의 키를 보관할 수 없으므로 서명 자체는 하드웨어가 아닌 앱에서 이루어집니다. 따라서 하드웨어에서 서명됐다고 하지 않고 봉인됐다고 표현합니다.",
    "Your Passport is live" to "Passport가 활성화됐습니다",
    "Your Passport is live and your first signed record is on Technocore. Anyone can verify it, and it stays yours." to
        "Passport가 활성화됐으며 첫 번째 서명 기록이 Technocore에 있습니다. 누구나 검증할 수 있으며 소유권은 사용자에게 있습니다.",
    "Your Passport is live." to "Passport가 활성화됐습니다.",
    "Your key never leaves this phone." to "키는 이 휴대전화를 벗어나지 않습니다.",
    "Your wallet signs one statement. It is not a transaction and moves no funds. The same wallet rebuilds the same Passport on any device." to
        "지갑은 하나의 문장에 서명합니다. 이는 거래가 아니며 자금을 이동하지 않습니다. 동일한 지갑으로 어느 기기에서든 같은 Passport를 다시 만들 수 있습니다.",
    "active days" to "활동 일수",
    "activity" to "활동",
    "address" to "주소",
    "agent: FLOP Passport for Seeker" to "에이전트: Seeker용 FLOP Passport",
    "algorithm: Ed25519, did:key, 32-byte seed" to "알고리즘: Ed25519, did:key, 32바이트 시드",
    "built by a community builder" to "커뮤니티 개발자가 제작",
    "cancel" to "취소",
    "change" to "변경",
    "checked" to "확인됨",
    "close" to "닫기",
    "connection" to "연결",
    "content" to "내용",
    "continue" to "계속",
    "copy key" to "키 복사",
    "create passport" to "Passport 생성",
    "created this Passport rebuilds it on any device." to
        "이 Passport를 생성한 지갑으로 어느 기기에서든 다시 만들 수 있습니다.",
    "danger zone" to "주의 영역",
    "day streak" to "연속 활동 일수",
    "delete passport from this phone" to "이 휴대전화에서 Passport 삭제",
    "detail" to "세부 정보",
    "did anything go public?" to "공개된 내용이 있습니까?",
    "done" to "완료",
    "failed" to "실패",
    "fetched again and matched exactly" to "다시 가져와 정확히 일치함",
    "fetched from the server on opening" to "열 때 서버에서 가져옴",
    "fingerprint" to "지문",
    "floop-passport vault self-test" to "floop-passport 키 저장소 자체 테스트",
    "identity" to "신원",
    "identity note" to "신원 메모",
    "last connection" to "마지막 연결",
    "live" to "활성",
    "live records" to "현재 공개 기록",
    "matched on our nonce, not just our key" to "키뿐 아니라 자체 nonce도 일치함",
    "no thanks, continue" to "후원하지 않고 계속",
    "no, nothing was made public" to "아니요, 공개된 내용 없음",
    "not found" to "찾을 수 없음",
    "not yet - the note alone is a claim, not a proof" to "아직 아님 - 메모만으로는 주장일 뿐 증명이 아님",
    "our exact bytes, no wallet prefix" to "지갑 접두사 없이 정확한 원본 바이트",
    "passport for seeker" to "Seeker용 Passport",
    "private key, 32 bytes, hex" to "개인 키, 32바이트, 16진수",
    "protect passport" to "Passport 보호",
    "publish identity" to "신원 게시",
    "published" to "게시됨",
    "re-check with the server" to "서버에서 다시 확인",
    "re-checked when the app opened" to "앱을 열 때 다시 확인함",
    "records the server still holds" to "서버에 아직 남아 있는 기록",
    "recovery" to "복구",
    "room" to "공간",
    "save my key" to "키 저장",
    "save to a file" to "파일로 저장",
    "self test" to "자체 테스트",
    "send a tip" to "후원금 보내기",
    "sequence" to "순서",
    "settings" to "설정",
    "sign and check in" to "서명하고 기록 남기기",
    "sign today's record" to "오늘 기록에 서명",
    "signed" to "서명됨",
    "signed and verified against your DID" to "암호학적으로 서명되고 DID와 대조해 검증됨",
    "storage" to "저장소",
    "support the builder" to "개발자 후원",
    "technocore.chat answered" to "technocore.chat이 응답했습니다",
    "technocore.chat refused the note" to "technocore.chat에서 메모를 거부함",
    "technocore.chat refused the signed write" to "technocore.chat에서 서명된 쓰기를 거부함",
    "text" to "텍스트",
    "the same wallet rebuilds this identity anywhere" to "동일한 지갑으로 어디서든 이 신원을 다시 생성",
    "unconfirmed" to "미확인",
    "verified" to "검증됨",
    "verify it yourself" to "직접 검증",
    "version" to "버전",
    "vouched for" to "보증됨",
    "wallet" to "지갑",
    "wallet linked" to "지갑 연결됨",
    "what this app never does" to "이 앱이 하지 않는 일",
    "what to do" to "해야 할 일",
    "when" to "시각",
    "with a wallet prefix, which is fine and pinned" to "허용되고 고정된 지갑 접두사 포함",
    "working" to "처리 중",
    "yes, a signed did-note line carries its hash" to "예, 서명된 did-note 줄에 해시가 포함됨",
    "yes, delete" to "예, 삭제",
    "yes, something is already public" to "예, 이미 공개된 내용 있음",
    "your identity" to "사용자 신원",
    "your private key" to "사용자 개인 키",
)
