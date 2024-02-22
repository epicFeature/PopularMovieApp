package com.popularmovieapp.api.moviedetail.model


data class MovieDetailData(val rating: Rating?,
                           val id:Int,
                           val description: String?,
                           val name: String?,
                           val year: Int?,
                           val movieLength: Int?,
                           val genres:List<Genres>,
                           val type:String,
                           val alternativeName:String?,
                           val seasonsInfo:List<Season>?,
                           val releaseYears:List<Years>?,
                           val poster: Poster)
