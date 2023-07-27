package com.oswaldo.vixtest.home.data.dto


import com.google.gson.annotations.SerializedName

data class Contents(
    @SerializedName("edges")
    val edges: List<EdgeX>,
    @SerializedName("totalCount")
    val totalCount: Int
)