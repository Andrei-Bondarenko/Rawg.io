package com.example.main_page.model.genres

import android.os.Parcelable
import com.example.main_page.db.model.GenresEntity
import kotlinx.parcelize.Parcelize

@Parcelize
data class GenresData(
    val name: String,
    val slug: String,
) : Parcelable {

    fun toGenresEntity() = GenresEntity(
        slug = slug,
        name = name
    )

}