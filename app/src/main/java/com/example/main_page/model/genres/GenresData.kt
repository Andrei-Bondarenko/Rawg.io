package com.example.main_page.model.genres

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GenresData(
    val id: Int,
    val name: String,
    val slug: String,
    val image_background: String,
    val games: List<Games>
) : Parcelable
