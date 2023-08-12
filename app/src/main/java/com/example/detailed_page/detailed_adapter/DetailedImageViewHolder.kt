package com.example.detailed_page.detailed_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.main_page.model.games.Screenshots
import com.example.rawgio.R
import com.example.rawgio.databinding.ItemDetailGameBinding

class DetailedImageViewHolder(
    private val binding: ItemDetailGameBinding
) : RecyclerView.ViewHolder(binding.root) {

    constructor(parent: ViewGroup) : this(
        binding = ItemDetailGameBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    fun onBind(item: Screenshots) {
        with(binding) {
            imageView.load(item.image) {
                crossfade(true)
                placeholder(R.drawable.ic_loading)
            }
        }
    }

}