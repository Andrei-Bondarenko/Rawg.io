package com.example.main_page.repository

import com.example.main_page.model.games.GamesData
import com.example.main_page.model.games.GamesResults
import com.example.main_page.model.genres.Results
import com.example.rawgio.R

interface MainRepository {

    suspend fun getData(): List<Results>

    suspend fun getGamesData(genre: String): GamesData

}