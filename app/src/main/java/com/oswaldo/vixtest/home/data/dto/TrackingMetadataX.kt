package com.oswaldo.vixtest.home.data.dto


import com.google.gson.annotations.SerializedName

data class TrackingMetadataX(
    @SerializedName("advertisingMetadata")
    val advertisingMetadata: AdvertisingMetadataX,
)