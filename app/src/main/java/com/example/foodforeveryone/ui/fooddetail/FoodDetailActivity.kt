package com.example.foodforeveryone.ui.fooddetail

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.foodforeveryone.R
import com.example.foodforeveryone.databinding.ActivityFoodDetailBinding
import com.example.foodforeveryone.database.model.Food
import com.example.foodforeveryone.ui.food.FoodFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoodDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFoodDetailBinding
    private var foodItem: Food? = null
    private val viewModel: FoodDetailViewModel by viewModels()
    private var isItemFav: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (intent.hasExtra(FoodFragment.FOOD_DETAIL)) {
            foodItem = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                intent.getParcelableExtra(FoodFragment.FOOD_DETAIL, Food::class.java)
            } else {
                intent.getParcelableExtra(FoodFragment.FOOD_DETAIL)
            }
            if (foodItem != null) {
                with(foodItem) {
                    binding.detailFoodNameTextView.text = this?.name.orEmpty()
                    binding.detailFoodPriceTextView.text = this?.price.orEmpty()
                    binding.detailFoodDeliveryInfo.text = this?.deliveryInfo.orEmpty()
                    binding.returnPolicyDetailTextView.text = this?.returnPolicy.orEmpty()
                }
            }
        }

        with(binding) {
            addToCartButton.setOnClickListener {
                foodItem?.let {
                    viewModel.addItemToCart(it)
                }
                Toast.makeText(this@FoodDetailActivity, "Item added to cart", Toast.LENGTH_SHORT)
                    .show()
            }

            heartImageView.setOnClickListener {
                isItemFav = !isItemFav
                if (isItemFav) {
                    heartImageView.setImageResource(R.drawable.ic_heart_fill)
                } else {
                    heartImageView.setImageResource(R.drawable.ic_heart)
                }
                foodItem?.let {
                    if (isItemFav) {
                        viewModel.addToFavourite(it)
                    } else {
                        viewModel.removeItemFromFavourite(it)
                    }

                }
                Toast.makeText(
                    this@FoodDetailActivity,
                    "Item added to favourite",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }

            backImageView.setOnClickListener {
                finish()
            }
        }
    }
}