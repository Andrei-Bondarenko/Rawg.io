package com.example.main_page.api.model.games

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


data class YearResponse(
    @SerializedName("year")
    val year: Int,
    @SerializedName("count")
    val count: Int,
    @SerializedName("nofollow")
    val nofollow: Boolean
)