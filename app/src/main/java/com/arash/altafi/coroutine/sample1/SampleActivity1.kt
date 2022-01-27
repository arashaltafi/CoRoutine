package com.arash.altafi.coroutine.sample1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.arash.altafi.coroutine.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class SampleActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample1)

        init()
//        init2()
    }

    private fun init() {

        val repo = Repo()
        CoroutineScope(Dispatchers.Main).launch {
            repo.getNameOfUsers()
                .catch { error ->
                    Log.e("test123321",error.message?:"Error")
                }.collect {
                    it.forEach {
                        Log.d("test123321", "name is $it")
                    }
                }
        }

    }

    private fun init2() {
        CoroutineScope(Dispatchers.Main).launch {
            val ints: Flow<Int> = flow {
                for (i in 1..10) {
                    delay(200)
                    emit(i)
                }
            }
            ints.collect {
                Log.d("test123321", it.toString())
            }
        }
    }

}