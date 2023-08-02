package com.oswaldo.vixtest.detail.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.oswaldo.vixtest.BaseFragment
import com.oswaldo.vixtest.core.utils.setOnSafeClickListener
import com.oswaldo.vixtest.databinding.FragmentDetailBinding


class DetailFragment : BaseFragment() {

    private var movieId: String? = null
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        fetchArguments()
        setupListeners()

        return binding.root
    }

    private fun setupListeners() {
        binding.run {
            back.setOnSafeClickListener {
                navController.popBackStack()
            }
        }
    }

    private fun fetchArguments() {
        val args = arguments
        if (args != null) {
            movieId = args.getString("cursor")
        }
    }
}