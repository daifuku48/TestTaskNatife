package com.danylokharytonovuaa.testtasknatife.network.model.trending

import com.google.gson.annotations.SerializedName

//Main data class for getting gif list
data class GifResultNetwork(
    @SerializedName("data")
    val data: List<DataNetwork>
)