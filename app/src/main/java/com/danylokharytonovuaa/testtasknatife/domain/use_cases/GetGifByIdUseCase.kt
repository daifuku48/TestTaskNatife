package com.danylokharytonovuaa.testtasknatife.domain.use_cases

import com.danylokharytonovuaa.testtasknatife.domain.model.GifDomain
import com.danylokharytonovuaa.testtasknatife.domain.repository.GifRepository
import javax.inject.Inject

class GetGifByIdUseCase @Inject constructor(
    private val repository: GifRepository
) {
    suspend fun execute(id: String) : GifDomain {
        return repository.getGifById(id)
    }
}