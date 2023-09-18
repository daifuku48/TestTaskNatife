package com.danylokharytonovuaa.testtasknatife.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.danylokharytonovuaa.testtasknatife.databinding.ErrorLayoutBinding
import com.danylokharytonovuaa.testtasknatife.databinding.GifListLayoutBinding
import com.danylokharytonovuaa.testtasknatife.presentation.adapters.GifRecyclerAdapter
import com.danylokharytonovuaa.testtasknatife.presentation.adapters.base.BaseFragment
import com.danylokharytonovuaa.testtasknatife.presentation.viewmodels.GifListViewModel
import com.danylokharytonovuaa.testtasknatife.presentation.viewmodels.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class GifListFragment : BaseFragment() {

    private val navController by lazy { findNavController() }
    private var _binding: GifListLayoutBinding? = null
    private val binding
        get() = _binding!!

    private val vm: GifListViewModel by viewModels()
    private val sharedVM : SharedViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = GifListLayoutBinding.inflate(inflater)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val resultBinding = ErrorLayoutBinding.bind(binding.root)
        val layoutManager = LinearLayoutManager(requireContext())
        binding.gifList.layoutManager = layoutManager

        //When an error handle button click
        resultBinding.restartButton.setOnClickListener {
            vm.fetchGifList()
        }

        //Render gif list or error
        vm.gifList.observe(viewLifecycleOwner){ result ->
            renderResult(
                root = binding.root,
                result = result,
                onSuccess = { gifList ->
                    val adapter = GifRecyclerAdapter(gifList)
                    adapter.onItemClick = { gif ->
                        val action = GifListFragmentDirections
                            .actionGifListFragmentToGifFragment2()
                        sharedVM.setGifId(gif.id)
                        navController.navigate(action)
                    }
                    binding.gifList.adapter = adapter
                    binding.gifList.visibility = View.VISIBLE
                },
                onError = {
                    resultBinding.errorText.visibility = View.VISIBLE
                    resultBinding.restartButton.visibility = View.VISIBLE
                }
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}