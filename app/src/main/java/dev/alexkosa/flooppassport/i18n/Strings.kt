package dev.alexkosa.flooppassport.i18n

import android.content.Context
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
 * Only languages with a real table are offered. A picker listing ten languages that all
 * render English is worse than a short honest list: it tells someone their language is
 * supported and then proves otherwise on the next screen.
 */
enum class Lang(val code: String, val label: String) {
    /** Each language named the way its own speakers write it: people scan for their script. */
    EN("en", "English"),
    RU("ru", "Русский"),
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
)

class Translator(val lang: Lang) {
    private val table = TABLES[lang].orEmpty()

    /** Translate, falling back to the English sentence that was passed in. */
    operator fun invoke(english: String): String = table[english] ?: english
}

val LocalTranslator = compositionLocalOf { Translator(Lang.EN) }

/**
 * Where the choice is kept.
 *
 * Deliberately separate from the vault: a language preference is not a secret, and putting
 * it next to key material would mean unlocking the vault to read it.
 */
class LanguageStore(context: Context) {
    private val prefs = context.getSharedPreferences("floop_passport_prefs", Context.MODE_PRIVATE)

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
