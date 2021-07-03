package com.example.taskuser.utils.data

sealed class Either<out S, out F>{
    fun isSuccess() = this is Success
    fun isFailure() = this is Failure
    fun result() = (this as Success).value
    fun error() = (this as Failure).reason
}

data class Success<out S>(val value: S) : Either<S, Nothing>()
data class Failure<out F>(val reason: F) : Either<Nothing, F>()