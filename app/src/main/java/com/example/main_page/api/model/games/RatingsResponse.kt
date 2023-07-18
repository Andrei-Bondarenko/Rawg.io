package com.example.main_page.api.model.games

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RatingsResponse(
    val id: Int,
    val title: String,
    val count: Int,
    val percent: Double
) : Parcelable