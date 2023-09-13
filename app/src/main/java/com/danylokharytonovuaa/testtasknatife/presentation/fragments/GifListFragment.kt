package com.danylokharytonovuaa.testtasknatife.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.danylokharytonovuaa.testtasknatife.databinding.ErrorLayoutBinding
import com.danylokharytonovuaa.testtasknatife.databinding.GifListLayoutBinding
import com.danylokharytonovuaa.testtasknatife.presentation.adapters.base.BaseFragment
import com.danylokharytonovuaa.testtasknatife.presentation.viewmodels.GifListViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class GifListFragment : BaseFragment() {

    private var _binding: GifListLayoutBinding? = null
    private val binding
        get() = _binding!!

    private val vm: GifListViewModel by viewModels()

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

        vm.loading.observe(viewLifecycleOwner){

        }

        val resultBinding = ErrorLayoutBinding.bind(binding?.root!!)

        vm.gifList.observe(viewLifecycleOwner){ result ->
            renderResult(
                root = binding.root,
                result = result,
                onSuccess = {
                    val adapter = RecyclerCategoriesAdapter(it)
                    adapter.onItemClick = { category ->
                        Log.d("Category", category.strCategory)
                        val action = CategoriesListFragmentDirections
                            .actionCategorieslListFragmentToMealsByCategoriesFragment()
                        sharedVM.setCategoryName(category.strCategory)
                        sharedVM.setCategoryImage(category.strCategoryThumb)
                        navController.navigate(action)
                    }
                    binding?.categoriesRecyclerView?.adapter = adapter
                    binding?.appBarLayout?.visibility = View.VISIBLE
                    binding?.categoriesRecyclerView?.visibility = View.VISIBLE
                },
                onError = {
                    resultBinding.buttonErrorRestart.visibility = View.VISIBLE
                    resultBinding.textError.visibility = View.VISIBLE
                }
            )
        }
    }
}