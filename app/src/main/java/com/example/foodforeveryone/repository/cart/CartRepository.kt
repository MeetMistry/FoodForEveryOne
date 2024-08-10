package com.example.foodforeveryone.repository.cart

import com.example.foodforeveryone.database.model.Cart
import com.example.foodforeveryone.database.model.Food
import kotlinx.coroutines.flow.Flow

interface CartRepository {

    fun getCartItems(): Flow<List<Cart>>

    suspend fun insertFoodItemInCart(food: Food)
}