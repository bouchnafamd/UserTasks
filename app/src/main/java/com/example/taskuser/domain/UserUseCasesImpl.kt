package com.example.taskuser.domain

import com.example.taskuser.model.UserModel
import com.example.taskuser.repositories.UserRepository
import com.example.taskuser.utils.di.RemoteSource
import javax.inject.Inject

class UserUseCasesImpl constructor(val remoteUserRepository: UserRepository , val localUserRepository: UserRepository) : UserUseCases {
    override suspend fun fetchAllUsers(): ArrayList<UserModel> {
        return remoteUserRepository.getAllUsers()
    }
}