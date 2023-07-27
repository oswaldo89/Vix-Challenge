package com.oswaldo.vixtest.home.data.dto


import com.google.gson.annotations.SerializedName

data class SharedMetadataJsonXX(
    @SerializedName("carousel_id")
    val carouselId: String,
    @SerializedName("carousel_title")
    val carouselTitle: String,
    @SerializedName("content_group")
    val contentGroup: String,
    @SerializedName("is_epg")
    val isEpg: String,
    @SerializedName("is_recommendation")
    val isRecommendation: String,
    @SerializedName("navigation_section")
    val navigationSection: String,
    @SerializedName("sports_away_team")
    val sportsAwayTeam: String,
    @SerializedName("sports_event_id")
    val sportsEventId: String,
    @SerializedName("sports_event_mcp_id")
    val sportsEventMcpId: String,
    @SerializedName("sports_event_title")
    val sportsEventTitle: String,
    @SerializedName("sports_home_team")
    val sportsHomeTeam: String,
    @SerializedName("sports_id")
    val sportsId: String,
    @SerializedName("sports_league_id")
    val sportsLeagueId: String,
    @SerializedName("sports_league_name")
    val sportsLeagueName: String,
    @SerializedName("sports_pckg")
    val sportsPckg: String,
    @SerializedName("sports_title")
    val sportsTitle: String,
    @SerializedName("stream_type")
    val streamType: String,
    @SerializedName("video_is_kids")
    val videoIsKids: String,
    @SerializedName("video_rating")
    val videoRating: String,
    @SerializedName("video_type")
    val videoType: String
)