package com.oswaldo.vixtest.home.domain.repository

import com.oswaldo.vixtest.home.data.dto.EdgeX
import com.oswaldo.vixtest.home.data.dto.UiPage

interface MoviesRepository {

    suspend fun getPages() : List<UiPage>

    suspend fun getOriginalMovies() : List<EdgeX>
    suspend fun getPosters() : List<EdgeX>
}