package com.example.main_page.api.model.games

data class PlatformsResponse(
    val platform: PlatformResponse,
    val released_at: String,
    val requirements_en: RequirementsEnResponse?,
    val requirements_ru: RequirementsRuResponse?
)
