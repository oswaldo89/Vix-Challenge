package com.oswaldo.vixtest.home.domain.usecase

import com.oswaldo.vixtest.home.domain.repository.MoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetPages @Inject constructor(private val moviesRepository: MoviesRepository) {
    suspend operator fun invoke(): List<String> {
        return withContext(Dispatchers.IO) {
            moviesRepository.getPages()
        }
    }
}