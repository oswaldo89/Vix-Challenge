package com.oswaldo.vixtest.home.data.dto


import com.google.gson.annotations.SerializedName

data class VideoTypeDataX(
    @SerializedName("extraType")
    val extraType: String,
    @SerializedName("parents")
    val parents: List<Parent>,
    @SerializedName("playbackData")
    val playbackData: PlaybackDataX
)