package com.example.taskuser.repositories.local

import com.example.taskuser.database.dao.UserDao
import com.example.taskuser.database.mapping.UserEntityMapper
import com.example.taskuser.model.UserModel
import com.example.taskuser.repositories.UserRepository

class UserRepositoryLocalImpl(val userEntityMapper: UserEntityMapper,val userDao: UserDao ) : UserRepository {
    override suspend fun getAllUsers(): ArrayList<UserModel> {
        val userEntityList = userDao.getAllUsers()
        return userEntityMapper.toUserModelList(userEntityList)
    }

    override suspend fun saveUserList(listUser: ArrayList<UserModel>) {
        userDao.insertAllUsers(userEntityMapper.toUserEntityList(listUser))
    }
}