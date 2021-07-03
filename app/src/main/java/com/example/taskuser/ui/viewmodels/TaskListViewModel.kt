package com.example.taskuser.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.taskuser.commons.BaseViewModel
import com.example.taskuser.domain.TaskUseCases
import com.example.taskuser.model.TaskModel
import com.example.taskuser.utils.NO_ERROR
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class TaskListViewModel @Inject constructor(private val taskUseCases: TaskUseCases) : BaseViewModel(){
    private val _userTaskList = MutableLiveData<ArrayList<TaskModel>>()
    val userTaskList : LiveData<ArrayList<TaskModel>> get() = _userTaskList

    fun fetchTaskList(userId : Long){
        showLoading()
        viewModelScope.launch {
            val result = taskUseCases.fetchAllUserTask(userId)
            withContext(Dispatchers.Main){
                hideLoading()
                if(result.isFailure()){
                    _errorMsg.value=result.error()
                }else{
                    _errorMsg.value= NO_ERROR
                    _userTaskList.value=result.result()
                }
            }
        }
    }
}