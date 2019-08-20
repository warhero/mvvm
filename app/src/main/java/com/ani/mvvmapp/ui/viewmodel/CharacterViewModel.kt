package com.ani.mvvmapp.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.ani.mvvmapp.Persistance.RickAndMortyDatabase
import com.ani.mvvmapp.R
import com.ani.mvvmapp.extentions.string
import com.ani.mvvmapp.extentions.toast
import com.ani.mvvmapp.repository.ApiRepository
import com.ani.mvvmapp.ui.model.ApiResponse.ApiResponse
import com.ani.mvvmapp.ui.model.UiModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CharacterViewModel(val context: Application) : AndroidViewModel(context) {

    var liveData: MutableLiveData<List<UiModel>>
    private var repository: ApiRepository
    private val compositeDisposable = CompositeDisposable()

    //initialize the data
    init {
        liveData = MutableLiveData()
        repository = ApiRepository()
        loadData()
    }

    /**
     * Method used to fetch the data
     */
    fun loadData() {
        val placesResposne = RickAndMortyDatabase.getDatabase(context).placesDao().loadAllPlaces()
        if (placesResposne.isEmpty()) {
            compositeDisposable.add(
                repository.fetchData()
                    .map { it ->
                        val database = RickAndMortyDatabase.getDatabase(context)
                        database.placesDao().insertPlaces(it.result)
                        it
                    }
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                        { result -> onSuccess(result.result) },
                        { error -> onApiFailure(error?.localizedMessage) }
                    )
            )
        } else {
            onSuccess(placesResposne)
        }
    }

    private fun onSuccess(response: List<ApiResponse>) {    //Callback
        val uiList: MutableList<UiModel> = mutableListOf()
        for (responseObj: ApiResponse in response) {
            uiList.add(
                UiModel(
                    appendName(responseObj.name),
                    appendSpecies(responseObj.species),
                    responseObj.image
                )
            )
        }
        liveData.value = uiList
    }

    private fun onApiFailure(error: String?) {
        val text = error ?: context.string(R.string.error_msg)
        context.toast(text)
    }

    /**
     * Append the name title to the response
     */
    private fun appendName(name: String): String {
        return "${context.string(R.string.Name)} $name"
    }

    /**
     * Append the species title to the response
     */
    private fun appendSpecies(species: String): String {
        return "${context.string(R.string.species)} $species"
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

}