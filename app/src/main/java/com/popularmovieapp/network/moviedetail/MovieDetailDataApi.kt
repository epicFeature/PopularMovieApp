package com.popularmovieapp.network.moviedetail

import com.popularmovieapp.network.moviedetail.model.MovieDetailData
import com.popularmovieapp.network.common.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface MovieDetailDataApi {

    @GET(Constants.MOVIE_DETAIL_ENDPOINT)
    suspend fun getMovieDetailData(
        @Path("id") id: String
    ): Response<MovieDetailData>
}