package dev.alexkosa.flooppassport.i18n

/**
 * Russian.
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
internal val RU_STRINGS: Map<String, String> = mapOf(
    "A message signed by your Passport, posted to a quiet room and then read back to prove it landed." to
        "Сообщение, подписанное вашим Passport, отправляется в тихую комнату и считывается оттуда для подтверждения доставки.",
    "A once-a-day reminder to leave today's signed record." to
        "Ежедневное напоминание оставить сегодняшнюю подписанную запись.",
    "A permanent note at an address derived from your key, so anyone can find and verify you later." to
        "Постоянная запись по адресу, полученному из вашего ключа, чтобы позже любой мог найти и проверить вашу личность.",
    "A public note at an address derived from your key, so anyone can find and verify you later." to
        "Публичная запись по адресу, полученному из вашего ключа, чтобы позже любой мог найти и проверить вас.",
    "A signed record has to be left by hand, and a missed day cannot be filled in later. This is also the switch that warns you before your identity note is deleted." to
        "Подписанную отметку нужно оставлять вручную, а пропущенный день нельзя добавить позже. Этот переключатель также включает предупреждения перед удалением записи о вашей личности.",
    "A tip changes nothing about your Passport and nothing about any airdrop." to
        "Чаевые ничего не меняют в вашем Passport и не влияют ни на один аирдроп.",
    "A tip changes nothing about your Passport, and nothing about any airdrop. It is a thank you, not a fee." to
        "Чаевые ничего не меняют в вашем Passport и не влияют ни на один аирдроп. Это благодарность, а не плата.",
    "About" to "О приложении",
    "Accepted, but we could not read it back yet" to
        "Принято, но пока не удалось считать обратно",
    "Activity" to "Активность",
    "Already checked in, found in the room" to "Запись уже оставлена и найдена в комнате",
    "Already published, read back just now" to "Уже опубликовано и только что считано обратно",
    "Android is blocking notifications for this app. Turn them on in the system settings." to
        "Android блокирует уведомления этого приложения. Включите их в настройках системы.",
    "Anyone can check it at the address in step 03. This app promises nothing about any allocation, and never will." to
        "Любой может проверить это по адресу из шага 03. Приложение ничего не обещает в отношении какого-либо распределения и никогда не будет.",
    "Anyone holding it can sign as you" to "Любой владелец сможет подписывать от вашего имени",
    "Anyone holding seed_hex can sign as this identity on Technocore." to
        "Любой владелец seed_hex сможет подписывать от имени этой личности в Technocore.",
    "Anyone with this can be you" to "Любой владелец сможет действовать от вашего имени",
    "Apply" to "Применить",
    "Cancel" to "Отмена",
    "Check in" to "Оставить запись",
    "Check your connection and try again." to "Проверьте подключение и повторите попытку.",
    "Could not open the security prompt on this screen." to
        "Не удалось открыть запрос безопасности на этом экране.",
    "Could not reach technocore.chat" to "Не удалось подключиться к technocore.chat",
    "Could not reach technocore.chat. This says nothing about your records, only about the connection." to
        "Не удалось подключиться к technocore.chat. Это относится только к соединению, а не к вашим записям.",
    "Could not reach the server." to "Не удалось связаться с сервером.",
    "Could not read the key back from secure storage" to
        "Не удалось считать ключ из защищённого хранилища",
    "Create" to "Создать",
    "Create your Passport" to "Создайте свой Passport",
    "Create your Passport first. There is nothing to show until something has been signed." to
        "Сначала создайте свой Passport. Пока ничего не подписано, показывать нечего.",
    "Created my FLOP Passport on a Solana Seeker." to
        "Создал свой FLOP Passport на Solana Seeker.",
    "Daily activity" to "Ежедневная активность",
    "Daily reminder" to "Ежедневное напоминание",
    "Delete it?" to "Удалить?",
    "Delete the Passport and create it again from your wallet." to
        "Удалите Passport и создайте его заново из своего кошелька.",
    "Deleted after seven days without a record. Sign one now and it goes back to the same address." to
        "Удалена после семи дней без отметок. Подпишите отметку сейчас, и запись вернётся по тому же адресу.",
    "Deleting removes the Passport from this phone only. Anything already published may stay public, and the same wallet rebuilds the same identity - so this is not a way to undo anything." to
        "Удаление убирает Passport только с этого телефона. Всё уже опубликованное может остаться публичным, а тот же кошелёк восстановит ту же идентичность — поэтому так нельзя отменить выполненные действия.",
    "Deleting removes the Passport from this phone only. Anything already published stays public, and the same wallet rebuilds the same identity - so this is not a way to undo anything." to
        "Удаление убирает Passport только с этого телефона. Всё уже опубликованное останется общедоступным, а тот же кошелёк воссоздаст ту же личность, поэтому отменить что-либо таким способом нельзя.",
    "Derived from a Seed Vault signature, sealed by StrongBox on device." to
        "Получен из подписи Seed Vault и запечатан в StrongBox на устройстве.",
    "Derived from a signature my wallet made inside Seed Vault, then sealed by StrongBox." to
        "Получен из подписи, созданной моим кошельком внутри Seed Vault, затем запечатан в StrongBox.",
    "Every language listed here has a full translation." to
        "Для каждого указанного здесь языка доступен полный перевод.",
    "FLOP Passport creates a Technocore identity from your Solana wallet and keeps the receipts." to
        "FLOP Passport создаёт личность Technocore из вашего кошелька Solana и сохраняет подтверждения.",
    "FLOP Passport for Seeker" to "FLOP Passport для Seeker",
    "FLOP Passport for Seeker - private backup" to
        "FLOP Passport для Seeker — закрытая резервная копия",
    "FLOP Passport for Seeker by @AlexKosa1" to "FLOP Passport для Seeker от @AlexKosa1",
    "FLOP Passport for Seeker. First signed check-in." to
        "FLOP Passport для Seeker. Первая подписанная запись.",
    "FLOP asked agents to do something useful. A signed record is what proves you did, and a day without one is a day nobody can check later." to
        "FLOP попросил агентов сделать что-то полезное. Подписанная запись подтверждает, что это сделано, а день без неё позже никто не сможет проверить.",
    "Identity derived from your wallet signature" to
        "Личность, полученная из подписи вашего кошелька",
    "Identity note published, first check in signed and verified on Technocore." to
        "Запись о личности опубликована, первая запись подписана и проверена в Technocore.",
    "Identity note published, first check in verified on Technocore." to
        "Запись о личности опубликована, первая запись проверена в Technocore.",
    "Identity note published, first check in verified." to
        "Запись о личности опубликована, первая запись проверена.",
    "If it does get deleted, your Passport is not gone: the same wallet still gives the same identity, and signing a record publishes the note back to the same address." to
        "Если запись всё же удалят, ваш Passport не исчезнет: тот же кошелёк по-прежнему создаёт ту же личность, а подписанная отметка вернёт запись по тому же адресу.",
    "It never asks for your wallet recovery phrase." to
        "Приложение никогда не запрашивает фразу восстановления кошелька.",
    "It promises nothing about any airdrop, and never will." to
        "Приложение ничего не обещает в отношении какого-либо аирдропа и никогда не будет.",
    "It will be deleted after seven days without a record." to
        "Она будет удалена, если семь дней не будет отметок.",
    "Keep this file offline. Never send it to anyone, including the app author." to
        "Храните этот файл офлайн. Никому его не отправляйте, включая автора приложения.",
    "Keep your record going" to "Продолжайте вести записи",
    "Key born in Seed Vault, sealed by StrongBox on device." to
        "Ключ создан в Seed Vault и запечатан устройством через StrongBox.",
    "Language" to "Язык",
    "Leave today's signed record on Technocore." to
        "Оставьте сегодняшнюю подписанную запись в Technocore.",
    "Make your first signed check-in" to "Оставьте первую подписанную запись",
    "My FLOP Passport, created on a Solana Seeker." to
        "Мой FLOP Passport, созданный на Solana Seeker.",
    "Next: create your Passport from your wallet." to
        "Далее: создайте Passport из своего кошелька.",
    "Next: make your first signed check-in." to "Далее: оставьте первую подписанную запись.",
    "Next: publish your identity so anyone can verify you." to
        "Далее: опубликуйте свою личность, чтобы любой мог её проверить.",
    "Next: seal the key in this phone's secure storage." to
        "Далее: запечатайте ключ в защищённом хранилище этого телефона.",
    "No account, no server of ours, no analytics." to
        "Без учётной записи, нашего сервера и аналитики.",
    "No wallet on this phone opened the payment link." to
        "Ни один кошелёк на этом телефоне не открыл платёжную ссылку.",
    "No. Nothing was published." to "Нет. Ничего не опубликовано.",
    "Not checked yet." to "Ещё не проверено.",
    "Nothing asked yet" to "Запросов пока не было",
    "Nothing found. If you signed something and it is not here, the room has been trimmed past it - which is normal, and exactly why this screen exists." to
        "Ничего не найдено. Если вы что-то подписали, но этого здесь нет, старая часть комнаты уже удалена, что нормально и является причиной существования этого экрана.",
    "Nothing has vouched for this text yet. Publish again to sign for it." to
        "За этот текст пока никто не поручился. Опубликуйте снова, чтобы подписать его.",
    "Nothing signed today yet." to "Сегодня пока ничего не подписано.",
    "Only languages with a real translation are listed. A picker offering languages that all render English would say your language is supported and then prove otherwise on the next screen." to
        "Указаны только языки, для которых есть настоящий перевод. Если бы все доступные языки отображались на английском, этот список сообщал бы о поддержке вашего языка, а следующий экран показывал бы обратное.",
    "Opening a connection" to "Установка соединения",
    "Opening your Solana wallet" to "Открывается ваш кошелёк Solana",
    "Passport at risk" to "Passport под угрозой",
    "Press Create again. Nothing was sent anywhere." to
        "Нажмите «Создать» ещё раз. Ничего никуда не отправлено.",
    "Protect" to "Защитить",
    "Protect it" to "Защитите",
    "Publish" to "Опубликовать",
    "Publish your identity" to "Опубликуйте свою личность",
    "Published and read back from the server" to "Опубликовано и считано обратно с сервера",
    "Published, read back, and vouched for by your key" to
        "Опубликовано, считано обратно и подтверждено вашим ключом",
    "Publishing your identity note to technocore.chat" to
        "Запись о вашей личности публикуется в technocore.chat",
    "Publishing your note" to "Публикация заметки",
    "Read from technocore.chat just now, not from this phone. Rooms are trimmed as they grow, so this is what anyone would find today." to
        "Только что считано из technocore.chat, а не с этого телефона. По мере роста старые части комнат удаляются, поэтому сегодня любой найдёт именно это.",
    "Reading your note" to "Чтение заметки",
    "Reading your records" to "Чтение записей",
    "Ready" to "Готово",
    "Remind me once a day" to "Напоминать раз в день",
    "Renewed today. technocore.chat keeps it for seven days after the last write, and this app rewrites it every time you open it." to
        "Обновлена сегодня. technocore.chat хранит её семь дней после последнего обновления, а приложение обновляет её при каждом открытии.",
    "Sealed by Android Keystore" to "Запечатано через Android Keystore",
    "Sealed by StrongBox, this phone's separate security chip" to
        "Запечатано через StrongBox, отдельный защитный чип телефона",
    "Sealed by this phone's trusted execution environment" to
        "Запечатано доверенной средой выполнения этого телефона",
    "Sealing the key in this device's secure storage" to
        "Ключ запечатывается в защищённом хранилище устройства",
    "Sending your signed record" to "Отправка подписанной записи",
    "Sent, but not confirmed in the room yet" to
        "Отправлено, но пока не подтверждено в комнате",
    "Settings" to "Настройки",
    "Seven days without a record. Open the app to publish it again." to
        "Семь дней без отметок. Откройте приложение, чтобы опубликовать её снова.",
    "Show your private key" to "Показать закрытый ключ",
    "Signed, accepted and found again in the room" to
        "Подписано, принято и снова найдено в комнате",
    "Signing your first check-in and sending it" to
        "Первая запись подписывается и отправляется",
    "Somebody changed this note after your key signed for it. Publish again." to
        "Кто-то изменил заметку после того, как ваш ключ за неё поручился. Опубликуйте снова.",
    "Talking to the service" to "Связь с сервисом",
    "Thanks for building this" to "Поблагодарить разработчика",
    "That was the last step. Your Passport is live." to
        "Это был последний шаг. Ваш Passport действует.",
    "The identity is born inside Seed Vault and sealed by StrongBox on the phone." to
        "Личность создаётся внутри Seed Vault и запечатывается через StrongBox на телефоне.",
    "The key is sealed in this phone's secure storage, then read back and checked against your identity." to
        "Ключ запечатывается в защищённом хранилище телефона, затем считывается обратно и сверяется с вашей личностью.",
    "The server is busy. Trying again." to "Сервер занят. Повторная попытка.",
    "The stored key does not match your identity" to
        "Сохранённый ключ не соответствует вашей личности",
    "The wallet did not complete the signature" to "Кошелёк не завершил подписание",
    "There are no points here and no score. FLOP asked agents to do something useful, so what counts is a record a person can still open. A number invented by this app would be a different game." to
        "Здесь нет баллов и счёта. FLOP предложил агентам сделать что-то полезное, поэтому имеет значение запись, которую человек всё ещё может открыть. Число, придуманное этим приложением, относилось бы к другой игре.",
    "These 32 bytes are your FLOP Passport itself. Whoever holds them can sign as you on Technocore. Keep them offline and never send them to anyone, including us." to
        "Эти 32 байта и есть ваш FLOP Passport. Их владелец сможет подписывать от вашего имени в Technocore. Храните их офлайн и никому не отправляйте, включая нас.",
    "This app is free and open source, and nobody paid for it. If it saved you an afternoon, a tip is welcome." to
        "Это бесплатное приложение с открытым исходным кодом, созданное без оплаты. Если оно сэкономило вам несколько часов, можно оставить чаевые.",
    "This app rewrites your note every time you open it and every time you sign a record, so the seven days start again. Open it at least once a week and nothing is ever lost." to
        "Приложение обновляет запись при каждом открытии и при каждой подписанной отметке, поэтому отсчёт семи дней начинается заново. Открывайте его хотя бы раз в неделю, и ничего не потеряется.",
    "This is NOT your Solana wallet key. Your wallet's own key never leaves Seed Vault and this app has never seen it. What you are looking at is a separate key that signs only on Technocore." to
        "Это НЕ ключ вашего кошелька Solana. Собственный ключ кошелька никогда не покидает Seed Vault, и приложение его не видело. Перед вами отдельный ключ, используемый для подписания только в Technocore.",
    "Three days left before it is deleted." to "До удаления осталось три дня.",
    "Told only when your identity note is days away from being deleted." to
        "Вы получите уведомление, только когда до удаления записи о вашей личности останется несколько дней.",
    "Tomorrow is the last day." to "Завтра последний день.",
    "Try again. Nothing was posted." to "Повторите попытку. Ничего не отправлено.",
    "Try again. Nothing was published." to "Повторите попытку. Ничего не опубликовано.",
    "Two days left before it is deleted." to "До удаления осталось два дня.",
    "Use the phone's language" to "Использовать язык телефона",
    "Wait a moment and press it again to re-check. Do not treat this as a failure." to
        "Подождите немного и нажмите ещё раз для повторной проверки. Не считайте это ошибкой.",
    "Wait a moment and press it again to re-check. Sending it as a new message would post twice in public." to
        "Подождите немного и нажмите ещё раз для повторной проверки. Отправка нового сообщения создаст две общедоступные записи.",
    "What is still provable" to "Что ещё можно доказать",
    "What recovery without a seed phrase costs" to
        "Чем приходится платить за восстановление без seed-фразы",
    "Yes. Something is already visible to others." to "Да. Другим уже что-то видно.",
    "You do not need this file to recover. The same Solana wallet that" to
        "Этот файл не нужен для восстановления. Тот же кошелёк Solana, который",
    "You do not need this to recover. The same Solana wallet rebuilds the same Passport on any phone. This copy is for using the key somewhere else, on your own terms." to
        "Это не нужно для восстановления. Тот же кошелёк Solana воссоздаёт тот же Passport на любом телефоне. Эта копия нужна для самостоятельного использования ключа в другом месте.",
    "You have already checked in" to "Вы уже оставили запись",
    "You have already left a record today." to "Сегодня вы уже оставили запись.",
    "You're all set" to "Всё готово",
    "Your Passport is born inside Seed Vault, the Seeker's hardware key store, from which a key cannot be extracted. On this phone it is then sealed by Android's secure storage. Signing itself happens in the app, not in hardware, because Android Keystore cannot hold this kind of key - so we say sealed, not signed, in hardware." to
        "Ваш Passport создаётся внутри Seed Vault, аппаратного хранилища ключей Seeker, из которого ключ нельзя извлечь. Затем на этом телефоне он запечатывается защищённым хранилищем Android. Само подписание выполняется в приложении, а не аппаратно, поскольку Android Keystore не поддерживает такой тип ключа, поэтому мы говорим об аппаратном запечатывании, а не подписании.",
    "Your Passport is derived from one signature your wallet makes inside Seed Vault, the Seeker's hardware key store. The wallet key never leaves that hardware. The Passport key is computed from its signature in this app and then sealed by Android's secure storage - sealed, not signed, in hardware, because Android Keystore cannot hold this kind of key." to
        "Ваш Passport создаётся из одной подписи, которую кошелёк формирует внутри Seed Vault, аппаратного хранилища ключей Seeker. Ключ кошелька никогда не покидает это оборудование. Ключ Passport вычисляется в этом приложении из подписи, а затем запечатывается защищённым хранилищем Android — именно запечатывается, а не подписывается, аппаратно, поскольку Android Keystore не может хранить ключи такого типа.",
    "Your Passport is live" to "Ваш Passport действует",
    "Your Passport is live and your first signed record is on Technocore. Anyone can verify it, and it stays yours." to
        "Ваш Passport действует, а первая подписанная запись находится в Technocore. Любой может её проверить, и она остаётся вашей.",
    "Your Passport is live." to "Ваш Passport действует.",
    "Your Passport is rebuilt from one wallet signature, which is why no seed phrase exists to lose. The same fact cuts the other way: any app that persuades your wallet to sign that exact sentence can rebuild this Passport. Read what a wallet asks you to sign, here and everywhere else." to
        "Passport восстанавливается из одной подписи кошелька — поэтому и нет seed-фразы, которую можно потерять. У этого есть обратная сторона: любое приложение, уговорившее ваш кошелёк подписать ровно ту же фразу, восстановит этот Passport. Читайте, что кошелёк просит подписать, здесь и везде.",
    "Your Passport itself is not lost: the same wallet still gives the same identity, and signing a record now publishes the note back to the same address." to
        "Сам Passport не потерян: тот же кошелёк по-прежнему создаёт ту же личность, а если подписать отметку сейчас, запись снова появится по тому же адресу.",
    "Your identity note expires soon" to "Запись о вашей личности скоро исчезнет",
    "Your identity note has been deleted" to "Запись о вашей личности удалена",
    "Your key is never sent anywhere. Only you can export it." to
        "Ваш ключ никуда не отправляется. Экспортировать его можете только вы.",
    "Your key never leaves this phone." to "Ваш ключ никогда не покидает этот телефон.",
    "Your key signed a line carrying this note's exact hash." to
        "Ваш ключ подписал строку с точным хэшем этой заметки.",
    "Your note has to be kept alive" to "Запись нужно поддерживать",
    "Your wallet signs one statement. It is not a transaction and moves no funds. The same wallet rebuilds the same Passport on any device." to
        "Ваш кошелёк подписывает одно утверждение. Это не транзакция, и средства не перемещаются. Тот же кошелёк воссоздаёт тот же Passport на любом устройстве.",
    "active days" to "активных дней",
    "activity" to "активность",
    "address" to "адрес",
    "agent: FLOP Passport for Seeker" to "агент: FLOP Passport для Seeker",
    "algorithm: Ed25519, did:key, 32-byte seed" to
        "алгоритм: Ed25519, did:key, 32-байтовый seed",
    "built by a community builder" to "создано участником сообщества",
    "cancel" to "отмена",
    "change" to "изменить",
    "changed" to "изменено",
    "checked" to "проверено",
    "close" to "закрыть",
    "connection" to "соединение",
    "content" to "содержимое",
    "continue" to "продолжить",
    "copy key" to "копировать ключ",
    "create passport" to "создать passport",
    "created this Passport rebuilds it on any device." to
        "создал этот Passport, воссоздаёт его на любом устройстве.",
    "danger zone" to "опасная зона",
    "day streak" to "дней подряд",
    "delete passport from this phone" to "удалить passport с этого телефона",
    "detail" to "сведения",
    "did anything go public?" to "что-нибудь стало общедоступным?",
    "done" to "готово",
    "failed" to "ошибка",
    "fetched again and matched exactly" to "получено повторно и полностью совпало",
    "fetched from the server on opening" to "получено с сервера при открытии",
    "fingerprint" to "отпечаток",
    "floop-passport vault self-test" to "самопроверка хранилища floop-passport",
    "identity" to "идентичность",
    "identity note" to "запись о личности",
    "last connection" to "последнее соединение",
    "live" to "активно",
    "live records" to "доступные записи",
    "matched on our nonce, not just our key" to "совпало по нашему nonce, а не только по ключу",
    "no thanks, continue" to "нет, продолжить",
    "no, nothing was made public" to "нет, ничего не стало общедоступным",
    "not found" to "не найдено",
    "not yet - the note alone is a claim, not a proof" to
        "ещё нет — сама запись является утверждением, а не доказательством",
    "off" to "выкл.",
    "on" to "вкл.",
    "our exact bytes, no wallet prefix" to "точно наши байты, без префикса кошелька",
    "passport for seeker" to "passport для seeker",
    "private key, 32 bytes, hex" to "закрытый ключ, 32 байта, hex",
    "protect passport" to "защитить passport",
    "publish identity" to "опубликовать личность",
    "published" to "опубликовано",
    "re-check with the server" to "повторно проверить на сервере",
    "re-checked when the app opened" to "повторно проверено при открытии приложения",
    "records the server still holds" to "записи, ещё хранящиеся на сервере",
    "recovery" to "восстановление",
    "room" to "комната",
    "save my key" to "сохранить мой ключ",
    "save to a file" to "сохранить в файл",
    "self test" to "самопроверка",
    "send a tip" to "отправить чаевые",
    "sequence" to "последовательность",
    "settings" to "настройки",
    "sign and check in" to "подписать и оставить запись",
    "sign today's record" to "подписать сегодняшнюю запись",
    "signed" to "подписано",
    "signed and verified against your DID" to "подписано и проверено по вашему DID",
    "storage" to "хранилище",
    "support the builder" to "поддержать разработчика",
    "technocore.chat answered" to "technocore.chat ответил",
    "technocore.chat deletes anything nobody has written to for seven days. That includes the identity note at the address you save and share." to
        "technocore.chat удаляет всё, что никто не обновлял семь дней. Это касается и записи о вашей личности по адресу, который вы сохраняете и публикуете.",
    "technocore.chat deletes anything with no write for seven days. Signing today rewrites your note and starts the seven days again." to
        "technocore.chat удаляет всё, что не обновлялось семь дней. Подпишите отметку сегодня, чтобы обновить запись и начать отсчёт семи дней заново.",
    "technocore.chat refused the note" to "technocore.chat отклонил запись",
    "technocore.chat refused the signed write" to "technocore.chat отклонил подписанную запись",
    "text" to "текст",
    "the same wallet rebuilds this identity anywhere" to
        "тот же кошелёк воссоздаёт эту личность где угодно",
    "unconfirmed" to "не подтверждено",
    "unsigned" to "без подписи",
    "verified" to "подтверждено",
    "verify it yourself" to "проверить самостоятельно",
    "version" to "версия",
    "vouched for" to "подтверждено",
    "wallet" to "кошелёк",
    "wallet linked" to "кошелёк связан",
    "what this app never does" to "чего это приложение никогда не делает",
    "what to do" to "что делать",
    "when" to "когда",
    "with a wallet prefix, which is fine and pinned" to
        "с префиксом кошелька, что допустимо и закреплено",
    "working" to "обработка",
    "yes, a signed did-note line carries its hash" to
        "да, подписанная строка did-note содержит свой хеш",
    "yes, delete" to "да, удалить",
    "yes, something is already public" to "да, кое-что уже общедоступно",
    "your identity" to "ваша личность",
    "your private key" to "ваш закрытый ключ",
)
