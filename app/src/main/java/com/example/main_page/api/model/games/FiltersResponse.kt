package com.example.main_page.api.model.games

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


data class FiltersResponse(
    @SerializedName("years")
    val years: List<YearsResponse>
)
