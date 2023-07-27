package com.oswaldo.vixtest.home.data.dto


import com.google.gson.annotations.SerializedName

data class PageAnalyticsMetadata(
    @SerializedName("keyValues")
    val keyValues: List<KeyValue>
)