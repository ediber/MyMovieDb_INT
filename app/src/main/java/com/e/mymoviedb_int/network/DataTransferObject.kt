package com.e.mymoviedb_int.network

import com.e.mymovieskotlin.database.DatabaseMovie
import com.squareup.moshi.Json

data class MoviesList(
    val results: List<NetworkMovie>
)

data class NetworkMovie(
    val popularity: Double,

    @Json(name = "poster_path")
    val posterPath: String,

    val title: String,
    val overview: String
)

fun MoviesList.asDatabaseModel(): Array<DatabaseMovie> {
    return results.map { networkMovie ->
        DatabaseMovie(
            posterPath = networkMovie.posterPath,
            title = networkMovie.title,
            isSelected = false,
            popularity = networkMovie.popularity,
            overview = networkMovie.overview,
            listType = "top_rated"
        )
    }.toTypedArray()
}