package com.example.main_page.api.model.genres

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<ResultsResponse>
) : Parcelable