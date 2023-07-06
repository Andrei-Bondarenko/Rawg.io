package com.example.main_page.api.model.games

data class AddedByStatusResponse(
    val yet: Int,
    val owned: Int,
    val beaten: Int,
    val toplay: Int,
    val dropped: Int,
    val playing: String
)
