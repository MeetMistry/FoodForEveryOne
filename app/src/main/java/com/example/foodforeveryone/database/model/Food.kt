package com.example.foodforeveryone.database.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Food(
    val id: Int,
    val image: String,
    val name: String,
    val ingredients: String,
    val price: String,
    val time: String,
    val distance: String,
    val ratings: String,
    val deliveryInfo: String,
    val returnPolicy: String
): Parcelable
