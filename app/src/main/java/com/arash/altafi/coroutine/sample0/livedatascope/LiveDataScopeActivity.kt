package com.arash.altafi.coroutine.sample0.livedatascope

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.arash.altafi.coroutine.databinding.ActivityLiveDataScopeBinding
import com.arash.altafi.coroutine.sample0.livedatascope.viewmodel.LiveDataScopeViewModel

class LiveDataScopeActivity : AppCompatActivity() {
    private val viewModel: LiveDataScopeViewModel by lazy {
        ViewModelProvider(this)[LiveDataScopeViewModel::class.java]
    }
    private val binding: ActivityLiveDataScopeBinding by lazy {
        ActivityLiveDataScopeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        onClickListener()
    }

    private fun onClickListener() {
        binding.button.setOnClickListener {
            viewModel.fetchFakeApi().observe(this) {
                setText(it)
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setText(result: String) {
        binding.message.text = binding.message.text.toString() + "\n" + result
    }
}