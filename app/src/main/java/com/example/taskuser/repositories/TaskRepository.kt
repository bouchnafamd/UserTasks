package com.example.taskuser.repositories

import com.example.taskuser.model.TaskModel

interface TaskRepository {
    suspend fun getUserTasks(userId: Long) : ArrayList<TaskModel>
    suspend fun saveAllUserTasks(taskList: ArrayList<TaskModel>)
}