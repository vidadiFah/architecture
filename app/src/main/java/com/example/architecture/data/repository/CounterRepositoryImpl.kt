package com.example.architecture.data.repository

import com.example.architecture.data.api.CountApi
import com.example.architecture.data.mapper.mapToDomain
import com.example.architecture.data.models.CountDto
import com.example.architecture.domain.models.Count
import com.example.architecture.domain.models.TypeOfOperation
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

    override fun resetCount() {
        api.resetCount()
    }

    override fun getCount(): Count {
        return api.getCount().mapToDomain(  )
    }
}