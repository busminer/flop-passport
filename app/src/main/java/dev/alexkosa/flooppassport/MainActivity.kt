package dev.alexkosa.flooppassport

import android.content.Context
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import dev.alexkosa.flooppassport.crypto.DidKey
import dev.alexkosa.flooppassport.technocore.Technocore
import dev.alexkosa.flooppassport.ui.designsystem.FlopBadge
import dev.alexkosa.flooppassport.ui.designsystem.FlopButton
import dev.alexkosa.flooppassport.ui.designsystem.FlopButtonSecondary
import dev.alexkosa.flooppassport.ui.designsystem.FlopCard
import dev.alexkosa.flooppassport.ui.designsystem.FlopColors
import dev.alexkosa.flooppassport.ui.designsystem.FlopDot
import dev.alexkosa.flooppassport.ui.designsystem.FlopLabel
import dev.alexkosa.flooppassport.ui.designsystem.FlopMonoData
import dev.alexkosa.flooppassport.ui.designsystem.FlopShapes
import dev.alexkosa.flooppassport.ui.designsystem.FlopSpacing
import dev.alexkosa.flooppassport.ui.designsystem.FlopState
import dev.alexkosa.flooppassport.ui.designsystem.FlopType
import dev.alexkosa.flooppassport.vault.PassportVault
import dev.alexkosa.flooppassport.wallet.WalletLink
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * First installable slice: the launch scene, then the wallet handshake that creates the
 * Passport, then the identity on screen.
 *
 * Its job right now is to answer the one question no amount of desk work can settle -
 * whether a real wallet on a real Seeker returns a usable detached signature - so the
 * screen shows the raw facts of that handshake rather than hiding them.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent { PassportApp() }
    }
}

private enum class Phase { Launch, Passport }

@Composable
private fun PassportApp() {
    val context = LocalContext.current
    var phase by remember { mutableStateOf(Phase.Launch) }

    LaunchedEffect(Unit) {
        playLaunchCue(context)
        delay(3_200)
        phase = Phase.Passport
    }

    Box(Modifier.fillMaxSize().background(FlopColors.Base)) {
        when (phase) {
            Phase.Launch -> LaunchScene()
            Phase.Passport -> PassportScreen()
        }
    }
}

/**
 * The marks only ever fade in at full scale. FLOP's Logo and Usage Standards forbid
 * rotating, splitting or animating the lockup as anything but a whole, so the motion is
 * carried by everything around them.
 */
@Composable
private fun LaunchScene() {
    var started by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) { started = true }

    val lockup by animateFloatAsState(
        if (started) 1f else 0f, tween(700, delayMillis = 500), label = "lockup",
    )
    val seeker by animateFloatAsState(
        if (started) 1f else 0f, tween(900, delayMillis = 2100), label = "seeker",
    )
    val ready by animateFloatAsState(
        if (started) 1f else 0f, tween(450, delayMillis = 2700), label = "ready",
    )

    Column(
        Modifier.fillMaxSize().safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(R.drawable.flop_lockup_reverse),
            contentDescription = "FLOP",
            modifier = Modifier.width(236.dp).alpha(lockup),
        )
        Spacer(Modifier.height(FlopSpacing.sm))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.alpha(seeker),
        ) {
            FlopLabel("for")
            Spacer(Modifier.width(FlopSpacing.md))
            Image(
                painter = painterResource(R.drawable.seeker_wordmark),
                contentDescription = "Seeker",
                modifier = Modifier.width(124.dp),
            )
        }
        Spacer(Modifier.height(FlopSpacing.xl))
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.alpha(ready)) {
            FlopDot(FlopState.Verified)
            Spacer(Modifier.width(FlopSpacing.sm))
            FlopLabel("passport", FlopColors.Green)
        }
    }
}

