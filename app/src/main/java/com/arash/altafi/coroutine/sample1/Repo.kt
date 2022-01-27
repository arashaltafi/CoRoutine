package com.arash.altafi.coroutine.sample1

import android.util.Log
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class Repo(private val dataSource: UserDataSource = UserDataSource()) {

    fun getNameOfUsers() = dataSource.getUsers()
        .map { list ->
            list.map {
                it.name
            }
        }
        .catch { error ->
            Log.e("Flow Error", error.message ?: "Error")
        }
}