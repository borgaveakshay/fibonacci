package com.example.fibonacci.data_layer

import com.example.fibonacci.domain_layer.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor() : Repository {

    override suspend fun getNextFibonacciNumber(
        maxValue: ULong,
        first: Int,
        second: Int,
        result: MutableList<Int>
    ): MutableList<Int> {
        return if (maxValue > 0UL) {
            result.add(first)
            getNextFibonacciNumber(maxValue - 1UL, second, first + second, result)
        } else {
            result
        }
    }

}