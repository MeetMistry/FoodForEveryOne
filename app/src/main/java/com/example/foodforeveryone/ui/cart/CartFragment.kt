package com.example.foodforeveryone.ui.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodforeveryone.R
import com.example.foodforeveryone.ui.cart.model.Cart

class CartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sampleCartData = arrayListOf(
            Cart(
                foodName = "Veggie tomato mix",
                foodPrice = "# 1,900"
            ),
            Cart(
                foodName = "Fish with mix orange",
                foodPrice = "# 1,900"
            ),
            Cart(
                foodName = "Veggie tomato mix",
                foodPrice = "# 1,900"
            ),
            Cart(
                foodName = "Fish with mix orange",
                foodPrice = "# 1,900"
            ),
            Cart(
                foodName = "Veggie tomato mix",
                foodPrice = "# 1,900"
            ),
            Cart(
                foodName = "Fish with mix orange",
                foodPrice = "# 1,900"
            ),
            Cart(
                foodName = "Veggie tomato mix",
                foodPrice = "# 1,900"
            ),
            Cart(
                foodName = "Fish with mix orange",
                foodPrice = "# 1,900"
            )
        )
        val recyclerView = view.findViewById<RecyclerView>(R.id.cartRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = CartAdapter(sampleCartData)
    }
}