package com.paypal.movies.ui

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.paypal.movies.R

class MoviesListHolder(rootView: View) : RecyclerView.ViewHolder(rootView) {
    val titleView: TextView = rootView.findViewById(R.id.title)
    val yearView: TextView = rootView.findViewById(R.id.year)
    val imageView: ImageView = rootView.findViewById(R.id.icon)
}
