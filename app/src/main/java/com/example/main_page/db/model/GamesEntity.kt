package com.example.main_page.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.main_page.model.games.GamesResults
import com.example.main_page.model.games.Genres
import com.example.main_page.model.games.Platforms
import com.example.main_page.model.games.Screenshots

@Entity(tableName = "games")
data class GamesEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
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
) {
    fun toGames() = GamesResults(
        id = id,
        name = name,
        slug = slug,
        released = released,
        rating = rating,
        updated = updated,
        background_image = background_image,
        ratings_count = ratings_count,
        platforms = platforms,
        genres = genres,
        screenshots = screenshots
    )
}
