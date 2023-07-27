package com.oswaldo.vixtest.home.data.dto


import com.google.gson.annotations.SerializedName

data class AdvertisingMetadata(
    @SerializedName("adConfiguration")
    val adConfiguration: AdConfiguration,
    @SerializedName("adUnit")
    val adUnit: String
)