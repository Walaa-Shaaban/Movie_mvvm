package com.walaa.shaaban.movie.presenter.ui.MainMovie.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.walaa.shaaban.movie.R
import com.walaa.shaaban.movie.data.repository.MoviePopularRepository
import com.walaa.shaaban.movie.databinding.FragmentPopularBinding
import com.walaa.shaaban.movie.presenter.adapter.PopulerMovieAdapter



class PopularMovieFragment : Fragment() {


    private lateinit var mContext  :Context
    private lateinit var binding: FragmentPopularBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_popular, container, false)
        getViewModel()
        mContext = context!!.applicationContext
        binding.rvMovie.layoutManager = LinearLayoutManager(mContext)
        getViewModel().getPopularMovie.observe(this, Observer {
            binding.rvMovie.adapter = PopulerMovieAdapter(it,mContext)

        })
        return binding.root
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