package tech.jknair.workalarmmanagersample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import androidx.work.WorkRequest


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sampleWR: WorkRequest = OneTimeWorkRequest.Builder(SampleWorker::class.java).build()

        WorkManager
            .getInstance(this)
            .enqueue(sampleWR);
    }
}