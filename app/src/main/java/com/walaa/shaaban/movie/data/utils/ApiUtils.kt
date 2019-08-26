package com.walaa.shaaban.movie.data.utils

import com.walaa.shaaban.movie.data.remote.MovieRetrofit
import com.walaa.shaaban.movie.data.remote.MoviesService

object ApiUtils {

    val BASE_URL = "https://api.themoviedb.org/3/"
    val apiService:MoviesService = MovieRetrofit.getClient()?.create(MoviesService::class.java)!!
    val API_KEY = "77a55d760786b1d3455d3b44ae00f0df"
    val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342"

}