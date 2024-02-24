package com.popularmovieapp.network.common

class Constants {
    companion object{
        const val BASE_URL = "https://api.kinopoisk.dev"
        const val MOVIE_LIST_ENDPOINT ="/v1.4/movie?page=1&limit=10&sortField=votes.kp&sortType=-1&votes.kp=1000000-10000000"
        const val MOVIE_DETAIL_ENDPOINT ="/v1.4/movie/{id}"
    }
}
