package com.oswaldo.vixtest.detail.presentation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.oswaldo.vixtest.BaseFragment
import com.oswaldo.vixtest.core.utils.loadUrl
import com.oswaldo.vixtest.core.utils.setOnSafeClickListener
import com.oswaldo.vixtest.databinding.FragmentDetailBinding
import com.oswaldo.vixtest.detail.presentation.adapters.IOptionEvent
import com.oswaldo.vixtest.detail.presentation.adapters.OptionsAdapter
import com.oswaldo.vixtest.home.data.dto.EdgeX
import com.oswaldo.vixtest.home.data.dto.UiPage
import com.oswaldo.vixtest.home.presentation.adapters.PageAdapter
import com.oswaldo.vixtest.videoplayer.presentation.VideoPlayerActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment(), IOptionEvent {

    private val viewModel: DetailViewModel by viewModels()
    private lateinit var optionsAdapter: OptionsAdapter

    private var parentCursor: String? = null
    private var cursor: String? = null
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        fetchArguments()
        setupListeners()
        observeState()
        setupHorizontalRecyclerViews()

        parentCursor?.let { parent ->
            cursor?.let { cursor ->
                viewModel.init(parent, cursor)
            }
        }

        return binding.root
    }

    private fun setupHorizontalRecyclerViews() {
        binding.apply {
            setupHorizontalRv(rvOptions)
        }
    }

    private fun observeState() {
        viewModel.stateLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is DetailViewModel.State.ShowData -> setupData(it.data, it.options)
                else -> {}
            }
        }
    }

    private fun setupData(data: EdgeX, options: List<UiPage>) {
        binding.run {
            posterImage.loadUrl(requireContext(), viewModel.loadVideoImageCover(data))

            title.text = data.node.clickTrackingJson.uiContentTitle
            description.text = data.node.video.description
            fullDescription.text = viewModel.getCompleteDescription(data)

            optionsAdapter = OptionsAdapter(options, this@DetailFragment)
            rvOptions.adapter = optionsAdapter
        }
    }

    private fun setupListeners() {
        binding.run {
            back.setOnSafeClickListener {
                navController.popBackStack()
            }
            btnPlay.setOnSafeClickListener {
                val intent = Intent(context, VideoPlayerActivity::class.java)
                startActivity(intent)
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

    override fun onClickOption(page: UiPage) {

    }
}