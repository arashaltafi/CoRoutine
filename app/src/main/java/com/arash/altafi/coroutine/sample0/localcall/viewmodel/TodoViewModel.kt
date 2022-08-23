package com.arash.altafi.coroutine.sample0.localcall.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.arash.altafi.coroutine.sample0.localcall.model.TodoModel
import com.arash.altafi.coroutine.sample0.localcall.repository.TodoRepository
import kotlinx.coroutines.Dispatchers

class TodoViewModel(application: Application) : AndroidViewModel(application) {
    private val todoRepository: TodoRepository = TodoRepository.getInstance(getApplication())
    val todoList: LiveData<List<TodoModel>> get() = todoRepository.getTodoList()

//    fun fetchTodoList() = liveData(Dispatchers.IO) {
//        emit(TodoListState.Loading)
//        emit(todoRepository.addAllTodo())
//    }
//
//    fun deleteTodo(todoModel: TodoModel) = liveData(Dispatchers.IO) {
//        emit(TodoListState.Loading)
//        emit(todoRepository.deleteTodo(todoModel))
//    }

    fun addTodo(
        title: String,
        description: String
    ) = liveData(Dispatchers.IO) {

        emit(TodoState.Loading)

        emit(
            todoRepository.addTodo(
                title = title,
                description = description
            )
        )


    }

    sealed class TodoState {
        object Loading : TodoState()
        data class Success(val message: String?) : TodoState()
        data class Error(val status: Int, val message: String) : TodoState()
    }
}

