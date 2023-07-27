package com.oswaldo.vixtest.home.data.dto


import com.google.gson.annotations.SerializedName

data class LocalTeam(
    @SerializedName("id")
    val id: String,
    @SerializedName("imageAssets")
    val imageAssets: List<ImageAsset>,
    @SerializedName("name")
    val name: String
)