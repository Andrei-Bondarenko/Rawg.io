package com.example.main_page.repository

import com.example.main_page.model.games.GamesData
import com.example.main_page.model.genres.GenresData

interface MainRepository {

    suspend fun getData(): List<GenresData>

    suspend fun getGamesData(genre: String): GamesData

}