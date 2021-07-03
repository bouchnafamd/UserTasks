package com.example.taskuser.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.taskuser.commons.BaseViewModel
import com.example.taskuser.domain.UserUseCases
import com.example.taskuser.model.UserModel
import com.example.taskuser.utils.NO_ERROR
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(private val userUseCases: UserUseCases): BaseViewModel() {

    private val _listUser = MutableLiveData(ArrayList<UserModel>())
    val listUser : LiveData<ArrayList<UserModel>> get() = _listUser

    fun fetchUserList(){
        showLoading()
        viewModelScope.launch {
            val result = userUseCases.fetchAllUsers()
            withContext(Dispatchers.Main){
                hideLoading()
                if(result.isFailure()){
                    _errorMsg.value=result.error()
                }else{
                    _errorMsg.value= NO_ERROR
                    _listUser.value=result.result()
                }
            }
        }
    }
}