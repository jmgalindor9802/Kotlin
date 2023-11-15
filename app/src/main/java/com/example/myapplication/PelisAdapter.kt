package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ViewPelisItemBinding
import com.example.myapplication.models.Result


interface PelisClickedListener{
    fun onPelisClicked(peli: Result)
}

class PelisAdapter(var pelis: List<Result>,
private val pelisClickedListener: PelisClickedListener):
        RecyclerView.Adapter<PelisAdapter.ViewHolder>(){
            class ViewHolder(val binding: ViewPelisItemBinding):
                RecyclerView.ViewHolder(binding.root){
                    fun bind(peli: Result{
                        Glide.with(binding.root.context)
                            .load("https://image.tmdb.org/t/p/w500${peli.poster_path}")
                            .into(binding.afiche)
                        binding.titulo.text=peli.original_title
                    }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val binding=ViewPelisItemBinding.inflate(
           LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return pelis.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val peli=pelis[position]
        holder.bind(peli)
        holder.itemView.setOnClickListener{pelisClickedListener.onPelisClicked(peli)}
    }
}


