package com.example.main_page.ui

import com.example.common.mvvm.BaseViewModel
import com.example.main_page.interactor.MainInteractor
import com.example.main_page.model.games.GamesResults
import com.example.main_page.model.genres.GenresData
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

    private val _mainUi = MutableStateFlow<List<MainUi>>(emptyList())
    val mainUi = _mainUi.asStateFlow()

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
                val data = interactor.getGenres()
                _genresData.emit(data)
                _mainUi.emit(addGenres(data))
            } catch (e: CancellationException) {
                Timber.e("VIEWMODEL CANCELATIONEXEPTION ===========", e.message)
            } catch (t: Throwable) {
                Timber.e("VIEWMODEL THROWABLE ========= $t")
            } finally {
            }
        }
    }

    fun loadGames(genre: String, page: Int) {
        launch {
            val lastMainUi = _mainUi.value.map {
                when(it) {
                    is MainUi.GamesList -> {
                        if(it.genre == genre) it.copy(
                            paginationState = PaginationState.READY
                        ) else it
                    }
                    is MainUi.Genre -> it
                }
            }
            try {
                val data = interactor.getGamesData(genre, page)

                _mainUi.value = _mainUi.value.addNewGamesByGenre(
                    games = data,
                    genre = genre,
                    page = page,
                )
            } catch (e: CancellationException) {
                Timber.e("VIEWMODEL CANCELATIONEXEPTION ===========", e.message)
            } catch (t: Throwable) {
                _mainUi.value = lastMainUi
                _mainUi.value = _mainUi.value.map {
                    when(it) {
                        is MainUi.GamesList -> {
                            if(it.genre == genre) it.copy(
                                paginationState = PaginationState.ERROR,
                                lastVisiblePosition = it.lastVisiblePosition + PAGE_SIZE + 1
                            ) else it
                        }
                        is MainUi.Genre -> it
                    }
                }
                Timber.e("VIEWMODEL THROWABLE ========= $t")
            }
            finally {
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
                        lastVisiblePosition = page * PAGE_SIZE - PAGE_SIZE,
                        paginationState = PaginationState.READY
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