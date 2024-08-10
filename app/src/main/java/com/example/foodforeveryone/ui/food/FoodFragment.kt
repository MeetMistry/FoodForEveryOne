package com.example.foodforeveryone.ui.food

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.foodforeveryone.R
import com.example.foodforeveryone.databinding.FragmentFoodBinding
import com.example.foodforeveryone.ui.fooddetail.FoodDetailActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FoodFragment : Fragment() {

    private val viewModel: FoodViewModel by viewModels()
    private lateinit var binding: FragmentFoodBinding
    private val foodAdapter = FoodAdapter {
        val intent = Intent(requireContext(), FoodDetailActivity::class.java)
        intent.putExtra(FOOD_DETAIL, it)
        startActivity(intent)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentFoodBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.foodRecyclerView.adapter = foodAdapter
        lifecycleScope.launch {
            viewModel.foodItems.collectLatest {
                foodAdapter.setList(it)
            }
        }
    }

    companion object {
        const val FOOD_DETAIL = "food_details"
    }
}