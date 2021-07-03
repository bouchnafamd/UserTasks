package com.example.taskuser.repositories.di

import com.example.taskuser.apiservices.UserApiService
import com.example.taskuser.apiservices.mapping.UserJsonMapper
import com.example.taskuser.database.dao.UserDao
import com.example.taskuser.database.mapping.UserEntityMapper
import com.example.taskuser.repositories.UserRepository
import com.example.taskuser.repositories.local.UserRepositoryLocalImpl
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
    fun provideUserRepositoryRemote(userJsonMapper: UserJsonMapper , userApiService: UserApiService) : UserRepository {
        return UserRepositoryRemoteImpl(userJsonMapper,userApiService)
    }

    @LocalSource
    @Provides
    fun provideUserRepositoryLocal(userEntityMapper: UserEntityMapper,userDao: UserDao) : UserRepository {
        return UserRepositoryLocalImpl(userEntityMapper,userDao)
    }
}