package ru.otus.demo.room

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {


    private val mUiHandler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "MainActivity onCreate")
        setContentView(R.layout.activity_main)


        val task = Runnable {
            val result = Db.getInstance(this)?.getPublisherDao()?.getAll()
            Log.d(TAG, "result:$result")
            mUiHandler.post {
                Log.d(TAG, "result:$result")
            }
        }
        Executors.newSingleThreadScheduledExecutor().schedule(task, 2000, TimeUnit.MILLISECONDS)

    }


}
