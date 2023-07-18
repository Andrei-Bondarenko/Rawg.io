package com.example.main_page.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.main_page.model.games.GamesData
import com.example.main_page.model.games.GamesResults
import com.example.main_page.model.genres.GenresData
import com.example.main_page.ui.model.GamesUi
import com.example.rawgio.R

class MainAdapter(
    private val getGames: (String) -> Unit,
    private val clickOnItem: (GamesResults) -> Unit
): RecyclerView.Adapter<MainViewHolder>() {

    private val data = mutableListOf<GenresData>()
    private val mainData: MutableMap<String, List<GamesResults>> = mutableMapOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.item_main_recycler, parent, false)
        return MainViewHolder(parent,getGames,clickOnItem)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val slug = data[position].slug
        val games = mainData[slug] ?: emptyList()
        holder.onBind(games, data[position])
    }

    override fun getItemCount() = data.size

    fun setData(items: List<GenresData>) {
        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }

    fun setGamesData(item: GamesUi) {
        mainData[item.slug] = item.games
        notifyDataSetChanged()
    }
}