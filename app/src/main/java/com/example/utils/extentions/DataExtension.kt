package com.example.utils.extentions

import com.example.main_page.api.model.games.GamesResultsResponse
import com.example.main_page.api.model.games.GenresResponse
import com.example.main_page.api.model.games.PlatformsResponse
import com.example.main_page.api.model.games.ShortScreenshotsResponse
import com.example.main_page.model.games.GamesResults
import com.example.main_page.model.games.Genres
import com.example.main_page.model.games.Platforms
import com.example.main_page.model.games.Screenshots

//fun GamesResultsResponse.toGamesEntity() =
//    GamesEntity(
//        id = 1,
//        name = name,
//        released = released,
//        backround_image = background_image,
//        rating = rating,
//        ratings_count = ratings_count,
//        updated = updated,
//        platforms = toEntityPlatform(platforms),
//        genres = toEntityGenres(genres),
//        screenshots = toEntityScreenshots(screenshots = short_screenshots)
//        )
//
//fun GamesEntity.toGamesData(): GamesResults {
//    return GamesResults(
//        name = name,
//        released = released,
//        backround_image = backround_image,
//        rating = rating,
//        ratings_count = ratings_count,
//        updated = updated,
//        platforms = toPlatform(platforms),
//        genres = toGenres(genres),
//        screenshots = toScreenshots(screenshots)
//    )
//}
//
//private fun toEntityScreenshots(screenshots: List<ShortScreenshotsResponse>): List<String> {
//    val strings = mutableListOf<String>()
//    screenshots.map {
//        strings.add(it.image)
//    }
//    return strings
//}
//
//private fun toEntityGenres(genres: List<GenresResponse>): List<String> {
//    val strings = mutableListOf<String>()
//    genres.map {
//        strings.add(it.name)
//    }
//    return strings
//}
//
//private fun toEntityPlatform(platforms: List<PlatformsResponse>): List<String> {
//    val strings = mutableListOf<String>()
//    platforms.map {
//        strings.add(it.platform.name)
//    }
//    return strings
//}
//
//
//
//private fun toScreenshots(screenshots: List<String>) =
//    screenshots.map {
//        Screenshots(
//            image = it
//        )
//    }
//
//private fun toGenres(genres: List<String>) =
//    genres.map {
//        Genres(
//            name = it,
//            image_background = null
//        )
//    }
//
//private fun toPlatform(platforms: List<String>) =
//    platforms.map {
//        Platforms(
//            name = it,
//            image_background = null
//        )
//    }