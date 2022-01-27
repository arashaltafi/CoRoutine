package com.arash.altafi.coroutine.sample1

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserDataSource {

    fun getUsers(): Flow<List<User>> = flow {

        emit(listOf(User(1, "Ali"), User(2, "Hassan"), User(3, "Hossein")))

        delay(3000)

        emit(listOf(User(1, "Hamed"), User(2, "Mahdi"), User(3, "Mohammad")))

        throw Exception("Http 403")

    }

}