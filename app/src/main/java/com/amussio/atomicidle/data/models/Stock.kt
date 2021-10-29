package com.amussio.atomicidle.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stock")
data class Stock(

    @PrimaryKey
    val id: Int = 1,

    @ColumnInfo(name = "elements")
    var elements: List<Element>,

    @ColumnInfo(name = "timestamp")
    var timestamp: Int)
