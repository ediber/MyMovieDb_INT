package com.e.mymoviedb_int

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.e.mymoviedb_int.domain.Movie
import com.e.mymoviedb_int.repository.MoviesRepository
import com.e.mymovieskotlin.database.getDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class Fragment0ViewModel(context: Context) : ViewModel() {
    // TODO: Implement the ViewModel

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private val database = getDatabase(context)
    private val moviesRepository = MoviesRepository(database)

    private val _movies = moviesRepository.movies
    val movies: LiveData<List<Movie>>
        get() {
            return _movies
        }

    fun refreshMovieDBData(){
        coroutineScope.launch {
            moviesRepository.refreshMovieDbData()
        }
    }
}