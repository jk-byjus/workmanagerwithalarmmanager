package tech.jknair.workalarmmanagersample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import tech.jknair.workalarmmanagersample.SampleWorker.Companion.TAG

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.e(TAG, "onReceive: invoked by alarm manager"+intent )
    }

}