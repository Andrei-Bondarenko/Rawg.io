package com.example.main_page.model.games

import com.example.main_page.api.model.games.GamesDataResponse
import com.example.main_page.api.model.games.GamesResultsResponse
import com.example.main_page.api.model.games.GenresResponse
import com.example.main_page.api.model.games.PlatformsResponse
import com.example.main_page.api.model.games.ShortScreenshotsResponse

object GamesDataConverter {

     fun fromNetwork(response: List<GamesResultsResponse>, genres: String) =
        response.map { data ->
            GamesResults(
                id = data.id,
                name = data.name,
                slug = genres,
                released = data.released,
                background_image = data.background_image,
                rating = data.rating,
                ratings_count = data.ratings_count,
                updated = data.updated,
                platforms = fromNetworkPlatform(data.platforms),
                genres = fromNetworkGenres(data.genres),
                screenshots = fromNetworkScreenshots(data.short_screenshots)
            )
        }

    private fun fromNetworkScreenshots(response: List<ShortScreenshotsResponse>) =
        response.map { data ->
            Screenshots(
                image = data.image
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