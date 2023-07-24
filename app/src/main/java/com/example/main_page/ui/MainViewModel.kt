package com.example.main_page.ui

import com.example.common.mvvm.BaseViewModel
import com.example.main_page.interactor.MainInteractor
import com.example.main_page.model.games.GamesResults
import com.example.main_page.model.genres.GenresData
import com.example.main_page.ui.model.GamesUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.surfstudio.android.datalistpagecount.domain.datalist.DataList
import ru.surfstudio.android.easyadapter.pagination.PaginationState
import timber.log.Timber
import java.util.concurrent.CancellationException

class MainViewModel(
    private val interactor: MainInteractor
) : BaseViewModel() {

    private val _genresData = MutableStateFlow<List<GenresData>>(emptyList())
    val dataFlow = _genresData.asStateFlow()

    private val _gamesData = MutableStateFlow<GamesUi>(GamesUi())
    val gamesData = _gamesData.asStateFlow()

    private val _mainUi = MutableStateFlow<List<MainUi>>(emptyList())
    val mainUi = _mainUi.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    init {
        loadGenres()
    }

    companion object {
        private const val PAGE_SIZE = 20
    }

    fun loadGenres() {
        launch {
            try {
                Timber.d("CALLED FUNCTION GETDATA IN VIEWMODEL")
                _isLoading.value = true
                val data = interactor.getGenres()
                _genresData.emit(data)
                _mainUi.emit(addGenres(data))
            } catch (e: CancellationException) {
                Timber.e("VIEWMODEL CANCELATIONEXEPTION ===========", e.message)
            } catch (t: Throwable) {
                Timber.e("VIEWMODEL THROWABLE ========= $t")
            } finally {
                _isLoading.value = false
            }
        }

    }

    fun loadGames(genre: String, page: Int) {
        launch {
            try {
                _isLoading.value = true
                val data = interactor.getGamesData(genre, page)

                _mainUi.value = _mainUi.value.addNewGamesByGenre(
                    games = data,
                    genre = genre,
                    page = page,
                )
            } catch (e: CancellationException) {
                Timber.e("VIEWMODEL CANCELATIONEXEPTION ===========", e.message)
            } catch (t: Throwable) {
                Timber.e("VIEWMODEL THROWABLE ========= $t")
            } finally {
                _isLoading.value = false
            }
        }
    }

    private fun List<MainUi>.addNewGamesByGenre(
        games: List<GamesResults>,
        genre: String,
        page: Int,
    ): List<MainUi> =
        this.map { mainUi ->
            return@map when (mainUi) {
                is MainUi.GamesList -> {
                    if (mainUi.genre != genre) mainUi
                    else mainUi.copy(
                        games = mainUi.games.merge(
                            DataList(games, page, PAGE_SIZE)
                        ),
                        page = page + 1,
                        lastVisiblePosition = page * PAGE_SIZE - PAGE_SIZE
                    )
                }

                is MainUi.Genre -> mainUi
            }
        }

    private fun addGenres(genres: List<GenresData>): List<MainUi> {
        val mainUiList: MutableList<MainUi> = mutableListOf()
        genres.forEach {
            mainUiList.add(MainUi.Genre(it.name))

            mainUiList.add(
                MainUi.GamesList(
                    genre = it.slug,
                    games = DataList(emptyList(), 1, PAGE_SIZE),
                    paginationState = PaginationState.READY,
                    page = 1,
                    lastVisiblePosition = 0
                )
            )
        }
        return mainUiList
    }

}