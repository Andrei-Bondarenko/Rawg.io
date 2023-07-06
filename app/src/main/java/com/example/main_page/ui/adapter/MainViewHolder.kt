package com.example.main_page.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.main_page.model.games.GamesData
import com.example.main_page.model.games.GamesResults
import com.example.main_page.model.genres.Results
import com.example.rawgio.R
import com.example.rawgio.databinding.ItemMainRecyclerBinding

class MainViewHolder(
    private val binding: ItemMainRecyclerBinding,
) : RecyclerView.ViewHolder(binding.root) {

    private lateinit var horizontalAdapter: HorizontalAdapter

    constructor(parent: ViewGroup) : this(
        ItemMainRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    fun onBind(item: GamesData, context: Context, position: Int) {
        with(binding) {
            itemRecycler.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            horizontalAdapter = HorizontalAdapter(item)
            itemRecycler.adapter = horizontalAdapter
            genresTextView.text = item.results[position].name

        }
    }

}

