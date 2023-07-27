package com.oswaldo.vixtest.home.data.dto


import com.google.gson.annotations.SerializedName

data class PageInfoX(
    @SerializedName("endCursor")
    val endCursor: String,
    @SerializedName("hasNextPage")
    val hasNextPage: Boolean,
    @SerializedName("hasPreviousPage")
    val hasPreviousPage: Boolean,
    @SerializedName("startCursor")
    val startCursor: String
)