package com.example.taskuser.repositories.remote

import com.example.taskuser.apiservices.UserApiService
import com.example.taskuser.apiservices.mapping.UserJsonMapper
import com.example.taskuser.model.UserModel
import com.example.taskuser.repositories.UserRepository

class UserRepositoryRemoteImpl constructor(private val userJsonMapper: UserJsonMapper,
                                           private val userApiService: UserApiService) : UserRepository {
    override suspend fun getAllUsers() = userJsonMapper.toUserModelList(userApiService.getAllUsers())
    override suspend fun saveUserList(listUser: ArrayList<UserModel>) {

    }
}