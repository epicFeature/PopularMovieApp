package com.popularmovieapp.movielist.api.model


data class MovieData(
    val id: Int?,
    val name: String?,
    val alternativeName: String?,
    val poster: Poster?,
    val rating: Rating?,
    val description: String?,
    val genres: List<Genres>?
)
