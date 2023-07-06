package com.example.main_page.api.model.games

data class GamesDataResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<GamesResultsResponse>,
    val seo_title: String,
    val seo_description: String,
    val seo_h1: String,
    val noindex: Boolean,
    val nofollow: Boolean,
    val description: String,
    val filters: FiltersResponse,
    val nofollow_collections: List<String>
)
