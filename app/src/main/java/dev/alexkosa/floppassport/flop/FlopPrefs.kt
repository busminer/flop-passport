package dev.alexkosa.floppassport.flop

import android.content.Context
import androidx.core.content.edit
import org.json.JSONArray
import org.json.JSONObject

/**
 * What this phone remembers about its FLOP account.
 *
 * Nothing here is a secret worth the vault: the gateway key is a devnet credential that
 * spends at most 25 valueless FLOP and dies within a day, and the rest is history the
 * person can see on screen anyway. Kept apart from the Passport's own preferences so that
 * deleting a Passport can forget all of it in one call.
 */
class FlopPrefs(context: Context) {

    private val prefs = context.getSharedPreferences("flop_network", Context.MODE_PRIVATE)

    /**
     * An address the person already had, set in place of the Passport's own.
     *
     * For somebody who holds FLOP in another wallet and wants the faucet there. Null means
     * the Passport's address, which is the default and the only one the gateway can use,
     * because only the Passport key can sign the gateway's challenge.
     */
    var receiveAddress: String?
        get() = prefs.getString(K_RECEIVE, null)
        set(value) = prefs.edit { if (value == null) remove(K_RECEIVE) else putString(K_RECEIVE, value) }

    /** When the faucet last funded an address, keyed by the address it funded. */
    fun lastFunded(address: String): Long = prefs.getLong(K_FUNDED + address, 0L)

    fun recordFunded(address: String, at: Long, txHash: String?) = prefs.edit {
        putLong(K_FUNDED + address, at)
        putString(K_FUNDED_TX + address, txHash)
    }

    fun lastFundTx(address: String): String? = prefs.getString(K_FUNDED_TX + address, null)

    data class GatewayKey(val address: String, val key: String, val model: String, val expiresAt: Long)

    var gatewayKey: GatewayKey?
        get() {
            val raw = prefs.getString(K_GATEWAY, null) ?: return null
            return runCatching {
                val j = JSONObject(raw)
                GatewayKey(j.getString("address"), j.getString("key"), j.getString("model"), j.getLong("expiresAt"))
            }.getOrNull()
        }
        set(value) = prefs.edit {
            if (value == null) {
                remove(K_GATEWAY)
            } else {
                putString(
                    K_GATEWAY,
                    JSONObject()
                        .put("address", value.address).put("key", value.key)
                        .put("model", value.model).put("expiresAt", value.expiresAt)
                        .toString(),
                )
            }
        }

    /**
     * True once this account's one devnet allowance is known to be over.
     *
     * The gateway never renews an expired or exhausted devnet allowance, so after the first
     * day the honest screen says the trial is finished rather than offering a button that
     * can only fail.
     */
    fun gatewayClosed(address: String): Boolean = prefs.getBoolean(K_CLOSED + address, false)

    fun markGatewayClosed(address: String) = prefs.edit { putBoolean(K_CLOSED + address, true) }

    /** The Passport's numbers as last read from the public room. */
    data class Stats(val streak: Int, val best: Int, val signedDays: Int, val firstDay: String?)

    fun stats(did: String): Stats? = runCatching {
        val j = JSONObject(prefs.getString(K_STATS, null) ?: return null)
        if (j.getString("did") != did) return null
        Stats(j.getInt("streak"), j.getInt("best"), j.getInt("days"), j.optString("first").ifBlank { null })
    }.getOrNull()

    fun saveStats(did: String, s: Stats) = prefs.edit {
        putString(
            K_STATS,
            JSONObject().put("did", did).put("streak", s.streak).put("best", s.best)
                .put("days", s.signedDays).put("first", s.firstDay ?: "").toString(),
        )
    }

    var community: dev.alexkosa.floppassport.ui.ActivityState.Community?
        get() = runCatching {
            val j = JSONObject(prefs.getString(K_COMMUNITY, null) ?: return null)
            dev.alexkosa.floppassport.ui.ActivityState.Community(
                j.getInt("passports"), j.getInt("days"), j.getInt("today"), j.getLong("at"),
            )
        }.getOrNull()
        set(value) = prefs.edit {
            if (value == null) {
                remove(K_COMMUNITY)
            } else {
                putString(
                    K_COMMUNITY,
                    JSONObject().put("passports", value.passports).put("days", value.signedDays)
                        .put("today", value.signedToday).put("at", value.checkedAt).toString(),
                )
            }
        }

    data class Message(val role: String, val text: String, val costFlop: Double?, val at: Long)

    var chat: List<Message>
        get() = runCatching {
            val a = JSONArray(prefs.getString(K_CHAT, "[]"))
            (0 until a.length()).map { i ->
                val m = a.getJSONObject(i)
                Message(
                    m.getString("role"),
                    m.getString("text"),
                    if (m.has("cost")) m.getDouble("cost") else null,
                    m.optLong("at"),
                )
            }
        }.getOrDefault(emptyList())
        set(value) {
            val a = JSONArray()
            value.takeLast(MAX_CHAT).forEach { m ->
                val o = JSONObject().put("role", m.role).put("text", m.text).put("at", m.at)
                m.costFlop?.takeIf { it.isFinite() }?.let { o.put("cost", it) }
                a.put(o)
            }
            prefs.edit { putString(K_CHAT, a.toString()) }
        }

    /** The day the daily question was last asked, so the ritual asks once a day. */
    var lastAskedDay: String?
        get() = prefs.getString(K_ASKED, null)
        set(value) = prefs.edit { putString(K_ASKED, value) }

    var whatsNewSeen: Boolean
        get() = prefs.getBoolean(K_WHATS_NEW, false)
        set(value) = prefs.edit { putBoolean(K_WHATS_NEW, value) }

    /** Everything but whether the 2.0 notes were read: a new Passport is not a new app. */
    fun clear() {
        val seen = whatsNewSeen
        prefs.edit { clear() }
        whatsNewSeen = seen
    }

    private companion object {
        const val K_RECEIVE = "receive_address"
        const val K_FUNDED = "funded_at_"
        const val K_FUNDED_TX = "funded_tx_"
        const val K_GATEWAY = "gateway_key"
        const val K_CLOSED = "gateway_closed_"
        const val K_CHAT = "chat"
        private const val K_STATS = "passport_stats"
        private const val K_COMMUNITY = "community"
        const val K_ASKED = "asked_day"
        const val MAX_CHAT = 60
        const val K_WHATS_NEW = "whats_new_2_0"
    }
}
