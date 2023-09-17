package com.danylokharytonovuaa.testtasknatife.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danylokharytonovuaa.testtasknatife.domain.model.GifDomain
import com.danylokharytonovuaa.testtasknatife.domain.model.GifResultDomain
import com.danylokharytonovuaa.testtasknatife.domain.use_cases.GetGifByIdUseCase
import com.danylokharytonovuaa.testtasknatife.presentation.adapters.base.MutableLiveResult
import com.danylokharytonovuaa.testtasknatife.presentation.utils.ErrorResult
import com.danylokharytonovuaa.testtasknatife.presentation.utils.SuccessResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.net.UnknownHostException
import javax.inject.Inject

//VM for gifFragment
@HiltViewModel
class GifViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getGifByIdUseCase: GetGifByIdUseCase
) : ViewModel() {
    //
    private val gifId = MutableLiveData("")
    val gif = MutableLiveResult<GifDomain>()
    private val loading = MutableLiveData(false)
    fun setGifId(id: String){
        gifId.value = id
        fetchGif()
    }

    fun fetchGif(){
        viewModelScope.launch {
            delay(2000L)
            try {
                val domainResult = SuccessResult(getGifByIdUseCase.execute(gifId.value!!))
                gif.postValue(domainResult)
                loading.value = true
            } catch (e: UnknownHostException){
                val errorResult = ErrorResult<GifDomain>(Exception("IllegalAccessError"))
                gif.postValue(errorResult)
                loading.value = true
            }
        }
    }
}