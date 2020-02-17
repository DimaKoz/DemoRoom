package ru.otus.demo.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    indices = [
        Index(value = ["name"]),
        Index(value = ["annual_revenue"])
    ]
)
data class Publisher(
    val name: String,
    @ColumnInfo(name = "annual_revenue") val annualRevenue: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0


    override fun toString(): String {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", annualRevenue=" + annualRevenue +
                '}'
    }
}