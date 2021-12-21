package com.example.fibonacci.presentation_layer.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fibonacci.domain_layer.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FibonacciViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    val fibonacciNumbers = repository.getUpdatedList()
    
    init {
        getFibonacciSeries()
    }

    private fun getFibonacciSeries() {
        viewModelScope.launch {
            repository.getNextFibonacciNumber(3UL)
        }
    }
}