package com.example.main_page.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.main_page.model.genres.GenresData

@Entity(tableName = "genres")
data class GenresEntity(
    @PrimaryKey
    val slug: String,
    val name: String,
) {

    fun toGenres() = GenresData(
        name = name,
        slug = slug
    )

}
