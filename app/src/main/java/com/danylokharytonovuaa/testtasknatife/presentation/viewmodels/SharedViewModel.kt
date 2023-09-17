package com.danylokharytonovuaa.testtasknatife.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject



//ViewModel for share information between 2 fragments
@HiltViewModel
class SharedViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    //livedata for share id
    private val gifId = MutableLiveData("")

    fun getGifId() = gifId.value

    fun setGifId(id: String) {
        gifId.value = id
    }
}