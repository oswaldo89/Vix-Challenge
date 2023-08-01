package com.oswaldo.vixtest.home.presentation

import androidx.lifecycle.viewModelScope
import com.oswaldo.vixtest.core.BaseViewModel
import com.oswaldo.vixtest.home.data.dto.EdgeX
import com.oswaldo.vixtest.home.data.dto.UiPage
import com.oswaldo.vixtest.home.domain.usecase.GetOriginalMoviesUseCase
import com.oswaldo.vixtest.home.domain.usecase.GetPagesUseCase
import com.oswaldo.vixtest.home.domain.usecase.GetPostersMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private var pagesUseCase: GetPagesUseCase,
    private var originalMoviesUsecase: GetOriginalMoviesUseCase,
    private var postersMoviesUsecase: GetPostersMoviesUseCase
) : BaseViewModel<HomeViewModel.State, HomeViewModel.Navigation>() {
    private var dataHasBeenLoaded = false
    fun init() {
        viewModelScope.launch {
            if (!dataHasBeenLoaded) {
                setState(
                    State.ShowOriginals(
                        pagesUseCase(),
                        originalMoviesUsecase(),
                        postersMoviesUsecase()
                    )
                )
                dataHasBeenLoaded = true
            }
        }
    }

    fun onMovieClicked(data: EdgeX) {
        navigateTo(Navigation.GoToDetail(data))
    }

    sealed class State {
        class ShowOriginals(
            val pages: List<UiPage>,
            val originalMovies: List<EdgeX>,
            val postersMovies: List<EdgeX>
        ) : State()
    }

    sealed class Navigation {
        class GoToDetail(val data: EdgeX) : Navigation()
    }
}