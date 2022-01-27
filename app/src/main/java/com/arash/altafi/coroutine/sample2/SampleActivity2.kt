package com.arash.altafi.coroutine.sample2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.arash.altafi.coroutine.R

class SampleActivity2 : AppCompatActivity(), RemoteErrorEmitter {

    private val apiService: ApiService = RetrofitBuilder.api

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample2)

        init()
    }

    private fun init() {
        val thePosts = apiCall(this) { apiService.getPosts() }.observe(this) {
            if (it != null) {
                for (item in it) {
                    Log.d("test123321", item.title)
                }
            }
        }
        return thePosts
    }

    override fun onError(msg: String) {
        Log.e("test123321", msg)
    }

    override fun onError(errorType: ErrorType) {
        Log.e("test123321", "$errorType")
    }

}