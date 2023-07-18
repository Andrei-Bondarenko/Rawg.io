package com.example.main_page.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common.mvvm.BaseFragment
import com.example.detailed_page.DetailedFragment
import com.example.main_page.ui.adapter.MainAdapter
import com.example.rawgio.R
import com.example.rawgio.databinding.FragmentMainBinding
import com.example.utils.extentions.replaceScreen
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class MainFragment : BaseFragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding
    private val viewModel: MainViewModel by viewModel()
    private val adapter: MainAdapter =
        MainAdapter(getGames = { slug ->
            Timber.d("CALLED FUNCTION GETGAMESDATA WITH SLUG ==== $slug")
            viewModel.getGamesData(slug)
        },
            clickOnItem = { data ->
                replaceScreen(DetailedFragment.newInstance(itemData = data))
            }
        )

    private val layoutManager: LinearLayoutManager by lazy {
        LinearLayoutManager(context)
    }

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
            mainRecycler.layoutManager = layoutManager
            mainRecycler.setHasFixedSize(true)
            mainRecycler.adapter = adapter
            adapter.onAttachedToRecyclerView(mainRecycler)
        }
    }

    override fun bind() {
        with(viewModel) {
            observe(dataFlow) {
                adapter.setData(it)
            }
            observe((gamesData)) {
                adapter.setGamesData(it)
            }
            observe(isLoading) { isLoading ->
                binding.progressBar.isVisible = isLoading
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.mainRecycler.layoutManager = null

    }
}