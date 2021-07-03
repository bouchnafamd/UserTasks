package com.example.taskuser.apiservices

import com.example.taskuser.apiservices.jsonmodels.TaskJson
import retrofit2.http.GET
import retrofit2.http.Query

interface TaskApiService {
    @GET("todos")
    suspend fun getUserTasks(@Query("userId") userId : Long) : List<TaskJson>
}