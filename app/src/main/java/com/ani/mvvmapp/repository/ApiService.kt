package com.ani.mvvmapp.repository

import com.ani.mvvmapp.ui.model.character.CharacterResponse
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    /**
     * Api to get the Character
     */
    @GET("character/")
    fun getCharacters(): Single<CharacterResponse>


}