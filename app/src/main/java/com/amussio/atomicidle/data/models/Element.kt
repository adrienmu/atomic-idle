package com.amussio.atomicidle.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "element")
data class Element(

    @PrimaryKey
    @ColumnInfo(name = "name")
    override val name: String,

    @ColumnInfo(name = "group")
    override val group:String,

    @ColumnInfo(name = "requires")
    override val requires: MutableMap<String, Int>?,

    @ColumnInfo(name = "produces")
    override val produces: MutableMap<String, Int>?,

    @ColumnInfo(name = "quantity")
    var quantity: Int

    ): ElementBase(name = name, group = group, requires = requires, produces = produces)

