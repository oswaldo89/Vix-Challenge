package com.oswaldo.vixtest.home.di

import android.content.Context
import com.oswaldo.vixtest.home.data.datasource.MoviesRemoteDataSource
import com.oswaldo.vixtest.home.data.repository.DefaultMoviesRepository
import com.oswaldo.vixtest.home.domain.repository.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class HomeModule {
    @Provides
    fun provideDefaultMoviesRepository(apiService: MoviesRemoteDataSource , context: Context): MoviesRepository = DefaultMoviesRepository(apiService, context)
}
