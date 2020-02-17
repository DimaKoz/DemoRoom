package ru.otus.demo.room

import androidx.room.Dao
import androidx.room.Transaction

@Dao
abstract class PublisherDao : IPublisherDao {

    @Transaction
    open fun insertAndDeleteInTransaction(
        newPublisher: Publisher?,
        oldPublisher: Publisher?
    ) { // Anything inside this method runs in a single transaction.
        insert(newPublisher)
        delete(oldPublisher)
    }

}