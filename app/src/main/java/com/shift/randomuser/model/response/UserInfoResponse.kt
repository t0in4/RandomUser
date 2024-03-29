package com.example.example

import com.google.gson.annotations.SerializedName
import com.shift.randomuser.model.response.ParentData
import com.shift.randomuser.model.response.Results


data class UserInfoResponse (

    @SerializedName("results" ) var results : List<Results>,
    @SerializedName("info"    ) var info    : List<Info>

)