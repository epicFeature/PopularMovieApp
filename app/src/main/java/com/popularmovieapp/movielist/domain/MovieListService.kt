package com.popularmovieapp.movielist.domain

import com.popularmovieapp.movielist.api.MovieListDataApi
import com.popularmovieapp.movielist.api.model.MovieData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieListService @Inject constructor(private val movieListDataApi: MovieListDataApi) {

    suspend fun getMovieListData(): List<MovieData> {
        return withContext(Dispatchers.IO) {
            val movieList = movieListDataApi.getMovieListData()
            movieList.body()?.docs?: emptyList()
        }
    }
}