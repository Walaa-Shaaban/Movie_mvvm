package com.walaa.shaaban.movie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.walaa.shaaban.movie.data.model.PopularMovieModel
import com.walaa.shaaban.movie.data.repository.MovieDetailsRepository
import com.walaa.shaaban.movie.data.repository.MoviePopularRepository
import com.walaa.shaaban.movie.presenter.adapter.PopulerMovieAdapter
import com.walaa.shaaban.movie.presenter.ui.DetailsMovie.DetailsMovieViewModel
import com.walaa.shaaban.movie.presenter.ui.PopularMovie.PopularMovieViewModel
import kotlinx.android.synthetic.main.activity_popular_movie.*


class PopularMovieActivity : AppCompatActivity() {

    lateinit var popularMovieModel: PopularMovieModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popular_movie)

        getViewModel()
        rv_movie_list.layoutManager = LinearLayoutManager(this)
        getViewModel().getPopularMovie.observe(this, Observer {
            rv_movie_list.adapter = PopulerMovieAdapter(it, this)

        })


    }

    //Send args using factory
    fun getViewModel(): PopularMovieViewModel {
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return PopularMovieViewModel(MoviePopularRepository()) as T
            }
        })[PopularMovieViewModel::class.java]
    }
}


