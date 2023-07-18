package com.example.main_page.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.main_page.model.games.GamesData
import com.example.main_page.model.games.GamesResults
import com.example.main_page.model.genres.Games
import com.example.rawgio.R

class HorizontalAdapter(
    private val gamesData: List<GamesResults>,
    private val clickOnItem: (GamesResults) -> Unit
): RecyclerView.Adapter<HorizontalViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.item_horizontal_recycler, parent, false)
        return HorizontalViewHolder(parent, clickOnItem)
    }

    override fun onBindViewHolder(holder: HorizontalViewHolder, position: Int) {
        holder.onBind(gamesData[position])
    }

    override fun getItemCount() = gamesData.size


}