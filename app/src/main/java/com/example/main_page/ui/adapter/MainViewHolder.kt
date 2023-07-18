package com.example.main_page.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.detailed_page.DetailedFragment
import com.example.main_page.model.games.GamesResults
import com.example.main_page.model.genres.GenresData
import com.example.main_page.ui.MainFragment
import com.example.rawgio.databinding.ItemMainRecyclerBinding
import com.example.utils.extentions.replaceScreen

class MainViewHolder(
    private val binding: ItemMainRecyclerBinding,
    private val getGames: (String) -> Unit,
    private val clickOnItem: (GamesResults) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    private lateinit var horizontalAdapter: HorizontalAdapter
    private var slugList: MutableList<String> = mutableListOf()
    constructor(parent: ViewGroup, getGames: (String) -> Unit, clickOnItem: (GamesResults) -> Unit) : this(
        binding = ItemMainRecyclerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        getGames = getGames,
        clickOnItem = clickOnItem
    )

    fun onBind(gameItem: List<GamesResults>, item: GenresData) {
        with(binding) {
            if (!equalSlug(item.slug)) {
                getGames(item.slug)
                slugList.add(item.slug)
            }

            itemRecycler.layoutManager =
                LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)

            horizontalAdapter = HorizontalAdapter(gameItem, clickOnItem)
            itemRecycler.adapter = horizontalAdapter

            genresTextView.text = item.name
        }
    }

    private fun equalSlug(slug: String): Boolean {
        var isSame = false
        if (slugList.isNotEmpty()) {
            for (i in 0 until slugList.size) {
                if (slug == slugList[i]) isSame = true
            }
        }
        return isSame
    }
}

