package ru.otus.demo.room

import android.app.Application
import android.util.Log
import java.util.concurrent.Executors

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "App onCreate")
        Executors.newSingleThreadScheduledExecutor().execute(
            Runnable {
                Db.getInstance(this)?.getPublisherDao()?.getAll()
            }
        )
    }
}