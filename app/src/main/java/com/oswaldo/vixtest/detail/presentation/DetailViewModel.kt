package com.oswaldo.vixtest.detail.presentation

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.oswaldo.vixtest.core.BaseViewModel
import com.oswaldo.vixtest.detail.domain.usecase.GetMovieDetailUseCase
import com.oswaldo.vixtest.home.data.dto.EdgeX
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private var detailUseCase: GetMovieDetailUseCase
) : BaseViewModel<DetailViewModel.State, Unit>() {

    fun init(parentCursor: String, cursor: String) {
        viewModelScope.launch {
            val detail = detailUseCase(parentCursor, cursor)
            setState(State.ShowData(detail))
            Log.v("oswaldo_detail", "${detail.node.clickTrackingJson.uiContentTitle}")
        }
    }

    sealed class State {
        class ShowData(
            val data: EdgeX
        ) : State()
    }
}