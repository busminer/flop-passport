package dev.alexkosa.floppassport.i18n

/**
 * Simplified Chinese.
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
internal val ZH_STRINGS: Map<String, String> = mapOf(
    "06  tell them" to "06  告诉大家",
    "5 of 6" to "6 步中的 5 步",
    "A few more words, and it is yours. One real sentence is all this needs." to
        "再写几个字就成了。只需要一句真话。",
    "A few reminders about the last step, and then they stop." to "关于最后一步的几条提醒，之后就不再打扰。",
    "A little too long. Trim it and the whole post fits, key included." to
        "有点长了。删短一些，整条帖子连同密钥就都放得下。",
    "A once-a-day reminder to leave today's signed record." to "每天提醒一次，留下当天的签名记录。",
    "A public note at an address derived from your key, so anyone can find and verify you later. This one goes to technocore.chat, which is someone else's public service: when it is busy it refuses, and pressing again is the answer. Two or three attempts is normal and means nothing is wrong with your phone." to
        "一条公开备注，地址由你的密钥算出，方便别人以后找到并核验你。这一步要发往 technocore.chat，那是别人的公共服务：繁忙时它会拒绝，办法就是再按一次。尝试两三次很正常，说明你的手机没有问题。",
    "A signed record has to be left by hand, and a missed day cannot be filled in later. This is also the switch that warns you before your identity note is deleted." to
        "签署的记录必须手动留下，错过的日期以后无法补上。此开关还会在你的身份备注被删除前提醒你。",
    "A tip changes nothing about your Passport and nothing about any airdrop." to
        "打赏不会改变你的 Passport，也不会影响任何空投。",
    "A tip changes nothing about your Passport, and nothing about any airdrop. It is a thank you, not a fee." to
        "打赏不会改变你的 Passport，也不会影响任何空投。这是致谢，不是费用。",
    "About" to "关于",
    "Accepted, but we could not read it back yet" to "已接受，但暂时无法读回",
    "Activity" to "活动",
    "All six done" to "六步全部完成",
    "Already checked in, found in the room" to "已留下签名记录，并在房间中找到",
    "Already published, read back just now" to "已发布，刚刚已读回",
    "Android is blocking notifications for this app. Turn them on in the system settings." to
        "Android 已阻止此应用发送通知。请在系统设置中将其开启。",
    "Anyone can check it at the address in step 03. This app promises nothing about any allocation, and never will." to
        "任何人都能在步骤 03 的地址查看。本应用不对任何分配作出承诺，以后也不会。",
    "Anyone holding it can sign as you" to "任何持有者都能以你的身份签名",
    "Anyone holding seed_hex can sign as this identity on Technocore." to
        "任何持有 seed_hex 的人都能在 Technocore 上以此身份签名。",
    "Anyone who looks it up sees a key and nothing else." to "别人查到的只有一把密钥，别无其他。",
    "Anyone with this can be you" to "任何持有此内容的人都能冒充你",
    "Apply" to "应用",
    "Cancel" to "取消",
    "Check in" to "留下签名记录",
    "Check your connection and try again." to "请检查连接后重试。",
    "Could not open the security prompt on this screen." to "无法在此屏幕上打开安全提示。",
    "Could not reach technocore.chat" to "无法连接 technocore.chat",
    "Could not reach technocore.chat. This says nothing about your records, only about the connection." to
        "无法连接 technocore.chat。这只说明连接存在问题，与你的记录无关。",
    "Could not reach the server." to "无法连接到服务器。",
    "Could not read the key back from secure storage" to "无法从安全存储中读回密钥",
    "Create" to "创建",
    "Create your Passport" to "创建你的 Passport",
    "Create your Passport first. There is nothing to show until something has been signed." to
        "请先创建你的 Passport。在签署内容之前，没有可显示的内容。",
    "Daily activity" to "每日活动",
    "Daily reminder" to "每日提醒",
    "Delete it?" to "删除？",
    "Deleting removes the Passport from this phone only. Anything already published may stay public, and the same wallet rebuilds the same identity - so this is not a way to undo anything." to
        "删除操作只会从此手机移除 Passport。已发布的内容可能仍会保持公开，使用同一钱包也会重建出同一身份，因此这无法撤销任何操作。",
    "Did you post it?" to "发出去了吗？",
    "Every language listed here has a full translation." to "此处列出的每种语言都有完整翻译。",
    "FLOP Passport creates a Technocore identity from your Solana wallet and keeps the receipts." to
        "FLOP Passport 根据你的 Solana 钱包创建 Technocore 身份并保留凭据。",
    "FLOP Passport for Seeker" to "Seeker 版 FLOP Passport",
    "FLOP Passport for Seeker - private backup" to "Seeker 版 FLOP Passport - 私密备份",
    "FLOP Passport for Seeker by @AlexKosa1" to "由 @AlexKosa1 制作的 Seeker 版 FLOP Passport",
    "FLOP asked agents to do two things: create a unique key, and do something useful to spread the word about Technocore. The five steps above did the first. Nobody can do the second for you, so this writes the post and you decide whether to send it." to
        "FLOP 要求代理完成两件事：创建一个唯一密钥，并做些有用的事来宣传 Technocore。上面的五个步骤完成了第一件事。第二件事没人能替你做，所以这里会写好帖子，由你决定是否发布。",
    "Identity derived from your wallet signature" to "由你的钱包签名派生的身份",
    "If it does get deleted, your Passport is not gone: the same wallet still gives the same identity, and signing a record publishes the note back to the same address." to
        "即使它被删除，你的 Passport 也没有消失：同一个钱包仍会生成相同的身份，签署一条记录即可将备注重新发布到同一地址。",
    "In one line: what you did, or why you set this up" to "用一句话说：你做了什么，或者为什么建立它",
    "It never asks for your wallet recovery phrase." to "它绝不会要求你提供钱包恢复助记词。",
    "It promises nothing about any airdrop, and never will." to "它不对任何空投作出承诺，以后也不会。",
    "Keep this file offline. Never send it to anyone, including the app author." to
        "请离线保存此文件。绝不要发送给任何人，包括应用作者。",
    "Language" to "语言",
    "Last reminder about this one." to "关于这件事，这是最后一次提醒。",
    "Make your first signed check-in" to "留下首条签名记录",
    "Next: create your Passport from your wallet." to "下一步：通过钱包创建 Passport。",
    "Next: make your first signed check-in." to "下一步：留下首条签名记录。",
    "Next: publish your identity so anyone can verify you." to "下一步：发布身份，让任何人都能验证你。",
    "Next: seal the key in this phone's secure storage." to "下一步：将密钥封存在此手机的安全存储中。",
    "No account, no server of ours, no analytics." to "无需账号，没有我们的服务器，也没有数据分析。",
    "No wallet on this phone opened the payment link." to "此手机上没有钱包打开付款链接。",
    "No. Nothing was published." to "没有。未发布任何内容。",
    "Not checked yet." to "尚未检查。",
    "Not done. Your Passport is not attached to any public name yet, and this is the one step nobody can do for you." to
        "尚未完成。你的 Passport 还没有绑定任何公开名字，而这一步没有人能替你做。",
    "Nothing asked yet" to "尚未提出请求",
    "Nothing found. If you signed something and it is not here, the room has been trimmed past it - which is normal, and exactly why this screen exists." to
        "未找到任何内容。如果你签署过内容但这里没有显示，说明房间已清理掉该记录。这是正常情况，也是此页面存在的原因。",
    "Nothing has vouched for this text yet. Publish again to sign for it." to
        "尚无任何内容为这段文本背书。请再次发布以为其签名。",
    "Nothing is broken and nothing is lost. Your Passport works. When you want the public half of it, step 06 is waiting where you left it." to
        "没有出错，也没有丢失任何东西。你的 Passport 是好用的。等你想要它公开的那一半时，第 06 步还在你离开的地方等着。",
    "Nothing signed today yet." to "今天尚未签署任何记录。",
    "One step left" to "还剩一步",
    "Only languages with a real translation are listed. A picker offering languages that all render English would say your language is supported and then prove otherwise on the next screen." to
        "仅列出已有实际翻译的语言。如果语言选择器列出的语言都显示为英文，它会声称支持你的语言，却在下一屏显示事实并非如此。",
    "Opening a connection" to "正在建立连接",
    "Opening your Solana wallet" to "正在打开你的 Solana 钱包",
    "Post your line, then come back and paste the link. That is what attaches your name to your key, and it is the half FLOP asked agents for." to
        "发出你的那句话，然后回来贴上链接。正是这一步把你的名字系到你的密钥上，也正是 FLOP 要求代理去做的那一半。",
    "Protect" to "保护",
    "Protect it" to "保护它",
    "Publish" to "发布",
    "Publish your identity" to "发布你的身份",
    "Published and read back from the server" to "已发布并从服务器读回",
    "Published, read back, and vouched for by your key" to "已发布、读回并由你的密钥背书",
    "Publishing your identity note to technocore.chat" to "正在将身份备注发布到 technocore.chat",
    "Publishing your note" to "正在发布你的备注",
    "Questions, answered in full" to "问题详解",
    "Read from technocore.chat just now, not from this phone. Rooms are trimmed as they grow, so this is what anyone would find today." to
        "刚刚从 technocore.chat 读取，并非来自此手机。房间会随内容增加而清理，因此这是任何人今天能找到的内容。",
    "Reading your note" to "正在读取你的备注",
    "Reading your records" to "正在读取你的记录",
    "Ready" to "就绪",
    "Remind me once a day" to "每天提醒我一次",
    "Renewed today. technocore.chat keeps it for seven days after the last write, and this app rewrites it every time you open it." to
        "今天已续期。technocore.chat 会从最后一次写入起保留七天，并且你每次打开此应用时，应用都会重写它。",
    "Sealed by Android Keystore" to "由 Android Keystore 封存",
    "Sealed by StrongBox, this phone's separate security chip" to "由 StrongBox 封存，即此手机的独立安全芯片",
    "Sealed by this phone's trusted execution environment" to "由此手机的可信执行环境封存",
    "Sealing the key in this device's secure storage" to "正在将密钥封存在此设备的安全存储中",
    "Sending your signed record" to "正在发送你的签名记录",
    "Sent, but not confirmed in the room yet" to "已发送，但尚未在房间中确认",
    "Settings" to "设置",
    "Show your private key" to "显示你的私钥",
    "Signed, accepted and found again in the room" to "已签名、接受并再次在房间中找到",
    "Signing your first check-in and sending it" to "正在签署并发送你的首条记录",
    "Somebody changed this note after your key signed for it. Publish again." to
        "在你的密钥为这条备注背书之后，有人改动了它。请再次发布。",
    "Still one step short" to "仍然差一步",
    "Talking to the service" to "正在与服务通信",
    "Thanks for building this" to "感谢开发此应用",
    "That does not look like a link to a post. It should look like https://x.com/you/status/123." to
        "这看起来不像帖子链接。格式应该类似 https://x.com/you/status/123。",
    "The key is sealed in this phone's secure storage, then read back and checked against your identity." to
        "密钥封存在此手机的安全存储中，随后读回并与你的身份核对。",
    "The manual" to "手册",
    "The server is busy. Trying again." to "服务器繁忙。正在重试。",
    "The stored key does not match your identity" to "存储的密钥与你的身份不匹配",
    "The wallet did not complete the signature" to "钱包未完成签名",
    "There are no points here and no score. FLOP asked agents to do something useful, so what counts is a record a person can still open. A number invented by this app would be a different game." to
        "这里没有积分，也没有分数。FLOP 要求代理完成有用的事情，因此有意义的是人们仍能打开的记录。由本应用编造一个数字会变成另一种游戏。",
    "These 32 bytes are your FLOP Passport itself. Whoever holds them can sign as you on Technocore. Keep them offline and never send them to anyone, including us." to
        "这 32 字节就是你的 FLOP Passport。任何持有者都能在 Technocore 上以你的身份签名。请离线保存，绝不要发送给任何人，包括我们。",
    "This app is free and open source, and nobody paid for it. If it saved you an afternoon, a tip is welcome." to
        "本应用免费且开源，没有人为它付费。如果它为你节省了一个下午，可以选择打赏。",
    "This app is free and open source. If it was useful, you can send a tip to {name}. Your wallet opens and you choose the amount there." to
        "本应用免费且开源。如果它对你有用，可以向 {name} 发送打赏。你的钱包会打开，金额由你在钱包中选择。",
    "This app rewrites your note every time you open it and every time you sign a record, so the seven days start again. Open it at least once a week and nothing is ever lost." to
        "每次打开此应用或签署记录时，应用都会重写你的备注，并重新开始计算七天。每周至少打开一次，就不会丢失任何内容。",
    "This is NOT your Solana wallet key. Your wallet's own key never leaves Seed Vault and this app has never seen it. What you are looking at is a separate key that signs only on Technocore." to
        "这不是你的 Solana 钱包密钥。钱包自身的密钥从未离开 Seed Vault，本应用也从未读取过它。你看到的是一把独立密钥，只用于在 Technocore 上签名。",
    "This line is what makes the post yours. Everything under it is the proof." to
        "这一句才让这条帖子属于你。下面的一切都是证据。",
    "Three days left before it is deleted." to "距离删除还剩三天。",
    "Today cannot be added later" to "今天无法事后补上",
    "Told only when your identity note is days away from being deleted." to
        "只有当你的身份备注再过几天就会被删除时，你才会收到通知。",
    "Tomorrow is the last day." to "明天是最后一天。",
    "Two days left before it is deleted." to "距离删除还剩两天。",
    "Unfinished setup" to "未完成的设置",
    "Use the phone's language" to "使用手机的语言",
    "Wait a moment and press it again to re-check. Do not treat this as a failure." to
        "请稍候片刻，再次按下以重新检查。不要将此视为失败。",
    "Wait a moment and press it again to re-check. Sending it as a new message would post twice in public." to
        "请稍候片刻，再次按下以重新检查。作为新消息发送会公开发布两次。",
    "What is still provable" to "仍可证明的内容",
    "What recovery without a seed phrase costs" to "无需助记词的恢复方式，代价是什么",
    "What to do and how often, why the identity expires, why this works on a Seeker, and what the catch is. Opens in your browser." to
        "该做什么、多久做一次，为什么身份会过期，为什么这能在 Seeker 上运行，以及有什么需要注意。将在浏览器中打开。",
    "Write one line only you would write. Posts that differ from each other by nothing but a key get read as farming, and that lands on the people who did the work." to
        "写一句只有你会写的话。彼此之间只差一个密钥的帖子会被当成刷量，而代价由真正做事的人承担。",
    "Yes. Something is already visible to others." to "是。已有内容对其他人可见。",
    "You do not need this file to recover. The same Solana wallet that" to
        "恢复时不需要此文件。创建它的同一 Solana 钱包",
    "You do not need this to recover. The same Solana wallet rebuilds the same Passport on any phone. This copy is for using the key somewhere else, on your own terms." to
        "恢复时不需要此内容。同一 Solana 钱包可在任何手机上重建相同的 Passport。此副本用于由你自行决定在其他地方使用该密钥。",
    "You finished the five. The last one takes a minute." to "五步你已经走完了。最后一步只要一分钟。",
    "You have already checked in" to "你已留下签名记录",
    "You have already left a record today." to "你今天已经留下了一条记录。",
    "You're all set" to "已完成设置",
    "Your Passport has no name on it" to "你的 Passport 上没有名字",
    "Your Passport is derived from one signature your wallet makes inside Seed Vault, the Seeker's hardware key store. The wallet key never leaves that hardware. The Passport key is computed from its signature in this app and then sealed by Android's secure storage - sealed, not signed, in hardware, because Android Keystore cannot hold this kind of key." to
        "你的 Passport 派生自钱包在 Seeker 的硬件密钥存储区 Seed Vault 中生成的一次签名。钱包密钥始终留在该硬件中。此应用根据该签名计算出 Passport 密钥，再由 Android 的安全存储在硬件中封存，而非签名，因为 Android Keystore 无法保存此类密钥。",
    "Your Passport is live" to "你的 Passport 已生效",
    "Your Passport is live and your first signed record is on Technocore. Anyone can verify it, and it stays yours." to
        "你的 Passport 已生效，首条签名记录已发布到 Technocore。任何人都能验证，它始终属于你。",
    "Your Passport is live. One step left." to "你的 Passport 已生效。还剩一步。",
    "Your Passport is rebuilt from one wallet signature, which is why no seed phrase exists to lose. The same fact cuts the other way: any app that persuades your wallet to sign that exact sentence can rebuild this Passport. Read what a wallet asks you to sign, here and everywhere else." to
        "你的 Passport 由一次钱包签名重建，因此没有会丢失的助记词。反过来也成立：任何能让你的钱包签署那句一模一样的话的应用，都能重建这个 Passport。请阅读钱包要求你签署的内容，在这里，也在任何地方。",
    "Your identity note expires soon" to "你的身份备注即将过期",
    "Your identity note has been deleted" to "你的身份备注已被删除",
    "Your key is never sent anywhere. Only you can export it." to "你的密钥不会发送到任何地方。只有你可以将其导出。",
    "Your key signed a line carrying this note's exact hash." to "你的密钥签署了一行，其中带有这条备注的确切哈希值。",
    "Your note has to be kept alive" to "你的备注需要保持有效",
    "Your post is in your identity note, at your key's own address." to
        "你的帖子已在你的身份备注里，就在你密钥自己的地址上。",
    "Your wallet signs one statement. It is not a transaction and moves no funds. The same wallet rebuilds the same Passport on any device." to
        "你的钱包只签署一项声明。这不是交易，也不会转移资金。同一钱包可在任何设备上重建相同的 Passport。",
    "active days" to "活跃天数",
    "activity" to "活动",
    "address" to "地址",
    "algorithm: Ed25519, did:key, 32-byte seed" to "算法：Ed25519、did:key、32 字节种子",
    "attach it" to "绑定",
    "built by a community builder" to "由社区开发者构建",
    "cancel" to "取消",
    "change" to "更改",
    "changed" to "已更改",
    "check again" to "再检查一次",
    "checked" to "已检查",
    "close" to "关闭",
    "connection" to "连接",
    "content" to "内容",
    "continue" to "继续",
    "copy" to "复制",
    "copy key" to "复制密钥",
    "create passport" to "创建 Passport",
    "created this Passport rebuilds it on any device." to "可在任何设备上重建此 Passport。",
    "danger zone" to "危险区域",
    "day streak" to "连续天数",
    "delete passport from this phone" to "从此手机删除 Passport",
    "detail" to "详情",
    "did anything go public?" to "是否有内容已公开？",
    "done" to "完成",
    "failed" to "失败",
    "fetched again and matched exactly" to "再次获取并完全匹配",
    "fetched from the server on opening" to "打开时从服务器获取",
    "fingerprint" to "指纹",
    "flop-passport vault self-test" to "flop-passport 密钥库自检",
    "identity" to "身份",
    "identity note" to "身份备注",
    "language {code}" to "语言 {code}",
    "last connection" to "上次连接",
    "linked" to "已关联",
    "live records" to "现存记录",
    "matched on our nonce, not just our key" to "与我们的随机数匹配，而不只是密钥",
    "no thanks, continue" to "不用了，继续",
    "no, nothing was made public" to "没有，未公开任何内容",
    "nonce" to "随机数",
    "not found" to "未找到",
    "not yet" to "暂时不",
    "not yet - the note alone is a claim, not a proof" to "尚未：单独的备注只是声明，不是证明",
    "off" to "关",
    "on" to "开",
    "open" to "打开",
    "our exact bytes, no wallet prefix" to "与我们的字节完全一致，无钱包前缀",
    "passport for seeker" to "Seeker 版 Passport",
    "pin it to your identity" to "固定到你的身份",
    "private key, 32 bytes, hex" to "私钥，32 字节，十六进制",
    "protect passport" to "保护 Passport",
    "publish identity" to "发布身份",
    "published" to "已发布",
    "publishing" to "发布中",
    "re-check with the server" to "向服务器重新检查",
    "re-checked when the app opened" to "应用打开时已重新检查",
    "records the server still holds" to "服务器仍保留的记录",
    "recovery" to "恢复",
    "room" to "房间",
    "save to a file" to "保存到文件",
    "say it another way" to "换一种说法",
    "self test" to "自检",
    "send a tip" to "发送打赏",
    "send a tip in {token}" to "用 {token} 发送打赏",
    "send a tip to {name}" to "向 {name} 发送打赏",
    "sequence" to "序号",
    "settings" to "设置",
    "sign and check in" to "签名并留下记录",
    "sign today's record" to "签署今天的记录",
    "signed" to "已签名",
    "signed and verified against your DID" to "已签名并根据你的 DID 验证",
    "step {n} {title} complete" to "第 {n} 步 {title} 已完成",
    "step {n} {title} did not finish" to "第 {n} 步 {title} 未完成",
    "storage" to "存储",
    "support the builder" to "支持开发者",
    "technocore.chat answered" to "technocore.chat 已响应",
    "technocore.chat deletes anything nobody has written to for seven days. That includes the identity note at the address you save and share." to
        "technocore.chat 会删除连续七天无人写入的内容。这也包括你保存和分享的地址上的身份备注。",
    "technocore.chat refused the note" to "technocore.chat 拒绝了该备注",
    "technocore.chat refused the signed write" to "technocore.chat 拒绝了签名写入",
    "text" to "文本",
    "the note changed between reads" to "两次读取之间备注发生了变化",
    "the post" to "帖子",
    "the same wallet rebuilds this identity anywhere" to "同一钱包可在任何地方重建此身份",
    "try again" to "再试一次",
    "unconfirmed" to "未确认",
    "unsigned" to "未签名",
    "verified" to "已验证",
    "verify it yourself" to "自行验证",
    "version" to "版本",
    "vouched for" to "已背书",
    "wallet" to "钱包",
    "wallet linked" to "钱包已关联",
    "what this app never does" to "本应用绝不会做的事",
    "what to do" to "操作方法",
    "when" to "时间",
    "working" to "正在处理",
    "yes, a signed did-note line carries its hash" to "是，签名的 did-note 行包含其哈希值",
    "yes, delete" to "是，删除",
    "yes, something is already public" to "是，已有内容公开",
    "your identity" to "你的身份",
    "your private key" to "你的私钥",
    "{token} is preselected and you can switch it." to "已预选 {token}，你可以更换。",
    "Try again. Nothing was sent anywhere." to
        "请再试一次。什么都没有发出去。",
    "Try again. technocore.chat is a public service and it refuses writes when it is busy, which has nothing to do with this app, your phone or your key. Two or three attempts is normal. Nothing was published." to
        "请再试一次。technocore.chat 是一个公共服务，繁忙时会拒绝写入，这和本应用、你的手机、你的密钥都没有关系。试上两三次是正常的。什么都没有发布出去。",
    "Try again. technocore.chat is a public service and it refuses writes when it is busy, which has nothing to do with this app, your phone or your key. Two or three attempts is normal. Nothing was posted." to
        "请再试一次。technocore.chat 是一个公共服务，繁忙时会拒绝写入，这和本应用、你的手机、你的密钥都没有关系。试上两三次是正常的。什么都没有发出去。",
    "Could not reach technocore.chat. Check your connection and try again; nothing was lost." to
        "无法连接 technocore.chat。检查一下网络再试一次，什么都没有丢。",
    "The service took your record but has not shown it back yet. Press re-check in a moment; nothing needs signing again." to
        "服务已经收下你的记录，但还没有把它显示回来。稍后按“重新检查”；不需要再签一次。",
    "technocore.chat refused the record. It refuses writes when it is busy - try again in a moment." to
        "technocore.chat 拒绝了这条记录。它繁忙时会拒绝写入，稍后再试一次。",
    "technocore.chat did not take the change. It refuses writes when it is busy - press publish again in a moment. Your link is saved on this phone either way." to
        "technocore.chat 没有接受这次改动。它繁忙时会拒绝写入，稍后再按一次“发布”。无论如何，你的链接已经存在这台手机上。",
    "Not finished yet. Your Passport is not live until all five are green, and there is nothing complete for anyone to verify. Keep going." to
        "还没有完成。五项全部变绿之前，你的 Passport 尚未生效，也没有完整的东西可供别人核对。继续。",
    "A message signed by your Passport, posted to a quiet room and then read back to prove it landed. Same service as step 03, same rule: if it refuses, press again. That is the service being busy, not a problem with your key." to
        "一条由你的 Passport 签名的消息，发到一个安静的房间，然后再被读回来，以此证明它确实落地了。和第 03 步是同一个服务，规则也一样：被拒绝就再按一次。那是服务繁忙，不是你的密钥有问题。",
    "Deleted after seven days with nothing written to it. Publish it now and it goes back to the same address." to
        "七天之内没有任何写入就会被删除。现在发布一次，它就会回到同一个地址。",
    "Identity note at risk" to
        "身份备注面临删除风险",
    "In Settings, delete the Passport from this phone, then create it again from your wallet." to
        "到“设置”里把 Passport 从这台手机上删除，然后用钱包重新建一个。",
    "It is deleted after seven days with nothing written to it. Opening this app writes it." to
        "七天之内没有任何写入，它就会被删除。打开这个应用本身就是一次写入。",
    "Maybe. The service accepted it, and this app could not read it back to be sure." to
        "也许。服务已经接受了，但这个应用还没能把它读回来加以确认。",
    "That was the last of the five. Your Passport is live. One thing left, and it is the part FLOP actually asked for: tell people what you did. The app writes the post for you at the bottom of this screen." to
        "这是五步里的最后一步。你的 Passport 已经生效。还剩一件事，而它正是 FLOP 真正要求的：告诉别人你做了什么。帖子由应用替你写好，就在这个页面的下方。",
    "This app is free and there is nothing in it to buy. If it has been useful, a thank you can go to kosa.skr." to
        "这个应用是免费的，里面也没有任何东西可买。如果它对你有用，可以给 kosa.skr 一点心意。",
    "checking" to
        "正在检查",
    "open notification settings" to
        "打开通知设置",
    "send a tip to kosa.skr" to
        "给 kosa.skr 送上心意",
    "show my private key" to
        "显示我的私钥",
    "step {n} {title} not confirmed yet" to
        "步骤 {n} {title} 尚未确认",
    "technocore.chat deletes anything with no write for seven days. Opening this app rewrites your note, and so does signing a record. Either one starts the seven days again." to
        "technocore.chat 会删掉七天内无人写入的一切。打开这个应用会重写你的备注，签一条记录也会。两者任意一个都会让七天重新开始。",
    "This phone has no screen lock set up. Add a PIN or a fingerprint first." to
        "这台手机没有设置屏幕锁。请先设置 PIN 码或指纹。",
    "The server accepted the write but the message is not in the room yet. Do not resend: read the room again first." to
        "服务器已经接受了这次写入，但消息还没有出现在房间里。不要重发：先把房间再读一遍。",
    "The stored text differs from the text we signed" to
        "存下来的文字和我们签名的文字不一致",
    "The stored record did not verify against this key" to
        "存下来的记录用这把密钥核对不通过",
    "You made a key only your wallet can rebuild, sealed it in this phone, published it where a stranger can find it, signed a record and proved it landed, and put your post beside your key. There is nothing left to set up." to
        "你建了一把只有你的钱包才能重建的密钥，把它封进这台手机，发布到陌生人也能找到的地方，签下一条记录并证明它确实落地，还把你的帖子放在了密钥旁边。没有什么要再设置的了。",
    "open Activity" to
        "打开“活动”",
    "{n} more characters and the button below wakes up." to
        "再写 {n} 个字，下面的按钮就会亮起来。",
    "Could not check technocore.chat for your published steps. This says nothing about them, only about the connection. Re-check when you are back online." to
        "无法向 technocore.chat 核对你已发布的步骤。这只说明连接有问题，与那些步骤本身无关。恢复联网后再重新检查。",
    "The key could not be sealed in this phone's secure storage" to
        "无法将密钥封存在此手机的安全存储中",
    "Try again. If it keeps failing, restart the phone and try once more. Nothing was sent anywhere." to
        "请再试一次。如果一直失败，重启手机后再试一次。什么都没有发出去。",
    "with a wallet prefix - this Passport rebuilds only through this same wallet app" to
        "带有钱包前缀，此 Passport 只能通过同一个钱包应用重建",
    "Could not reach technocore.chat. Check your connection and press publish again. Your link is saved on this phone either way." to
        "无法连接 technocore.chat。检查一下网络，再按一次“发布”。无论如何，你的链接已经存在这台手机上。",
    "The note was accepted, but it could not be read back yet." to
        "备注已被接受，但暂时还无法读回。",
    "The record was sent but no answer came back in time. Do not resend: read the room again first." to
        "记录已发出，但没有及时收到回应。不要重发：先把房间再读一遍。",
    "The link you paste goes into your identity note, at an address derived from your own key. The note stays as long as you keep opening the app; seven days without a write and it is deleted." to
        "你贴回来的链接会写进你的身份备注，地址由你自己的密钥算出。只要你还在打开这个应用，备注就一直在；七天没有任何写入，它就会被删除。",
    "vault: security chip" to "保管库：安全芯片",
    "vault: secure area" to "保管库：安全区域",
    "vault: software" to "保管库：软件",
    "vault: not sealed yet" to "保管库：尚未封存",
    "Could not read the key from secure storage. Restart the phone and try again." to
        "无法从安全存储中读取密钥。请重启手机后再试。",
    "FLOP Passport is an independent community project. It is not made, endorsed or reviewed by FLOP Labs or by Solana Mobile." to
        "FLOP Passport 是一个独立的社区项目，并非由 FLOP Labs 或 Solana Mobile 制作、认可或审核。",
    "From now on: open the app at least once a week, so your identity note is not deleted. On the days you do something, open Activity and sign that day's record - a day cannot be added later." to
        "从现在起：每周至少打开一次应用，这样你的身份备注就不会被删除。在你做了事情的那天，打开“活动”标签页，签下当天的记录。过去的日子是补不上的。",
    "Link to your post on X" to "你在 X 上的帖子链接",
    "Nothing was saved. Open your private key again and save it from there." to
        "没有保存任何内容。请重新打开你的私钥，从那里保存。",
    "Paste the link here and your name goes beside your key, in your identity note. This is the part people mean to do later and then do not." to
        "把链接贴在这里，你的名字就会出现在你的密钥旁边，写在你的身份备注里。这一步大家都打算稍后再做，然后就没有再做。",
    "Paste the link to your post on X. It goes into your identity note, so the note points at the post and the post carries the key. Anyone can then check both ends against one key. The app does not open the link or check the post; anyone reading your note can." to
        "粘贴你在 X 上的帖子链接。它会加入你的身份备注，让备注指向帖子，同时帖子带有密钥。任何人都能用同一个密钥核验两边。应用不会打开链接，也不会检查帖子；读到你备注的任何人都可以自己核对。",
    "Seeker and Solana Mobile are trademarks of Solana Mobile, used only to say what this app is built for. FLOP and Technocore are names of the project whose public service this app writes to." to
        "Seeker 与 Solana Mobile 是 Solana Mobile 的商标，在此仅用于说明本应用是为什么设备而做。FLOP 与 Technocore 是本应用所写入的那个公共服务所属项目的名称。",
    "The file could not be written. Try another location." to
        "无法写入文件。请换一个位置。",
    "The five steps built your identity. Nobody outside this phone knows it is yours yet. Step 06 below: write one line, post it, then come back and paste the link. That last part is what puts your name beside your key, and it is where people stop." to
        "五个步骤建好了你的身份。这台手机之外，还没有人知道它是你的。见下方第 06 步：写一句话，发出去，然后回来贴上链接。最后这一步会把你的名字放在你的密钥旁边，而人们通常就停在这里。",
    "Three things, in this order: write your line, post it on X, then come back and paste the link. The last one is what puts your name beside your key, and it is the one people forget." to
        "三件事，按顺序：写下你的那句话，发到 X 上，然后回来把链接贴上。最后一步才把你的名字放在你的密钥旁边，而它正是最容易被忘掉的那一步。",
    "Your Passport is live, it is yours, and your post link is on it." to
        "你的 Passport 已生效，属于你，并且带上了你的帖子链接。",
    "checking with the server" to "正在向服务器核对",
    "independent project" to "独立项目",
    "not in your note yet" to "尚未写入你的备注",
    "post it on X" to "发到 X 上",
    "put it in my note" to "写进我的备注",
    "The prompt for this app begins with FLOP Passport key derivation v1 and names the app dev.alexkosa.floppassport; your wallet shows it was requested by flop.alexkosa.dev." to
        "本应用的签名提示以 FLOP Passport key derivation v1 开头，并写明应用 dev.alexkosa.floppassport；你的钱包会显示该请求来自 flop.alexkosa.dev。",
    "A signed record is dated evidence that you were here. A day without one cannot be added later, and signing also keeps your identity note alive. Nothing here promises anything about any allocation." to
        "签名记录是带日期的凭据，证明你来过。没有记录的一天事后补不上，而签名同时也让你的身份备注保持有效。这里没有任何内容对任何分配作出承诺。",
    "Your Passport itself is not lost: the same wallet still gives the same identity, and publishing again puts the note back at the same address." to
        "你的 Passport 并未丢失：同一个钱包仍会生成相同的身份，再发布一次即可将备注放回同一地址。",
    "Read from technocore.chat, not from this phone. Rooms are trimmed as they grow, so this shows what anyone would find today." to
        "从 technocore.chat 读取，并非来自此手机。房间会随内容增加而清理，因此这里显示的是任何人今天能找到的内容。",
    "Seven days without opening the app. Open it and press publish; the note goes back to the same address." to
        "已经七天没有打开过这个应用了。打开它并按“发布”，备注就会回到同一个地址。",
    "Finish the steps on the Passport tab first. Daily records start once your Passport is live." to
        "请先完成 Passport 标签页里的步骤。你的 Passport 生效后，才开始每日记录。",
    "Today is the last day. It is deleted within 24 hours unless you open the app." to
        "今天是最后一天。除非你打开应用，它将在 24 小时内被删除。",
    "If you did something today, sign a record for it now." to
        "如果你今天做了事，现在就为它签一条记录。",

    // 2.0: FLOP account, my day, guide and questions (2026-11-03).
    "@flop_labs is FLOP's account on X, YouTube and TikTok." to
        "@flop_labs 是 FLOP 在 X、YouTube 和 TikTok 上的账号。",
    "A FLOP account with daily FLOP" to
        "每天都有 FLOP 可领的 FLOP 账户",
    "A flop.finance address, but not one FLOP lists publicly. Ask through x.com/flop_labs." to
        "这是 flop.finance 的地址，但不是 FLOP 公开列出的地址。请通过 x.com/flop_labs 询问。",
    "A flop.finance address. FLOP lists security@flop.finance as its one public contact." to
        "这是 flop.finance 的地址。FLOP 公开列出的唯一联系方式是 security@flop.finance。",
    "A model you pay in FLOP, and a streak" to
        "一个用 FLOP 付费的模型，还有连续天数",
    "A practice network, open to everyone since 3 November 2026. FLOP here has no value, earns nothing and can be wiped in a reset. Use it to learn the day before it counts." to
        "一个练习网络，自 2026 年 11 月 3 日起向所有人开放。这里的 FLOP 没有价值，什么也赚不到，重置时可能被清空。用它在正式计数之前熟悉每天的流程。",
    "A streak counts days in a row with a signed record. One missed day a week is now forgiven; two missed days in a row end it. The count is read from the public room, so a day you did not sign cannot be added later." to
        "连续天数统计的是连续留下签名记录的天数。现在每周可以宽限一天漏签；连续漏签两天就会中断。天数是从公开房间读取的，所以没签的那天以后无法补上。",
    "About 90 days. This is where FLOP's agent airdrop is earned: the testnet FLOP you spend on the model is recorded as your claim on mainnet FLOP." to
        "大约 90 天。FLOP 的代理空投就是在这一阶段获得的：你在模型上花掉的 testnet FLOP，会被记作你对 mainnet FLOP 的领取权。",
    "Alex Kosa, one developer, for Seeker owners. It is not made by FLOP Labs. It is free and its code is open." to
        "Alex Kosa，一位开发者，为 Seeker 用户制作。不是 FLOP Labs 做的。它免费，代码开源。",
    "An identity made by your wallet" to
        "由你的钱包生成的身份",
    "Ask a question, see what it cost, and keep a streak of the days you show up." to
        "提一个问题，看看花了多少，再用连续天数记下你每天的到场。",
    "Ask anything. The model is small, so short, plain questions work best. Each answer costs a few devnet FLOP, taken from your Passport's allowance." to
        "随便问。模型很小，所以简短、直白的问题效果最好。每个回答花费几个 devnet FLOP，从你 Passport 的额度中扣除。",
    "Ask the model" to
        "向模型提问",
    "Ask the model one question" to
        "向模型提一个问题",
    "Blocks are being finalised normally." to
        "区块正在正常完成最终确认。",
    "Could not reach FLOP's gateway. Check your connection and try again." to
        "无法连接 FLOP 的网关。请检查连接后重试。",
    "Could not reach technocore.chat." to
        "无法连接 technocore.chat。",
    "Could not reach the FLOP devnet node. This says nothing about your balance, only about the connection." to
        "无法连接 FLOP devnet 节点。这只说明连接存在问题，与你的余额无关。",
    "Could not reach the FLOP explorer." to
        "无法连接 FLOP 区块浏览器。",
    "Could not reach the FLOP faucet. Check your connection and try again." to
        "无法连接 FLOP 水龙头。请检查连接后重试。",
    "Devnet FLOP is practice money: it has no value and can be wiped in a reset." to
        "Devnet FLOP 是练习用的钱：没有价值，重置时可能被清空。",
    "Devnet explorer" to
        "Devnet 区块浏览器",
    "Devnet is open" to
        "Devnet 已开放",
    "Devnet is open to everyone since 3 November 2026. It has no rewards and may be reset. Testnet has no date yet; FLOP will announce it on x.com/flop_labs. On testnet, the testnet FLOP an agent spends on inference becomes its claim on mainnet FLOP. Creating accounts earns nothing." to
        "Devnet 自 2026 年 11 月 3 日起向所有人开放。没有奖励，可能会被重置。Testnet 还没有日期；FLOP 会在 x.com/flop_labs 上公布。在 testnet 上，代理花在推理上的 testnet FLOP 会成为它对 mainnet FLOP 的领取权。创建账户不会带来任何收益。",
    "Devnet is practice" to
        "Devnet 只是练习",
    "Devnet is practice: its FLOP has no value. This app promises nothing about any allocation." to
        "Devnet 只是练习：其中的 FLOP 没有价值。本应用不对任何分配作出承诺。",
    "Do I have to post on X?" to
        "我必须在 X 上发帖吗？",
    "Do I need more than one account?" to
        "我需要多个账户吗？",
    "Do my day" to
        "完成今天",
    "Every step below was read back from the server, not just sent." to
        "下面的每一步都已从服务器读回，而不只是发送出去。",
    "Explain the idea of a 'seed phrase' and why it must stay secret." to
        "解释一下“助记词”是什么，以及为什么必须保密。",
    "Explain what 'decentralised' means without using jargon." to
        "不用术语，解释一下“去中心化”是什么意思。",
    "Explain what a blockchain block is to a ten-year-old, in three sentences." to
        "用三句话向一个十岁的孩子解释什么是区块链中的区块。",
    "Explain what an API is using a restaurant as the example." to
        "以餐厅为例，解释什么是 API。",
    "Explain what open-source software is in two sentences." to
        "用两句话解释什么是开源软件。",
    "FLOP Network is a blockchain where AI agents pay for AI work with FLOP. Miners run models on graphics cards, validators check that the work was really done, and agents buy the answers. Asking the model a question here is exactly that: your Passport acts as an agent and pays for one answer." to
        "FLOP Network 是一条区块链，AI 代理在上面用 FLOP 为 AI 工作付费。矿工用显卡运行模型，验证者检查工作是否真的完成，代理购买答案。在这里向模型提问正是如此：你的 Passport 充当代理，为一个答案付费。",
    "FLOP Passport gives your Seeker an identity and an account on FLOP Network, and one place to do your day there. It is free, open source, and made by one developer, Alex Kosa. It is not made by FLOP Labs." to
        "FLOP Passport 为你的 Seeker 提供 FLOP Network 上的身份和账户，让你在一个地方完成在那里的每日事项。它免费、开源，由一位开发者 Alex Kosa 制作，不是 FLOP Labs 做的。",
    "FLOP gives each account one devnet allowance: 25 FLOP for 24 hours. When it is over it is over until testnet." to
        "FLOP 给每个账户一次 devnet 额度：24 小时内 25 FLOP。用完就没有了，直到 testnet。",
    "FLOP has no Discord, Telegram, Reddit or Medium. There is no FLOP token yet." to
        "FLOP 没有 Discord、Telegram、Reddit 或 Medium。目前还没有 FLOP 代币。",
    "FLOP has no official Discord, Telegram, Reddit or Medium. An invitation to one never comes from FLOP." to
        "FLOP 没有官方的 Discord、Telegram、Reddit 或 Medium。这类邀请绝不会来自 FLOP。",
    "FLOP has not announced the testnet date. When it opens, the testnet FLOP you spend on the model becomes your claim on mainnet FLOP. Holding FLOP or making more accounts earns nothing." to
        "FLOP 尚未公布 testnet 日期。开放后，你在模型上花掉的 testnet FLOP 会成为你对 mainnet FLOP 的领取权。持有 FLOP 或创建更多账户都不会带来任何收益。",
    "FLOP has not given a date. It will be announced on x.com/flop_labs, and this app's status will say so the same day." to
        "FLOP 还没有给出日期。日期会在 x.com/flop_labs 上公布，本应用的状态也会在当天显示。",
    "FLOP says Q1 2027" to
        "FLOP 表示为 2027 年第一季度",
    "FLOP says there is no token, mint, claim, presale or live airdrop yet. Anything offering one is not FLOP." to
        "FLOP 表示目前还没有代币、铸造、领取、预售或正在进行的空投。任何提供这些的都不是 FLOP。",
    "FLOP's faucet is down for everyone right now. It is not your phone. Try again later." to
        "FLOP 的水龙头目前对所有人都不可用。不是你手机的问题。请稍后再试。",
    "FLOP's faucet is refusing every request with “IP classification unavailable”. This is FLOP's bug (network issue #22), not your phone. The app keeps trying when you press do my day." to
        "FLOP 的水龙头拒绝了所有请求，提示“IP classification unavailable”。这是 FLOP 的 bug（网络 issue #22），不是你手机的问题。你按“完成今天”时，应用会继续尝试。",
    "FLOP's faucet sends 25 devnet FLOP to your address, once every 24 hours per address. The request goes from your phone, for your own address, the same as pressing the button on faucet.flop.network. When the faucet is down, the app says so and the rest of your day still counts." to
        "FLOP 的水龙头向每个地址每 24 小时发送一次 25 devnet FLOP。请求从你的手机发出、针对你自己的地址，和在 faucet.flop.network 上按按钮一样。水龙头不可用时，应用会如实告诉你，你这一天的其他部分仍然算数。",
    "FLOP's gateway has handed out all of today's devnet allowances, or is unavailable. Try again later." to
        "FLOP 的网关已发完今天的所有 devnet 额度，或者暂时不可用。请稍后再试。",
    "FLOP's gateway rules (OpenAPI)" to
        "FLOP 网关规则（OpenAPI）",
    "FLOP's only handle is @flop_labs. Any other account using the name is not theirs." to
        "FLOP 唯一的账号是 @flop_labs。其他使用这个名字的账号都不是他们的。",
    "FLOP: official links and verification" to
        "FLOP：官方链接与核验",
    "FLOP: the airdrop and testnet conversion" to
        "FLOP：空投与 testnet 转换",
    "Faucet outage, FLOP issue #22" to
        "水龙头故障，FLOP issue #22",
    "Finality is lagging behind. The network may be slow." to
        "最终确认落后了。网络可能较慢。",
    "Finish setting up your Passport first." to
        "请先完成 Passport 的设置。",
    "Free and open source. Made by Alex Kosa, not by FLOP Labs. It promises nothing about any allocation." to
        "免费且开源。由 Alex Kosa 制作，不是 FLOP Labs。它不对任何分配作出承诺。",
    "From FLOP's faucet, once every 24 hours." to
        "来自 FLOP 的水龙头，每 24 小时一次。",
    "From FLOP's faucet. Next in {time}." to
        "来自 FLOP 的水龙头。{time} 后可再领。",
    "From the FLOP Passport team, written into this version." to
        "来自 FLOP Passport 团队，写入此版本。",
    "From the FLOP Passport team." to
        "来自 FLOP Passport 团队。",
    "Get 25 FLOP" to
        "领取 25 FLOP",
    "Give me a short motivational sentence for a Monday." to
        "给我一句适合星期一的简短励志话。",
    "Give me a simple recipe idea with rice and eggs." to
        "给我一个用米饭和鸡蛋做的简单菜谱点子。",
    "Give me one practical tip for writing clearer emails." to
        "给我一个让邮件写得更清楚的实用技巧。",
    "Give one good question to ask before buying any crypto token." to
        "给出一个在购买任何加密代币之前都该问的好问题。",
    "Give one way to remember a new word in a foreign language." to
        "给出一个记住外语新单词的方法。",
    "Give three tips for keeping a phone's battery healthy." to
        "给出三个保持手机电池健康的小技巧。",
    "I changed phones. How do I get my Passport back?" to
        "我换了手机。怎么找回我的 Passport？",
    "In plain words, what does 'inference' mean for an AI model?" to
        "用大白话说，对 AI 模型来说“推理”是什么意思？",
    "In two sentences, what does a GPU do that a CPU does badly?" to
        "用两句话说明：有什么事是 GPU 擅长而 CPU 做不好的？",
    "Install the app and connect the same Solana wallet. The same wallet makes the same Passport, with the same FLOP address and the same streak. There are no words to write down." to
        "安装应用并连接同一个 Solana 钱包。同一个钱包会生成同一个 Passport，FLOP 地址和连续天数也都相同。没有需要抄写下来的词。",
    "Is this FLOP money real?" to
        "这些 FLOP 是真钱吗？",
    "It gets 25 devnet FLOP from FLOP's faucet every 24 hours." to
        "它每 24 小时从 FLOP 的水龙头领取 25 devnet FLOP。",
    "It needs at least 1 FLOP on your Passport address first. On devnet each account also gets only one trial: 25 FLOP for 24 hours. After that it stays closed until testnet. The Ask tab says which one it is." to
        "首先你的 Passport 地址上需要至少有 1 FLOP。在 devnet 上，每个账户也只有一次试用：24 小时内 25 FLOP。之后就会一直关闭，直到 testnet。“提问”标签页会告诉你是哪一种情况。",
    "Its FLOP has no value. What you practise here is what testnet will count." to
        "其中的 FLOP 没有价值。你在这里练习的，正是 testnet 会计入的。",
    "Name three things to check before signing anything in a crypto wallet." to
        "说出在加密钱包里签署任何东西之前要检查的三件事。",
    "Name three uses of AI that run well on small models." to
        "说出三种在小模型上就能运行良好的 AI 用途。",
    "No, and it would not help. FLOP counts spending, not accounts, and says extra accounts earn nothing. One person, one Passport." to
        "不需要，而且也没有用。FLOP 计算的是花费，不是账户数量，并表示多余的账户不会带来任何收益。一人一个 Passport。",
    "No. Devnet FLOP is practice money with no value, and FLOP may wipe the devnet at any time. There is no FLOP token yet at all. Anybody selling FLOP today is a scammer." to
        "不是。Devnet FLOP 是没有价值的练习用钱，FLOP 随时可能清空 devnet。目前根本还没有 FLOP 代币。今天任何出售 FLOP 的人都是骗子。",
    "No. Linking a post to your Passport is optional. It shows people the Passport is yours, nothing more." to
        "不必。把帖子关联到你的 Passport 是可选的。它只是向别人表明这个 Passport 是你的，仅此而已。",
    "Nobody can promise that, and this app never will. What FLOP says: on testnet, the testnet FLOP an agent spends on the model becomes its claim on mainnet FLOP. The app helps you do exactly that every day. Devnet, which is now, earns nothing." to
        "没有人能保证这一点，本应用也永远不会。FLOP 的说法是：在 testnet 上，代理花在模型上的 testnet FLOP 会成为它对 mainnet FLOP 的领取权。本应用帮你每天做的正是这件事。现在的 devnet 不会带来任何收益。",
    "Nothing new to write down. The same wallet brings it back on any phone." to
        "没有新的东西需要抄下来。同一个钱包能在任何手机上把它找回来。",
    "On devnet FLOP gives each account one allowance: 25 FLOP to spend on the model within 24 hours, and needs at least 1 FLOP on the account to start it. When it is over, it stays over until testnet." to
        "在 devnet 上，FLOP 给每个账户一次额度：24 小时内可在模型上花 25 FLOP，而且账户上至少要有 1 FLOP 才能开启。用完之后，会一直关闭到 testnet。",
    "One button signs today, takes today's FLOP and asks the model one question." to
        "一个按钮：签署今天、领取今天的 FLOP，并向模型提一个问题。",
    "One press does all three, in order. Whatever is already done is skipped." to
        "按一下，按顺序完成这三件事。已经完成的会跳过。",
    "One question, paid in FLOP. Spending on the model is what testnet will count." to
        "一个问题，用 FLOP 支付。在模型上的花费正是 testnet 会计入的。",
    "One short text to sign. It is not a transaction and moves no money. Your wallet keeps its keys; nothing leaves it but that one signature." to
        "只需签署一段简短文字。这不是交易，也不会转移任何资金。你的钱包保管自己的密钥；除了那一个签名，什么都不会离开它。",
    "Only text, never a transaction. Once, to create your Passport. After that the Passport signs on its own: your daily record and the model's entry statement. None of it can move money from your wallet." to
        "只有文字，绝不是交易。只签一次，用来创建你的 Passport。之后由 Passport 自己签名：你的每日记录和模型的接入声明。这些都无法从你的钱包转走资金。",
    "Open the app and press do my day. It signs today, takes today's FLOP from the faucet and asks the model one question. That is all. Whatever is already done is skipped." to
        "打开应用，按“完成今天”。它会签署今天、从水龙头领取今天的 FLOP，并向模型提一个问题。就这些。已经完成的会跳过。",
    "Open the app and press do my day: it signs today, takes today's FLOP and asks the model one question." to
        "打开应用，按“完成今天”：它会签署今天、领取今天的 FLOP，并向模型提一个问题。",
    "Paste a FLOP address from SubWallet, Talisman or Polkadot.js. The faucet will send there. The model still uses your Passport's own address, because only your Passport can sign for it." to
        "粘贴来自 SubWallet、Talisman 或 Polkadot.js 的 FLOP 地址。水龙头会发到那里。模型仍然使用你 Passport 自己的地址，因为只有你的 Passport 能为它签名。",
    "Paste a full link, a handle like @name, or an address." to
        "粘贴完整链接、像 @name 这样的账号名，或一个地址。",
    "Paste a link, an @handle or an address someone sent you." to
        "粘贴别人发给你的链接、@账号名或地址。",
    "Questions people ask" to
        "大家常问的问题",
    "Reading your days from technocore.chat…" to
        "正在从 technocore.chat 读取你的天数…",
    "Same Passport, same days. And now one missed day a week is forgiven." to
        "同一个 Passport，同样的天数。现在每周还能宽限一天漏签。",
    "Sign today" to
        "签署今天",
    "Sign today to start your streak." to
        "签署今天，开始你的连续天数。",
    "Sign today's record" to
        "签署今天的记录",
    "Sign today, or the streak ends. Yesterday was already forgiven." to
        "今天要签，否则连续天数就会中断。昨天已经宽限过了。",
    "Signing the gateway's statement with your Passport…" to
        "正在用你的 Passport 签署网关的声明…",
    "Since 3 November FLOP's practice network is open to everyone. Devnet FLOP has no value, earns nothing, and the network may be reset at any time." to
        "自 11 月 3 日起，FLOP 的练习网络向所有人开放。Devnet FLOP 没有价值，什么也赚不到，网络随时可能被重置。",
    "Staying safe" to
        "注意安全",
    "Suggest a five-minute stretch for someone who sits all day." to
        "给整天坐着的人推荐一套五分钟的拉伸。",
    "Summarise what 'proof of work' means in two sentences." to
        "用两句话概括“工作量证明”是什么意思。",
    "Take today's FLOP" to
        "领取今天的 FLOP",
    "Tell me one interesting fact about the history of computers." to
        "告诉我一个关于计算机历史的有趣事实。",
    "Testnet and the airdrop" to
        "Testnet 与空投",
    "Testnet: no date yet" to
        "Testnet：尚无日期",
    "That is not a FLOP address. It should start with 5 and be 47 or 48 characters; copy it again from your wallet." to
        "这不是 FLOP 地址。它应以 5 开头，长度为 47 或 48 个字符；请从钱包里重新复制。",
    "The faucet" to
        "水龙头",
    "The faucet did not answer." to
        "水龙头没有响应。",
    "The faucet is down for everyone" to
        "水龙头对所有人都不可用",
    "The faucet sends to an address you chose instead:" to
        "水龙头改为发送到你选择的地址：",
    "The faucet works for you" to
        "水龙头对你可用",
    "The model did not answer." to
        "模型没有响应。",
    "The model is busy. Try again in a minute; nothing was spent." to
        "模型正忙。请一分钟后再试；没有花费任何东西。",
    "The model is closed for this account" to
        "此账户的模型已关闭",
    "The model is thinking…" to
        "模型正在思考…",
    "The model needs at least 1 FLOP on your Passport address first. Get it from the faucet." to
        "要使用模型，你的 Passport 地址上首先需要至少有 1 FLOP。可以从水龙头领取。",
    "The model: one trial per account" to
        "模型：每个账户一次试用",
    "The real token. There is no FLOP token before this, so anything sold or “claimed” as FLOP today is a scam." to
        "真正的代币。在此之前没有 FLOP 代币，所以今天任何以 FLOP 名义出售或“领取”的东西都是骗局。",
    "There is no FLOP token yet, so there is no FLOP contract address. Anything offered as one is not FLOP." to
        "目前还没有 FLOP 代币，所以也没有 FLOP 合约地址。任何以此名义提供的都不是 FLOP。",
    "There is no FLOP token yet. Nobody, including this app's author, will ever ask for your private key or your wallet's words. Your wallet only ever signs text here, never a transaction. If somebody sends you a FLOP link, check it on the Network tab first." to
        "目前还没有 FLOP 代币。任何人，包括本应用的作者，都绝不会向你索要私钥或钱包助记词。在这里，你的钱包只签署文字，绝不签署交易。如果有人给你发来 FLOP 链接，请先在“网络”标签页核对。",
    "There is no Passport on this phone." to
        "此手机上没有 Passport。",
    "This account has used its one devnet allowance. FLOP does not renew it on devnet. The model opens again when testnet starts, and on testnet the FLOP you spend here is what counts." to
        "此账户已用完唯一一次 devnet 额度。FLOP 不会在 devnet 上续期。testnet 开始后模型会重新开放，而在 testnet 上，你在这里花的 FLOP 才会被计入。",
    "This account's devnet allowance is used up." to
        "此账户的 devnet 额度已用完。",
    "This address already got its FLOP in the last 24 hours." to
        "此地址在过去 24 小时内已经领过 FLOP。",
    "This app's source code" to
        "本应用的源代码",
    "This is an account on FLOP Network. An address alone says nothing about who holds it." to
        "这是 FLOP Network 上的一个账户。单凭地址无法说明是谁持有它。",
    "To use the model, your Passport signs a short statement from api.flop.network. That signature moves nothing. FLOP then opens an allowance for your account: on devnet that is 25 FLOP for 24 hours, once per account, and your account needs at least 1 FLOP to start it. An answer costs about 0.006 FLOP per word-piece, usually one or two FLOP. When the allowance ends, the model stays closed for that account until testnet." to
        "要使用模型，你的 Passport 会签署一段来自 api.flop.network 的简短声明。这个签名不会转移任何东西。随后 FLOP 会为你的账户开启额度：在 devnet 上是 24 小时内 25 FLOP，每个账户一次，并且账户上至少要有 1 FLOP 才能开启。一个回答大约每个词元花费 0.006 FLOP，通常是一两个 FLOP。额度结束后，该账户的模型会一直关闭到 testnet。",
    "Today is not signed yet" to
        "今天还没签",
    "Today is not signed yet." to
        "今天还没签。",
    "Today is signed. Come back tomorrow." to
        "今天已签。明天再来。",
    "Today is signed. See you tomorrow." to
        "今天已签。明天见。",
    "Too many tries from this network. Wait a minute and try again." to
        "来自这个网络的尝试次数过多。请等一分钟后再试。",
    "Type a question" to
        "输入一个问题",
    "What FLOP is" to
        "FLOP 是什么",
    "What FLOP says: on testnet, testnet FLOP that an agent actually spends on inference becomes its claim on mainnet FLOP. That claim is locked, and unlocks as it is spent on inference on mainnet: three spent unlock one. Holding FLOP earns nothing. Making more accounts earns nothing. Posting your identity earns nothing." to
        "FLOP 的说法：在 testnet 上，代理真正花在推理上的 testnet FLOP 会成为它对 mainnet FLOP 的领取权。这份领取权是锁定的，随着在 mainnet 上花在推理上而逐步解锁：每花三个解锁一个。持有 FLOP 不会带来任何收益。创建更多账户不会带来任何收益。公开你的身份也不会带来任何收益。",
    "What do I need to do every day?" to
        "我每天需要做什么？",
    "What does a miner do in a compute network?" to
        "在算力网络中，矿工做什么？",
    "What exactly does my wallet sign?" to
        "我的钱包到底签署了什么？",
    "What is a hash function? Two sentences." to
        "什么是哈希函数？用两句话。",
    "What is a token in the context of language models?" to
        "在语言模型里，词元（token）是什么？",
    "What is a validator in a blockchain network? Keep it short." to
        "在区块链网络中，验证者是什么？简短点。",
    "What is an AI agent, in one paragraph?" to
        "用一段话说说什么是 AI 代理。",
    "What is latency, and why do people care about it?" to
        "什么是延迟，为什么大家在意它？",
    "What is phishing, and how do you spot it? Three signs." to
        "什么是网络钓鱼，怎么识别？给出三个迹象。",
    "What is the cloud, really? Two sentences." to
        "云到底是什么？用两句话。",
    "What is the difference between a private key and a public key?" to
        "私钥和公钥有什么区别？",
    "What makes a password strong? Three short points." to
        "怎样的密码才算强？三个简短要点。",
    "What this app is" to
        "本应用是什么",
    "What we say: this app promises nothing about any allocation, and never will. It helps you do, every day, the thing FLOP says it counts. One person, one Passport." to
        "我们的说法：本应用不对任何分配作出承诺，以后也不会。它帮你每天去做 FLOP 说会计入的那件事。一人一个 Passport。",
    "When does testnet start?" to
        "Testnet 什么时候开始？",
    "Where FLOP is now" to
        "FLOP 现在进展到哪里",
    "Where these facts come from" to
        "这些信息的来源",
    "Who made this app?" to
        "这个应用是谁做的？",
    "Why did my streak go back to zero?" to
        "为什么我的连续天数归零了？",
    "Why do computers use binary? Two sentences." to
        "为什么计算机使用二进制？用两句话。",
    "Why does the model not answer me?" to
        "为什么模型不回答我？",
    "Why is my balance 0?" to
        "为什么我的余额是 0？",
    "Will I get FLOP tokens for this?" to
        "我会因此获得 FLOP 代币吗？",
    "Write a haiku about a phone that never sleeps." to
        "写一首关于一部从不休眠的手机的俳句。",
    "You are a small model running on FLOP Network's devnet, answering inside a phone app. Answer briefly and plainly. Answer in the language the user writes in." to
        "你是一个运行在 FLOP Network devnet 上的小模型，在一个手机应用里回答问题。回答要简短、直白。用户用什么语言写，就用什么语言回答。",
    "You never need this to recover: your wallet rebuilds the Passport. It is here for people who want to use their identity away from this phone. Nobody, including this app's author, will ever ask you for it." to
        "恢复时你永远不需要它：你的钱包会重建 Passport。它放在这里，是给想在这台手机之外使用自己身份的人。任何人，包括本应用的作者，都绝不会向你索要它。",
    "Your FLOP address" to
        "你的 FLOP 地址",
    "Your FLOP comes from FLOP's faucet, and right now the faucet is not giving FLOP to anyone. That is FLOP's problem, not your phone. When it works, press do my day and 25 FLOP arrives within a minute." to
        "你的 FLOP 来自 FLOP 的水龙头，而目前水龙头没有给任何人发 FLOP。这是 FLOP 的问题，不是你手机的问题。等它恢复后，按“完成今天”，25 FLOP 会在一分钟内到账。",
    "Your Passport is a FLOP account" to
        "你的 Passport 就是一个 FLOP 账户",
    "Your Passport is also a FLOP address. FLOP's faucet gives it 25 FLOP every 24 hours." to
        "你的 Passport 也是一个 FLOP 地址。FLOP 的水龙头每 24 小时给它 25 FLOP。",
    "Your Passport key is also an account on FLOP Network. Same key, written the way FLOP writes addresses." to
        "你的 Passport 密钥同时也是 FLOP Network 上的一个账户。同一把密钥，只是按 FLOP 书写地址的方式写出来。",
    "Your Passport key is also your FLOP account. It is the same key, written the way FLOP writes addresses, so there is nothing new to back up: your Solana wallet rebuilds both on any phone. If you already have a FLOP address in SubWallet, Talisman or Polkadot.js, you can send the faucet there instead, on the Passport tab. The model works only with the Passport's own address, because only the Passport can sign for it." to
        "你的 Passport 密钥同时也是你的 FLOP 账户。它是同一把密钥，只是按 FLOP 书写地址的方式写出来，所以没有新的东西需要备份：你的 Solana 钱包能在任何手机上把两者都重建出来。如果你在 SubWallet、Talisman 或 Polkadot.js 里已经有 FLOP 地址，可以在 Passport 标签页让水龙头改发到那里。模型只能使用 Passport 自己的地址，因为只有 Passport 能为它签名。",
    "Your Passport now lives on FLOP" to
        "你的 Passport 现在在 FLOP 上了",
    "Your Passport signs one line in public. It adds a day to your streak." to
        "你的 Passport 会公开签署一行字，为你的连续天数加上一天。",
    "Your Passport signs one short line in a public room on technocore.chat, and the app reads it back to prove it landed. Each signed day adds to your streak. Miss one day and it is forgiven, once a week. Miss two in a row and the streak starts again." to
        "你的 Passport 会在 technocore.chat 的一个公开房间里签署一行短文字，应用会把它读回来，证明它确实落地。每签一天，连续天数就加一。漏签一天可以宽限，每周一次。连续漏签两天，连续天数就会从头开始。",
    "Your address got its FLOP from the faucet in the last 24 hours. It can ask again 24 hours after the last grant." to
        "你的地址在过去 24 小时内已从水龙头领过 FLOP。距上次发放满 24 小时后可以再次申请。",
    "Your day is done." to
        "今天的事都做完了。",
    "Your day on FLOP, from your Seeker." to
        "你在 FLOP 上的一天，从你的 Seeker 开始。",
    "Your day, step by step" to
        "你的一天，分步说明",
    "Your first question opens it. Your Passport signs a short statement from api.flop.network; nothing else is signed and nothing moves. You need at least 1 FLOP on your Passport's address, which the faucet on Today gives you." to
        "你的第一个问题会开启它。你的 Passport 会签署一段来自 api.flop.network 的简短声明；除此之外不签任何东西，也不会转移任何东西。你的 Passport 地址上需要至少有 1 FLOP，“今天”页的水龙头会给你。",
    "Your identity note was deleted after seven quiet days. Publish it again to keep signing your days. Your streak is not lost." to
        "你的身份备注在连续七天无人写入后被删除了。重新发布它，才能继续签署每天的记录。你的连续天数没有丢失。",
    "Your one devnet trial of the model is over. It opens again on testnet." to
        "你在 devnet 上对模型的唯一一次试用已结束。它会在 testnet 上重新开放。",
    "Your streak came with you" to
        "你的连续天数跟着你过来了",
    "Your wallet made this key and rebuilds it on any phone. There are no words to write down." to
        "这把密钥由你的钱包生成，并能在任何手机上重建。没有需要抄写下来的词。",
    "Your {n}-day streak ends at midnight" to
        "你连续 {n} 天的记录将在午夜中断",
    "accounts" to
        "账户",
    "active agents" to
        "活跃代理",
    "all my records" to
        "我的全部记录",
    "allowance left" to
        "剩余额度",
    "already asked today" to
        "今天已提问",
    "already signed today" to
        "今天已签",
    "already taken today" to
        "今天已领取",
    "answered" to
        "已回答",
    "ask the model something else" to
        "再问模型点别的",
    "back" to
        "返回",
    "balance" to
        "余额",
    "balance {n} FLOP" to
        "余额 {n} FLOP",
    "change the address" to
        "更改地址",
    "closes in" to
        "距关闭",
    "compute market and FRCR index" to
        "算力市场与 FRCR 指数",
    "copied" to
        "已复制",
    "cost {n} FLOP" to
        "花费 {n} FLOP",
    "day in a row" to
        "天连续",
    "days in a row" to
        "天连续",
    "devnet flop" to
        "devnet FLOP",
    "do my day" to
        "完成今天",
    "entering" to
        "接入中",
    "finish your passport first" to
        "先完成 Passport",
    "flop gateway" to
        "FLOP 网关",
    "go back to my passport address" to
        "改回我的 Passport 地址",
    "got it" to
        "知道了",
    "how it all works" to
        "这一切如何运作",
    "how it works" to
        "运作方式",
    "how it works, questions and answers" to
        "运作方式与问答",
    "how the model works here" to
        "模型在这里如何运作",
    "is this really flop?" to
        "这真的是 FLOP 吗？",
    "just now" to
        "刚刚",
    "latest block" to
        "最新区块",
    "made by wallet" to
        "由钱包生成",
    "model" to
        "模型",
    "my day on flop" to
        "我在 FLOP 的一天",
    "needs flop" to
        "需要 FLOP",
    "network" to
        "网络",
    "new in 2.0" to
        "2.0 新内容",
    "news" to
        "新闻",
    "no date yet" to
        "尚无日期",
    "not entered" to
        "未接入",
    "not flop" to
        "不是 FLOP",
    "not flop's" to
        "不属于 FLOP",
    "not now" to
        "以后再说",
    "official" to
        "官方",
    "official channels" to
        "官方渠道",
    "open in FLOP's explorer" to
        "在 FLOP 区块浏览器中打开",
    "passport" to
        "Passport",
    "private key" to
        "私钥",
    "publish again" to
        "重新发布",
    "read it in FLOP's own words" to
        "看 FLOP 自己怎么说",
    "reading" to
        "读取中",
    "refresh" to
        "刷新",
    "refused" to
        "已拒绝",
    "save" to
        "保存",
    "scam warning" to
        "防骗提醒",
    "send" to
        "发送",
    "settings, language, about" to
        "设置、语言、关于",
    "signed and read back" to
        "已签名并读回",
    "spent on the model, as FLOP's explorer sees it" to
        "花在模型上的 FLOP（据 FLOP 区块浏览器）",
    "start" to
        "开始",
    "the proof" to
        "证明",
    "to do" to
        "待办",
    "today" to
        "今天",
    "today's question: {q}" to
        "今日问题：{q}",
    "trial over" to
        "试用已结束",
    "use an address I already have" to
        "使用我已有的地址",
    "validators" to
        "验证者",
    "what is happening now" to
        "现在的情况",
    "what your wallet will show" to
        "钱包会显示什么",
    "where flop stands" to
        "FLOP 的现状",
    "your flop address" to
        "你的 FLOP 地址",
    "{day} was missed and forgiven: one missed day a week is." to
        "{day} 漏签了，已宽限：每周可以宽限一天。",
    "{h} h {m} min" to
        "{h} 小时 {m} 分钟",
    "{m} min" to
        "{m} 分钟",
    "{n} d ago" to
        "{n} 天前",
    "{n} h ago" to
        "{n} 小时前",
    "{n} min ago" to
        "{n} 分钟前",
    "Today" to "今天",
    "Ask" to "提问",
    "Network" to "网络",
    "{host} is on FLOP's official list." to "{host} 在 FLOP 的官方列表上。",
    "This is FLOP's own account on {host}." to "这是 FLOP 在 {host} 上的官方账号。",
    "This is on {host}, but not FLOP's account there. FLOP's is {account}." to "这在 {host} 上，但不是 FLOP 的账号。FLOP 的账号是 {account}。",
    "{host} uses the FLOP name but is not on FLOP's official list. Treat it as an impersonation." to "{host} 使用了 FLOP 的名字，但不在 FLOP 的官方列表上。请当作冒充处理。",
    "{host} is not FLOP. That does not make it bad, only not FLOP." to "{host} 不是 FLOP。这不代表它不好，只是它不是 FLOP。",
    // The faucet came back (2026-11-03).
    "The faucet works" to
        "水龙头正常工作",
    "FLOP's faucet gives each address 25 FLOP once every 24 hours. It can be slow: an answer may take a minute or two. The app waits for it and checks your balance." to
        "FLOP 的水龙头每 24 小时给每个地址 25 FLOP。它可能比较慢：一次回应可能要一两分钟。应用会等待并检查你的余额。",
    "Your FLOP comes from FLOP's faucet: 25 FLOP once every 24 hours. Press do my day and wait, the faucet can take a minute or two. If the balance stays 0, the faucet step says why." to
        "你的 FLOP 来自 FLOP 的水龙头：每 24 小时 25 FLOP。点“完成今天”然后等待，水龙头可能需要一两分钟。如果余额仍为 0，水龙头那一步会写明原因。",
    // Review fixes before the 2.0 release (2026-11-03).
    "The faucet is limiting requests from your network right now. Nothing arrived; try again later." to
        "水龙头正在限制来自你所在网络的请求。什么都没有到账，请稍后再试。",
    "FLOP's gateway sent a sign-in text this app does not recognise, so it was not signed. Nothing happened." to
        "FLOP 网关发来了一段本应用无法识别的登录文本，因此没有签名。什么都没有发生。",
    "The faucet said no: {reason}" to
        "水龙头拒绝了：{reason}",
    "The gateway said no: {reason}" to
        "网关拒绝了：{reason}",
    "The model did not answer: {reason}" to
        "模型没有回答：{reason}",
    "Only https links can be FLOP's. Type FLOP's address yourself instead of following this one." to
        "只有 https 链接才可能是 FLOP 的。请自己输入 FLOP 的地址，不要点这个链接。",
    "Sign today to keep your streak. This week's one forgiven day is already used." to
        "今天签名才能保住连续记录。本周唯一一次原谅已经用掉了。",
    // The model allowance is what the gateway says, not a fixed number (2026-11-03).
    "On devnet FLOP gives each account one allowance to spend on the model within 24 hours, and needs at least 1 FLOP on the account to start it. The Ask tab shows how much is left. When it is over, it stays over until testnet." to
        "在开发网上，FLOP 给每个账户一份 24 小时内可用于模型的额度，账户里至少要有 1 FLOP 才能开始。剩余多少，在“提问”页可以看到。额度用完后，直到测试网都不会再开放。",
    "FLOP gives each account one devnet allowance for 24 hours. The figure above is what is left of it. When it is over it is over until testnet." to
        "FLOP 给每个账户一份 24 小时的开发网额度。上面的数字就是剩余的部分。用完后，直到测试网都不会再开放。",
    "It needs at least 1 FLOP on your Passport address first. On devnet each account also gets only one trial, for 24 hours. After that it stays closed until testnet. The Ask tab says which one it is." to
        "首先，你的 Passport 地址上至少要有 1 FLOP。另外，在开发网上每个账户只有一次试用，为期 24 小时。之后直到测试网都不会再开放。“提问”页会写明是哪一种情况。",
    "To use the model, your Passport signs a short statement from api.flop.network. That signature moves nothing. FLOP then opens an allowance for your account: on devnet one, for 24 hours, and your account needs at least 1 FLOP to start it. The Ask tab shows how much of it is left. An answer costs about 0.006 FLOP per word-piece, usually one or two FLOP. When the allowance ends, the model stays closed for that account until testnet." to
        "要使用模型，你的 Passport 会签署一段来自 api.flop.network 的简短声明。这个签名不会转走任何东西。然后 FLOP 为你的账户开放一份额度：开发网上只有一份，为期 24 小时，账户里至少要有 1 FLOP 才能开始。剩余多少，在“提问”页可以看到。每个词片大约 0.006 FLOP，一次回答通常一到两个 FLOP。额度结束后，该账户的模型直到测试网都不会再开放。",
    // The faucet's two other refusals, seen 3-4 November 2026.
    "The faucet has your request in its queue and has not sent the FLOP yet. This can take a while. Press do my day again later." to
        "你的请求在水龙头的队列里，FLOP 还没有发出。这可能需要一段时间。请稍后再点一次“完成今天”。",
    "The faucet has given out all of today's FLOP. Nothing arrived. It opens again within hours, so try later." to
        "水龙头今天的 FLOP 已经发完。什么都没有到账。几小时内会重新开放，请稍后再试。",
    "Signing today's line with your Passport and reading it back from technocore.chat…" to
        "正在用你的 Passport 签署今天的记录，并从 technocore.chat 读回…",
    "Asking FLOP's faucet. It serves about 10 people a minute, so this can take up to 2 minutes." to
        "正在请求 FLOP 水龙头。它每分钟服务约 10 人，最多可能需要 2 分钟。",
    "You are in the faucet's queue. The app watches your balance and asks again by itself." to
        "你在水龙头的队列中。应用会关注你的余额，并自动再次请求。",
    "Reading your balance…" to
        "正在读取余额…",
    "Sending your question to the model. It has up to 90 seconds to answer." to
        "正在把问题发送给模型。它最多有 90 秒来回答。",
    "FLOP's gateway is full right now: many people are asking at once. Nothing was spent. The app tries again by itself." to
        "FLOP 的网关现在已满：很多人同时在提问。没有产生任何花费。应用会自动重试。",
    "Your FLOP is still settling on the network. The app tries again by itself." to
        "你的 FLOP 仍在网络上确认中。应用会自动重试。",
    "Reading what the answer cost…" to
        "正在读取这次回答的花费…",
    "FLOP's gateway stayed full through every try. Nothing was spent. Try again in a few minutes." to
        "FLOP 的网关在每次尝试时都已满。没有产生任何花费。请几分钟后再试。",
    "{n} s so far" to
        "已过 {n} 秒",
    "try {n} of {m}" to
        "第 {n}/{m} 次尝试",
    "next try in {n} s" to
        "{n} 秒后重试",
    "gateway ping {n} ms" to
        "网关延迟 {n} ms",
    "faucet ping {n} ms" to
        "水龙头延迟 {n} ms",
    "the gateway does not answer a ping" to
        "网关没有响应 ping",
    "the faucet does not answer a ping" to
        "水龙头没有响应 ping",
    "step {n} of 3" to
        "第 {n}/3 步",
    "ping" to
        "延迟",
    "no answer" to
        "无响应",
    "last answer took" to
        "上次回答用时",
    "You can leave this screen: it keeps going." to
        "你可以离开此屏幕：它会继续运行。",
    "Signing today's line" to
        "正在签署今天的一行",
    "Your Passport signs one short line in the public room and reads it back. That line is your day." to
        "你的 Passport 会在公共房间签下一行简短的话，再读回来。这一行就是你的一天。",
    "Asking FLOP's faucet" to
        "正在向 FLOP 水龙头申请",
    "The faucet pays about 10 people a minute. This can take up to two minutes." to
        "水龙头每分钟大约发放给 10 个人。最多可能需要两分钟。",
    "Standing in the faucet's queue" to
        "正在水龙头队列中等待",
    "The faucet pays about 10 people a minute. Your request is in. We watch your balance and ask again by ourselves." to
        "水龙头每分钟大约发放给 10 个人。你的申请已提交。我们会留意你的余额，并自动再次申请。",
    "Your FLOP is on its way" to
        "你的 FLOP 正在路上",
    "One moment." to
        "请稍等。",
    "Opening the model" to
        "正在打开模型",
    "Your Passport signs the gateway's statement. Nothing is spent." to
        "你的 Passport 会签署网关的声明。不会花费任何东西。",
    "Asking the model" to
        "正在询问模型",
    "Your question is with the model. It has up to 90 seconds." to
        "你的问题已交给模型。最多等待 90 秒。",
    "The model is full right now" to
        "模型现在已满",
    "Many people are asking at once. Nothing was spent. We try again by ourselves." to
        "很多人同时在提问。没有花费任何东西。我们会自动再试一次。",
    "Your FLOP is still settling" to
        "你的 FLOP 还在到账中",
    "A fresh grant takes a moment to count. We try again by ourselves." to
        "新到的额度需要一点时间才会计入。我们会自动再试一次。",
    "Reading what it cost" to
        "正在读取花费",
    "FLOP's gateway stayed full through all 6 tries. Nothing was spent. This is on FLOP's side, not yours." to
        "FLOP 的网关 6 次尝试都处于满载状态。没有花费任何东西。问题出在 FLOP 一侧，不在你这边。",
    "to next try" to
        "距下次尝试",
    "elapsed {t}" to
        "已用时 {t}",
    "ask the model" to
        "问模型",
    "Answered" to
        "已回答",
    "cost {c} FLOP · {s} s" to
        "花费 {c} FLOP · {s} 秒",
    "The model did not answer" to
        "模型没有回答",
    "your question" to
        "你的问题",
    "waiting" to
        "等待中",
    "Connect your Passport" to
        "连接你的 Passport",
    "Get the answer" to
        "获取答案",
    "minimise · it keeps going" to
        "最小化 · 仍会继续",
    "my day · step {n} of 3" to
        "我的一天 · 第 {n} 步，共 3 步",
    "my day" to
        "我的一天",
    "Your day is closed" to
        "今天已完成",
    "See you tomorrow." to
        "明天见。",
    "Today is signed" to
        "今天已签署",
    "not today" to
        "今天不了",
    "Could not sign today" to
        "今天未能签署",
    "Your day is signed. Your streak of {n} is safe whatever happens next." to
        "今天已签署。无论接下来发生什么，你的 {n} 天连续记录都很安全。",
    "Today is not signed yet. One missed day a week is forgiven; two in a row end the streak." to
        "今天还没有签署。每周可以漏掉一天，会被原谅；连续漏掉两天，记录就会结束。",
    "question of the day: {q}" to
        "今日一问：{q}",
    "Part of your day waits" to
        "你的一天还有一部分在等待",
    "passport · {name}" to
        "passport · {name}",
    "Days in a row: {n}" to
        "连续天数：{n}",
    "Start your streak today" to
        "今天开始你的连续记录",
    "Registered {date} · day {n} with us" to
        "注册于 {date} · 与我们同行第 {n} 天",
    "reading your days" to
        "正在读取你的日子",
    "today signed" to
        "今天已签署",
    "sign today or the streak ends" to
        "今天签署，否则连续记录会中断",
    "today not signed yet" to
        "今天还没签署",
    "in a row" to
        "连续",
    "{n} of 3" to
        "{n}/3",
    "Your Passport signs one public line. That line is your streak." to
        "你的 Passport 会签署一行公开的话。这一行就是你的连续记录。",
    "From FLOP's faucet, once a day. Practice coins, no price." to
        "来自 FLOP 水龙头，每天一次。练习用的币，没有价格。",
    "One question of the day, paid in FLOP." to
        "每天一个问题，用 FLOP 支付。",
    "One press, all three steps in order. What is already done is skipped." to
        "点一下，三个步骤依次完成。已经做完的会跳过。",
    "devnet · practice network" to
        "devnet · 练习网络",
    "one key · two networks" to
        "一把密钥 · 两个网络",
    "Seeker wallet" to
        "Seeker 钱包",
    "Made the Passport with one signature. Brings it back on any phone." to
        "用一次签名创建了 Passport。在任何手机上都能找回。",
    "FLOP account" to
        "FLOP 账户",
    "The same key as a FLOP address. The faucet pays here; the model is paid from here." to
        "同一把密钥，以 FLOP 地址的形式呈现。水龙头发到这里；模型也从这里付费。",
    "Registered" to
        "注册时间",
    "Days in a row" to
        "连续天数",
    "Best streak" to
        "最佳连续",
    "Signed days" to
        "已签署天数",
    "Balance, FLOP" to
        "余额，FLOP",
    "Spent on the model, FLOP" to
        "用于模型，FLOP",
    "1 skip left this week" to
        "本周还剩 1 次豁免",
    "this week's skip is used" to
        "本周的豁免已用完",
    "details and key" to
        "详情和密钥",
    "On Seeker · in FLOP Network · an app by Alex Kosa, not FLOP Labs, not Solana Mobile" to
        "在 Seeker 上 · 在 FLOP 网络中 · Alex Kosa 的应用，不是 FLOP Labs 或 Solana Mobile 的",
    "days signed together" to
        "一起签署的天数",
    "flop pulse" to
        "flop 脉搏",
    "Devnet is a practice network, open to everyone since 3 November. Coins have no price, there is no reward." to
        "Devnet 是练习网络，自 11 月 3 日起向所有人开放。币没有价格，也没有奖励。",
    "more about the network" to
        "更多网络信息",
    "thanks to both sides" to
        "感谢双方",
    "for Seeker, the wallet and one-tap signing" to
        "感谢 Seeker、钱包和一键签名",
    "for the network, the faucet and a model you can pay" to
        "感谢网络、水龙头和可以付费的模型",
    "An independent app by Alex Kosa. No promises about tokens or rewards." to
        "Alex Kosa 的独立应用。不对代币或奖励作任何承诺。",
    "check a link, an @name or an address someone sent you" to
        "检查别人发给你的链接、@名字或地址",
    "check" to
        "检查",
    "FLOP model" to
        "FLOP 模型",
    "The model is small: short, plain questions work best. Everything you pay is practice FLOP." to
        "模型很小：简短朴素的问题效果最好。你付出的一切都是练习用的 FLOP。",
    "model open" to
        "模型已开放",
    "opening the model" to
        "正在打开模型",
    "trial over for this account" to
        "此账户的试用已结束",
    "needs 1 flop" to
        "需要 1 flop",
    "model closed for now" to
        "模型暂时关闭",
    "first question opens it" to
        "第一个问题会打开它",
    "ping {n} ms" to
        "延迟 {n} 毫秒",
    "Your Passport signs a short statement from FLOP's gateway. Nothing moves. You need at least 1 FLOP; the faucet on Today gives you 25." to
        "你的 Passport 会签署 FLOP 网关的一份简短声明。不会转移任何东西。至少需要 1 FLOP；“今天”页的水龙头会给你 25。",
    "more" to
        "更多",
    "That was the last step. Your Passport is live, and your day on FLOP starts now." to
        "这是最后一步。你的 Passport 已就绪，你在 FLOP 的一天现在开始。",
    "Pulse" to
        "动态",
    "Who is here, and how FLOP's network is doing today." to
        "谁在这里,以及 FLOP 网络今天的情况。",
    "who is here" to
        "谁在这里",
    "Passport holders" to
        "Passport 持有者",
    "{n} Passport holders · {m} signed today" to
        "Passport 持有者 {n} 人 · 今日已签 {m} 人",
    "{n} of them signed today" to
        "其中今日已签:{n} 人",
    "To keep a streak, each holder signs one short public line a day. Counted from that public record, so anyone can repeat it." to
        "为保持连续记录,每位持有者每天签一行简短的公开内容。数字来自这份公开记录,任何人都可以复算。",
    "same key" to
        "同一把密钥",
    "knock now" to
        "现在敲门",
    "A refused knock costs nothing. Knock as often as you like." to
        "被拒绝不花钱。想敲多少次都可以。",
    "FLOP spent on the model, all time" to
        "累计用于模型的 FLOP",
    "accounts that paid for the model" to
        "为模型付过费的账户",
    "Join FLOP with Alex's link" to
        "通过 Alex 的链接进入 FLOP",
    "This is Alex Kosa's personal referral link from FLOP, and it may count for him. It gives you nothing extra from this app. Prefer not to? Go to flop.finance yourself." to
        "这是 FLOP 发给 Alex Kosa 的个人推荐链接,可能会计入他的名下。本应用不会因此给你额外的东西。不想用?请自己前往 flop.finance。",
    "open {host}" to
        "打开 {host}",
)
