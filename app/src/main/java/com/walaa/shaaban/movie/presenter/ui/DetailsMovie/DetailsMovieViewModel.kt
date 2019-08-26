package com.walaa.shaaban.movie.presenter.ui.DetailsMovie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.walaa.shaaban.movie.data.model.DetailsMovieModel
import com.walaa.shaaban.movie.data.remote.MoviesService
import com.walaa.shaaban.movie.data.repository.MovieDetailsRepository
import com.walaa.shaaban.movie.data.utils.ApiUtils
import io.reactivex.disposables.CompositeDisposable

class DetailsMovieViewModel (var movieDetailsRepository: MovieDetailsRepository,  movie_id : Int) : ViewModel(){

    lateinit var compositeDisposable: CompositeDisposable

    init {
       compositeDisposable = CompositeDisposable()
        movieDetailsRepository = MovieDetailsRepository()

    }

    /*
    lazy when we need livedata nit when we initalize
     */
    val getMovieDetails : LiveData<DetailsMovieModel> by lazy {
        movieDetailsRepository.fetchMovieDetails(compositeDisposable = compositeDisposable,move_id = movie_id)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}