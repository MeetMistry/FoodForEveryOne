package com.example.foodforeveryone.repository.fav

import com.example.foodforeveryone.database.dao.FavouriteDao
import com.example.foodforeveryone.database.mapper.toFavouriteEntity
import com.example.foodforeveryone.database.mapper.toFood
import com.example.foodforeveryone.database.model.Food
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FavouriteRepositoryImpl @Inject constructor(
    private val favouriteDao: FavouriteDao,
) : FavouriteRepository {
    override suspend fun addItemToFav(item: Food) = withContext(Dispatchers.IO) {
        favouriteDao.insert(item.toFavouriteEntity())
    }

    override fun getFavItems(): Flow<List<Food>> =
        favouriteDao.getFavFoodList().map { favouriteEntity ->
            favouriteEntity.map { it.toFood() }
        }.flowOn(Dispatchers.IO)

    override suspend fun removeItemFromFav(item: Food) = withContext(Dispatchers.IO) {
        favouriteDao.deleteFavFood(item.id)
    }
}