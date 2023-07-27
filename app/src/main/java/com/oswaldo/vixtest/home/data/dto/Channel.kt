package com.oswaldo.vixtest.home.data.dto


import com.google.gson.annotations.SerializedName

data class Channel(
    @SerializedName("badges")
    val badges: List<Any>,
    @SerializedName("channelAvailability")
    val channelAvailability: ChannelAvailability,
    @SerializedName("trackingMetadata")
    val trackingMetadata: TrackingMetadata
)