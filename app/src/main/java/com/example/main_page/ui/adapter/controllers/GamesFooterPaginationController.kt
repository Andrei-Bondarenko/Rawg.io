package com.example.main_page.ui.adapter.controllers

import android.view.View
import android.view.ViewGroup
import com.example.rawgio.R
import com.example.rawgio.databinding.LayoutPaginationFooterBinding
import ru.surfstudio.android.easyadapter.pagination.EasyPaginationAdapter
import ru.surfstudio.android.easyadapter.pagination.PaginationState

class GamesFooterPaginationController :
    EasyPaginationAdapter.BasePaginationFooterController<GamesFooterPaginationController.Holder>() {

    override fun createViewHolder(
        parent: ViewGroup,
        listener: EasyPaginationAdapter.OnShowMoreListener
    ): Holder {
        return Holder(parent, listener)
    }

    inner class Holder(
        parent: ViewGroup,
        listener: EasyPaginationAdapter.OnShowMoreListener
    ) : EasyPaginationAdapter.BasePaginationFooterHolder(
        parent,
        R.layout.layout_pagination_footer
    ) {

        private val binding: LayoutPaginationFooterBinding =
            LayoutPaginationFooterBinding.bind(itemView)

        init {
            with(binding) {
                tryAgainBtn.setOnClickListener { listener.onShowMore() }
                progressBar.visibility = View.GONE
                tryAgainBtn.visibility = View.GONE
            }
        }

        override fun bind(state: PaginationState) {

            with(binding) {
                when (state) {
                    PaginationState.READY -> {
                        progressBar.visibility = View.VISIBLE
                        tryAgainBtn.visibility = View.GONE
                    }

                    PaginationState.COMPLETE -> {
                        progressBar.visibility = View.GONE
                        tryAgainBtn.visibility = View.GONE
                    }

                    PaginationState.ERROR -> {
                        progressBar.visibility = View.GONE
                        tryAgainBtn.visibility = View.VISIBLE
                    }

                    else -> throw IllegalArgumentException("unsupported state: $state")
                }
            }
        }
    }
}