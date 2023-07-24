package com.example.main_page.model.genres

import android.os.Parcelable
import com.example.common.ui.recycler.PagingState
import com.example.main_page.db.model.GenresEntity
import kotlinx.parcelize.Parcelize

@Parcelize
data class GenresData(
    val name: String,
    val slug: String,
    var position: Int = -1,
    var page: Int = 1,
    var latestScrollPosition: Int = 0,
    var pagingState: PagingState = PagingState.Idle,
    var state: Parcelable? = null
) : Parcelable {

    fun toGenresEntity() = GenresEntity(
        slug = slug,
        name = name
    )

}