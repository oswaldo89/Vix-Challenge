package com.oswaldo.vixtest.home.presentation.adapters

import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.oswaldo.vixtest.core.utils.loadUrl
import com.oswaldo.vixtest.core.utils.setOnSafeClickListener
import com.oswaldo.vixtest.databinding.ItemMovieThumbBinding
import com.oswaldo.vixtest.databinding.ItemPosterThumbBinding
import com.oswaldo.vixtest.home.data.dto.EdgeX

class MoviePosterListAdapter(private var movie: List<EdgeX>, private var iMovieEvent: IMovieEvent) :
    RecyclerView.Adapter<MoviePosterListAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemPosterThumbBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPosterThumbBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(movie[position]) {
                val horizontalPoster = this.node.video.imageAssets.find { it.imageRole == "HORIZONTAL_POSTER" }?.link
                binding.thumbMovie.loadUrl(context = holder.itemView.context, url = horizontalPoster.orEmpty())
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
