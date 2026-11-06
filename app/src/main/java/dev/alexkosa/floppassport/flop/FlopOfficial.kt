package dev.alexkosa.floppassport.flop

import org.json.JSONObject
import java.net.URI

/**
 * What is FLOP and what is not, from FLOP's own official-links page.
 *
 * Source: docs.flop.network, "Official links & verification", owner FLOP Labs, updated
 * 2026-10-23. It says there is no token, no mint, no claim, no presale and no airdrop live,
 * that there is no official Discord, Telegram, Reddit or Medium, and lists the only
 * accounts and domains that are theirs. Copied into the app so the check works offline and
 * cannot be steered by whatever a page on the network says about itself.
 */
object FlopOfficial {

    data class Source(val name: String, val url: String, val what: String)

    val SOURCES = listOf(
        Source("X @flop_labs", "https://x.com/flop_labs", "The main channel. Airdrop eligibility is announced here."),
        Source("flop.finance", "https://flop.finance", "Website: intro, whitepaper, testnet and airdrop pages."),
        Source("docs.flop.network", "https://docs.flop.network", "Operator and developer docs."),
        Source("ask.flop.finance", "https://ask.flop.finance", "FLOP's own docs chatbot."),
        Source("GitHub flop-labs", "https://github.com/flop-labs", "Code, yellow paper, bug reports."),
        Source("YouTube @flop_labs", "https://www.youtube.com/@flop_labs", "Videos."),
        Source("Devnet explorer", "https://explorer.devnet.flop.network", "Blocks, accounts, the compute market."),
    )

    private val HOSTS = setOf(
        "flop.finance", "ask.flop.finance", "docs.flop.network", "flop.network",
        "api.flop.network", "mcp.flop.network", "faucet.flop.network", "rpc.devnet.flop.network",
        "explorer.devnet.flop.network",
    )

    /** Accounts on shared platforms, by the path FLOP's page gives. */
    private val ACCOUNTS = mapOf(
        "x.com" to "flop_labs",
        "twitter.com" to "flop_labs",
        "youtube.com" to "@flop_labs",
        "tiktok.com" to "@flop_labs",
        "github.com" to "flop-labs",
    )

    private val NEVER = listOf("discord", "t.me", "telegram", "reddit", "medium.com")

    private val SCAM_WORDS = listOf("presale", "pre-sale", "claim", "mint", "airdrop is live", "buy flop", "contract address")

    enum class Verdict { Official, NotOfficial, NoTokenYet, Unknown }

    /**
     * [reason] is an English sentence with `{host}` and `{account}` holes, filled after the
     * sentence is translated, so the verdict reads in the person's own language.
     */
    data class Check(val verdict: Verdict, val reason: String, val host: String = "", val account: String = "")

