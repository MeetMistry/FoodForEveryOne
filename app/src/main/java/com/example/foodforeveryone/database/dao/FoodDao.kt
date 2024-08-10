package com.example.foodforeveryone.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.foodforeveryone.database.entity.FoodEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(food: FoodEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(food: List<FoodEntity>)

    @Query("SELECT * FROM food")
    fun getFoodList(): Flow<List<FoodEntity>>

    @Query("DELETE FROM food")
    suspend fun deleteAll()
}
