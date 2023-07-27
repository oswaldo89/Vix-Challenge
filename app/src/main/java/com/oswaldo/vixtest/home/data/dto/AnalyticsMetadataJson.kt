package com.oswaldo.vixtest.home.data.dto


import com.google.gson.annotations.SerializedName

data class AnalyticsMetadataJson(
    @SerializedName("channel_number")
    val channelNumber: String,
    @SerializedName("channel_video_schedule_end_date")
    val channelVideoScheduleEndDate: String,
    @SerializedName("channel_video_schedule_start_date")
    val channelVideoScheduleStartDate: String
)