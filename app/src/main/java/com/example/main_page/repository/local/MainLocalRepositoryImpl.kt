package com.example.main_page.repository.local

import com.example.main_page.db.dao.GamesDao
import com.example.main_page.db.dao.GenresDao
import com.example.main_page.db.model.GamesEntity
import com.example.main_page.db.model.GenresEntity
import com.example.main_page.model.games.GamesResults
import com.example.main_page.model.genres.GenresData

private const val PAGE_SIZE = 20

class MainLocalRepositoryImpl(
    private val genresDao: GenresDao,
    private val gamesDao: GamesDao,
): MainLocalRepository {

    override suspend fun getGames(page: Int, genre: String): List<GamesResults> =
        gamesDao.getGames(
            genre = genre,
            limit = PAGE_SIZE,
            offset = page * PAGE_SIZE - PAGE_SIZE
        ).map(GamesEntity::toGames)

    override suspend fun getGenres(): List<GenresData> =
        genresDao.getGenres().map(GenresEntity::toGenres)

    override suspend fun setGenres(genres: List<GenresData>) {
        genresDao.setGenres(
            genres = genres.map(GenresData::toGenresEntity)
        )
    }

    override suspend fun setGames(games: List<GamesResults>) {
        gamesDao.setGames(games.map(GamesResults::toGamesEntity))
    }
}