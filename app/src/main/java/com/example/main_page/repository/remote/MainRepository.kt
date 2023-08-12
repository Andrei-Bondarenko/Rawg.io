package com.example.main_page.repository.remote

import com.example.main_page.model.games.GamesResults
import com.example.main_page.model.genres.GenresData

interface MainRepository {
    suspend fun getGamesData(genre: String, page: Int = 1): List<GamesResults>

    suspend fun getGenres(): List<GenresData>
}