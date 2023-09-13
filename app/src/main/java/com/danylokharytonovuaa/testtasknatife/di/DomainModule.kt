package com.danylokharytonovuaa.testtasknatife.di

import com.danylokharytonovuaa.testtasknatife.domain.repository.GifRepository
import com.danylokharytonovuaa.testtasknatife.domain.use_cases.GetAllGifTrendsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun providesGetAllTrendsUseCase(
        repository: GifRepository
    ) : GetAllGifTrendsUseCase {
        return GetAllGifTrendsUseCase(
            repository = repository
        )
    }
}