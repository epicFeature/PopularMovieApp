package com.popularmovieapp.network.movielist.item

import com.popularmovieapp.network.movielist.model.MovieData
import com.popularmovieapp.network.movielist.model.MovieListDataModel

data class Movie(
    val id: Int,
    val name: String,
    val alternativeName: String,
    val poster: String,
    val rating: String
) {

}

fun MovieData.toMovie() = Movie(id, name, alternativeName, poster.url, rating.kp.toString())