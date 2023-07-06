package com.example.main_page.repository

import com.example.main_page.api.MainApi
import com.example.main_page.model.games.GamesData
import com.example.main_page.model.games.GamesDataConverter
import com.example.main_page.model.games.GamesResults
import com.example.main_page.model.genres.DataConverter
import com.example.main_page.model.genres.Results
import com.example.rawgio.R
import timber.log.Timber

class MainRemoteRepository(
    private val api: MainApi
): MainRepository {
    override suspend fun getData(): List<Results> {
        val data = api.getData()
        Timber.d("DATA ========= $data")
        return DataConverter.fromNetwork(data.results)
    }

    override suspend fun getGamesData(genre: String): GamesData {
        val data = api.getGamesData(genre = genre)
        Timber.d("GAMESDATA ========= $data")
        return GamesDataConverter.fromNetwork(data)
    }


}