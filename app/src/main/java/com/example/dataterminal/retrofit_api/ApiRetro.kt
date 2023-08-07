package com.example.dataterminal.retrofit_api

import com.example.dataterminal.data.AutRequest
import com.example.dataterminal.data.Product
import com.example.dataterminal.data.ProductX
import com.example.dataterminal.data.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.HEAD
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiRetro {

    @POST("/auth/login")
    suspend fun auth(@Body autRequest: AutRequest): User
    @GET("/products")
    suspend fun getAllProduct(): Product


    @GET("/products/{code}")
     fun getProduct(@Path ("code") code: String): Call<ProductX>
}