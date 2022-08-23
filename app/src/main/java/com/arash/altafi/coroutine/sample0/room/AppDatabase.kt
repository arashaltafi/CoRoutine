package com.arash.altafi.coroutine.sample0.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.arash.altafi.coroutine.sample0.localcall.model.TodoModel

@Database(
    entities = [TodoModel::class],
    exportSchema = false,
    version = 1
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun appDAO(): AppDAO

    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            AppDatabase::class.java, "mytodos.db"
        ).build()
    }
}

