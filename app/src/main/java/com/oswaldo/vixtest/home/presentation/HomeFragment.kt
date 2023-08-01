package com.oswaldo.vixtest.home.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.oswaldo.vixtest.BaseFragment
import com.oswaldo.vixtest.R
import com.oswaldo.vixtest.core.utils.OneTimeEventObserver
import com.oswaldo.vixtest.databinding.FragmentHomeBinding
import com.oswaldo.vixtest.home.data.dto.EdgeX
import com.oswaldo.vixtest.home.data.dto.UiPage
import com.oswaldo.vixtest.home.presentation.adapters.IMovieEvent
import com.oswaldo.vixtest.home.presentation.adapters.IPageEvent
import com.oswaldo.vixtest.home.presentation.adapters.MovieListAdapter
import com.oswaldo.vixtest.home.presentation.adapters.MoviePosterListAdapter
import com.oswaldo.vixtest.home.presentation.adapters.PageAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment(), IMovieEvent, IPageEvent {

    private val viewModel: HomeViewModel by viewModels()

    private lateinit var pagesAdapter: PageAdapter
    private lateinit var posterMoviesAdapter: MoviePosterListAdapter
    private lateinit var originalMoviesAdapter: MovieListAdapter

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        observeState()
        observeNavigation()
        setupHorizontalRecyclerViews()

        viewModel.init()
        return binding.root
    }


    private fun observeState() {
        viewModel.stateLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is HomeViewModel.State.ShowOriginals -> setupData(
                    it.pages,
                    it.originalMovies,
                    it.postersMovies
                )

                else -> {}
            }
        }
    }

    private fun observeNavigation() {
        viewModel.navigationLiveData.observe(
            viewLifecycleOwner,
            OneTimeEventObserver {
                when (it) {
                    is HomeViewModel.Navigation.GoToDetail -> {
                        navController.navigate(R.id.action_homeFragment_to_detailFragment)
                    }
                }
            }
        )
    }

    private fun setupHorizontalRecyclerViews() {
        binding.apply {
            setupHorizontalRv(rvPages)
            setupHorizontalRv(rvOriginals)
            setupHorizontalRv(rvPosters)
        }
    }

    private fun setupData(pages: List<UiPage>, originalMovies: List<EdgeX>, postersMovies: List<EdgeX>) {
        binding.apply {
            pagesAdapter = PageAdapter(pages, this@HomeFragment)
            rvPages.adapter = pagesAdapter

            originalMoviesAdapter = MovieListAdapter(originalMovies, this@HomeFragment)
            rvOriginals.adapter = originalMoviesAdapter

            posterMoviesAdapter = MoviePosterListAdapter(postersMovies, this@HomeFragment)
            rvPosters.adapter = posterMoviesAdapter
        }
    }

    override fun onClickMovie(movie: EdgeX) {
        viewModel.onMovieClicked(movie)
    }

    override fun onClickPage(page: UiPage) {
        Log.v("page_clicked", page.pageName)
    }
}