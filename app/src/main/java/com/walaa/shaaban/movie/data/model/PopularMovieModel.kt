package com.walaa.shaaban.movie.data.model


import com.google.gson.annotations.SerializedName

data class PopularMovieModel(
    @SerializedName("results")
    val movies:  List<Movies>
)