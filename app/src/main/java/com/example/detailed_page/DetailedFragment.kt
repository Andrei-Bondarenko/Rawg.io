package com.example.detailed_page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.example.common.mvvm.BaseFragment
import com.example.detailed_page.detailed_adapter.Adapter
import com.example.main_page.model.games.GamesResults
import com.example.main_page.model.games.Platforms
import com.example.rawgio.R
import com.example.rawgio.databinding.FragmentDetailGamesBinding
import com.example.utils.Arguments
import com.example.utils.extentions.args
import com.example.utils.extentions.popScreen
import com.example.utils.extentions.withArgs

class DetailedFragment : BaseFragment(R.layout.fragment_detail_games) {

    private lateinit var binding: FragmentDetailGamesBinding
    private val adapter: Adapter by lazy {
        Adapter()
    }
    private val layoutManager: LinearLayoutManager by lazy {
        LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailGamesBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        fun newInstance(itemData: GamesResults) =
            DetailedFragment().withArgs(Arguments.DETAILS to itemData)
    }

    private val itemData: GamesResults by args(Arguments.DETAILS)

    override fun initViews(view: View) {
        with(binding) {
            imageViewRecycler.layoutManager = layoutManager
            imageViewRecycler.setHasFixedSize(true)
            imageViewRecycler.adapter = adapter
            adapter.onAttachedToRecyclerView(imageViewRecycler)
            releasedAtTextView.text = itemData.released
            lastUpdateTextView.text = itemData.updated.substring(0, 10)
            ratingBar.rating = itemData.rating.toFloat()
            imageView.load(itemData.background_image)
            gamingPlatformsTextView.text = setPlatforms(itemData.platforms)
            setPlatforms(itemData.platforms)
            toolBarName.text = itemData.name
            adapter.setData(itemData.screenshots)

            toolBarDetailPageTitle.setNavigationOnClickListener {
                popScreen()
            }
        }
    }

    override fun bind() {
    }

    private fun setPlatforms(platforms: List<Platforms>): String {
        var platformsString = ""
        for (i in platforms.indices) {
            if (i != platforms.size - 1) {
            platformsString = platformsString + platforms[i].name + ", "
            } else platformsString += platforms[i].name
        }
        return platformsString
    }

}