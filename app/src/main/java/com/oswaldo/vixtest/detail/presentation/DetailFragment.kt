package com.oswaldo.vixtest.detail.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.oswaldo.vixtest.BaseFragment
import com.oswaldo.vixtest.core.utils.loadUrl
import com.oswaldo.vixtest.core.utils.setOnSafeClickListener
import com.oswaldo.vixtest.databinding.FragmentDetailBinding
import com.oswaldo.vixtest.home.data.dto.EdgeX
import com.oswaldo.vixtest.home.presentation.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment() {

    private val viewModel: DetailViewModel by viewModels()

    private var parentCursor: String? = null
    private var cursor: String? = null
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        fetchArguments()
        setupListeners()
        observeState()

        parentCursor?.let { parent ->
            cursor?.let { cursor ->
                viewModel.init(parent, cursor)
            }
        }

        return binding.root
    }

    private fun observeState() {
        viewModel.stateLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is DetailViewModel.State.ShowData -> setupData(it.data)
                else -> {}
            }
        }
    }

    private fun setupData(data: EdgeX) {
        binding.run {
            posterImage.loadUrl(requireContext(), data.node.image.link)
            title.text = data.node.clickTrackingJson.uiContentTitle
            description.text = data.node.video.description
        }
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
            parentCursor = args.getString("parent_cursor")
            cursor = args.getString("cursor")
        }
    }
}