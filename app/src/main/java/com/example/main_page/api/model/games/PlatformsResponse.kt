package com.example.main_page.api.model.games

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PlatformsResponse(
    val platform: PlatformResponse,
    val released_at: String,
    val requirements_en: RequirementsEnResponse?,
    val requirements_ru: RequirementsRuResponse?
) : Parcelable
