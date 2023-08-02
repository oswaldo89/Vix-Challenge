package com.oswaldo.vixtest.detail.presentation

import android.text.Html
import android.text.Spanned
import androidx.lifecycle.viewModelScope
import com.oswaldo.vixtest.core.BaseViewModel
import com.oswaldo.vixtest.detail.domain.usecase.GetFullDescriptionUseCase
import com.oswaldo.vixtest.detail.domain.usecase.GetMovieDetailUseCase
import com.oswaldo.vixtest.detail.domain.usecase.GetOptionsUseCase
import com.oswaldo.vixtest.home.data.dto.EdgeX
import com.oswaldo.vixtest.home.data.dto.UiPage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private var detailUseCase: GetMovieDetailUseCase,
    private var detailOptionsUseCase: GetOptionsUseCase,
    private var getFullDescriptionUseCase: GetFullDescriptionUseCase
) : BaseViewModel<DetailViewModel.State, Unit>() {

    fun init(parentCursor: String, cursor: String) {
        viewModelScope.launch {
            val detail = detailUseCase(parentCursor, cursor)
            val options = detailOptionsUseCase()
            setState(State.ShowData(detail, options))
        }
    }

    fun loadVideoImageCover(data: EdgeX): String {
        return data.node.video.imageAssets.find { it.imageRole == VERTICAL_HERO_TYPE }?.link.orEmpty()
    }

     fun getCompleteDescription(data: EdgeX): Spanned? {
        val content = getFullDescriptionUseCase.invoke(data)
        return Html.fromHtml(content, Html.FROM_HTML_MODE_COMPACT)
    }

    sealed class State {
        class ShowData(
            val data: EdgeX,
            val options: List<UiPage>
        ) : State()
    }

    companion object {
        const val VERTICAL_HERO_TYPE = "VERTICAL_HERO"
        const val LINE_BREAK = "<br/><br/>"
    }
}