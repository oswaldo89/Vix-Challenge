package com.oswaldo.vixtest.home.domain.repository

import com.oswaldo.vixtest.home.data.dto.EdgeX

interface MoviesRepository {

    suspend fun getPages() : List<String>

    suspend fun getOriginalMovies() : List<EdgeX>
    suspend fun getPosters() : List<EdgeX>
}