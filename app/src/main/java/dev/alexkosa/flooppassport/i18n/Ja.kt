package dev.alexkosa.flooppassport.i18n

/**
 * Japanese.
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
internal val JA_STRINGS: Map<String, String> = mapOf(
    "A message signed by your Passport, posted to a quiet room and then read back to prove it landed." to
        "Passportで署名したメッセージを静かなルームに投稿し、読み戻して到着を確認します。",
    "A once-a-day reminder to leave today's signed record." to "今日の署名済み記録を残すための、1日1回のリマインダー。",
    "A permanent note at an address derived from your key, so anyone can find and verify you later." to
        "鍵から導出したアドレスに残る恒久的なノートです。後から誰でも見つけて検証できます。",
    "A public note at an address derived from your key, so anyone can find and verify you later." to
        "鍵から導出されたアドレスに置かれる公開ノートです。後から誰でも見つけて検証できます。",
    "A signed record has to be left by hand, and a missed day cannot be filled in later." to
        "署名済み記録は手動で残す必要があり、記録しなかった日を後から埋めることはできません。",
    "A tip changes nothing about your Passport and nothing about any airdrop." to
        "チップはPassportにも、いかなるエアドロップにも影響しません。",
    "A tip changes nothing about your Passport, and nothing about any airdrop. It is a thank you, not a fee." to
        "チップはPassportにも、いかなるエアドロップにも影響しません。料金ではなく、謝意を示すものです。",
    "About" to "概要",
    "Accepted, but we could not read it back yet" to "受理されましたが、まだ読み戻せません",
    "Activity" to "アクティビティ",
    "Already checked in, found in the room" to "記録済みで、ルーム内に見つかりました",
    "Already published, read back just now" to "公開済みで、たった今読み戻しました",
    "Android is blocking notifications for this app. Turn them on in the system settings." to
        "Androidがこのアプリの通知をブロックしています。システム設定で通知をオンにしてください。",
    "Anyone can check it at the address in step 03. This app promises nothing about any allocation, and never will." to
        "ステップ03のアドレスで誰でも確認できます。このアプリは、いかなる割り当ても約束せず、今後も約束しません。",
    "Anyone holding it can sign as you" to "これを持つ人は本人として署名できます",
    "Anyone holding seed_hex can sign as this identity on Technocore." to
        "seed_hexを持つ人は、Technocore上でこのIDとして署名できます。",
    "Anyone with this can be you" to "これを持つ人は本人になれます",
    "Apply" to "適用",
    "Cancel" to "キャンセル",
    "Check in" to "記録を残す",
    "Check your connection and try again." to "接続を確認して、もう一度お試しください。",
    "Could not open the security prompt on this screen." to "この画面でセキュリティ確認を開けませんでした。",
    "Could not reach technocore.chat" to "technocore.chatに接続できませんでした",
    "Could not reach technocore.chat. This says nothing about your records, only about the connection." to
        "technocore.chatに接続できませんでした。これは接続に関する状態であり、記録の状態を示すものではありません。",
    "Could not reach the server." to "サーバーに接続できませんでした。",
    "Could not read the key back from secure storage" to "セキュアストレージから鍵を読み戻せませんでした",
    "Create" to "作成",
    "Create your Passport" to "Passportを作成",
    "Create your Passport first. There is nothing to show until something has been signed." to
        "先にPassportを作成してください。署名が行われるまで、表示するものはありません。",
    "Created my FLOP Passport on a Solana Seeker." to "Solana SeekerでFLOP Passportを作成しました。",
    "Daily activity" to "毎日のアクティビティ",
    "Daily reminder" to "毎日のリマインダー",
    "Delete it?" to "削除しますか？",
    "Delete the Passport and create it again from your wallet." to
        "Passportを削除し、ウォレットから再作成します。",
    "Deleting removes the Passport from this phone only. Anything already published may stay public, and the same wallet rebuilds the same identity - so this is not a way to undo anything." to
        "削除しても、この端末からPassportが消えるだけです。公開済みの内容は公開されたまま残ることがあり、同じウォレットから同じアイデンティティが再構築されるため、取り消す手段にはなりません。",
    "Deleting removes the Passport from this phone only. Anything already published stays public, and the same wallet rebuilds the same identity - so this is not a way to undo anything." to
        "削除されるのは、この端末上のPassportだけです。すでに公開されたものは公開されたままで、同じウォレットから同じIDが再構築されます。取り消しの手段ではありません。",
    "Derived from a Seed Vault signature, sealed by StrongBox on device." to
        "Seed Vaultの署名から導出し、端末上のStrongBoxで封印。",
    "Derived from a signature my wallet made inside Seed Vault, then sealed by StrongBox." to
        "ウォレットがSeed Vault内で生成した署名から導出し、StrongBoxで封印。",
    "Every language listed here has a full translation." to "ここに記載されているすべての言語には、完全な翻訳があります。",
    "FLOP Passport creates a Technocore identity from your Solana wallet and keeps the receipts." to
        "FLOP PassportはSolanaウォレットからTechnocore IDを作成し、証跡を保持します。",
    "FLOP Passport for Seeker" to "Seeker用FLOP Passport",
    "FLOP Passport for Seeker - private backup" to "Seeker用FLOP Passport - 非公開バックアップ",
    "FLOP Passport for Seeker by @AlexKosa1" to "@AlexKosa1によるSeeker用FLOP Passport",
    "FLOP Passport for Seeker. First signed check-in." to "Seeker用FLOP Passport。最初の署名済み記録。",
    "FLOP asked agents to do something useful. A signed record is what proves you did, and a day without one is a day nobody can check later." to
        "FLOPはエージェントに有用なことをするよう求めました。署名済み記録は実行したことの証明となり、記録のない日は後から誰も確認できません。",
    "Identity derived from your wallet signature" to "ウォレット署名から導出されたID",
    "Identity note published, first check in signed and verified on Technocore." to
        "IDノートを公開し、最初の記録を署名してTechnocore上で検証しました。",
    "Identity note published, first check in verified on Technocore." to
        "IDノートを公開し、最初の記録をTechnocore上で検証しました。",
    "Identity note published, first check in verified." to "IDノートを公開し、最初の記録を検証しました。",
    "It never asks for your wallet recovery phrase." to "ウォレットのリカバリーフレーズを求めることはありません。",
    "It promises nothing about any airdrop, and never will." to "いかなるエアドロップも約束せず、今後も約束しません。",
    "Keep this file offline. Never send it to anyone, including the app author." to
        "このファイルはオフラインで保管してください。アプリ作者を含め、誰にも送らないでください。",
    "Keep your record going" to "記録を継続する",
    "Key born in Seed Vault, sealed by StrongBox on device." to
        "Seed Vault内で生成され、端末のStrongBoxで封印された鍵。",
    "Language" to "言語",
    "Leave today's signed record on Technocore." to "今日の署名済み記録をTechnocoreに残します。",
    "Make your first signed check-in" to "最初の署名済み記録を残す",
    "My FLOP Passport, created on a Solana Seeker." to "Solana Seekerで作成したFLOP Passport。",
    "Next: create your Passport from your wallet." to "次へ：ウォレットからPassportを作成します。",
    "Next: make your first signed check-in." to "次へ：最初の署名済み記録を残します。",
    "Next: publish your identity so anyone can verify you." to "次へ：IDを公開し、誰でも検証できるようにします。",
    "Next: seal the key in this phone's secure storage." to "次へ：この端末のセキュアストレージに鍵を封印します。",
    "No account, no server of ours, no analytics." to "アカウント、自前のサーバー、分析機能はありません。",
    "No wallet on this phone opened the payment link." to "この端末のウォレットで支払いリンクを開けませんでした。",
    "No. Nothing was published." to "いいえ。何も公開されていません。",
    "Not checked yet." to "まだ確認していません。",
    "Nothing asked yet" to "まだ質問はありません",
    "Nothing found. If you signed something and it is not here, the room has been trimmed past it - which is normal, and exactly why this screen exists." to
        "何も見つかりませんでした。署名したものがここにない場合、ルームの整理によって削除されています。これは通常の動作であり、その確認のためにこの画面があります。",
    "Nothing signed today yet." to "今日はまだ何も署名していません。",
    "Only languages with a real translation are listed. A picker offering languages that all render English would say your language is supported and then prove otherwise on the next screen." to
        "実際の翻訳がある言語のみを表示しています。すべて英語で表示される言語を選択肢に含めると、対応言語と表示されても、次の画面では対応していないことになります。",
    "Opening a connection" to "接続を開始しています",
    "Opening your Solana wallet" to "Solanaウォレットを開いています",
    "Press Create again. Nothing was sent anywhere." to "もう一度「作成」を押してください。どこにも何も送信されていません。",
    "Protect" to "保護",
    "Protect it" to "保護する",
    "Publish" to "公開",
    "Publish your identity" to "IDを公開",
    "Published and read back from the server" to "公開し、サーバーから読み戻しました",
    "Published, read back, and vouched for by your key" to "公開、読み戻し、鍵による保証が完了しました",
    "Publishing your identity note to technocore.chat" to "IDノートをtechnocore.chatに公開しています",
    "Publishing your note" to "ノートを公開中",
    "Read from technocore.chat just now, not from this phone. Rooms are trimmed as they grow, so this is what anyone would find today." to
        "この端末ではなく、technocore.chatからたった今読み取りました。ルームは増加に伴って整理されるため、これが現時点で誰でも確認できる内容です。",
    "Reading your note" to "ノートを読み込み中",
    "Reading your records" to "記録を読み込み中",
    "Ready" to "準備完了",
    "Remind me once a day" to "1日1回通知する",
    "Sealed by Android Keystore" to "Android Keystoreで封印済み",
    "Sealed by StrongBox, this phone's separate security chip" to
        "この端末の独立したセキュリティチップ、StrongBoxで封印済み",
    "Sealed by this phone's trusted execution environment" to "この端末の信頼できる実行環境で封印済み",
    "Sealing the key in this device's secure storage" to "この端末のセキュアストレージに鍵を封印しています",
    "Sending your signed record" to "署名済み記録を送信中",
    "Sent, but not confirmed in the room yet" to "送信済みですが、まだルーム内で確認できません",
    "Settings" to "設定",
    "Show your private key" to "秘密鍵を表示",
    "Signed, accepted and found again in the room" to "署名、受理され、ルーム内で再確認されました",
    "Signing your first check-in and sending it" to "最初の記録に署名して送信しています",
    "Talking to the service" to "サービスと通信中",
    "Thanks for building this" to "開発への謝意を送る",
    "That was the last step. Your Passport is live." to "これが最後のステップです。Passportは公開されています。",
    "The identity is born inside Seed Vault and sealed by StrongBox on the phone." to
        "IDはSeed Vault内で生成され、端末のStrongBoxで封印されます。",
    "The key is sealed in this phone's secure storage, then read back and checked against your identity." to
        "鍵をこの端末のセキュアストレージに封印し、読み戻してIDと照合します。",
    "The server is busy. Trying again." to "サーバーが混み合っています。再試行しています。",
    "The stored key does not match your identity" to "保存された鍵がIDと一致しません",
    "The wallet did not complete the signature" to "ウォレットが署名を完了しませんでした",
    "There are no points here and no score. FLOP asked agents to do something useful, so what counts is a record a person can still open. A number invented by this app would be a different game." to
        "ここにポイントやスコアはありません。FLOPがエージェントに求めたのは有用な行為であり、意味を持つのは人が後から開ける記録です。このアプリが作った数字では、別のゲームになります。",
    "These 32 bytes are your FLOP Passport itself. Whoever holds them can sign as you on Technocore. Keep them offline and never send them to anyone, including us." to
        "この32バイトがFLOP Passportそのものです。これを持つ人はTechnocore上で本人として署名できます。オフラインで保管し、当方を含め誰にも送らないでください。",
    "This app is free and open source, and nobody paid for it. If it saved you an afternoon, a tip is welcome." to
        "このアプリは無料のオープンソースで、開発に対する報酬は受けていません。作業時間の節約になった場合は、チップを送ることができます。",
    "This is NOT your Solana wallet key. Your wallet's own key never leaves Seed Vault and this app has never seen it. What you are looking at is a separate key that signs only on Technocore." to
        "これはSolanaウォレットの鍵ではありません。ウォレット自体の鍵はSeed Vaultから出ず、このアプリが取得したこともありません。表示しているのは、Technocore上でのみ署名する別の鍵です。",
    "Try again. Nothing was posted." to "もう一度お試しください。何も投稿されていません。",
    "Try again. Nothing was published." to "もう一度お試しください。何も公開されていません。",
    "Use the phone's language" to "端末の言語を使用",
    "Wait a moment and press it again to re-check. Do not treat this as a failure." to
        "少し待ってから、もう一度押して再確認してください。失敗として扱う必要はありません。",
    "Wait a moment and press it again to re-check. Sending it as a new message would post twice in public." to
        "少し待ってから、もう一度押して再確認してください。新しいメッセージとして送ると、公開投稿が重複します。",
    "What is still provable" to "現在も証明できること",
    "Yes. Something is already visible to others." to "はい。すでに他の人から見える情報があります。",
    "You do not need this file to recover. The same Solana wallet that" to
        "復元にこのファイルは不要です。同じSolanaウォレットで",
    "You do not need this to recover. The same Solana wallet rebuilds the same Passport on any phone. This copy is for using the key somewhere else, on your own terms." to
        "復元にこれは不要です。同じSolanaウォレットから、どの端末でも同じPassportを再構築できます。このコピーは、自身の判断で別の場所から鍵を使用するためのものです。",
    "You have already checked in" to "すでに記録を残しています",
    "You have already left a record today." to "今日はすでに記録を残しています。",
    "You're all set" to "設定が完了しました",
    "Your Passport is born inside Seed Vault, the Seeker's hardware key store, from which a key cannot be extracted. On this phone it is then sealed by Android's secure storage. Signing itself happens in the app, not in hardware, because Android Keystore cannot hold this kind of key - so we say sealed, not signed, in hardware." to
        "Passportは、鍵を取り出せないSeekerのハードウェア鍵ストアであるSeed Vault内で生成されます。その後、この端末ではAndroidのセキュアストレージによって封印されます。Android Keystoreはこの種類の鍵を保持できないため、署名自体はハードウェアではなくアプリ内で行われます。そのため、ハードウェアで署名ではなく封印と表記しています。",
    "Your Passport is derived from one signature your wallet makes inside Seed Vault, the Seeker's hardware key store. The wallet key never leaves that hardware. The Passport key is computed from its signature in this app and then sealed by Android's secure storage - sealed, not signed, in hardware, because Android Keystore cannot hold this kind of key." to
        "Passportは、SeekerのハードウェアキーストアであるSeed Vault内でウォレットが生成する1つの署名から導出されます。ウォレットの鍵がそのハードウェアの外に出ることはありません。Passportの鍵は、このアプリ内でその署名から計算され、Androidのセキュアストレージで封印されます。Android Keystoreはこの種類の鍵を保持できないため、ハードウェア内で署名されるのではなく、封印されます。",
    "Your Passport is live" to "Passportは公開されています",
    "Your Passport is live and your first signed record is on Technocore. Anyone can verify it, and it stays yours." to
        "Passportは公開され、最初の署名済み記録がTechnocore上にあります。誰でも検証でき、所有者は変わりません。",
    "Your Passport is live." to "Passportは公開されています。",
    "Your key is never sent anywhere. Only you can export it." to
        "鍵が外部に送信されることはありません。エクスポートできるのは本人だけです。",
    "Your key never leaves this phone." to "鍵がこの端末から出ることはありません。",
    "Your wallet signs one statement. It is not a transaction and moves no funds. The same wallet rebuilds the same Passport on any device." to
        "ウォレットは1つの文に署名します。トランザクションではなく、資金は移動しません。同じウォレットから、どの端末でも同じPassportを再構築できます。",
    "active days" to "活動日数",
    "activity" to "アクティビティ",
    "address" to "アドレス",
    "agent: FLOP Passport for Seeker" to "エージェント：Seeker用FLOP Passport",
    "algorithm: Ed25519, did:key, 32-byte seed" to "アルゴリズム：Ed25519、did:key、32バイトシード",
    "built by a community builder" to "コミュニティ開発者による制作",
    "cancel" to "キャンセル",
    "change" to "変更",
    "checked" to "確認済み",
    "close" to "閉じる",
    "connection" to "接続",
    "content" to "内容",
    "continue" to "続行",
    "copy key" to "鍵をコピー",
    "create passport" to "passportを作成",
    "created this Passport rebuilds it on any device." to
        "このPassportを作成したウォレットから、どの端末でも再構築できます。",
    "danger zone" to "危険な操作",
    "day streak" to "連続日数",
    "delete passport from this phone" to "この端末からpassportを削除",
    "detail" to "詳細",
    "did anything go public?" to "何か公開されましたか？",
    "done" to "完了",
    "failed" to "失敗",
    "fetched again and matched exactly" to "再取得し、完全一致を確認",
    "fetched from the server on opening" to "起動時にサーバーから取得",
    "fingerprint" to "フィンガープリント",
    "floop-passport vault self-test" to "floop-passport 鍵ストア自己テスト",
    "identity" to "アイデンティティ",
    "identity note" to "IDノート",
    "last connection" to "前回の接続",
    "live" to "有効",
    "live records" to "公開中の記録",
    "matched on our nonce, not just our key" to "鍵だけでなく、固有のnonceも一致",
    "no thanks, continue" to "送らずに続行",
    "no, nothing was made public" to "いいえ、何も公開されていません",
    "nonce" to "ノンス",
    "not found" to "見つかりません",
    "not yet - the note alone is a claim, not a proof" to "まだです - ノートだけでは主張であり、証明ではありません",
    "off" to "オフ",
    "on" to "オン",
    "our exact bytes, no wallet prefix" to "ウォレット接頭辞なしの正確なバイト列",
    "passport for seeker" to "seeker用passport",
    "private key, 32 bytes, hex" to "秘密鍵、32バイト、16進数",
    "protect passport" to "passportを保護",
    "publish identity" to "IDを公開",
    "published" to "公開済み",
    "re-check with the server" to "サーバーで再確認",
    "re-checked when the app opened" to "アプリ起動時に再確認",
    "records the server still holds" to "サーバーに現在も残る記録",
    "recovery" to "復旧",
    "room" to "ルーム",
    "save my key" to "鍵を保存",
    "save to a file" to "ファイルに保存",
    "self test" to "自己テスト",
    "send a tip" to "チップを送る",
    "sequence" to "シーケンス",
    "settings" to "設定",
    "sign and check in" to "署名して記録を残す",
    "sign today's record" to "今日の記録に署名",
    "signed" to "署名済み",
    "signed and verified against your DID" to "署名済みで、DIDとの照合を完了",
    "storage" to "ストレージ",
    "support the builder" to "開発者を支援",
    "technocore.chat answered" to "technocore.chat が応答しました",
    "technocore.chat refused the note" to "technocore.chatがノートを拒否しました",
    "technocore.chat refused the signed write" to "technocore.chatが署名済み書き込みを拒否しました",
    "text" to "テキスト",
    "the same wallet rebuilds this identity anywhere" to "同じウォレットから、どこでもこのIDを再構築できます",
    "unconfirmed" to "未確認",
    "verified" to "検証済み",
    "verify it yourself" to "自身で検証",
    "version" to "バージョン",
    "vouched for" to "鍵による保証済み",
    "wallet" to "ウォレット",
    "wallet linked" to "ウォレット連携済み",
    "what this app never does" to "このアプリが行わないこと",
    "what to do" to "操作方法",
    "when" to "日時",
    "with a wallet prefix, which is fine and pinned" to "ウォレット接頭辞付きで、正常かつ固定済み",
    "working" to "処理中",
    "yes, a signed did-note line carries its hash" to "はい、署名済みdid-note行にハッシュが含まれます",
    "yes, delete" to "はい、削除",
    "yes, something is already public" to "はい、すでに何かが公開されています",
    "your identity" to "ID",
    "your private key" to "秘密鍵",
)
