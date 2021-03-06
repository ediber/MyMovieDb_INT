package com.e.mymoviedb_int.Screen0

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.e.mymoviedb_int.R
import com.e.mymoviedb_int.domain.Movie

class MovieDbAdapter(): RecyclerView.Adapter<MovieDbAdapter.ViewHolder>(){

    var data = listOf<Movie>()
        set(value) {
            field = value

            // refresh the adapter
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieDbAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.movie_db_row, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MovieDbAdapter.ViewHolder, position: Int) {
        val item = data[position]
        holder.name.text = item.title

        // glide used to load images from server URL
        Glide.with(holder.image.context)
            .load(item.posterBasePath + item.posterPath)
            .into(holder.image)

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val name: TextView = itemView.findViewById(R.id.movie_db_row_name)
        val image: ImageView = itemView.findViewById(R.id.movie_db_row_image)
    }


}