package com.walaa.shaaban.movie.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.walaa.shaaban.movie.data.model.PopularMovieModel
import com.walaa.shaaban.movie.data.utils.ApiUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class MoviePopularRepository() {

    var popularMovies: MutableLiveData<PopularMovieModel> = MutableLiveData()

    fun fetchPopularMovie(compositeDisposable: CompositeDisposable): LiveData<PopularMovieModel> {
        compositeDisposable.add(
            ApiUtils.apiService.getPopularMovies(ApiUtils.API_KEY, "en-US", 2)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    Consumer {
                        popularMovies.value = it
                    }
                ))
        return popularMovies
    }

    fun getPopularMovies(): LiveData<PopularMovieModel>{
        return popularMovies
    }


}