package com.shift.randomuser.model.api

import com.example.example.UserInfoResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
class RetrofitInstance {
    private lateinit var api: UserApi
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://randomuser.me/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(UserApi::class.java)
    }
    suspend fun getUInfo(): UserInfoResponse {
        return api.getUInfo()
    }
}*/
object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://randomuser.me/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api: UserApi by lazy {
        retrofit.create(UserApi::class.java)
    }
}