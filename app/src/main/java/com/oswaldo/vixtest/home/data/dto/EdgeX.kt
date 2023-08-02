package com.oswaldo.vixtest.home.data.dto


import com.google.gson.annotations.SerializedName

data class EdgeX(
    @SerializedName("parent_cursor")
    var parentCursor: String,
    @SerializedName("cursor")
    val cursor: String,
    @SerializedName("node")
    val node: NodeX
)