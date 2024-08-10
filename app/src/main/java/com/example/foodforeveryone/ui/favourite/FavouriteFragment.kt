package com.example.foodforeveryone.ui.favourite

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.foodforeveryone.R
import com.example.foodforeveryone.databinding.FragmentFavouriteBinding
import com.example.foodforeveryone.databinding.FragmentFoodBinding
import com.example.foodforeveryone.ui.food.FoodAdapter
import com.example.foodforeveryone.ui.food.FoodFragment.Companion.FOOD_DETAIL
import com.example.foodforeveryone.ui.food.FoodViewModel
import com.example.foodforeveryone.ui.fooddetail.FoodDetailActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FavouriteFragment : Fragment() {

    private val viewModel: FavouriteViewModel by viewModels()
    private lateinit var binding: FragmentFavouriteBinding
    private val favouriteAdapter = FavouriteAdapter {
        val intent = Intent(requireContext(), FoodDetailActivity::class.java)
        intent.putExtra(FOOD_DETAIL, it)
        startActivity(intent)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentFavouriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.favFoodRecyclerView.adapter = favouriteAdapter
        lifecycleScope.launch {
            viewModel.favItems.collectLatest {
                favouriteAdapter.setList(it)
            }
        }
    }
}