package com.example.dataterminal.retrofit_api

import com.example.dataterminal.data.AutRequest
import com.example.dataterminal.data.User
import retrofit2.http.Body
import retrofit2.http.HEAD
import retrofit2.http.POST

interface ApiRetro {

    @POST("/auth/login")
    suspend fun auth(@Body autRequest: AutRequest): User
}