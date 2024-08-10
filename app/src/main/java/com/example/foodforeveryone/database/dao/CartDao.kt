package com.example.foodforeveryone.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.foodforeveryone.database.entity.CartEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cartFood: CartEntity)

    @Query("SELECT * FROM cart")
    fun getCartFoodList(): Flow<List<CartEntity>>

    @Query("DELETE FROM cart where id = :id")
    suspend fun deleteCartFood(id: Int)
}
