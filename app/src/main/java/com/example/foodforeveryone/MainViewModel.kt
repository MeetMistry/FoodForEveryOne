package com.example.foodforeveryone

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodforeveryone.helper.SampleData
import com.example.foodforeveryone.repository.food.FoodRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val foodRepository: FoodRepository,
) : ViewModel() {

    fun loadData() {
        viewModelScope.launch {
            foodRepository.deleteAll()
            foodRepository.addFoodItem(SampleData.sampleFoodData)
        }
    }
}
