package com.shift.randomuser.model.response

import com.example.example.Location
import com.example.example.Name
import com.example.example.Picture
import com.google.gson.annotations.SerializedName


data class Results (

  @SerializedName("name"     ) var name     : Name?     = Name(),
  @SerializedName("location" ) var location : Location? = Location(),
  @SerializedName("phone"    ) var phone    : String?   = null,
  @SerializedName("picture"  ) var picture  : Picture?  = Picture()

)