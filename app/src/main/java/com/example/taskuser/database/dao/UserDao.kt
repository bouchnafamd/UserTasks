package com.example.taskuser.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.taskuser.database.entities.UserEntity
import com.example.taskuser.model.UserModel




@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllUsers(listUser : ArrayList<UserEntity>)

    @Query("SELECT * FROM USER")
    suspend fun getAllUsers(): List<UserEntity>
}