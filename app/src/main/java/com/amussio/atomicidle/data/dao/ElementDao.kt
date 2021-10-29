package com.amussio.atomicidle.data.dao

import androidx.room.*
import com.amussio.atomicidle.data.models.Element

@Dao
interface ElementDao {

    @Query("SELECT * FROM element")
    fun getAllElements(): List<Element>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(element: Element)

    @Update
    suspend fun update(element: Element)

    @Query("DELETE FROM element WHERE name = :name")
    suspend fun deleteElement(name: String)

    @Query("DELETE FROM element")
    suspend fun deleteAllElements()

}