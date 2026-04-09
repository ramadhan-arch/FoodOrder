package com.app.foodorder.v1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.app.foodorder.v1.databinding.ItemFoodRowBinding
import com.app.foodorder.v1.model.FoodItem
import java.text.NumberFormat
import java.util.Locale

class FoodListAdapter (
    context: Context,
    private val items: List<FoodItem>
) : ArrayAdapter<FoodItem> (context, 0, items) {
    private val rupiah = NumberFormat.getCurrencyInstance(Locale("id", "ID"))

    override fun getView(position: Int, convertView: View?, parent: ViewGroup) : View {
        val binding: ItemFoodRowBinding
        val view: View

        if (convertView == null) {
            binding = ItemFoodRowBinding.inflate(LayoutInflater.from(context), parent, false)
            view = binding.root
            view.tag = binding
        } else {
            view = convertView
            binding = view.tag as ItemFoodRowBinding
        }

        val item = items[position]
        binding.imgFood.setImageResource(item.imageResId)
        binding.tvName.text = item.name
        binding.tvRestaurant.text = item.restaurant
        binding.tvPrice.text = rupiah.format(item.price)
        binding.tvRating.text = "⭐ ${item.rating}"

        return view
    }
}