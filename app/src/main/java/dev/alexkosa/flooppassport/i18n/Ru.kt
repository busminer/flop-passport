package dev.alexkosa.flooppassport.i18n

/**
 * Russian.
 *
 * The key is the English sentence exactly as it appears in the screen, so a change there
 * orphans the entry here rather than silently drifting. Anything missing renders English.
 *
 * Technical terms stay in English on purpose: `did:key`, StrongBox, Seed Vault, Technocore
 * and Solana are what a person will see everywhere else, and translating them would make
 * this app the only place they are called something different.
 */
internal val RU_STRINGS: Map<String, String> = mapOf(
    // --- steps -------------------------------------------------------------------
    "Create" to "Создание",
    "Protect" to "Защита",
    "Publish" to "Публикация",
    "Check in" to "Отметка",
    "Ready" to "Готово",

    // --- passport screen ---------------------------------------------------------
    "passport for seeker" to "паспорт для seeker",
    "your identity" to "ваша личность",
    "Create your Passport" to "Создайте паспорт",
    "Your wallet signs one statement. It is not a transaction and moves no funds. " +
        "The same wallet rebuilds the same Passport on any device." to
        "Кошелёк подпишет одну фразу. Это не транзакция и средства не двигаются. " +
        "Тот же кошелёк восстановит тот же паспорт на любом устройстве.",
    "create passport" to "создать паспорт",
    "Protect it" to "Защитите его",
    "The key is sealed in this phone's secure storage, then read back and checked " +
        "against your identity." to
        "Ключ запирается в защищённом хранилище телефона, затем читается обратно и " +
        "сверяется с вашей личностью.",
    "protect passport" to "защитить паспорт",
    "Publish your identity" to "Опубликуйте личность",
    "A permanent note at an address derived from your key, so anyone can find and " +
        "verify you later." to
        "Постоянная заметка по адресу, который вычисляется из вашего ключа — вас " +
        "смогут найти и проверить когда угодно.",
    "publish identity" to "опубликовать личность",
    "Make your first signed check-in" to "Сделайте первую подписанную отметку",
    "A message signed by your Passport, posted to a quiet room and then read back to " +
        "prove it landed." to
        "Сообщение, подписанное вашим паспортом. Уходит в тихую комнату, потом " +
        "читается обратно как доказательство.",
    "sign and check in" to "подписать и отметиться",
    "Your Passport is live." to "Ваш паспорт живой.",
    "save my key" to "сохранить ключ",
    "delete passport from this phone" to "удалить паспорт с телефона",

    // --- step ladder -------------------------------------------------------------
    "verified" to "проверено",
    "working" to "идёт",
    "failed" to "ошибка",
    "unconfirmed" to "не подтверждено",
    "what to do" to "что делать",
    "did anything go public?" to "что-то стало публичным?",
    "detail" to "подробности",

    // --- tabs --------------------------------------------------------------------
    "Passport" to "Паспорт",
    "Activity" to "Активность",
    "Settings" to "Настройки",

    // --- activity ----------------------------------------------------------------
    "activity" to "активность",
    "What is still provable" to "Что ещё можно доказать",
    "Read from technocore.chat just now, not from this phone. Rooms are trimmed as " +
        "they grow, so this is what anyone would find today." to
        "Прочитано с technocore.chat прямо сейчас, а не с телефона. Комнаты " +
        "подрезаются по мере роста, так что это ровно то, что найдёт любой человек.",
    "day streak" to "дней подряд",
    "live records" to "живых записей",
    "active days" to "дней активности",
    "identity note" to "заметка личности",
    "live" to "живая",
    "not found" to "не найдена",
    "You have already left a record today." to "Сегодня запись уже оставлена.",
    "Nothing signed today yet." to "Сегодня ещё ничего не подписано.",
    "sign today's record" to "подписать запись за сегодня",
    "re-check with the server" to "перепроверить на сервере",
    "checking..." to "проверяю...",
    "records the server still holds" to "записи, которые сервер ещё хранит",

    // --- settings ----------------------------------------------------------------
    "settings" to "настройки",
    "Language" to "Язык",
    "Follow the phone" to "Как в телефоне",
    "About" to "О приложении",
    "support the builder" to "поддержать разработчика",
    "danger zone" to "опасная зона",

    // --- backup ------------------------------------------------------------------
    "your private key" to "ваш приватный ключ",
    "Anyone with this can be you" to "Любой, у кого он есть, сможет быть вами",
    "save to a file" to "сохранить в файл",
    "copy key" to "скопировать ключ",
    "close" to "закрыть",

    // --- support -----------------------------------------------------------------
    "You're all set" to "Всё готово",
    "no thanks, continue" to "спасибо, не сейчас",
    "continue" to "продолжить",
    "done" to "готово",
    "ok" to "понятно",
)
