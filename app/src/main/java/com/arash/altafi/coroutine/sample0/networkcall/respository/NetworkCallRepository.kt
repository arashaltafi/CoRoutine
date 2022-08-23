package com.arash.altafi.coroutine.sample0.networkcall.respository

import com.arash.altafi.coroutine.sample0.networkcall.model.EmployeeDetailsModel
import com.arash.altafi.coroutine.sample0.networkcall.model.EmployeesListModel
import com.arash.altafi.coroutine.sample0.networkcall.model.UsersListModel
import com.arash.altafi.coroutine.sample0.retrofit.RetrofitClient
import com.arash.altafi.coroutine.sample0.retrofit.RetrofitClient.BASE_URL1
import com.arash.altafi.coroutine.sample0.retrofit.RetrofitClient.BASE_URL2
import com.arash.altafi.coroutine.sample0.utils.checkConnectivityError
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object NetworkCallRepository {
    suspend fun employeesList(): EmployeesListModel {
        var response: EmployeesListModel
        withContext(Dispatchers.IO) {
            response = try {
                RetrofitClient.invoke(BASE_URL1).employeesList()
            } catch (e: Exception) {
                val error = checkConnectivityError(e)
                EmployeesListModel(status = error.status, message = error.message)
            }
        }
        return response
    }

    suspend fun employeeDetails(id: String): EmployeeDetailsModel {
        var response: EmployeeDetailsModel
        withContext(Dispatchers.IO) {
            response = try {
                RetrofitClient.invoke(BASE_URL1).employeeDetails(id)
            } catch (e: Exception) {
                val error = checkConnectivityError(e)
                EmployeeDetailsModel(status = error.status, message = error.message)
            }
        }
        return response
    }

    suspend fun userList(): UsersListModel {
        var response: UsersListModel
        withContext(Dispatchers.IO) {
            response = try {
                UsersListModel(status = "success", userList = RetrofitClient.invoke(BASE_URL2).userList())
            } catch (e: Exception) {
                val error = checkConnectivityError(e)
                UsersListModel(status = error.status, message = error.message)
            }
        }
        return response
    }
}