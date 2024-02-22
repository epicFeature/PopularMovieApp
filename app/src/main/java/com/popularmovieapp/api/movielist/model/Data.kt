package com.popularmovieapp.api.movielist.model

data class Data(
val id: Int,
val name: String,
val alternativeName: String,
val year: Int,
val poster: String?,
val rating: Double
)
