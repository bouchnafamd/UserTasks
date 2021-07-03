package com.example.taskuser.database.mapping

import com.example.taskuser.database.entities.TaskEntity
import com.example.taskuser.model.TaskModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TaskEntityMapper @Inject constructor() {
    fun toTaskEntity(taskModel : TaskModel) = TaskEntity(
        taskId = taskModel.taskId,
        userId = taskModel.userId,
        title = taskModel.title,
        completed = taskModel.completed
    )

    fun toTaskEntityList(listTaskModel : ArrayList<TaskModel>)
        = ArrayList(listTaskModel.map { toTaskEntity(it) })

    fun toTaskModel(taskEntity: TaskEntity) = TaskModel(
        taskId = taskEntity.taskId,
        userId = taskEntity.userId,
        title = taskEntity.title,
        completed = taskEntity.completed
    )

    fun toTaskModelList(listTaskEntity: List<TaskEntity>)
        = ArrayList(listTaskEntity.map { toTaskModel(it) })
}