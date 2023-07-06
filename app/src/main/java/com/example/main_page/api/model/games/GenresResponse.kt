package com.example.main_page.api.model.games

data class GenresResponse(
    val id: Int,
    val name: String,
    val slug: String,
    val games_count: Int,
    val image_background: String
)
