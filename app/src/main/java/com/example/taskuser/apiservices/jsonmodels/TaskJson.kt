package com.example.taskuser.apiservices.jsonmodels
import com.google.gson.annotations.SerializedName


data class TaskJson(
    @SerializedName("completed")
    val completed: Boolean,
    @SerializedName("id")
    val id: Long,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: Long
)