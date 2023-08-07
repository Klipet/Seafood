package com.example.dataterminal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dataterminal.data.ProductX
import com.example.dataterminal.databinding.ActivityInfoFoodBinding
import com.example.dataterminal.retrofit_api.RetrofitApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InfoFood : AppCompatActivity() {
    private lateinit var binding: ActivityInfoFoodBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityInfoFoodBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


       val codeAsl =  intent.getStringExtra("code")
        binding.tvId.text = codeAsl.toString()

        _init_()



    }

    fun _init_(){
        val get  = RetrofitApi.api.getProduct(intent.getStringExtra("code").toString())
        get.enqueue(object : Callback<ProductX>{
            override fun onResponse(call: Call<ProductX>, response: Response<ProductX>) {
                if (response.isSuccessful){
                    binding.tvId.text = response.body()?.description.toString()
                }
            }

            override fun onFailure(call: Call<ProductX>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

}