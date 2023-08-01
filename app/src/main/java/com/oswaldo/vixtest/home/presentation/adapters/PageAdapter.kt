package com.oswaldo.vixtest.home.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oswaldo.vixtest.core.utils.loadUrl
import com.oswaldo.vixtest.core.utils.setOnSafeClickListener
import com.oswaldo.vixtest.databinding.ItemMovieThumbBinding
import com.oswaldo.vixtest.home.data.dto.EdgeX

class MovieListAdapter(private var movie: List<EdgeX>, private var iMovieEvent: IMovieEvent) :
    RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemMovieThumbBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemMovieThumbBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(movie[position]) {
                binding.thumbMovie.loadUrl(context = holder.itemView.context, url = this.node.image.link.orEmpty())
            }
            this.itemView.setOnSafeClickListener {
                iMovieEvent.onClickMovie(movie[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return movie.size
    }
}
