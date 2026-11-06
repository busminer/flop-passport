package dev.alexkosa.floppassport.notify

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import dev.alexkosa.floppassport.MainActivity
import dev.alexkosa.floppassport.R
import dev.alexkosa.floppassport.i18n.LanguageStore
import dev.alexkosa.floppassport.i18n.Translator
import dev.alexkosa.floppassport.vault.PassportVault

/**
 * A few reminders for the one step somebody left undone, and then silence.
 *
 * The five steps make an identity that only this phone knows about. Step 06 is what puts a
 * public name beside it, and it is the step people lose: they tap post, land in another
 * app, publish, and never come back to paste the link. Not out of carelessness - that is
 * simply what happens to attention when it is handed to a different screen.
 *
 * **Why it stops.** Alex asked for one every half hour. Every half hour, forever, is how an
 * app teaches somebody to mute it - and the switch they reach for is usually the app, not
 * the channel, which would take the seven-day expiry warning with it. That warning is the
 * one notification this app would be negligent not to send. So the schedule is loud early,
 * when the person still remembers what they were doing, and then gets out of the way:
 * half an hour, two hours, a day, done. Three in total. If they have not finished by then,
 * a fourth will not be what changes their mind, and the app still tells them on its own
 * screen every time they open it.
 *
 * Its own channel, for the same reason the expiry warning has one: somebody who finds this
 * one nagging can silence exactly this and keep the rest.
 */
object FinishNudge {

    const val CHANNEL_ID = "finish_setup"

    private const val REQUEST_CODE = 4202
    private const val NOTIFICATION_ID = 4202

    private const val MINUTE = 60_000L
    private const val HOUR = 60 * MINUTE

    /** Half an hour, two hours, a day. Then nothing. */
    private val DELAYS = longArrayOf(30 * MINUTE, 2 * HOUR, 24 * HOUR)

    fun ensureChannel(context: Context) {
        val tr = Translator(LanguageStore(context).effective)
        NotificationManagerCompat.from(context).createNotificationChannel(
            NotificationChannel(
                CHANNEL_ID,
                tr("Unfinished setup"),
                NotificationManager.IMPORTANCE_DEFAULT,
            ).apply {
                description = tr("A few reminders about the last step, and then they stop.")
                setShowBadge(true)
            },
        )
    }

    /**
     * Start, or continue, the short run of reminders.
     *
     * Called when the five steps are done and no link has come back. Calling it again while
     * it is already running changes nothing: the attempt counter only moves when a
     * reminder actually fires, so opening the app twice does not reset the schedule or
     * double it up.
     */
    fun start(context: Context) {
        val prefs = NudgePrefs(context)
        if (prefs.attempt >= DELAYS.size) return
        schedule(context, prefs.attempt)
    }

    private fun schedule(context: Context, attempt: Int) {
        if (attempt >= DELAYS.size) return
        context.getSystemService(AlarmManager::class.java)?.set(
            AlarmManager.RTC,
            System.currentTimeMillis() + DELAYS[attempt],
            pendingIntent(context),
        )
    }

    /**
     * Stop.
     *
     * Called the moment the link is found in the note, and when the Passport is deleted;
     * in both cases the counter resets, so somebody who starts again gets the same help
     * the second time. It is also called while the ladder is still being restored from
     * the server at launch, and there the counter must be kept: resetting it on every
     * slow launch handed a person who had already heard all three reminders all three
     * again.
     */
    fun cancel(context: Context, resetCount: Boolean = true) {
        context.getSystemService(AlarmManager::class.java)?.cancel(pendingIntent(context))
        NotificationManagerCompat.from(context).cancel(NOTIFICATION_ID)
        if (resetCount) NudgePrefs(context).attempt = 0
    }

    private fun pendingIntent(context: Context): PendingIntent = PendingIntent.getBroadcast(
        context,
        REQUEST_CODE,
        Intent(context, Receiver::class.java),
        PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE,
    )

    class Receiver : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val prefs = NudgePrefs(context)
            // Somebody with no Passport has nothing to finish, and somebody who finished
            // cancelled this already - but an alarm can outlive both, so check rather
            // than assume.
            if (!prefs.pending || !PassportVault(context).hasPassport) return
            if (!DailyReminder.canPost(context)) return

            val attempt = prefs.attempt
            if (attempt >= DELAYS.size) return

            ensureChannel(context)
            val tr = Translator(LanguageStore(context).effective)
            val open = PendingIntent.getActivity(
                context,
                0,
                Intent(context, MainActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
                },
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE,
            )

            // Three messages, saying three different things. Repeating one sentence louder
            // is what makes a reminder feel like a machine; each of these tells the person
            // something they did not already know from the last one.
            val title: String
            val text: String
            val detail: String
            when (attempt) {
                0 -> {
                    title = tr("One step left")
                    text = tr("You finished the five. The last one takes a minute.")
                    detail = tr(
                        "Post your line, then come back and paste the link. That is what " +
                            "attaches your name to your key, and it is the half FLOP asked " +
                            "agents for.",
                    )
                }
                1 -> {
                    title = tr("Your Passport has no name on it")
                    text = tr("Anyone who looks it up sees a key and nothing else.")
                    detail = tr(
                        "The link you paste goes into your identity note, at an address " +
                            "derived from your own key. The note stays as long as you " +
                            "keep opening the app; seven days without a write and it is " +
                            "deleted.",
                    )
                }
                else -> {
                    title = tr("Still one step short")
                    text = tr("Last reminder about this one.")
                    detail = tr(
                        "Nothing is broken and nothing is lost. Your Passport works. When " +
                            "you want the public half of it, step 06 is waiting where you " +
                            "left it.",
                    )
                }
            }

            val notification = NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.flop_chip)
                .setContentTitle(title)
                .setContentText(text)
                .setStyle(NotificationCompat.BigTextStyle().bigText(text + "\n\n" + detail))
                .setContentIntent(open)
                .setAutoCancel(true)
                .build()

            // Refused notifications on Android 13+ are dropped by the system anyway; this says so
            // in code, and a phone that throws instead cannot take the alarm down with it.
            if (DailyReminder.canPost(context)) {
                try {
                    NotificationManagerCompat.from(context).notify(NOTIFICATION_ID, notification)
                } catch (_: SecurityException) {
                }
            }
            prefs.attempt = attempt + 1
            schedule(context, attempt + 1)
        }
    }
}

/** Where the short run of reminders keeps its place. */
class NudgePrefs(context: Context) {
    private val prefs =
        context.getSharedPreferences("flop_passport_prefs", Context.MODE_PRIVATE)

    /** True between finishing the five steps and the link landing in the note. */
    var pending: Boolean
        get() = prefs.getBoolean(KEY_PENDING, false)
        set(value) = prefs.edit().putBoolean(KEY_PENDING, value).apply()

    /** How many have already been sent. Three is the end of it. */
    var attempt: Int
        get() = prefs.getInt(KEY_ATTEMPT, 0)
        set(value) = prefs.edit().putInt(KEY_ATTEMPT, value).apply()

    private companion object {
        const val KEY_PENDING = "finish_pending"
        const val KEY_ATTEMPT = "finish_attempt"
    }
}
