package com.e.mymoviedb_int.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.e.mymoviedb_int.domain.Movie
import com.e.mymoviedb_int.network.MoviesApiService
import com.e.mymoviedb_int.network.asDatabaseModel
import com.e.mymovieskotlin.database.MoviesDatabase
import com.e.mymovieskotlin.database.asDomainModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext



class MoviesRepository(private val database: MoviesDatabase) {

    // getting movies from DB
    // changing the format of the class
    val movies: LiveData<List<Movie>> =
        Transformations.map(database.movieDao.getMovies()) {
            it.asDomainModel()
        }

    suspend fun refreshMovieDbData(){
        withContext(Dispatchers.IO) {
            //database.movieDao.deleteAll()

            val getMoviesDeferred = MoviesApiService.MovieApi.retrofitService.getTopRated()
            var moviesList = getMoviesDeferred.await()

            database.movieDao.insertAll(moviesList.asDatabaseModel())
        }
    }

}