package com.example.main_page.model.genres

data class Results(
    val id: Int,
    val name: String,
    val slug: String,
    val image_background: String,
    val games: List<Games>
)
