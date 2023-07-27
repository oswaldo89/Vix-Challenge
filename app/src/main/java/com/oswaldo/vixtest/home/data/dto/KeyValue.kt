package com.oswaldo.vixtest.home.data.dto


import com.google.gson.annotations.SerializedName

data class KeyValue(
    @SerializedName("key")
    val key: String,
    @SerializedName("value")
    val value: String
)