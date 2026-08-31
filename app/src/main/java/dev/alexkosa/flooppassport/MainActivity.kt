package dev.alexkosa.flooppassport

import android.content.Context
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import dev.alexkosa.flooppassport.ui.designsystem.FlopColors
import dev.alexkosa.flooppassport.ui.designsystem.FlopDot
import dev.alexkosa.flooppassport.ui.designsystem.FlopLabel
import dev.alexkosa.flooppassport.ui.designsystem.FlopSpacing
import dev.alexkosa.flooppassport.ui.designsystem.FlopState
import dev.alexkosa.flooppassport.ui.screens.PassportScreen
import kotlinx.coroutines.delay

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
