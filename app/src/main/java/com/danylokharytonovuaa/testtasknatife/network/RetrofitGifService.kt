package com.danylokharytonovuaa.testtasknatife.network

import com.danylokharytonovuaa.testtasknatife.network.model.trending.GifNetwork
import com.danylokharytonovuaa.testtasknatife.network.model.trending.GifResultNetwork
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitGifService {
    @GET("v1/gifs/trending")
    suspend fun getTrendList(
        @Query("api_key") apiKey: String,
        @Query("limit") limit: String,
        @Query("rating") rating: String
    ): GifResultNetwork

    @GET("v1/gifs/{gif_id}")
    suspend fun getGifById(
        @Path("gif_id") id: String,
        @Query("api_key") apiKey: String
    ) : GifNetwork

    companion object {
        const val BASE_URL = "http://api.giphy.com/"
    }
}