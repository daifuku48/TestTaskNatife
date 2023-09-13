package com.danylokharytonovuaa.testtasknatife.data.repository

import android.media.Rating
import com.danylokharytonovuaa.testtasknatife.domain.model.GifResultDomain
import com.danylokharytonovuaa.testtasknatife.domain.repository.GifRepository
import com.danylokharytonovuaa.testtasknatife.network.RetrofitGifService
import com.danylokharytonovuaa.testtasknatife.network.mappers.TrendGifMapper
import javax.inject.Inject

class GifRepositoryImpl @Inject constructor(
    private val mapper: TrendGifMapper,
    private val retrofitGifService: RetrofitGifService
) : GifRepository {
    override suspend fun getTrendGifs(): GifResultDomain {
        return mapper.networkToDomain(retrofitGifService.getTrendList(
            apiKey = API_KEY,
            limit = LIMIT,
            rating = RATING
        ))
    }

    companion object {
        const val API_KEY = "nnviO7X3tn4VUmHzWuxre3uyM6CNDdP4"
        const val LIMIT = "20"
        const val RATING = "g"
    }
}