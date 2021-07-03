package com.example.taskuser.apiservices

import com.example.taskuser.apiservices.jsonmodels.UserJson
import retrofit2.http.GET

interface UserApiService {
    @GET("users")
    suspend fun getAllUsers() : List<UserJson>
}