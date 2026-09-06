package dev.alexkosa.floppassport.i18n

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
    "06  tell them" to "06  расскажите им",
    "5 of 6" to "5 из 6",
    "A few more words, and it is yours. One real sentence is all this needs." to
        "Ещё несколько слов, и строчка ваша. Нужно всего одно живое предложение.",
    "A few reminders about the last step, and then they stop." to
        "Несколько напоминаний про последний шаг, потом они прекращаются.",
    "A little too long. Trim it and the whole post fits, key included." to
        "Чуть длинновато. Сократите, и весь пост поместится вместе с ключом.",
    "A once-a-day reminder to leave today's signed record." to
        "Ежедневное напоминание оставить сегодняшнюю подписанную запись.",
    "A public note at an address derived from your key, so anyone can find and verify you later. This one goes to technocore.chat, which is someone else's public service: when it is busy it refuses, and pressing again is the answer. Two or three attempts is normal and means nothing is wrong with your phone." to
        "Публичная заметка по адресу, вычисленному из вашего ключа, чтобы вас потом нашли и проверили. Этот шаг идёт в technocore.chat, а это чужой публичный сервис: когда он загружен, он отказывает, и ответ на это — нажать ещё раз. Две-три попытки это нормально и значит, что с телефоном всё в порядке.",
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
    "All six done" to "Все шесть сделаны",
    "Already checked in, found in the room" to "Запись уже оставлена и найдена в комнате",
    "Already published, read back just now" to "Уже опубликовано и только что считано обратно",
    "Android is blocking notifications for this app. Turn them on in the system settings." to
        "Android блокирует уведомления этого приложения. Включите их в настройках системы.",
    "Anyone can check it at the address in step 03. This app promises nothing about any allocation, and never will." to
        "Любой может проверить это по адресу из шага 03. Приложение ничего не обещает в отношении какого-либо распределения и никогда не будет.",
    "Anyone holding it can sign as you" to "Любой владелец сможет подписывать от вашего имени",
    "Anyone holding seed_hex can sign as this identity on Technocore." to
        "Любой владелец seed_hex сможет подписывать от имени этой личности в Technocore.",
    "Anyone who looks it up sees a key and nothing else." to
        "Кто на него посмотрит, увидит ключ и больше ничего.",
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
    "Daily activity" to "Ежедневная активность",
    "Daily reminder" to "Ежедневное напоминание",
    "Delete it?" to "Удалить?",
    "Deleting removes the Passport from this phone only. Anything already published may stay public, and the same wallet rebuilds the same identity - so this is not a way to undo anything." to
        "Удаление убирает Passport только с этого телефона. Всё уже опубликованное может остаться публичным, а тот же кошелёк восстановит ту же идентичность — поэтому так нельзя отменить выполненные действия.",
    "Did you post it?" to "Опубликовали?",
    "Every language listed here has a full translation." to
        "Для каждого указанного здесь языка доступен полный перевод.",
    "FLOP Passport creates a Technocore identity from your Solana wallet and keeps the receipts." to
        "FLOP Passport создаёт личность Technocore из вашего кошелька Solana и сохраняет подтверждения.",
    "FLOP Passport for Seeker" to "FLOP Passport для Seeker",
    "FLOP Passport for Seeker - private backup" to
        "FLOP Passport для Seeker — закрытая резервная копия",
    "FLOP Passport for Seeker by @AlexKosa1" to "FLOP Passport для Seeker от @AlexKosa1",
    "FLOP asked agents to do something useful. A signed record is how you leave evidence of it, and a day without one is a day nobody can check later." to
        "FLOP попросил агентов делать что-то полезное. Подписанная запись это след, который вы оставляете, а день без неё это день, который потом никто не проверит.",
    "FLOP asked agents to do two things: create a unique key, and do something useful to spread the word about Technocore. The five steps above did the first. Nobody can do the second for you, so this writes the post and you decide whether to send it." to
        "FLOP попросил агентов сделать две вещи: создать уникальный ключ и помочь рассказать о Technocore. Пять шагов выше сделали первое. Второе никто не сделает за вас, поэтому приложение напишет пост, а вы решите, публиковать ли его.",
    "Identity derived from your wallet signature" to
        "Личность, полученная из подписи вашего кошелька",
    "If it does get deleted, your Passport is not gone: the same wallet still gives the same identity, and signing a record publishes the note back to the same address." to
        "Если запись всё же удалят, ваш Passport не исчезнет: тот же кошелёк по-прежнему создаёт ту же личность, а подписанная отметка вернёт запись по тому же адресу.",
    "In one line: what you did, or why you set this up" to
        "Одной строкой: что вы сделали или зачем это завели",
    "It never asks for your wallet recovery phrase." to
        "Приложение никогда не запрашивает фразу восстановления кошелька.",
    "It promises nothing about any airdrop, and never will." to
        "Приложение ничего не обещает в отношении какого-либо аирдропа и никогда не будет.",
    "Keep this file offline. Never send it to anyone, including the app author." to
        "Храните этот файл офлайн. Никому его не отправляйте, включая автора приложения.",
    "Language" to "Язык",
    "Last reminder about this one." to "Про это напоминаю в последний раз.",
    "Link to what you built, if there is one" to "Ссылка на то, что вы создали, если она есть",
    "Link to your post" to "Ссылка на вашу публикацию",
    "Make your first signed check-in" to "Оставьте первую подписанную запись",
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
    "Not done. Your Passport is not attached to any public name yet, and this is the one step nobody can do for you." to
        "Не сделано. Ваш Passport пока не привязан ни к какому публичному имени, и это тот шаг, который за вас не сделает никто.",
    "Nothing asked yet" to "Запросов пока не было",
    "Nothing found. If you signed something and it is not here, the room has been trimmed past it - which is normal, and exactly why this screen exists." to
        "Ничего не найдено. Если вы что-то подписали, но этого здесь нет, старая часть комнаты уже удалена, что нормально и является причиной существования этого экрана.",
    "Nothing has vouched for this text yet. Publish again to sign for it." to
        "За этот текст пока никто не поручился. Опубликуйте снова, чтобы подписать его.",
    "Nothing is broken and nothing is lost. Your Passport works. When you want the public half of it, step 06 is waiting where you left it." to
        "Ничего не сломалось и ничего не потеряно. Ваш Passport работает. Когда захотите его публичную половину, шаг 06 будет там, где вы его оставили.",
    "Nothing signed today yet." to "Сегодня пока ничего не подписано.",
    "One step left" to "Остался один шаг",
    "Only languages with a real translation are listed. A picker offering languages that all render English would say your language is supported and then prove otherwise on the next screen." to
        "Указаны только языки, для которых есть настоящий перевод. Если бы все доступные языки отображались на английском, этот список сообщал бы о поддержке вашего языка, а следующий экран показывал бы обратное.",
    "Opening a connection" to "Установка соединения",
    "Opening your Solana wallet" to "Открывается ваш кошелёк Solana",
    "Paste the link here and your name is attached to your key for good. This is the part people mean to do later and then do not." to
        "Вставьте сюда ссылку, и ваше имя привяжется к ключу навсегда. Это то, что люди собираются сделать потом и не делают.",
    "Paste the link to your post. It goes into your identity note, so the note points at the post and the post carries the key. Anyone can then check both ends against one key." to
        "Вставьте ссылку на свою публикацию. Она попадёт в заметку вашего идентификатора: заметка будет ссылаться на публикацию, а публикация будет содержать ключ. Тогда любой сможет сверить их по одному ключу.",
    "Post your line, then come back and paste the link. That is what attaches your name to your key, and it is the half FLOP asked agents for." to
        "Опубликуйте свою строчку, потом вернитесь и вставьте ссылку. Именно это привязывает ваше имя к вашему ключу, и это та половина, о которой FLOP просил агентов.",
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
    "Questions, answered in full" to "Полные ответы на вопросы",
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
    "Show your private key" to "Показать закрытый ключ",
    "Sign a record now and this day is on your history for good." to
        "Подпишите запись сейчас, и этот день останется в вашей истории навсегда.",
    "Signed, accepted and found again in the room" to
        "Подписано, принято и снова найдено в комнате",
    "Signing your first check-in and sending it" to
        "Первая запись подписывается и отправляется",
    "Somebody changed this note after your key signed for it. Publish again." to
        "Кто-то изменил заметку после того, как ваш ключ за неё поручился. Опубликуйте снова.",
    "Still one step short" to "Всё ещё не хватает одного шага",
    "Talking to the service" to "Связь с сервисом",
    "Thanks for building this" to "Поблагодарить разработчика",
    "That does not look like a link to a post. It should look like https://x.com/you/status/123." to
        "Это не похоже на ссылку на публикацию. Она должна выглядеть примерно так: https://x.com/you/status/123.",
    "That does not look like a link. It should start with https://" to
        "Это не похоже на ссылку. Она должна начинаться с https://",
    "The five steps built your identity. Nobody outside this phone knows it is yours yet. Step 06 below: write one line, post it, then come back and paste the link. That last part is what puts your name beside your key for good, and it is where people stop." to
        "Пять шагов построили вашу личность. За пределами этого телефона пока никто не знает, что она ваша. Шаг 06 ниже: напишите строчку, опубликуйте, потом вернитесь и вставьте ссылку. Именно это ставит ваше имя рядом с вашим ключом навсегда, и именно здесь люди останавливаются.",
    "The key is sealed in this phone's secure storage, then read back and checked against your identity." to
        "Ключ запечатывается в защищённом хранилище телефона, затем считывается обратно и сверяется с вашей личностью.",
    "The manual" to "Инструкция",
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
    "This app is free and open source. If it was useful, you can send a tip to {name}. Your wallet opens and you choose the amount there." to
        "Это бесплатное приложение с открытым исходным кодом. Если оно оказалось полезным, вы можете отправить чаевые {name}. Откроется ваш кошелёк, и сумму вы выберете там.",
    "This app rewrites your note every time you open it and every time you sign a record, so the seven days start again. Open it at least once a week and nothing is ever lost." to
        "Приложение обновляет запись при каждом открытии и при каждой подписанной отметке, поэтому отсчёт семи дней начинается заново. Открывайте его хотя бы раз в неделю, и ничего не потеряется.",
    "This is NOT your Solana wallet key. Your wallet's own key never leaves Seed Vault and this app has never seen it. What you are looking at is a separate key that signs only on Technocore." to
        "Это НЕ ключ вашего кошелька Solana. Собственный ключ кошелька никогда не покидает Seed Vault, и приложение его не видело. Перед вами отдельный ключ, используемый для подписания только в Technocore.",
    "This line is what makes the post yours. Everything under it is the proof." to
        "Эта строчка и делает пост вашим. Всё под ней это доказательство.",
    "Three days left before it is deleted." to "До удаления осталось три дня.",
    "Three things, in this order: write your line, post it, then come back and paste the link. The last one is what makes it permanent, and it is the one people forget." to
        "Три вещи, по порядку: напишите свою строчку, опубликуйте пост, потом вернитесь и вставьте ссылку. Последнее и делает всё это постоянным, и именно про него забывают.",
    "Today cannot be added later" to "Сегодняшний день потом не добавить",
    "Told only when your identity note is days away from being deleted." to
        "Вы получите уведомление, только когда до удаления записи о вашей личности останется несколько дней.",
    "Tomorrow is the last day." to "Завтра последний день.",
    "Two days left before it is deleted." to "До удаления осталось два дня.",
    "Unfinished setup" to "Незаконченная настройка",
    "Use the phone's language" to "Использовать язык телефона",
    "Wait a moment and press it again to re-check. Do not treat this as a failure." to
        "Подождите немного и нажмите ещё раз для повторной проверки. Не считайте это ошибкой.",
    "Wait a moment and press it again to re-check. Sending it as a new message would post twice in public." to
        "Подождите немного и нажмите ещё раз для повторной проверки. Отправка нового сообщения создаст две общедоступные записи.",
    "What is still provable" to "Что ещё можно доказать",
    "What recovery without a seed phrase costs" to
        "Чем приходится платить за восстановление без seed-фразы",
    "What to do and how often, why the identity expires, why this works on a Seeker, and what the catch is. Opens in your browser." to
        "Что делать и как часто, почему срок действия идентификатора истекает, почему это работает на Seeker и в чём подвох. Откроется в браузере.",
    "Write one line only you would write. Posts that differ from each other by nothing but a key get read as farming, and that lands on the people who did the work." to
        "Напишите строчку, которую напишете только вы. Посты, отличающиеся друг от друга одним лишь ключом, читаются как ферма, и достаётся за это тем, кто правда работал.",
    "Yes. Something is already visible to others." to "Да. Другим уже что-то видно.",
    "You do not need this file to recover. The same Solana wallet that" to
        "Этот файл не нужен для восстановления. Тот же кошелёк Solana, который",
    "You do not need this to recover. The same Solana wallet rebuilds the same Passport on any phone. This copy is for using the key somewhere else, on your own terms." to
        "Это не нужно для восстановления. Тот же кошелёк Solana воссоздаёт тот же Passport на любом телефоне. Эта копия нужна для самостоятельного использования ключа в другом месте.",
    "You finished the five. The last one takes a minute." to
        "Пять вы прошли. Последний занимает минуту.",
    "You have already checked in" to "Вы уже оставили запись",
    "You have already left a record today." to "Сегодня вы уже оставили запись.",
    "You're all set" to "Всё готово",
    "Your Passport has no name on it" to "На вашем Passport нет имени",
    "Your Passport is derived from one signature your wallet makes inside Seed Vault, the Seeker's hardware key store. The wallet key never leaves that hardware. The Passport key is computed from its signature in this app and then sealed by Android's secure storage - sealed, not signed, in hardware, because Android Keystore cannot hold this kind of key." to
        "Ваш Passport создаётся из одной подписи, которую кошелёк формирует внутри Seed Vault, аппаратного хранилища ключей Seeker. Ключ кошелька никогда не покидает это оборудование. Ключ Passport вычисляется в этом приложении из подписи, а затем запечатывается защищённым хранилищем Android — именно запечатывается, а не подписывается, аппаратно, поскольку Android Keystore не может хранить ключи такого типа.",
    "Your Passport is live" to "Ваш Passport действует",
    "Your Passport is live and your first signed record is on Technocore. Anyone can verify it, and it stays yours." to
        "Ваш Passport действует, а первая подписанная запись находится в Technocore. Любой может её проверить, и она остаётся вашей.",
    "Your Passport is live, it is yours, and your name is on it." to
        "Ваш Passport живой, он ваш, и на нём стоит ваше имя.",
    "Your Passport is live. One step left." to "Ваш Passport живой. Остался один шаг.",
    "Your Passport is rebuilt from one wallet signature, which is why no seed phrase exists to lose. The same fact cuts the other way: any app that persuades your wallet to sign that exact sentence can rebuild this Passport. Read what a wallet asks you to sign, here and everywhere else." to
        "Passport восстанавливается из одной подписи кошелька — поэтому и нет seed-фразы, которую можно потерять. У этого есть обратная сторона: любое приложение, уговорившее ваш кошелёк подписать ровно ту же фразу, восстановит этот Passport. Читайте, что кошелёк просит подписать, здесь и везде.",
    "Your Passport itself is not lost: the same wallet still gives the same identity, and signing a record now publishes the note back to the same address." to
        "Сам Passport не потерян: тот же кошелёк по-прежнему создаёт ту же личность, а если подписать отметку сейчас, запись снова появится по тому же адресу.",
    "Your identity note expires soon" to "Запись о вашей личности скоро исчезнет",
    "Your identity note has been deleted" to "Запись о вашей личности удалена",
    "Your key is never sent anywhere. Only you can export it." to
        "Ваш ключ никуда не отправляется. Экспортировать его можете только вы.",
    "Your key signed a line carrying this note's exact hash." to
        "Ваш ключ подписал строку с точным хэшем этой заметки.",
    "Your note has to be kept alive" to "Запись нужно поддерживать",
    "Your post is in your identity note, at your key's own address." to
        "Ваш пост лежит в вашей заметке личности, по адресу вашего же ключа.",
    "Your wallet signs one statement. It is not a transaction and moves no funds. The same wallet rebuilds the same Passport on any device." to
        "Ваш кошелёк подписывает одно утверждение. Это не транзакция, и средства не перемещаются. Тот же кошелёк воссоздаёт тот же Passport на любом устройстве.",
    "active days" to "активных дней",
    "activity" to "активность",
    "address" to "адрес",
    "agent: FLOP Passport for Seeker" to "агент: FLOP Passport для Seeker",
    "algorithm: Ed25519, did:key, 32-byte seed" to
        "алгоритм: Ed25519, did:key, 32-байтовый seed",
    "attach it" to "привязать",
    "built by a community builder" to "создано участником сообщества",
    "cancel" to "отмена",
    "change" to "изменить",
    "changed" to "изменено",
    "check again" to "проверить ещё раз",
    "checked" to "проверено",
    "close" to "закрыть",
    "connection" to "соединение",
    "content" to "содержимое",
    "continue" to "продолжить",
    "copy" to "копировать",
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
    "flop-passport vault self-test" to "самопроверка хранилища flop-passport",
    "identity" to "идентичность",
    "identity note" to "запись о личности",
    "language {code}" to "язык {code}",
    "last connection" to "последнее соединение",
    "linked" to "привязано",
    "live records" to "доступные записи",
    "matched on our nonce, not just our key" to "совпало по нашему nonce, а не только по ключу",
    "no thanks, continue" to "нет, продолжить",
    "no, nothing was made public" to "нет, ничего не стало общедоступным",
    "nonce" to "разовый номер",
    "not found" to "не найдено",
    "not yet" to "пока нет",
    "not yet - the note alone is a claim, not a proof" to
        "ещё нет — сама запись является утверждением, а не доказательством",
    "off" to "выкл.",
    "on" to "вкл.",
    "open" to "открыть",
    "our exact bytes, no wallet prefix" to "точно наши байты, без префикса кошелька",
    "passport for seeker" to "passport для seeker",
    "pin it to your identity" to "привязать к идентификатору",
    "post it" to "опубликовать",
    "private key, 32 bytes, hex" to "закрытый ключ, 32 байта, hex",
    "protect passport" to "защитить passport",
    "publish identity" to "опубликовать личность",
    "publish these to my note" to "добавить в мою заметку",
    "published" to "опубликовано",
    "publishing" to "публикуется",
    "re-check with the server" to "повторно проверить на сервере",
    "re-checked when the app opened" to "повторно проверено при открытии приложения",
    "records the server still holds" to "записи, ещё хранящиеся на сервере",
    "recovery" to "восстановление",
    "room" to "комната",
    "save to a file" to "сохранить в файл",
    "say it another way" to "сказать иначе",
    "self test" to "самопроверка",
    "send a tip" to "отправить чаевые",
    "send a tip in {token}" to "отправить чаевые в {token}",
    "send a tip to {name}" to "отправить чаевые {name}",
    "sequence" to "последовательность",
    "settings" to "настройки",
    "sign and check in" to "подписать и оставить запись",
    "sign today's record" to "подписать сегодняшнюю запись",
    "signed" to "подписано",
    "signed and verified against your DID" to "подписано и проверено по вашему DID",
    "step {n} {title} complete" to "шаг {n} {title} выполнен",
    "step {n} {title} did not finish" to "шаг {n} {title} не завершён",
    "storage" to "хранилище",
    "support the builder" to "поддержать разработчика",
    "technocore.chat answered" to "technocore.chat ответил",
    "technocore.chat deletes anything nobody has written to for seven days. That includes the identity note at the address you save and share." to
        "technocore.chat удаляет всё, что никто не обновлял семь дней. Это касается и записи о вашей личности по адресу, который вы сохраняете и публикуете.",
    "technocore.chat refused the note" to "technocore.chat отклонил запись",
    "technocore.chat refused the signed write" to "technocore.chat отклонил подписанную запись",
    "text" to "текст",
    "the note changed between reads" to "заметка изменилась между чтениями",
    "the post" to "публикация",
    "the same wallet rebuilds this identity anywhere" to
        "тот же кошелёк воссоздаёт эту личность где угодно",
    "try again" to "попробовать снова",
    "unconfirmed" to "не подтверждено",
    "unsigned" to "без подписи",
    "vault {level}" to "хранилище {level}",
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
    "{token} is preselected and you can switch it." to
        "{token} выбран заранее, и его можно поменять.",
    "Try again. Nothing was sent anywhere." to
        "Попробуйте ещё раз. Никуда ничего не отправлялось.",
    "Try again. technocore.chat is a public service and it refuses writes when it is busy, which has nothing to do with this app, your phone or your key. Two or three attempts is normal. Nothing was published." to
        "Попробуйте ещё раз. technocore.chat это публичный сервис, и под нагрузкой он отказывает в записи — это не про приложение, не про ваш телефон и не про ваш ключ. Две-три попытки это нормально. Ничего не опубликовано.",
    "Try again. technocore.chat is a public service and it refuses writes when it is busy, which has nothing to do with this app, your phone or your key. Two or three attempts is normal. Nothing was posted." to
        "Попробуйте ещё раз. technocore.chat это публичный сервис, и под нагрузкой он отказывает в записи — это не про приложение, не про ваш телефон и не про ваш ключ. Две-три попытки это нормально. Ничего не отправлено.",
    "Could not reach technocore.chat. Check your connection and try again; nothing was lost." to
        "Не удалось связаться с technocore.chat. Проверьте соединение и попробуйте ещё раз, ничего не потеряно.",
    "The service took your record but has not shown it back yet. Press re-check in a moment; nothing needs signing again." to
        "Сервис принял вашу запись, но пока не показывает её обратно. Через минуту нажмите «перепроверить»; подписывать заново ничего не нужно.",
    "technocore.chat refused the record. It refuses writes when it is busy - try again in a moment." to
        "technocore.chat отклонил запись. Под нагрузкой он отказывает — попробуйте ещё раз через минуту.",
    "technocore.chat did not take the change. It refuses writes when it is busy - press publish again in a moment. Your links are saved on this phone either way." to
        "technocore.chat не принял изменение. Под нагрузкой он отказывает — через минуту нажмите «опубликовать» ещё раз. Ваши ссылки в любом случае сохранены на телефоне.",
    "Not finished yet. Your Passport is not live until all five are green, and there is nothing complete for anyone to verify. Keep going." to
        "Ещё не готово. Ваш Passport не действует, пока все пять не станут зелёными, и проверить пока нечего. Продолжайте.",
    "A message signed by your Passport, posted to a quiet room and then read back to prove it landed. Same service as step 03, same rule: if it refuses, press again. That is the service being busy, not a problem with your key." to
        "Сообщение, подписанное вашим Passport, отправляется в тихую комнату и потом перечитывается оттуда — это и есть доказательство, что оно дошло. Сервис тот же, что на шаге 03, и правило то же: отказал — нажмите ещё раз. Это сервис занят, а не что-то не так с вашим ключом.",
    "Deleted after seven days with nothing written to it. Publish it now and it goes back to the same address." to
        "Удаляется через семь дней, если в неё ничего не писали. Опубликуйте сейчас, и она вернётся по тому же адресу.",
    "Identity note at risk" to
        "Заметка личности под угрозой",
    "In Settings, delete the Passport from this phone, then create it again from your wallet." to
        "Зайдите в настройки, удалите Passport с этого телефона и заведите его заново из кошелька.",
    "It is deleted after seven days with nothing written to it. Opening this app writes it." to
        "Она удаляется через семь дней, если в неё ничего не писали. Само открытие приложения в неё пишет.",
    "Maybe. The service accepted it, and this app could not read it back to be sure." to
        "Возможно. Сервис принял это, но приложение пока не смогло перечитать и убедиться.",
    "Seven days without opening the app. Open it now and the note goes back up." to
        "Семь дней приложение не открывали. Откройте сейчас, и заметка вернётся.",
    "That was the last of the five. Your Passport is live. One thing left, and it is the part FLOP actually asked for: tell people what you did. The app writes the post for you at the bottom of this screen." to
        "Это был последний из пяти. Ваш Passport действует. Осталось одно, и это как раз то, о чём FLOP и просил: расскажите людям, что вы сделали. Пост приложение напишет за вас, внизу этого экрана.",
    "The link you paste goes into your identity note, at an address derived from your own key. Rooms are cleared within a day. The note stays as long as you keep opening the app." to
        "Ссылка, которую вы вставите, ляжет в вашу заметку личности, по адресу, вычисленному из вашего собственного ключа. Комнаты чистятся в течение суток. Заметка живёт, пока вы открываете приложение.",
    "This app is free and there is nothing in it to buy. If it has been useful, a thank you can go to kosa.skr." to
        "Приложение бесплатное, и покупать в нём нечего. Если оно оказалось полезным, спасибо можно отправить на kosa.skr.",
    "checking" to
        "проверяю",
    "open notification settings" to
        "открыть настройки уведомлений",
    "send a tip to kosa.skr" to
        "отправить чаевые на kosa.skr",
    "show my private key" to
        "показать закрытый ключ",
    "step {n} {title} not confirmed yet" to
        "шаг {n} {title} пока не подтверждён",
    "technocore.chat deletes anything with no write for seven days. Opening this app rewrites your note, and so does signing a record. Either one starts the seven days again." to
        "technocore.chat удаляет всё, во что семь дней никто не писал. Открытие приложения переписывает вашу заметку, и подпись записи тоже. Любое из двух запускает семь дней заново.",
    "This phone has no screen lock set up. Add a PIN or a fingerprint first." to
        "На этом телефоне не настроена блокировка экрана. Сначала поставьте PIN или отпечаток.",
    "The server accepted the write but the message is not in the room yet. Do not resend: read the room again first." to
        "Сервер принял запись, но сообщения в комнате пока нет. Не отправляйте снова: сначала перечитайте комнату.",
    "The stored text differs from the text we signed" to
        "Сохранённый текст не совпадает с тем, что мы подписали",
    "The stored record did not verify against this key" to
        "Сохранённая запись не проходит проверку этим ключом",
)
