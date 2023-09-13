package com.danylokharytonovuaa.testtasknatife.network.model.trending

import com.google.gson.annotations.SerializedName

data class DataNetwork(
    @SerializedName("images")
    val images: ImagesNetwork,
    @SerializedName("id")
    val id: String,
    @SerializedName("rating")
    val rating: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("source")
    val source: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("username")
    val username: String
)