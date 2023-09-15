package com.danylokharytonovuaa.testtasknatife.data.repository

import com.danylokharytonovuaa.testtasknatife.domain.model.GifDomain
import com.danylokharytonovuaa.testtasknatife.domain.model.GifResultDomain
import com.danylokharytonovuaa.testtasknatife.domain.repository.GifRepository
import com.danylokharytonovuaa.testtasknatife.network.RetrofitGifService
import com.danylokharytonovuaa.testtasknatife.network.mappers.GifMapper
import com.danylokharytonovuaa.testtasknatife.network.mappers.TrendGifMapper
import javax.inject.Inject

class GifRepositoryImpl @Inject constructor(
    private val trendsMapper: TrendGifMapper,
    private val gifMapper: GifMapper,
    private val retrofitGifService: RetrofitGifService
) : GifRepository {
    override suspend fun getTrendGifs(): GifResultDomain {
        return trendsMapper.networkToDomain(retrofitGifService.getTrendList(
            apiKey = API_KEY,
            limit = LIMIT,
            rating = RATING
        ))
    }

    override suspend fun getGifById(id: String): GifDomain {
        return gifMapper.networkToDomain(retrofitGifService.getGifById(
            apiKey = API_KEY,
            id = id
        ))
    }

    companion object {
        const val API_KEY = "nnviO7X3tn4VUmHzWuxre3uyM6CNDdP4"
        const val LIMIT = "10"
        const val RATING = "g"
    }
}