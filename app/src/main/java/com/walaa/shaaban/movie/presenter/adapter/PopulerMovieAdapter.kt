package com.walaa.shaaban.movie.presenter.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.walaa.shaaban.movie.DetailsMovieActivity
import com.walaa.shaaban.movie.R
import com.walaa.shaaban.movie.data.model.PopularMovieModel
import com.walaa.shaaban.movie.data.utils.ApiUtils

class PopulerMovieAdapter(var getPopularMovies : PopularMovieModel, context:Context) :RecyclerView.Adapter<PopulerMovieAdapter.ViewHolderMovieopular>() {

    private lateinit var mGetPopularMovies : PopularMovieModel
    private lateinit var mContext: Context
    init {
     mGetPopularMovies = getPopularMovies
        mContext = context

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderMovieopular {
        val inflater = LayoutInflater.from(mContext).inflate(R.layout.movie_list_item, parent, false)
        return ViewHolderMovieopular(inflater)
    }

    override fun getItemCount(): Int {
        return getPopularMovies.movies.size
    }

    override fun onBindViewHolder(holder: ViewHolderMovieopular, position: Int) {

        var popularMovies = getPopularMovies.movies.get(position)
        holder.movieTiltle.text = popularMovies.title.toString()
        holder.movieData.text = popularMovies.releaseDate.toString()

        Glide
            .with(mContext)
            .load("${ApiUtils.POSTER_BASE_URL}${popularMovies.posterPath}")
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.movieImg)

        holder.movieImg.setOnClickListener(View.OnClickListener {
            var intent:Intent = Intent(mContext, DetailsMovieActivity::class.java)
            intent.putExtra("id", popularMovies.id)
            mContext.startActivity(intent)
        })
    }


    class ViewHolderMovieopular:RecyclerView.ViewHolder{

        var movieImg: ImageView
        var movieTiltle: TextView
        var movieData: TextView

        constructor(itemView: View) : super(itemView){
            movieImg = itemView.findViewById(R.id.cv_iv_movie_poster)
            movieTiltle = itemView.findViewById(R.id.cv_movie_title)
            movieData = itemView.findViewById(R.id.cv_movie_release_date)
        }



    }
}