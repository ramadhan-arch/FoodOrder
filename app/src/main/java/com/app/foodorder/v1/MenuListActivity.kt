package com.app.foodorder.v1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.foodorder.v1.adapter.FoodListAdapter
import com.app.foodorder.v1.data.FoodRepository
import com.app.foodorder.v1.databinding.ActivityMenuListBinding

class MenuListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi ViewBinding
        binding = ActivityMenuListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mengambil data makanan dari repository
        val foods = FoodRepository.getFoods()

        // Menghubungkan adapter ke ListView
        val adapter = FoodListAdapter(this, foods)
        binding.listFoods.adapter = adapter

        // Ketika item diklik → buka halaman detail
        binding.listFoods.setOnItemClickListener { _, _, position, _ ->

            val item = foods[position]

            val intent = Intent(this, FoodDetailActivity::class.java)
            intent.putExtra(FoodDetailActivity.EXTRA_FOOD_ID, item.id)

            startActivity(intent)
        }
    }
}