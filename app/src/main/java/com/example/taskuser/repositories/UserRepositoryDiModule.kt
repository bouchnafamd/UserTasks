package com.example.taskuser.repositories

import com.example.taskuser.apiservices.UserApiService
import com.example.taskuser.repositories.mapping.UserMapper
import com.example.taskuser.repositories.remote.UserRepositoryRemoteImpl
import com.example.taskuser.utils.di.LocalSource
import com.example.taskuser.utils.di.RemoteSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UserRepositoryDiModule {
    @RemoteSource
    @Provides
    fun provideUserRepositoryRemote(userMapper: UserMapper , userApiService: UserApiService) : UserRepository{
        return UserRepositoryRemoteImpl(userMapper,userApiService)
    }
}