package com.example.main_page.api.model.games

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GamesResultsResponse(
    val id: Int,
    val slug: String,
    val name: String,
    val released: String,
    val tba: Boolean,
    val background_image: String,
    val rating: Double,
    val rating_top: Int,
    val ratings: List<RatingsResponse>,
    val ratings_count: Int,
    val reviews_text_count: Int,
    val added: Int,
    val added_by_status: AddedByStatusResponse,
    val metacritic: Int,
    val playtime: Int,
    val suggestions_count: Int,
    val updated: String,
    val user_game: String?,
    val reviews_count: Int,
    val saturated_color: String,
    val dominant_color: String,
    val platforms: List<PlatformsResponse>,
    val parent_platforms: List<ParentPlatformsResponse>,
    val genres: List<GenresResponse>,
    val stores: List<StoresResponse>,
    val clip: String?,
    val tags: List<TagsResponse>,
    val esrb_rating: EsrbRatingResponse,
    val short_screenshots: List<ShortScreenshotsResponse>,

) : Parcelable
