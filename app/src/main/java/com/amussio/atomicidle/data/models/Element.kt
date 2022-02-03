package com.amussio.atomicidle.data.models

import androidx.room.*
import com.amussio.atomicidle.data.helpers.MapConverter

@Entity(tableName = "element")
data class Element(

    @PrimaryKey
    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "group")
    val group:String,

    @ColumnInfo(name = "requires")
    @TypeConverters(MapConverter::class)
    val requires: Map<String, Double>?,

    @ColumnInfo(name = "produces")
    @TypeConverters(MapConverter::class)
    val produces: Map<String, Double>?,

    @ColumnInfo(name = "quantity")
    var quantity: Double

    )

