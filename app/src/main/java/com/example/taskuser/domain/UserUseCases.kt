package com.example.taskuser.domain

import com.example.taskuser.model.UserModel

interface UserUseCases {
    suspend fun fetchAllUsers() : ArrayList<UserModel>
}