package com.popularmovieapp.network.movielist.domain

import com.popularmovieapp.network.movielist.item.Movie
import com.popularmovieapp.network.repository.MovieListRepository
import javax.inject.Inject

class GetMovieListUseCase @Inject constructor(
    private val movieListRepository: MovieListRepository
){
     suspend operator fun invoke(): List<Movie> {
        return movieListRepository.getMovieListData()
    }


}