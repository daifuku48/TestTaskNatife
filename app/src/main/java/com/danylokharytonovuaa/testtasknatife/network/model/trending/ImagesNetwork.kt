package com.danylokharytonovuaa.testtasknatife.network.model.trending

import com.google.gson.annotations.SerializedName

data class ImagesNetwork(
    @SerializedName("fixed_height_small")
    val fixedHeightSmallStill: FixedHeightSmallNetwork
)
