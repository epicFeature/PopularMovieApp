package com.popularmovieapp.movielist.domain

import javax.inject.Inject

class GetMovieListUseCase @Inject constructor(
    private val movieListRepository: MovieListRepository
){
     suspend operator fun invoke(): List<Movie> {
        return movieListRepository.getMovieListData()
    }
}