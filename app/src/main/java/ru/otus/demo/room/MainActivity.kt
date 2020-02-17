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

            result?.let  {
                if(result.isNotEmpty()) {
                    val old = result[0]
                    val new =  ListData.publishers[1]
                    Db.getInstance(this)?.getPublisherDao()?.insertAndDeleteInTransaction(new, old)
                }
            }

            val secondResult = Db.getInstance(this)?.getPublisherDao()?.getAll()
            mUiHandler.post {
                Log.d(TAG, "secondResult:$secondResult")
            }

        }
        Executors.newSingleThreadScheduledExecutor().schedule(task, 2000, TimeUnit.MILLISECONDS)

    }


}
