package com.app.foodorder.v1.model

data class FoodItem (
    val id: Int,
    val name: String,
    val price: Int,
    val restaurant: String,
    val rating: Double,
    val description: String,
    val imageResId: Int,
)