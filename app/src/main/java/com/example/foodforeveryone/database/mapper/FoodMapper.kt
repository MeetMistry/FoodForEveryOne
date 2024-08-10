package com.example.foodforeveryone.database.mapper

import com.example.foodforeveryone.database.entity.FoodEntity
import com.example.foodforeveryone.database.model.Food

fun Food.toFoodEntity(): FoodEntity = FoodEntity(
    id = id,
    image = image,
    name = name,
    ingredients = ingredients,
    price = price,
    time = time,
    distance = distance,
    ratings = ratings,
    deliveryInfo = deliveryInfo,
    returnPolicy = returnPolicy
)

fun FoodEntity.toFood(): Food = Food(
    id = id,
    image = image,
    name = name,
    ingredients = ingredients,
    price = price,
    time = time,
    distance = distance,
    ratings = ratings,
    deliveryInfo = deliveryInfo,
    returnPolicy = returnPolicy
)