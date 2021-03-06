package com.example.taskuser.domain.di

import com.example.taskuser.domain.TaskUseCases
import com.example.taskuser.domain.TaskUseCasesImpl
import com.example.taskuser.domain.UserUseCases
import com.example.taskuser.domain.UserUseCasesImpl
import com.example.taskuser.repositories.TaskRepository
import com.example.taskuser.repositories.UserRepository
import com.example.taskuser.utils.di.LocalSource
import com.example.taskuser.utils.di.RemoteSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UserUseCasesModule {
    @Provides
    @Singleton
    fun provideUserUseCases(@RemoteSource remoteUserRepository: UserRepository , @LocalSource localUserRepository: UserRepository) : UserUseCases{
        return UserUseCasesImpl(remoteUserRepository,localUserRepository)
    }
}

@Module
@InstallIn(SingletonComponent::class)
object TaskUseCasesModule {
    @Provides
    @Singleton
    fun provideTaskUseCases(@RemoteSource remoteTaskRepository: TaskRepository , @LocalSource localTaskRepository: TaskRepository ) : TaskUseCases{
        return TaskUseCasesImpl(remoteTaskRepository,localTaskRepository)
    }
}