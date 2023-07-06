package com.example.main_page.interactor

import com.example.main_page.repository.MainRepository
import com.example.rawgio.R

class MainInteractor(
    private val mainRepository: MainRepository
) {
    suspend fun getData() = mainRepository.getData()

    suspend fun getGamesData(genre: String) = mainRepository.getGamesData(genre = genre)
}