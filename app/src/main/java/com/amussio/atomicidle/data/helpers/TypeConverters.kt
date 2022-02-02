package com.amussio.atomicidle.data.helpers

import androidx.room.TypeConverter
import com.amussio.atomicidle.data.models.Element
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.reflect.TypeToken
import java.io.Serializable
import java.lang.reflect.Type

object MapConverter {
    @TypeConverter
    @JvmStatic
    fun stringToMap(value: String): Map<String, Int>? {
        return Gson().fromJson(value,  object : TypeToken<Map<String, Int>>() {}.type)
    }

    @TypeConverter
    @JvmStatic
    fun mapToString(value: Map<String, Int>?): String {
        return Gson().toJson(value, object : TypeToken<Map<String, Int>>() {}.type)
    }
}

object ElementConverter {
    @TypeConverter
    @JvmStatic
    fun stringToElement(value: String): Element {
        return Gson().fromJson(value,  object : TypeToken<Element>() {}.type)
    }

    @TypeConverter
    @JvmStatic
    fun elementToString(value: Element?): String {
        return if(value == null) "" else Gson().toJson(value)
    }
}

object ElementsConverter {
    @TypeConverter
    @JvmStatic
    fun fromElementList(elements: List<Element>): String {
        val gson = Gson()
        val type: Type = object : TypeToken<List<Element>>() {}.type
        return gson.toJson(elements, type)
    }

    @TypeConverter
    @JvmStatic
    fun toElementList(elementsString: String): List<Element> {
        val gson = Gson()
        val type: Type = object : TypeToken<List<Element>?>() {}.type
        return gson.fromJson(elementsString, type)
    }
}