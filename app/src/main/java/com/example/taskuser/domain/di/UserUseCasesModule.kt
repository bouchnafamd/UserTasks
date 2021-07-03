package com.example.taskuser.domain.di

import com.example.taskuser.domain.UserUseCases
import com.example.taskuser.domain.UserUseCasesImpl
import com.example.taskuser.repositories.UserRepository
import com.example.taskuser.utils.di.LocalSource
import com.example.taskuser.utils.di.RemoteSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UserUseCasesModule {
    @Provides
    fun provideUserUseCases(@RemoteSource remoteUserRepository: UserRepository , @LocalSource localUserRepository: UserRepository) : UserUseCases{
        return UserUseCasesImpl(remoteUserRepository,localUserRepository)
    }
}