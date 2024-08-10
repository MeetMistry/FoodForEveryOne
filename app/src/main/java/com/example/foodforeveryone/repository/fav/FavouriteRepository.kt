package com.example.foodforeveryone.repository.fav

import com.example.foodforeveryone.database.model.Food
import kotlinx.coroutines.flow.Flow

interface FavouriteRepository {

    suspend fun addItemToFav(item: Food)

    fun getFavItems(): Flow<List<Food>>

    suspend fun removeItemFromFav(item: Food)
}