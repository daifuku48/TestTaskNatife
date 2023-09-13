package com.danylokharytonovuaa.testtasknatife.domain.model

data class DataDomain(
    val images: ImagesDomain,
    val id: String,
    val rating: String,
    val slug: String,
    val source: String,
    val title: String,
    val type: String,
    val url: String,
    val username: String
)