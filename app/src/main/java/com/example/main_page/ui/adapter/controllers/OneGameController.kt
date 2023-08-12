package com.example.main_page.ui.adapter.controllers

import android.view.ViewGroup
import coil.load
import com.example.main_page.model.games.GamesResults
import com.example.main_page.model.games.Platforms
import com.example.rawgio.R
import com.example.rawgio.databinding.ItemHorizontalRecyclerBinding
import com.example.utils.extentions.getDrawable
import ru.surfstudio.android.easyadapter.controller.BindableItemController
import ru.surfstudio.android.easyadapter.holder.BindableViewHolder
import timber.log.Timber

class OneGameController(
    private val onGameItemClicked: (GamesResults) -> Unit,
) : BindableItemController<GamesResults, OneGameController.Holder>() {

    override fun createViewHolder(parent: ViewGroup): Holder = Holder(parent)

    override fun getItemId(data: GamesResults): Any = data.hashCode()

    inner class Holder(parent: ViewGroup) :
        BindableViewHolder<GamesResults>(parent, R.layout.item_horizontal_recycler) {

        private val binding: ItemHorizontalRecyclerBinding =
            ItemHorizontalRecyclerBinding.bind(itemView)

        private val platforms = listOf(
            binding.image1,
            binding.image5,
            binding.image2,
            binding.image6,
            binding.image3,
            binding.image7,
            binding.image4,
            binding.image8,
            binding.image9,
            binding.image10
        )

        override fun bind(item: GamesResults) {
            with(binding) {
                gameName.text = item.name

                imageView.load(item.background_image) {
                    crossfade(true)
                    placeholder(R.drawable.ic_loading)
                }

                if (item.platforms.isNotEmpty()) {
                    getPlatformsImage(item.platforms)
                }
                itemView.setOnClickListener { onGameItemClicked.invoke(item) }
            }
        }

        private fun getPlatformsImage(platformsList: List<Platforms>) = with(binding) {
            var i = 0
            platforms.forEach { it.setImageDrawable(null) }
            platformsList.forEach {
                if (i < 10) {
                platforms[i].setImageResource(getDrawable(it.name))
                    i++
                }
            }
        }
    }
}