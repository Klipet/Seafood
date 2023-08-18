package com.example.dataterminal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dataterminal.PostObject.CartMaster
import com.example.dataterminal.adapters.PhotoRAdapter
import com.example.dataterminal.data.Product
import com.example.dataterminal.data.ProductX
import com.example.dataterminal.databinding.ActivityInfoFoodBinding
import com.example.dataterminal.retrofit_api.RetrofitApi
import com.smarteist.autoimageslider.SliderView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class InfoFood : AppCompatActivity() {
    private lateinit var adapterImage: PhotoRAdapter
    private lateinit var binding: ActivityInfoFoodBinding
    lateinit var sliderView: SliderView
    private lateinit var cardMaster: CartMaster





    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityInfoFoodBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val code = intent.getStringExtra("code")
        CoroutineScope(Dispatchers.IO).launch {
            val productX = RetrofitApi.api.getProduct(code.toString())
            productX.enqueue(object : Callback<ProductX>{
                override fun onResponse(call: Call<ProductX>, response: Response<ProductX>) {
                    if (response.isSuccessful){
                        adapterImage = PhotoRAdapter()
                        runOnUiThread {
                            binding.apply {
                                val images: List<String> = response.body()!!.images
                                adapterImage.setImages(images)
                                sliderT.setSliderAdapter(adapterImage)
                                sliderT.autoCycleDirection = SliderView.LAYOUT_DIRECTION_LTR
                                tvDescription.text = response.body()!!.description
                                tvStock.text = response.body()!!.stock.toString()
                                tvTitle.text = response.body()!!.title
                                btAdd.setOnClickListener {
                                    val intent = Intent(this@InfoFood, CardActivity::class.java)
                                  //  intent.putExtra("product", response.body())
                                 //   intent.
                                //  cardMaster = CartMaster.addToCard()
                                }
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<ProductX>, t: Throwable) {

                }

            })



        }



    }




}