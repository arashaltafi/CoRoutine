package com.arash.altafi.coroutine.sample0.coroutineflow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class ViewModelFlow: ViewModel() {

    private val _liveInfo = SingleLiveData<List<Int>>()
    val liveInfo: LiveData<List<Int>>
        get() = _liveInfo

    init {
        test1()
    }

    private fun <T> observeFlow(
        flow: Flow<T>,
        observeFunction: (T) -> Unit,
    ) = viewModelIO {
        flow.collect {
            observeFunction(it)
        }
    }

    /**
     * instead of [LiveData.postValue] use it
     * (when post multiple items at once! only last item will post!!)
     */
    private fun <T> MutableLiveData<T>.setSafeValue(t: T?) {
        viewModelScope.launch { value = t }
    }

    private fun test1() = flowIO {
        listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).also {
            emit(it)
        }
    }

    fun getData() {
        observeFlow(
            test1()
        ) { _liveInfo.setSafeValue(it) }
    }

}