package com.example.main_page.api.model.games

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


data class StoresResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("store")
    val store: StoreResponse
)
