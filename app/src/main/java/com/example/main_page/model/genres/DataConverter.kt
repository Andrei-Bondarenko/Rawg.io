package com.example.main_page.model.genres

import com.example.main_page.api.model.genres.GamesResponse
import com.example.main_page.api.model.genres.ResultsResponse

object DataConverter {

    fun fromNetwork(response: List<ResultsResponse>) =
        response.map { data ->
            GenresData(
                name = data.name,
                slug = data.slug,
            )
    }
}