package com.walaa.shaaban.movie.data.remote

import androidx.lifecycle.LiveData
import com.walaa.shaaban.movie.data.model.DetailsMovieModel
import com.walaa.shaaban.movie.data.model.PopularMovieModel
import io.reactivex.Single
import retrofit2.http.*

interface MoviesService {

    //https://api.t/hemoviedb.org/3/movie/popular?api_key=77a55d760786b1d3455d3b44ae00f0df&language=en-US&page=2

    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") api_key : String,
        @Query("language") language : String,
        @Query("page") page : Int
    ):Single<PopularMovieModel>

    @GET("movie/{movie_id}")
    fun getDetailMovieService(
        @Path("movie_id") movie_id: Int,
        @Query("api_key") api_key : String
    ): Single<DetailsMovieModel>


}