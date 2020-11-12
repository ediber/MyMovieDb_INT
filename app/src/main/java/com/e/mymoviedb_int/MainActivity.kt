package com.e.mymoviedb_int

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}



// assigment
// add 1 screen of favorite movies, the movies are added when user long clickes them in the all movies screen
//       add "chosen" field in some of the movie classes
//       update the "chosen field" on click
//       add query that selects only chosen movies


// add a screen that show more data of the movie, on click
//       you move data to the next fragment of the id of the chosen movie
//       with this id the details fragment get all the relevant movie data from Room