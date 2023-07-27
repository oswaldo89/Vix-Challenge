package com.oswaldo.vixtest.home.data.dto


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("uiPage")
    val uiPage: UiPage
)