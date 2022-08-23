package com.arash.altafi.coroutine.sample0.room

import androidx.room.*
import com.arash.altafi.coroutine.sample0.localcall.model.TodoModel
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTodo(todoModel: TodoModel) : Long

    @Delete
    fun deleteTodo(todoModel: TodoModel)

    @Query("SELECT * FROM todo")
     fun getAllTodos(): Flow<List<TodoModel>>
}