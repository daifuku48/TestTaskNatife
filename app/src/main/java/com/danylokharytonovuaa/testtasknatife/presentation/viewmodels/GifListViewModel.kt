package com.danylokharytonovuaa.testtasknatife.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danylokharytonovuaa.testtasknatife.domain.model.GifResultDomain
import com.danylokharytonovuaa.testtasknatife.domain.use_cases.GetAllGifTrendsUseCase
import com.danylokharytonovuaa.testtasknatife.presentation.adapters.base.LiveResult
import com.danylokharytonovuaa.testtasknatife.presentation.adapters.base.MutableLiveResult
import com.danylokharytonovuaa.testtasknatife.presentation.utils.ErrorResult
import com.danylokharytonovuaa.testtasknatife.presentation.utils.SuccessResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.net.UnknownHostException
import javax.inject.Inject

//ViewModel for gifListFragment
@HiltViewModel
class GifListViewModel @Inject constructor(
    private val getAllGifTrendsUseCase: GetAllGifTrendsUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel(){
    private var _gifList = MutableLiveResult<GifResultDomain>()
    var gifList : LiveResult<GifResultDomain> = _gifList
    var loading = MutableLiveData(false)
    init {
        fetchGifList()
    }

    //Fetching data from REST API
    fun fetchGifList(){
        viewModelScope.launch {
            delay(3000L)
            try {
                val domainResult = SuccessResult(getAllGifTrendsUseCase.execute())
                _gifList.postValue(domainResult)
                loading.value = true
            } catch (e: UnknownHostException){
                val errorResult = ErrorResult<GifResultDomain>(Exception("IllegalAccessError"))
                _gifList.postValue(errorResult)
                loading.value = true
            }
        }
    }
}