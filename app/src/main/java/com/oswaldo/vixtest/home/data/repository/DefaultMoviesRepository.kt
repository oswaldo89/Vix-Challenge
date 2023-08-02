package com.oswaldo.vixtest.home.data.repository

import android.content.Context
import com.google.gson.Gson
import com.oswaldo.vixtest.home.data.datasource.MoviesRemoteDataSource
import com.oswaldo.vixtest.home.data.dto.DataUiPage
import com.oswaldo.vixtest.home.data.dto.EdgeX
import com.oswaldo.vixtest.home.data.dto.UiPage
import com.oswaldo.vixtest.home.domain.repository.MoviesRepository


class DefaultMoviesRepository(
    private val remoteDataSource: MoviesRemoteDataSource,
    private val context: Context
) : MoviesRepository {
    override suspend fun getPages(): List<UiPage> {
        return listOf(
            UiPage(pageName = "Inicio", selected = true),
            UiPage(pageName = "Cine", selected = false),
            UiPage(pageName = "Novelas", selected = false),
            UiPage(pageName = "Premium", selected = false),
            UiPage(pageName = "Series", selected = false),
            UiPage(pageName = "Kids", selected = false)
        )
    }

    // if the data comes from the endpoint, we can use remoteDataSource
    // but for this example, use a local json provided by the company
    override suspend fun getOriginalMovies(): List<EdgeX> {
        return getMoviesByCursor(ORIGINALS_ID)
    }

    override suspend fun getPosters(): List<EdgeX> {
        return getMoviesByCursor(POSTERS_ID)
    }

    override suspend fun getPremium(): List<EdgeX> {
        return getMoviesByCursor(PREMIUM_ID)
    }

    private fun getSource(): DataUiPage {
        val json: String = context.assets.open(JSON_FILE_NAME).bufferedReader().use { it.readText() }
        val gson = Gson()
        return gson.fromJson(json, DataUiPage::class.java)
    }

    private fun getMoviesByCursor(cursor: String): List<EdgeX> {
        val source = getSource()
        val movies = source.data.uiPage.uiModules?.edges?.find { it.cursor == cursor }
        return movies?.node?.contents?.edges.orEmpty()
    }

    companion object {
        const val JSON_FILE_NAME = "inicio.json"
        const val ORIGINALS_ID = "88751ce876862c81cae3571981aa248f78234886"
        const val POSTERS_ID = "af4be6c5b08f667d454359ea9646d896110cdaad"
        const val PREMIUM_ID = "9a112fe3774f30e5726850372ee39e07a31cc29c"
    }
}