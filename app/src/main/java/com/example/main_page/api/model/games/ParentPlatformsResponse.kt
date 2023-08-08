package com.example.main_page.api.model.games

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class ParentPlatformsResponse(
    @SerializedName("platform")
    val platform: ParentPlatformResponse,
)
