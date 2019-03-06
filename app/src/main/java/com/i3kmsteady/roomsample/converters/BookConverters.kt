package com.i3kmsteady.roomsample.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.i3kmsteady.roomsample.entity.Book

class BookConverters {

    @TypeConverter
    fun stringToObject(value: String): List<Book> {
        val listType = object : TypeToken<List<Book>>() {

        }.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun objectToString(list: List<Book>): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}