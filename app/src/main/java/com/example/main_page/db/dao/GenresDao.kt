package com.example.main_page.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.main_page.db.model.GenresEntity

@Dao
interface GenresDao {

    @Query("SELECT * FROM genres")
    fun getGenres(): List<GenresEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setGenres(genres: List<GenresEntity>)

}