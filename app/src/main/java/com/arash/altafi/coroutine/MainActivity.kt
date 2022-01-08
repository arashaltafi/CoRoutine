package com.arash.altafi.coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Flow
        viewModel = MainViewModel()
        flow1()

//////////////////////////////////////////////////////
        //Co Routine
        // way 1
//        MainScope().launch { init() }

        // way 2
        // Main - Default - io
//        CoroutineScope(Dispatchers.Default).launch { init() }

    }

    private fun flow1() {
        println(viewModel.test1.value)
        println(viewModel.test2.value)
    }

    // suspend was say this method is for coroutine
    private suspend fun init() {
        test1()
        test2()
        test3()
        test4()
        test5()
        test6()
    }

    // For create a new thread (like launch) for a task. But in rub blocking all of methods and tasks in main thread was blocking when this task in run blocking was finished.
    private suspend fun test1() = runBlocking {
        launch {
            repeat(3) {
                delay(500)
                println("Test 1")
            }
        }
        // async can return a value but launch cant
        async {
            println("Test 2")
        }
        println("Test 3")
    }

    private suspend fun test2() = coroutineScope {
        launch {
            delay(1000)
            println("Test 4")
        }
        println("Test 5")
    }

    private suspend fun test3() = coroutineScope {
        launch {
            delay(2000)
            println("Test 6")
        }
        launch {
            delay(1000)
            println("Test 7")
        }
        println("Test 8")
    }

    private suspend fun test4() {
        coroutineScope {
            val job = launch {
                println("Test 9")
            }
            delay(3000)
            job.cancel()
            println("Test 10")
            job.join()
            println("Test 11")
        }
    }

    private suspend fun test5() {
        withContext(Dispatchers.Default) {
            delay(4000)
            println("Test 12")
        }
    }

    private suspend fun test6() = coroutineScope {
        launch {
            delay(5000)
            println("Test 13")
        }
        println("Test 14")
    }


}