package com.example.main_page.ui

import com.example.common.mvvm.BaseViewModel
import com.example.main_page.interactor.MainInteractor
import com.example.main_page.model.games.GamesData
import com.example.main_page.model.games.GamesResults
import com.example.main_page.model.genres.Results
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.concurrent.CancellationException

class MainViewModel(
    private val interactor: MainInteractor
): BaseViewModel() {

    private val _dataFlow = MutableStateFlow<List<Results>>(emptyList())
    val dataFlow = _dataFlow.asStateFlow()

    private val _gamesData = MutableStateFlow<List<GamesResults>>(emptyList())
    val gamesData = _gamesData.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    init {
        getData("action")
    }

    fun getData(genre: String) {
        launch {
            try {
                _isLoading.value = true
                Timber.d("INTERACTOR.GETDATA")
                val data = interactor.getData()
                Timber.d("INTERACTOR.GETGAMESDATA")
                val gamesData = interactor.getGamesData(genre = genre)
                Timber.d("EMITTING DATA TO DATAFLOW")
                _dataFlow.emit(data)
                Timber.d("EMITTING DATA TO GAMESFLOW")
                _gamesData.emit(gamesData.results)
                delay(5000)
            } catch (e: CancellationException) {
                Timber.e("VIEWMODEL CANCELATIONEXEPTION ===========",e.message)
            } catch (t: Throwable) {
                Timber.e("VIEWMODEL THROWABLE =========", t.message)
            }finally {
                _isLoading.value = false
            }
        }
    }

}