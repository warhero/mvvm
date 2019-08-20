package com.ani.mvvmapp.ui.model.character

import com.ani.mvvmapp.ui.model.ApiResponse.ApiResponse
import com.ani.mvvmapp.ui.model.ApiResponse.PageInfo
import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("info")
    val info: PageInfo,
    @SerializedName("results")
    val result: MutableList<ApiResponse>
)