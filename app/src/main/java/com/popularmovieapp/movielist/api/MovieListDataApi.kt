package com.popularmovieapp.movielist.api

import com.popularmovieapp.movielist.domain.MovieListDataModel
import retrofit2.Response
import retrofit2.http.GET

interface MovieListDataApi {
    @GET(ApiConstants.MOVIE_LIST_ENDPOINT)
    suspend fun getMovieListData(): Response<MovieListDataModel>
}