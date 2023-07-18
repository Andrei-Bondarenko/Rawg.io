package com.example.main_page.api.model.games

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RequirementsRuResponse(
    val minimum: String?,
    val recommended: String?
) : Parcelable
