package com.example.main_page.api.model.games

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FiltersResponse(
    val years: List<YearsResponse>
) : Parcelable
