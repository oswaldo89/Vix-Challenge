package com.oswaldo.vixtest.home.data.dto


import com.google.gson.annotations.SerializedName

data class Schedule(
    @SerializedName("endDate")
    val endDate: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("imageAssets")
    val imageAssets: List<Any>,
    @SerializedName("startDate")
    val startDate: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("trackingMetadata")
    val trackingMetadata: TrackingMetadataX,
    @SerializedName("video")
    val video: Any,
    @SerializedName("vodAvailable")
    val vodAvailable: Boolean
)