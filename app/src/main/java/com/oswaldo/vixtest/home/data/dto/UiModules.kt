package com.oswaldo.vixtest.home.data.dto


import com.google.gson.annotations.SerializedName

data class UiModules(
    @SerializedName("edges")
    val edges: List<Edge>,
    @SerializedName("pageInfo")
    val pageInfo: PageInfoX,
    @SerializedName("totalCount")
    val totalCount: Int
)