package com.example.taskuser.domain

import com.example.taskuser.model.UserModel
import com.example.taskuser.utils.data.Either

interface UserUseCases {
    suspend fun fetchAllUsers() : Either<ArrayList<UserModel>, Int>
}