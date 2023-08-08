package com.example.main_page.api.model.genres

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class ResultsResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("games_count")
    val games_count: Int,
    @SerializedName("image_background")
    val image_background: String,
    @SerializedName("games")
    val games: List<GamesResponse>
    )