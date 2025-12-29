package com.linghui.data.local.db

import androidx.room.TypeConverter
import org.json.JSONArray

class StringListConverter {
    @TypeConverter
    fun fromList(value: List<String>): String = JSONArray(value).toString()

    @TypeConverter
    fun toList(value: String): List<String> {
        if (value.isBlank()) return emptyList()
        val jsonArray = JSONArray(value)
        return List(jsonArray.length()) { index -> jsonArray.getString(index) }
    }
}
