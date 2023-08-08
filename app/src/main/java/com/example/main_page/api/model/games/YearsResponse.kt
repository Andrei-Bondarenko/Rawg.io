package com.example.main_page.api.model.games

import com.google.gson.annotations.SerializedName


data class YearsResponse(
    @SerializedName("from")
    val from: Int,
    @SerializedName("to")
    val to: Int,
    @SerializedName("filter")
    val filter: String,
    @SerializedName("decade")
    val decade: Int,
    @SerializedName("year")
    val year: List<YearResponse>,
    @SerializedName("nofollow")
    val nofollow: Boolean,
    @SerializedName("count")
    val count: Int,
)
