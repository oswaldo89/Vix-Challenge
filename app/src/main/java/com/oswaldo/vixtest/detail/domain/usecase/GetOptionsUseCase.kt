package com.oswaldo.vixtest.detail.domain.usecase

import com.oswaldo.vixtest.home.data.dto.UiPage
import com.oswaldo.vixtest.home.domain.repository.MoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetOptionsUseCase @Inject constructor(private val moviesRepository: MoviesRepository) {
    suspend operator fun invoke(): List<UiPage> {
        return withContext(Dispatchers.IO) {
            moviesRepository.getDetailOptions()
        }
    }
}