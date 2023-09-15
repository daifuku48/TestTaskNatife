package com.danylokharytonovuaa.testtasknatife.network.model.trending

import com.google.gson.annotations.SerializedName

data class ImagesNetwork(
    @SerializedName("fixed_height")
    val fixedHeightSmall: FixedHeightSmallNetwork,
    @SerializedName("downsized_medium")
    val downsizedMedium: DownsizedMediumNetwork,
)
