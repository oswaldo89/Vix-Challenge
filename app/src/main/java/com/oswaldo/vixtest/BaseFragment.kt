package com.oswaldo.vixtest

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

open class BaseFragment : Fragment() {

    val Fragment.navController get() = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)

    protected fun setupHorizontalRv(recyclerView: RecyclerView) {
        recyclerView.layoutManager = createHorizontalLinearLayout()
    }

    private fun createHorizontalLinearLayout() = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
}