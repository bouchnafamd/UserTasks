package com.example.taskuser.domain

import com.example.taskuser.model.TaskModel
import com.example.taskuser.utils.data.Either

interface TaskUseCases {
    suspend fun fetchAllUserTask(userId: Long) : Either<ArrayList<TaskModel>,Int>
}