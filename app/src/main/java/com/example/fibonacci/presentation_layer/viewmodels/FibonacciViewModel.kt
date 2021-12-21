package com.example.fibonacci.presentation_layer.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fibonacci.domain_layer.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class FibonacciViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    val fibonacciNumbers = MutableLiveData<List<ULong>>()

    init {
        getFibonacciSeries()
    }

    private fun getFibonacciSeries() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                fibonacciNumbers.postValue(repository.getNextFibonacciNumber(500UL))
            }
        }
    }
}