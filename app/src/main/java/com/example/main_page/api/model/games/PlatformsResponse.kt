package com.example.main_page.api.model.games

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


data class PlatformsResponse(
    @SerializedName("platform")
    val platform: PlatformResponse,
    @SerializedName("released_at")
    val released_at: String,
    @SerializedName("requirements_en")
    val requirements_en: RequirementsEnResponse?,
    @SerializedName("requirements_ru")
    val requirements_ru: RequirementsRuResponse?
)
