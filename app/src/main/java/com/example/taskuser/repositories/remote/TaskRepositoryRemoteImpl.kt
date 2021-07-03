package com.example.taskuser.repositories.remote

import com.example.taskuser.apiservices.TaskApiService
import com.example.taskuser.apiservices.mapping.TaskJsonMapper
import com.example.taskuser.model.TaskModel
import com.example.taskuser.repositories.TaskRepository

class TaskRepositoryRemoteImpl constructor(private val taskJsonMapper: TaskJsonMapper,
                                           private val taskApiService: TaskApiService) : TaskRepository {
    override suspend fun getUserTasks(userId: Long) = taskJsonMapper.toTaskModelList(taskApiService.getUserTasks(userId))
    override suspend fun saveAllUserTasks(taskList: ArrayList<TaskModel>) {
    }


}