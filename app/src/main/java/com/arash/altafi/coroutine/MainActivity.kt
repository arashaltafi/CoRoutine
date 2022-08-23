package com.arash.altafi.coroutine

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.arash.altafi.coroutine.sample0.SampleActivity0
import com.arash.altafi.coroutine.sample1.SampleActivity1
import com.arash.altafi.coroutine.sample2.SampleActivity2
import com.arash.altafi.coroutine.sample3.SampleActivity3
import com.google.android.material.button.MaterialButton
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var btnSample0 : MaterialButton
    private lateinit var btnSample1 : MaterialButton
    private lateinit var btnSample2 : MaterialButton
    private lateinit var btnSample3 : MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        findView()
        btnSample0.setOnClickListener {
            startActivity(Intent(this , SampleActivity0::class.java))
        }
        btnSample1.setOnClickListener {
            startActivity(Intent(this , SampleActivity1::class.java))
        }
        btnSample2.setOnClickListener {
            startActivity(Intent(this , SampleActivity2::class.java))
        }
        btnSample3.setOnClickListener {
            startActivity(Intent(this , SampleActivity3::class.java))
        }
    }

    private fun findView() {
        btnSample0 = findViewById(R.id.btn_sample_0)
        btnSample1 = findViewById(R.id.btn_sample_1)
        btnSample2 = findViewById(R.id.btn_sample_2)
        btnSample3 = findViewById(R.id.btn_sample_3)
    }

}