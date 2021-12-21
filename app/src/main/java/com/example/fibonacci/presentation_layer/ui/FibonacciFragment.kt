package com.example.fibonacci.presentation_layer.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fibonacci.R
import com.example.fibonacci.databinding.FragmentFibonacciBinding
import com.example.fibonacci.presentation_layer.adapter.FibonacciAdapter
import com.example.fibonacci.presentation_layer.viewmodels.FibonacciViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FibonacciFragment : Fragment() {

    private val viewModel by viewModels<FibonacciViewModel>()
    private lateinit var viewBinding: FragmentFibonacciBinding
    private val fibonacciAdapter by lazy { FibonacciAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(requireContext()),
            R.layout.fragment_fibonacci,
            null,
            false
        )
        return viewBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.recycleView.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = fibonacciAdapter
            addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    DividerItemDecoration.VERTICAL
                )
            )
        }

        viewModel.fibonacciNumbers.observe(viewLifecycleOwner, { data ->
            data?.let { list -> fibonacciAdapter.submitList(list) }
        })
    }

}