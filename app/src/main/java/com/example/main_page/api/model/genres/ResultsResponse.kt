package com.example.main_page.api.model.genres

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResultsResponse(
    val id: Int,
    val name: String,
    val slug: String,
    val games_count: Int,
    val image_background: String,
    val games: List<GamesResponse>
    ) : Parcelable