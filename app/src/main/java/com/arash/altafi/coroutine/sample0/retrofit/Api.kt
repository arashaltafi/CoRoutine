package com.arash.altafi.coroutine.sample0.retrofit

import com.arash.altafi.coroutine.sample0.networkcall.model.EmployeeDetailsModel
import com.arash.altafi.coroutine.sample0.networkcall.model.EmployeesListModel
import com.arash.altafi.coroutine.sample0.networkcall.model.UserModel
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("employees")
    suspend fun employeesList(): EmployeesListModel

    @GET("employee/{id}")
    suspend fun employeeDetails(@Path("id") id : String): EmployeeDetailsModel

    @GET("users")
    suspend fun userList(): List<UserModel>
}