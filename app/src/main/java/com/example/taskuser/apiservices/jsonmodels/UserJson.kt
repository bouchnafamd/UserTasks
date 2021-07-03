package com.example.taskuser.apiservices.jsonmodels

import com.google.gson.annotations.SerializedName

data class UserJson(
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("username")
    val username: String
)