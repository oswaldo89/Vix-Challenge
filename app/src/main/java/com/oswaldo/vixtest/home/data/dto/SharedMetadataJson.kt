package com.oswaldo.vixtest.home.data.dto


import com.google.gson.annotations.SerializedName

data class SharedMetadataJson(
    @SerializedName("carousel_id")
    val carouselId: String,
    @SerializedName("carousel_title")
    val carouselTitle: String,
    @SerializedName("channel_ads_key")
    val channelAdsKey: String,
    @SerializedName("channel_id")
    val channelId: String,
    @SerializedName("channel_title")
    val channelTitle: String,
    @SerializedName("content_group")
    val contentGroup: String,
    @SerializedName("epg_channel_type")
    val epgChannelType: String,
    @SerializedName("is_epg")
    val isEpg: String,
    @SerializedName("is_recommendation")
    val isRecommendation: String,
    @SerializedName("navigation_section")
    val navigationSection: String,
    @SerializedName("stream_type")
    val streamType: String,
    @SerializedName("video_content_genres")
    val videoContentGenres: String,
    @SerializedName("video_id_external")
    val videoIdExternal: String,
    @SerializedName("video_language")
    val videoLanguage: String,
    @SerializedName("video_rating")
    val videoRating: String,
    @SerializedName("video_supplier")
    val videoSupplier: List<String>,
    @SerializedName("video_title")
    val videoTitle: String,
    @SerializedName("video_type")
    val videoType: String
)