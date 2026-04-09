package com.app.foodorder.v1.data

import com.app.foodorder.v1.R
import com.app.foodorder.v1.model.FoodItem

object FoodRepository {

    fun getFoods(): List<FoodItem> {
        return listOf(
            FoodItem(
                id = 1,
                name = "Nasi Goreng Kambing",
                restaurant = "Kedai Nasi Goreng Pak Amar",
                price = 28000,
                rating = 4.7,
                description = "Nasi goreng dengan daging kambing, telur mata sapi, dan sambal pedas.",
                imageResId = R.drawable.food_1
            ),
            FoodItem(
                id = 2,
                name = "Mie Ayam Bakso",
                restaurant = "Mie Ayam Bakso Enak",
                price = 25000,
                rating = 4.5,
                description = "Mie ayam bakso yang enak banget loh.",
                imageResId = R.drawable.food_2
            ),
            FoodItem(
                id = 3,
                name = "Ayam Geprek",
                restaurant = "Ayam Geprek Semeru",
                price = 28000,
                rating = 4.7,
                description = "Ayam Crispy digeprek sekuat tenaga dengan sambal super pedas",
                imageResId = R.drawable.food_3
            )
        )
    }
    fun getFoodById(id: Int) : FoodItem? = getFoods().find { it.id == id }
}