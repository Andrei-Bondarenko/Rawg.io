package com.example.main_page.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.main_page.db.dao.GamesDao
import com.example.main_page.db.dao.GenresDao
import com.example.main_page.db.model.DatabaseConverter
import com.example.main_page.db.model.GamesEntity
import com.example.main_page.db.model.GenresEntity

@Database(version = 2, entities = [GenresEntity::class, GamesEntity::class])
@TypeConverters(DatabaseConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getGenresDao(): GenresDao
    abstract fun getGamesDao(): GamesDao
}
