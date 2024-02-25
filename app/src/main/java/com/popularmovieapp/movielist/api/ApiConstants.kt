package com.popularmovieapp.movielist.api

object ApiConstants {
    const val BASE_URL = "https://api.kinopoisk.dev"
    const val MOVIE_LIST_ENDPOINT =
        "/v1.4/movie?page=1&limit=15&sortField=votes.kp&sortType=-1&votes.kp=1000000-10000000"
}
