package com.example.dataterminal.retrofit_api

import com.example.dataterminal.data.AutRequest
import com.example.dataterminal.data.Category
import com.example.dataterminal.data.Images
import com.example.dataterminal.data.ImagesProductX
import com.example.dataterminal.data.Product
import com.example.dataterminal.data.ProductX
import com.example.dataterminal.data.User
import retrofit2.Call
import retrofit2.Response
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
    @GET("/products/categories")
    fun getAllCategory(): Call<Category>

    @GET("/products/{code}")
     fun getProduct(@Path ("code") code: String): Call<ProductX>
}