package com.arash.altafi.coroutine.sample0.networkcall.model


import com.arash.altafi.coroutine.sample0.networkcall.model.EmployeeModel
import com.google.gson.annotations.SerializedName

data class EmployeesListModel(
    @SerializedName("data")
    val employeesList: List<EmployeeModel>? = null,
    @SerializedName("status")
    val status: String,
    val message: String? = null,
)