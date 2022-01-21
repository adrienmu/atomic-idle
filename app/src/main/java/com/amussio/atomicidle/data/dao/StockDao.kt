package com.amussio.atomicidle.data.dao

import androidx.room.*
import com.amussio.atomicidle.data.models.Element
import com.amussio.atomicidle.data.models.Stock
import kotlinx.coroutines.flow.Flow

@Dao
interface StockDao {
    @Query("SELECT * FROM stock LIMIT 1")
    fun getStock(): Stock

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(stock: Stock)

    @Update
    suspend fun update(stock: Stock)
}