package com.example.taskuser.commons

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.taskuser.utils.NO_ERROR


open class BaseViewModel : ViewModel() {
    private val _loading = MutableLiveData(false)
    val loading : LiveData<Boolean> get() = _loading

    protected val _errorMsg = MutableLiveData(NO_ERROR)
    val errorMsg : LiveData<Int> get() = _errorMsg

    fun showLoading(){
        _loading.value=true
    }

    fun hideLoading(){
        _loading.value=false
    }
}