package com.oswaldo.vixtest.home.data.dto


import com.google.gson.annotations.SerializedName

data class NodeX(
    @SerializedName("awayTeamLogo")
    val awayTeamLogo: AwayTeamLogo,
    @SerializedName("channel")
    val channel: Channel,
    @SerializedName("channelId")
    val channelId: String,
    @SerializedName("clickTrackingJson")
    val clickTrackingJson: ClickTrackingJson,
    @SerializedName("compositeImageLink")
    val compositeImageLink: String,
    @SerializedName("heroTarget")
    val heroTarget: HeroTarget,
    @SerializedName("heroTargetContentType")
    val heroTargetContentType: String,
    @SerializedName("image")
    val image: Image,
    @SerializedName("localTeamLogo")
    val localTeamLogo: LocalTeamLogo,
    @SerializedName("logoImage")
    val logoImage: LogoImage,
    @SerializedName("mobileFillImage")
    val mobileFillImage: MobileFillImage,
    @SerializedName("schedule")
    val schedule: Schedule,
    @SerializedName("sponsorMetadata")
    val sponsorMetadata: Any,
    @SerializedName("sportsEvent")
    val sportsEvent: SportsEvent,
    @SerializedName("sportsEventId")
    val sportsEventId: String,
    @SerializedName("stream")
    val stream: StreamX,
    @SerializedName("textTitle")
    val textTitle: String,
    @SerializedName("tournamentCardBackground")
    val tournamentCardBackground: TournamentCardBackground,
    @SerializedName("tournamentLogo")
    val tournamentLogo: TournamentLogo,
    @SerializedName("tournamentSplashBackground")
    val tournamentSplashBackground: TournamentSplashBackground,
    @SerializedName("video")
    val video: Video
)