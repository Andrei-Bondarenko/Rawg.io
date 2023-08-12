package com.example.main_page.ui.adapter.controllers

import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.main_page.model.games.GamesResults
import com.example.main_page.ui.MainUi
import com.example.rawgio.R
import com.example.rawgio.databinding.ItemMainRecyclerBinding
import ru.surfstudio.android.easyadapter.ItemList
import ru.surfstudio.android.easyadapter.controller.BindableItemController
import ru.surfstudio.android.easyadapter.holder.BindableViewHolder
import ru.surfstudio.android.easyadapter.pagination.EasyPaginationAdapter
import timber.log.Timber

class GamesController(
    private val onGameItemClicked: (GamesResults) -> Unit,
    private val onLoadGames: (genre: String, page: Int) -> Unit,
) : BindableItemController<MainUi.GamesList, GamesController.Holder>() {

    override fun getItemId(data: MainUi.GamesList): Any = data.genre

    override fun createViewHolder(parent: ViewGroup): Holder {
        Timber.d("GAMES CONTROLLER IS WORKING BRO!!!!")
        return Holder(parent)
    }

    inner class Holder(parent: ViewGroup) :
        BindableViewHolder<MainUi.GamesList>(parent, R.layout.item_main_recycler) {

        private val binding = ItemMainRecyclerBinding.bind(itemView)

        private val footerController = GamesFooterPaginationController()

        private lateinit var data: MainUi.GamesList

        private val adapter = EasyPaginationAdapter(footerController) {
            onLoadGames(data.genre, data.games.nextPage)
        }

        private val oneGameController = OneGameController(onGameItemClicked)

        init {
            binding.itemRecycler.adapter = adapter
        }

        override fun bind(data: MainUi.GamesList) {
            this.data = data
            setAdapterItems(data.games)
            binding.itemRecycler.scrollToPosition(data.lastVisiblePosition)
            if (data.page == 1) onLoadGames(data.genre, data.page)
        }

        private fun setAdapterItems(games: List<GamesResults>) {
            val itemList = ItemList.create()
            for (game in games) {
                itemList.add(game, oneGameController)
            }
            adapter.setItems(itemList, data.paginationState)
        }
    }
}