package com.example.dataterminal

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.recyclerview.widget.GridLayoutManager
import com.example.dataterminal.adapters.ProductAdapter
import com.example.dataterminal.data.ProductX
import com.example.dataterminal.databinding.ActivityHomeBinding
import com.example.dataterminal.databinding.ItemMenuBinding
import com.example.dataterminal.retrofit_api.RetrofitApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Suppress("DEPRECATION")
class Home : AppCompatActivity() {
    private lateinit var adapter: ProductAdapter
    private lateinit var binding: ActivityHomeBinding
    private lateinit var bindingMenuBinding: ItemMenuBinding
    @SuppressLint("ObsoleteSdkInt")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        bindingMenuBinding = ItemMenuBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_home)
        setContentView(binding.root)






     //   val imgInfo = intent.getStringExtra("image")
     //   Picasso.get().load(imgInfo).into(binding.imPhoto)
     //   binding.tvHi.text = intent.getStringExtra("user")
        init()



    }

    fun init(){


        adapter = ProductAdapter{ product ->

            val intent = Intent(this@Home, InfoFood::class.java)
            println(product.id)
            intent.putExtra("code", product.id.toString())
            startActivity(intent)

        }
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