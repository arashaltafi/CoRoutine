package com.arash.altafi.coroutine

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.*

class MainViewModel() : ViewModel() {

    private val _test1 : MutableLiveData<String> = MutableLiveData()
    val test1 : MutableLiveData<String> = _test1

    init {
        test1.value = "Arash Altafi 1"
    }

    private val _test2 : MutableStateFlow<String> = MutableStateFlow("Arash Altafi 2")
    val test2 : StateFlow<String> = _test2

//    val test3 : StateFlow<String> = flow {
//        emit("Arash Altafi 3")
//    }.stateIn(
//        scope = CoroutineScope() ,
//        started = SharingStarted.WhileSubscribed(1000),
//        initialValue = "Arash Altafi 4"
//    )


}