package com.example.main_page.model.games

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Screenshots(
    val image: String
) : Parcelable
