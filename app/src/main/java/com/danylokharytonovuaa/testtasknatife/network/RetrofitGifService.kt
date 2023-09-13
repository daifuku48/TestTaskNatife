package com.danylokharytonovuaa.testtasknatife.network

import com.danylokharytonovuaa.testtasknatife.network.model.trending.GifResultNetwork
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitGifService {
    @GET("v1/gifs/trending")
    suspend fun getTrendList(
        @Query("api_key") apiKey: String,
        @Query("limit") limit: String,
        @Query("rating") rating: String
    ): GifResultNetwork

    companion object {
        const val BASE_URL = "https://api.giphy.com/"
    }
}