package com.example.foodforeveryone

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.foodforeveryone.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        bottomNavigationView = binding.bottomNavigationView
        navController =
            (supportFragmentManager.findFragmentById(binding.navHostFragment.id) as NavHostFragment).navController

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.food_fragment -> {
                    navController.navigate(R.id.food_fragment)
                    true
                }

                R.id.favourite_fragment -> {
                    navController.navigate(R.id.favourite_fragment)
                    true
                }

                R.id.cart_fragment -> {
                    navController.navigate(R.id.cart_fragment)
                    true
                }

                else -> false
            }
        }
    }
}