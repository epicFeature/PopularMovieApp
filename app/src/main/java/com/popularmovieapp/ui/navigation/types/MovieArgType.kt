package com.popularmovieapp.ui.navigation.types

import com.google.gson.Gson
import com.popularmovieapp.movielist.domain.Movie

class MovieArgType : JsonNavType<Movie>() {
    private val gson = Gson()
    override fun fromJsonParse(value: String): Movie =
        gson.fromJson(value, Movie::class.java)

    override fun Movie.getJsonParse(): String =
        gson.toJson(this)
}