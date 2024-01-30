package com.shift.randomuser.model.response

import com.example.example.Location
import com.example.example.Name
import com.example.example.Picture
import com.google.gson.annotations.SerializedName


data class Results (

  @SerializedName("name"     ) var name     : List<Name>     = listOf(),
  @SerializedName("location" ) var location : List<Location> = listOf(),
  @SerializedName("phone"    ) var phone    : String?,
  @SerializedName("picture"  ) var picture  : List<Picture>  = listOf()

)