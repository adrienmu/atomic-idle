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
    val requires: Map<String, Int>?,

    @ColumnInfo(name = "produces")
    @TypeConverters(MapConverter::class)
    val produces: Map<String, Int>?,

    @ColumnInfo(name = "quantity")
    var quantity: Int

    )

