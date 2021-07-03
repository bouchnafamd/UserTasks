package com.example.taskuser.apiservices.mapping

import com.example.taskuser.apiservices.jsonmodels.TaskJson
import com.example.taskuser.model.TaskModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TaskJsonMapper @Inject constructor() {
    fun toTaskModel(taskJson: TaskJson) = TaskModel(
        taskId = taskJson.id,
        userId = taskJson.userId,
        title = taskJson.title,
        completed = taskJson.completed
    )

    fun toTaskModelList(listTaskJson : List<TaskJson>)
        = ArrayList(listTaskJson.map { toTaskModel(it) })
}