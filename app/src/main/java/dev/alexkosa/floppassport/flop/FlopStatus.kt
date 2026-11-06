package dev.alexkosa.floppassport.flop

import org.json.JSONObject

/**
 * What is happening on FLOP right now, said by the people who make this app.
 *
 * FLOP changes faster than an app can be reviewed: the devnet opened on 3 November 2026,
 * the faucet broke the same morning, and the testnet date moved twice before that. So the
 * app carries a dated status written into the build, and replaces it with a fresher one from
 * the app's own site when it can reach it. Either way the screen shows the date, so nobody
 * mistakes last week's sentence for today's.
 *
 * The remote file is plain text with a level, so a compromised site could at worst say
 * something wrong. The one exception is [Status.referral], Alex's referral link from FLOP,
 * which has to go live the hour FLOP issues it and cannot wait for a store review. It is only
 * ever a URL: the words on the button are in the app, and [safeReferral] refuses anything
 * that is not https on FLOP's own domains, so the worst the site can do there is point at a
 * different page of FLOP's.
 */
object FlopStatus {

    const val URL = "https://flop.alexkosa.dev/status.json"

    enum class Level { Good, Info, Warning, Problem }

    /** [topic] lets the app correct a line by what it has seen: "faucet", "model", "network", "testnet". */
    data class Line(val title: String, val text: String, val level: Level, val topic: String = "")

    data class Status(val updated: String, val lines: List<Line>, val fromSite: Boolean, val referral: String? = null)

    /** Written 3 November 2026 from FLOP's docs, the faucet's own replies and FLOP's issue tracker; the faucet came back that afternoon. */
    val BUILT_IN = Status(
        updated = "2026-11-03",
        fromSite = false,
        lines = listOf(
            Line(
                "Devnet is open",
                "Since 3 November FLOP's practice network is open to everyone. Devnet FLOP has no value, earns nothing, and the network may be reset at any time.",
                Level.Info,
            ),
            Line(
                topic = "faucet",
                title = "The faucet works",
                text = "FLOP's faucet gives each address 25 FLOP once every 24 hours. It can be slow: an answer may take a minute or two. The app waits for it and checks your balance.",
                level = Level.Good,
            ),
            Line(
                "The model: one trial per account",
                "On devnet FLOP gives each account one allowance to spend on the model within 24 hours, and needs at least 1 FLOP on the account to start it. The Ask tab shows how much is left. When it is over, it stays over until testnet.",
                Level.Warning,
            ),
            Line(
                "Testnet: no date yet",
                "FLOP has not announced the testnet date. When it opens, the testnet FLOP you spend on the model becomes your claim on mainnet FLOP. Holding FLOP or making more accounts earns nothing.",
                Level.Info,
            ),
        ),
    )

    private val LINK = Regex("""https://([a-z0-9.-]+)(/[A-Za-z0-9._~!$&'()*+,;=:@%/-]*)?(\?[A-Za-z0-9._~!$&'()*+,;=:@%/?-]*)?""")

    /** The link if it is plainly FLOP's, otherwise null. Empty means there is no link yet. */
    fun safeReferral(raw: String?): String? {
        val link = raw?.trim().orEmpty()
        if (link.isEmpty() || link.length > 300) return null
        val host = LINK.matchEntire(link)?.groupValues?.get(1) ?: return null
        val own = host == "flop.finance" || host == "flop.network" ||
            host.endsWith(".flop.finance") || host.endsWith(".flop.network")
        return link.takeIf { own }
    }

    /** The host, to print beside the button: people should see where it goes. */
    fun hostOf(link: String): String = LINK.matchEntire(link)?.groupValues?.get(1).orEmpty()

    /**
     * A field is either one English string, or an object of language codes to strings, so
     * the site can speak every language the app does. A missing language falls back to
     * English, which the app then translates if the sentence happens to be in its tables.
     */
    private fun pick(o: JSONObject, field: String, lang: String): String {
        val v = o.opt(field)
        return when (v) {
            is JSONObject -> v.optString(lang).ifBlank { v.optString("en") }
            is String -> v
            else -> ""
        }
    }

    fun parse(body: String, lang: String = "en"): Status? = runCatching {
        val j = JSONObject(body)
        val a = j.getJSONArray("lines")
        val lines = (0 until a.length()).mapNotNull { i ->
            val o = a.getJSONObject(i)
            val title = pick(o, "title", lang).take(80)
            val text = pick(o, "text", lang).take(400)
            if (title.isBlank() || text.isBlank()) return@mapNotNull null
            val level = runCatching { Level.valueOf(o.optString("level", "Info").replaceFirstChar { it.uppercase() }) }
                .getOrDefault(Level.Info)
            Line(title, text, level, o.optString("topic"))
        }.take(8)
        val updated = j.optString("updated")
        if (lines.isEmpty() || !Regex("\\d{4}-\\d{2}-\\d{2}").matches(updated)) null
        // An older file than the build must not overwrite what the build knows.
        else if (updated < BUILT_IN.updated) null
        else Status(updated, lines, fromSite = true, referral = safeReferral(j.optString("referral")))
    }.getOrNull()

    suspend fun fetch(lang: String): Status? {
        val r = FlopHttp.request(URL, timeoutMs = 8_000)
        return if (r.ok) parse(r.body, lang) else null
    }
}