    /**
     * Whether a link, handle or address is FLOP's.
     *
     * Exact hosts only: `flop.finance.example` and `flop-finance.com` are the shapes an
     * impersonator registers, and a contains-check would wave both through.
     */
    fun check(input: String): Check {
        val raw = input.trim()
        if (raw.isEmpty()) return Check(Verdict.Unknown, "")
        val lower = raw.lowercase()

        // A base58 string of Solana length, or a 0x address: somebody is being shown a
        // contract. FLOP says no contract exists until mainnet.
        if (dev.alexkosa.floppassport.crypto.Ss58.isValid(raw)) {
            return Check(Verdict.Unknown, "This is an account on FLOP Network. An address alone says nothing about who holds it.")
        }
        if (Regex("^(0x[0-9a-fA-F]{40}|[1-9A-HJ-NP-Za-km-z]{32,44})$").matches(raw)) {
            return Check(Verdict.NoTokenYet, "There is no FLOP token yet, so there is no FLOP contract address. Anything offered as one is not FLOP.")
        }
        if (SCAM_WORDS.any { lower.contains(it) }) {
            return Check(Verdict.NoTokenYet, "FLOP says there is no token, mint, claim, presale or live airdrop yet. Anything offering one is not FLOP.")
        }
        if (raw.startsWith("@")) {
            return if (lower == "@flop_labs") {
                Check(Verdict.Official, "@flop_labs is FLOP's account on X, YouTube and TikTok.")
            } else {
                Check(Verdict.NotOfficial, "FLOP's only handle is @flop_labs. Any other account using the name is not theirs.")
            }
        }
        if (lower.endsWith("@flop.finance")) {
            return if (lower == "security@flop.finance" || lower == "info@flop.finance") {
                Check(Verdict.Official, "A flop.finance address. FLOP lists security@flop.finance as its one public contact.")
            } else {
                Check(Verdict.Unknown, "A flop.finance address, but not one FLOP lists publicly. Ask through x.com/flop_labs.")
            }
        }

        // Normalised before it is judged: "x.com/flop_labs/../someone" is someone's page
        // once a browser has read it, and that is the page the link would open.
        val uri = runCatching { URI(if (lower.contains("://")) raw else "https://$raw").normalize() }.getOrNull()
        val host = uri?.host?.lowercase()?.removePrefix("www.")
            ?: return Check(Verdict.Unknown, "Paste a full link, a handle like @name, or an address.")
        // FLOP serves everything over https. Anything else can be changed on the way, or
        // be opened by whichever app claims the scheme rather than by a browser.
        if (uri.scheme?.lowercase() != "https" || uri.rawUserInfo != null || uri.rawPath.orEmpty().contains("/..")) {
            return Check(Verdict.NotOfficial, "Only https links can be FLOP's. Type FLOP's address yourself instead of following this one.")
        }
        if (NEVER.any { host.contains(it) }) {
            return Check(Verdict.NotOfficial, "FLOP has no official Discord, Telegram, Reddit or Medium. An invitation to one never comes from FLOP.")
        }
        if (host in HOSTS) return Check(Verdict.Official, "{host} is on FLOP's official list.", host)
        ACCOUNTS[host]?.let { account ->
            val first = uri.path.trim('/').substringBefore('/').lowercase()
            return if (first == account.lowercase()) {
                Check(Verdict.Official, "This is FLOP's own account on {host}.", host)
            } else {
                Check(Verdict.NotOfficial, "This is on {host}, but not FLOP's account there. FLOP's is {account}.", host, account)
            }
        }
        if (host.contains("flop")) {
            return Check(Verdict.NotOfficial, "{host} uses the FLOP name but is not on FLOP's official list. Treat it as an impersonation.", host)
        }
        return Check(Verdict.Unknown, "{host} is not FLOP. That does not make it bad, only not FLOP.", host)
    }

    // ------------------------------------------------------------------ news

    data class News(val date: String, val title: String, val url: String)

    /**
     * Short news lines, each one pointing at an official source.
     *
     * Served from the app's own site rather than scraped from X, which an app cannot read
     * without a paid key. The feed only ever links to the sources above, and a line whose link
     * is not official is dropped here, so the feed cannot be used to send people elsewhere.
     */
    const val NEWS_URL = "https://flop.alexkosa.dev/news.json"

    fun parseNews(body: String, lang: String = "en"): List<News> = runCatching {
        val a = JSONObject(body).getJSONArray("items")
        (0 until a.length()).mapNotNull { i ->
            val o = a.getJSONObject(i)
            // A title is one English string, or language codes to strings, like the status.
            val title = when (val v = o.opt("title")) {
                is JSONObject -> v.optString(lang).ifBlank { v.optString("en") }
                else -> o.optString("title")
            }
            val n = News(o.optString("date"), title.take(120), o.optString("url"))
            n.takeIf { it.title.isNotBlank() && check(it.url).verdict == Verdict.Official }
        }.take(20)
    }.getOrDefault(emptyList())

    suspend fun news(lang: String): List<News> {
        val r = FlopHttp.request(NEWS_URL)
        return if (r.ok) parseNews(r.body, lang) else emptyList()
    }
}
