package com.oswaldo.vixtest.home.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.oswaldo.vixtest.core.utils.OneTimeEventObserver
import com.oswaldo.vixtest.databinding.FragmentHomeBinding
import com.oswaldo.vixtest.home.data.dto.EdgeX
import com.oswaldo.vixtest.home.presentation.adapters.IMovieEvent
import com.oswaldo.vixtest.home.presentation.adapters.MovieListAdapter
import com.oswaldo.vixtest.home.presentation.adapters.MoviePosterListAdapter
import dagger.hilt.android.AndroidEntryPoint

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

@AndroidEntryPoint
class HomeFragment : Fragment(), IMovieEvent {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var originalMoviesAdapter: MovieListAdapter
    private lateinit var posterMoviesAdapter: MoviePosterListAdapter

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        viewModel.init()

        setupRecyclerView()
        observeState()
        observeNavigation()

        return binding.root
    }

    private fun setupRecyclerView() {
        binding.apply {
            rvPosters.layoutManager = createHorizontalLinearLayout()
            rvOriginals.layoutManager = createHorizontalLinearLayout()
        }
    }

    private fun createHorizontalLinearLayout() = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

    private fun observeState() {
        viewModel.stateLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is HomeViewModel.State.ShowOriginals -> showOriginals(it.originalMovies, it.postersMovies)
                else -> {}
            }
        }
    }

    private fun showOriginals(originalMovies: List<EdgeX>, postersMovies: List<EdgeX>) {
        binding.apply {
            originalMoviesAdapter = MovieListAdapter(originalMovies, this@HomeFragment)
            rvOriginals.adapter = originalMoviesAdapter

            posterMoviesAdapter = MoviePosterListAdapter(postersMovies, this@HomeFragment)
            rvPosters.adapter = posterMoviesAdapter
        }
    }

    private fun observeNavigation() {
        viewModel.navigationLiveData.observe(
            viewLifecycleOwner,
            OneTimeEventObserver {
                when (it) {
                    //is HomeViewModel.Navigation.NAME -> {}
                }
            }
        )
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onClickMovie(movie: EdgeX) {

    }
}