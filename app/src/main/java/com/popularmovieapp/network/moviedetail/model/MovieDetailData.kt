package com.popularmovieapp.network.moviedetail.model


data class MovieDetailData(val rating: Rating?,
                           val id:Int,
                           val description: String?,
                           val name: String?,
                           val genres:List<Genres>,
                           val alternativeName:String?,
                           val poster: Poster)
