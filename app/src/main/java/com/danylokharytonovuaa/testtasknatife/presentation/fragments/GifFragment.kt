package com.danylokharytonovuaa.testtasknatife.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.danylokharytonovuaa.testtasknatife.databinding.ErrorLayoutBinding
import com.danylokharytonovuaa.testtasknatife.databinding.GifLayoutBinding
import com.danylokharytonovuaa.testtasknatife.presentation.adapters.GifRecyclerAdapter
import com.danylokharytonovuaa.testtasknatife.presentation.adapters.base.BaseFragment
import com.danylokharytonovuaa.testtasknatife.presentation.viewmodels.GifViewModel
import com.danylokharytonovuaa.testtasknatife.presentation.viewmodels.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class GifFragment : BaseFragment() {

    private val navController by lazy { findNavController() }
    private var _binding : GifLayoutBinding? = null
    private val binding
        get() = _binding!!

    private val vm: GifViewModel by viewModels()
    private val sharedVM: SharedViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = GifLayoutBinding.inflate(inflater)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val gifId = sharedVM.getGifId()
        vm.setGifId(gifId!!)

        val resultBinding = ErrorLayoutBinding.bind(binding.root)

        resultBinding.restartButton.setOnClickListener {
            vm.fetchGif()
        }

        binding.backButton.setOnClickListener {
            navController.navigateUp()
        }

        vm.gif.observe(viewLifecycleOwner){result ->
            renderResult(
                root = binding.root,
                result = result,
                onSuccess = { gif ->
                    Glide.with(requireContext())
                        .asGif()
                        .load(gif.data.images.downsizedMedium.url)
                        .skipMemoryCache(true)
                        .into(binding.gifImageview)
                    binding.gifImageview.visibility = View.VISIBLE
                    binding.backButton.visibility = View.VISIBLE
                },
                onError = {
                    resultBinding.errorText.visibility = View.VISIBLE
                    resultBinding.restartButton.visibility = View.VISIBLE
                }
            )
        }
    }
}