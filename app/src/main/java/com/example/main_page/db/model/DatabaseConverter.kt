package com.example.main_page.db.model

import androidx.room.TypeConverter
import com.example.main_page.model.games.Genres
import com.example.main_page.model.games.Platforms
import com.example.main_page.model.games.Screenshots
import com.example.main_page.model.genres.GenresData
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.lang.StringBuilder

object DatabaseConverter {

    private val gson: Gson = GsonBuilder().create()

    @TypeConverter
    fun fromListScreenshots(screenshots: List<Screenshots>): String {
        val data = StringBuilder()
        for (item in screenshots) {
            data.append(gson.toJson(item))
            data.append(';')
        }
        return data.toString()
    }

    @TypeConverter
    fun fromListPlatforms(platforms: List<Platforms>): String {
        val data = StringBuilder()
        for (item in platforms) {
            data.append(gson.toJson(item))
            data.append(';')
        }
        return data.toString()
    }

    @TypeConverter
    fun fromListGenres(genres: List<Genres>): String {
        val data = StringBuilder()
        for (item in genres) {
            data.append(gson.toJson(item))
            data.append(';')
        }
        return data.toString()
    }

    @TypeConverter
    fun toDatabaseScreenshots(screenshots: String): List<Screenshots> {
        if(screenshots.isEmpty()) return listOf()
        val data = mutableListOf<Screenshots>()
        for (item in screenshots.split(";".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
            data.add(gson.fromJson(item,Screenshots::class.java))
        }
        return data
    }

    @TypeConverter
    fun toDatabaseGenres(genres: String): List<Genres> {
        if(genres.isEmpty()) return listOf()
        val data = mutableListOf<Genres>()
        for (item in genres.split(";".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
            data.add(gson.fromJson(item,Genres::class.java))
        }
        return data
    }

    @TypeConverter
    fun toDatabasePlatforms(platforms: String): List<Platforms> {
        if(platforms.isEmpty()) return listOf()
        val data = mutableListOf<Platforms>()
        for (item in platforms.split(";".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
            data.add(gson.fromJson(item,Platforms::class.java))
        }
        return data
    }
}