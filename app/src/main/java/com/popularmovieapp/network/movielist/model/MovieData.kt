package com.popularmovieapp.network.movielist.model

import com.popularmovieapp.network.moviedetail.model.Genres
import com.popularmovieapp.network.moviedetail.model.Poster
import com.popularmovieapp.network.moviedetail.model.Rating


data class MovieData(
    val id: Int,
    val name: String,
    val alternativeName: String,
    val poster: Poster,
    val rating: Rating,
    val description: String,
    val genres: List<Genres>
)
