package com.example.fibonacci.domain_layer

import androidx.lifecycle.MutableLiveData

interface Repository {

    suspend fun getNextFibonacciNumber(
        maxValue: ULong,
        first: Int = 0,
        second: Int = 1,
        result: MutableList<Int> = mutableListOf()
    ): MutableList<Int>

}