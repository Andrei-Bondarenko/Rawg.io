package com.example.main_page.api.model.games

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class YearResponse(
    val year: Int,
    val count: Int,
    val nofollow: Boolean
) : Parcelable