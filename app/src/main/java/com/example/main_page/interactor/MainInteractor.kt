package com.example.main_page.interactor

import com.example.main_page.model.games.GamesResults
import com.example.main_page.repository.local.MainLocalRepository
import com.example.main_page.repository.remote.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

class MainInteractor(
    private val mainRepository: MainRepository,
    private val localRepository: MainLocalRepository
) {
    suspend fun getGamesData(genre: String, page: Int): List<GamesResults> =
         withContext(Dispatchers.IO) {
             val localData = localRepository.getGames(page, genre)
             Timber.d("INTERACTOR LOCALDATA ====== $localData")
             localData.ifEmpty {
                 val remoteData = mainRepository.getGamesData(genre, page)
                 Timber.d("INTERACTOR REMOTEDATA ====== $localData")
                 localRepository.setGames(remoteData)
                 remoteData
             }
         }

    suspend fun getGenres() =
        withContext(Dispatchers.IO) {
            val localData = localRepository.getGenres()
            localData.ifEmpty {
                val remoteData = mainRepository.getGenres()
                Timber.d("INTERACTOR GENRES ====== $remoteData")
                localRepository.setGenres(remoteData)
                remoteData
            }
        }
}