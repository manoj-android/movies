package com.paypal.movies.viewmodel

import DefaultRepo
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MoviesListViewModel : ViewModel() {

    private val repo = DefaultRepo()

    private val _moviesList =
        MutableLiveData<List<MovieListItem>>().apply { emptyList<MovieListItem>() }

    val moviesList: LiveData<List<MovieListItem>> = _moviesList


    private fun fetchMovies() {

        viewModelScope.launch {

            _moviesList.value = repo.getImage()?.map {
                MovieListItem(
                    title = it.title,
                    year = it.year,
                    thumbnailUrl = it.thumbnailUrl
                )
            }

        }

    }

    override fun onCleared() {
        super.onCleared()
    }

    init {
        fetchMovies()
    }
}