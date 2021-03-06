package com.kyawt.shimmertesting.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kyawt.shimmertesting.service.model.movie.MovieResult
import com.kyawt.shimmertesting.view.constant.Constant
import kotlinx.android.synthetic.main.item_movie.view.*

class UpcomingViewHolder(var v: View,
private val mClickListener: ClickListener) : RecyclerView.ViewHolder(v) {
    fun bind(upComing: MovieResult) {
        val baseUrl = Constant.MOVIE_PATH
        val imgPath = upComing.posterPath

        Glide.with(v)
            .load("$baseUrl$imgPath")
            .into(v.moviePoster)

        v.rootView.setOnClickListener {
            mClickListener.onClickUpcoming(upComing)
        }
    }

    interface ClickListener{
        fun onClickUpcoming(upComing: MovieResult)
    }
}