package com.example.main_page.model.games

import com.example.main_page.api.model.games.GamesDataResponse
import com.example.main_page.api.model.games.GamesResultsResponse
import com.example.main_page.api.model.games.GenresResponse
import com.example.main_page.api.model.games.PlatformResponse
import com.example.main_page.api.model.games.PlatformsResponse

object GamesDataConverter {

    fun fromNetwork(response: GamesDataResponse) =
        GamesData(
            results = fromNetworkResults(response.results)
        )

    private fun fromNetworkResults(response: List<GamesResultsResponse>) =
        response.map { data ->
            GamesResults(
                name = data.name,
                released = data.released,
                backround_image = data.background_image,
                rating = data.rating,
                ratings_count = data.ratings_count,
                updated = data.updated,
                platforms = fromNetworkPlatform(data.platforms),
                genres = fromNetworkGenres(data.genres)
            )
        }

    private fun fromNetworkPlatform(response: List<PlatformsResponse>) =
        response.map { data->
            Platforms(
                name = data.platform.name,
                image_background = data.platform.image_background
            )
        }

    private fun fromNetworkGenres(response: List<GenresResponse>) =
        response.map { data->
            Genres(
                name = data.name,
                image_background = data.image_background
            )
        }
}