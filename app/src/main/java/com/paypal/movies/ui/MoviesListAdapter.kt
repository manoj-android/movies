package com.paypal.movies.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.paypal.movies.R
import com.paypal.movies.usecase.bindImage
import com.paypal.movies.viewmodel.MovieListItem

class MoviesListAdapter(private val listItems: List<MovieListItem>) :
    RecyclerView.Adapter<MoviesListHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesListHolder {
        // create a new view
        val rootview = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item, parent, false)
        return MoviesListHolder(rootview)
    }

    override fun getItemCount(): Int = listItems.size

    override fun onBindViewHolder(holder: MoviesListHolder, position: Int) {
        listItems[position].let {
            holder.titleView.text = it.title
            holder.yearView.text = it.year
            holder.imageView.bindImage(it.thumbnailUrl)
        }
    }
}