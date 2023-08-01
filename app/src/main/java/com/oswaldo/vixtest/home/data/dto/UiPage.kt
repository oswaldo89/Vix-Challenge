package com.oswaldo.vixtest.home.data.dto


import com.google.gson.annotations.SerializedName

data class UiPage(
    @SerializedName("pageAnalyticsMetadata")
    val pageAnalyticsMetadata: PageAnalyticsMetadata? = null,
    @SerializedName("pageContentAvailability")
    val pageContentAvailability: PageContentAvailability? = null,
    @SerializedName("pageName")
    val pageName: String,
    @SerializedName("uiModules")
    val uiModules: UiModules? = null,
    @SerializedName("urlPath")
    val urlPath: String? = null,
    @SerializedName("selected")
    var selected: Boolean
)