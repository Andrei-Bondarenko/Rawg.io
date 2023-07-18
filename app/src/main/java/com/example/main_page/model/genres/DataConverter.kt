package com.example.main_page.model.genres

import com.example.main_page.api.model.genres.GamesResponse
import com.example.main_page.api.model.genres.ResultsResponse

object DataConverter {

    fun fromNetwork(response: List<ResultsResponse>) =
        response.map { data ->
            GenresData(
                id = data.id,
                name = data.name,
                slug = data.slug,
                image_background = data.image_background,
                games = fromNetworkGames(data.games)
            )
    }

    private fun fromNetworkGames(response: List<GamesResponse>) =
        response.map { data ->
            Games(
                id = data.id,
                name = data.name
            )
        
    }

}