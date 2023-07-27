package com.oswaldo.vixtest.home.data.dto


import com.google.gson.annotations.SerializedName

data class PlaybackData(
    @SerializedName("kickoffDate")
    val kickoffDate: String,
    @SerializedName("scheduledEndTime")
    val scheduledEndTime: String,
    @SerializedName("scheduledStartTime")
    val scheduledStartTime: String,
    @SerializedName("streamId")
    val streamId: String,
    @SerializedName("trackingMetadata")
    val trackingMetadata: TrackingMetadataXX
)