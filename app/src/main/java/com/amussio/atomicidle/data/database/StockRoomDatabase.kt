package com.amussio.atomicidle.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.amussio.atomicidle.data.dao.StockDao
import com.amussio.atomicidle.data.models.Stock

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = arrayOf(Stock::class), version = 1, exportSchema = false)
@TypeConverters(com.amussio.atomicidle.data.helpers.TypeConverters::class)
abstract class StockRoomDatabase: RoomDatabase() {
    abstract fun stockDao(): StockDao
}