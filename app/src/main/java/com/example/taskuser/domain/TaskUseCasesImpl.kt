package com.example.taskuser.domain

import com.example.taskuser.R
import com.example.taskuser.model.TaskModel
import com.example.taskuser.repositories.TaskRepository
import com.example.taskuser.utils.data.Either
import com.example.taskuser.utils.data.Failure
import com.example.taskuser.utils.data.Success
import java.io.IOException
import java.net.UnknownHostException

class TaskUseCasesImpl(private val remoteTaskRepository: TaskRepository , private val localTaskRepository: TaskRepository) : TaskUseCases {
    override suspend fun fetchAllUserTask(userId: Long)  : Either<ArrayList<TaskModel>, Int> {
        var listUserTasks : ArrayList<TaskModel>
        try {
            listUserTasks=remoteTaskRepository.getUserTasks(userId)
            localTaskRepository.saveAllUserTasks(listUserTasks)
        }catch (e : UnknownHostException){
            listUserTasks=localTaskRepository.getUserTasks(userId)
        }catch (e : IOException){
            return Failure(R.string.general_error_message)
        }

        return if(listUserTasks.isEmpty()){
            Failure(R.string.user_list_task_empty_message)
        }else{
            Success(listUserTasks)
        }
    }
}