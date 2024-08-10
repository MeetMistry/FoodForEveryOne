package com.example.foodforeveryone.ui.fooddetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodforeveryone.repository.cart.CartRepository
import com.example.foodforeveryone.database.model.Food
import com.example.foodforeveryone.repository.fav.FavouriteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodDetailViewModel @Inject constructor(
    private val cartRepository: CartRepository,
    private val favouriteRepository: FavouriteRepository
): ViewModel() {

    fun addItemToCart(item: Food) {
        viewModelScope.launch {
            cartRepository.insertFoodItemInCart(item)
        }
    }

    fun addToFavourite(item: Food) {
        viewModelScope.launch {
            favouriteRepository.addItemToFav(item)
        }
    }

    fun removeItemFromFavourite(item: Food) {
        viewModelScope.launch {
            favouriteRepository.removeItemFromFav(item)
        }
    }
}