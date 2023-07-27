package com.oswaldo.vixtest.home.data.dto


import com.google.gson.annotations.SerializedName

data class Contributor(
    @SerializedName("name")
    val name: String,
    @SerializedName("roles")
    val roles: List<String>
)