package com.oswaldo.vixtest.core.utils

import android.os.Handler
import androidx.recyclerview.widget.RecyclerView
import com.oswaldo.vixtest.home.data.dto.EdgeX

fun RecyclerView.startAutoScroll(
    dataList: List<EdgeX>,
    delayMillis: Long,
    initialPosition: Int = 0
) {
    val autoScrollHandler = Handler()
    val autoScrollRunnable = object : Runnable {
        private var currentPosition = initialPosition

        override fun run() {
            val nextPosition = (currentPosition + 1) % dataList.size
            smoothScrollToPosition(nextPosition)
            currentPosition = nextPosition
            autoScrollHandler.postDelayed(this, delayMillis)
        }
    }

    autoScrollHandler.postDelayed(autoScrollRunnable, delayMillis)
}

fun RecyclerView.stopAutoScroll() {
    val autoScrollHandler = Handler()
    autoScrollHandler.removeCallbacksAndMessages(null)
}
