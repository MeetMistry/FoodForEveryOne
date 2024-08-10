package com.example.foodforeveryone.ui.cart

import androidx.lifecycle.ViewModel
import com.example.foodforeveryone.database.model.Cart
import com.example.foodforeveryone.repository.cart.CartRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val cartRepository: CartRepository,
) : ViewModel() {

    val cartItems: Flow<List<Cart>> = cartRepository.getCartItems()
}