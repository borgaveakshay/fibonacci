package com.example.fibonacci.domain_layer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun getNextFibonacciNumber1(
        maxValue: ULong,
        first: ULong = 0U,
        second: ULong = 1U,
        result: MutableList<ULong> = mutableListOf()
    ): MutableList<ULong>

    suspend fun getNextFibonacciNumber2(
        maxValue: ULong,
        first: ULong = 0U,
        second: ULong = 1U,
        result: MutableList<ULong> = mutableListOf()
    ): Flow<MutableList<ULong>>


    fun getLiveList() : LiveData<List<ULong>>
    suspend fun getNextFibonacciNumber(
        n: ULong,
        i: ULong = 0UL,
    ): MutableList<ULong>

}