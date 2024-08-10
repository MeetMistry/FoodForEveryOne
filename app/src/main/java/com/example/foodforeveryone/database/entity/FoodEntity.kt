package com.example.foodforeveryone.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("food")
data class FoodEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val image: String,
    val name: String,
    val ingredients: String,
    val price: String,
    val time: String,
    val distance: String,
    val ratings: String,
    val deliveryInfo: String,
    val returnPolicy: String
)
