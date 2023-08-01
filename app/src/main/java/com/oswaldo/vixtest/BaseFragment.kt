package com.oswaldo.vixtest

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

open class BaseFragment : Fragment() {

    protected fun setupHorizontalRv(recyclerView: RecyclerView) {
        recyclerView.layoutManager = createHorizontalLinearLayout()
    }

    private fun createHorizontalLinearLayout() = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
}