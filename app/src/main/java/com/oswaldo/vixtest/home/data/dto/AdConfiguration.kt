package com.oswaldo.vixtest.home.data.dto


import com.google.gson.annotations.SerializedName

data class AdConfiguration(
    @SerializedName("correlator")
    val correlator: String,
    @SerializedName("cust_params")
    val custParams: String,
    @SerializedName("description_url")
    val descriptionUrl: String,
    @SerializedName("env")
    val env: String,
    @SerializedName("gdfp_req")
    val gdfpReq: String,
    @SerializedName("impl")
    val impl: String,
    @SerializedName("iu")
    val iu: String,
    @SerializedName("npa")
    val npa: String,
    @SerializedName("server_url")
    val serverUrl: String,
    @SerializedName("ss_req")
    val ssReq: String,
    @SerializedName("sz")
    val sz: String,
    @SerializedName("tfcd")
    val tfcd: String,
    @SerializedName("unviewed_position_start")
    val unviewedPositionStart: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("vad_type")
    val vadType: String,
    @SerializedName("vconp")
    val vconp: String,
    @SerializedName("vpa")
    val vpa: String,
    @SerializedName("vpi")
    val vpi: String
)