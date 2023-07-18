package com.example.main_page.api.model.games

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ParentPlatformResponse(
    val id: Int,
    val name: String,
    val slug: String
) : Parcelable
