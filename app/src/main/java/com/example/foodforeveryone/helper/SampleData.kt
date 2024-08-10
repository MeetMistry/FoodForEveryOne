package com.example.foodforeveryone.helper

import com.example.foodforeveryone.database.model.Food

object SampleData {
    val sampleFoodData = listOf(
        Food(
            id = 0,
            image = "https://example.com/images/pizza.jpg",
            name = "Margherita Pizza",
            ingredients = "Tomato, Mozzarella, Basil",
            price = "$12.99",
            time = "30 mins",
            distance = "2.5 km",
            ratings = "4.5",
            deliveryInfo = "Free delivery for orders above $20",
            returnPolicy = "No returns on food items"
        ),
        Food(
            id = 1,
            image = "https://example.com/images/burger.jpg",
            name = "Cheeseburger",
            ingredients = "Beef Patty, Cheese, Lettuce, Tomato",
            price = "$8.99",
            time = "20 mins",
            distance = "3.2 km",
            ratings = "4.2",
            deliveryInfo = "Standard delivery charges apply",
            returnPolicy = "Returns accepted within 1 hour of delivery"
        ),
        Food(
            id = 2,
            image = "https://example.com/images/sushi.jpg",
            name = "Sushi Platter",
            ingredients = "Salmon, Tuna, Rice, Seaweed",
            price = "$22.50",
            time = "45 mins",
            distance = "1.8 km",
            ratings = "4.8",
            deliveryInfo = "Free delivery for premium members",
            returnPolicy = "No returns on sushi items"
        ),
        Food(
            id = 3,
            image = "https://example.com/images/pasta.jpg",
            name = "Spaghetti Carbonara",
            ingredients = "Spaghetti, Eggs, Pancetta, Parmesan",
            price = "$15.00",
            time = "35 mins",
            distance = "2.0 km",
            ratings = "4.6",
            deliveryInfo = "Delivery available within a 5 km radius",
            returnPolicy = "Return within 30 minutes for a full refund"
        ),
        Food(
            id = 4,
            image = "https://example.com/images/salad.jpg",
            name = "Caesar Salad",
            ingredients = "Romaine Lettuce, Croutons, Caesar Dressing",
            price = "$10.50",
            time = "15 mins",
            distance = "1.2 km",
            ratings = "4.3",
            deliveryInfo = "Fast delivery available",
            returnPolicy = "Return within 15 minutes for a full refund"
        )
    )
}