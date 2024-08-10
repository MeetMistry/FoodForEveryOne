package com.example.foodforeveryone.ui.favourite

import androidx.lifecycle.ViewModel
import com.example.foodforeveryone.database.model.Food
import com.example.foodforeveryone.repository.fav.FavouriteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class FavouriteViewModel @Inject constructor(
    favouriteRepository: FavouriteRepository,
) : ViewModel() {

    val favItems: Flow<List<Food>> = favouriteRepository.getFavItems()
}