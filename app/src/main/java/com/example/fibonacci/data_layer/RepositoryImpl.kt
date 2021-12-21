package com.example.fibonacci.data_layer

import androidx.lifecycle.MutableLiveData
import com.example.fibonacci.domain_layer.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import kotlin.math.pow
import kotlin.math.roundToLong
import kotlin.math.sqrt

class RepositoryImpl @Inject constructor() : Repository {


    val fibonacciList = MutableLiveData<List<ULong>>()
    val list = mutableListOf<ULong>()

    override suspend fun getNextFibonacciNumber1(
        maxValue: ULong,
        first: ULong,
        second: ULong,
        result: MutableList<ULong>
    ): MutableList<ULong> {

        return if (maxValue > 0UL) {
            result.add(first)
            getNextFibonacciNumber1(maxValue - 1UL, second, first + second, result)
        } else {
            result
        }
    }

    override suspend fun getNextFibonacciNumber2(
        maxValue: ULong,
        first: ULong,
        second: ULong,
        result: MutableList<ULong>
    ): Flow<MutableList<ULong>> = flow {

        if (maxValue > 0UL) {
            result.add(first)
            emit(getNextFibonacciNumber1(maxValue - 1UL, second, first + second, result))
        } else {
            emit(result)
        }
    }

    override fun getLiveList() = fibonacciList


    override suspend fun getNextFibonacciNumber(
        n: ULong,
        i: ULong,
    ): MutableList<ULong> {
        var j = i
        return if (i == n)
            list
        else {
            list.add(fib(i))
            fibonacciList.postValue(list)
            // println("fibonaci list data $list")
            getNextFibonacciNumber(n, ++j)
        }
    }

    private fun fib(n: ULong): ULong {
        val phi = (1 + sqrt(5.0)) / 2
        return (phi.pow(n.toDouble())
                / sqrt(5.0)).roundToLong().toULong()
    }
}