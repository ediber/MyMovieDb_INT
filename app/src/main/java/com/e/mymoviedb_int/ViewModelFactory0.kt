package com.e.mymoviedb_int

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory0(private val application: Application) : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(Fragment0ViewModel::class.java)){
            return Fragment0ViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
