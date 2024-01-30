package com.shift.randomuser.model.api


import com.example.example.UserInfoResponse
import com.shift.randomuser.model.response.Results
import retrofit2.http.GET

interface UserApi {
    @GET("api/?inc=name%2Cpicture%2Clocation%2Cphone&results=100")
    suspend fun getUInfo(): List<UserInfoResponse>
}