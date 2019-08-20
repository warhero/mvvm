package com.ani.mvvmapp.Persistance.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ani.mvvmapp.ui.model.ApiResponse.ApiResponse

@Dao
interface ResponseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPlaces(place: List<ApiResponse>)

    @Query("SELECT * FROM  ApiResponse")
    fun loadAllPlaces(): MutableList<ApiResponse>

}