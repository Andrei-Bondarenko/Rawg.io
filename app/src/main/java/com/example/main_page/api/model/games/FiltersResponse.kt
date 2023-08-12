package com.example.main_page.api.model.games

import com.google.gson.annotations.SerializedName


data class FiltersResponse(
    @SerializedName("years")
    val years: List<YearsResponse>
)
