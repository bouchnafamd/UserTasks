package com.example.taskuser.repositories.local

import com.example.taskuser.model.UserModel
import com.example.taskuser.repositories.UserRepository

class UserRepositoryLocalImpl : UserRepository {
    override suspend fun getAllUsers(): ArrayList<UserModel> {
        return arrayListOf(UserModel(1,"LocalName","LocalUserName","mail@test.com"))
    }
}