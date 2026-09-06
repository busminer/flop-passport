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
        "签署的记录必须手动留下，错过的日期以后无法补上。此开关还会在你的身份笔记被删除前提醒你.",
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
    "FLOP asked agents to do something useful. A signed record is how you leave evidence of it, and a day without one is a day nobody can check later." to
        "FLOP 要求代理做些有用的事。签名记录就是你留下的凭据，而没有记录的一天，之后谁也无法核验。",
    "FLOP asked agents to do two things: create a unique key, and do something useful to spread the word about Technocore. The five steps above did the first. Nobody can do the second for you, so this writes the post and you decide whether to send it." to
        "FLOP 要求代理完成两件事：创建一个唯一密钥，并做些有用的事来宣传 Technocore。上面的五个步骤完成了第一件事。第二件事没人能替你做，所以这里会写好帖子，由你决定是否发布。",
    "Identity derived from your wallet signature" to "由你的钱包签名派生的身份",
    "If it does get deleted, your Passport is not gone: the same wallet still gives the same identity, and signing a record publishes the note back to the same address." to
        "即使它被删除，你的 Passport 也没有消失：同一个钱包仍会生成相同的身份，签署一条记录即可将笔记重新发布到同一地址.",
    "In one line: what you did, or why you set this up" to "用一句话说：你做了什么，或者为什么建立它",
    "It never asks for your wallet recovery phrase." to "它绝不会要求你提供钱包恢复助记词。",
    "It promises nothing about any airdrop, and never will." to "它不对任何空投作出承诺，以后也不会。",
    "Keep this file offline. Never send it to anyone, including the app author." to
        "请离线保存此文件。绝不要发送给任何人，包括应用作者。",
    "Language" to "语言",
    "Last reminder about this one." to "关于这件事，这是最后一次提醒。",
    "Link to what you built, if there is one" to "你所构建内容的链接（如果有）",
    "Link to your post" to "你的帖子链接",
    "Make your first signed check-in" to "留下首条签名记录",
    "Next: create your Passport from your wallet." to "下一步：通过钱包创建 Passport。",
    "Next: make your first signed check-in." to "下一步：留下首条签名记录。",
    "Next: publish your identity so anyone can verify you." to "下一步：发布身份，让任何人都能验证你。",
    "Next: seal the key in this phone's secure storage." to "下一步：将密钥封存在此手机的安全存储中。",
    "No account, no server of ours, no analytics." to "无需账户，不使用我们的服务器，也不进行数据分析。",
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
    "Paste the link here and your name is attached to your key for good. This is the part people mean to do later and then do not." to
        "把链接贴在这里，你的名字就永久系在你的密钥上了。这一步大家都打算稍后再做，然后就没有再做。",
    "Paste the link to your post. It goes into your identity note, so the note points at the post and the post carries the key. Anyone can then check both ends against one key." to
        "粘贴你的帖子链接。它会加入你的身份备注，让备注指向帖子，同时帖子带有密钥。任何人都能用同一个密钥核验两边.",
    "Post your line, then come back and paste the link. That is what attaches your name to your key, and it is the half FLOP asked agents for." to
        "发出你的那句话，然后回来贴上链接。正是这一步把你的名字系到你的密钥上，也正是 FLOP 要求代理去做的那一半。",
    "Protect" to "保护",
    "Protect it" to "保护它",
    "Publish" to "发布",
    "Publish your identity" to "发布你的身份",
    "Published and read back from the server" to "已发布并从服务器读回",
    "Published, read back, and vouched for by your key" to "已发布、读回并由你的密钥背书",
    "Publishing your identity note to technocore.chat" to "正在将身份记录发布到 technocore.chat",
    "Publishing your note" to "正在发布你的备注",
    "Questions, answered in full" to "问题详解",
    "Read from technocore.chat just now, not from this phone. Rooms are trimmed as they grow, so this is what anyone would find today." to
        "刚刚从 technocore.chat 读取，并非来自此手机。房间会随内容增加而清理，因此这是任何人今天能找到的内容。",
    "Reading your note" to "正在读取你的备注",
    "Reading your records" to "正在读取你的记录",
    "Ready" to "就绪",
    "Remind me once a day" to "每天提醒我一次",
    "Renewed today. technocore.chat keeps it for seven days after the last write, and this app rewrites it every time you open it." to
        "今天已续期。technocore.chat 会从最后一次写入起保留七天，并且你每次打开此应用时，应用都会重写它.",
    "Sealed by Android Keystore" to "由 Android Keystore 封存",
    "Sealed by StrongBox, this phone's separate security chip" to "由 StrongBox 封存，即此手机的独立安全芯片",
    "Sealed by this phone's trusted execution environment" to "由此手机的可信执行环境封存",
    "Sealing the key in this device's secure storage" to "正在将密钥封存在此设备的安全存储中",
    "Sending your signed record" to "正在发送你的签名记录",
    "Sent, but not confirmed in the room yet" to "已发送，但尚未在房间中确认",
    "Settings" to "设置",
    "Show your private key" to "显示你的私钥",
    "Sign a record now and this day is on your history for good." to "现在签一条记录，这一天就永久留在你的历史里。",
    "Signed, accepted and found again in the room" to "已签名、接受并再次在房间中找到",
    "Signing your first check-in and sending it" to "正在签署并发送你的首条记录",
    "Somebody changed this note after your key signed for it. Publish again." to
        "在你的密钥为这条备注背书之后，有人改动了它。请再次发布。",
    "Still one step short" to "仍然差一步",
    "Talking to the service" to "正在与服务通信",
    "Thanks for building this" to "感谢开发此应用",
    "That does not look like a link to a post. It should look like https://x.com/you/status/123." to
        "这看起来不像帖子链接。格式应该类似 https://x.com/you/status/123.",
    "That does not look like a link. It should start with https://" to "这看起来不像链接。链接应以 https:// 开头",
    "The five steps built your identity. Nobody outside this phone knows it is yours yet. Step 06 below: write one line, post it, then come back and paste the link. That last part is what puts your name beside your key for good, and it is where people stop." to
        "五个步骤建好了你的身份。这台手机之外，还没有人知道它是你的。见下方第 06 步：写一句话，发出去，然后回来贴上链接。最后这一步会把你的名字永久地放在你的密钥旁边，而人们通常就停在这里。",
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
        "每次打开此应用或签署记录时，应用都会重写你的笔记，并重新开始计算七天。每周至少打开一次，就不会丢失任何内容.",
    "This is NOT your Solana wallet key. Your wallet's own key never leaves Seed Vault and this app has never seen it. What you are looking at is a separate key that signs only on Technocore." to
        "这不是你的 Solana 钱包密钥。钱包自身的密钥从未离开 Seed Vault，本应用也从未读取过它。你看到的是一把独立密钥，只用于在 Technocore 上签名。",
    "This line is what makes the post yours. Everything under it is the proof." to
        "这一句才让这条帖子属于你。下面的一切都是证据。",
    "Three days left before it is deleted." to "距离删除还剩三天.",
    "Three things, in this order: write your line, post it, then come back and paste the link. The last one is what makes it permanent, and it is the one people forget." to
        "三件事，按顺序：写下你的那句话，发出去，然后回来把链接贴上。最后一步才让这一切长久，而它正是最容易被忘掉的那一步。",
    "Today cannot be added later" to "今天无法事后补上",
    "Told only when your identity note is days away from being deleted." to
        "只有当你的身份笔记再过几天就会被删除时，你才会收到通知.",
    "Tomorrow is the last day." to "明天是最后一天.",
    "Two days left before it is deleted." to "距离删除还剩两天.",
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
        "你的 Passport 派生自钱包在 Seeker 的硬件密钥存储区 Seed Vault 中生成的一次签名。钱包密钥始终留在该硬件中。此应用根据该签名计算出 Passport 密钥，再由 Android 的安全存储在硬件中封存，而非签名，因为 Android 密钥库无法保存此类密钥。",
    "Your Passport is live" to "你的 Passport 已启用",
    "Your Passport is live and your first signed record is on Technocore. Anyone can verify it, and it stays yours." to
        "你的 Passport 已启用，首条签名记录已发布到 Technocore。任何人都能验证，它始终属于你。",
    "Your Passport is live, it is yours, and your name is on it." to
        "你的 Passport 已生效，属于你，并且署上了你的名字。",
    "Your Passport is live. One step left." to "你的 Passport 已生效。还剩一步。",
    "Your Passport is rebuilt from one wallet signature, which is why no seed phrase exists to lose. The same fact cuts the other way: any app that persuades your wallet to sign that exact sentence can rebuild this Passport. Read what a wallet asks you to sign, here and everywhere else." to
        "你的 Passport 由一次钱包签名重建，因此没有会丢失的助记词。反过来也成立：任何能让你的钱包签署那句一模一样的话的应用，都能重建这个 Passport。请阅读钱包要求你签署的内容，在这里，也在任何地方。",
    "Your Passport itself is not lost: the same wallet still gives the same identity, and signing a record now publishes the note back to the same address." to
        "你的 Passport 并未丢失：同一个钱包仍会生成相同的身份，现在签署一条记录即可将笔记重新发布到同一地址.",
    "Your identity note expires soon" to "你的身份笔记即将过期",
    "Your identity note has been deleted" to "你的身份笔记已被删除",
    "Your key is never sent anywhere. Only you can export it." to "你的密钥不会发送到任何地方。只有你可以将其导出。",
    "Your key signed a line carrying this note's exact hash." to "你的密钥签署了一行，其中带有这条备注的确切哈希值。",
    "Your note has to be kept alive" to "你的笔记需要保持有效",
    "Your post is in your identity note, at your key's own address." to
        "你的帖子已在你的身份备注里，就在你密钥自己的地址上。",
    "Your wallet signs one statement. It is not a transaction and moves no funds. The same wallet rebuilds the same Passport on any device." to
        "你的钱包只签署一项声明。这不是交易，也不会转移资金。同一钱包可在任何设备上重建相同的 Passport。",
    "active days" to "活跃天数",
    "activity" to "活动",
    "address" to "地址",
    "agent: FLOP Passport for Seeker" to "代理：Seeker 版 FLOP Passport",
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
    "identity note" to "身份记录",
    "language {code}" to "语言 {code}",
    "last connection" to "上次连接",
    "linked" to "已关联",
    "live records" to "现存记录",
    "matched on our nonce, not just our key" to "与我们的 nonce 匹配，而不只是密钥",
    "no thanks, continue" to "不用，谢谢，继续",
    "no, nothing was made public" to "没有，未公开任何内容",
    "nonce" to "随机数",
    "not found" to "未找到",
    "not yet" to "暂时不",
    "not yet - the note alone is a claim, not a proof" to "尚未，单独的记录只是声明，不是证明",
    "off" to "关",
    "on" to "开",
    "open" to "打开",
    "our exact bytes, no wallet prefix" to "与我们的字节完全一致，无钱包前缀",
    "passport for seeker" to "Seeker 版 Passport",
    "pin it to your identity" to "固定到你的身份",
    "post it" to "发布",
    "private key, 32 bytes, hex" to "私钥，32 字节，十六进制",
    "protect passport" to "保护 Passport",
    "publish identity" to "发布身份",
    "publish these to my note" to "将这些发布到我的备注",
    "published" to "已发布",
    "publishing" to "发布中",
    "re-check with the server" to "通过服务器重新检查",
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
        "technocore.chat 会删除连续七天无人写入的内容。这也包括你保存和分享的地址上的身份笔记.",
    "technocore.chat refused the note" to "technocore.chat 拒绝了该记录",
    "technocore.chat refused the signed write" to "technocore.chat 拒绝了签名写入",
    "text" to "文本",
    "the note changed between reads" to "两次读取之间备注发生了变化",
    "the post" to "帖子",
    "the same wallet rebuilds this identity anywhere" to "同一钱包可在任何地方重建此身份",
    "try again" to "再试一次",
    "unconfirmed" to "未确认",
    "unsigned" to "未签名",
    "vault {level}" to "保管库 {level}",
    "verified" to "已验证",
    "verify it yourself" to "自行验证",
    "version" to "版本",
    "vouched for" to "已背书",
    "wallet" to "钱包",
    "wallet linked" to "钱包已关联",
    "what this app never does" to "本应用绝不会做的事",
    "what to do" to "操作方法",
    "when" to "时间",
    "with a wallet prefix, which is fine and pinned" to "带有钱包前缀，符合要求且已固定",
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
        "服务已经收下你的记录，但还没有把它显示回来。稍后按「重新检查」；不需要再签一次。",
    "technocore.chat refused the record. It refuses writes when it is busy - try again in a moment." to
        "technocore.chat 拒绝了这条记录。它繁忙时会拒绝写入，稍后再试一次。",
    "technocore.chat did not take the change. It refuses writes when it is busy - press publish again in a moment. Your links are saved on this phone either way." to
        "technocore.chat 没有接受这次改动。它繁忙时会拒绝写入，稍后再按一次「发布」。无论如何，你的链接已经存在这台手机上。",
    "Not finished yet. Your Passport is not live until all five are green, and there is nothing complete for anyone to verify. Keep going." to
        "还没有完成。五项全部变绿之前，你的 Passport 尚未生效，也没有完整的东西可供别人核对。继续。",
    "A message signed by your Passport, posted to a quiet room and then read back to prove it landed. Same service as step 03, same rule: if it refuses, press again. That is the service being busy, not a problem with your key." to
        "一条由你的 Passport 签名的消息，发到一个安静的房间，然后再被读回来，以此证明它确实落地了。和第 03 步是同一个服务，规则也一样：被拒绝就再按一次。那是服务繁忙，不是你的密钥有问题。",
    "Deleted after seven days with nothing written to it. Publish it now and it goes back to the same address." to
        "七天之内没有任何写入就会被删除。现在发布一次，它就会回到同一个地址。",
    "Identity note at risk" to
        "身份备注有风险",
    "In Settings, delete the Passport from this phone, then create it again from your wallet." to
        "到「设置」里把 Passport 从这台手机上删除，然后用钱包重新建一个。",
    "It is deleted after seven days with nothing written to it. Opening this app writes it." to
        "七天之内没有任何写入，它就会被删除。打开这个应用本身就是一次写入。",
    "Maybe. The service accepted it, and this app could not read it back to be sure." to
        "也许。服务已经接受了，但这个应用还没能把它读回来加以确认。",
    "Seven days without opening the app. Open it now and the note goes back up." to
        "已经七天没有打开过这个应用了。现在打开，备注就会重新发布上去。",
    "That was the last of the five. Your Passport is live. One thing left, and it is the part FLOP actually asked for: tell people what you did. The app writes the post for you at the bottom of this screen." to
        "这是五步里的最后一步。你的 Passport 已经生效。还剩一件事，而它正是 FLOP 真正要求的：告诉别人你做了什么。帖子由应用替你写好，就在这个页面的下方。",
    "The link you paste goes into your identity note, at an address derived from your own key. Rooms are cleared within a day. The note stays as long as you keep opening the app." to
        "你贴回来的链接会写进你的身份备注，地址由你自己的密钥算出。房间一天之内就会被清空。只要你还在打开这个应用，备注就一直在。",
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
)
