package com.example.main_page.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.main_page.model.games.GamesResults
import com.example.main_page.model.games.Platforms
import com.example.main_page.model.genres.Games
import com.example.rawgio.R
import com.example.rawgio.databinding.ItemHorizontalRecyclerBinding

class HorizontalViewHolder(
    private val binding: ItemHorizontalRecyclerBinding
) : RecyclerView.ViewHolder(binding.root) {

    constructor(parent: ViewGroup) : this(
        ItemHorizontalRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    fun onBind(item: GamesResults) {
        with(binding) {
            gameName.text = item.name
            imageView.load(item.backround_image) {
                crossfade(true)
                placeholder(R.drawable.ic_loading)
            }
            if (item.platforms.isNotEmpty()) {
                getPlatformsImage(item.platforms)
            }
        }
    }

    private fun getPlatformsImage(item: List<Platforms>) {
        with(binding) {
            when (item.size) {
                1 -> image1.load(item[0].image_background)
                2 -> {
                    image1.load(item[0].image_background)
                    image5.load(item[1].image_background)
                }
                3 -> {
                    image1.load(item[0].image_background)
                    image5.load(item[1].image_background)
                    image2.load(item[2].image_background)
                }
                4 -> {
                    image1.load(item[0].image_background)
                    image5.load(item[1].image_background)
                    image2.load(item[2].image_background)
                    image6.load(item[3].image_background)
                }
                5 -> {
                    image1.load(item[0].image_background)
                    image5.load(item[1].image_background)
                    image2.load(item[2].image_background)
                    image6.load(item[3].image_background)
                    image3.load(item[4].image_background)
                }
                6 -> {
                    image1.load(item[0].image_background)
                    image5.load(item[1].image_background)
                    image2.load(item[2].image_background)
                    image6.load(item[3].image_background)
                    image3.load(item[4].image_background)
                    image7.load(item[5].image_background)
                }
                7 -> {
                    image1.load(item[0].image_background)
                    image5.load(item[1].image_background)
                    image2.load(item[2].image_background)
                    image6.load(item[3].image_background)
                    image3.load(item[4].image_background)
                    image7.load(item[5].image_background)
                    image4.load(item[6].image_background)
                }
                8 -> {
                    image1.load(item[0].image_background)
                    image5.load(item[1].image_background)
                    image2.load(item[2].image_background)
                    image6.load(item[3].image_background)
                    image3.load(item[4].image_background)
                    image7.load(item[5].image_background)
                    image4.load(item[6].image_background)
                    image8.load(item[7].image_background)
                }
                else -> {}
            }
        }
    }

}