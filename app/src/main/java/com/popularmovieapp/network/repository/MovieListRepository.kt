package com.popularmovieapp.network.repository

import com.popularmovieapp.network.data.MovieListService
import com.popularmovieapp.network.movielist.item.Movie
import com.popularmovieapp.network.movielist.item.toMovie
import javax.inject.Inject

class MovieListRepository @Inject constructor(private val movieListService: MovieListService){
    suspend fun getMovieListData(): List<Movie> {
        return movieListService.getMovieListData().map { it.toMovie() }
    }
}