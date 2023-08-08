package com.example.main_page.api.model.games

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


data class GamesResultsResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("released")
    val released: String,
    @SerializedName("tba")
    val tba: Boolean,
    @SerializedName("background_image")
    val background_image: String,
    @SerializedName("rating")
    val rating: Double,
    @SerializedName("rating_top")
    val rating_top: Int,
    @SerializedName("ratings")
    val ratings: List<RatingsResponse>,
    @SerializedName("ratings_count")
    val ratings_count: Int,
    @SerializedName("reviews_text_count")
    val reviews_text_count: Int,
    @SerializedName("added")
    val added: Int,
    @SerializedName("added_by_status")
    val added_by_status: AddedByStatusResponse,
    @SerializedName("metacritic")
    val metacritic: Int,
    @SerializedName("playtime")
    val playtime: Int,
    @SerializedName("suggestions_count")
    val suggestions_count: Int,
    @SerializedName("updated")
    val updated: String,
    @SerializedName("user_game")
    val user_game: String?,
    @SerializedName("reviews_count")
    val reviews_count: Int,
    @SerializedName("saturated_color")
    val saturated_color: String,
    @SerializedName("dominant_color")
    val dominant_color: String,
    @SerializedName("platforms")
    val platforms: List<PlatformsResponse>,
    @SerializedName("parent_platforms")
    val parent_platforms: List<ParentPlatformsResponse>,
    @SerializedName("genres")
    val genres: List<GenresResponse>,
    @SerializedName("stores")
    val stores: List<StoresResponse>,
    @SerializedName("clip")
    val clip: String?,
    @SerializedName("tags")
    val tags: List<TagsResponse>,
    @SerializedName("esrb_rating")
    val esrb_rating: EsrbRatingResponse,
    @SerializedName("short_screenshots")
    val short_screenshots: List<ShortScreenshotsResponse>,
)
