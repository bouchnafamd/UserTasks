package com.example.taskuser.repositories.mapping

import com.example.taskuser.jsonmodels.UserJson
import com.example.taskuser.model.UserModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserMapper @Inject constructor(){
    fun toUserModel(userJson: UserJson) = UserModel(
        userId = userJson.id,
        name = userJson.name,
        userName = userJson.username,
        mail = userJson.email
    )

    fun toUserModelList(listUserJson : List<UserJson>)
        = ArrayList(listUserJson.map { toUserModel(it) })
}