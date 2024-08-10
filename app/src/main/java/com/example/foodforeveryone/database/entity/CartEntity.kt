package com.example.foodforeveryone.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("cart")
data class CartEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val image: String,
    val foodName: String,
    val price: String,
)
