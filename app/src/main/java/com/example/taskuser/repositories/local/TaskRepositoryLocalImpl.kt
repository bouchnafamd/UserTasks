package com.example.taskuser.repositories.local

import com.example.taskuser.database.dao.TaskDao
import com.example.taskuser.database.mapping.TaskEntityMapper
import com.example.taskuser.model.TaskModel
import com.example.taskuser.repositories.TaskRepository

class TaskRepositoryLocalImpl(private val taskEntityMapper: TaskEntityMapper,
                              private val taskDao: TaskDao) : TaskRepository{
    override suspend fun getUserTasks(userId: Long): ArrayList<TaskModel> {
        val taskEntityList = taskDao.getAllUserTasks(userId)
        return taskEntityMapper.toTaskModelList(taskEntityList)
    }

    override suspend fun saveAllUserTasks(taskList: ArrayList<TaskModel>) {
        taskDao.insertAllTask(taskEntityMapper.toTaskEntityList(taskList))
    }
}