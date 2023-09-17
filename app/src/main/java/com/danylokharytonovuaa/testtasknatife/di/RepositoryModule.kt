package com.danylokharytonovuaa.testtasknatife.di

import com.danylokharytonovuaa.testtasknatife.data.repository.GifRepositoryImpl
import com.danylokharytonovuaa.testtasknatife.domain.repository.GifRepository
import com.danylokharytonovuaa.testtasknatife.network.RetrofitGifService
import com.danylokharytonovuaa.testtasknatife.network.mappers.GifMapper
import com.danylokharytonovuaa.testtasknatife.network.mappers.TrendGifMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//Hilt Module on Singleton for Repository
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesTrendGifMapper() : TrendGifMapper{
        return TrendGifMapper()
    }

    @Provides
    @Singleton
    fun providesGifMapper() : GifMapper {
        return GifMapper()
    }

    @Provides
    @Singleton
    fun providesRepository(
        trendGifMapper: TrendGifMapper,
        gifMapper: GifMapper,
        retrofitGifService: RetrofitGifService
    ): GifRepository {
        return GifRepositoryImpl(
            trendGifMapper,
            gifMapper,
            retrofitGifService
        )
    }
}