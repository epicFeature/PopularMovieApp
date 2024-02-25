package com.popularmovieapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.popularmovieapp.movielist.domain.GetMovieListUseCase
import com.popularmovieapp.movielist.domain.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    application: Application,
    private val getMovieListUseCase: GetMovieListUseCase
) : AndroidViewModel(application) {
    private val _movies = MutableStateFlow(emptyList<Movie>())
    val movies: StateFlow<List<Movie>>
        get() = _movies

    init {
        getMovieList()
    }

    private fun getMovieList() {
        viewModelScope.launch {
            try {
                _movies.value = getMovieListUseCase()
            } catch (e: Exception) {
                Log.e("GetMovie", "Ошибка при поиске фильмов", e)
            }
        }
    }
}