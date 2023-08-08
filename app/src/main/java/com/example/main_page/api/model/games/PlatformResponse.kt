package com.example.main_page.api.model.games

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


data class PlatformResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("image")
    val image: String?,
    @SerializedName("year_end")
    val year_end: Int?,
    @SerializedName("year_start")
    val year_start: Int?,
    @SerializedName("games_count")
    val games_count: Int,
    @SerializedName("image_background")
    val image_background: String
)
