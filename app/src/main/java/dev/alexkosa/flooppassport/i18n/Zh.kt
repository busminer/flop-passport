package dev.alexkosa.flooppassport.i18n

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
    "A message signed by your Passport, posted to a quiet room and then read back to prove it landed." to
        "一条由 Passport 签名的消息，发布到安静的房间后再读回，以证明已送达。",
    "A permanent note at an address derived from your key, so anyone can find and verify you later." to
        "一条位于密钥派生地址的永久记录，之后任何人都能找到并验证您的身份。",
    "A tip changes nothing about your Passport and nothing about any airdrop." to
        "打赏不会改变您的 Passport，也不会影响任何空投。",
    "A tip changes nothing about your Passport, and nothing about any airdrop. It is a thank you, not a fee." to
        "打赏不会改变您的 Passport，也不会影响任何空投。这是致谢，不是费用。",
    "About" to "关于",
    "Accepted, but we could not read it back yet" to "已接受，但暂时无法读回",
    "Activity" to "活动",
    "Already checked in, found in the room" to "已留下签名记录，并在房间中找到",
    "Already published, read back just now" to "已发布，刚刚已读回",
    "Anyone can check it at the address in step 03. This app promises nothing about any allocation, and never will." to
        "任何人都能在步骤 03 的地址查看。本应用不对任何分配作出承诺，以后也不会。",
    "Anyone holding it can sign as you" to "任何持有者都能以您的身份签名",
    "Anyone holding seed_hex can sign as this identity on Technocore." to
        "任何持有 seed_hex 的人都能在 Technocore 上以此身份签名。",
    "Anyone with this can be you" to "任何持有此内容的人都能冒充您",
    "Apply" to "应用",
    "Cancel" to "取消",
    "Check in" to "留下签名记录",
    "Check your connection and try again." to "请检查连接后重试。",
    "Could not open the security prompt on this screen." to "无法在此屏幕上打开安全提示。",
    "Could not reach technocore.chat" to "无法连接 technocore.chat",
    "Could not reach technocore.chat. This says nothing about your records, only about the connection." to
        "无法连接 technocore.chat。这只说明连接存在问题，与您的记录无关。",
    "Could not read the key back from secure storage" to "无法从安全存储中读回密钥",
    "Create" to "创建",
    "Create your Passport" to "创建您的 Passport",
    "Create your Passport first. There is nothing to show until something has been signed." to
        "请先创建您的 Passport。在签署内容之前，没有可显示的内容。",
    "Created my FLOP Passport on a Solana Seeker." to "已在 Solana Seeker 上创建我的 FLOP Passport。",
    "Delete it?" to "删除？",
    "Delete the Passport and create it again from your wallet." to "删除 Passport，然后通过钱包重新创建。",
    "Deleting removes the Passport from this phone only. Anything already published stays public, and the same wallet rebuilds the same identity - so this is not a way to undo anything." to
        "删除只会从此手机移除 Passport。已发布的内容仍然公开，同一钱包会重建相同身份，因此这无法撤销任何内容。",
    "Every language listed here has a full translation." to "此处列出的每种语言都有完整翻译。",
    "FLOP Passport creates a Technocore identity from your Solana wallet and keeps the receipts." to
        "FLOP Passport 根据您的 Solana 钱包创建 Technocore 身份并保留凭据。",
    "FLOP Passport for Seeker" to "Seeker 版 FLOP Passport",
    "FLOP Passport for Seeker - private backup" to "Seeker 版 FLOP Passport - 私密备份",
    "FLOP Passport for Seeker by @AlexKosa1" to "由 @AlexKosa1 制作的 Seeker 版 FLOP Passport",
    "FLOP Passport for Seeker. First signed check-in." to "Seeker 版 FLOP Passport。首次签名记录。",
    "Follow the phone" to "按照手机上的提示操作",
    "Identity derived from your wallet signature" to "由您的钱包签名派生的身份",
    "Identity note published, first check in signed and verified on Technocore." to
        "身份记录已发布，首次记录已签名并在 Technocore 上验证。",
    "Identity note published, first check in verified on Technocore." to
        "身份记录已发布，首次记录已在 Technocore 上验证。",
    "Identity note published, first check in verified." to "身份记录已发布，首次记录已验证。",
    "It never asks for your wallet recovery phrase." to "它绝不会要求您提供钱包恢复助记词。",
    "It promises nothing about any airdrop, and never will." to "它不对任何空投作出承诺，以后也不会。",
    "Keep this file offline. Never send it to anyone, including the app author." to
        "请离线保存此文件。绝不要发送给任何人，包括应用作者。",
    "Key born in Seed Vault, sealed by StrongBox on device." to
        "密钥生成于 Seed Vault，并由设备上的 StrongBox 封存。",
    "LAST CONNECTION" to "上次连接",
    "LIVE CONNECTION" to "实时连接",
    "Language" to "语言",
    "Make your first signed check-in" to "留下首条签名记录",
    "My FLOP Passport, created on a Solana Seeker." to "我的 FLOP Passport，创建于 Solana Seeker。",
    "Next: create your Passport from your wallet." to "下一步：通过钱包创建 Passport。",
    "Next: make your first signed check-in." to "下一步：留下首条签名记录。",
    "Next: publish your identity so anyone can verify you." to "下一步：发布身份，让任何人都能验证您。",
    "Next: seal the key in this phone's secure storage." to "下一步：将密钥封存在此手机的安全存储中。",
    "No account, no server of ours, no analytics." to "无需账户，不使用我们的服务器，也不进行数据分析。",
    "No wallet on this phone opened the payment link." to "此手机上没有钱包打开付款链接。",
    "No. Nothing was published." to "没有。未发布任何内容。",
    "Not checked yet." to "尚未检查。",
    "Nothing found. If you signed something and it is not here, the room has been trimmed past it - which is normal, and exactly why this screen exists." to
        "未找到任何内容。如果您签署过内容但这里没有显示，说明房间已清理掉该记录。这是正常情况，也是此页面存在的原因。",
    "Nothing signed today yet." to "今天尚未签署任何记录。",
    "Only languages with a real translation are listed. A picker offering languages that all render English would say your language is supported and then prove otherwise on the next screen." to
        "仅列出已有实际翻译的语言。如果语言选择器列出的语言都显示为英文，它会声称支持您的语言，却在下一屏显示事实并非如此。",
    "Opening your Solana wallet" to "正在打开您的 Solana 钱包",
    "Press Create again. Nothing was sent anywhere." to "请再次按“创建”。没有向任何地方发送内容。",
    "Protect" to "保护",
    "Protect it" to "保护它",
    "Publish" to "发布",
    "Publish your identity" to "发布您的身份",
    "Published and read back from the server" to "已发布并从服务器读回",
    "Published, read back, and vouched for by your key" to "已发布、读回并由您的密钥背书",
    "Publishing your identity note to technocore.chat" to "正在将身份记录发布到 technocore.chat",
    "Read from technocore.chat just now, not from this phone. Rooms are trimmed as they grow, so this is what anyone would find today." to
        "刚刚从 technocore.chat 读取，并非来自此手机。房间会随内容增加而清理，因此这是任何人今天能找到的内容。",
    "Ready" to "就绪",
    "Sealed by Android Keystore" to "由 Android Keystore 封存",
    "Sealed by StrongBox, this phone's separate security chip" to "由 StrongBox 封存，即此手机的独立安全芯片",
    "Sealed by this phone's trusted execution environment" to "由此手机的可信执行环境封存",
    "Sealing the key in this device's secure storage" to "正在将密钥封存在此设备的安全存储中",
    "Sent, but not confirmed in the room yet" to "已发送，但尚未在房间中确认",
    "Settings" to "设置",
    "Show your private key" to "显示您的私钥",
    "Signed, accepted and found again in the room" to "已签名、接受并再次在房间中找到",
    "Signing your first check-in and sending it" to "正在签署并发送您的首条记录",
    "Thanks for building this" to "感谢开发此应用",
    "That was the last step. Your Passport is live." to "这是最后一步。您的 Passport 已启用。",
    "The identity is born inside Seed Vault and sealed by StrongBox on the phone." to
        "身份生成于 Seed Vault，并由手机上的 StrongBox 封存。",
    "The key is sealed in this phone's secure storage, then read back and checked against your identity." to
        "密钥封存在此手机的安全存储中，随后读回并与您的身份核对。",
    "The stored key does not match your identity" to "存储的密钥与您的身份不匹配",
    "The wallet did not complete the signature" to "钱包未完成签名",
    "There are no points here and no score. FLOP asked agents to do something useful, so what counts is a record a person can still open. A number invented by this app would be a different game." to
        "这里没有积分，也没有分数。FLOP 要求代理完成有用的事情，因此有意义的是人们仍能打开的记录。由本应用编造一个数字会变成另一种游戏。",
    "These 32 bytes are your FLOP Passport itself. Whoever holds them can sign as you on Technocore. Keep them offline and never send them to anyone, including us." to
        "这 32 字节就是您的 FLOP Passport。任何持有者都能在 Technocore 上以您的身份签名。请离线保存，绝不要发送给任何人，包括我们。",
    "This app is free and open source, and nobody paid for it. If it saved you an afternoon, a tip is welcome." to
        "本应用免费且开源，没有人为它付费。如果它为您节省了一个下午，可以选择打赏。",
    "This is NOT your Solana wallet key. Your wallet's own key never leaves Seed Vault and this app has never seen it. What you are looking at is a separate key that signs only on Technocore." to
        "这不是您的 Solana 钱包密钥。钱包自身的密钥从未离开 Seed Vault，本应用也从未读取过它。您看到的是一把独立密钥，只用于在 Technocore 上签名。",
    "Try again. Nothing was posted." to "请重试。未发布任何内容。",
    "Try again. Nothing was published." to "请重试。未发布任何内容。",
    "Wait a moment and press it again to re-check. Do not treat this as a failure." to
        "请稍候片刻，再次按下以重新检查。不要将此视为失败。",
    "Wait a moment and press it again to re-check. Sending it as a new message would post twice in public." to
        "请稍候片刻，再次按下以重新检查。作为新消息发送会公开发布两次。",
    "What is still provable" to "仍可证明的内容",
    "Yes. Something is already visible to others." to "是。已有内容对其他人可见。",
    "You do not need this file to recover. The same Solana wallet that" to
        "恢复时不需要此文件。创建它的同一 Solana 钱包",
    "You do not need this to recover. The same Solana wallet rebuilds the same Passport on any phone. This copy is for using the key somewhere else, on your own terms." to
        "恢复时不需要此内容。同一 Solana 钱包可在任何手机上重建相同的 Passport。此副本用于由您自行决定在其他地方使用该密钥。",
    "You have already checked in" to "您已留下签名记录",
    "You have already left a record today." to "您今天已经留下了一条记录。",
    "You're all set" to "已完成设置",
    "Your Passport is born inside Seed Vault, the Seeker's hardware key store, from which a key cannot be extracted. On this phone it is then sealed by Android's secure storage. Signing itself happens in the app, not in hardware, because Android Keystore cannot hold this kind of key - so we say sealed, not signed, in hardware." to
        "您的 Passport 生成于 Seeker 的硬件密钥存储 Seed Vault，其中的密钥无法导出。随后，它会由此手机的 Android 安全存储封存。签名本身在应用内完成，而不是在硬件中，因为 Android Keystore 无法保存此类密钥。因此我们说由硬件封存，而不是由硬件签名。",
    "Your Passport is live" to "您的 Passport 已启用",
    "Your Passport is live and your first signed record is on Technocore. Anyone can verify it, and it stays yours." to
        "您的 Passport 已启用，首条签名记录已发布到 Technocore。任何人都能验证，它始终属于您。",
    "Your Passport is live." to "您的 Passport 已启用。",
    "Your key never leaves this phone." to "您的密钥绝不会离开此手机。",
    "Your wallet signs one statement. It is not a transaction and moves no funds. The same wallet rebuilds the same Passport on any device." to
        "您的钱包只签署一项声明。这不是交易，也不会转移资金。同一钱包可在任何设备上重建相同的 Passport。",
    "active days" to "活跃天数",
    "activity" to "活动",
    "address" to "地址",
    "agent: FLOP Passport for Seeker" to "代理：Seeker 版 FLOP Passport",
    "algorithm: Ed25519, did:key, 32-byte seed" to "算法：Ed25519、did:key、32 字节种子",
    "built by a community builder" to "由社区开发者构建",
    "cancel" to "取消",
    "change" to "更改",
    "checked" to "已检查",
    "close" to "关闭",
    "content" to "内容",
    "continue" to "继续",
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
    "floop-passport vault self-test" to "floop-passport 密钥库自检",
    "identity" to "身份",
    "identity note" to "身份记录",
    "live" to "实时",
    "live records" to "现存记录",
    "matched on our nonce, not just our key" to "与我们的 nonce 匹配，而不只是密钥",
    "no thanks, continue" to "不用，谢谢，继续",
    "no, nothing was made public" to "没有，未公开任何内容",
    "nonce" to "随机数",
    "not asked yet" to "尚未请求",
    "not found" to "未找到",
    "not yet - the note alone is a claim, not a proof" to "尚未，单独的记录只是声明，不是证明",
    "opening" to "正在打开",
    "our exact bytes, no wallet prefix" to "与我们的字节完全一致，无钱包前缀",
    "passport for seeker" to "Seeker 版 Passport",
    "private key, 32 bytes, hex" to "私钥，32 字节，十六进制",
    "protect passport" to "保护 Passport",
    "publish identity" to "发布身份",
    "published" to "已发布",
    "re-check with the server" to "通过服务器重新检查",
    "re-checked when the app opened" to "应用打开时已重新检查",
    "records the server still holds" to "服务器仍保留的记录",
    "recovery" to "恢复",
    "room" to "房间",
    "save my key" to "保存我的密钥",
    "save to a file" to "保存到文件",
    "self test" to "自检",
    "send a tip" to "发送打赏",
    "sequence" to "序号",
    "settings" to "设置",
    "sign and check in" to "签名并留下记录",
    "sign today's record" to "签署今天的记录",
    "signed" to "已签名",
    "signed and verified against your DID" to "已签名并根据您的 DID 验证",
    "storage" to "存储",
    "support the builder" to "支持开发者",
    "technocore.chat refused the note" to "technocore.chat 拒绝了该记录",
    "technocore.chat refused the signed write" to "technocore.chat 拒绝了签名写入",
    "text" to "文本",
    "the same wallet rebuilds this identity anywhere" to "同一钱包可在任何地方重建此身份",
    "unconfirmed" to "未确认",
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
    "your identity" to "您的身份",
    "your private key" to "您的私钥",
)
