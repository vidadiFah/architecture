package com.example.architecture.domain.usecases

import com.example.architecture.domain.repository.CounterRepository

class IncrementUseCase(
    private val repository: CounterRepository
) {

    fun increment() {
        repository.increment()
    }
}