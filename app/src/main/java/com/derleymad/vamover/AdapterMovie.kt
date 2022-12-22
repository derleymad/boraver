package com.derleymad.vamover

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.derleymad.vamover.model.Movies
import com.squareup.picasso.Picasso

class AdapterMovie(private val list : List<Movies>) : RecyclerView.Adapter<AdapterMovie.MovieViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.movie_item,parent,false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = list[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(movie : Movies){
            val baseUrl = "https://www.tvmap.com.br"
            val imageView = itemView.findViewById<ImageView>(R.id.movie_img)
            val textView = itemView.findViewById<TextView>(R.id.movie_txt)
            textView.text = movie.nomeDoFilme
            Picasso.with(itemView.context)
                .load(baseUrl+movie.urlImage)
                .into(imageView)
        }
    }
}