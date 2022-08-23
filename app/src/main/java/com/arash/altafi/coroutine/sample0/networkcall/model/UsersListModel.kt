package com.arash.altafi.coroutine.sample0.networkcall.model

import com.arash.altafi.coroutine.sample0.networkcall.model.UserModel


data class UsersListModel(
    val status: String,
    val message: String? = null,
    val userList: List<UserModel>? = null
)