package com.oswaldo.vixtest.home.presentation.adapters

import com.oswaldo.vixtest.home.data.dto.UiPage

interface IPageEvent {
    fun onClickPage(page: UiPage)
}