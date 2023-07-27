package com.oswaldo.vixtest.home.data.dto


import com.google.gson.annotations.SerializedName

data class UiPage(
    @SerializedName("pageAnalyticsMetadata")
    val pageAnalyticsMetadata: PageAnalyticsMetadata,
    @SerializedName("pageContentAvailability")
    val pageContentAvailability: PageContentAvailability,
    @SerializedName("pageName")
    val pageName: String,
    @SerializedName("uiModules")
    val uiModules: UiModules,
    @SerializedName("urlPath")
    val urlPath: String
)