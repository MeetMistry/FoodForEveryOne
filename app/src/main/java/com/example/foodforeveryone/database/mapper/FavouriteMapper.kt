package com.example.foodforeveryone.database.mapper

import com.example.foodforeveryone.database.entity.FavouriteEntity
import com.example.foodforeveryone.database.model.Food

fun Food.toFavouriteEntity(): FavouriteEntity = FavouriteEntity(
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

fun FavouriteEntity.toFood(): Food = Food(
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