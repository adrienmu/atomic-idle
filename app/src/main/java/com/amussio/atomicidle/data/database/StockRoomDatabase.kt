package com.amussio.atomicidle.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.amussio.atomicidle.data.dao.StockDao
import com.amussio.atomicidle.data.helpers.MapTypeConverter
import com.amussio.atomicidle.data.models.Stock

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = arrayOf(Stock::class), version = 1, exportSchema = false)
@TypeConverters(MapTypeConverter::class)
public abstract class StockRoomDatabase: RoomDatabase() {
    abstract fun stockDao(): StockDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: StockRoomDatabase? = null

        fun getDatabase(context: Context): StockRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    StockRoomDatabase::class.java,
                    "stock_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}