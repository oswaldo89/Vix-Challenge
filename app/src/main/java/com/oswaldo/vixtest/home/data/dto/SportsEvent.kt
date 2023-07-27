package com.oswaldo.vixtest.home.data.dto


import com.google.gson.annotations.SerializedName

data class SportsEvent(
    @SerializedName("awayTeam")
    val awayTeam: AwayTeam,
    @SerializedName("badges")
    val badges: List<String>,
    @SerializedName("id")
    val id: String,
    @SerializedName("localTeam")
    val localTeam: LocalTeam,
    @SerializedName("name")
    val name: String,
    @SerializedName("playbackData")
    val playbackData: PlaybackData,
    @SerializedName("tournament")
    val tournament: Tournament,
    @SerializedName("vodAvailability")
    val vodAvailability: VodAvailabilityX
)