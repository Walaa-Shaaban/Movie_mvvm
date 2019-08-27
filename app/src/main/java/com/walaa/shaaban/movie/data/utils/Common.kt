package com.walaa.shaaban.movie.data.utils

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.walaa.shaaban.movie.R

object Common {
    fun getImageView(context: Context, imageView: ImageView, url: String) {
        Glide
            .with(context)
            .load(url)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(imageView)
    }

    fun toast(context: Context, msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
}
