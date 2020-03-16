package com.paypal.movies

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.paypal.movies.ui.MoviesListAdapter
import com.paypal.movies.viewmodel.MoviesListViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MoviesListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //create ViewModel and bind
        viewModel = ViewModelProvider(this).get(MoviesListViewModel::class.java)
        //setup UI
        //bind
        bindModel()

    }

    private fun bindModel() {
        viewModel.moviesList.observe(this, Observer {
            with(movies_list_recycler_view) {
                // use this setting to improve performance if you know that changes
                // in content do not change the layout size of the RecyclerView
                setHasFixedSize(true)

                // use a linear layout manager
                layoutManager = LinearLayoutManager(this@MainActivity)

                // specify an viewAdapter (see also next example)
                adapter = MoviesListAdapter(it)

            }
        })
    }
}
