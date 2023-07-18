package com.example.main_page.api.model.games

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PlatformResponse(
    val id: Int,
    val name: String,
    val slug: String,
    val image: String?,
    val year_end: Int?,
    val year_start: Int?,
    val games_count: Int,
    val image_background: String
) : Parcelable
