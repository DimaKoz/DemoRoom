package ru.otus.demo.room

import androidx.room.*

@Dao
interface IPublisherDao {

    //Examples of insertion methods
    @Insert
    fun insert(Publisher: Publisher?)

    @Insert
    fun insertSinglePublisher(Publisher: Publisher?): Long

    @Insert
    fun insertBothPublisher(Publisher1: Publisher?, Publisher2: Publisher?)

    @Insert
    fun insertPublishers(vararg Publishers: Publisher?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPublishers(Publishers: List<Publisher?>?): List<Long?>?

    @Insert
    fun insertPublisherAndPublishers(
        Publisher: Publisher?,
        Publishers: List<Publisher?>?
    )


    //Examples of update methods
    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updatePublishers(vararg Publishers: Publisher?)

    @Update
    fun update(Publisher: Publisher?)

    @Update
    fun updatePublishers(Publishers: List<Publisher?>?): Int


    //Examples of deletion methods
    @Delete
    fun deletePublishers(vararg Publishers: Publisher?)

    @Delete
    fun deletePublisher(Publisher: Publisher?)

    @Delete
    fun deletePublishers(Publishers: List<Publisher?>?): Int

    @Delete
    fun delete(Publisher: Publisher?)


    @Query("SELECT * FROM Publisher")
    fun getAll(): List<Publisher?>?

    @Query("SELECT * FROM Publisher WHERE id = :id")
    fun getById(id: Long): Publisher?

    @Query("SELECT * FROM Publisher WHERE name LIKE :search ")
    fun findPublishersWithName(search: String?): List<Publisher?>?

    @Query("SELECT * FROM Publisher WHERE annual_revenue > :revenue ")
    fun findPublisherWithRevenueMore(revenue: Int): List<Publisher?>?

}