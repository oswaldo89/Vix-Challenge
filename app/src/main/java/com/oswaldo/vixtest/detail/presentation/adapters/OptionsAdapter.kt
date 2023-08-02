package com.oswaldo.vixtest.detail.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.oswaldo.vixtest.R
import com.oswaldo.vixtest.core.utils.setOnSafeClickListener
import com.oswaldo.vixtest.databinding.ItemPageButtonBinding
import com.oswaldo.vixtest.home.data.dto.UiPage

class OptionsAdapter(private var pages: List<UiPage>, private var iPageEvent: IOptionEvent) :
    RecyclerView.Adapter<OptionsAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemPageButtonBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPageButtonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(pages[position]) {
                val context = itemView.context
                binding.btnPage.text = this.pageName

                val textColor = if (this.selected) R.color.white else R.color.circleButton
                val backgroundRes = if (this.selected) R.drawable.bg_btn_page_selected else R.drawable.bg_btn_page_normal

                binding.btnPage.setTextColor(ContextCompat.getColor(context, textColor))
                binding.btnPage.setBackgroundResource(backgroundRes)

                binding.btnPage.setOnSafeClickListener {
                    deselectAllItems()
                    this.selected = !this.selected
                    iPageEvent.onClickOption(this)
                    notifyDataSetChanged()
                }
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun deselectAllItems(){
        for (page in pages) {
            page.selected = false
        }
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return pages.size
    }
}
