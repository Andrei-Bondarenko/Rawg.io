package com.example.main_page.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.main_page.model.games.GamesData
import com.example.main_page.model.games.GamesResults
import com.example.main_page.model.genres.Games
import com.example.rawgio.R

class HorizontalAdapter(
    private val gamesData: GamesData
): RecyclerView.Adapter<HorizontalViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.item_horizontal_recycler, parent, false)
        return HorizontalViewHolder(parent)
    }

    override fun onBindViewHolder(holder: HorizontalViewHolder, position: Int) {
        holder.onBind(gamesData.results[position])
    }

    override fun getItemCount() = gamesData.results.size


}