package com.oswaldo.vixtest.home.domain.repository

import com.oswaldo.vixtest.home.data.dto.EdgeX
import com.oswaldo.vixtest.home.data.dto.UiPage

interface MoviesRepository {

    suspend fun getPages() : List<UiPage>

    suspend fun getDetailOptions() : List<UiPage>

    suspend fun getOriginalMovies() : List<EdgeX>
    suspend fun getPosters() : List<EdgeX>

    suspend fun getPremium() : List<EdgeX>

    suspend fun getDetail(parentCursor: String, cursor : String) : EdgeX
}