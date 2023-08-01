package com.oswaldo.vixtest.home.domain.usecase

import com.oswaldo.vixtest.home.data.dto.UiPage
import com.oswaldo.vixtest.home.domain.repository.MoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetPagesUseCase @Inject constructor(private val moviesRepository: MoviesRepository) {
    suspend operator fun invoke(): List<UiPage> {
        return withContext(Dispatchers.IO) {
            moviesRepository.getPages()
        }
    }
}