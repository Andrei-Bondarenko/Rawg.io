package com.example.main_page.api.model.genres

data class GamesResponse(
    val id: Int,
    val slug: String,
    val name: String,
    val added: Int
)