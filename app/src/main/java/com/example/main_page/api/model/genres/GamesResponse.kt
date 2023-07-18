package com.example.main_page.api.model.genres

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GamesResponse(
    val id: Int,
    val slug: String,
    val name: String,
    val added: Int
) : Parcelable