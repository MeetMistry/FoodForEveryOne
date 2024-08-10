package com.example.foodforeveryone.ui.cart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodforeveryone.R
import com.example.foodforeveryone.ui.cart.model.Cart

class CartAdapter(private val cart: ArrayList<Cart>) :
    RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.cart_item, parent, false)
        return CartViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return cart.size
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val cartItem = cart[position]
        holder.image.setImageResource(R.drawable.food_2)
        holder.foodName.text = cartItem.foodName
        holder.foodPrice.text = cartItem.foodPrice
    }

    class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.cartFoodImageView)
        val foodName: TextView = itemView.findViewById(R.id.cartFoodNameTextView)
        val foodPrice: TextView = itemView.findViewById(R.id.cartFoodPriceTextView)
    }
}