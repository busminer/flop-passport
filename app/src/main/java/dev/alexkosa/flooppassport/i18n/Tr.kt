package dev.alexkosa.flooppassport.i18n

/**
 * Turkish.
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
internal val TR_STRINGS: Map<String, String> = mapOf(
    "A message signed by your Passport, posted to a quiet room and then read back to prove it landed." to
        "Passport'ınız tarafından imzalanan, sakin bir odaya gönderilip ulaştığını kanıtlamak için geri okunan bir mesaj.",
    "A permanent note at an address derived from your key, so anyone can find and verify you later." to
        "Anahtarınızdan türetilen bir adreste kalıcı bir not; böylece daha sonra herkes sizi bulup doğrulayabilir.",
    "A tip changes nothing about your Passport and nothing about any airdrop." to
        "Bahşiş, Passport'ınız veya herhangi bir airdrop hakkında hiçbir şeyi değiştirmez.",
    "A tip changes nothing about your Passport, and nothing about any airdrop. It is a thank you, not a fee." to
        "Bahşiş, Passport'ınız veya herhangi bir airdrop hakkında hiçbir şeyi değiştirmez. Bu bir teşekkürdür, ücret değildir.",
    "About" to "Hakkında",
    "Accepted, but we could not read it back yet" to
        "Kabul edildi, ancak henüz geri okuyamadık",
    "Activity" to "Etkinlik",
    "Already checked in, found in the room" to "Kayıt zaten bırakılmış, odada bulundu",
    "Already published, read back just now" to "Zaten yayımlanmış, az önce geri okundu",
    "Anyone can check it at the address in step 03. This app promises nothing about any allocation, and never will." to
        "Herkes bunu 03. adımdaki adresten kontrol edebilir. Bu uygulama herhangi bir tahsis hakkında hiçbir söz vermez ve vermeyecektir.",
    "Anyone holding it can sign as you" to
        "Bunu elinde tutan herkes sizin adınıza imzalayabilir",
    "Anyone holding seed_hex can sign as this identity on Technocore." to
        "seed_hex değerini elinde tutan herkes Technocore üzerinde bu kimlik adına imzalayabilir.",
    "Anyone with this can be you" to "Buna sahip olan herkes siz olabilir",
    "Apply" to "Uygula",
    "Cancel" to "İptal",
    "Check in" to "Kayıt bırak",
    "Check your connection and try again." to "Bağlantınızı kontrol edip yeniden deneyin.",
    "Could not open the security prompt on this screen." to
        "Bu ekranda güvenlik istemi açılamadı.",
    "Could not reach technocore.chat" to "technocore.chat adresine ulaşılamadı",
    "Could not reach technocore.chat. This says nothing about your records, only about the connection." to
        "technocore.chat adresine ulaşılamadı. Bu, kayıtlarınızla değil yalnızca bağlantıyla ilgilidir.",
    "Could not read the key back from secure storage" to
        "Anahtar güvenli depolamadan geri okunamadı",
    "Create" to "Oluştur",
    "Create your Passport" to "Passport'ınızı oluşturun",
    "Create your Passport first. There is nothing to show until something has been signed." to
        "Önce Passport'ınızı oluşturun. Bir şey imzalanana kadar gösterilecek bir şey yok.",
    "Created my FLOP Passport on a Solana Seeker." to
        "FLOP Passport'ımı bir Solana Seeker üzerinde oluşturdum.",
    "Delete it?" to "Silinsin mi?",
    "Delete the Passport and create it again from your wallet." to
        "Passport'ı silin ve cüzdanınızdan yeniden oluşturun.",
    "Deleting removes the Passport from this phone only. Anything already published stays public, and the same wallet rebuilds the same identity - so this is not a way to undo anything." to
        "Silme işlemi Passport'ı yalnızca bu telefondan kaldırır. Daha önce yayımlanan her şey herkese açık kalır ve aynı cüzdan aynı kimliği yeniden oluşturur; dolayısıyla bu, herhangi bir şeyi geri alma yolu değildir.",
    "Every language listed here has a full translation." to
        "Burada listelenen her dilin tam çevirisi vardır.",
    "FLOP Passport creates a Technocore identity from your Solana wallet and keeps the receipts." to
        "FLOP Passport, Solana cüzdanınızdan bir Technocore kimliği oluşturur ve kayıt kanıtlarını saklar.",
    "FLOP Passport for Seeker" to "Seeker için FLOP Passport",
    "FLOP Passport for Seeker - private backup" to "Seeker için FLOP Passport - özel yedek",
    "FLOP Passport for Seeker by @AlexKosa1" to
        "@AlexKosa1 tarafından Seeker için FLOP Passport",
    "FLOP Passport for Seeker. First signed check-in." to
        "Seeker için FLOP Passport. İlk imzalı kayıt.",
    "Follow the phone" to "Telefondaki adımları izleyin",
    "Identity derived from your wallet signature" to "Cüzdan imzanızdan türetilen kimlik",
    "Identity note published, first check in signed and verified on Technocore." to
        "Kimlik notu yayımlandı, ilk kayıt Technocore üzerinde imzalandı ve doğrulandı.",
    "Identity note published, first check in verified on Technocore." to
        "Kimlik notu yayımlandı, ilk kayıt Technocore üzerinde doğrulandı.",
    "Identity note published, first check in verified." to
        "Kimlik notu yayımlandı, ilk kayıt doğrulandı.",
    "It never asks for your wallet recovery phrase." to
        "Cüzdan kurtarma ifadenizi hiçbir zaman istemez.",
    "It promises nothing about any airdrop, and never will." to
        "Herhangi bir airdrop hakkında hiçbir söz vermez ve vermeyecektir.",
    "Keep this file offline. Never send it to anyone, including the app author." to
        "Bu dosyayı çevrimdışı tutun. Uygulamanın yazarı dahil hiç kimseye göndermeyin.",
    "Key born in Seed Vault, sealed by StrongBox on device." to
        "Anahtar Seed Vault içinde oluşturuldu, cihazdaki StrongBox ile mühürlendi.",
    "LAST CONNECTION" to "SON BAĞLANTI",
    "LIVE CONNECTION" to "CANLI BAĞLANTI",
    "Language" to "Dil",
    "Make your first signed check-in" to "İlk imzalı kaydınızı bırakın",
    "My FLOP Passport, created on a Solana Seeker." to
        "Bir Solana Seeker üzerinde oluşturduğum FLOP Passport.",
    "Next: create your Passport from your wallet." to
        "Sırada: Passport'ınızı cüzdanınızdan oluşturun.",
    "Next: make your first signed check-in." to "Sırada: İlk imzalı kaydınızı bırakın.",
    "Next: publish your identity so anyone can verify you." to
        "Sırada: Herkesin sizi doğrulayabilmesi için kimliğinizi yayımlayın.",
    "Next: seal the key in this phone's secure storage." to
        "Sırada: Anahtarı bu telefonun güvenli depolamasında mühürleyin.",
    "No account, no server of ours, no analytics." to
        "Hesap yok, bize ait sunucu yok, analiz yok.",
    "No wallet on this phone opened the payment link." to
        "Bu telefondaki hiçbir cüzdan ödeme bağlantısını açmadı.",
    "No. Nothing was published." to "Hayır. Hiçbir şey yayımlanmadı.",
    "Not checked yet." to "Henüz kontrol edilmedi.",
    "Nothing found. If you signed something and it is not here, the room has been trimmed past it - which is normal, and exactly why this screen exists." to
        "Hiçbir şey bulunamadı. Bir şey imzaladıysanız ve burada değilse oda onu artık içermeyecek şekilde kırpılmıştır; bu normaldir ve bu ekran tam olarak bu nedenle vardır.",
    "Nothing signed today yet." to "Bugün henüz hiçbir şey imzalanmadı.",
    "Only languages with a real translation are listed. A picker offering languages that all render English would say your language is supported and then prove otherwise on the next screen." to
        "Yalnızca gerçek çevirisi olan diller listelenir. Tüm seçenekleri İngilizce gösteren bir dil seçici, dilinizin desteklendiğini söyler ancak sonraki ekranda bunun doğru olmadığını gösterir.",
    "Opening your Solana wallet" to "Solana cüzdanınız açılıyor",
    "Press Create again. Nothing was sent anywhere." to
        "Oluştur'a yeniden basın. Hiçbir yere hiçbir şey gönderilmedi.",
    "Protect" to "Koru",
    "Protect it" to "Onu koruyun",
    "Publish" to "Yayımla",
    "Publish your identity" to "Kimliğinizi yayımlayın",
    "Published and read back from the server" to "Yayımlandı ve sunucudan geri okundu",
    "Published, read back, and vouched for by your key" to
        "Yayımlandı, geri okundu ve anahtarınızla doğrulandı",
    "Publishing your identity note to technocore.chat" to
        "Kimlik notunuz technocore.chat adresinde yayımlanıyor",
    "Read from technocore.chat just now, not from this phone. Rooms are trimmed as they grow, so this is what anyone would find today." to
        "Az önce bu telefondan değil, technocore.chat üzerinden okundu. Odalar büyüdükçe kırpılır; dolayısıyla bugün herkesin bulacağı kayıt budur.",
    "Ready" to "Hazır",
    "Sealed by Android Keystore" to "Android Keystore ile mühürlendi",
    "Sealed by StrongBox, this phone's separate security chip" to
        "Bu telefonun ayrı güvenlik çipi StrongBox ile mühürlendi",
    "Sealed by this phone's trusted execution environment" to
        "Bu telefonun güvenilir yürütme ortamıyla mühürlendi",
    "Sealing the key in this device's secure storage" to
        "Anahtar bu cihazın güvenli depolamasında mühürleniyor",
    "Sent, but not confirmed in the room yet" to "Gönderildi, ancak odada henüz doğrulanmadı",
    "Settings" to "Ayarlar",
    "Show your private key" to "Özel anahtarınızı gösterin",
    "Signed, accepted and found again in the room" to
        "İmzalandı, kabul edildi ve odada yeniden bulundu",
    "Signing your first check-in and sending it" to "İlk kaydınız imzalanıp gönderiliyor",
    "Thanks for building this" to "Bunu geliştirdiğiniz için teşekkürler",
    "That was the last step. Your Passport is live." to "Bu son adımdı. Passport'ınız yayında.",
    "The identity is born inside Seed Vault and sealed by StrongBox on the phone." to
        "Kimlik Seed Vault içinde oluşturulur ve telefondaki StrongBox ile mühürlenir.",
    "The key is sealed in this phone's secure storage, then read back and checked against your identity." to
        "Anahtar bu telefonun güvenli depolamasında mühürlenir, ardından geri okunur ve kimliğinizle karşılaştırılır.",
    "The stored key does not match your identity" to "Saklanan anahtar kimliğinizle eşleşmiyor",
    "The wallet did not complete the signature" to "Cüzdan imzalama işlemini tamamlamadı",
    "There are no points here and no score. FLOP asked agents to do something useful, so what counts is a record a person can still open. A number invented by this app would be a different game." to
        "Burada puan veya skor yoktur. FLOP, aracılardan yararlı bir şey yapmalarını istedi; bu nedenle önemli olan, bir kişinin hâlâ açabildiği kayıttır. Bu uygulamanın ürettiği bir sayı farklı bir oyun olurdu.",
    "These 32 bytes are your FLOP Passport itself. Whoever holds them can sign as you on Technocore. Keep them offline and never send them to anyone, including us." to
        "Bu 32 bayt doğrudan FLOP Passport'ınızdır. Bunları elinde tutan kişi Technocore üzerinde sizin adınıza imzalayabilir. Çevrimdışı tutun ve biz dahil hiç kimseye göndermeyin.",
    "This app is free and open source, and nobody paid for it. If it saved you an afternoon, a tip is welcome." to
        "Bu uygulama ücretsiz ve açık kaynaklıdır; geliştirilmesi için kimse ödeme yapmadı. Size bir öğleden sonra kazandırdıysa bahşiş bırakabilirsiniz.",
    "This is NOT your Solana wallet key. Your wallet's own key never leaves Seed Vault and this app has never seen it. What you are looking at is a separate key that signs only on Technocore." to
        "Bu, Solana cüzdan anahtarınız DEĞİLDİR. Cüzdanınızın kendi anahtarı Seed Vault dışına hiçbir zaman çıkmaz ve bu uygulama onu hiç görmemiştir. Gördüğünüz, yalnızca Technocore üzerinde imza atan ayrı bir anahtardır.",
    "Try again. Nothing was posted." to "Yeniden deneyin. Hiçbir şey gönderilmedi.",
    "Try again. Nothing was published." to "Yeniden deneyin. Hiçbir şey yayımlanmadı.",
    "Wait a moment and press it again to re-check. Do not treat this as a failure." to
        "Biraz bekleyip yeniden kontrol etmek için tekrar basın. Bunu bir hata olarak değerlendirmeyin.",
    "Wait a moment and press it again to re-check. Sending it as a new message would post twice in public." to
        "Biraz bekleyip yeniden kontrol etmek için tekrar basın. Yeni mesaj olarak göndermek, kaydı herkese açık olarak iki kez yayımlar.",
    "What is still provable" to "Hâlâ kanıtlanabilenler",
    "Yes. Something is already visible to others." to
        "Evet. Bir şey başkaları tarafından zaten görülebiliyor.",
    "You do not need this file to recover. The same Solana wallet that" to
        "Kurtarmak için bu dosyaya ihtiyacınız yok. Bu Passport'ı oluşturan aynı Solana cüzdanı",
    "You do not need this to recover. The same Solana wallet rebuilds the same Passport on any phone. This copy is for using the key somewhere else, on your own terms." to
        "Kurtarmak için buna ihtiyacınız yok. Aynı Solana cüzdanı, aynı Passport'ı herhangi bir telefonda yeniden oluşturur. Bu kopya, anahtarı kendi koşullarınızla başka bir yerde kullanmanız içindir.",
    "You have already checked in" to "Zaten kayıt bıraktınız",
    "You have already left a record today." to "Bugün zaten bir kayıt bıraktınız.",
    "You're all set" to "Her şey hazır",
    "Your Passport is born inside Seed Vault, the Seeker's hardware key store, from which a key cannot be extracted. On this phone it is then sealed by Android's secure storage. Signing itself happens in the app, not in hardware, because Android Keystore cannot hold this kind of key - so we say sealed, not signed, in hardware." to
        "Passport'ınız, Seeker donanım anahtar deposu olan ve içinden anahtar çıkarılamayan Seed Vault içinde oluşturulur. Ardından bu telefonda Android'in güvenli depolamasıyla mühürlenir. Android Keystore bu tür bir anahtarı tutamadığı için imzalama donanımda değil, uygulamada gerçekleşir; bu nedenle donanımda imzalandı değil, mühürlendi deriz.",
    "Your Passport is live" to "Passport'ınız yayında",
    "Your Passport is live and your first signed record is on Technocore. Anyone can verify it, and it stays yours." to
        "Passport'ınız yayında ve ilk imzalı kaydınız Technocore üzerinde. Herkes bunu doğrulayabilir ve kayıt size ait kalır.",
    "Your Passport is live." to "Passport'ınız yayında.",
    "Your key never leaves this phone." to "Anahtarınız bu telefondan hiçbir zaman ayrılmaz.",
    "Your wallet signs one statement. It is not a transaction and moves no funds. The same wallet rebuilds the same Passport on any device." to
        "Cüzdanınız tek bir beyanı imzalar. Bu bir işlem değildir ve hiçbir fonu taşımaz. Aynı cüzdan, aynı Passport'ı herhangi bir cihazda yeniden oluşturur.",
    "active days" to "etkin gün",
    "activity" to "etkinlik",
    "address" to "adres",
    "agent: FLOP Passport for Seeker" to "aracı: Seeker için FLOP Passport",
    "algorithm: Ed25519, did:key, 32-byte seed" to
        "algoritma: Ed25519, did:key, 32 baytlık seed",
    "built by a community builder" to "bir topluluk geliştiricisi tarafından oluşturuldu",
    "cancel" to "iptal",
    "change" to "değiştir",
    "checked" to "kontrol edildi",
    "close" to "kapat",
    "content" to "içerik",
    "continue" to "devam et",
    "copy key" to "anahtarı kopyala",
    "create passport" to "passport oluştur",
    "created this Passport rebuilds it on any device." to
        "onu herhangi bir cihazda yeniden oluşturur.",
    "danger zone" to "tehlikeli alan",
    "day streak" to "günlük seri",
    "delete passport from this phone" to "passport'ı bu telefondan sil",
    "detail" to "ayrıntı",
    "did anything go public?" to "herhangi bir şey herkese açıldı mı?",
    "done" to "tamam",
    "failed" to "başarısız",
    "fetched again and matched exactly" to "yeniden alındı ve tam olarak eşleşti",
    "fetched from the server on opening" to "açılışta sunucudan alındı",
    "fingerprint" to "parmak izi",
    "floop-passport vault self-test" to "floop-passport güvenli depolama öz testi",
    "identity" to "kimlik",
    "identity note" to "kimlik notu",
    "live" to "etkin",
    "live records" to "yayındaki kayıtlar",
    "matched on our nonce, not just our key" to
        "yalnızca anahtarımızla değil, nonce değerimizle eşleşti",
    "no thanks, continue" to "hayır, teşekkürler; devam et",
    "no, nothing was made public" to "hayır, hiçbir şey herkese açılmadı",
    "not asked yet" to "henüz sorulmadı",
    "not found" to "bulunamadı",
    "not yet - the note alone is a claim, not a proof" to
        "henüz değil; not tek başına bir iddiadır, kanıt değildir",
    "opening" to "açılıyor",
    "our exact bytes, no wallet prefix" to "tam baytlarımız, cüzdan öneki yok",
    "passport for seeker" to "seeker için passport",
    "private key, 32 bytes, hex" to "özel anahtar, 32 bayt, hex",
    "protect passport" to "passport'ı koru",
    "publish identity" to "kimliği yayımla",
    "published" to "yayımlandı",
    "re-check with the server" to "sunucuyla yeniden kontrol et",
    "re-checked when the app opened" to "uygulama açıldığında yeniden kontrol edildi",
    "records the server still holds" to "sunucunun hâlâ tuttuğu kayıtlar",
    "recovery" to "kurtarma",
    "room" to "oda",
    "save my key" to "anahtarımı kaydet",
    "save to a file" to "dosyaya kaydet",
    "self test" to "öz test",
    "send a tip" to "bahşiş gönder",
    "sequence" to "sıra",
    "settings" to "ayarlar",
    "sign and check in" to "imzala ve kayıt bırak",
    "sign today's record" to "bugünün kaydını imzala",
    "signed" to "imzalı",
    "signed and verified against your DID" to "imzalandı ve DID'nizle doğrulandı",
    "storage" to "depolama",
    "support the builder" to "geliştiriciyi destekle",
    "technocore.chat refused the note" to "technocore.chat notu reddetti",
    "technocore.chat refused the signed write" to
        "technocore.chat imzalı yazma işlemini reddetti",
    "text" to "metin",
    "the same wallet rebuilds this identity anywhere" to
        "aynı cüzdan bu kimliği her yerde yeniden oluşturur",
    "unconfirmed" to "doğrulanmadı",
    "verified" to "doğrulandı",
    "verify it yourself" to "kendiniz doğrulayın",
    "version" to "sürüm",
    "vouched for" to "anahtarla doğrulandı",
    "wallet" to "cüzdan",
    "wallet linked" to "cüzdan bağlandı",
    "what this app never does" to "bu uygulamanın hiçbir zaman yapmadıkları",
    "what to do" to "yapılması gerekenler",
    "when" to "zaman",
    "with a wallet prefix, which is fine and pinned" to
        "cüzdan önekiyle; bu kabul edilir ve sabitlenmiştir",
    "working" to "işleniyor",
    "yes, a signed did-note line carries its hash" to
        "evet, imzalı bir did-note satırı kendi hash değerini taşır",
    "yes, delete" to "evet, sil",
    "yes, something is already public" to "evet, bir şey zaten herkese açık",
    "your identity" to "kimliğiniz",
    "your private key" to "özel anahtarınız",
)
