package com.walaa.shaaban.movie.data.model


import com.google.gson.annotations.SerializedName

data class Movies(

    @SerializedName("poster_path")
    val posterPath: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("id")
    val id: Int,

    @SerializedName("release_date")
    val releaseDate: String
)