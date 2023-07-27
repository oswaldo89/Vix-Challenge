package com.oswaldo.vixtest.home.data.dto


import com.google.gson.annotations.SerializedName

data class TrackingMetadataXX(
    @SerializedName("advertisingMetadata")
    val advertisingMetadata: AdvertisingMetadataXX,
    @SerializedName("analyticsMetadataJson")
    val analyticsMetadataJson: AnalyticsMetadataJsonXX,
    @SerializedName("sharedMetadataJson")
    val sharedMetadataJson: SharedMetadataJsonXX
)