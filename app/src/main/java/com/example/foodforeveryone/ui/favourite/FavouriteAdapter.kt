package com.example.foodforeveryone.ui.favourite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodforeveryone.R
import com.example.foodforeveryone.databinding.FoodItemBinding
import com.example.foodforeveryone.database.model.Food

class FavouriteAdapter(private val onClick: (Food) -> Unit = {}) :
    RecyclerView.Adapter<FavouriteAdapter.FavouriteViewHolder>() {

    private val foodItem: MutableList<Food> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = FoodItemBinding.inflate(inflater, parent, false)
        return FavouriteViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return foodItem.size
    }

    override fun onBindViewHolder(holder: FavouriteViewHolder, position: Int) {
        holder.bind(foodItem[position])
    }

    inner class FavouriteViewHolder(private val binding: FoodItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(foodItem: Food) = with(binding) {
            foodImageView.setImageResource(R.drawable.food_1)
            foodNameTextView.text = foodItem.name
            foodIngredientTextView.text = foodItem.ingredients
            priceTextView.text = foodItem.price
            timeAndDistanceTextView.text = foodItem.time + "" + foodItem.distance
            ratingTextView.text = foodItem.ratings
            root.setOnClickListener { onClick.invoke(foodItem) }
        }
    }

    fun setList(items: List<Food>) {
        foodItem.clear()
        foodItem.addAll(items)
        notifyDataSetChanged()
    }
}