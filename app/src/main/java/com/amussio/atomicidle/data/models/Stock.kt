package com.amussio.atomicidle.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.amussio.atomicidle.data.helpers.ElementsConverter
import com.amussio.atomicidle.data.helpers.MapConverter

@Entity(tableName = "stock")
data class Stock(

    @PrimaryKey
    val id: Int = 1,

    @TypeConverters(ElementsConverter::class)
    @ColumnInfo(name = "elements")
    var elements: List<Element>,

    @ColumnInfo(name = "timestamp")
    var timestamp: Int)
