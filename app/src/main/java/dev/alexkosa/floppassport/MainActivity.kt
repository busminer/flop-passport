package dev.alexkosa.floppassport

import android.content.Context
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.fragment.app.FragmentActivity
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
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.alexkosa.floppassport.notify.ReminderPrefs
import dev.alexkosa.floppassport.notify.DailyReminder
import dev.alexkosa.floppassport.ui.PassportViewModel
import dev.alexkosa.floppassport.ui.designsystem.FlopColors
import dev.alexkosa.floppassport.ui.designsystem.FlopDot
import dev.alexkosa.floppassport.ui.designsystem.FlopLabel
import dev.alexkosa.floppassport.ui.designsystem.FlopSpacing
import dev.alexkosa.floppassport.ui.designsystem.FlopState
import dev.alexkosa.floppassport.ui.screens.AppShell
import kotlinx.coroutines.delay

/**
 * A FragmentActivity rather than a ComponentActivity: BiometricPrompt attaches to a
 * fragment host, and the key-export screen needs it.
 */
class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // Hand the system splash over to our own theme before the first frame, so the
        // Chip the system was showing gives way to the launch scene without a flash.
        setTheme(R.style.Theme_FlopPassport)
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        askForNotificationsOnce()
        setContent { PassportApp() }
    }

    /**
     * Ask for notification permission on the first launch, and never again.
     *
     * Asking once, at the start, is the honest moment: the person is deciding what this app
     * is allowed to do while they are deciding what it is. Asking later - at the end of a
     * flow, when they are pleased - is a trick, and asking repeatedly is how an app teaches
     * people to refuse it. If they say no, the switch in Settings is still there, and
     * Android will show its own prompt when they use it.
     */
    private fun askForNotificationsOnce() {
        // Below Android 13 there is no prompt, and installing the app already grants the
        // permission. That is not consent to be notified: switching reminders on for
        // somebody who was never asked is exactly the behaviour the prompt exists to stop.
        // They stay off, and the switch in Settings is where a person turns them on.
        if (android.os.Build.VERSION.SDK_INT < 33) {
            ReminderPrefs(this).asked = true
            return
        }
        val prefs = ReminderPrefs(this)
        if (prefs.asked) return

        val launcher = registerForActivityResult(
            androidx.activity.result.contract.ActivityResultContracts.RequestPermission(),
        ) { granted ->
            prefs.asked = true
            prefs.enabled = granted
            if (granted) DailyReminder.schedule(this) else DailyReminder.cancel(this)
        }
        if (DailyReminder.canPost(this)) {
            prefs.asked = true
            prefs.enabled = true
            DailyReminder.schedule(this)
        } else {
            launcher.launch(android.Manifest.permission.POST_NOTIFICATIONS)
        }
    }
}

@Composable
private fun PassportApp(vm: PassportViewModel = viewModel()) {
    val context = LocalContext.current

    // Keyed on the ViewModel's flag rather than Unit: a rotation recreates the Activity and
    // would otherwise replay the whole launch scene, sound included, every time the phone
    // is turned over.
    LaunchedEffect(vm.launchScenePlayed) {
        if (!vm.launchScenePlayed) {
            playLaunchCue(context)
            delay(3_200)
            vm.markLaunchScenePlayed()
        }
    }

    Box(Modifier.fillMaxSize().background(FlopColors.Base)) {
        if (vm.launchScenePlayed) AppShell(vm) else LaunchScene()
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
