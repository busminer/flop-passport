package dev.alexkosa.floppassport.i18n

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import java.util.Locale

/**
 * Translation, with the English sentence as its own key.
 *
 * Borrowed from SKR Eyes, where it has already earned its keep. There is no table of
 * `home.title` style names to keep in step with the screens, so a string nobody has
 * translated yet renders in English instead of showing a person its own identifier. The
 * cost is that editing an English sentence orphans its translation, which is visible in
 * review rather than at runtime.
 *
 * Only languages with a real table are offered. A picker listing languages that all render
 * English is worse than a short honest list: it tells someone their language is supported
 * and then proves otherwise on the next screen. Every entry here has a full table.
 */
enum class Lang(val code: String, val label: String) {
    /** Each language named the way its own speakers write it: people scan for their script. */
    EN("en", "English"),
    RU("ru", "Русский"),
    ZH("zh", "中文"),
    ES("es", "Español"),
    PT("pt", "Português"),
    DE("de", "Deutsch"),
    TR("tr", "Türkçe"),
    VI("vi", "Tiếng Việt"),
    ID("id", "Indonesia"),
    KO("ko", "한국어"),
    JA("ja", "日本語"),
    ;

    companion object {
        fun fromCode(code: String?): Lang? = entries.firstOrNull { it.code == code }

        /** What the phone is set to, matched on the language part alone. */
        fun fromSystem(): Lang = fromCode(Locale.getDefault().language) ?: EN
    }
}

private val TABLES: Map<Lang, Map<String, String>> = mapOf(
    Lang.EN to emptyMap(),
    Lang.RU to RU_STRINGS,
    Lang.ZH to ZH_STRINGS,
    Lang.ES to ES_STRINGS,
    Lang.PT to PT_STRINGS,
    Lang.DE to DE_STRINGS,
    Lang.TR to TR_STRINGS,
    Lang.VI to VI_STRINGS,
    Lang.ID to ID_STRINGS,
    Lang.KO to KO_STRINGS,
    Lang.JA to JA_STRINGS,
)

class Translator(val lang: Lang) {
    private val table = TABLES[lang].orEmpty()

    /** The language's own casing rules, for labels drawn in capitals. */
    val locale: Locale = if (lang == Lang.EN) Locale.ROOT else Locale.forLanguageTag(lang.code)

    /** Translate, falling back to the English sentence that was passed in. */
    operator fun invoke(english: String): String = table[english] ?: english
}

val LocalTranslator = compositionLocalOf { Translator(Lang.EN) }

/**
 * Translate a string at the moment it is drawn.
 *
 * Deliberately the only entry point the screens use. Translating at display rather than
 * where a sentence is written means the ViewModel stays plain English - it has no business
 * knowing about languages - and the rule stays small enough to hold in your head: if it is
 * rendered, it went through here. A string with no entry in the table comes back exactly as
 * it went in, so data like a DID or a hash passes through untouched.
 */
@Composable
fun t(english: String): String = LocalTranslator.current(english)

/**
 * Translate and capitalise for a label, by the language's own rules.
 *
 * `uppercase()` alone follows the invariant locale, which turns Turkish "için" into "IÇIN"
 * with a dotless I where the language writes "İÇİN". Every label, badge and tab in the app
 * is drawn in capitals, so a Turkish reader met the mistake on every screen.
 */
@Composable
fun tu(english: String): String {
    val translator = LocalTranslator.current
    return translator(english).uppercase(translator.locale)
}

/**
 * Translate a sentence that has a name or a token in it.
 *
 * The placeholder is written into the English key as `{name}` and filled in after the
 * lookup. Pasting the value in first is what went wrong before: the key at runtime read
 * "send a tip to alexkosa.skr", which is in no table, so the whole tip card stayed English
 * in every language while every other string around it translated.
 */
@Composable
fun t(english: String, vararg values: Pair<String, String>): String {
    var out = LocalTranslator.current(english)
    for ((name, value) in values) out = out.replace("{$name}", value)
    return out
}

/**
 * Where the choice is kept.
 *
 * Deliberately separate from the vault: a language preference is not a secret, and putting
 * it next to key material would mean unlocking the vault to read it.
 */
class LanguageStore(context: Context) {
    private val prefs = context.getSharedPreferences("flop_passport_prefs", Context.MODE_PRIVATE)

    /** Null means "follow the phone", which is the default and stays the default. */
    var chosen: Lang?
        get() = Lang.fromCode(prefs.getString(KEY, null))
        set(value) = prefs.edit().apply {
            if (value == null) remove(KEY) else putString(KEY, value.code)
        }.apply()

    val effective: Lang get() = chosen ?: Lang.fromSystem()

    private companion object {
        const val KEY = "lang"
    }
}
