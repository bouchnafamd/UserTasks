package com.example.taskuser.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.taskuser.database.dao.TaskDao
import com.example.taskuser.database.dao.UserDao
import com.example.taskuser.database.entities.TaskEntity
import com.example.taskuser.database.entities.UserEntity

@Database(entities = [UserEntity::class , TaskEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun taskDao(): TaskDao
}