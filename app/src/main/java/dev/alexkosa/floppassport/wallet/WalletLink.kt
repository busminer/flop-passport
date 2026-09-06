package dev.alexkosa.floppassport.wallet

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import com.solana.mobilewalletadapter.clientlib.protocol.MobileWalletAdapterClient
import com.solana.mobilewalletadapter.clientlib.scenario.LocalAssociationIntentCreator
import com.solana.mobilewalletadapter.clientlib.scenario.LocalAssociationScenario
import com.solana.mobilewalletadapter.common.ProtocolContract
import dev.alexkosa.floppassport.crypto.Base58
import dev.alexkosa.floppassport.crypto.DidKey
import dev.alexkosa.floppassport.crypto.Ed25519
import dev.alexkosa.floppassport.crypto.PassportDerivation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.concurrent.TimeUnit

/**
 * The one place the Solana wallet is touched.
 *
 * Mobile Wallet Adapter only — never the Seed Vault SDK directly. A dApp that reaches for
 * Seed Vault is claiming a role it does not have; MWA is the supported surface, and it is
 * what lets any wallet on the device serve the request rather than only the stock one.
 *
 * What this asks the wallet for is deliberately the smallest thing that exists: a detached
 * signature over a human-readable statement. No transaction, no lamports, no token
 * approval, no account creation. If a wallet ever shows the user something other than that
 * text, the wallet is misbehaving and the user can see it.
 */
object WalletLink {

    /**
     * Shown on the wallet's approval screen as who is asking.
     *
     * A real address that serves a real page, not a plausible-looking one: this app tells
     * people to read what a wallet asks them to sign, and the first line of that screen
     * naming a domain nobody can open would be the app failing its own instruction.
     */
    val IDENTITY_URI: Uri = Uri.parse("https://flop.alexkosa.dev")
    // Relative to IDENTITY_URI, and it has to exist: this used to point at favicon.ico,
    // which the site does not serve, so every wallet honouring the icon showed a blank
    // square at the exact moment the app tells the user to read what they are signing.
    val ICON_URI: Uri = Uri.parse("assets/flop-chip-favicon.svg")
    const val IDENTITY_NAME = "FLOP Passport"
    /**
     * The four-argument authorize takes a CLUSTER, whose only legal values are
     * mainnet-beta, testnet and devnet. The CAIP-style "solana:mainnet" belongs to the
     * chain parameter of the longer overload; passing it here makes the wallet raise
     * ERROR_CLUSTER_NOT_SUPPORTED, and because that arrives as a dropped association
     * rather than an exception, the visible symptom is only a timeout.
     */
    val CLUSTER: String = ProtocolContract.CLUSTER_MAINNET_BETA

    private const val ASSOCIATION_TIMEOUT_MS = 30_000
    private const val CONNECT_TIMEOUT_S = 25L
    private const val CALL_TIMEOUT_S = 120L

    fun isWalletAvailable(pm: PackageManager): Boolean =
        LocalAssociationIntentCreator.isWalletEndpointAvailable(pm)

    /**
     * A live association with a wallet app. Created on the caller's side because launching
     * the intent needs an Activity result launcher, which only the UI layer owns.
     */
    class Session internal constructor(
        private val scenario: LocalAssociationScenario,
        val intent: Intent,
    ) {
        private var client: MobileWalletAdapterClient? = null

        /** Call after the wallet activity has been launched. Blocks until it connects. */
        suspend fun connect(): MobileWalletAdapterClient = withContext(Dispatchers.IO) {
            scenario.start().get(CONNECT_TIMEOUT_S, TimeUnit.SECONDS).also { client = it }
        }

        suspend fun close() = withContext(Dispatchers.IO) {
            runCatching { scenario.close().get(5, TimeUnit.SECONDS) }
            Unit
        }
    }

    fun newSession(): Session {
        val scenario = LocalAssociationScenario(ASSOCIATION_TIMEOUT_MS)
        val intent = LocalAssociationIntentCreator.createAssociationIntent(
            null, scenario.port, scenario.session,
        )
        return Session(scenario, intent)
    }

    /** What came back from the wallet, plus everything derived from it. */
    data class Derived(
        val walletAddress: String,
        val walletPublicKey: ByteArray,
        val walletSignature: ByteArray,
        val passportSeed: ByteArray,
        val did: String,
    ) {
        /**
         * True when the wallet signed the exact bytes we handed it, with no prefix of its
         * own. Informational, not a gate: derivation works either way because the
         * signature is deterministic regardless. But a wallet that prefixes produces a
         * different Passport than one that does not, and that Passport comes back only
         * through the same wallet app - which the step-01 evidence says in so many words.
         */
        val walletSignedRawBytes: Boolean
            get() = Ed25519.verify(
                walletPublicKey,
                PassportDerivation.statement(walletAddress).toByteArray(Charsets.UTF_8),
                walletSignature,
            )
    }

    /**
     * Authorize, ask for one detached signature over the derivation statement, and turn it
     * into the Passport identity.
     *
     * `signMessagesDetached` rather than `signMessages`: the detached call returns the raw
     * 64-byte signature on its own, while the other returns the payload with the signature
     * appended, which we would only have to take apart again.
     */
    suspend fun authorizeAndDerive(session: Session): Derived = withContext(Dispatchers.IO) {
        val client = session.connect()

        val auth = client
            .authorize(IDENTITY_URI, ICON_URI, IDENTITY_NAME, CLUSTER)
            .get(CALL_TIMEOUT_S, TimeUnit.SECONDS)

        val walletPublicKey = auth.publicKey
        require(walletPublicKey.size == 32) {
            "A Solana account key is 32 bytes, got ${walletPublicKey.size}"
        }
        val address = Base58.encode(walletPublicKey)
        val statement = PassportDerivation.statement(address).toByteArray(Charsets.UTF_8)

        val signed = client
            .signMessagesDetached(arrayOf(statement), arrayOf(walletPublicKey))
            .get(CALL_TIMEOUT_S, TimeUnit.SECONDS)

        val first = signed.messages.firstOrNull()
            ?: error("The wallet returned no signed message")
        val signature = first.signatures.firstOrNull()
            ?: error("The wallet returned no signature")
        require(signature.size == 64) {
            "An Ed25519 signature is 64 bytes, got ${signature.size}"
        }
        // The statement names one account and asks that account to sign it. A wallet
        // holding several that answered with a different one would derive a Passport
        // bound to a statement about the wrong address, and the same account would not
        // rebuild it later. Wallets that omit the field are taken at their word.
        val signer = first.addresses.firstOrNull()
        require(signer == null || signer.contentEquals(walletPublicKey)) {
            "The wallet signed with a different account than the one it authorized"
        }

        val seed = PassportDerivation.seedFromWalletSignature(signature, address)
        val did = DidKey.fromPublicKey(Ed25519.publicKeyFromSeed(seed))

        Derived(
            walletAddress = address,
            walletPublicKey = walletPublicKey,
            walletSignature = signature,
            passportSeed = seed,
            did = did,
        )
    }
}
