package com.walaa.shaaban.movie.presenter.ui.PopularMovie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.walaa.shaaban.movie.data.model.PopularMovieModel
import com.walaa.shaaban.movie.data.repository.MoviePopularRepository
import io.reactivex.disposables.CompositeDisposable

class PopularMovieViewModel(var moviePopularRepository: MoviePopularRepository) : ViewModel() {

    lateinit var compositeDisposable: CompositeDisposable

    init {
        compositeDisposable = CompositeDisposable()
        moviePopularRepository = MoviePopularRepository()
    }

    val getPopularMovie: LiveData<PopularMovieModel> by lazy { moviePopularRepository.fetchPopularMovie(compositeDisposable)}


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}