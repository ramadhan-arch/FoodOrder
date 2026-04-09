package com.app.foodorder.v1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.foodorder.v1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // ViewBinding untuk activity_main.xml
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
    }

    private fun setupUI() {

        // Akses view dari layout include header
        binding.incHeader.tvGreeting.text = "Selamat datang 👋"
        binding.incHeader.tvLocation.text = "UPNVJ, Jakarta"

        // Akses view dari layout include search
        binding.incSearch.etSearch.hint = "Cari makanan, minuman, atau restoran"

        // Tombol explore → buka MenuListActivity
        binding.incPromo.btnExplore.setOnClickListener {
            val intent = Intent(this, MenuListActivity::class.java)
            startActivity(intent)
        }
    }
}