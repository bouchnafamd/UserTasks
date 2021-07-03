package com.example.taskuser.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val TASK_TABLE = "TASK"


@Entity(tableName = TASK_TABLE)
data class TaskEntity(@PrimaryKey val taskId: Long,
                      @ColumnInfo(name = "userId") val userId : Long,
                      @ColumnInfo(name = "title") val title:String ,
                      @ColumnInfo(name = "completed") val completed : Boolean)