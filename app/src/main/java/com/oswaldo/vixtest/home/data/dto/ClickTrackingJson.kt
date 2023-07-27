package com.oswaldo.vixtest.home.data.dto


import com.google.gson.annotations.SerializedName

data class ClickTrackingJson(
    @SerializedName("ui_content_group")
    val uiContentGroup: String,
    @SerializedName("ui_content_id")
    val uiContentId: String,
    @SerializedName("ui_content_title")
    val uiContentTitle: String,
    @SerializedName("ui_content_type")
    val uiContentType: String
)