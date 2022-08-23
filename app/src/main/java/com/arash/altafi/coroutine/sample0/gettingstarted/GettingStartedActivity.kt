package com.arash.altafi.coroutine.sample0.gettingstarted

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.arash.altafi.coroutine.databinding.ActivityGettingStartedBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GettingStartedActivity : AppCompatActivity() {
    private val binding: ActivityGettingStartedBinding by lazy {
        ActivityGettingStartedBinding.inflate(layoutInflater)
    }
    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        onClickListener()
    }

    private fun onClickListener() {
        binding.button.setOnClickListener {
            CoroutineScope(IO).launch {
                val result = fakeApiCall()
                setTextOnMainThread(result)
            }
        }
        binding.button2.setOnClickListener {
            CoroutineScope(IO).launch {
                val result = fakeApiCall()
                setTextOnMainThread2(result)
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private suspend fun setTextOnMainThread(result: String) {
        withContext(Main){
            binding.message.text = binding.message.text.toString() + "\n" + result
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setTextOnMainThread2(result: String) {
        lifecycleScope.launch {
            binding.message.text = binding.message.text.toString() + "\n" + result
        }
    }

    private suspend fun fakeApiCall(): String {
        delay(1000)
        return "Result ${count++}"
    }
}