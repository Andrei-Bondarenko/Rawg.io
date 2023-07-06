package com.example.main_page.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.main_page.model.games.GamesData
import com.example.main_page.model.games.GamesResults
import com.example.main_page.model.genres.Results
import com.example.rawgio.R

class MainAdapter(
    private val context: Context
) : RecyclerView.Adapter<MainViewHolder>() {

    private val data = mutableListOf<Results>()
    private val gameData = mutableListOf<GamesResults>()
    private val mainData: GamesData = GamesData(gameData)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.item_main_recycler, parent, false)
        return MainViewHolder(parent)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.onBind(mainData, context, position)
    }

    override fun getItemCount() = data.size

    fun setData(items: List<Results>) {
        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }

    fun setGamesData(items: List<GamesResults>) {
        gameData.clear()
        gameData.addAll(items)
        notifyDataSetChanged()
    }
}