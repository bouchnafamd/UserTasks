package com.example.taskuser.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.taskuser.database.entities.TaskEntity

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllTask(listTask: ArrayList<TaskEntity>)

    @Query("SELECT * FROM TASK where userId = :userId")
    suspend fun getAllUserTasks(userId : Long): List<TaskEntity>

}