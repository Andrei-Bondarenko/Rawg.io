package com.example.main_page.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common.mvvm.BaseFragment
import com.example.detailed_page.DetailedFragment
import com.example.main_page.model.games.GamesResults
import com.example.main_page.ui.adapter.controllers.GamesController
import com.example.main_page.ui.adapter.controllers.GenreController
import com.example.rawgio.R
import com.example.rawgio.databinding.FragmentMainBinding
import com.example.utils.extentions.hideAndAddFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.surfstudio.android.easyadapter.EasyAdapter
import ru.surfstudio.android.easyadapter.ItemList

class MainFragment : BaseFragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding
    private val viewModel: MainViewModel by viewModel()
    private val easyAdapter = EasyAdapter()

    private val layoutManager: LinearLayoutManager by lazy {
        LinearLayoutManager(context)
    }

    private val gamesController = GamesController(
        onGameItemClicked = { onGameItemClicked(it) },
        onLoadGames = { genre, page, _ ->
            viewModel.loadGames(
                genre,
                page
            )
        }
    )

    private val genreController = GenreController()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun initViews(view: View) {
        with(binding) {
            mainRecycler.adapter = easyAdapter
        }
    }

    override fun bind() {
        with(viewModel) {

            observe(mainUi) { mainUiList ->

                val itemList = ItemList.create()

                mainUiList.forEach { item ->
                    when (item) {
                        is MainUi.GamesList -> itemList.add(item, gamesController)
                        is MainUi.Genre -> itemList.add(item, genreController)
                    }
                }
                easyAdapter.setItems(itemList)
            }

            observe(isLoading) { isLoading ->
                binding.progressBar.isVisible = isLoading
            }
        }
    }

    private fun onGameItemClicked(gameDetails: GamesResults) {
        val fragment = DetailedFragment.newInstance(gameDetails)
        parentFragmentManager.findFragmentById(R.id.fragmentContainer)?.let {
            it.hideAndAddFragment(
                addFragment = fragment,
                id = R.id.fragmentContainer
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.mainRecycler.layoutManager = null

    }
}