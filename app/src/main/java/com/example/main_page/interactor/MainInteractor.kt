package com.example.main_page.interactor

import com.example.main_page.model.games.GamesData
import com.example.main_page.repository.MainRepository
import com.example.rawgio.R
import timber.log.Timber

class MainInteractor(
    private val mainRepository: MainRepository
) {
    suspend fun getData() = mainRepository.getData()

    suspend fun getGamesData(genre: String): GamesData  {
        val data = mainRepository.getGamesData(genre = genre)
        Timber.d("INTERACTORDATA ====== $data")
      return  data
    }
}