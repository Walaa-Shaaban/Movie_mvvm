package com.walaa.shaaban.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.walaa.shaaban.movie.data.repository.MovieDetailsRepository
import com.walaa.shaaban.movie.data.utils.ApiUtils
import com.walaa.shaaban.movie.presenter.ui.DetailsMovie.DetailsMovieViewModel
import kotlinx.android.synthetic.main.activity_details_movie.*

class DetailsMovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_movie)

        getViewModel().getMovieDetails.observe(this, Observer {it ->
            Glide
                .with(this)
                .load("${ApiUtils.POSTER_BASE_URL}${it.poster_path}")
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(iv_movie_poster)


            movie_title.text = it.title
            movie_tagline.text = it.tagline
            movie_release_date.text = it.release_date
            movie_runtime.text = it.runtime.toString() + " minutes"
            movie_overview.text = it.overview

        })

    }

    //Send args using factory
    fun getViewModel(): DetailsMovieViewModel{
        return ViewModelProviders.of(this,object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>):T{
                return DetailsMovieViewModel(MovieDetailsRepository(),intent.getIntExtra("id", 1)) as T
            }

        })[DetailsMovieViewModel::class.java]
    }
}
