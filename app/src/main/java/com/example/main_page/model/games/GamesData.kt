package com.example.main_page.model.games

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GamesData(
    val results: List<GamesResults>
) : Parcelable
