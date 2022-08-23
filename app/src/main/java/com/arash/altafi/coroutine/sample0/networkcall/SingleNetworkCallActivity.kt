package com.arash.altafi.coroutine.sample0.networkcall

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.arash.altafi.coroutine.databinding.ActivitySingleNetworkCallBinding
import com.arash.altafi.coroutine.sample0.utils.*
import com.arash.altafi.coroutine.sample0.networkcall.adapter.SingleNetworkCallAdapter
import com.arash.altafi.coroutine.sample0.networkcall.model.EmployeeModel
import com.arash.altafi.coroutine.sample0.networkcall.model.EmployeesListModel
import com.arash.altafi.coroutine.sample0.networkcall.viewmodel.SingleNetworkCallViewModel

class SingleNetworkCallActivity : AppCompatActivity() {
    private val binding: ActivitySingleNetworkCallBinding by lazy {
        ActivitySingleNetworkCallBinding.inflate(layoutInflater)
    }
    private val viewModel: SingleNetworkCallViewModel by lazy {
        ViewModelProvider(this)[SingleNetworkCallViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        fetchUserList()
    }

    private fun fetchUserList() {
        viewModel.fetchEmployeesList().observe(this, ::handleState)
    }

    private fun handleState(state: Resource<EmployeesListModel>) {
        when (state) {
            is Resource.Loading -> {
                binding.progress.show()
                binding.recyclerView.gone()
            }
            is Resource.Success -> {
                binding.progress.gone()
                setRecyclerView(state.data?.employeesList)
            }
            is Resource.Error -> {
                binding.progress.gone()
                binding.recyclerView.gone()
                showToast(state.message)
            }
        }
    }

    private fun setRecyclerView(data: List<EmployeeModel>?) {
        data?.let {
            binding.recyclerView.show()
            binding.recyclerView.layoutManager = LinearLayoutManager(this)
            binding.recyclerView.adapter = SingleNetworkCallAdapter(it)
        } ?: also {
            binding.recyclerView.gone()
            showToast("Empty List...")
        }
    }
}