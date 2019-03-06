package com.i3kmsteady.roomsample.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.i3kmsteady.roomsample.converters.BookConverters


@Entity(tableName = "user")
@TypeConverters(BookConverters::class)
data class User(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "books")
    val books: List<Book>

)

data class Book(
    val bookName: String
)
