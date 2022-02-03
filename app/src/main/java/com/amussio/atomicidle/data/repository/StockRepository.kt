package com.amussio.atomicidle.data.repository

import androidx.annotation.WorkerThread
import com.amussio.atomicidle.data.dao.StockDao
import com.amussio.atomicidle.data.models.Element
import com.amussio.atomicidle.data.models.Stock
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class StockRepository @Inject constructor(private val stockDao: StockDao) {

    fun getInfiniteStockFlow(): Flow<Stock> = flow {
        while (true) {
            delay(1_000)
            emit(stockDao.getStock())
        }
    }.flowOn(Dispatchers.IO)

    suspend fun updateStock(stock: Stock) {
        stockDao.update(stock)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(stock: Stock) {
        stockDao.insert(stock)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun increase(elementName: String, value: Int) {
        val stock = stockDao.getStock()
        stock.elements.forEach {
            if (it.name == elementName) {
                it.quantity += value
            }
        }
        stockDao.update(stock)
    }
}