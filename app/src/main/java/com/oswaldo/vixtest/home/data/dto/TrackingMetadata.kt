package com.oswaldo.vixtest.home.data.dto


import com.google.gson.annotations.SerializedName

data class TrackingMetadata(
    @SerializedName("advertisingMetadata")
    val advertisingMetadata: AdvertisingMetadata,
    @SerializedName("advertisingMetadataJson")
    val advertisingMetadataJson: AdvertisingMetadataJson,
    @SerializedName("analyticsMetadataJson")
    val analyticsMetadataJson: AnalyticsMetadataJson,
    @SerializedName("sharedMetadataJson")
    val sharedMetadataJson: SharedMetadataJson
)