package dev.alexkosa.floppassport.i18n

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
    "06  tell them" to "06  伝える",
    "5 of 6" to "6のうち5",
    "A few more words, and it is yours. One real sentence is all this needs." to
        "あと少し書けば、その一行はあなたのものです。本当の一文があれば十分です。",
    "A few reminders about the last step, and then they stop." to "最後の手順についての数回の通知。そのあとは止まります。",
    "A little too long. Trim it and the whole post fits, key included." to
        "少し長すぎます。短くすれば、鍵も含めて投稿全体が収まります。",
    "A once-a-day reminder to leave today's signed record." to "今日の署名済み記録を残すための、1日1回のリマインダー。",
    "A public note at an address derived from your key, so anyone can find and verify you later. This one goes to technocore.chat, which is someone else's public service: when it is busy it refuses, and pressing again is the answer. Two or three attempts is normal and means nothing is wrong with your phone." to
        "あなたの鍵から算出したアドレスに置く公開ノートです。あとから誰でもあなたを見つけ、検証できるようになります。この手順はtechnocore.chatに送られます。他者が運営する公開サービスなので、混んでいるときは拒否され、その答えはもう一度押すことです。二、三回試すのはふつうで、端末に問題がないという意味です。",
    "A signed record has to be left by hand, and a missed day cannot be filled in later. This is also the switch that warns you before your identity note is deleted." to
        "署名付き記録は手動で残す必要があり、記録し忘れた日は後から埋められません。この設定は、IDノートが削除される前に警告する機能も兼ねています。",
    "A tip changes nothing about your Passport and nothing about any airdrop." to
        "チップはPassportにも、いかなるエアドロップにも影響しません。",
    "A tip changes nothing about your Passport, and nothing about any airdrop. It is a thank you, not a fee." to
        "チップはPassportにも、いかなるエアドロップにも影響しません。料金ではなく、謝意を示すものです。",
    "About" to "概要",
    "Accepted, but we could not read it back yet" to "受理されましたが、まだ読み戻せません",
    "Activity" to "アクティビティ",
    "All six done" to "六つすべて完了",
    "Already checked in, found in the room" to "記録済みで、ルーム内に見つかりました",
    "Already published, read back just now" to "公開済みで、たった今読み戻しました",
    "Android is blocking notifications for this app. Turn them on in the system settings." to
        "Androidがこのアプリの通知をブロックしています。システム設定で通知をオンにしてください。",
    "Anyone can check it at the address in step 03. This app promises nothing about any allocation, and never will." to
        "ステップ03のアドレスで誰でも確認できます。このアプリは、いかなる割り当ても約束せず、今後も約束しません。",
    "Anyone holding it can sign as you" to "これを持つ人はあなたとして署名できます",
    "Anyone holding seed_hex can sign as this identity on Technocore." to
        "seed_hexを持つ人は、Technocore上でこのIDとして署名できます。",
    "Anyone who looks it up sees a key and nothing else." to "調べた人に見えるのは鍵だけで、ほかには何もありません。",
    "Anyone with this can be you" to "これを持つ人はあなたになれます",
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
    "Daily activity" to "毎日のアクティビティ",
    "Daily reminder" to "毎日のリマインダー",
    "Delete it?" to "削除しますか？",
    "Deleting removes the Passport from this phone only. Anything already published may stay public, and the same wallet rebuilds the same identity - so this is not a way to undo anything." to
        "削除しても、この端末からPassportが消えるだけです。公開済みの内容は公開されたまま残ることがあり、同じウォレットから同じIDが再構築されるため、取り消す手段にはなりません。",
    "Did you post it?" to "投稿しましたか？",
    "Every language listed here has a full translation." to "ここに記載されているすべての言語には、完全な翻訳があります。",
    "FLOP Passport creates a Technocore identity from your Solana wallet and keeps the receipts." to
        "FLOP PassportはSolanaウォレットからTechnocore IDを作成し、証跡を保持します。",
    "FLOP Passport for Seeker" to "Seeker用FLOP Passport",
    "FLOP Passport for Seeker - private backup" to "Seeker用FLOP Passport - 非公開バックアップ",
    "FLOP Passport for Seeker by @AlexKosa1" to "@AlexKosa1によるSeeker用FLOP Passport",
    "FLOP asked agents to do two things: create a unique key, and do something useful to spread the word about Technocore. The five steps above did the first. Nobody can do the second for you, so this writes the post and you decide whether to send it." to
        "FLOPはエージェントに2つのことを求めました。固有の鍵を作ること、そしてTechnocoreを広めるために役立つことをすることです。上の5つのステップで1つ目は完了しました。2つ目は誰にも代わりにできないので、このアプリが投稿文を作り、送るかどうかはあなたが決めます。",
    "Identity derived from your wallet signature" to "ウォレット署名から導出されたID",
    "If it does get deleted, your Passport is not gone: the same wallet still gives the same identity, and signing a record publishes the note back to the same address." to
        "削除されてもPassportは失われません。同じウォレットから同じIDが得られ、記録に署名すると、同じアドレスにノートが再公開されます。",
    "In one line: what you did, or why you set this up" to "一行で。何をしたか、あるいはなぜ作ったか",
    "It never asks for your wallet recovery phrase." to "ウォレットのリカバリーフレーズを求めることはありません。",
    "It promises nothing about any airdrop, and never will." to "いかなるエアドロップも約束せず、今後も約束しません。",
    "Keep this file offline. Never send it to anyone, including the app author." to
        "このファイルはオフラインで保管してください。アプリ作者を含め、誰にも送らないでください。",
    "Language" to "言語",
    "Last reminder about this one." to "この件の通知はこれで最後です。",
    "Make your first signed check-in" to "最初の署名済み記録を残す",
    "Next: create your Passport from your wallet." to "次へ：ウォレットからPassportを作成します。",
    "Next: make your first signed check-in." to "次へ：最初の署名済み記録を残します。",
    "Next: publish your identity so anyone can verify you." to "次へ：IDを公開し、誰でも検証できるようにします。",
    "Next: seal the key in this phone's secure storage." to "次へ：この端末のセキュアストレージに鍵を封印します。",
    "No account, no server of ours, no analytics." to "アカウント、自前のサーバー、分析機能はありません。",
    "No wallet on this phone opened the payment link." to "この端末のウォレットで支払いリンクを開けませんでした。",
    "No. Nothing was published." to "いいえ。何も公開されていません。",
    "Not checked yet." to "まだ確認していません。",
    "Not done. Your Passport is not attached to any public name yet, and this is the one step nobody can do for you." to
        "まだです。あなたのPassportはどの公開名にも結び付いていません。そしてこれは、誰も代わりにできない手順です。",
    "Nothing asked yet" to "まだ何も問い合わせていません",
    "Nothing found. If you signed something and it is not here, the room has been trimmed past it - which is normal, and exactly why this screen exists." to
        "何も見つかりませんでした。署名したものがここにない場合、ルームの整理によって削除されています。これは通常の動作であり、その確認のためにこの画面があります。",
    "Nothing has vouched for this text yet. Publish again to sign for it." to
        "このテキストを保証するものはまだありません。署名するにはもう一度公開してください。",
    "Nothing is broken and nothing is lost. Your Passport works. When you want the public half of it, step 06 is waiting where you left it." to
        "壊れたものも、失われたものもありません。あなたのPassportは動いています。公開される側の半分が必要になったら、手順06は置いてきた場所で待っています。",
    "Nothing signed today yet." to "今日はまだ何も署名していません。",
    "One step left" to "あと一手順です",
    "Only languages with a real translation are listed. A picker offering languages that all render English would say your language is supported and then prove otherwise on the next screen." to
        "実際の翻訳がある言語のみを表示しています。すべて英語で表示される言語を選択肢に含めると、対応言語と表示されても、次の画面では対応していないことになります。",
    "Opening a connection" to "接続を開始しています",
    "Opening your Solana wallet" to "Solanaウォレットを開いています",
    "Post your line, then come back and paste the link. That is what attaches your name to your key, and it is the half FLOP asked agents for." to
        "自分の一行を投稿し、戻ってリンクを貼ってください。それがあなたの名前を鍵に結び付けます。FLOPがエージェントに求めた半分は、これです。",
    "Protect" to "保護",
    "Protect it" to "保護する",
    "Publish" to "公開",
    "Publish your identity" to "IDを公開",
    "Published and read back from the server" to "公開し、サーバーから読み戻しました",
    "Published, read back, and vouched for by your key" to "公開、読み戻し、鍵による保証が完了しました",
    "Publishing your identity note to technocore.chat" to "IDノートをtechnocore.chatに公開しています",
    "Publishing your note" to "ノートを公開中",
    "Questions, answered in full" to "疑問への詳しい答え",
    "Read from technocore.chat just now, not from this phone. Rooms are trimmed as they grow, so this is what anyone would find today." to
        "この端末ではなく、technocore.chatからたった今読み取りました。ルームは増加に伴って整理されるため、これが現時点で誰でも確認できる内容です。",
    "Reading your note" to "ノートを読み込み中",
    "Reading your records" to "記録を読み込み中",
    "Ready" to "準備完了",
    "Remind me once a day" to "1日1回通知する",
    "Renewed today. technocore.chat keeps it for seven days after the last write, and this app rewrites it every time you open it." to
        "今日更新されました。technocore.chatでは最後の書き込みから七日間保持され、このアプリを開くたびに書き直されます。",
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
    "Somebody changed this note after your key signed for it. Publish again." to
        "鍵が保証した後で、誰かがこのノートを書き換えました。もう一度公開してください。",
    "Still one step short" to "まだ一手順足りません",
    "Talking to the service" to "サービスと通信中",
    "Thanks for building this" to "開発への謝意を送る",
    "That does not look like a link to a post. It should look like https://x.com/you/status/123." to
        "投稿へのリンクではないようです。https://x.com/you/status/123 のような形式にしてください。",
    "The key is sealed in this phone's secure storage, then read back and checked against your identity." to
        "鍵をこの端末のセキュアストレージに封印し、読み戻してIDと照合します。",
    "The manual" to "マニュアル",
    "The server is busy. Trying again." to "サーバーが混み合っています。再試行しています。",
    "The stored key does not match your identity" to "保存された鍵がIDと一致しません",
    "The wallet did not complete the signature" to "ウォレットが署名を完了しませんでした",
    "There are no points here and no score. FLOP asked agents to do something useful, so what counts is a record a person can still open. A number invented by this app would be a different game." to
        "ここにポイントやスコアはありません。FLOPがエージェントに求めたのは有用な行為であり、意味を持つのは人が後から開ける記録です。このアプリが作った数字では、別のゲームになります。",
    "These 32 bytes are your FLOP Passport itself. Whoever holds them can sign as you on Technocore. Keep them offline and never send them to anyone, including us." to
        "この32バイトがFLOP Passportそのものです。これを持つ人はTechnocore上であなたとして署名できます。オフラインで保管し、当方を含め誰にも送らないでください。",
    "This app is free and open source, and nobody paid for it. If it saved you an afternoon, a tip is welcome." to
        "このアプリは無料のオープンソースで、開発に対する報酬は受けていません。作業時間の節約になった場合は、チップを送ることができます。",
    "This app is free and open source. If it was useful, you can send a tip to {name}. Your wallet opens and you choose the amount there." to
        "このアプリは無料のオープンソースです。役に立った場合は、{name}にチップを送れます。ウォレットが開き、金額はそこで選びます。",
    "This app rewrites your note every time you open it and every time you sign a record, so the seven days start again. Open it at least once a week and nothing is ever lost." to
        "このアプリは、開くたび、また記録に署名するたびにノートを書き直すため、七日間の期限が再び始まります。少なくとも週に一度開けば、何も失われません。",
    "This is NOT your Solana wallet key. Your wallet's own key never leaves Seed Vault and this app has never seen it. What you are looking at is a separate key that signs only on Technocore." to
        "これはSolanaウォレットの鍵ではありません。ウォレット自体の鍵はSeed Vaultから出ず、このアプリが取得したこともありません。表示しているのは、Technocore上でのみ署名する別の鍵です。",
    "This line is what makes the post yours. Everything under it is the proof." to
        "この一文が、この投稿をあなたのものにします。その下はすべて証拠です。",
    "Three days left before it is deleted." to "削除まであと三日です。",
    "Today cannot be added later" to "今日は、あとから足せません",
    "Told only when your identity note is days away from being deleted." to
        "IDノートが削除される数日前にのみ通知されます。",
    "Tomorrow is the last day." to "明日が最後の日です。",
    "Two days left before it is deleted." to "削除まであと二日です。",
    "Unfinished setup" to "未完了の設定",
    "Use the phone's language" to "端末の言語を使用",
    "Wait a moment and press it again to re-check. Do not treat this as a failure." to
        "少し待ってから、もう一度押して再確認してください。失敗として扱う必要はありません。",
    "Wait a moment and press it again to re-check. Sending it as a new message would post twice in public." to
        "少し待ってから、もう一度押して再確認してください。新しいメッセージとして送ると、公開投稿が重複します。",
    "What is still provable" to "現在も証明できること",
    "What recovery without a seed phrase costs" to "シードフレーズなしで復元できることの代償",
    "What to do and how often, why the identity expires, why this works on a Seeker, and what the catch is. Opens in your browser." to
        "何をどのくらいの頻度でするのか、なぜIDに有効期限があるのか、なぜSeekerで使えるのか、注意点は何か。ブラウザで開きます。",
    "Write one line only you would write. Posts that differ from each other by nothing but a key get read as farming, and that lands on the people who did the work." to
        "あなたにしか書けない一行を書いてください。互いに鍵しか違わない投稿はファーミングとして読まれ、割を食うのは実際に手を動かした人です。",
    "Yes. Something is already visible to others." to "はい。すでに他の人から見える情報があります。",
    "You do not need this file to recover. The same Solana wallet that" to
        "復元にこのファイルは不要です。このPassportを作成した同じSolanaウォレットが",
    "You do not need this to recover. The same Solana wallet rebuilds the same Passport on any phone. This copy is for using the key somewhere else, on your own terms." to
        "復元にこれは不要です。同じSolanaウォレットから、どの端末でも同じPassportを再構築できます。このコピーは、自身の判断で別の場所から鍵を使用するためのものです。",
    "You finished the five. The last one takes a minute." to "五つは終わりました。最後は一分で済みます。",
    "You have already checked in" to "すでに記録を残しています",
    "You have already left a record today." to "今日はすでに記録を残しています。",
    "You're all set" to "設定が完了しました",
    "Your Passport has no name on it" to "あなたのPassportに名前がありません",
    "Your Passport is derived from one signature your wallet makes inside Seed Vault, the Seeker's hardware key store. The wallet key never leaves that hardware. The Passport key is computed from its signature in this app and then sealed by Android's secure storage - sealed, not signed, in hardware, because Android Keystore cannot hold this kind of key." to
        "Passportは、SeekerのハードウェアキーストアであるSeed Vault内でウォレットが生成する1つの署名から導出されます。ウォレットの鍵がそのハードウェアの外に出ることはありません。Passportの鍵は、このアプリ内でその署名から計算され、Androidのセキュアストレージで封印されます。Android Keystoreはこの種類の鍵を保持できないため、ハードウェア内で署名されるのではなく、封印されます。",
    "Your Passport is live" to "Passportは有効です",
    "Your Passport is live and your first signed record is on Technocore. Anyone can verify it, and it stays yours." to
        "Passportは有効になり、最初の署名済み記録がTechnocore上にあります。誰でも検証でき、所有者は変わりません。",
    "Your Passport is live. One step left." to "あなたのPassportは有効です。あと一手順です。",
    "Your Passport is rebuilt from one wallet signature, which is why no seed phrase exists to lose. The same fact cuts the other way: any app that persuades your wallet to sign that exact sentence can rebuild this Passport. Read what a wallet asks you to sign, here and everywhere else." to
        "Passportはウォレットの署名ひとつから再構成されます。だから失うシードフレーズがありません。同じことは逆にも働きます。まったく同じ文にウォレットで署名させられるアプリは、このPassportを再構成できます。ウォレットが何に署名を求めているかを、ここでも、ほかのどこでも読んでください。",
    "Your identity note expires soon" to "IDノートの有効期限が近づいています",
    "Your identity note has been deleted" to "IDノートが削除されました",
    "Your key is never sent anywhere. Only you can export it." to
        "鍵が外部に送信されることはありません。エクスポートできるのはあなただけです。",
    "Your key signed a line carrying this note's exact hash." to
        "あなたの鍵が、このノートの正確なハッシュを含む行に署名しました。",
    "Your note has to be kept alive" to "ノートを維持する必要があります",
    "Your post is in your identity note, at your key's own address." to
        "あなたの投稿は、あなたの鍵自身のアドレスにあるIDノートの中にあります。",
    "Your wallet signs one statement. It is not a transaction and moves no funds. The same wallet rebuilds the same Passport on any device." to
        "ウォレットは1つの文に署名します。トランザクションではなく、資金は移動しません。同じウォレットから、どの端末でも同じPassportを再構築できます。",
    "active days" to "活動日数",
    "activity" to "アクティビティ",
    "address" to "アドレス",
    "algorithm: Ed25519, did:key, 32-byte seed" to "アルゴリズム：Ed25519、did:key、32バイトシード",
    "attach it" to "結び付ける",
    "built by a community builder" to "コミュニティ開発者による制作",
    "cancel" to "キャンセル",
    "change" to "変更",
    "changed" to "変更あり",
    "check again" to "もう一度確認する",
    "checked" to "確認済み",
    "close" to "閉じる",
    "connection" to "接続",
    "content" to "内容",
    "continue" to "続行",
    "copy" to "コピー",
    "copy key" to "鍵をコピー",
    "create passport" to "Passportを作成",
    "created this Passport rebuilds it on any device." to
        "どの端末でも同じPassportを再構築します。",
    "danger zone" to "危険な操作",
    "day streak" to "連続日数",
    "delete passport from this phone" to "この端末からPassportを削除",
    "detail" to "詳細",
    "did anything go public?" to "何か公開されましたか？",
    "done" to "完了",
    "failed" to "失敗",
    "fetched again and matched exactly" to "再取得し、完全一致を確認",
    "fetched from the server on opening" to "起動時にサーバーから取得",
    "fingerprint" to "フィンガープリント",
    "flop-passport vault self-test" to "flop-passport鍵ストア自己テスト",
    "identity" to "ID",
    "identity note" to "IDノート",
    "language {code}" to "言語 {code}",
    "last connection" to "前回の接続",
    "linked" to "リンク済み",
    "live records" to "公開中の記録",
    "matched on our nonce, not just our key" to "鍵だけでなく、こちらのノンスも一致",
    "no thanks, continue" to "送らずに続行",
    "no, nothing was made public" to "いいえ、何も公開されていません",
    "nonce" to "ノンス",
    "not found" to "見つかりません",
    "not yet" to "まだです",
    "not yet - the note alone is a claim, not a proof" to "まだです。ノートだけでは主張であり、証明ではありません",
    "off" to "オフ",
    "on" to "オン",
    "open" to "開く",
    "our exact bytes, no wallet prefix" to "ウォレット接頭辞なしの正確なバイト列",
    "passport for seeker" to "Seeker用Passport",
    "pin it to your identity" to "自分のIDに固定",
    "private key, 32 bytes, hex" to "秘密鍵、32バイト、16進数",
    "protect passport" to "Passportを保護",
    "publish identity" to "IDを公開",
    "published" to "公開済み",
    "publishing" to "公開中",
    "re-check with the server" to "サーバーで再確認",
    "re-checked when the app opened" to "アプリ起動時に再確認",
    "records the server still holds" to "サーバーに現在も残る記録",
    "recovery" to "復元",
    "room" to "ルーム",
    "save to a file" to "ファイルに保存",
    "say it another way" to "別の言い方にする",
    "self test" to "自己テスト",
    "send a tip" to "チップを送る",
    "send a tip in {token}" to "{token}でチップを送る",
    "send a tip to {name}" to "{name}にチップを送る",
    "sequence" to "シーケンス",
    "settings" to "設定",
    "sign and check in" to "署名して記録を残す",
    "sign today's record" to "今日の記録に署名",
    "signed" to "署名済み",
    "signed and verified against your DID" to "署名済みで、DIDとの照合を完了",
    "step {n} {title} complete" to "手順 {n} {title} 完了",
    "step {n} {title} did not finish" to "手順 {n} {title} 未完了",
    "storage" to "ストレージ",
    "support the builder" to "開発者を支援",
    "technocore.chat answered" to "technocore.chatが応答しました",
    "technocore.chat deletes anything nobody has written to for seven days. That includes the identity note at the address you save and share." to
        "technocore.chatでは、誰も七日間書き込まなかったものは削除されます。保存して共有するアドレスにあるIDノートも対象です。",
    "technocore.chat refused the note" to "technocore.chatがノートを拒否しました",
    "technocore.chat refused the signed write" to "technocore.chatが署名済み書き込みを拒否しました",
    "text" to "テキスト",
    "the note changed between reads" to "二回の読み取りの間にノートが変わりました",
    "the post" to "投稿",
    "the same wallet rebuilds this identity anywhere" to "同じウォレットから、どこでもこのIDを再構築できます",
    "try again" to "もう一度試す",
    "unconfirmed" to "未確認",
    "unsigned" to "未署名",
    "verified" to "検証済み",
    "verify it yourself" to "自身で検証",
    "version" to "バージョン",
    "vouched for" to "鍵による保証済み",
    "wallet" to "ウォレット",
    "wallet linked" to "ウォレット連携済み",
    "what this app never does" to "このアプリが行わないこと",
    "what to do" to "操作方法",
    "when" to "日時",
    "working" to "処理中",
    "yes, a signed did-note line carries its hash" to "はい、署名済みdid-note行にハッシュが含まれます",
    "yes, delete" to "はい、削除",
    "yes, something is already public" to "はい、すでに何かが公開されています",
    "your identity" to "ID",
    "your private key" to "秘密鍵",
    "{token} is preselected and you can switch it." to "{token}が選択済みです。変更もできます。",
    "Try again. Nothing was sent anywhere." to
        "もう一度お試しください。どこにも何も送られていません。",
    "Try again. technocore.chat is a public service and it refuses writes when it is busy, which has nothing to do with this app, your phone or your key. Two or three attempts is normal. Nothing was published." to
        "もう一度お試しください。technocore.chatは公開サービスで、混雑時には書き込みを断ります。このアプリにも、あなたの端末にも、鍵にも関係ありません。二、三回試すのは普通のことです。何も公開されていません。",
    "Try again. technocore.chat is a public service and it refuses writes when it is busy, which has nothing to do with this app, your phone or your key. Two or three attempts is normal. Nothing was posted." to
        "もう一度お試しください。technocore.chatは公開サービスで、混雑時には書き込みを断ります。このアプリにも、あなたの端末にも、鍵にも関係ありません。二、三回試すのは普通のことです。何も送られていません。",
    "Could not reach technocore.chat. Check your connection and try again; nothing was lost." to
        "technocore.chatに接続できませんでした。通信を確認してもう一度お試しください。失われたものはありません。",
    "The service took your record but has not shown it back yet. Press re-check in a moment; nothing needs signing again." to
        "サービスは記録を受け取りましたが、まだ返して表示していません。少し待って「再確認」を押してください。署名し直す必要はありません。",
    "technocore.chat refused the record. It refuses writes when it is busy - try again in a moment." to
        "technocore.chatが記録を受け付けませんでした。混雑時には書き込みを断ります。少し待ってからもう一度お試しください。",
    "technocore.chat did not take the change. It refuses writes when it is busy - press publish again in a moment. Your link is saved on this phone either way." to
        "technocore.chatが変更を受け付けませんでした。混雑時には書き込みを断ります。少し待ってからもう一度「公開」を押してください。リンクはいずれにせよこの端末に保存されています。",
    "Not finished yet. Your Passport is not live until all five are green, and there is nothing complete for anyone to verify. Keep going." to
        "まだ終わっていません。五つすべてが緑になるまでPassportは有効になりませんし、誰かが検証できる完成したものもありません。続けてください。",
    "A message signed by your Passport, posted to a quiet room and then read back to prove it landed. Same service as step 03, same rule: if it refuses, press again. That is the service being busy, not a problem with your key." to
        "Passportで署名したメッセージを静かなルームに書き込み、そのあと読み直して、確かに届いたことを確かめます。ステップ03と同じサービス、同じ決まりです。断られたらもう一度押してください。サービスが混んでいるだけで、鍵に問題があるわけではありません。",
    "Deleted after seven days with nothing written to it. Publish it now and it goes back to the same address." to
        "何も書き込まれないまま七日が過ぎると削除されます。いま公開すれば、同じアドレスに戻ります。",
    "Identity note at risk" to
        "IDノートが失われるおそれがあります",
    "In Settings, delete the Passport from this phone, then create it again from your wallet." to
        "設定から、この端末のPassportを削除し、ウォレットで作り直してください。",
    "It is deleted after seven days with nothing written to it. Opening this app writes it." to
        "何も書き込まれないまま七日が過ぎると削除されます。このアプリを開くこと自体が書き込みになります。",
    "Maybe. The service accepted it, and this app could not read it back to be sure." to
        "その可能性があります。サービスは受け取りましたが、このアプリはそれを読み直して確かめられていません。",
    "That was the last of the five. Your Passport is live. One thing left, and it is the part FLOP actually asked for: tell people what you did. The app writes the post for you at the bottom of this screen." to
        "五つのうちの最後でした。あなたのPassportは有効です。残りはひとつ、そしてそれこそFLOPが実際に求めたことです。何をしたのかを人に伝えてください。投稿はこの画面の下でアプリが書きます。",
    "This app is free and there is nothing in it to buy. If it has been useful, a thank you can go to kosa.skr." to
        "このアプリは無料で、中に買うものは何もありません。役に立ったなら、お礼はkosa.skrに送れます。",
    "checking" to
        "確認中",
    "open notification settings" to
        "通知設定を開く",
    "send a tip to kosa.skr" to
        "kosa.skrにチップを送る",
    "show my private key" to
        "自分の秘密鍵を表示",
    "step {n} {title} not confirmed yet" to
        "手順 {n} {title} はまだ確認できていません",
    "technocore.chat deletes anything with no write for seven days. Opening this app rewrites your note, and so does signing a record. Either one starts the seven days again." to
        "technocore.chatは、七日間だれも書き込まなかったものをすべて削除します。このアプリを開けばノートは書き直され、記録に署名しても同じです。どちらか一方で、七日間は最初から数え直しになります。",
    "This phone has no screen lock set up. Add a PIN or a fingerprint first." to
        "この端末には画面ロックが設定されていません。まずPINか指紋を登録してください。",
    "The server accepted the write but the message is not in the room yet. Do not resend: read the room again first." to
        "サーバーは書き込みを受け付けましたが、メッセージはまだルームにありません。送り直さないでください。まずルームを読み直してください。",
    "The stored text differs from the text we signed" to
        "保存されたテキストが、署名したテキストと一致しません",
    "The stored record did not verify against this key" to
        "保存された記録が、この鍵で検証できませんでした",
    "You made a key only your wallet can rebuild, sealed it in this phone, published it where a stranger can find it, signed a record and proved it landed, and put your post beside your key. There is nothing left to set up." to
        "あなたのウォレットだけが作り直せる鍵を作り、この端末に封じ、見知らぬ人でも見つけられる場所に公開し、記録に署名して届いたことを証明し、投稿を鍵のとなりに置きました。もう設定することはありません。",
    "open Activity" to
        "アクティビティを開く",
    "{n} more characters and the button below wakes up." to
        "あと{n}文字で、下のボタンが有効になります。",
    "Could not check technocore.chat for your published steps. This says nothing about them, only about the connection. Re-check when you are back online." to
        "technocore.chatで公開済みの手順を確認できませんでした。これは手順そのものではなく、接続に関する状態です。オンラインに戻ったら再確認してください。",
    "The key could not be sealed in this phone's secure storage" to
        "この端末のセキュアストレージに鍵を封印できませんでした",
    "Try again. If it keeps failing, restart the phone and try once more. Nothing was sent anywhere." to
        "もう一度お試しください。それでも失敗が続く場合は、端末を再起動してもう一度お試しください。どこにも何も送られていません。",
    "with a wallet prefix - this Passport rebuilds only through this same wallet app" to
        "ウォレット接頭辞付き。このPassportは同じウォレットアプリからのみ再構築できます",
    "Could not reach technocore.chat. Check your connection and press publish again. Your link is saved on this phone either way." to
        "technocore.chatに接続できませんでした。通信を確認して、もう一度「公開」を押してください。リンクはいずれにせよこの端末に保存されています。",
    "The note was accepted, but it could not be read back yet." to
        "ノートは受理されましたが、まだ読み戻せていません。",
    "The record was sent but no answer came back in time. Do not resend: read the room again first." to
        "記録は送信しましたが、時間内に応答がありませんでした。送り直さないでください。まずルームを読み直してください。",
    "The link you paste goes into your identity note, at an address derived from your own key. The note stays as long as you keep opening the app; seven days without a write and it is deleted." to
        "貼り付けたリンクは、あなた自身の鍵から計算されるアドレスにあるIDノートに入ります。ノートはアプリを開き続けているかぎり残り、七日間書き込みがなければ削除されます。",
    "vault: security chip" to "保管庫：セキュリティチップ",
    "vault: secure area" to "保管庫：セキュア領域",
    "vault: software" to "保管庫：ソフトウェア",
    "vault: not sealed yet" to "保管庫：未封印",
    "Could not read the key from secure storage. Restart the phone and try again." to
        "セキュアストレージから鍵を読み取れませんでした。端末を再起動してからもう一度お試しください。",
    "FLOP Passport is an independent community project. It is not made, endorsed or reviewed by FLOP Labs or by Solana Mobile." to
        "FLOP Passportは独立したコミュニティのプロジェクトです。FLOP LabsやSolana Mobileが制作・推奨・審査したものではありません。",
    "From now on: open the app at least once a week, so your identity note is not deleted. On the days you do something, open Activity and sign that day's record - a day cannot be added later." to
        "これからは、IDノートが削除されないように、少なくとも週に一度アプリを開いてください。何かをした日にはアクティビティを開き、その日の記録に署名してください。過ぎた日はあとから足せません。",
    "Link to your post on X" to "Xの投稿へのリンク",
    "Nothing was saved. Open your private key again and save it from there." to
        "何も保存されていません。秘密鍵をもう一度開き、そこから保存してください。",
    "Paste the link here and your name goes beside your key, in your identity note. This is the part people mean to do later and then do not." to
        "ここにリンクを貼れば、あなたの名前はIDノートの中で鍵のとなりに置かれます。あとでやろうと思って、そのままになるのがこの部分です。",
    "Paste the link to your post on X. It goes into your identity note, so the note points at the post and the post carries the key. Anyone can then check both ends against one key. The app does not open the link or check the post; anyone reading your note can." to
        "Xの投稿へのリンクを貼り付けてください。リンクはあなたのIDノートに入り、ノートが投稿を示し、投稿には鍵が含まれます。これで誰でも両方を同じ鍵で確認できます。アプリはリンクを開かず、投稿の確認もしません。あなたのノートを読む人なら誰でも確認できます。",
    "Seeker and Solana Mobile are trademarks of Solana Mobile, used only to say what this app is built for. FLOP and Technocore are names of the project whose public service this app writes to." to
        "SeekerおよびSolana MobileはSolana Mobileの商標で、本アプリがどの端末向けかを示すためだけに使用しています。FLOPとTechnocoreは、本アプリが書き込む公開サービスを運営するプロジェクトの名称です。",
    "The file could not be written. Try another location." to
        "ファイルを書き込めませんでした。別の保存先をお試しください。",
    "The five steps built your identity. Nobody outside this phone knows it is yours yet. Step 06 below: write one line, post it, then come back and paste the link. That last part is what puts your name beside your key, and it is where people stop." to
        "五つの手順があなたのIDを作りました。この端末の外では、それがあなたのものだとまだ誰も知りません。下の手順06です。一行書き、投稿し、戻ってリンクを貼ってください。その最後の部分が、あなたの名前を鍵の隣に置きます。そして人が止まるのも、まさにそこです。",
    "Three things, in this order: write your line, post it on X, then come back and paste the link. The last one is what puts your name beside your key, and it is the one people forget." to
        "順番に三つ。自分の一行を書き、Xに投稿し、それから戻ってリンクを貼ります。最後のひとつがあなたの名前を鍵のとなりに置き、そして忘れられるのもそれです。",
    "Your Passport is live, it is yours, and your post link is on it." to
        "あなたのPassportは有効で、あなたのもので、あなたの投稿リンクが付いています。",
    "checking with the server" to "サーバーで確認中",
    "independent project" to "独立プロジェクト",
    "not in your note yet" to "まだノートに入っていません",
    "post it on X" to "Xに投稿する",
    "put it in my note" to "ノートに入れる",
    "The prompt for this app begins with FLOP Passport key derivation v1 and names the app dev.alexkosa.floppassport; your wallet shows it was requested by flop.alexkosa.dev." to
        "本アプリの署名リクエストはFLOP Passport key derivation v1で始まり、アプリdev.alexkosa.floppassportを名指しします。ウォレットには、flop.alexkosa.devからの要求であると表示されます。",
    "A signed record is dated evidence that you were here. A day without one cannot be added later, and signing also keeps your identity note alive. Nothing here promises anything about any allocation." to
        "署名済みの記録は、あなたがここにいたことを示す日付入りの証拠です。記録のない一日はあとから足せず、署名はIDノートを維持する働きもします。ここにあるものは、いかなる割り当ても約束しません。",
    "Your Passport itself is not lost: the same wallet still gives the same identity, and publishing again puts the note back at the same address." to
        "Passport自体は失われていません。同じウォレットから同じIDが得られ、もう一度公開すれば、ノートは同じアドレスに戻ります。",
    "Read from technocore.chat, not from this phone. Rooms are trimmed as they grow, so this shows what anyone would find today." to
        "この端末ではなく、technocore.chatから読み取りました。ルームは増加に伴って整理されるため、ここに表示されるのは、今日誰でも見つけられる内容です。",
    "Seven days without opening the app. Open it and press publish; the note goes back to the same address." to
        "七日間アプリが開かれていません。開いて「公開」を押せば、ノートは同じアドレスに戻ります。",
    "Finish the steps on the Passport tab first. Daily records start once your Passport is live." to
        "先にPassportタブの手順を終えてください。毎日の記録は、Passportが有効になってから始まります。",
    "Today is the last day. It is deleted within 24 hours unless you open the app." to
        "今日が最後の日です。アプリを開かなければ、24時間以内に削除されます。",
    "If you did something today, sign a record for it now." to
        "今日何かをしたなら、いまその記録に署名してください。",

    // 2.0: FLOP account, my day, guide and questions (2026-11-03).
    "@flop_labs is FLOP's account on X, YouTube and TikTok." to
        "@flop_labsは、X、YouTube、TikTokでのFLOPのアカウントです。",
    "A FLOP account with daily FLOP" to
        "毎日FLOPが届くFLOPアカウント",
    "A flop.finance address, but not one FLOP lists publicly. Ask through x.com/flop_labs." to
        "flop.financeのアドレスですが、FLOPが公開しているものではありません。x.com/flop_labsで問い合わせてください。",
    "A flop.finance address. FLOP lists security@flop.finance as its one public contact." to
        "flop.financeのアドレスです。FLOPが公開している唯一の連絡先はsecurity@flop.financeです。",
    "A model you pay in FLOP, and a streak" to
        "FLOPで支払うモデルと、連続日数",
    "A practice network, open to everyone since 3 November 2026. FLOP here has no value, earns nothing and can be wiped in a reset. Use it to learn the day before it counts." to
        "2026年11月3日から誰でも使える練習用ネットワークです。ここのFLOPには価値がなく、何も得られず、リセットで消えることがあります。本番で数えられる前に、一日の流れを覚えるために使ってください。",
    "A streak counts days in a row with a signed record. One missed day a week is now forgiven; two missed days in a row end it. The count is read from the public room, so a day you did not sign cannot be added later." to
        "連続日数は、署名済み記録のある日が何日続いたかを数えます。週に一日の抜けは見逃されるようになりました。二日続けて抜けると途切れます。日数は公開ルームから読み取るので、署名しなかった日はあとから足せません。",
    "About 90 days. This is where FLOP's agent airdrop is earned: the testnet FLOP you spend on the model is recorded as your claim on mainnet FLOP." to
        "約90日間。FLOPのエージェント向けエアドロップはここで得られます。モデルに使ったtestnet FLOPが、mainnet FLOPを受け取る権利として記録されます。",
    "Alex Kosa, one developer, for Seeker owners. It is not made by FLOP Labs. It is free and its code is open." to
        "Alex Kosaという一人の開発者が、Seekerの持ち主のために作りました。FLOP Labsが作ったものではありません。無料で、コードは公開されています。",
    "An identity made by your wallet" to
        "ウォレットから作られるID",
    "Ask a question, see what it cost, and keep a streak of the days you show up." to
        "質問して、いくらかかったかを確かめ、顔を出した日を連続日数として残しましょう。",
    "Ask anything. The model is small, so short, plain questions work best. Each answer costs a few devnet FLOP, taken from your Passport's allowance." to
        "何でも聞いてください。モデルは小さいので、短く平易な質問がいちばん向いています。回答ごとに数devnet FLOPかかり、Passportの利用枠から差し引かれます。",
    "Ask the model" to
        "モデルに質問する",
    "Ask the model one question" to
        "モデルに質問を一つする",
    "Blocks are being finalised normally." to
        "ブロックは通常どおりファイナライズされています。",
    "Could not reach FLOP's gateway. Check your connection and try again." to
        "FLOPのゲートウェイに接続できませんでした。接続を確認して、もう一度お試しください。",
    "Could not reach technocore.chat." to
        "technocore.chatに接続できませんでした。",
    "Could not reach the FLOP devnet node. This says nothing about your balance, only about the connection." to
        "FLOP devnetノードに接続できませんでした。これは接続に関する状態であり、残高の状態を示すものではありません。",
    "Could not reach the FLOP explorer." to
        "FLOPのエクスプローラーに接続できませんでした。",
    "Could not reach the FLOP faucet. Check your connection and try again." to
        "FLOPのフォーセットに接続できませんでした。接続を確認して、もう一度お試しください。",
    "Devnet FLOP is practice money: it has no value and can be wiped in a reset." to
        "Devnet FLOPは練習用のお金です。価値はなく、リセットで消えることがあります。",
    "Devnet explorer" to
        "Devnetエクスプローラー",
    "Devnet is open" to
        "Devnet公開中",
    "Devnet is open to everyone since 3 November 2026. It has no rewards and may be reset. Testnet has no date yet; FLOP will announce it on x.com/flop_labs. On testnet, the testnet FLOP an agent spends on inference becomes its claim on mainnet FLOP. Creating accounts earns nothing." to
        "Devnetは2026年11月3日から誰でも使えます。報酬はなく、リセットされることがあります。Testnetの日程はまだありません。FLOPがx.com/flop_labsで発表します。Testnetでは、エージェントが推論に使ったtestnet FLOPが、mainnet FLOPを受け取る権利になります。アカウントを作っても何も得られません。",
    "Devnet is practice" to
        "Devnetは練習です",
    "Devnet is practice: its FLOP has no value. This app promises nothing about any allocation." to
        "Devnetは練習です。そのFLOPに価値はありません。このアプリは、いかなる割り当ても約束しません。",
    "Do I have to post on X?" to
        "Xに投稿しないといけませんか？",
    "Do I need more than one account?" to
        "アカウントは複数必要ですか？",
    "Do my day" to
        "今日の分をやる",
    "Every step below was read back from the server, not just sent." to
        "以下の各手順は、送信しただけでなく、サーバーから読み戻して確認しています。",
    "Explain the idea of a 'seed phrase' and why it must stay secret." to
        "「シードフレーズ」とは何か、なぜ秘密にしなければならないのかを説明してください。",
    "Explain what 'decentralised' means without using jargon." to
        "「分散型」とはどういう意味か、専門用語を使わずに説明してください。",
    "Explain what a blockchain block is to a ten-year-old, in three sentences." to
        "ブロックチェーンのブロックとは何かを、10歳の子どもに三文で説明してください。",
    "Explain what an API is using a restaurant as the example." to
        "APIとは何かを、レストランを例にして説明してください。",
    "Explain what open-source software is in two sentences." to
        "オープンソースソフトウェアとは何かを二文で説明してください。",
    "FLOP Network is a blockchain where AI agents pay for AI work with FLOP. Miners run models on graphics cards, validators check that the work was really done, and agents buy the answers. Asking the model a question here is exactly that: your Passport acts as an agent and pays for one answer." to
        "FLOP Networkは、AIエージェントがFLOPでAIの仕事に支払うブロックチェーンです。マイナーはグラフィックカードでモデルを動かし、バリデーターは仕事が本当に行われたかを確かめ、エージェントは答えを買います。ここでモデルに質問するのはまさにそれです。あなたのPassportがエージェントとして、一つの答えに支払います。",
    "FLOP Passport gives your Seeker an identity and an account on FLOP Network, and one place to do your day there. It is free, open source, and made by one developer, Alex Kosa. It is not made by FLOP Labs." to
        "FLOP Passportは、あなたのSeekerにFLOP Network上のIDとアカウントを与え、そこでの一日を一か所で済ませられるようにします。無料のオープンソースで、一人の開発者Alex Kosaが作っています。FLOP Labsが作ったものではありません。",
    "FLOP gives each account one devnet allowance: 25 FLOP for 24 hours. When it is over it is over until testnet." to
        "FLOPは各アカウントにdevnetの利用枠を一度だけ与えます。24時間で25 FLOPです。使い切ったら、testnetまでそれで終わりです。",
    "FLOP has no Discord, Telegram, Reddit or Medium. There is no FLOP token yet." to
        "FLOPにDiscord、Telegram、Reddit、Mediumはありません。FLOPトークンもまだありません。",
    "FLOP has no official Discord, Telegram, Reddit or Medium. An invitation to one never comes from FLOP." to
        "FLOPには公式のDiscord、Telegram、Reddit、Mediumはありません。そうした場への招待がFLOPから来ることはありません。",
    "FLOP has not announced the testnet date. When it opens, the testnet FLOP you spend on the model becomes your claim on mainnet FLOP. Holding FLOP or making more accounts earns nothing." to
        "FLOPはtestnetの開始日をまだ発表していません。始まれば、モデルに使ったtestnet FLOPが、mainnet FLOPを受け取る権利になります。FLOPを保有しても、アカウントを増やしても、何も得られません。",
    "FLOP has not given a date. It will be announced on x.com/flop_labs, and this app's status will say so the same day." to
        "FLOPはまだ日付を出していません。x.com/flop_labsで発表され、このアプリの状況表示も同じ日にそう伝えます。",
    "FLOP says Q1 2027" to
        "FLOPによると2027年第1四半期",
    "FLOP says there is no token, mint, claim, presale or live airdrop yet. Anything offering one is not FLOP." to
        "FLOPによると、トークン、ミント、クレーム、プレセール、実施中のエアドロップはまだ一つもありません。それらを持ちかけるものはFLOPではありません。",
    "FLOP's faucet is down for everyone right now. It is not your phone. Try again later." to
        "FLOPのフォーセットは現在、全員に対して止まっています。あなたの端末の問題ではありません。あとでもう一度お試しください。",
    "FLOP's faucet is refusing every request with “IP classification unavailable”. This is FLOP's bug (network issue #22), not your phone. The app keeps trying when you press do my day." to
        "FLOPのフォーセットが、すべてのリクエストを「IP classification unavailable」で拒否しています。これはFLOP側の不具合（network issue #22）で、あなたの端末の問題ではありません。「今日の分をやる」を押すたびに、アプリは再試行します。",
    "FLOP's faucet sends 25 devnet FLOP to your address, once every 24 hours per address. The request goes from your phone, for your own address, the same as pressing the button on faucet.flop.network. When the faucet is down, the app says so and the rest of your day still counts." to
        "FLOPのフォーセットは、アドレスごとに24時間に一度、25 devnet FLOPを送ります。リクエストはあなたの端末から、あなた自身のアドレス宛てに送られ、faucet.flop.networkでボタンを押すのと同じです。フォーセットが止まっているときはアプリがそう伝え、その日のほかの部分はそのまま数えられます。",
    "FLOP's gateway has handed out all of today's devnet allowances, or is unavailable. Try again later." to
        "FLOPのゲートウェイが今日のdevnet利用枠をすべて配り終えたか、利用できない状態です。あとでもう一度お試しください。",
    "FLOP's gateway rules (OpenAPI)" to
        "FLOPゲートウェイの仕様（OpenAPI）",
    "FLOP's only handle is @flop_labs. Any other account using the name is not theirs." to
        "FLOPのアカウントは@flop_labsだけです。その名前を使うほかのアカウントはFLOPのものではありません。",
    "FLOP: official links and verification" to
        "FLOP：公式リンクと確認方法",
    "FLOP: the airdrop and testnet conversion" to
        "FLOP：エアドロップとtestnetからの移行",
    "Faucet outage, FLOP issue #22" to
        "フォーセット障害、FLOP issue #22",
    "Finality is lagging behind. The network may be slow." to
        "ファイナリティが遅れています。ネットワークが遅くなっている可能性があります。",
    "Finish setting up your Passport first." to
        "先にPassportの設定を終えてください。",
    "Free and open source. Made by Alex Kosa, not by FLOP Labs. It promises nothing about any allocation." to
        "無料のオープンソース。FLOP LabsではなくAlex Kosaが作りました。いかなる割り当ても約束しません。",
    "From FLOP's faucet, once every 24 hours." to
        "FLOPのフォーセットから、24時間に一度。",
    "From FLOP's faucet. Next in {time}." to
        "FLOPのフォーセットから。次は{time}後。",
    "From the FLOP Passport team, written into this version." to
        "FLOP Passportチームより。このバージョンに収録。",
    "From the FLOP Passport team." to
        "FLOP Passportチームより。",
    "Get 25 FLOP" to
        "25 FLOPを受け取る",
    "Give me a short motivational sentence for a Monday." to
        "月曜日向けの、短い励ましの一文をください。",
    "Give me a simple recipe idea with rice and eggs." to
        "ご飯と卵で作れる簡単なレシピのアイデアをください。",
    "Give me one practical tip for writing clearer emails." to
        "メールをわかりやすく書くための実用的なコツを一つ教えてください。",
    "Give one good question to ask before buying any crypto token." to
        "暗号資産のトークンを買う前に確認すべき、良い質問を一つ挙げてください。",
    "Give one way to remember a new word in a foreign language." to
        "外国語の新しい単語を覚える方法を一つ挙げてください。",
    "Give three tips for keeping a phone's battery healthy." to
        "スマホのバッテリーを長持ちさせるコツを三つ挙げてください。",
    "I changed phones. How do I get my Passport back?" to
        "端末を替えました。Passportを取り戻すにはどうすればいいですか？",
    "In plain words, what does 'inference' mean for an AI model?" to
        "AIモデルにとっての「推論」とは何か、やさしい言葉で教えてください。",
    "In two sentences, what does a GPU do that a CPU does badly?" to
        "GPUが得意でCPUが苦手なことは何か、二文で答えてください。",
    "Install the app and connect the same Solana wallet. The same wallet makes the same Passport, with the same FLOP address and the same streak. There are no words to write down." to
        "アプリをインストールし、同じSolanaウォレットを接続してください。同じウォレットからは同じPassportが作られ、FLOPアドレスも連続日数も同じです。書き留める単語はありません。",
    "Is this FLOP money real?" to
        "このFLOPは本物のお金ですか？",
    "It gets 25 devnet FLOP from FLOP's faucet every 24 hours." to
        "FLOPのフォーセットから、24時間ごとに25 devnet FLOPを受け取ります。",
    "It needs at least 1 FLOP on your Passport address first. On devnet each account also gets only one trial: 25 FLOP for 24 hours. After that it stays closed until testnet. The Ask tab says which one it is." to
        "まず、Passportのアドレスに少なくとも1 FLOPが必要です。また、devnetでは各アカウントの試用は一度だけで、24時間で25 FLOPです。そのあとはtestnetまで閉じたままです。どちらが理由かは「質問」タブに表示されます。",
    "Its FLOP has no value. What you practise here is what testnet will count." to
        "そのFLOPに価値はありません。ここで練習することが、testnetで数えられることです。",
    "Name three things to check before signing anything in a crypto wallet." to
        "暗号資産ウォレットで何かに署名する前に確認すべきことを三つ挙げてください。",
    "Name three uses of AI that run well on small models." to
        "小さなモデルでもうまく動くAIの使い道を三つ挙げてください。",
    "No, and it would not help. FLOP counts spending, not accounts, and says extra accounts earn nothing. One person, one Passport." to
        "いいえ。増やしても意味はありません。FLOPが数えるのはアカウント数ではなく使った量で、余分なアカウントでは何も得られないとしています。一人につきPassportは一つです。",
    "No. Devnet FLOP is practice money with no value, and FLOP may wipe the devnet at any time. There is no FLOP token yet at all. Anybody selling FLOP today is a scammer." to
        "いいえ。Devnet FLOPは価値のない練習用のお金で、FLOPはいつでもdevnetをリセットすることがあります。FLOPトークンそのものがまだ存在しません。今FLOPを売っている人は詐欺師です。",
    "No. Linking a post to your Passport is optional. It shows people the Passport is yours, nothing more." to
        "いいえ。投稿をPassportに結び付けるのは任意です。そのPassportがあなたのものだと人に示すだけで、それ以上の意味はありません。",
    "Nobody can promise that, and this app never will. What FLOP says: on testnet, the testnet FLOP an agent spends on the model becomes its claim on mainnet FLOP. The app helps you do exactly that every day. Devnet, which is now, earns nothing." to
        "それは誰にも約束できませんし、このアプリが約束することもありません。FLOPの説明では、testnetでエージェントがモデルに使ったtestnet FLOPが、mainnet FLOPを受け取る権利になります。このアプリは、まさにそれを毎日行う手助けをします。今のdevnetでは何も得られません。",
    "Nothing new to write down. The same wallet brings it back on any phone." to
        "新しく書き留めるものはありません。同じウォレットがあれば、どの端末でも元に戻せます。",
    "On devnet FLOP gives each account one allowance: 25 FLOP to spend on the model within 24 hours, and needs at least 1 FLOP on the account to start it. When it is over, it stays over until testnet." to
        "devnetでは、FLOPは各アカウントに利用枠を一度だけ与えます。24時間以内にモデルで使える25 FLOPで、始めるにはアカウントに少なくとも1 FLOPが必要です。使い切ると、testnetまで閉じたままです。",
    "One button signs today, takes today's FLOP and asks the model one question." to
        "ボタン一つで、今日に署名し、今日のFLOPを受け取り、モデルに質問を一つします。",
    "One press does all three, in order. Whatever is already done is skipped." to
        "一度押すと、三つを順番に行います。済んでいるものは飛ばします。",
    "One question, paid in FLOP. Spending on the model is what testnet will count." to
        "質問を一つ、FLOPで支払います。モデルに使った分こそ、testnetで数えられるものです。",
    "One short text to sign. It is not a transaction and moves no money. Your wallet keeps its keys; nothing leaves it but that one signature." to
        "署名するのは短いテキスト一つだけです。トランザクションではなく、お金は動きません。鍵はウォレットが持ったままで、外に出るのはその署名一つだけです。",
    "Only text, never a transaction. Once, to create your Passport. After that the Passport signs on its own: your daily record and the model's entry statement. None of it can move money from your wallet." to
        "テキストだけで、トランザクションには決して署名しません。Passportを作るときに一度だけです。そのあとはPassportが自分で署名します。毎日の記録と、モデル利用時の声明です。どれもウォレットからお金を動かすことはできません。",
    "Open the app and press do my day. It signs today, takes today's FLOP from the faucet and asks the model one question. That is all. Whatever is already done is skipped." to
        "アプリを開いて「今日の分をやる」を押してください。今日に署名し、フォーセットから今日のFLOPを受け取り、モデルに質問を一つします。それだけです。済んでいるものは飛ばします。",
    "Open the app and press do my day: it signs today, takes today's FLOP and asks the model one question." to
        "アプリを開いて「今日の分をやる」を押してください。今日に署名し、今日のFLOPを受け取り、モデルに質問を一つします。",
    "Paste a FLOP address from SubWallet, Talisman or Polkadot.js. The faucet will send there. The model still uses your Passport's own address, because only your Passport can sign for it." to
        "SubWallet、Talisman、Polkadot.jsのFLOPアドレスを貼り付けてください。フォーセットはそこに送ります。モデルは引き続きPassport自身のアドレスを使います。そのアドレスに署名できるのはPassportだけだからです。",
    "Paste a full link, a handle like @name, or an address." to
        "完全なリンク、@nameのようなハンドル、またはアドレスを貼り付けてください。",
    "Paste a link, an @handle or an address someone sent you." to
        "送られてきたリンク、@ハンドル、アドレスを貼り付けてください。",
    "Questions people ask" to
        "よくある質問",
    "Reading your days from technocore.chat…" to
        "technocore.chatから日々の記録を読み込み中…",
    "Same Passport, same days. And now one missed day a week is forgiven." to
        "Passportも日数もそのまま。さらに、週に一日の抜けは見逃されるようになりました。",
    "Sign today" to
        "今日に署名",
    "Sign today to start your streak." to
        "今日に署名して、連続日数を始めましょう。",
    "Sign today's record" to
        "今日の記録に署名",
    "Sign today, or the streak ends. Yesterday was already forgiven." to
        "今日署名しないと、連続日数が途切れます。昨日はすでに見逃し済みです。",
    "Signing the gateway's statement with your Passport…" to
        "ゲートウェイの声明にPassportで署名しています…",
    "Since 3 November FLOP's practice network is open to everyone. Devnet FLOP has no value, earns nothing, and the network may be reset at any time." to
        "11月3日から、FLOPの練習用ネットワークが誰でも使えるようになりました。Devnet FLOPに価値はなく、何も得られず、ネットワークはいつでもリセットされることがあります。",
    "Staying safe" to
        "安全のために",
    "Suggest a five-minute stretch for someone who sits all day." to
        "一日中座っている人向けの、5分間のストレッチを提案してください。",
    "Summarise what 'proof of work' means in two sentences." to
        "「プルーフ・オブ・ワーク」とは何かを二文でまとめてください。",
    "Take today's FLOP" to
        "今日のFLOPを受け取る",
    "Tell me one interesting fact about the history of computers." to
        "コンピューターの歴史にまつわる面白い事実を一つ教えてください。",
    "Testnet and the airdrop" to
        "Testnetとエアドロップ",
    "Testnet: no date yet" to
        "Testnet：日程未定",
    "That is not a FLOP address. It should start with 5 and be 47 or 48 characters; copy it again from your wallet." to
        "FLOPアドレスではありません。5で始まり、47文字か48文字のはずです。ウォレットからもう一度コピーしてください。",
    "The faucet" to
        "フォーセット",
    "The faucet did not answer." to
        "フォーセットから応答がありませんでした。",
    "The faucet is down for everyone" to
        "フォーセットが全員に対して停止中",
    "The faucet sends to an address you chose instead:" to
        "フォーセットは、あなたが選んだ別のアドレスに送ります：",
    "The faucet works for you" to
        "フォーセットは利用できます",
    "The model did not answer." to
        "モデルから応答がありませんでした。",
    "The model is busy. Try again in a minute; nothing was spent." to
        "モデルが混み合っています。1分ほどしてからもう一度お試しください。何も使われていません。",
    "The model is closed for this account" to
        "このアカウントではモデルが閉じています",
    "The model is thinking…" to
        "モデルが考えています…",
    "The model needs at least 1 FLOP on your Passport address first. Get it from the faucet." to
        "モデルを使うには、まずPassportのアドレスに少なくとも1 FLOPが必要です。フォーセットで受け取ってください。",
    "The model: one trial per account" to
        "モデル：アカウントごとに試用は一度",
    "The real token. There is no FLOP token before this, so anything sold or “claimed” as FLOP today is a scam." to
        "本物のトークンです。それより前にFLOPトークンは存在しないので、今日FLOPとして売られたり「クレーム」できるとされたりするものは詐欺です。",
    "There is no FLOP token yet, so there is no FLOP contract address. Anything offered as one is not FLOP." to
        "FLOPトークンはまだないので、FLOPのコントラクトアドレスもありません。それとして提示されるものはFLOPではありません。",
    "There is no FLOP token yet. Nobody, including this app's author, will ever ask for your private key or your wallet's words. Your wallet only ever signs text here, never a transaction. If somebody sends you a FLOP link, check it on the Network tab first." to
        "FLOPトークンはまだありません。このアプリの作者を含め、誰も秘密鍵やウォレットの単語を求めることはありません。ここでウォレットが署名するのはテキストだけで、トランザクションには決して署名しません。FLOPのリンクが送られてきたら、まず「ネットワーク」タブで確認してください。",
    "There is no Passport on this phone." to
        "この端末にPassportはありません。",
    "This account has used its one devnet allowance. FLOP does not renew it on devnet. The model opens again when testnet starts, and on testnet the FLOP you spend here is what counts." to
        "このアカウントは一度きりのdevnet利用枠を使い切りました。FLOPはdevnetで利用枠を更新しません。testnetが始まるとモデルは再び開き、testnetではここで使ったFLOPが数えられます。",
    "This account's devnet allowance is used up." to
        "このアカウントのdevnet利用枠は使い切りました。",
    "This address already got its FLOP in the last 24 hours." to
        "このアドレスは過去24時間以内にすでにFLOPを受け取っています。",
    "This app's source code" to
        "このアプリのソースコード",
    "This is an account on FLOP Network. An address alone says nothing about who holds it." to
        "これはFLOP Network上のアカウントです。アドレスだけでは、誰が持っているかはわかりません。",
    "To use the model, your Passport signs a short statement from api.flop.network. That signature moves nothing. FLOP then opens an allowance for your account: on devnet that is 25 FLOP for 24 hours, once per account, and your account needs at least 1 FLOP to start it. An answer costs about 0.006 FLOP per word-piece, usually one or two FLOP. When the allowance ends, the model stays closed for that account until testnet." to
        "モデルを使うために、Passportはapi.flop.networkからの短い声明に署名します。その署名で動くものは何もありません。そのあとFLOPがアカウントに利用枠を開きます。devnetでは24時間で25 FLOP、アカウントごとに一度で、始めるにはアカウントに少なくとも1 FLOPが必要です。回答の費用はトークン1つあたり約0.006 FLOPで、たいてい1〜2 FLOPです。利用枠が終わると、そのアカウントのモデルはtestnetまで閉じたままです。",
    "Today is not signed yet" to
        "今日はまだ署名していません",
    "Today is not signed yet." to
        "今日はまだ署名していません。",
    "Today is signed. Come back tomorrow." to
        "今日は署名済みです。また明日来てください。",
    "Today is signed. See you tomorrow." to
        "今日は署名済みです。また明日。",
    "Too many tries from this network. Wait a minute and try again." to
        "このネットワークからの試行が多すぎます。1分待ってからもう一度お試しください。",
    "Type a question" to
        "質問を入力",
    "What FLOP is" to
        "FLOPとは",
    "What FLOP says: on testnet, testnet FLOP that an agent actually spends on inference becomes its claim on mainnet FLOP. That claim is locked, and unlocks as it is spent on inference on mainnet: three spent unlock one. Holding FLOP earns nothing. Making more accounts earns nothing. Posting your identity earns nothing." to
        "FLOPの説明：testnetでエージェントが実際に推論に使ったtestnet FLOPが、mainnet FLOPを受け取る権利になります。その権利はロックされていて、mainnetで推論に使うにつれて解除されます。三つ使うと一つ解除されます。FLOPを保有しても何も得られません。アカウントを増やしても何も得られません。IDを投稿しても何も得られません。",
    "What do I need to do every day?" to
        "毎日何をすればいいですか？",
    "What does a miner do in a compute network?" to
        "計算資源ネットワークで、マイナーは何をしていますか？",
    "What exactly does my wallet sign?" to
        "ウォレットは具体的に何に署名するのですか？",
    "What is a hash function? Two sentences." to
        "ハッシュ関数とは何ですか？二文で。",
    "What is a token in the context of language models?" to
        "言語モデルでいう「トークン」とは何ですか？",
    "What is a validator in a blockchain network? Keep it short." to
        "ブロックチェーンネットワークのバリデーターとは何ですか？手短に。",
    "What is an AI agent, in one paragraph?" to
        "AIエージェントとは何か、一段落で説明してください。",
    "What is latency, and why do people care about it?" to
        "レイテンシとは何で、なぜ気にされるのですか？",
    "What is phishing, and how do you spot it? Three signs." to
        "フィッシングとは何で、どう見分けますか？サインを三つ。",
    "What is the cloud, really? Two sentences." to
        "クラウドとは、結局のところ何ですか？二文で。",
    "What is the difference between a private key and a public key?" to
        "秘密鍵と公開鍵の違いは何ですか？",
    "What makes a password strong? Three short points." to
        "強いパスワードの条件は？短く三つ。",
    "What this app is" to
        "このアプリについて",
    "What we say: this app promises nothing about any allocation, and never will. It helps you do, every day, the thing FLOP says it counts. One person, one Passport." to
        "私たちの立場：このアプリは、いかなる割り当ても約束せず、今後も約束しません。FLOPが数えるとしていることを、毎日行う手助けをするだけです。一人につきPassportは一つです。",
    "When does testnet start?" to
        "Testnetはいつ始まりますか？",
    "Where FLOP is now" to
        "FLOPの現在地",
    "Where these facts come from" to
        "これらの情報の出どころ",
    "Who made this app?" to
        "このアプリは誰が作ったのですか？",
    "Why did my streak go back to zero?" to
        "連続日数がゼロに戻ったのはなぜですか？",
    "Why do computers use binary? Two sentences." to
        "コンピューターはなぜ2進数を使うのですか？二文で。",
    "Why does the model not answer me?" to
        "モデルが答えてくれないのはなぜですか？",
    "Why is my balance 0?" to
        "残高が0なのはなぜですか？",
    "Will I get FLOP tokens for this?" to
        "これでFLOPトークンがもらえますか？",
    "Write a haiku about a phone that never sleeps." to
        "眠らないスマホについての俳句を詠んでください。",
    "You are a small model running on FLOP Network's devnet, answering inside a phone app. Answer briefly and plainly. Answer in the language the user writes in." to
        "あなたはFLOP Networkのdevnet上で動く小さなモデルで、スマホアプリの中で答えています。短く、平易に答えてください。ユーザーが書いた言語で答えてください。",
    "You never need this to recover: your wallet rebuilds the Passport. It is here for people who want to use their identity away from this phone. Nobody, including this app's author, will ever ask you for it." to
        "復元にこれが必要になることはありません。ウォレットがPassportを再構築します。これは、この端末以外でIDを使いたい人のためのものです。このアプリの作者を含め、誰もこれを求めることはありません。",
    "Your FLOP address" to
        "あなたのFLOPアドレス",
    "Your FLOP comes from FLOP's faucet, and right now the faucet is not giving FLOP to anyone. That is FLOP's problem, not your phone. When it works, press do my day and 25 FLOP arrives within a minute." to
        "FLOPはFLOPのフォーセットから届きますが、今はフォーセットが誰にもFLOPを配っていません。FLOP側の問題で、あなたの端末の問題ではありません。復旧したら「今日の分をやる」を押せば、1分以内に25 FLOPが届きます。",
    "Your Passport is a FLOP account" to
        "PassportはFLOPアカウントです",
    "Your Passport is also a FLOP address. FLOP's faucet gives it 25 FLOP every 24 hours." to
        "PassportはFLOPアドレスでもあります。FLOPのフォーセットが24時間ごとに25 FLOPを送ります。",
    "Your Passport key is also an account on FLOP Network. Same key, written the way FLOP writes addresses." to
        "Passportの鍵は、FLOP Network上のアカウントでもあります。同じ鍵を、FLOPのアドレス形式で書いたものです。",
    "Your Passport key is also your FLOP account. It is the same key, written the way FLOP writes addresses, so there is nothing new to back up: your Solana wallet rebuilds both on any phone. If you already have a FLOP address in SubWallet, Talisman or Polkadot.js, you can send the faucet there instead, on the Passport tab. The model works only with the Passport's own address, because only the Passport can sign for it." to
        "Passportの鍵は、あなたのFLOPアカウントでもあります。同じ鍵をFLOPのアドレス形式で書いたものなので、新たにバックアップするものはありません。Solanaウォレットがあれば、どの端末でも両方を再構築できます。SubWallet、Talisman、Polkadot.jsにFLOPアドレスをすでに持っているなら、Passportタブでフォーセットの送り先をそちらに変えられます。モデルはPassport自身のアドレスでしか使えません。そのアドレスに署名できるのはPassportだけだからです。",
    "Your Passport now lives on FLOP" to
        "PassportはFLOPの上で動くようになりました",
    "Your Passport signs one line in public. It adds a day to your streak." to
        "Passportが公開の場で一行に署名します。連続日数に一日加わります。",
    "Your Passport signs one short line in a public room on technocore.chat, and the app reads it back to prove it landed. Each signed day adds to your streak. Miss one day and it is forgiven, once a week. Miss two in a row and the streak starts again." to
        "Passportはtechnocore.chatの公開ルームで短い一行に署名し、アプリがそれを読み戻して届いたことを確かめます。署名した日ごとに連続日数が増えます。一日抜けても、週に一度までは見逃されます。二日続けて抜けると、連続日数は最初からになります。",
    "Your address got its FLOP from the faucet in the last 24 hours. It can ask again 24 hours after the last grant." to
        "このアドレスは過去24時間以内にフォーセットからFLOPを受け取っています。前回の受け取りから24時間たつと、もう一度申請できます。",
    "Your day is done." to
        "今日の分は終わりました。",
    "Your day on FLOP, from your Seeker." to
        "FLOPでの一日を、あなたのSeekerから。",
    "Your day, step by step" to
        "一日の流れ、手順ごとに",
    "Your first question opens it. Your Passport signs a short statement from api.flop.network; nothing else is signed and nothing moves. You need at least 1 FLOP on your Passport's address, which the faucet on Today gives you." to
        "最初の質問で開きます。Passportがapi.flop.networkからの短い声明に署名します。ほかには何も署名せず、何も動きません。Passportのアドレスに少なくとも1 FLOPが必要で、「今日」タブのフォーセットで受け取れます。",
    "Your identity note was deleted after seven quiet days. Publish it again to keep signing your days. Your streak is not lost." to
        "IDノートは、七日間書き込みがなかったため削除されました。日々の署名を続けるには、もう一度公開してください。連続日数は失われていません。",
    "Your one devnet trial of the model is over. It opens again on testnet." to
        "devnetでの一度きりのモデル試用は終わりました。testnetで再び開きます。",
    "Your streak came with you" to
        "連続日数も引き継がれました",
    "Your wallet made this key and rebuilds it on any phone. There are no words to write down." to
        "この鍵はウォレットが作り、どの端末でも再構築します。書き留める単語はありません。",
    "Your {n}-day streak ends at midnight" to
        "{n}日の連続記録が深夜0時に途切れます",
    "accounts" to
        "アカウント",
    "active agents" to
        "アクティブなエージェント",
    "all my records" to
        "自分の記録をすべて見る",
    "allowance left" to
        "残りの利用枠",
    "already asked today" to
        "今日は質問済み",
    "already signed today" to
        "今日は署名済み",
    "already taken today" to
        "今日は受け取り済み",
    "answered" to
        "回答済み",
    "ask the model something else" to
        "モデルに別のことを聞く",
    "back" to
        "戻る",
    "balance" to
        "残高",
    "balance {n} FLOP" to
        "残高 {n} FLOP",
    "change the address" to
        "アドレスを変更",
    "closes in" to
        "終了まで",
    "compute market and FRCR index" to
        "計算資源市場とFRCR指数",
    "copied" to
        "コピーしました",
    "cost {n} FLOP" to
        "費用 {n} FLOP",
    "day in a row" to
        "日連続",
    "days in a row" to
        "日連続",
    "devnet flop" to
        "devnet FLOP",
    "do my day" to
        "今日の分をやる",
    "entering" to
        "開始中",
    "finish your passport first" to
        "先にPassportを完成させる",
    "flop gateway" to
        "FLOPゲートウェイ",
    "go back to my passport address" to
        "Passportのアドレスに戻す",
    "got it" to
        "了解",
    "how it all works" to
        "全体の仕組み",
    "how it works" to
        "仕組み",
    "how it works, questions and answers" to
        "仕組みとQ&A",
    "how the model works here" to
        "ここでのモデルの仕組み",
    "is this really flop?" to
        "これは本当にFLOP？",
    "just now" to
        "たった今",
    "latest block" to
        "最新ブロック",
    "made by wallet" to
        "作成元ウォレット",
    "model" to
        "モデル",
    "my day on flop" to
        "FLOPでの私の一日",
    "needs flop" to
        "FLOPが必要",
    "network" to
        "ネットワーク",
    "new in 2.0" to
        "2.0の新機能",
    "news" to
        "ニュース",
    "no date yet" to
        "日程未定",
    "not entered" to
        "未開始",
    "not flop" to
        "FLOPではない",
    "not flop's" to
        "FLOPのものではない",
    "not now" to
        "あとで",
    "official" to
        "公式",
    "official channels" to
        "公式チャンネル",
    "open in FLOP's explorer" to
        "FLOPのエクスプローラーで開く",
    "passport" to
        "Passport",
    "private key" to
        "秘密鍵",
    "publish again" to
        "もう一度公開",
    "read it in FLOP's own words" to
        "FLOP自身の言葉で読む",
    "reading" to
        "読み込み中",
    "refresh" to
        "更新",
    "refused" to
        "拒否",
    "save" to
        "保存",
    "scam warning" to
        "詐欺に注意",
    "send" to
        "送信",
    "settings, language, about" to
        "設定、言語、概要",
    "signed and read back" to
        "署名して読み戻し済み",
    "spent on the model, as FLOP's explorer sees it" to
        "モデルに使った額（FLOPのエクスプローラー上）",
    "start" to
        "始める",
    "the proof" to
        "証拠",
    "to do" to
        "やること",
    "today" to
        "今日",
    "today's question: {q}" to
        "今日の質問：{q}",
    "trial over" to
        "試用終了",
    "use an address I already have" to
        "手持ちのアドレスを使う",
    "validators" to
        "バリデーター",
    "what is happening now" to
        "いま起きていること",
    "what your wallet will show" to
        "ウォレットに表示される内容",
    "where flop stands" to
        "FLOPの現状",
    "your flop address" to
        "あなたのFLOPアドレス",
    "{day} was missed and forgiven: one missed day a week is." to
        "{day}は抜けましたが見逃されました。週に一日までは見逃されます。",
    "{h} h {m} min" to
        "{h}時間{m}分",
    "{m} min" to
        "{m}分",
    "{n} d ago" to
        "{n}日前",
    "{n} h ago" to
        "{n}時間前",
    "{n} min ago" to
        "{n}分前",
    "Today" to "今日",
    "Ask" to "質問",
    "Network" to "ネットワーク",
    "{host} is on FLOP's official list." to "{host} は FLOP の公式リストにあります。",
    "This is FLOP's own account on {host}." to "これは {host} 上の FLOP 自身のアカウントです。",
    "This is on {host}, but not FLOP's account there. FLOP's is {account}." to "これは {host} 上ですが、FLOP のアカウントではありません。FLOP のアカウントは {account} です。",
    "{host} uses the FLOP name but is not on FLOP's official list. Treat it as an impersonation." to "{host} は FLOP の名前を使っていますが、FLOP の公式リストにはありません。なりすましとして扱ってください。",
    "{host} is not FLOP. That does not make it bad, only not FLOP." to "{host} は FLOP ではありません。悪いという意味ではなく、FLOP ではないというだけです。",
    // The faucet came back (2026-11-03).
    "The faucet works" to
        "フォーセットは動いています",
    "FLOP's faucet gives each address 25 FLOP once every 24 hours. It can be slow: an answer may take a minute or two. The app waits for it and checks your balance." to
        "FLOP のフォーセットは各アドレスに 24 時間ごとに 25 FLOP を配ります。遅いことがあり、応答に 1〜2 分かかる場合があります。アプリは応答を待ち、残高を確認します。",
    "Your FLOP comes from FLOP's faucet: 25 FLOP once every 24 hours. Press do my day and wait, the faucet can take a minute or two. If the balance stays 0, the faucet step says why." to
        "FLOP は FLOP のフォーセットから届きます。24 時間ごとに 25 FLOP です。「今日の分をやる」を押して待ってください。フォーセットは 1〜2 分かかることがあります。残高が 0 のままなら、フォーセットの手順に理由が表示されます。",
    // Review fixes before the 2.0 release (2026-11-03).
    "The faucet is limiting requests from your network right now. Nothing arrived; try again later." to
        "フォーセットは今、あなたのネットワークからのリクエストを制限しています。何も届いていません。後でもう一度お試しください。",
    "FLOP's gateway sent a sign-in text this app does not recognise, so it was not signed. Nothing happened." to
        "FLOP のゲートウェイがこのアプリの知らないサインイン文を送ってきたため、署名しませんでした。何も起きていません。",
    "The faucet said no: {reason}" to
        "フォーセットが拒否しました：{reason}",
    "The gateway said no: {reason}" to
        "ゲートウェイが拒否しました：{reason}",
    "The model did not answer: {reason}" to
        "モデルが答えませんでした：{reason}",
    "Only https links can be FLOP's. Type FLOP's address yourself instead of following this one." to
        "FLOP のリンクは https だけです。このリンクを開かず、FLOP のアドレスを自分で入力してください。",
    "Sign today to keep your streak. This week's one forgiven day is already used." to
        "連続記録を守るには今日署名してください。今週の許される 1 日はもう使いました。",
    // The model allowance is what the gateway says, not a fixed number (2026-11-03).
    "On devnet FLOP gives each account one allowance to spend on the model within 24 hours, and needs at least 1 FLOP on the account to start it. The Ask tab shows how much is left. When it is over, it stays over until testnet." to
        "devnet では FLOP が各アカウントに 24 時間使えるモデル用の枠を 1 つ与え、開始にはアカウントに 1 FLOP 以上が必要です。残りは「質問」タブに表示されます。使い切ると testnet まで閉じたままです。",
    "FLOP gives each account one devnet allowance for 24 hours. The figure above is what is left of it. When it is over it is over until testnet." to
        "FLOP は各アカウントに 24 時間の devnet 枠を 1 つ与えます。上の数字がその残りです。使い切ると testnet まで閉じたままです。",
    "It needs at least 1 FLOP on your Passport address first. On devnet each account also gets only one trial, for 24 hours. After that it stays closed until testnet. The Ask tab says which one it is." to
        "まず、Passport のアドレスに 1 FLOP 以上が必要です。さらに devnet では各アカウントに試用が 1 回だけ、24 時間です。その後は testnet まで閉じたままです。どちらに当たるかは「質問」タブに表示されます。",
    "To use the model, your Passport signs a short statement from api.flop.network. That signature moves nothing. FLOP then opens an allowance for your account: on devnet one, for 24 hours, and your account needs at least 1 FLOP to start it. The Ask tab shows how much of it is left. An answer costs about 0.006 FLOP per word-piece, usually one or two FLOP. When the allowance ends, the model stays closed for that account until testnet." to
        "モデルを使うには、Passport が api.flop.network からの短い文に署名します。この署名は何も動かしません。次に FLOP があなたのアカウントに枠を開きます。devnet では 1 つ、24 時間で、開始にはアカウントに 1 FLOP 以上が必要です。残りは「質問」タブに表示されます。回答は単語片 1 つあたり約 0.006 FLOP、たいてい 1〜2 FLOP です。枠が終わると、そのアカウントのモデルは testnet まで閉じたままです。",
    // The faucet's two other refusals, seen 3-4 November 2026.
    "The faucet has your request in its queue and has not sent the FLOP yet. This can take a while. Press do my day again later." to
        "リクエストはフォーセットの順番待ちで、FLOP はまだ送られていません。時間がかかることがあります。後でもう一度「今日の分をやる」を押してください。",
    "The faucet has given out all of today's FLOP. Nothing arrived. It opens again within hours, so try later." to
        "フォーセットは今日の FLOP を配り終えました。何も届いていません。数時間以内に再開するので、後でお試しください。",
    "Signing today's line with your Passport and reading it back from technocore.chat…" to
        "今日の記録をPassportで署名し、technocore.chatから読み戻しています…",
    "Asking FLOP's faucet. It serves about 10 people a minute, so this can take up to 2 minutes." to
        "FLOPのフォーセットに依頼しています。1分に約10人を処理するため、最大2分かかることがあります。",
    "You are in the faucet's queue. The app watches your balance and asks again by itself." to
        "フォーセットの順番待ちです。アプリが残高を確認し、自動でもう一度依頼します。",
    "Reading your balance…" to
        "残高を読み取っています…",
    "Sending your question to the model. It has up to 90 seconds to answer." to
        "質問をモデルに送っています。回答までの時間は最大90秒です。",
    "FLOP's gateway is full right now: many people are asking at once. Nothing was spent. The app tries again by itself." to
        "FLOPのゲートウェイは現在満杯です。多くの人が同時に質問しています。費用はかかっていません。アプリが自動で再試行します。",
    "Your FLOP is still settling on the network. The app tries again by itself." to
        "FLOPはまだネットワークで確定中です。アプリが自動で再試行します。",
    "Reading what the answer cost…" to
        "回答の費用を読み取っています…",
    "FLOP's gateway stayed full through every try. Nothing was spent. Try again in a few minutes." to
        "すべての試行でFLOPのゲートウェイは満杯でした。費用はかかっていません。数分後にもう一度お試しください。",
    "{n} s so far" to
        "{n}秒経過",
    "try {n} of {m}" to
        "試行 {n}/{m}",
    "next try in {n} s" to
        "{n}秒後に再試行",
    "gateway ping {n} ms" to
        "ゲートウェイのping {n} ms",
    "faucet ping {n} ms" to
        "フォーセットのping {n} ms",
    "the gateway does not answer a ping" to
        "ゲートウェイがpingに応答しません",
    "the faucet does not answer a ping" to
        "フォーセットがpingに応答しません",
    "step {n} of 3" to
        "ステップ {n}/3",
    "ping" to
        "ping",
    "no answer" to
        "応答なし",
    "last answer took" to
        "前回の回答にかかった時間",
    "You can leave this screen: it keeps going." to
        "この画面を離れても処理は続きます。",
    "Signing today's line" to
        "今日の一行に署名中",
    "Your Passport signs one short line in the public room and reads it back. That line is your day." to
        "Passportが公開ルームに短い一行を署名し、読み戻します。その一行があなたの一日です。",
    "Asking FLOP's faucet" to
        "FLOPのフォーセットにお願い中",
    "The faucet pays about 10 people a minute. This can take up to two minutes." to
        "フォーセットは1分に約10人へ配布します。最大2分ほどかかることがあります。",
    "Standing in the faucet's queue" to
        "フォーセットの順番待ち中",
    "The faucet pays about 10 people a minute. Your request is in. We watch your balance and ask again by ourselves." to
        "フォーセットは1分に約10人へ配布します。リクエストは受け付け済みです。残高を見守り、こちらで自動的にもう一度お願いします。",
    "Your FLOP is on its way" to
        "FLOPが届く途中です",
    "One moment." to
        "少々お待ちください。",
    "Opening the model" to
        "モデルを開いています",
    "Your Passport signs the gateway's statement. Nothing is spent." to
        "Passportがゲートウェイの声明に署名します。何も使われません。",
    "Asking the model" to
        "モデルに質問中",
    "Your question is with the model. It has up to 90 seconds." to
        "質問はモデルに届いています。最長90秒かかります。",
    "The model is full right now" to
        "今はモデルが満員です",
    "Many people are asking at once. Nothing was spent. We try again by ourselves." to
        "多くの人が同時に質問しています。何も使われていません。こちらで自動的に再試行します。",
    "Your FLOP is still settling" to
        "FLOPがまだ反映中です",
    "A fresh grant takes a moment to count. We try again by ourselves." to
        "新しく受け取った分が数えられるまで少しかかります。こちらで自動的に再試行します。",
    "Reading what it cost" to
        "費用を確認中",
    "FLOP's gateway stayed full through all 6 tries. Nothing was spent. This is on FLOP's side, not yours." to
        "FLOPのゲートウェイは6回とも満員でした。何も使われていません。原因はFLOP側で、あなたのせいではありません。",
    "to next try" to
        "次の試行まで",
    "elapsed {t}" to
        "経過 {t}",
    "ask the model" to
        "モデルに質問",
    "Answered" to
        "回答済み",
    "cost {c} FLOP · {s} s" to
        "費用 {c} FLOP · {s}秒",
    "The model did not answer" to
        "モデルから回答がありませんでした",
    "your question" to
        "あなたの質問",
    "waiting" to
        "待機中",
    "Connect your Passport" to
        "Passportを接続",
    "Get the answer" to
        "回答を受け取る",
    "minimise · it keeps going" to
        "最小化 · 動作は続きます",
    "my day · step {n} of 3" to
        "今日の分 · ステップ {n}/3",
    "my day" to
        "今日の分",
    "Your day is closed" to
        "今日は完了です",
    "See you tomorrow." to
        "また明日。",
    "Today is signed" to
        "今日は署名済み",
    "not today" to
        "今日はなし",
    "Could not sign today" to
        "今日は署名できませんでした",
    "Your day is signed. Your streak of {n} is safe whatever happens next." to
        "今日の署名は完了です。{n}日の連続記録は何があっても安全です。",
    "Today is not signed yet. One missed day a week is forgiven; two in a row end the streak." to
        "今日はまだ署名していません。週に1日の休みは許されますが、2日続けて休むと連続記録は終わります。",
    "question of the day: {q}" to
        "今日の質問: {q}",
    "Part of your day waits" to
        "今日の一部が待っています",
    "passport · {name}" to
        "passport · {name}",
    "Days in a row: {n}" to
        "連続日数: {n}",
    "Start your streak today" to
        "今日から連続記録を始めましょう",
    "Registered {date} · day {n} with us" to
        "登録日 {date} · 一緒に過ごして{n}日目",
    "reading your days" to
        "日々を読み込み中",
    "today signed" to
        "今日は署名済み",
    "sign today or the streak ends" to
        "今日署名しないと連続記録が途切れます",
    "today not signed yet" to
        "今日はまだ署名していません",
    "in a row" to
        "連続",
    "{n} of 3" to
        "{n}/3",
    "Your Passport signs one public line. That line is your streak." to
        "Passportが公開の一行に署名します。その一行があなたの連続記録です。",
    "From FLOP's faucet, once a day. Practice coins, no price." to
        "FLOPのフォーセットから1日1回。練習用のコインで、価格はありません。",
    "One question of the day, paid in FLOP." to
        "毎日ひとつの質問、支払いはFLOPで。",
    "One press, all three steps in order. What is already done is skipped." to
        "ワンタップで3つのステップを順番に。済んでいるものは飛ばします。",
    "devnet · practice network" to
        "devnet · 練習用ネットワーク",
    "one key · two networks" to
        "ひとつの鍵 · ふたつのネットワーク",
    "Seeker wallet" to
        "Seekerウォレット",
    "Made the Passport with one signature. Brings it back on any phone." to
        "署名ひとつでPassportを作成しました。どの端末でも復元できます。",
    "FLOP account" to
        "FLOPアカウント",
    "The same key as a FLOP address. The faucet pays here; the model is paid from here." to
        "FLOPアドレスとして表した同じ鍵です。フォーセットはここへ配布し、モデルの支払いもここから行います。",
    "Registered" to
        "登録日",
    "Days in a row" to
        "連続日数",
    "Best streak" to
        "最長記録",
    "Signed days" to
        "署名した日数",
    "Balance, FLOP" to
        "残高、FLOP",
    "Spent on the model, FLOP" to
        "モデルに使った分、FLOP",
    "1 skip left this week" to
        "今週あと1日お休みOK",
    "this week's skip is used" to
        "今週のお休みは使用済み",
    "details and key" to
        "詳細と鍵",
    "On Seeker · in FLOP Network · an app by Alex Kosa, not FLOP Labs, not Solana Mobile" to
        "Seeker上 · FLOPネットワーク内 · Alex Kosaのアプリです。FLOP LabsやSolana Mobileのものではありません",
    "days signed together" to
        "みんなで署名した日数",
    "flop pulse" to
        "flopパルス",
    "Devnet is a practice network, open to everyone since 3 November. Coins have no price, there is no reward." to
        "Devnetは練習用ネットワークで、11月3日から誰でも使えます。コインに価格はなく、報酬もありません。",
    "more about the network" to
        "ネットワークについてもっと",
    "thanks to both sides" to
        "両方に感謝",
    "for Seeker, the wallet and one-tap signing" to
        "Seeker、ウォレット、ワンタップ署名に",
    "for the network, the faucet and a model you can pay" to
        "ネットワーク、フォーセット、支払えるモデルに",
    "An independent app by Alex Kosa. No promises about tokens or rewards." to
        "Alex Kosaによる独立したアプリです。トークンや報酬の約束はありません。",
    "check a link, an @name or an address someone sent you" to
        "届いたリンク、@名前、アドレスを確認",
    "check" to
        "確認",
    "FLOP model" to
        "FLOPモデル",
    "The model is small: short, plain questions work best. Everything you pay is practice FLOP." to
        "モデルは小さめです。短くて簡単な質問が一番うまくいきます。支払うのはすべて練習用のFLOPです。",
    "model open" to
        "モデル利用可",
    "opening the model" to
        "モデルを開いています",
    "trial over for this account" to
        "このアカウントのお試しは終了",
    "needs 1 flop" to
        "1 flop 必要",
    "model closed for now" to
        "モデルは今は閉じています",
    "first question opens it" to
        "最初の質問で開きます",
    "ping {n} ms" to
        "ping {n} ms",
    "Your Passport signs a short statement from FLOP's gateway. Nothing moves. You need at least 1 FLOP; the faucet on Today gives you 25." to
        "PassportがFLOPゲートウェイの短い声明に署名します。何も動きません。1 FLOP以上が必要です。今日タブのフォーセットで25もらえます。",
    "more" to
        "もっと見る",
    "That was the last step. Your Passport is live, and your day on FLOP starts now." to
        "これで最後のステップです。Passportの準備ができ、FLOPでのあなたの一日が始まります。",
    "Pulse" to
        "いま",
    "Who is here, and how FLOP's network is doing today." to
        "誰がいて、FLOPネットワークが今日どんな様子かを示します。",
    "who is here" to
        "ここにいる人",
    "Passport holders" to
        "Passport保有者",
    "{n} Passport holders · {m} signed today" to
        "Passport保有者 {n}人 · 今日の署名 {m}人",
    "{n} of them signed today" to
        "うち今日の署名: {n}人",
    "To keep a streak, each holder signs one short public line a day. Counted from that public record, so anyone can repeat it." to
        "連続記録を続けるため、保有者は毎日短い公開の一行に署名します。この公開記録から数えているので、誰でも確かめられます。",
    "same key" to
        "同じ鍵",
    "knock now" to
        "今すぐノック",
    "A refused knock costs nothing. Knock as often as you like." to
        "断られても費用はかかりません。何度でもノックできます。",
    "FLOP spent on the model, all time" to
        "モデルに使われたFLOP、累計",
    "accounts that paid for the model" to
        "モデルに支払ったアカウント",
    "Join FLOP with Alex's link" to
        "Alexのリンクで FLOP へ",
    "This is Alex Kosa's personal referral link from FLOP, and it may count for him. It gives you nothing extra from this app. Prefer not to? Go to flop.finance yourself." to
        "これはFLOPが発行したAlex Kosaの個人紹介リンクで、彼の実績として数えられることがあります。このアプリから追加で得られるものはありません。使いたくなければ、flop.finance へ直接どうぞ。",
    "open {host}" to
        "{host} を開く",
)
