package dev.alexkosa.floppassport.notify

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

/**
 * Put the daily alarm back after a restart.
 *
 * Android drops every alarm on reboot. Without this the reminder works perfectly until the
 * first time the phone is switched off and then never again, which is the kind of failure
 * nobody reports because it looks like they simply stopped caring.
 */
class BootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action != Intent.ACTION_BOOT_COMPLETED) return
        if (ReminderPrefs(context).enabled) DailyReminder.schedule(context)
    }
}
