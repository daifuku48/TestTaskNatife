package com.danylokharytonovuaa.testtasknatife.network.model.trending

import com.google.gson.annotations.SerializedName

data class FixedHeightSmallNetwork(
    @SerializedName("url")
    val url: String,
    @SerializedName("height")
    val height: String,
    @SerializedName("width")
    val width: String
)
