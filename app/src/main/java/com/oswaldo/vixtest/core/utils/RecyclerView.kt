package com.oswaldo.vixtest.core.utils

import android.os.Handler
import androidx.recyclerview.widget.RecyclerView
import com.oswaldo.vixtest.home.data.dto.EdgeX


var autoScrollRunnable: Runnable? = null
var autoScrollHandler: Handler? = null

fun startAutoScroll(
    recyclerView: RecyclerView,
    dataList: List<EdgeX>,
    delayMillis: Long,
    initialPosition: Int = 0
) {
    autoScrollHandler = Handler()
    autoScrollRunnable = object : Runnable {
        private var currentPosition = initialPosition

        override fun run() {
            val nextPosition = (currentPosition + 1) % dataList.size
            recyclerView.smoothScrollToPosition(nextPosition)
            currentPosition = nextPosition
            autoScrollHandler?.postDelayed(this, delayMillis)
        }
    }

    autoScrollHandler?.postDelayed(autoScrollRunnable!!, delayMillis)
}

fun stopAutoScroll() {
    autoScrollHandler?.removeCallbacks(autoScrollRunnable!!)
}