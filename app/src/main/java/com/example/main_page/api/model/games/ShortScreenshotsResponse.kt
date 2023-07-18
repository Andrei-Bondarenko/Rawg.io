package com.example.main_page.api.model.games

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ShortScreenshotsResponse(
    val id: Int,
    val image: String
) : Parcelable
