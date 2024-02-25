package com.popularmovieapp.movielist.domain

import android.net.Uri
import com.google.gson.Gson
import com.popularmovieapp.movielist.api.model.Genres
import com.popularmovieapp.movielist.api.model.MovieData

data class Movie(
    val id: Int,
    val name: String,
    val alternativeName: String,
    val poster: String,
    val rating: String,
    val description: String,
    val genres: String
) {

    override fun toString(): String = Uri.encode(Gson().toJson(this))

    companion object {
        fun fromJson(json: String): Movie = Gson().fromJson(json, Movie::class.java)

    }
}

fun MovieData.toMovie() = Movie(
    id = id ?: 0,
    name = name ?: "",
    alternativeName = alternativeName ?: "",
    poster = poster?.url ?: "",
    rating = rating?.kp.toString().substring(0, 3),
    description = description ?: "",
    genres = genresMapping(genres ?: emptyList())
)


fun genresMapping(genres: List<Genres>): String {
    val genreNames = mutableListOf<String>()
    genres.forEach {
        genreNames.add(it.name)
    }
    return genreNames.joinToString(", ")
}