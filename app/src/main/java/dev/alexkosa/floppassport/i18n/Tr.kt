package dev.alexkosa.floppassport.i18n

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
    "06  tell them" to "06  onlara anlat",
    "06  tell them  ·  last step" to "06  anlat  ·  son adım",
    "A few more words, and it is yours. One real sentence is all this needs." to
        "Birkaç kelime daha, ve satır senin olur. Tek bir gerçek cümle yeter.",
    "A message signed by your Passport, posted to a quiet room and then read back to prove it landed." to
        "Passport'ınız tarafından imzalanan, sakin bir odaya gönderilip ulaştığını kanıtlamak için geri okunan bir mesaj.",
    "A message signed by your Passport, posted to a quiet room and then read back to prove it landed. Same service as step 03, same rule: if it refuses, press again. It is their load, not your key." to
        "Passport'unla imzalanmış bir mesaj sessiz bir odaya gönderilir, sonra ulaştığını kanıtlamak için geri okunur. 03. adımdaki hizmetin aynısı, kuralın da aynısı: reddederse tekrar bas. Bu onların yükü, senin anahtarın değil.",
    "A once-a-day reminder to leave today's signed record." to
        "Bugünün imzalı kaydını bırakmak için günde bir kez hatırlatma.",
    "A permanent note at an address derived from your key, so anyone can find and verify you later." to
        "Anahtarınızdan türetilen bir adreste kalıcı bir not; böylece daha sonra herkes sizi bulup doğrulayabilir.",
    "A public note at an address derived from your key, so anyone can find and verify you later." to
        "Anahtarınızdan türetilen bir adreste yayımlanan herkese açık bir not; böylece daha sonra herkes sizi bulabilir ve doğrulayabilir.",
    "A public note at an address derived from your key, so anyone can find and verify you later. This one goes to technocore.chat, which is someone else's public service: when it is busy it refuses, and pressing again is the answer. Two or three attempts is normal and means nothing is wrong with your phone." to
        "Anahtarından hesaplanan bir adreste kamuya açık bir not; böylece sonradan seni bulup doğrulayabilirler. Bu adım technocore.chat'e gider, yani başkasının kamuya açık hizmetine: yoğunken reddeder ve cevabı tekrar basmaktır. İki üç deneme normaldir ve telefonunda bir sorun olmadığı anlamına gelir.",
    "A signed record has to be left by hand, and a missed day cannot be filled in later. This is also the switch that warns you before your identity note is deleted." to
        "İmzalı bir kaydı kendiniz bırakmanız gerekir ve kaçırılan bir gün daha sonra tamamlanamaz. Bu ayar ayrıca kimlik notunuz silinmeden önce sizi uyarır.",
    "A tip changes nothing about your Passport and nothing about any airdrop." to
        "Bahşiş, Passport'ınız veya herhangi bir airdrop hakkında hiçbir şeyi değiştirmez.",
    "A tip changes nothing about your Passport, and nothing about any airdrop. It is a thank you, not a fee." to
        "Bahşiş, Passport'ınız veya herhangi bir airdrop hakkında hiçbir şeyi değiştirmez. Bu bir teşekkürdür, ücret değildir.",
    "About" to "Hakkında",
    "Accepted, but we could not read it back yet" to
        "Kabul edildi, ancak henüz geri okuyamadık",
    "Activity" to "Etkinlik",
    "All five done" to "Beşi de tamam",
    "All six done" to "Altısı da tamam",
    "Already checked in, found in the room" to "Kayıt zaten bırakılmış, odada bulundu",
    "Already published, read back just now" to "Zaten yayımlanmış, az önce geri okundu",
    "Android is blocking notifications for this app. Turn them on in the system settings." to
        "Android bu uygulamanın bildirimlerini engelliyor. Bildirimleri sistem ayarlarından açın.",
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
    "Could not reach the server." to "Sunucuya ulaşılamadı.",
    "Could not read the key back from secure storage" to
        "Anahtar güvenli depolamadan geri okunamadı",
    "Create" to "Oluştur",
    "Create your Passport" to "Passport'ınızı oluşturun",
    "Create your Passport first. There is nothing to show until something has been signed." to
        "Önce Passport'ınızı oluşturun. Bir şey imzalanana kadar gösterilecek bir şey yok.",
    "Created my FLOP Passport on a Solana Seeker." to
        "FLOP Passport'ımı bir Solana Seeker üzerinde oluşturdum.",
    "Daily activity" to "Günlük etkinlik",
    "Daily reminder" to "Günlük hatırlatma",
    "Delete it?" to "Silinsin mi?",
    "Delete the Passport and create it again from your wallet." to
        "Passport'ı silin ve cüzdanınızdan yeniden oluşturun.",
    "Deleted after seven days without a record. Sign one now and it goes back to the same address." to
        "Yedi gün boyunca kayıt bırakılmadığı için silindi. Şimdi bir kayıt imzalarsanız aynı adrese geri gelir.",
    "Deleting removes the Passport from this phone only. Anything already published may stay public, and the same wallet rebuilds the same identity - so this is not a way to undo anything." to
        "Silme işlemi Passport'ı yalnızca bu telefondan kaldırır. Daha önce yayımlanmış içerikler herkese açık kalabilir ve aynı cüzdan aynı kimliği yeniden oluşturur; dolayısıyla bu işlem hiçbir şeyi geri almaz.",
    "Deleting removes the Passport from this phone only. Anything already published stays public, and the same wallet rebuilds the same identity - so this is not a way to undo anything." to
        "Silme işlemi Passport'ı yalnızca bu telefondan kaldırır. Daha önce yayımlanan her şey herkese açık kalır ve aynı cüzdan aynı kimliği yeniden oluşturur; dolayısıyla bu, herhangi bir şeyi geri alma yolu değildir.",
    "Derived from a Seed Vault signature, sealed by StrongBox on device." to
        "Bir Seed Vault imzasından türetildi, cihazda StrongBox ile mühürlendi.",
    "Derived from a signature my wallet made inside Seed Vault, then sealed by StrongBox." to
        "Cüzdanımın Seed Vault içinde oluşturduğu bir imzadan türetildi, ardından StrongBox ile mühürlendi.",
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
    "FLOP asked agents to do something useful. A signed record is what proves you did, and a day without one is a day nobody can check later." to
        "FLOP, ajanlardan yararlı bir şey yapmalarını istedi. Bunu yaptığınızı imzalı bir kayıt kanıtlar; kayıtsız geçen bir günü daha sonra kimse doğrulayamaz.",
    "FLOP asked agents to do two things: create a unique key, and do something useful to spread the word about Technocore. The five steps above did the first. Nobody can do the second for you, so this writes the post and you decide whether to send it." to
        "FLOP aracılardan iki şey istedi: benzersiz bir anahtar oluşturmak ve Technocore’u duyurmak için faydalı bir şey yapmak. Yukarıdaki beş adım ilkini yaptı. İkincisini sizin yerinize kimse yapamaz, bu yüzden uygulama gönderiyi yazar ve gönderip göndermemeye siz karar verirsiniz.",
    "Identity derived from your wallet signature" to "Cüzdan imzanızdan türetilen kimlik",
    "Identity note published, first check in signed and verified on Technocore." to
        "Kimlik notu yayımlandı, ilk kayıt Technocore üzerinde imzalandı ve doğrulandı.",
    "Identity note published, first check in verified on Technocore." to
        "Kimlik notu yayımlandı, ilk kayıt Technocore üzerinde doğrulandı.",
    "Identity note published, first check in verified." to
        "Kimlik notu yayımlandı, ilk kayıt doğrulandı.",
    "If it does get deleted, your Passport is not gone: the same wallet still gives the same identity, and signing a record publishes the note back to the same address." to
        "Silinse bile Passport kaybolmaz: aynı cüzdan hâlâ aynı kimliği verir ve bir kayıt imzaladığınızda not aynı adreste yeniden yayımlanır.",
    "In one line: what you did, or why you set this up" to
        "Tek satırda: ne yaptın ya da bunu neden kurdun",
    "It never asks for your wallet recovery phrase." to
        "Cüzdan kurtarma ifadenizi hiçbir zaman istemez.",
    "It promises nothing about any airdrop, and never will." to
        "Herhangi bir airdrop hakkında hiçbir söz vermez ve vermeyecektir.",
    "It will be deleted after seven days without a record." to
        "Yedi gün boyunca kayıt bırakılmazsa silinecek.",
    "Keep this file offline. Never send it to anyone, including the app author." to
        "Bu dosyayı çevrimdışı tutun. Uygulamanın yazarı dahil hiç kimseye göndermeyin.",
    "Keep your record going" to "Kaydınızı sürdürün",
    "Key born in Seed Vault, sealed by StrongBox on device." to
        "Anahtar Seed Vault içinde oluşturuldu, cihazdaki StrongBox ile mühürlendi.",
    "Language" to "Dil",
    "Leave it blank and the post still works. It just says less." to
        "Boş bıraksan da gönderi çalışır. Sadece daha az şey söyler.",
    "Leave today's signed record on Technocore." to
        "Bugünün imzalı kaydını Technocore üzerinde bırakın.",
    "Link to what you built, if there is one" to "Varsa, yaptığın şeyin bağlantısı",
    "Link to your post" to "Gönderinin bağlantısı",
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
    "Not done. Your Passport is not attached to any public name yet, and this is the one step nobody can do for you." to
        "Yapılmadı. Passport'un henüz herhangi bir kamuya açık isme bağlı değil ve bu, kimsenin senin yerine yapamayacağı adım.",
    "Not finished yet. Until all five are green your identity is not published and there is nothing anyone can verify. Keep going." to
        "Henüz bitmedi. Beşi birden yeşile dönmeden kimliğin yayımlanmış olmaz ve kimsenin doğrulayabileceği bir şey yoktur. Devam et.",
    "Nothing asked yet" to "Henüz bir şey sorulmadı",
    "Nothing found. If you signed something and it is not here, the room has been trimmed past it - which is normal, and exactly why this screen exists." to
        "Hiçbir şey bulunamadı. Bir şey imzaladıysanız ve burada değilse oda onu artık içermeyecek şekilde kırpılmıştır; bu normaldir ve bu ekran tam olarak bu nedenle vardır.",
    "Nothing has vouched for this text yet. Publish again to sign for it." to
        "Bu metin için henüz bir kefil yok. İmzalamak için yeniden yayımlayın.",
    "Nothing signed today yet." to "Bugün henüz hiçbir şey imzalanmadı.",
    "One sentence in your own words, please. Thousands of posts that differ only by a key get read as farming, and that lands on the people who did the work." to
        "Lütfen kendi cümlenle bir satır yaz. Yalnızca anahtarı farklı olan binlerce gönderi çiftlik gibi okunur ve bunun bedelini işi gerçekten yapanlar öder.",
    "Only languages with a real translation are listed. A picker offering languages that all render English would say your language is supported and then prove otherwise on the next screen." to
        "Yalnızca gerçek çevirisi olan diller listelenir. Tüm seçenekleri İngilizce gösteren bir dil seçici, dilinizin desteklendiğini söyler ancak sonraki ekranda bunun doğru olmadığını gösterir.",
    "Opening a connection" to "Bağlantı açılıyor",
    "Opening your Solana wallet" to "Solana cüzdanınız açılıyor",
    "Optional, and the part that actually counts." to "İsteğe bağlı, ama asıl önemli olan bu.",
    "Passport at risk" to "Passport risk altında",
    "Paste the link to your post. It goes into your identity note, so the note points at the post and the post carries the key. Anyone can then check both ends against one key." to
        "Gönderinin bağlantısını yapıştır. Kimlik notuna eklenir; böylece not gönderiyi gösterir, gönderi de anahtarı taşır. Sonra herkes iki ucu da aynı anahtarla kontrol edebilir.",
    "Press Create again. Nothing was sent anywhere." to
        "Oluştur'a yeniden basın. Hiçbir yere hiçbir şey gönderilmedi.",
    "Press check in again. technocore.chat is a public service and it refuses writes when it is busy, which has nothing to do with this app, your phone or your key. Two or three attempts is normal. Nothing was posted." to
        "Giriş yap'a tekrar bas. technocore.chat kamuya açık bir hizmettir ve yoğunken yazma isteklerini reddeder; bunun bu uygulamayla, telefonunla ya da anahtarınla ilgisi yoktur. İki üç deneme normaldir. Hiçbir şey gönderilmedi.",
    "Press publish again. technocore.chat is a public service and it refuses writes when it is busy, which has nothing to do with this app, your phone or your key. Two or three attempts is normal. Nothing was published." to
        "Yayımla'ya tekrar bas. technocore.chat kamuya açık bir hizmettir ve yoğunken yazma isteklerini reddeder; bunun bu uygulamayla, telefonunla ya da anahtarınla ilgisi yoktur. İki üç deneme normaldir. Hiçbir şey yayımlanmadı.",
    "Protect" to "Koru",
    "Protect it" to "Onu koruyun",
    "Publish" to "Yayımla",
    "Publish your identity" to "Kimliğinizi yayımlayın",
    "Published and read back from the server" to "Yayımlandı ve sunucudan geri okundu",
    "Published, read back, and vouched for by your key" to
        "Yayımlandı, geri okundu ve anahtarınızla doğrulandı",
    "Publishing your identity note to technocore.chat" to
        "Kimlik notunuz technocore.chat adresinde yayımlanıyor",
    "Publishing your note" to "Notunuz yayımlanıyor",
    "Questions, answered in full" to "Sorular, eksiksiz yanıtlarıyla",
    "Read from technocore.chat just now, not from this phone. Rooms are trimmed as they grow, so this is what anyone would find today." to
        "Az önce bu telefondan değil, technocore.chat üzerinden okundu. Odalar büyüdükçe kırpılır; dolayısıyla bugün herkesin bulacağı kayıt budur.",
    "Reading your note" to "Notunuz okunuyor",
    "Reading your records" to "Kayıtlarınız okunuyor",
    "Ready" to "Hazır",
    "Remind me once a day" to "Bana günde bir kez hatırlat",
    "Renewed today. technocore.chat keeps it for seven days after the last write, and this app rewrites it every time you open it." to
        "Bugün yenilendi. technocore.chat, son yazma işleminden sonra onu yedi gün boyunca saklar ve bu uygulama her açtığınızda yeniden yazar.",
    "Sealed by Android Keystore" to "Android Keystore ile mühürlendi",
    "Sealed by StrongBox, this phone's separate security chip" to
        "Bu telefonun ayrı güvenlik çipi StrongBox ile mühürlendi",
    "Sealed by this phone's trusted execution environment" to
        "Bu telefonun güvenilir yürütme ortamıyla mühürlendi",
    "Sealing the key in this device's secure storage" to
        "Anahtar bu cihazın güvenli depolamasında mühürleniyor",
    "Sending your signed record" to "İmzalı kaydınız gönderiliyor",
    "Sent, but not confirmed in the room yet" to "Gönderildi, ancak odada henüz doğrulanmadı",
    "Settings" to "Ayarlar",
    "Seven days without a record. Open the app to publish it again." to
        "Yedi gün boyunca kayıt bırakılmadı. Yeniden yayımlamak için uygulamayı açın.",
    "Shipped a Technocore client for the Seeker" to
        "Seeker için bir Technocore istemcisi yayınladım",
    "Show your private key" to "Özel anahtarınızı gösterin",
    "Signed, accepted and found again in the room" to
        "İmzalandı, kabul edildi ve odada yeniden bulundu",
    "Signing your first check-in and sending it" to "İlk kaydınız imzalanıp gönderiliyor",
    "Somebody changed this note after your key signed for it. Publish again." to
        "Anahtarınız kefil olduktan sonra biri bu notu değiştirdi. Yeniden yayımlayın.",
    "Talking to the service" to "Hizmetle iletişim kuruluyor",
    "Thanks for building this" to "Bunu geliştirdiğiniz için teşekkürler",
    "That does not look like a link to a post. It should look like https://x.com/you/status/123." to
        "Bu, gönderi bağlantısına benzemiyor. https://x.com/you/status/123 gibi görünmeli.",
    "That does not look like a link. It should start with https://" to
        "Bu bir bağlantıya benzemiyor. https:// ile başlamalı",
    "That was the last step. Your Passport is live. One thing left, and it is the part FLOP actually asked for: tell people what you did. The app writes the post for you at the bottom of this screen." to
        "Bu son adımdı. Passport’ınız aktif. Geriye bir şey kaldı ve FLOP’un asıl istediği de bu: insanlara ne yaptığınızı anlatın. Uygulama gönderiyi bu ekranın altında sizin için yazar.",
    "The five steps built your identity. Nobody outside this phone knows it is yours yet. Step 06 below: write one line, post it, then come back and paste the link. That last part is what puts your name beside your key for good, and it is where people stop." to
        "Beş adım kimliğini kurdu. Bu telefonun dışında onun senin olduğunu henüz kimse bilmiyor. Aşağıda 06. adım: bir satır yaz, paylaş, sonra geri gelip bağlantıyı yapıştır. Adını anahtarının yanına kalıcı olarak koyan tam da bu son kısımdır ve insanlar tam burada duruyor.",
    "The identity is born inside Seed Vault and sealed by StrongBox on the phone." to
        "Kimlik Seed Vault içinde oluşturulur ve telefondaki StrongBox ile mühürlenir.",
    "The key is sealed in this phone's secure storage, then read back and checked against your identity." to
        "Anahtar bu telefonun güvenli depolamasında mühürlenir, ardından geri okunur ve kimliğinizle karşılaştırılır.",
    "The manual" to "Kılavuz",
    "The server is busy. Trying again." to "Sunucu meşgul. Yeniden deneniyor.",
    "The stored key does not match your identity" to "Saklanan anahtar kimliğinizle eşleşmiyor",
    "The wallet did not complete the signature" to "Cüzdan imzalama işlemini tamamlamadı",
    "There are no points here and no score. FLOP asked agents to do something useful, so what counts is a record a person can still open. A number invented by this app would be a different game." to
        "Burada puan veya skor yoktur. FLOP, aracılardan yararlı bir şey yapmalarını istedi; bu nedenle önemli olan, bir kişinin hâlâ açabildiği kayıttır. Bu uygulamanın ürettiği bir sayı farklı bir oyun olurdu.",
    "These 32 bytes are your FLOP Passport itself. Whoever holds them can sign as you on Technocore. Keep them offline and never send them to anyone, including us." to
        "Bu 32 bayt doğrudan FLOP Passport'ınızdır. Bunları elinde tutan kişi Technocore üzerinde sizin adınıza imzalayabilir. Çevrimdışı tutun ve biz dahil hiç kimseye göndermeyin.",
    "This app is free and open source, and nobody paid for it. If it saved you an afternoon, a tip is welcome." to
        "Bu uygulama ücretsiz ve açık kaynaklıdır; geliştirilmesi için kimse ödeme yapmadı. Size bir öğleden sonra kazandırdıysa bahşiş bırakabilirsiniz.",
    "This app is free and open source. If it was useful, you can send a tip to {name}. Your wallet opens and you choose the amount there." to
        "Bu uygulama ücretsiz ve açık kaynaklıdır. İşinize yaradıysa {name} adresine bahşiş gönderebilirsiniz. Cüzdanınız açılır ve tutarı orada siz seçersiniz.",
    "This app is free and there is nothing in it to buy. If it has been useful, kosa.skr is where a thank you goes." to
        "Bu uygulama ücretsizdir ve içinde satın alınacak hiçbir şey yoktur. İşinize yaradıysa, teşekkürünüzü kosa.skr adresine gönderebilirsiniz.",
    "This app rewrites your note every time you open it and every time you sign a record, so the seven days start again. Open it at least once a week and nothing is ever lost." to
        "Bu uygulama, her açtığınızda ve her kayıt imzaladığınızda notunuzu yeniden yazar, böylece yedi günlük süre yeniden başlar. Haftada en az bir kez açarsanız hiçbir şey kaybolmaz.",
    "This is NOT your Solana wallet key. Your wallet's own key never leaves Seed Vault and this app has never seen it. What you are looking at is a separate key that signs only on Technocore." to
        "Bu, Solana cüzdan anahtarınız DEĞİLDİR. Cüzdanınızın kendi anahtarı Seed Vault dışına hiçbir zaman çıkmaz ve bu uygulama onu hiç görmemiştir. Gördüğünüz, yalnızca Technocore üzerinde imza atan ayrı bir anahtardır.",
    "This line is what makes the post yours. Everything under it is the proof." to
        "Bu satır gönderiyi senin yapan şey. Altındaki her şey kanıt.",
    "Three days left before it is deleted." to "Silinmesine üç gün kaldı.",
    "Three things, in this order: write your line, post it, then come back and paste the link. The last one is what makes it permanent, and it is the one people forget." to
        "Sırayla üç şey: satırını yaz, paylaş, sonra geri gel ve bağlantıyı yapıştır. Kalıcı yapan sonuncusudur ve unutulan da tam olarak odur.",
    "Told only when your identity note is days away from being deleted." to
        "Yalnızca kimlik notunuzun silinmesine birkaç gün kaldığında bildirim alırsınız.",
    "Tomorrow is the last day." to "Yarın son gün.",
    "Try again. Nothing was posted." to "Yeniden deneyin. Hiçbir şey gönderilmedi.",
    "Try again. Nothing was published." to "Yeniden deneyin. Hiçbir şey yayımlanmadı.",
    "Two days left before it is deleted." to "Silinmesine iki gün kaldı.",
    "Use the phone's language" to "Telefonun dilini kullan",
    "Wait a moment and press it again to re-check. Do not treat this as a failure." to
        "Biraz bekleyip yeniden kontrol etmek için tekrar basın. Bunu bir hata olarak değerlendirmeyin.",
    "Wait a moment and press it again to re-check. Sending it as a new message would post twice in public." to
        "Biraz bekleyip yeniden kontrol etmek için tekrar basın. Yeni mesaj olarak göndermek, kaydı herkese açık olarak iki kez yayımlar.",
    "What did you actually do?" to "Gerçekte ne yaptın?",
    "What is still provable" to "Hâlâ kanıtlanabilenler",
    "What recovery without a seed phrase costs" to "Seed ifadesi olmadan kurtarmanın bedeli",
    "What to do and how often, why the identity expires, why this works on a Seeker, and what the catch is. Opens in your browser." to
        "Ne yapmanız ve bunu ne sıklıkta yapmanız gerektiği, kimliğin süresinin neden dolduğu, bunun Seeker’da neden çalıştığı ve işin püf noktası. Tarayıcınızda açılır.",
    "Write one line only you would write. Posts that differ from each other by nothing but a key get read as farming, and that lands on the people who did the work." to
        "Yalnızca senin yazacağın bir satır yaz. Birbirinden yalnızca bir anahtarla ayrılan gönderiler çiftlik gibi okunur ve bunun bedelini işi gerçekten yapanlar öder.",
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
    "Your Passport is derived from one signature your wallet makes inside Seed Vault, the Seeker's hardware key store. The wallet key never leaves that hardware. The Passport key is computed from its signature in this app and then sealed by Android's secure storage - sealed, not signed, in hardware, because Android Keystore cannot hold this kind of key." to
        "Passport'ınız, cüzdanınızın Seeker'ın donanım anahtar deposu olan Seed Vault içinde oluşturduğu tek bir imzadan türetilir. Cüzdan anahtarı bu donanımdan hiç çıkmaz. Passport anahtarı, bu uygulamada söz konusu imzadan hesaplanır ve ardından Android'in güvenli depolama alanı tarafından mühürlenir; Android Keystore bu tür bir anahtarı tutamadığı için donanımda imzalanmaz, mühürlenir.",
    "Your Passport is live" to "Passport'ınız yayında",
    "Your Passport is live and it is yours." to "Passport'un yayında ve senin.",
    "Your Passport is live and it is yours. One thing is left, and it is the one FLOP actually asked for: say so publicly, and link it back. Step 06 below." to
        "Passport'un yayında ve senin. Bir şey kaldı, o da FLOP'un asıl istediği şey: bunu herkese söyle ve geri bağla. Aşağıda 06. adım.",
    "Your Passport is live and your first signed record is on Technocore. Anyone can verify it, and it stays yours." to
        "Passport'ınız yayında ve ilk imzalı kaydınız Technocore üzerinde. Herkes bunu doğrulayabilir ve kayıt size ait kalır.",
    "Your Passport is live, it is yours, and your name is on it." to
        "Passport'un yayında, senin ve üzerinde adın var.",
    "Your Passport is live." to "Passport'ınız yayında.",
    "Your Passport is live. One step left." to "Passport'un yayında. Bir adım kaldı.",
    "Your Passport is rebuilt from one wallet signature, which is why no seed phrase exists to lose. The same fact cuts the other way: any app that persuades your wallet to sign that exact sentence can rebuild this Passport. Read what a wallet asks you to sign, here and everywhere else." to
        "Passport tek bir cüzdan imzasından yeniden oluşturulur; kaybedilecek bir seed ifadesi bu yüzden yoktur. Aynı gerçek tersine de işler: cüzdanınıza tam olarak o cümleyi imzalatan herhangi bir uygulama bu Passport'u yeniden oluşturabilir. Bir cüzdanın size imzalattığı şeyi burada ve her yerde okuyun.",
    "Your Passport itself is not lost: the same wallet still gives the same identity, and signing a record now publishes the note back to the same address." to
        "Passport kaybolmadı: aynı cüzdan hâlâ aynı kimliği verir ve şimdi bir kayıt imzalarsanız not aynı adreste yeniden yayımlanır.",
    "Your identity note expires soon" to "Kimlik notunuzun süresi yakında dolacak",
    "Your identity note has been deleted" to "Kimlik notunuz silindi",
    "Your key is never sent anywhere. Only you can export it." to
        "Anahtarınız hiçbir yere gönderilmez. Yalnızca siz dışa aktarabilirsiniz.",
    "Your key never leaves this phone." to "Anahtarınız bu telefondan hiçbir zaman ayrılmaz.",
    "Your key signed a line carrying this note's exact hash." to
        "Anahtarınız bu notun tam karmasını taşıyan bir satırı imzaladı.",
    "Your note has to be kept alive" to "Notunuz aktif tutulmalı",
    "Your post is in your identity note, at your key's own address." to
        "Gönderin kimlik notunda, kendi anahtarının adresinde duruyor.",
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
    "changed" to "değişti",
    "check again" to "yeniden kontrol et",
    "checked" to "kontrol edildi",
    "close" to "kapat",
    "connection" to "bağlantı",
    "content" to "içerik",
    "continue" to "devam et",
    "copy" to "kopyala",
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
    "flop-passport vault self-test" to "flop-passport güvenli depolama öz testi",
    "identity" to "kimlik",
    "identity note" to "kimlik notu",
    "last connection" to "son bağlantı",
    "linked" to "bağlı",
    "live" to "etkin",
    "live records" to "yayındaki kayıtlar",
    "matched on our nonce, not just our key" to
        "yalnızca anahtarımızla değil, nonce değerimizle eşleşti",
    "no thanks, continue" to "hayır, teşekkürler; devam et",
    "no, nothing was made public" to "hayır, hiçbir şey herkese açılmadı",
    "not found" to "bulunamadı",
    "not yet - the note alone is a claim, not a proof" to
        "henüz değil; not tek başına bir iddiadır, kanıt değildir",
    "off" to "kapalı",
    "on" to "açık",
    "open" to "aç",
    "our exact bytes, no wallet prefix" to "tam baytlarımız, cüzdan öneki yok",
    "passport for seeker" to "seeker için passport",
    "pin it to your identity" to "kimliğine sabitle",
    "post it" to "paylaş",
    "private key, 32 bytes, hex" to "özel anahtar, 32 bayt, hex",
    "protect passport" to "passport'ı koru",
    "publish identity" to "kimliği yayımla",
    "publish these to my note" to "bunları notuma yayımla",
    "published" to "yayımlandı",
    "publishing" to "yayımlanıyor",
    "re-check with the server" to "sunucuyla yeniden kontrol et",
    "re-checked when the app opened" to "uygulama açıldığında yeniden kontrol edildi",
    "records the server still holds" to "sunucunun hâlâ tuttuğu kayıtlar",
    "recovery" to "kurtarma",
    "room" to "oda",
    "save my key" to "anahtarımı kaydet",
    "save to a file" to "dosyaya kaydet",
    "say it another way" to "başka türlü söyle",
    "self test" to "öz test",
    "send a tip" to "bahşiş gönder",
    "send a tip in {token}" to "{token} ile bahşiş gönder",
    "send a tip to {name}" to "{name} adresine bahşiş gönder",
    "sequence" to "sıra",
    "settings" to "ayarlar",
    "sign and check in" to "imzala ve kayıt bırak",
    "sign today's record" to "bugünün kaydını imzala",
    "signed" to "imzalı",
    "signed and verified against your DID" to "imzalandı ve DID'nizle doğrulandı",
    "storage" to "depolama",
    "support the builder" to "geliştiriciyi destekle",
    "technocore.chat answered" to "technocore.chat yanıtladı",
    "technocore.chat deletes anything nobody has written to for seven days. That includes the identity note at the address you save and share." to
        "technocore.chat, yedi gün boyunca kimsenin üzerine yazmadığı her şeyi siler. Kaydedip paylaştığınız adresteki kimlik notu da buna dahildir.",
    "technocore.chat deletes anything with no write for seven days. Signing today rewrites your note and starts the seven days again." to
        "technocore.chat, yedi gün boyunca üzerine hiçbir şey yazılmayan her şeyi siler. Bugün imza atmak notunuzu yeniden yazar ve yedi günlük süreyi yeniden başlatır.",
    "technocore.chat refused the note" to "technocore.chat notu reddetti",
    "technocore.chat refused the signed write" to
        "technocore.chat imzalı yazma işlemini reddetti",
    "text" to "metin",
    "the post" to "gönderi",
    "the same wallet rebuilds this identity anywhere" to
        "aynı cüzdan bu kimliği her yerde yeniden oluşturur",
    "try again" to "yeniden dene",
    "unconfirmed" to "doğrulanmadı",
    "unsigned" to "imzasız",
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
    "{token} is preselected and you can switch it." to
        "{token} önceden seçili, isterseniz değiştirebilirsiniz.",
)
