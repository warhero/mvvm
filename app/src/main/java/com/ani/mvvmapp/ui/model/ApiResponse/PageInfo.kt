package com.ani.mvvmapp.ui.model.ApiResponse

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PageInfo(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val count: Int,
    val pages: Int,
    val next: String,
    val prev: String
)