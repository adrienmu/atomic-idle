package com.amussio.atomicidle.data.helpers

import androidx.room.TypeConverter
import com.amussio.atomicidle.data.models.Element
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.reflect.TypeToken
import java.io.Serializable
import java.lang.reflect.Type

object TypeConverters {

    @TypeConverter
    @JvmStatic
    fun stringToMap(value: JsonElement): Map<String, Int> {
        return Gson().fromJson(value,  object : TypeToken<Map<String, String>>() {}.type)
    }

    @TypeConverter
    @JvmStatic
    fun mapToString(value: Map<String, String>?): String {
        return if(value == null) "" else Gson().toJson(value)
    }

    @TypeConverter
    @JvmStatic
    fun stringToElement(value: JsonElement): Element {
        return Gson().fromJson(value,  object : TypeToken<Map<String, String>>() {}.type)
    }

    @TypeConverter
    @JvmStatic
    fun elementToString(value: Element?): String {
        return if(value == null) "" else Gson().toJson(value)
    }

    @TypeConverter
    @JvmStatic
    fun fromElementList(elements: List<Element>?): String? {
        if (elements == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<List<Element>?>() {}.type
        return gson.toJson(elements, type)
    }

    @TypeConverter
    @JvmStatic
    fun toElementList(elementsString: String?): List<Element>? {
        if (elementsString == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<List<Element>?>() {}.type
        return gson.fromJson<List<Element>>(elementsString, type)
    }
}