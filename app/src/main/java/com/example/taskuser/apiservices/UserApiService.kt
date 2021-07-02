package com.example.taskuser.apiservices

import com.example.taskuser.jsonmodels.UserJson
import retrofit2.http.GET

interface UserApiService {
    @GET("user")
    suspend fun getAllUsers() : List<UserJson>
}