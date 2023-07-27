package com.oswaldo.vixtest.home.data.dto


import com.google.gson.annotations.SerializedName

data class Rating(
    @SerializedName("ratingSubValues")
    val ratingSubValues: List<String>,
    @SerializedName("ratingValue")
    val ratingValue: String
)