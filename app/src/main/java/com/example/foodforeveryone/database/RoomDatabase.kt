package com.example.foodforeveryone.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.foodforeveryone.database.dao.CartDao
import com.example.foodforeveryone.database.dao.FavouriteDao
import com.example.foodforeveryone.database.dao.FoodDao
import com.example.foodforeveryone.database.entity.CartEntity
import com.example.foodforeveryone.database.entity.FavouriteEntity
import com.example.foodforeveryone.database.entity.FoodEntity

@Database(
    entities = [
        FoodEntity::class,
        CartEntity::class,
        FavouriteEntity::class
    ],
    version = 1,
    exportSchema = true
)
abstract class FoodForEveryOneDatabase: RoomDatabase() {

    abstract fun foodDao(): FoodDao

    abstract fun cartDao(): CartDao

    abstract fun favDao(): FavouriteDao

    companion object {
        @Volatile
        private var instance: FoodForEveryOneDatabase? = null

        fun buildDatabase(context: Context): FoodForEveryOneDatabase =
            instance ?: synchronized(this) {
                instance ?: let {
                    instance =
                        Room.databaseBuilder(context, FoodForEveryOneDatabase::class.java, "FoodForEveryOne")
                            .build()
                    instance!!
                }
            }
    }
}