package com.shift.randomuser.model.response

import com.example.example.Location
import com.example.example.Name
import com.example.example.Picture

data class ParentData(
    var name: List<Name>? = null,
    var location: List<Location>? = null,
    var phone: Results?,
    var picture: List<Picture>? = null

)
