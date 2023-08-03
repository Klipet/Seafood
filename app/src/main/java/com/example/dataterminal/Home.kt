package com.example.dataterminal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ListAdapter
import com.example.dataterminal.adapters.ProductAdapter
import com.example.dataterminal.databinding.ActivityHomeBinding
import com.example.dataterminal.retrofit_api.RetrofitApi
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Home : AppCompatActivity() {
    private lateinit var adapter: ProductAdapter
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_home)
        setContentView(binding.root)

     //   val imgInfo = intent.getStringExtra("image")
     //   Picasso.get().load(imgInfo).into(binding.imPhoto)
     //   binding.tvHi.text = intent.getStringExtra("user")
        init()

    }

    fun init(){
        adapter = ProductAdapter()
        binding.rcFoodCard.layoutManager = GridLayoutManager(this, 2)
        binding.rcFoodCard.adapter = adapter
        CoroutineScope(Dispatchers.IO).launch {
            val list = RetrofitApi.api.getAllProduct()
            runOnUiThread {
                binding.apply {
                    adapter.submitList(list.products)
                }
            }
        }
    }


}