package com.oswaldo.vixtest.home.presentation.adapters

import com.oswaldo.vixtest.home.data.dto.EdgeX

interface IMovieEvent {
    fun onClickMovie(movie: EdgeX)
}