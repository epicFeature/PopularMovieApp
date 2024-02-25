package com.popularmovieapp.movielist.domain

import javax.inject.Inject

class MovieListRepository @Inject constructor(private val movieListService: MovieListService){
    suspend fun getMovieListData(): List<Movie> {
        return movieListService.getMovieListData().map { it.toMovie() }
    }
}