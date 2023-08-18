package com.example.dataterminal

import android.annotation.SuppressLint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.dataterminal.adapters.ProductAdapter
import com.example.dataterminal.adapters.TabsAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.dataterminal.data.Category
import com.example.dataterminal.data.Product

import com.example.dataterminal.databinding.ActivityHomeBinding
import com.example.dataterminal.databinding.ItemMenuBinding
import com.example.dataterminal.fragment.ProductiaFragment
import com.example.dataterminal.retrofit_api.RetrofitApi
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Objects


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


         val category = RetrofitApi.api.getAllCategory()
         category.enqueue(object : Callback<Category>{
             override fun onResponse(call: Call<Category>, response: Response<Category>) {
                 if (response.isSuccessful){
                     val category = response.body()
                     if (category != null) {
                         val categories = listOf( category)
                         val fragments = categories.map { category ->
                             ProductiaFragment.newInstance(categories.toString())
                         }

                         adapterVP = TabsAdapter(this@Home,fragments)
                         viewPager2 = findViewById(R.id.vp)
                         viewPager2.adapter = adapterVP
                         TabLayoutMediator(tabLayout, viewPager2){
                                 tab, position ->
                            // tab.text = category[position].category

                                 tab.text = categories[position].category.toString()


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



             override fun onFailure(call: Call<Category>, t: Throwable) {
                 TODO("Not yet implemented")
             }
         })
     }


}