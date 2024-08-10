package com.example.foodforeveryone.repository.food

import com.example.foodforeveryone.database.model.Food
import kotlinx.coroutines.flow.Flow

interface FoodRepository {
    suspend fun addFoodItem(foodItems: List<Food>)

    fun getFoodItems(): Flow<List<Food>>

    suspend fun deleteAll()
}