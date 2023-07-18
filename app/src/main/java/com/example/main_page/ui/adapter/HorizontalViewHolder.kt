package com.example.main_page.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.main_page.model.games.GamesResults
import com.example.main_page.model.games.Platforms
import com.example.rawgio.R
import com.example.rawgio.databinding.ItemHorizontalRecyclerBinding
import com.example.utils.extentions.getDrawable

class HorizontalViewHolder(
    private val clickOnItem: (GamesResults) -> Unit,
    private val binding: ItemHorizontalRecyclerBinding
) : RecyclerView.ViewHolder(binding.root) {

    constructor(parent: ViewGroup, clickOnItem: (GamesResults) -> Unit) : this(
        clickOnItem,
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
            itemView.setOnClickListener {
                clickOnItem(item)
            }
        }
    }

    private fun getPlatformsImage(item: List<Platforms>) {
        with(binding) {
            when (item.size) {
                1 -> image1.setImageResource(getDrawable(platform = item[0].name))
                2 -> {
                    image1.setImageResource(getDrawable(platform = item[0].name))
                    image5.setImageResource(getDrawable(platform = item[1].name))
                }

                3 -> {
                    image1.setImageResource(getDrawable(platform = item[0].name))
                    image5.setImageResource(getDrawable(platform = item[1].name))
                    image2.setImageResource(getDrawable(platform = item[2].name))
                }

                4 -> {
                    image1.setImageResource(getDrawable(platform = item[0].name))
                    image5.setImageResource(getDrawable(platform = item[1].name))
                    image2.setImageResource(getDrawable(platform = item[2].name))
                    image6.setImageResource(getDrawable(platform = item[3].name))
                }

                5 -> {
                    image1.setImageResource(getDrawable(platform = item[0].name))
                    image5.setImageResource(getDrawable(platform = item[1].name))
                    image2.setImageResource(getDrawable(platform = item[2].name))
                    image6.setImageResource(getDrawable(platform = item[3].name))
                    image3.setImageResource(getDrawable(platform = item[4].name))
                }

                6 -> {
                    image1.setImageResource(getDrawable(platform = item[0].name))
                    image5.setImageResource(getDrawable(platform = item[1].name))
                    image2.setImageResource(getDrawable(platform = item[2].name))
                    image6.setImageResource(getDrawable(platform = item[3].name))
                    image3.setImageResource(getDrawable(platform = item[4].name))
                    image7.setImageResource(getDrawable(platform = item[5].name))
                }

                7 -> {
                    image1.setImageResource(getDrawable(platform = item[0].name))
                    image5.setImageResource(getDrawable(platform = item[1].name))
                    image2.setImageResource(getDrawable(platform = item[2].name))
                    image6.setImageResource(getDrawable(platform = item[3].name))
                    image3.setImageResource(getDrawable(platform = item[4].name))
                    image7.setImageResource(getDrawable(platform = item[5].name))
                    image4.setImageResource(getDrawable(platform = item[6].name))
                }

                8 -> {
                    image1.setImageResource(getDrawable(platform = item[0].name))
                    image5.setImageResource(getDrawable(platform = item[1].name))
                    image2.setImageResource(getDrawable(platform = item[2].name))
                    image6.setImageResource(getDrawable(platform = item[3].name))
                    image3.setImageResource(getDrawable(platform = item[4].name))
                    image7.setImageResource(getDrawable(platform = item[5].name))
                    image4.setImageResource(getDrawable(platform = item[6].name))
                    image8.setImageResource(getDrawable(platform = item[7].name))
                }

                else -> {
                    image1.setImageResource(getDrawable(platform = item[0].name))
                    image5.setImageResource(getDrawable(platform = item[1].name))
                    image2.setImageResource(getDrawable(platform = item[2].name))
                    image6.setImageResource(getDrawable(platform = item[3].name))
                    image3.setImageResource(getDrawable(platform = item[4].name))
                    image7.setImageResource(getDrawable(platform = item[5].name))
                    image4.setImageResource(getDrawable(platform = item[6].name))
                    image8.setImageResource(getDrawable(platform = item[7].name))
                }
            }
        }
    }

}