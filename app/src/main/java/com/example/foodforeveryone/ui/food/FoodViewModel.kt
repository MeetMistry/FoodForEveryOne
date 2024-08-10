package com.example.foodforeveryone.ui.food

import androidx.lifecycle.ViewModel
import com.example.foodforeveryone.repository.food.FoodRepository
import com.example.foodforeveryone.database.model.Food
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import javax.inject.Inject

@HiltViewModel
class FoodViewModel @Inject constructor(
    foodRepository: FoodRepository
): ViewModel() {

    var foodItems: Flow<List<Food>> = foodRepository.getFoodItems()
}