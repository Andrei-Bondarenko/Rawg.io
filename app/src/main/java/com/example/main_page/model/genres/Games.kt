package com.example.main_page.model.genres

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Games(
    val id: Int,
    val name: String,
) : Parcelable