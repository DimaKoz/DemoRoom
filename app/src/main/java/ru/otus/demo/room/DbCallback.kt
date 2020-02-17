package ru.otus.demo.room

import android.content.Context
import android.util.Log
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import java.util.concurrent.Executors

class DbCallback(private val ctx: Context) : RoomDatabase.Callback() {
    override fun onCreate(db: SupportSQLiteDatabase) {
        Log.d(TAG, "DbCallback onCreate")
        Executors.newSingleThreadScheduledExecutor().execute(Runnable {
            val publisher = ListData.publishers[0]
            Db.getInstance(ctx)?.getPublisherDao()?.insert(publisher)
            Log.d(TAG, "DbCallback executed")

        })
    }

    override fun onOpen(db: SupportSQLiteDatabase) {
        // do something every time database is open
    }

}

