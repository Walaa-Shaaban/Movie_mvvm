package com.walaa.shaaban.movie.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.walaa.shaaban.movie.data.model.DetailsMovieModel
import com.walaa.shaaban.movie.data.remote.MoviesService
import com.walaa.shaaban.movie.data.utils.ApiUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class MovieDetailsRepository() {

    var movieDetails : MutableLiveData<DetailsMovieModel> = MutableLiveData()


    fun fetchMovieDetails(compositeDisposable: CompositeDisposable, move_id:Int) : LiveData<DetailsMovieModel>{

            compositeDisposable.add(
                ApiUtils.apiService.getDetailMovieService(move_id, ApiUtils.API_KEY)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                        Consumer {
                           movieDetails.value = it
                        }
        ))
        return movieDetails
    }

}