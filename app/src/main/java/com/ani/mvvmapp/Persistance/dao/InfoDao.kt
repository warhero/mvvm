package com.ani.mvvmapp.Persistance.dao

import androidx.room.Dao
import androidx.room.Insert
import com.ani.mvvmapp.ui.model.ApiResponse.PageInfo

@Dao
interface InfoDao {

    @Insert
    fun insertInfo(info: PageInfo)
}