package com.example.main_page.model.games

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Genres(
    val name: String,
    val image_background: String?
) : Parcelable
