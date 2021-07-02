package com.example.taskuser.repositories.remote

import com.example.taskuser.apiservices.UserApiService
import com.example.taskuser.model.UserModel
import com.example.taskuser.repositories.UserRepository
import com.example.taskuser.repositories.mapping.UserMapper
import javax.inject.Inject

class UserRepositoryRemoteImpl @Inject constructor(private val userMapper: UserMapper, private val userApiService: UserApiService) : UserRepository {
    override suspend fun getAllUsers() = userMapper.toUserModelList(userApiService.getAllUsers())
}