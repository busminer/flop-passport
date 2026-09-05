package dev.alexkosa.floppassport.notify

import android.app.AlarmManager
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import dev.alexkosa.floppassport.MainActivity
import dev.alexkosa.floppassport.R
import dev.alexkosa.floppassport.i18n.LanguageStore
import dev.alexkosa.floppassport.vault.PassportVault
import dev.alexkosa.floppassport.i18n.Translator
import java.util.Calendar

/**
 * One reminder a day, and only if there is something to remind about.
 *
 * A streak on Technocore is the one thing this app can honestly help with: records are
 * signed by hand, a day missed is a day gone, and nobody opens an identity app out of
 * habit. So the reminder exists - but it is built to be the kind a person keeps switched
 * on rather than the kind they turn off in week two:
 *
 *  - once a day, at a civilised hour, never a stream of them
 *  - it says nothing about an allocation. This app's own About screen promises nothing
 *    about any airdrop and never will, and a notification that quietly promises one would
 *    make that sentence a lie. What it does instead is state the fact - FLOP asked agents
 *    for useful work, a signed record is the evidence of it - which is both true and, for
 *    anyone who has read the project, more persuasive than a promise.
 *  - it is off by default until the person allows notifications, and there is a switch in
 *    Settings that actually cancels the alarm rather than only hiding the row.
 */
object DailyReminder {

    const val CHANNEL_ID = "daily_activity"

    /**
     * A second channel, on purpose.
     *
     * "Your streak could be longer" and "the address you saved goes empty tomorrow" are
     * not the same message, and Android lets a person keep one and mute the other only if
     * they arrive on different channels. Anyone who finds the daily nudge tiresome can
     * switch it off and still be told before their identity note is deleted - which is the
     * one notification this app would be negligent not to send.
     */
    const val EXPIRY_CHANNEL_ID = "note_expiry"

    private const val REQUEST_CODE = 4201
    private const val NOTIFICATION_ID = 4201

    /** Late morning: past the alarm-clock rush, well before a person stops opening apps. */
    private const val HOUR = 11

    /** The blank line between the headline and the explanation in the expanded view. */
    private const val LINE_BREAK = "\n\n"

    fun ensureChannel(context: Context) {
        val tr = Translator(LanguageStore(context).effective)
        val manager = NotificationManagerCompat.from(context)
        manager.createNotificationChannel(
            NotificationChannel(
                CHANNEL_ID,
                tr("Daily activity"),
                NotificationManager.IMPORTANCE_DEFAULT,
            ).apply {
                description = tr("A once-a-day reminder to leave today's signed record.")
                setShowBadge(true)
            },
        )
        manager.createNotificationChannel(
            NotificationChannel(
                EXPIRY_CHANNEL_ID,
                tr("Passport at risk"),
                NotificationManager.IMPORTANCE_HIGH,
            ).apply {
                description = tr(
                    "Told only when your identity note is days away from being deleted.",
                )
                setShowBadge(true)
            },
        )
    }

    fun schedule(context: Context) {
        ensureChannel(context)
        val alarms = context.getSystemService(AlarmManager::class.java) ?: return
        // Inexact on purpose: a daily nudge does not need to be to the second, and exact
        // alarms ask for a permission this app has no business holding.
        alarms.setInexactRepeating(
            AlarmManager.RTC,
            nextTrigger(),
            AlarmManager.INTERVAL_DAY,
            pendingIntent(context),
        )
    }

    fun cancel(context: Context) {
        context.getSystemService(AlarmManager::class.java)?.cancel(pendingIntent(context))
        NotificationManagerCompat.from(context).cancel(NOTIFICATION_ID)
    }

    fun canPost(context: Context): Boolean =
        android.os.Build.VERSION.SDK_INT < 33 ||
            ContextCompat.checkSelfPermission(
                context, android.Manifest.permission.POST_NOTIFICATIONS,
            ) == PackageManager.PERMISSION_GRANTED

