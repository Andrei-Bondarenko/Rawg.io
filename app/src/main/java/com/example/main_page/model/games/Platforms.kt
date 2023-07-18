package com.example.main_page.model.games

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Platforms(
    val name: String,
    val image_background: String?
) : Parcelable
