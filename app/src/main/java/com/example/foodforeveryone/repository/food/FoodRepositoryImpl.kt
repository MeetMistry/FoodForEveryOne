package com.example.foodforeveryone.repository.food

import com.example.foodforeveryone.database.dao.FoodDao
import com.example.foodforeveryone.database.mapper.toFood
import com.example.foodforeveryone.database.mapper.toFoodEntity
import com.example.foodforeveryone.database.model.Food
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FoodRepositoryImpl @Inject constructor(
    private val foodDao: FoodDao,
) : FoodRepository {
    override suspend fun addFoodItem(foodItems: List<Food>) = withContext(Dispatchers.IO) {
        foodDao.insert(foodItems.map { it.toFoodEntity() })
    }

    override fun getFoodItems(): Flow<List<Food>> =
        foodDao.getFoodList().map { foodItems ->
            foodItems.map { it.toFood() }
        }.flowOn(Dispatchers.IO)

    override suspend fun deleteAll() = withContext(Dispatchers.IO) {
        foodDao.deleteAll()
    }
}
