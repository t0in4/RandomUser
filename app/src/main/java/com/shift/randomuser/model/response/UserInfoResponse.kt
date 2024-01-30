package com.example.example

import com.google.gson.annotations.SerializedName
import com.shift.randomuser.model.response.Results


data class UserInfoResponse (

    @SerializedName("results" ) var results : List<Results> = listOf(),
    @SerializedName("info"    ) var info    : List<Info>    = listOf()

)