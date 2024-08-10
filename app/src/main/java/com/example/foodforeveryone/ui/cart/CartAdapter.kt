package com.example.foodforeveryone.ui.cart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodforeveryone.R
import com.example.foodforeveryone.database.model.Cart
import com.example.foodforeveryone.database.model.Food
import com.example.foodforeveryone.databinding.CartItemBinding

class CartAdapter :
    RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    private val cartItem: MutableList<Cart> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CartItemBinding.inflate(inflater, parent, false)
        return CartViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return cartItem.size
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(cartItem[position])
    }

    class CartViewHolder(private val binding: CartItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Cart) = with(binding) {
            cartFoodImageView.setImageResource(R.drawable.food_2)
            cartFoodNameTextView.text = item.foodName
            cartFoodPriceTextView.text = item.foodPrice
        }
    }

    fun setList(items: List<Cart>) {
        cartItem.clear()
        cartItem.addAll(items)
        notifyDataSetChanged()
    }
}