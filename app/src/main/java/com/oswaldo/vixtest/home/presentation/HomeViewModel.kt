package com.oswaldo.vixtest.home.presentation

import androidx.lifecycle.viewModelScope
import com.oswaldo.vixtest.core.BaseViewModel
import com.oswaldo.vixtest.home.data.dto.EdgeX
import com.oswaldo.vixtest.home.data.dto.UiPage
import com.oswaldo.vixtest.home.domain.usecase.GetOriginalMoviesUseCase
import com.oswaldo.vixtest.home.domain.usecase.GetPagesUseCase
import com.oswaldo.vixtest.home.domain.usecase.GetPostersMoviesUseCase
import com.oswaldo.vixtest.home.domain.usecase.GetPremiumMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private var pagesUseCase: GetPagesUseCase,
    private var originalMoviesUseCase: GetOriginalMoviesUseCase,
    private var postersMoviesUseCase: GetPostersMoviesUseCase,
    private var premiumMoviesUseCase: GetPremiumMoviesUseCase
) : BaseViewModel<HomeViewModel.State, HomeViewModel.Navigation>() {
    private var dataHasBeenLoaded = false
    fun init() {
        viewModelScope.launch {
            if (!dataHasBeenLoaded) {
                setState(
                    State.ShowOriginals(
                        pagesUseCase(),
                        originalMoviesUseCase(),
                        postersMoviesUseCase(),
                        premiumMoviesUseCase()
                    )
                )
                dataHasBeenLoaded = true
            }
        }
    }

    private fun forceReloadPage() {
        dataHasBeenLoaded = false
    }

    fun onMovieClicked(data: EdgeX) {
        navigateTo(Navigation.GoToDetail(data))
    }

    fun onPageClicked(page: UiPage) {
        // Simulation, only to show how state change to empty, imagine here call again the JSON
        if (page.pageName == "Inicio") {
            init()
        } else {
            forceReloadPage()
            setState(State.EmptyView)
        }
    }

    sealed class State {
        object EmptyView : State()
        class ShowOriginals(
            val pages: List<UiPage>,
            val originalMovies: List<EdgeX>,
            val postersMovies: List<EdgeX>,
            val premiumMovies: List<EdgeX>
        ) : State()
    }

    sealed class Navigation {
        class GoToDetail(val data: EdgeX) : Navigation()
    }
}