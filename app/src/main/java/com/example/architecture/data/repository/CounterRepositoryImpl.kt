package com.example.architecture.data.repository

import com.example.architecture.data.api.CountApi
import com.example.architecture.data.models.CountDto
import com.example.architecture.domain.models.Count
import com.example.architecture.domain.repository.CounterRepository

class CounterRepositoryImpl(
    private val api: CountApi
): CounterRepository {
    override fun increment() {
        api.increment()
    }

    override fun decrement() {
        api.decrement()
    }

    override fun getCount(): Count {
        val dto = api.getCount()
        return mapToDomain(dto)
    }

    override fun resetCount() {
        api.resetCount()
    }

    private fun mapToDomain(dto: CountDto): Count {
        return Count(
            count = dto.count,
            typeOfOperation = dto.typeOfOperation,
            createdAt = dto.createdAt
        )
    }
}