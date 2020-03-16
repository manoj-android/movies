package com.paypal.movies.usecase

import android.widget.ImageView
import com.paypal.movies.R
import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator

class FetchImageUseCase {
    fun execute(url: String?): RequestCreator =
        Picasso.get().load(url).placeholder(R.mipmap.ic_launcher)
            .error(R.drawable.ic_launcher_background)
}

fun ImageView.bindImage(thumbnailUrl: String?) {
    FetchImageUseCase().execute(thumbnailUrl).into(this)
}