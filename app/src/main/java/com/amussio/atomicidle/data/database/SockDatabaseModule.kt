package com.amussio.atomicidle.data.database

import android.content.Context
import androidx.room.Room
import com.amussio.atomicidle.data.dao.StockDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SockDatabaseModule {

    @Provides
    @Singleton
    fun provideStockDatabase(
        @ApplicationContext context: Context
    ): StockRoomDatabase =
        Room.databaseBuilder(context, StockRoomDatabase::class.java, "stock.db")
            .build()

    @Provides
    fun provideStockDao(database: StockRoomDatabase): StockDao =
        database.stockDao()
}