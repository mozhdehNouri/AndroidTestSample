package com.example.androidtestsample.roomdatabase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ShoppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addShoppItem(item: ShoppEntity)

    @Delete
    suspend fun deleteShoppItem(item: ShoppEntity)

    @Query("select * from shopp_table")
    fun getAllShopItem(): Flow<List<ShoppEntity>>

    @Query("select SUM(price * amount) from shopp_table")
    fun observeTotalPrice(): Flow<Float>

}