package com.example.main_page.model.games

data class GamesResults(
    val name: String,
    val released: String,
    val backround_image: String,
    val rating: Double,
    val ratings_count: Int,
    val updated: String,
    val platforms: List<Platforms>,
    val genres: List<Genres>
)
