package com.arash.altafi.coroutine.sample0.livedatascope.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay

class LiveDataScopeViewModel(application: Application) : AndroidViewModel(application) {
    private var count: Int = 0

    /* We are creating a liveDataScope in IO thread. For that fakeApiCall() operation is done on IO thread.
     * liveDataScope automatically cancels the job when viewModel is destroyed
     */
    fun fetchFakeApi(): LiveData<String> = liveData(IO) {
        emit(fakeApiCall())
    }

    private suspend fun fakeApiCall(): String {
        delay(3000)
        Log.d("coroutineTest", Thread.currentThread().name)
        return "Result ${count++}"
    }
}