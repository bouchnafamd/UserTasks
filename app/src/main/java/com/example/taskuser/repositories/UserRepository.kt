package com.example.taskuser.repositories

import com.example.taskuser.model.UserModel

interface UserRepository {
    suspend fun getAllUsers() : ArrayList<UserModel>
    suspend fun saveUserList(listUser : ArrayList<UserModel>)
}