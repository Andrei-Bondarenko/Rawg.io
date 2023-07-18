package com.example.main_page.db.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

//@Dao
//interface GamesDao {
//
//    @Upsert
//    suspend fun upsertAll(games: List<GamesEntity>?)
//
//    @Query("SELECT * FROM games")
//    fun pagingSource(): PagingSource<Int, GamesEntity>
//
//    @Query("DELETE FROM games")
//    suspend fun clearAll()
//}