package com.example.main_page.api.model.games

data class YearsResponse(
    val from: Int,
    val to: Int,
    val filter: String,
    val decade: Int,
    val year: List<YearResponse>,
    val nofollow: Boolean,
    val count: Int,
)
