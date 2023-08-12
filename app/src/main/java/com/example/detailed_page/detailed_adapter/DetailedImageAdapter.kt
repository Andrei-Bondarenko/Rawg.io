package com.example.detailed_page.detailed_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.main_page.model.games.Screenshots
import com.example.rawgio.R

class DetailedImageAdapter : RecyclerView.Adapter<DetailedImageViewHolder>() {

    private val data = mutableListOf<Screenshots>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailedImageViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.item_detail_game, parent, false)
        return DetailedImageViewHolder(parent)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: DetailedImageViewHolder, position: Int) {
        holder.onBind(data[position])
    }

    fun setData(items: List<Screenshots>) {
        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }
}