package com.oswaldo.vixtest.detail.domain.usecase

import com.oswaldo.vixtest.home.data.dto.EdgeX
import com.oswaldo.vixtest.home.data.dto.UiPage
import com.oswaldo.vixtest.home.domain.repository.MoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(private val moviesRepository: MoviesRepository) {
    suspend operator fun invoke(parentCursor: String, cursor: String): EdgeX {
        return withContext(Dispatchers.IO) {
            moviesRepository.getDetail(parentCursor, cursor)
        }
    }
}