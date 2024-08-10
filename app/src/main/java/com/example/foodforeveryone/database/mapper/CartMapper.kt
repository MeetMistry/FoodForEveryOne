package com.example.foodforeveryone.database.mapper

import com.example.foodforeveryone.database.entity.CartEntity
import com.example.foodforeveryone.database.model.Cart

fun Cart.toCartEntity(): CartEntity = CartEntity(
    image = image,
    foodName = foodName,
    price = foodPrice
)

fun CartEntity.toCart(): Cart = Cart(
    image = image,
    foodName = foodName,
    foodPrice = price
)