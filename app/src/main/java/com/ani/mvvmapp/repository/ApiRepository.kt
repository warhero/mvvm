package com.ani.mvvmapp.repository

import com.ani.mvvmapp.repository.ApiProvider.getRetrofitService
import com.ani.mvvmapp.ui.model.character.CharacterResponse
import io.reactivex.Single

class ApiRepository {

    /**
     * Function used to get the character API data
     */
    fun fetchData(): Single<CharacterResponse> {
        return getRetrofitService().getCharacters()
    }
}
