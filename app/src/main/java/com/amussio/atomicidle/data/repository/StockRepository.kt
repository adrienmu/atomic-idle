package com.amussio.atomicidle.data.repository

import androidx.annotation.WorkerThread
import com.amussio.atomicidle.data.dao.StockDao
import com.amussio.atomicidle.data.models.Stock
import kotlinx.coroutines.flow.Flow

class StockRepository(private val stockDao: StockDao) {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allWords: Flow<Stock> = stockDao.getStock()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(stock: Stock) {
        stockDao.insert(stock)
    }

}