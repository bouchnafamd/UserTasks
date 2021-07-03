package com.example.taskuser.domain

import com.example.taskuser.R
import com.example.taskuser.model.UserModel
import com.example.taskuser.repositories.UserRepository
import com.example.taskuser.utils.data.Either
import com.example.taskuser.utils.data.Failure
import com.example.taskuser.utils.data.Success
import java.io.IOException
import java.net.UnknownHostException

class UserUseCasesImpl constructor(private val remoteUserRepository: UserRepository,
                                   private val localUserRepository: UserRepository) : UserUseCases {
    override suspend fun fetchAllUsers(): Either<ArrayList<UserModel>, Int> {
        var listUser: ArrayList<UserModel>
        try {
            listUser = remoteUserRepository.getAllUsers()
            localUserRepository.saveUserList(listUser)
        }catch (e : UnknownHostException){
            listUser = localUserRepository.getAllUsers()
        }catch (e : IOException){
            return Failure(R.string.general_error_message)
        }

        return if(listUser.isEmpty()){
            Failure(R.string.user_list_empty_message)
        }else{
            Success(listUser)
        }
    }
}