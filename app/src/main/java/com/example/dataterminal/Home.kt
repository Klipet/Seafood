package com.example.dataterminal

import android.annotation.SuppressLint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope

import com.example.dataterminal.adapters.TabsAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.dataterminal.data.CategoryX

import com.example.dataterminal.databinding.ActivityHomeBinding
import com.example.dataterminal.databinding.ItemMenuBinding
import com.example.dataterminal.fragment.ProductiaFragment
import com.example.dataterminal.retrofit_api.RetrofitApi
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Home : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var bindingMenuBinding: ItemMenuBinding
    private lateinit var adapterVP: TabsAdapter
    private lateinit var viewPager2: ViewPager2

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

        getCategory()
    }




     fun getCategory() = with (binding) {

         lifecycleScope.launch {
             val category = RetrofitApi.api.getAllCategory()

             val categories = listOf( category)
             //val fragments = categories.map { category ->
             //     ProductiaFragment.newInstance(categories.toString())
             // }

             adapterVP = TabsAdapter(this@Home,category)
             viewPager2 = findViewById(R.id.vp)
             viewPager2.adapter = adapterVP
             TabLayoutMediator(tabLayout, viewPager2){
                     tab, position ->
                 tab.text = category[position]
             }.attach()

         }


       //              val grup = response.body()!!.products.groupBy { it.category }
     //                for ((category, products) in grup) {
     //

     //
     //
     //                    val tab = binding.tabLayout
     //                    val viewPager2 = binding.vp
     //
     //                    println("Категория: $category")
     //                    for (product in products) {
     //                        println("  - Продукт: ${product.title}")


     }


}