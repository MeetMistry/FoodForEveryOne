package com.example.foodforeveryone.repository.di

import com.example.foodforeveryone.repository.cart.CartRepository
import com.example.foodforeveryone.repository.cart.CartRepositoryImpl
import com.example.foodforeveryone.repository.fav.FavouriteRepository
import com.example.foodforeveryone.repository.fav.FavouriteRepositoryImpl
import com.example.foodforeveryone.repository.food.FoodRepository
import com.example.foodforeveryone.repository.food.FoodRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindsFoodRepository(
        impl: FoodRepositoryImpl,
    ): FoodRepository

    @Binds
    fun bindsCartRepository(
        impl: CartRepositoryImpl,
    ): CartRepository

    @Binds
    fun bindsFavouriteRepository(
        impl: FavouriteRepositoryImpl,
    ): FavouriteRepository
}