@Composable
private fun PassportScreen() {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val vault = remember { PassportVault(context) }
    val technocore = remember { Technocore() }

    var did by remember { mutableStateOf(vault.did) }
    var wallet by remember { mutableStateOf(vault.walletAddress) }
    var status by remember { mutableStateOf("") }
    var busy by remember { mutableStateOf(false) }
    var rawSigned by remember { mutableStateOf<Boolean?>(null) }
    var noteState by remember { mutableStateOf(FlopState.Neutral) }
    var proofLine by remember { mutableStateOf<String?>(null) }

    // The wallet runs in its own activity; we only need to know it came back, because the
    // real result arrives over the association we opened before launching it.
    val walletLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.StartActivityForResult(),
    ) { }

    fun createPassport() {
        if (busy) return
        busy = true
        status = "Opening your wallet..."
        rawSigned = null
        scope.launch {
            val s = WalletLink.newSession()
            try {
                walletLauncher.launch(s.intent)
                val derived = WalletLink.authorizeAndDerive(s)
                vault.store(derived.passportSeed, derived.did, derived.walletAddress)
                derived.passportSeed.fill(0)
                did = derived.did
                wallet = derived.walletAddress
                rawSigned = derived.walletSignedRawBytes
                status = "Passport created. Vault security: " + vault.securityLevel
                confirmHaptic(context)
            } catch (t: Throwable) {
                status = "Wallet step failed: " + (t.message ?: t.javaClass.simpleName)
            } finally {
                s.close()
                busy = false
            }
        }
    }

    fun publishAndCheckIn() {
        val identity = did ?: return
        if (busy) return
        busy = true
        status = "Publishing identity..."
        scope.launch {
            try {
                val note = technocore.publishIdentityNote(
                    identity, "FLOOP Passport for Seeker | agent identity",
                )
                noteState = if (note is Technocore.Result.Verified) {
                    FlopState.Verified
                } else {
                    FlopState.Failure
                }

                status = "Signing first check-in..."
                val room = "lobby"
                val nonce = technocore.nextNonce(room, identity)
                val result = technocore.saySigned(
                    did = identity,
                    room = room,
                    text = "FLOOP Passport for Seeker. First signed check-in.",
                    nonce = nonce,
                    sign = { vault.sign(it) },
                )
                status = when (result) {
                    is Technocore.Result.Verified -> {
                        proofLine = "seq " + result.proof.seq + "  |  nonce " + result.proof.nonce
                        confirmHaptic(context)
                        "Verified. Read back from the server."
                    }
                    is Technocore.Result.Refused ->
                        "Refused (" + result.status + "): " + result.message.take(120)
                    is Technocore.Result.Unconfirmed ->
                        "Unconfirmed - do not resend: " + result.reason.take(120)
                }
            } catch (t: Throwable) {
                status = "Failed: " + (t.message ?: t.javaClass.simpleName)
            } finally {
                busy = false
            }
        }
    }

    Column(
        Modifier
            .fillMaxSize()
            .safeDrawingPadding()
            .verticalScroll(rememberScrollState())
            .padding(FlopSpacing.md),
    ) {
        Image(
            painter = painterResource(R.drawable.flop_lockup_reverse),
            contentDescription = "FLOP",
            modifier = Modifier.width(150.dp),
        )
        Spacer(Modifier.height(FlopSpacing.xs))
        FlopLabel("passport for seeker")
        Spacer(Modifier.height(FlopSpacing.lg))

        val identity = did
        if (identity == null) {
            Text("Create your Passport", style = FlopType.h2, color = FlopColors.IceWhite)
            Spacer(Modifier.height(FlopSpacing.sm))
            Text(
                "Your wallet signs one statement. It is not a transaction and moves no funds. " +
                    "The same wallet rebuilds the same Passport on any device.",
                style = FlopType.bodyMd,
                color = FlopColors.TextMuted,
            )
            Spacer(Modifier.height(FlopSpacing.lg))
            FlopButton("create passport", { createPassport() }, enabled = !busy)
        } else {
            FlopCard(accent = FlopColors.Cyan) {
                FlopLabel("identity")
                Spacer(Modifier.height(FlopSpacing.sm))
                FlopMonoData(identity)
                Spacer(Modifier.height(FlopSpacing.sm))
                FlopLabel("fingerprint  " + DidKey.fingerprint(identity))
            }
            Spacer(Modifier.height(FlopSpacing.sm))
            FlopCard {
                FlopLabel("wallet")
                Spacer(Modifier.height(FlopSpacing.xs))
                FlopMonoData(wallet ?: "-", FlopColors.TextMuted)
                Spacer(Modifier.height(FlopSpacing.sm))
                Row(horizontalArrangement = Arrangement.spacedBy(FlopSpacing.sm)) {
                    FlopBadge("vault " + vault.securityLevel, FlopState.Active)
                    rawSigned?.let {
                        FlopBadge(
                            if (it) "raw bytes" else "wallet prefix",
                            if (it) FlopState.Verified else FlopState.Neutral,
                        )
                    }
                }
            }
            Spacer(Modifier.height(FlopSpacing.sm))
            FlopCard {
                FlopLabel("technocore")
                Spacer(Modifier.height(FlopSpacing.sm))
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    FlopLabel("identity note")
                    FlopBadge(
                        when (noteState) {
                            FlopState.Verified -> "verified"
                            FlopState.Failure -> "failed"
                            else -> "not published"
                        },
                        noteState,
                    )
                }
                proofLine?.let {
                    Spacer(Modifier.height(FlopSpacing.sm))
                    FlopLabel("proof")
                    Spacer(Modifier.height(FlopSpacing.xs))
                    FlopMonoData(it, FlopColors.Green)
                }
            }
            Spacer(Modifier.height(FlopSpacing.lg))
            FlopButton("publish and check in", { publishAndCheckIn() }, enabled = !busy)
            Spacer(Modifier.height(FlopSpacing.sm))
            FlopButtonSecondary("delete test passport", {
                vault.delete()
                did = null
                wallet = null
                proofLine = null
                noteState = FlopState.Neutral
                status = "Deleted."
            })
        }

        if (status.isNotEmpty()) {
            Spacer(Modifier.height(FlopSpacing.md))
            Box(
                Modifier
                    .fillMaxWidth()
                    .background(FlopColors.Surface, FlopShapes.md)
                    .padding(FlopSpacing.md),
            ) {
                Text(status, style = FlopType.bodySm, color = FlopColors.TextMuted)
            }
        }
    }
}

/**
 * The cue is a launch moment, not a notification, so it goes out on the media stream and
 * inherits the silent switch and the media volume the user already set.
 */
private fun playLaunchCue(context: Context) {
    runCatching {
        MediaPlayer.create(
            context,
            R.raw.launch_cue,
            AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build(),
            0,
        )?.apply {
            setOnCompletionListener { it.release() }
            start()
        }
    }
}

/** One short tick, only at moments that actually settled something. */
private fun confirmHaptic(context: Context) {
    runCatching {
        val v = context.getSystemService(Vibrator::class.java) ?: return
        v.vibrate(VibrationEffect.createPredefined(VibrationEffect.EFFECT_CLICK))
    }
}
