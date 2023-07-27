package com.oswaldo.vixtest.home.data.dto


import com.google.gson.annotations.SerializedName

data class StreamMetadata(
    @SerializedName("duration")
    val duration: Int,
    @SerializedName("introEndPosition")
    val introEndPosition: Int,
    @SerializedName("introSkippable")
    val introSkippable: Boolean,
    @SerializedName("introStartPosition")
    val introStartPosition: Int,
    @SerializedName("outroSkippable")
    val outroSkippable: Boolean,
    @SerializedName("outroStartPosition")
    val outroStartPosition: Int
)