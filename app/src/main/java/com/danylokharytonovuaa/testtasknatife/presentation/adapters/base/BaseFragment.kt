package com.danylokharytonovuaa.testtasknatife.presentation.adapters.base

import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.danylokharytonovuaa.testtasknatife.presentation.utils.ErrorResult
import com.danylokharytonovuaa.testtasknatife.presentation.utils.Result
import com.danylokharytonovuaa.testtasknatife.presentation.utils.SuccessResult


typealias LiveResult<T> = LiveData<Result<T>>
typealias MutableLiveResult<T> = MutableLiveData<Result<T>>

abstract class BaseFragment : Fragment() {

    //this method hide all elements and depend on result I can show it
    fun <T> renderResult(root: ViewGroup, result: Result<T>,
                         onError: (Exception) -> Unit,
                         onSuccess: (T) -> Unit) {

        root.children.forEach { it.visibility = View.GONE }
        when (result) {
            is SuccessResult<*> -> {
                onSuccess(result.data as T)
            }
            is ErrorResult<*> -> {
                onError(result.exception)
            }
        }
    }

}