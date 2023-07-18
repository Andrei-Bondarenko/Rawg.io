package com.example.main_page.ui.model

import android.os.Parcelable
import com.example.main_page.model.games.GamesResults
import kotlinx.parcelize.Parcelize

@Parcelize
data class GamesUi(
    val games: List<GamesResults> = emptyList(),
    val slug: String = ""
) : Parcelable
