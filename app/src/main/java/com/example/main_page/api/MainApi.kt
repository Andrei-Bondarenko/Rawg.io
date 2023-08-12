package com.example.main_page.api

import com.example.main_page.api.model.games.GamesDataResponse
import com.example.main_page.api.model.genres.DataResponse
import com.example.utils.Arguments
import retrofit2.http.GET
import retrofit2.http.Query

interface MainApi {
    @GET("api/genres")
    suspend fun getData(
        @Query("key") key: String = Arguments.API_KEY
    ): DataResponse

    @GET("api/games")
    suspend fun getGamesData(
        @Query("genres") genre: String,
        @Query("page") page: Int,
        @Query("key") key: String = Arguments.API_KEY
    ): GamesDataResponse
}