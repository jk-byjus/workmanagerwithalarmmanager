package tech.jknair.workalarmmanagersample

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.util.*

class SampleWorker(
    context: Context,
    params: WorkerParameters
) : Worker(context, params) {
    override fun doWork(): Result {
        scheduleWorkmanger(applicationContext)
        Log.e(TAG, "doWork: ")
        return Result.success()
    }

    fun scheduleWorkmanger(context: Context) {
        Log.e(TAG, "scheduleWorkmanger")
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context, AlarmReceiver::class.java)
        val alarmIntent = PendingIntent.getBroadcast(context, 123, intent, 0)
        if (alarmIntent != null) {
            val triggerAtMillis = minutesFromNow(1)
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, triggerAtMillis, alarmIntent)
            Log.e(
                TAG,
                "alarm manager set success at $triggerAtMillis"
            )
        } else {
            Log.e(
                TAG,
                "doWork: alarm manager set failed pendingIntent $alarmIntent, alarm manager $alarmManager"
            )
        }
    }

    private fun minutesFromNow(minutes: Int): Long {
        return Calendar.getInstance().timeInMillis + minutes * 60 * 1000
    }

    companion object {
        const val TAG = "SampleWorker"
    }
}