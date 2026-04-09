package com.app.foodorder.v1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.app.foodorder.v1.data.FoodRepository
import com.app.foodorder.v1.databinding.ActivityFoodDetailBinding
import java.text.NumberFormat
import java.util.Locale

class FoodDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_FOOD_ID = "extra_food_id"
    }

    private lateinit var binding: ActivityFoodDetailBinding

    private val rupiah = NumberFormat.getCurrencyInstance(
        Locale("id", "ID")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFoodDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getIntExtra(EXTRA_FOOD_ID, -1)
        val item = FoodRepository.getFoodById(id)

        if (item == null) {
            Toast.makeText(
                this,
                "Data menu tidak ditemukan",
                Toast.LENGTH_SHORT
            ).show()

            finish()
            return
        }

        binding.imgFood.setImageResource(item.imageResId)
        binding.tvName.text = item.name
        binding.tvMeta.text = "${item.restaurant} • ⭐ ${item.rating}"
        binding.tvPrice.text = rupiah.format(item.price)
        binding.tvDesc.text = item.description

        binding.btnAddToCart.setOnClickListener {
            Toast.makeText(
                this,
                "Ditambahkan: ${item.name}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}