package com.arash.altafi.coroutine.sample0.networkcall.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.arash.altafi.coroutine.sample0.utils.Resource
import com.arash.altafi.coroutine.sample0.networkcall.model.EmployeesListModel
import com.arash.altafi.coroutine.sample0.networkcall.respository.NetworkCallRepository
import kotlinx.coroutines.Dispatchers.IO

class SingleNetworkCallViewModel(application: Application) : AndroidViewModel(application) {

    fun fetchEmployeesList(): LiveData<Resource<EmployeesListModel>> = liveData(IO) {
        emit(Resource.Loading)
        val response = NetworkCallRepository.employeesList()
        if (response.status == "success") {
            emit(Resource.Success(response))
        } else {
            emit(Resource.Error<EmployeesListModel>(response.status, response.message))
        }
    }
}