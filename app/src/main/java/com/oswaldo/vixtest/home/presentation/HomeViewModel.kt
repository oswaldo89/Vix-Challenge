package com.oswaldo.vixtest.home.presentation

import androidx.lifecycle.viewModelScope
import com.oswaldo.vixtest.core.BaseViewModel
import com.oswaldo.vixtest.home.data.dto.EdgeX
import com.oswaldo.vixtest.home.data.dto.NodeX
import com.oswaldo.vixtest.home.domain.usecase.GetOriginalMovies
import com.oswaldo.vixtest.home.domain.usecase.GetPages
import com.oswaldo.vixtest.home.domain.usecase.GetPostersMovies
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private var pages : GetPages,
    private var originalMovies: GetOriginalMovies,
    private var postersMovies: GetPostersMovies
) : BaseViewModel<HomeViewModel.State, Unit>() {
    fun init() {
        viewModelScope.launch {
            val postersMovies = postersMovies()
            val originalModels = originalMovies()
            setState(State.ShowOriginals(originalModels, postersMovies))
        }
    }

    sealed class State {
        class ShowOriginals(
            val originalMovies: List<EdgeX>,
            val postersMovies: List<EdgeX>
        ) : State()
    }

    sealed class Navigation {
        // inject navigation
    }
}