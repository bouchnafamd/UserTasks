package com.example.taskuser.database.mapping

import com.example.taskuser.database.entities.UserEntity
import com.example.taskuser.model.UserModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserEntityMapper @Inject constructor(){
    fun toUserEntity(userModel: UserModel) = UserEntity(
        userId = userModel.userId,
        name = userModel.name,
        userName = userModel.userName,
        mail = userModel.mail
    )

    fun toUserEntityList(listUserModel : ArrayList<UserModel>)
            = ArrayList(listUserModel.map { toUserEntity(it) })

    fun toUserModel(userEntity: UserEntity)= UserModel(
        userId = userEntity.userId,
        name = userEntity.name,
        userName = userEntity.userName,
        mail = userEntity.mail
    )

    fun toUserModelList(listUserEntity : List<UserEntity>)
            = ArrayList(listUserEntity.map { toUserModel(it) })
}