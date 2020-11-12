package com.e.mymovieskotlin.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MovieDao {
    @Query("select * from database_movie")
    fun getMovies(): LiveData<List<DatabaseMovie>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(movies: Array<DatabaseMovie>)

    @Query("DELETE FROM database_movie")
    fun deleteAll()


}