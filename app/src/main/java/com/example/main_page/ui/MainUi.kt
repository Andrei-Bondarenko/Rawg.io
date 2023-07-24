package com.example.main_page.ui

import com.example.main_page.model.games.GamesResults
import ru.surfstudio.android.datalistpagecount.domain.datalist.DataList
import ru.surfstudio.android.easyadapter.pagination.PaginationState

sealed class MainUi {

    data class Genre(val name: String) : MainUi()

    data class GamesList(
        val genre: String,
        val games: DataList<GamesResults>,
        val paginationState: PaginationState,
        val page: Int,
        val lastVisiblePosition: Int
    ) : MainUi()
}
