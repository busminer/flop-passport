package dev.alexkosa.flooppassport.notify

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
import dev.alexkosa.flooppassport.MainActivity
import dev.alexkosa.flooppassport.R
import dev.alexkosa.flooppassport.i18n.LanguageStore
import dev.alexkosa.flooppassport.i18n.Translator
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
    private const val REQUEST_CODE = 4201
    private const val NOTIFICATION_ID = 4201

    /** Late morning: past the alarm-clock rush, well before a person stops opening apps. */
    private const val HOUR = 11

    fun ensureChannel(context: Context) {
        val tr = Translator(LanguageStore(context).effective)
        val channel = NotificationChannel(
            CHANNEL_ID,
            tr("Daily activity"),
            NotificationManager.IMPORTANCE_DEFAULT,
        ).apply {
            description = tr("A once-a-day reminder to leave today's signed record.")
            setShowBadge(true)
        }
        NotificationManagerCompat.from(context).createNotificationChannel(channel)
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
     * Posts the reminder.
     *
     * Deliberately says nothing about whether today's record already exists: finding that
     * out means asking the server, and a background network call that can fail is a poor
     * reason to stay silent. Opening the app answers it in a second, which is where the
     * answer belongs.
     */
    class Receiver : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val prefs = ReminderPrefs(context)
            if (!prefs.enabled || !canPost(context)) return
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

            val notification: Notification = androidx.core.app.NotificationCompat
                .Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.flop_chip)
                .setContentTitle(tr("Keep your record going"))
                .setContentText(tr("Leave today's signed record on Technocore."))
                .setStyle(
                    androidx.core.app.NotificationCompat.BigTextStyle().bigText(
                        tr(
                            "FLOP asked agents to do something useful. A signed record is " +
                                "what proves you did, and a day without one is a day nobody " +
                                "can check later.",
                        ),
                    ),
                )
                .setContentIntent(open)
                .setAutoCancel(true)
                .setPriority(androidx.core.app.NotificationCompat.PRIORITY_DEFAULT)
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
        context.getSharedPreferences("floop_passport_prefs", Context.MODE_PRIVATE)

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
