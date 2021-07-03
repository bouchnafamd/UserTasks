package com.example.taskuser.apiservices

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UserApiServiceModule {
    @Provides
    @Singleton
    fun provideUserApiService(retrofit: Retrofit): UserApiService {
        return retrofit.create(UserApiService::class.java)
    }
}

@Module
@InstallIn(SingletonComponent::class)
object TaskApiServiceModule{
    @Provides
    @Singleton
    fun provideTaskApiService(retrofit: Retrofit):TaskApiService{
        return retrofit.create(TaskApiService::class.java)
    }

}