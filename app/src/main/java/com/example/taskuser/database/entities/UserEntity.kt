package com.example.taskuser.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val USER_TABLE = "USER"

@Entity(tableName = USER_TABLE)
data class UserEntity(@PrimaryKey val userId: Long,
                      @ColumnInfo(name = "name") var name:String,
                      @ColumnInfo(name = "user_name") var userName : String,
                      @ColumnInfo(name = "mail") var mail : String)