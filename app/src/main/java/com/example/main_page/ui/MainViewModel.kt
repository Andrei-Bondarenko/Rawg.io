package com.example.main_page.ui

import com.example.common.mvvm.BaseViewModel
import com.example.main_page.interactor.MainInteractor
import com.example.main_page.model.genres.GenresData
import com.example.main_page.ui.model.GamesUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.concurrent.CancellationException

class MainViewModel(
    private val interactor: MainInteractor
) : BaseViewModel() {

//    val gamesPagingFlow = pager
//        .flow
//        .map { pagingData ->
//            pagingData.map { it.toGamesData() }
//        }
//        .cachedIn(viewModelScope)

    private val _genresData = MutableStateFlow<List<GenresData>>(emptyList())
    val dataFlow = _genresData.asStateFlow()

    private val _gamesData = MutableStateFlow<GamesUi>(GamesUi())
    val gamesData = _gamesData.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    init {
        getData()
    }

    fun getData() {
        launch {
            try {
                Timber.d("CALLED FUNCTION GETDATA IN VIEWMODEL")
                _isLoading.value = true
                val data = interactor.getData()
                _genresData.emit(data)
            } catch (e: CancellationException) {
                Timber.e("VIEWMODEL CANCELATIONEXEPTION ===========", e.message)
            } catch (t: Throwable) {
                Timber.e("VIEWMODEL THROWABLE ========= $t")
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun getGamesData(genre: String) {
        launch {
            try {
                Timber.d("CALLED FUNCTION GETGAMESDATA IN VIEWMODEL")
                _isLoading.value = true
                val gamesData = interactor.getGamesData(genre = genre)
                val gamesUi = GamesUi(gamesData.results, genre)
                _gamesData.emit(gamesUi)
            } catch (e: CancellationException) {
                Timber.e("VIEWMODEL CANCELATIONEXEPTION ===========", e.message)
            } catch (t: Throwable) {
                Timber.e("VIEWMODEL THROWABLE ========= $t")
            } finally {
                _isLoading.value = false
            }
        }
    }

}