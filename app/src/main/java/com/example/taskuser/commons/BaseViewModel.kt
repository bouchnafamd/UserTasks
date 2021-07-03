package com.example.taskuser.commons

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    private val _loading = MutableLiveData(false)
    val loading : LiveData<Boolean> get() = _loading

    fun showLoading(){
        _loading.value=true
    }

    fun hideLoading(){
        _loading.value=false
    }
}