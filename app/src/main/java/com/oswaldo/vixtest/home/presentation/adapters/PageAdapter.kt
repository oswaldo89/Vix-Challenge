package com.oswaldo.vixtest.home.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oswaldo.vixtest.core.utils.setOnSafeClickListener
import com.oswaldo.vixtest.databinding.ItemPageButtonBinding

class PageAdapter(private var page: List<String>, private var iPageEvent: IMovieEvent) :
    RecyclerView.Adapter<PageAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemPageButtonBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPageButtonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(page[position]) {
                binding.btnPage.text = this
            }
            this.itemView.setOnSafeClickListener {
                //iMovieEvent.onClickMovie(movie[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return page.size
    }
}
