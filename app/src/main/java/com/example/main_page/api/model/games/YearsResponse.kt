package com.example.main_page.api.model.games

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class YearsResponse(
    val from: Int,
    val to: Int,
    val filter: String,
    val decade: Int,
    val year: List<YearResponse>,
    val nofollow: Boolean,
    val count: Int,
) : Parcelable
