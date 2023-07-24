package com.example.main_page.repository.remote

import com.example.main_page.api.MainApi
import com.example.main_page.model.games.GamesDataConverter
import com.example.main_page.model.games.GamesResults
import com.example.main_page.model.genres.DataConverter
import com.example.main_page.model.genres.GenresData
import timber.log.Timber

class MainRemoteRepository(
    private val api: MainApi
): MainRepository {
    override suspend fun getGamesData(genre: String, page: Int): List<GamesResults> {
        val data = api.getGamesData(genre = genre, page = page)
        Timber.d("GAMESDATA ========= $data")
        return GamesDataConverter.fromNetwork(data.results, genre)
    }

    override suspend fun getGenres(): List<GenresData> {
        val data = api.getData()
        Timber.d("DATA ========= $data")
        return DataConverter.fromNetwork(data.results)
    }



}