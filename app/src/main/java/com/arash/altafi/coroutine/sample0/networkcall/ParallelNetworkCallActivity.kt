package com.arash.altafi.coroutine.sample0.networkcall

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.arash.altafi.coroutine.databinding.ActivityParallelNetworkCallBinding
import com.arash.altafi.coroutine.sample0.utils.*
import com.arash.altafi.coroutine.sample0.networkcall.model.EmployeeModel
import com.arash.altafi.coroutine.sample0.networkcall.viewmodel.ParallelNetworkCallViewModel

class ParallelNetworkCallActivity : AppCompatActivity() {
    private val binding: ActivityParallelNetworkCallBinding by lazy {
        ActivityParallelNetworkCallBinding.inflate(layoutInflater)
    }
    private val viewModel: ParallelNetworkCallViewModel by lazy {
        ViewModelProvider(this)[ParallelNetworkCallViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        fetchUsers()
        observers()
    }

    private fun observers() {
        viewModel.response.observe(this, ::handleState)
    }

    private fun fetchUsers() {
        viewModel.fetchUser()
    }

    private fun handleState(state: ParallelNetworkCallViewModel.Resource) {
        when (state) {
            is ParallelNetworkCallViewModel.Resource.Loading -> {
                binding.progress.show()
                binding.mainLayout.gone()
            }
            is ParallelNetworkCallViewModel.Resource.Success -> {
                binding.progress.gone()
                binding.mainLayout.show()
                setDataToViews(state.data, state.data1)
            }
            is ParallelNetworkCallViewModel.Resource.Error -> {
                binding.progress.gone()
                binding.mainLayout.gone()
                showToast(state.message)
            }
        }
    }

    private fun setDataToViews(data: EmployeeModel?, data1: EmployeeModel?) {
        binding.name.text = data?.employeeName
        binding.salary.text = data?.employeeSalary
        binding.age.text = data?.employeeAge

        binding.name1.text = data1?.employeeName
        binding.salary1.text = data1?.employeeSalary
        binding.age1.text = data1?.employeeAge
    }
}