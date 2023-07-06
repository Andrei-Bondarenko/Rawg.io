package com.example.main_page.api

import com.example.main_page.api.model.games.GamesDataResponse
import com.example.main_page.api.model.genres.DataResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MainApi {

    @GET("api/genres")
    suspend fun getData(
        @Query("key") key: String = "d2181ae3f27447199a3777f76003c0cd"
    ): DataResponse

    @GET("api/games")
    suspend fun getGamesData(
        @Query("genres") genre: String,
        @Query("key") key: String = "d2181ae3f27447199a3777f76003c0cd"
    ): GamesDataResponse
}