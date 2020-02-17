package ru.otus.demo.room

import androidx.room.Database
import androidx.room.RoomDatabase

const val TAG = "AppDb"

@Database(entities = arrayOf(Publisher::class), version = 1)
abstract class AppDb : RoomDatabase() {
    abstract fun getPublisherDao(): PublisherDao

}