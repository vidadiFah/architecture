package com.example.architecture.data.api

import com.example.architecture.data.models.CountDto

class CountApi {
    private var count = 0

    fun increment() {
        count++
    }

    fun decrement() {
        count--
    }

    fun resetCount() {
        count = 0
    }

    fun getCount() : CountDto {
        return CountDto(
            count = count,
            typeOfOperation = null,
            createdAt = System.currentTimeMillis()
        )
    }
}