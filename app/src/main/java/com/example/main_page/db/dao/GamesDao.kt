package com.example.main_page.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.main_page.db.model.GamesEntity

@Dao
interface GamesDao {
    @Query("SELECT * FROM games WHERE slug LIKE :genre LIMIT :limit OFFSET :offset")
    fun getGames(genre: String, limit: Int, offset: Int): List<GamesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setGames(genres: List<GamesEntity>)

}