    private fun nextTrigger(): Long {
        val now = Calendar.getInstance()
        val at = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, HOUR)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }
        if (at.timeInMillis <= now.timeInMillis) at.add(Calendar.DAY_OF_MONTH, 1)
        return at.timeInMillis
    }

    private fun pendingIntent(context: Context): PendingIntent = PendingIntent.getBroadcast(
        context,
        REQUEST_CODE,
        Intent(context, Receiver::class.java),
        PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE,
    )

    /**
     * Posts the reminder, and says the thing that is actually true today.
     *
     * The first version of this said the same sentence every morning and deliberately
     * asked the server nothing, on the grounds that a background call which can fail is a
     * poor reason to stay silent. That is still right about the network - and wrong about
     * staying quiet, because the app already knows the one fact that matters without
     * asking anybody: when it last wrote the note. From that it can do the two things a
     * daily reminder normally cannot.
     *
     * It can shut up. Somebody who signed a record this morning is told nothing at eleven,
     * which is the difference between a reminder people keep and one they switch off in
     * week two.
     *
     * And it can escalate. On the fourth quiet day it stops being a nudge, moves to the
     * channel a person cannot reasonably mute, and starts naming the day their identity
     * note is deleted. Past seven days it says the note is gone rather than pretending -
     * and says, correctly, that the Passport itself is not.
     */
    class Receiver : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val prefs = ReminderPrefs(context)
            if (!prefs.enabled || !canPost(context)) return
            // Nothing to keep going yet. Somebody who installed the app, looked at it and
            // never made a Passport should not be reminded tomorrow to continue a streak
            // that does not exist - that is the notification people uninstall over.
            if (!PassportVault(context).hasPassport) return

            val daysSince = NoteLife.daysSinceWrite(context)
            val urgency = NoteLife.urgency(daysSince)
            if (urgency == NoteLife.Urgency.SILENT) return

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

            val title: String
            val text: String
            val detail: String
            when (urgency) {
                NoteLife.Urgency.LOST -> {
                    title = tr("Your identity note has been deleted")
                    text = tr("Seven days without a record. Open the app to publish it again.")
                    detail = tr(
                        "Your Passport itself is not lost: the same wallet still gives the " +
                            "same identity, and signing a record now publishes the note " +
                            "back to the same address.",
                    )
                }
                NoteLife.Urgency.WARNING -> {
                    title = tr("Your identity note expires soon")
                    text = tr(NoteLife.countdown(daysSince))
                    detail = tr(
                        "technocore.chat deletes anything with no write for seven days. " +
                            "Signing today rewrites your note and starts the seven days " +
                            "again.",
                    )
                }
                else -> {
                    // The sharpest true thing this app can say, and the only one that
                    // needs no promise behind it. Everything else can be caught up on
                    // later: the key, the note, the post. A date cannot.
                    title = tr("Today cannot be added later")
                    text = tr("Sign a record now and this day is on your history for good.")
                    detail = tr(
                        "FLOP asked agents to do something useful. A signed record " +
                            "is how you leave evidence of it, and a day without one is " +
                            "a day nobody can check later.",
                    )
                }
            }

            val urgent = urgency != NoteLife.Urgency.NUDGE
            val notification: Notification = androidx.core.app.NotificationCompat
                .Builder(
                    context,
                    if (urgent) EXPIRY_CHANNEL_ID else CHANNEL_ID,
                )
                .setSmallIcon(R.drawable.flop_chip)
                .setContentTitle(title)
                .setContentText(text)
                .setStyle(
                    androidx.core.app.NotificationCompat.BigTextStyle()
                        .bigText(text + LINE_BREAK + detail),
                )
                .setContentIntent(open)
                .setAutoCancel(true)
                .setPriority(
                    if (urgent) {
                        androidx.core.app.NotificationCompat.PRIORITY_HIGH
                    } else {
                        androidx.core.app.NotificationCompat.PRIORITY_DEFAULT
                    },
                )
                .build()

            NotificationManagerCompat.from(context).notify(NOTIFICATION_ID, notification)
        }
    }
}

/**
 * Whether the reminder is wanted, kept beside the language rather than in the vault: it is
 * a preference, not a secret, and reading it must never require unlocking key material.
 */
class ReminderPrefs(context: Context) {
    private val prefs =
        context.getSharedPreferences("flop_passport_prefs", Context.MODE_PRIVATE)

    /** Off until somebody says otherwise, which the permission prompt is how they say. */
    var enabled: Boolean
        get() = prefs.getBoolean(KEY, false)
        set(value) = prefs.edit().putBoolean(KEY, value).apply()

    /** So the permission is asked for once, not on every launch. */
    var asked: Boolean
        get() = prefs.getBoolean(KEY_ASKED, false)
        set(value) = prefs.edit().putBoolean(KEY_ASKED, value).apply()

    private companion object {
        const val KEY = "daily_reminder"
        const val KEY_ASKED = "daily_reminder_asked"
    }
}
