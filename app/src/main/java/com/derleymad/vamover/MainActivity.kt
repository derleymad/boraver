package com.derleymad.vamover

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.derleymad.vamover.databinding.ActivityMainBinding
import com.derleymad.vamover.model.Movies
import com.derleymad.vamover.util.GetMovies

class MainActivity : AppCompatActivity(), GetMovies.Callback{

    private var movies = mutableListOf<Movies>()
    val movieAdapter = AdapterMovie(movies)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        GetMovies(this@MainActivity).execute()

        binding.rvMovies.adapter = movieAdapter
        binding.rvMovies.layoutManager = LinearLayoutManager(this@MainActivity)

    }

    override fun onPreExecuteQuery() {
    }

    override fun onResultQuery(movies: List<Movies>) {
       this.movies.clear()
       this.movies.addAll(movies)
        movieAdapter.notifyDataSetChanged()

        Log.i("testMovie",movies.toString())
    }

    override fun onFailureQuery(message: String) {
    }
}