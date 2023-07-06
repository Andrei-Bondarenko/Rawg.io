package com.example.main_page.api.model.genres

data class DataResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<ResultsResponse>
)