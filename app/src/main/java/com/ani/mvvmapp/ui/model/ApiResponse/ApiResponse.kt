package com.ani.mvvmapp.ui.model.ApiResponse

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ApiResponse(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var name: String,
    var status: String,
    var species: String,
    var type: String,
    var gender: String,
    var image: String,
    var url: String,
    var created: String
)