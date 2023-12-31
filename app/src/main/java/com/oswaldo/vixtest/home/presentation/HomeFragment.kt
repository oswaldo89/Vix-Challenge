package com.oswaldo.vixtest.home.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.oswaldo.vixtest.BaseFragment
import com.oswaldo.vixtest.R
import com.oswaldo.vixtest.core.utils.OneTimeEventObserver
import com.oswaldo.vixtest.core.utils.startAutoScroll
import com.oswaldo.vixtest.core.utils.stopAutoScroll
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

    private var posterList: List<EdgeX>? = null
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var pagesAdapter: PageAdapter
    private lateinit var posterMoviesAdapter: MoviePosterListAdapter
    private lateinit var originalMoviesAdapter: MovieListAdapter
    private lateinit var premiumMoviesAdapter: MovieListAdapter
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
                    it.postersMovies,
                    it.premiumMovies
                )
                is HomeViewModel.State.EmptyView -> showEmptyView()
                else -> {}
            }
        }
    }

    private fun showEmptyView() {
        binding.run {
            homeScroll.visibility = View.GONE
            emptyLayout.visibility = View.VISIBLE
            stopAutoScroll()
        }
    }

    private fun showDataView() {
        binding.run {
            homeScroll.visibility = View.VISIBLE
            emptyLayout.visibility = View.GONE
        }
    }

    private fun observeNavigation() {
        viewModel.navigationLiveData.observe(
            viewLifecycleOwner,
            OneTimeEventObserver {
                when (it) {
                    is HomeViewModel.Navigation.GoToDetail -> {
                        navController.navigate(R.id.action_homeFragment_to_detailFragment, it.args)
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
            setupHorizontalRv(rvPremium)
        }
    }

    private fun setupData(pages: List<UiPage>, originalMovies: List<EdgeX>, postersMovies: List<EdgeX>, premiumMovies: List<EdgeX>) {
        binding.apply {
            posterList = postersMovies
            pagesAdapter = PageAdapter(pages, this@HomeFragment)
            rvPages.adapter = pagesAdapter

            posterMoviesAdapter = MoviePosterListAdapter(postersMovies, this@HomeFragment)
            rvPosters.adapter = posterMoviesAdapter
            startAutoScroll()

            originalMoviesAdapter = MovieListAdapter(originalMovies, this@HomeFragment)
            rvOriginals.adapter = originalMoviesAdapter

            premiumMoviesAdapter = MovieListAdapter(premiumMovies, this@HomeFragment)
            rvPremium.adapter = premiumMoviesAdapter

            showDataView()
        }
    }

    override fun onClickMovie(movie: EdgeX) {
        viewModel.onMovieClicked(movie)
    }

    override fun onClickPage(page: UiPage) {
        viewModel.onPageClicked(page)
    }

    override fun onPause() {
        super.onPause()
        stopAutoScroll()
    }

    private fun startAutoScroll() {
        posterList?.let {
            startAutoScroll(binding.rvPosters,it, AUTO_SCROLL_DELAY)
        }
    }

    companion object {
        private const val AUTO_SCROLL_DELAY: Long = 3000
    }
}