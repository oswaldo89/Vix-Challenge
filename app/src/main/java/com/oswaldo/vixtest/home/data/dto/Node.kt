package com.oswaldo.vixtest.home.data.dto


import com.google.gson.annotations.SerializedName

data class Node(
    @SerializedName("caption")
    val caption: Any,
    @SerializedName("contents")
    val contents: Contents,
    @SerializedName("id")
    val id: String,
    @SerializedName("isLive")
    val isLive: Boolean,
    @SerializedName("landscapeFillImage")
    val landscapeFillImage: LandscapeFillImageX,
    @SerializedName("leagueId")
    val leagueId: Any,
    @SerializedName("moduleType")
    val moduleType: String,
    @SerializedName("portraitFillImage")
    val portraitFillImage: PortraitFillImageX,
    @SerializedName("scrollingTimeSeconds")
    val scrollingTimeSeconds: Any,
    @SerializedName("sportId")
    val sportId: Any,
    @SerializedName("sportsEventCarouselType")
    val sportsEventCarouselType: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("trackingId")
    val trackingId: String,
    @SerializedName("trackingMetadataJson")
    val trackingMetadataJson: TrackingMetadataJson,
    @SerializedName("treatment")
    val treatment: String
)