package com.example.main_page.ui.adapter.controllers

import android.view.ViewGroup
import coil.load
import com.example.main_page.model.games.GamesResults
import com.example.main_page.model.games.Platforms
import com.example.rawgio.R
import com.example.rawgio.databinding.ItemHorizontalRecyclerBinding
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
            platforms.forEach { it.setImageResource(R.drawable.ic_loading) }
            platformsList.forEach {
                Timber.d("PLATFORMS SIZE ==== ${platforms.size}")
                if(i < 10) {
                    when (it.name) {
                        "PC" -> platforms[i].setImageResource(R.drawable.ps)
                        "iOS" -> platforms[i].setImageResource(R.drawable.ic_ios)
                        "Android" -> platforms[i].setImageResource(R.drawable.ic_android)
                        "macOS" -> platforms[i].setImageResource(R.drawable.ic_macos)
                        "Linux" -> platforms[i].setImageResource(R.drawable.ic_linux)
                        "GameCube" -> platforms[i].setImageResource(R.drawable.nintendo_gamecube)
                        "Classic Macintosh" -> platforms[i].setImageResource(R.drawable.masintosh)
                        "Apple II" -> platforms[i].setImageResource(R.drawable.apple_ii)
                        "Commodore / Amiga" -> platforms[i].setImageResource(R.drawable.amiga)
                        "Genesis" -> platforms[i].setImageResource(R.drawable.genesis)
                        "Dreamcast" -> platforms[i].setImageResource(R.drawable.dreamcast)
                        "3DO" -> platforms[i].setImageResource(R.drawable._3do)
                        "Jaguar" -> platforms[i].setImageResource(R.drawable.jaguar)
                        "Game Gear" -> platforms[i].setImageResource(R.drawable.game_gear)
                        "Neo Geo" -> platforms[i].setImageResource(R.drawable.neo_geo)
                        "SEGA Saturn" -> platforms[i].setImageResource(R.drawable.sega_saturn)
                        "SEGA CD" -> platforms[i].setImageResource(R.drawable.sega_cd)
                        "SEGA 32X" -> platforms[i].setImageResource(R.drawable.sega_32x)
                        "SEGA Master System" -> platforms[i].setImageResource(R.drawable.sega_master_system)
                        "Atari 7800" -> platforms[i].setImageResource(R.drawable.atari_7800)
                        "Atari 5200" -> platforms[i].setImageResource(R.drawable.atari_5200)
                        "Atari 2600" -> platforms[i].setImageResource(R.drawable.atari_2600)
                        "Atari 8-bit" -> platforms[i].setImageResource(R.drawable.atari_8bit)
                        "Atari ST" -> platforms[i].setImageResource(R.drawable.atari_st)
                        "Atari Lynx" -> platforms[i].setImageResource(R.drawable.atari_linx)
                        "Atari XEGS" -> platforms[i].setImageResource(R.drawable.atari_xe)
                        "Atari Flashback" -> platforms[i].setImageResource(R.drawable.atari_flashbsck)
                        "Game Boy Advance" -> platforms[i].setImageResource(R.drawable.game_boy_advance)
                        "Game Boy Color" -> platforms[i].setImageResource(R.drawable.game_boy_color)
                        "Game Boy" -> platforms[i].setImageResource(R.drawable.game_boy)
                        "Wii U" -> platforms[i].setImageResource(R.drawable.wii_u)
                        "Wii" -> platforms[i].setImageResource(R.drawable.wii)
                        "Xbox One" -> platforms[i].setImageResource(R.drawable.xbox_one)
                        "Xbox" -> platforms[i].setImageResource(R.drawable.ic_xbox)
                        "Xbox 360" -> platforms[i].setImageResource(R.drawable.xbox_360)
                        "Xbox Series S/X" -> platforms[i].setImageResource(R.drawable.xbox_series)
                        "PlayStation 5" -> platforms[i].setImageResource(R.drawable.ic_ps5)
                        "PlayStation 4" -> platforms[i].setImageResource(R.drawable.ic_ps4)
                        "PlayStation 3" -> platforms[i].setImageResource(R.drawable.ic_ps3)
                        "PlayStation 2" -> platforms[i].setImageResource(R.drawable.ps_2)
                        "PlayStation" -> platforms[i].setImageResource(R.drawable.ps)
                        "PS Vita" -> platforms[i].setImageResource(R.drawable.ps_vita)
                        "PSP" -> platforms[i].setImageResource(R.drawable.psp)
                        "Nintendo Switch" -> platforms[i].setImageResource(R.drawable.ic_nintendo)
                        "Nintendo 3DS" -> platforms[i].setImageResource(R.drawable.nintendo_3ds)
                        "Nintendo DS" -> platforms[i].setImageResource(R.drawable.nintendo_ds)
                        "Nintendo DSi" -> platforms[i].setImageResource(R.drawable.nintendo_ds)
                        "Nintendo 64" -> platforms[i].setImageResource(R.drawable.nintendo_64)
                        "SNES" -> platforms[i].setImageResource(R.drawable.snes)
                        "NES" -> platforms[i].setImageResource(R.drawable.nes)
                    }
                    i++
                }
            }
        }
    }
}