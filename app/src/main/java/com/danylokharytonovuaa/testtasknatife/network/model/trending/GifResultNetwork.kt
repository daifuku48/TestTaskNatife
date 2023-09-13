package com.danylokharytonovuaa.testtasknatife.network.model.trending

import com.google.gson.annotations.SerializedName

data class GifResultNetwork(
    @SerializedName("data")
    val data: List<DataNetwork>
)