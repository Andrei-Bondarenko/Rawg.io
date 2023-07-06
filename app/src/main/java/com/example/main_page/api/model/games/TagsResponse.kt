package com.example.main_page.api.model.games

data class TagsResponse(
    val id: Int,
    val name: String,
    val slug: String,
    val language: String,
    val games_count: Int,
    val image_background: String
)
