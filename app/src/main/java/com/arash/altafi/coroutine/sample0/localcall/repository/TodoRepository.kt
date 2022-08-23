package com.arash.altafi.coroutine.sample0.localcall.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.arash.altafi.coroutine.sample0.localcall.model.TodoModel
import com.arash.altafi.coroutine.sample0.localcall.viewmodel.TodoViewModel
import com.arash.altafi.coroutine.sample0.room.AppDAO
import com.arash.altafi.coroutine.sample0.room.AppDatabase

class TodoRepository {
    companion object {
        private lateinit var instance: TodoRepository
        private lateinit var roomService: AppDAO

        fun getInstance(
            context: Context,
        ): TodoRepository {
            roomService = AppDatabase.invoke(context.applicationContext).appDAO()
            if (!Companion::instance.isInitialized) {
                instance = TodoRepository()
            }
            return instance
        }
    }

    suspend fun addTodo(
        title: String,
        description: String,
    ): TodoViewModel.TodoState {
        val addTodoLocal = roomService.addTodo(TodoModel(title = title,description = description))
        if (addTodoLocal > 0) {
            return TodoViewModel.TodoState.Success("Todo added")
        }
        return TodoViewModel.TodoState.Error(-1,"Failed")
    }


    fun getTodoList(): LiveData<List<TodoModel>> {
        return roomService.getAllTodos().asLiveData()
    }

}


