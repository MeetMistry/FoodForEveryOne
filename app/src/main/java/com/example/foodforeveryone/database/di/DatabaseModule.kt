package com.example.foodforeveryone.database.di

import android.content.Context
import com.example.foodforeveryone.database.FoodForEveryOneDatabase
import com.example.foodforeveryone.database.dao.CartDao
import com.example.foodforeveryone.database.dao.FavouriteDao
import com.example.foodforeveryone.database.dao.FoodDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun provideFoodForEveryOneDatabase(@ApplicationContext context: Context): FoodForEveryOneDatabase =
        FoodForEveryOneDatabase.buildDatabase(context)

    @Provides
    fun provideFoodDao(appDatabase: FoodForEveryOneDatabase): FoodDao = appDatabase.foodDao()

    @Provides
    fun provideCartDao(appDatabase: FoodForEveryOneDatabase): CartDao = appDatabase.cartDao()

    @Provides
    fun provideFavDao(appDatabase: FoodForEveryOneDatabase): FavouriteDao = appDatabase.favDao()
}