package com.example.main_page.model.games

import android.os.Parcelable
import com.example.main_page.db.model.GamesEntity
import kotlinx.parcelize.Parcelize

@Parcelize
data class GamesResults(
    val id: Int,
    val name: String,
    val slug: String,
    val released: String,
    val background_image: String,
    val rating: Double,
    val ratings_count: Int,
    val updated: String,
    val platforms: List<Platforms>,
    val genres: List<Genres>,
    val screenshots: List<Screenshots>
) : Parcelable {

    fun toGamesEntity() = GamesEntity(
        name = name,
        slug = slug,
        released = released,
        background_image = background_image,
        rating = rating,
        updated = updated,
        ratings_count = ratings_count,
        platforms = platforms,
        genres = genres,
        screenshots = screenshots
    )
}
