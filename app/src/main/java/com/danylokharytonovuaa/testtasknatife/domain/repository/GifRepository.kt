package com.danylokharytonovuaa.testtasknatife.domain.repository

import com.danylokharytonovuaa.testtasknatife.domain.model.GifDomain
import com.danylokharytonovuaa.testtasknatife.domain.model.GifResultDomain

interface GifRepository {
    suspend fun getTrendGifs() : GifResultDomain

    suspend fun getGifById(id: String) : GifDomain
}