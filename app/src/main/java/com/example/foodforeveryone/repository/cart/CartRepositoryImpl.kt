package com.example.foodforeveryone.repository.cart

import com.example.foodforeveryone.database.dao.CartDao
import com.example.foodforeveryone.database.mapper.toCart
import com.example.foodforeveryone.database.mapper.toCartEntity
import com.example.foodforeveryone.database.model.Cart
import com.example.foodforeveryone.database.model.Food
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CartRepositoryImpl @Inject constructor(
    private val cartDao: CartDao
) : CartRepository {

    override fun getCartItems(): Flow<List<Cart>> = cartDao.getCartFoodList().map { cartEntities ->
        cartEntities.map { it.toCart() }
    }.flowOn(Dispatchers.IO)

    override suspend fun insertFoodItemInCart(food: Food) = withContext(Dispatchers.IO) {
        val cartFood = Cart(
            image = food.image,
            foodName = food.name,
            foodPrice = food.price
        ).toCartEntity()
        cartDao.insert(cartFood)
    }
}
