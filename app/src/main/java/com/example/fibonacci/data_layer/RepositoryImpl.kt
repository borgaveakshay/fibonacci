package com.example.fibonacci.data_layer

import androidx.lifecycle.MutableLiveData
import com.example.fibonacci.domain_layer.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor() : Repository {
    val list = MutableLiveData<List<Int>>()
    private val numberList = mutableListOf<Int>()
    override suspend fun getNextFibonacciNumber(
        maxValue: ULong,
        first: Int,
        second: Int
    ): Int {
        val number = when (maxValue) {
            0UL -> first
            1UL -> second
            else ->
                getNextFibonacciNumber(
                    maxValue - 1UL,
                    second,
                    first + second
                )

        }
        numberList.add(number)
        list.postValue(numberList)
        return number
    }

    override fun getUpdatedList() = list
}