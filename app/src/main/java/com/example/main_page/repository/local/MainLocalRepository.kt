package com.example.main_page.repository.local

import com.example.main_page.model.games.GamesResults
import com.example.main_page.model.genres.GenresData

interface MainLocalRepository {

    suspend fun getGames(page: Int = 1, genre: String): List<GamesResults>

    suspend fun getGenres(): List<GenresData>

    suspend fun setGenres(genres: List<GenresData>)

    suspend fun setGames(games: List<GamesResults>)

}