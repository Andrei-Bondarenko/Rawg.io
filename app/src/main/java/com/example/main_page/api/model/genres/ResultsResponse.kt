package com.example.main_page.api.model.genres

data class ResultsResponse(
    val id: Int,
    val name: String,
    val slug: String,
    val games_count: Int,
    val image_background: String,
    val games: List<GamesResponse>
    )