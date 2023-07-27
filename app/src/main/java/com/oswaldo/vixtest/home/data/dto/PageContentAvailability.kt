package com.oswaldo.vixtest.home.data.dto


import com.google.gson.annotations.SerializedName

data class PageContentAvailability(
    @SerializedName("isBlocked")
    val isBlocked: Boolean,
    @SerializedName("reason")
    val reason: Any
)