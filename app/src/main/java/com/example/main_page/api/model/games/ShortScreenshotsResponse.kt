package com.example.main_page.api.model.games

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


data class ShortScreenshotsResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String
)
