package com.example.taskuser.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.taskuser.database.dao.UserDao
import com.example.taskuser.database.entities.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}