package com.example.dataterminal.retrofit_api

import com.example.dataterminal.data.AutRequest
import com.example.dataterminal.data.CategoryX
import com.example.dataterminal.data.Product
import com.example.dataterminal.data.ProductX
import com.example.dataterminal.data.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiRetro {

    @POST("/auth/login")
    suspend fun auth(@Body autRequest: AutRequest): User
    @GET("/product/category/{categori}")
     suspend fun getAllProduct(@Path("categori")category: String): Product
    @GET("/products/categories")
    suspend fun getAllCategory(): CategoryX

    @GET("/products/{code}")
     fun getProduct(@Path ("code") code: String): Call<ProductX>
}