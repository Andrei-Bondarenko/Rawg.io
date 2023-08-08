package com.example.main_page.api.model.games

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


data class GamesDataResponse(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String?,
    @SerializedName("previous")
    val previous: String?,
    @SerializedName("results")
    val results: List<GamesResultsResponse>,
    @SerializedName("seo_title")
    val seo_title: String,
    @SerializedName("seo_description")
    val seo_description: String,
    @SerializedName("seo_h1")
    val seo_h1: String,
    @SerializedName("noindex")
    val noindex: Boolean,
    @SerializedName("nofollow")
    val nofollow: Boolean,
    @SerializedName("description")
    val description: String,
    @SerializedName("filters")
    val filters: FiltersResponse,
    @SerializedName("nofollow_collections")
    val nofollow_collections: List<String>
)
