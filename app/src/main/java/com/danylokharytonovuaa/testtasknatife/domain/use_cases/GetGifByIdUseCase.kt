package com.danylokharytonovuaa.testtasknatife.domain.use_cases

import com.danylokharytonovuaa.testtasknatife.domain.model.GifResultDomain
import com.danylokharytonovuaa.testtasknatife.domain.repository.GifRepository
import javax.inject.Inject

class GetGifByIdUseCase @Inject constructor(
    private val repository: GifRepository
) {
    suspend fun execute(id: String) : GifResultDomain {
        return repository.getGifById(id)
    }
}