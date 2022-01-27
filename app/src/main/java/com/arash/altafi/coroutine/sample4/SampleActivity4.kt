package com.arash.altafi.coroutine.sample4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.arash.altafi.coroutine.R
import com.google.android.material.button.MaterialButton
import kotlinx.coroutines.*

class SampleActivity4 : AppCompatActivity() {

    private lateinit var btnStart : MaterialButton
    private lateinit var btnCancel : MaterialButton
    private lateinit var txtTest : TextView
    private lateinit var job : Job
    private val maxCount = 10
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample4)

        init()
    }

    @DelicateCoroutinesApi
    private fun init() {
        findView()

        btnStart.setOnClickListener {
            if (!::job.isInitialized) {
                createJob()
            }
        }

        btnCancel.setOnClickListener {
            if (::job.isInitialized) {
                job.cancel()
            }
        }
    }

    @DelicateCoroutinesApi
    private fun createJob() {
        job = Job()
        job.invokeOnCompletion { throwable ->
            throwable?.message.let { message ->
                if (throwable != null) {
                    Toast.makeText(this, message , Toast.LENGTH_SHORT).show()
                }
            }
        }
        counter(job)
    }

    @DelicateCoroutinesApi
    private fun showToast(str :String) {
        GlobalScope.launch(Dispatchers.Main) {
            Toast.makeText(this@SampleActivity4, str , Toast.LENGTH_SHORT).show()
        }
    }

    @DelicateCoroutinesApi
    private fun counter(job : Job) {
        if (counter < maxCount) {
            CoroutineScope(Dispatchers.IO + job).launch {
                counter++
                showToast(counter.toString())
                delay(1000)
                createJob()
            }
        }
    }

    private fun findView() {
        btnStart = findViewById(R.id.btn_start)
        btnCancel = findViewById(R.id.btn_cancel)
        txtTest = findViewById(R.id.txt_test)
    }

}