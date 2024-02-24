package com.popularmovieapp.network.movielist

import com.popularmovieapp.network.movielist.model.MovieListDataModel
import com.popularmovieapp.network.common.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface MovieListDataApi {
//
    @GET(Constants.MOVIE_LIST_ENDPOINT)
    suspend fun getMovieListData(): Response<MovieListDataModel>
}