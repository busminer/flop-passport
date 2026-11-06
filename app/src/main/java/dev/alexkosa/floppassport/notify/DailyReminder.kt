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
    private const val EVENING_REQUEST_CODE = 4202
    private const val NOTIFICATION_ID = 4201
    private const val EXTRA_EVENING = "evening"

    /** Late morning: past the alarm-clock rush, well before a person stops opening apps. */
    private const val HOUR = 11

    /**
     * And once more in the evening, only if the day is still unsigned.
     *
     * Added in 2.0. In 1.0 the single morning reminder stayed silent for anybody whose note
     * had been written in the last 24 hours, so a person who signed late yesterday was told
     * nothing today - measured on 19 October 2026, 163 streaks had ended on exactly one
     * missed day. The evening one is the last chance, and says so.
     */
    private const val EVENING_HOUR = 20

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
                tr("Identity note at risk"),
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
            nextTrigger(HOUR),
            AlarmManager.INTERVAL_DAY,
            pendingIntent(context, evening = false),
        )
        alarms.setInexactRepeating(
            AlarmManager.RTC,
            nextTrigger(EVENING_HOUR),
            AlarmManager.INTERVAL_DAY,
            pendingIntent(context, evening = true),
        )
    }

    fun cancel(context: Context) {
        context.getSystemService(AlarmManager::class.java)?.let {
            it.cancel(pendingIntent(context, evening = false))
            it.cancel(pendingIntent(context, evening = true))
        }
        NotificationManagerCompat.from(context).cancel(NOTIFICATION_ID)
    }

    fun canPost(context: Context): Boolean =
        android.os.Build.VERSION.SDK_INT < 33 ||
            ContextCompat.checkSelfPermission(
                context, android.Manifest.permission.POST_NOTIFICATIONS,
            ) == PackageManager.PERMISSION_GRANTED

    private fun nextTrigger(hour: Int): Long {
        val now = Calendar.getInstance()
        val at = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, hour)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }
        if (at.timeInMillis <= now.timeInMillis) at.add(Calendar.DAY_OF_MONTH, 1)
        return at.timeInMillis
    }

    private fun pendingIntent(context: Context, evening: Boolean): PendingIntent = PendingIntent.getBroadcast(
        context,
        if (evening) EVENING_REQUEST_CODE else REQUEST_CODE,
        Intent(context, Receiver::class.java).putExtra(EXTRA_EVENING, evening),
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
            // No note has ever been written from this phone: the person is still at the
            // early steps. "Sign a record now" would send them to a button that publishes
            // the note behind their back, and the unfinished-setup reminders are the
            // ones that cover this case.
            if (daysSince == NoteLife.UNKNOWN) return
            val evening = intent.getBooleanExtra(EXTRA_EVENING, false)
            // An inexact daily alarm may be delivered hours late. An evening reminder that
            // arrives after midnight would speak about a day that is already over.
            if (evening && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) < EVENING_HOUR - 2) return
            val noteUrgency = NoteLife.urgency(daysSince)
            // The day decides, not the note. A note written last night says nothing about
            // whether today is signed, and treating it as if it did is what silenced the
            // one reminder that mattered.
            val signedToday = prefs.lastSignedDay == dev.alexkosa.floppassport.ui.ActivityState.today()
            val urgency = when {
                noteUrgency == NoteLife.Urgency.LOST || noteUrgency == NoteLife.Urgency.WARNING -> noteUrgency
                signedToday -> NoteLife.Urgency.SILENT
                else -> NoteLife.Urgency.NUDGE
            }
            if (urgency == NoteLife.Urgency.SILENT) return
            // The evening run is only for the unsigned day. Note warnings went out this
            // morning, and saying them twice a day is how a channel gets muted.
            if (evening && urgency != NoteLife.Urgency.NUDGE) return

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
                    text = tr("Seven days without opening the app. Open it and press publish; the note goes back to the same address.")
                    detail = tr(
                        "Your Passport itself is not lost: the same wallet still gives the " +
                            "same identity, and publishing again puts the note back at " +
                            "the same address.",
                    )
                }
                NoteLife.Urgency.WARNING -> {
                    title = tr("Your identity note expires soon")
                    text = tr(NoteLife.countdown(NoteLife.daysLeft(context)))
                    detail = tr(
                        "technocore.chat deletes anything with no write for seven days. " +
                            "Opening this app rewrites your note, and so does signing a " +
                            "record. Either one starts the seven days again.",
                    )
                }
                else -> {
                    // The sharpest true thing this app can say, and the only one that
                    // needs no promise behind it. Everything else can be caught up on
                    // later: the key, the note, the post. A date cannot.
                    // "Ends at midnight" only when it is true. With one missed day a week
                    // forgiven, most unsigned evenings do not end anything.
                    val streak = prefs.lastStreak
                    val atRisk = prefs.atRiskDay == dev.alexkosa.floppassport.ui.ActivityState.today()
                    title = when {
                        evening && streak > 0 && atRisk -> tr("Your {n}-day streak ends at midnight").replace("{n}", streak.toString())
                        evening -> tr("Today is not signed yet")
                        else -> tr("Today cannot be added later")
                    }
                    text = tr("Open the app and press do my day: it signs today, takes today's FLOP and asks the model one question.")
                    detail = tr(
                        "A signed record is dated evidence that you were here. A day " +
                            "without one cannot be added later, and signing also keeps " +
                            "your identity note alive. Nothing here promises anything " +
                            "about any allocation.",
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

            // Refused notifications on Android 13+ are dropped by the system anyway; this says so
            // in code, and a phone that throws instead cannot take the alarm down with it.
            if (DailyReminder.canPost(context)) {
                try {
                    NotificationManagerCompat.from(context).notify(NOTIFICATION_ID, notification)
                } catch (_: SecurityException) {
                }
            }
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

    /**
     * The last day this phone saw signed, and the streak it saw then.
     *
     * Written by the app whenever the room shows today's record, so the reminder can know
     * the day is done without asking the network from a background alarm.
     */
    var lastSignedDay: String?
        get() = prefs.getString(KEY_SIGNED, null)
        set(value) = prefs.edit().putString(KEY_SIGNED, value).apply()

    var lastStreak: Int
        get() = prefs.getInt(KEY_STREAK, 0)
        set(value) = prefs.edit().putInt(KEY_STREAK, value).apply()

    /** The day on which missing the day would end the streak, as the app last saw it. */
    var atRiskDay: String?
        get() = prefs.getString(KEY_AT_RISK, null)
        set(value) = prefs.edit().putString(KEY_AT_RISK, value).apply()

    /** So the permission is asked for once, not on every launch. */
    var asked: Boolean
        get() = prefs.getBoolean(KEY_ASKED, false)
        set(value) = prefs.edit().putBoolean(KEY_ASKED, value).apply()

    private companion object {
        const val KEY = "daily_reminder"
        const val KEY_ASKED = "daily_reminder_asked"
        const val KEY_SIGNED = "last_signed_day"
        const val KEY_STREAK = "last_streak"
        const val KEY_AT_RISK = "streak_at_risk_day"
    }
}
