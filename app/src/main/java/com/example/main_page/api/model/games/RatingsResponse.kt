package com.example.main_page.api.model.games

data class RatingsResponse(
    val id: Int,
    val title: String,
    val count: Int,
    val percent: Double
)