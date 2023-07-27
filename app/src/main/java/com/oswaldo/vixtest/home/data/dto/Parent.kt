package com.oswaldo.vixtest.home.data.dto


import com.google.gson.annotations.SerializedName

data class Parent(
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String
)