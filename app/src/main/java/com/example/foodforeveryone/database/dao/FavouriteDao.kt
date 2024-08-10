package com.example.foodforeveryone.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.foodforeveryone.database.entity.FavouriteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavouriteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(favFood: FavouriteEntity)

    @Query("SELECT * FROM favourite")
    fun getFavFoodList(): Flow<List<FavouriteEntity>>

    @Query("DELETE FROM favourite where id = :id")
    suspend fun deleteFavFood(id: Int)
}
