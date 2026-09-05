package dev.alexkosa.floppassport.util

import android.net.Uri

/**
 * Solana Pay request URIs.
 *
 * Deliberately not transactions. Twelve apps on a Seeker register the `solana:` scheme, so
 * a link opens the user's own wallet on its own send screen with the recipient filled in,
 * and they confirm there. The app never builds a transfer, never asks for a signature and
 * never needs an RPC endpoint — which also means there is no new way for it to be wrong
 * about somebody's money.
 */
object Qr {

    fun solanaPay(
        recipient: String,
        label: String? = null,
        message: String? = null,
        /**
         * An SPL mint preselects that token in the wallet's send screen. A suggestion, not
         * a constraint: the sender can switch to anything they hold, and no amount is set,
         * so they choose that too.
         */
        splToken: String? = null,
    ): String = buildString {
        append("solana:").append(recipient)
        val params = buildList {
            splToken?.let { add("spl-token=" + Uri.encode(it)) }
            label?.let { add("label=" + Uri.encode(it)) }
            message?.let { add("message=" + Uri.encode(it)) }
        }
        if (params.isNotEmpty()) append("?").append(params.joinToString("&"))
    }
}
