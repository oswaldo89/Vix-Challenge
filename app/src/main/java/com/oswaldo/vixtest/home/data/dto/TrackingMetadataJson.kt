package com.oswaldo.vixtest.home.data.dto


import com.google.gson.annotations.SerializedName

data class TrackingMetadataJson(
    @SerializedName("ui_is_recommendation")
    val uiIsRecommendation: Boolean,
    @SerializedName("ui_module_id")
    val uiModuleId: String,
    @SerializedName("ui_module_title")
    val uiModuleTitle: String,
    @SerializedName("ui_navigation_section")
    val uiNavigationSection: String,
    @SerializedName("ui_object_type")
    val uiObjectType: String
)