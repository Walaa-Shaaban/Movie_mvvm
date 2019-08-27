package com.walaa.shaaban.movie.presenter.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.walaa.shaaban.movie.R
import com.walaa.shaaban.movie.presenter.ui.MainMovie.ui.PopularMovieFragment



class MainMovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_movie)

        loadFragment(PopularMovieFragment())

    }

    private fun loadFragment(fragment: Fragment) {
        // load fragment
        getSupportFragmentManager()
            .beginTransaction()
            .add(R.id.main_fragment, fragment, "Popular Movie")
            .disallowAddToBackStack()
            .commit()

    }
}
