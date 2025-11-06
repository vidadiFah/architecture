package com.example.architecture.domain.usecases

import com.example.architecture.domain.repository.CounterRepository

class ResetCountUseCase (
    private val repository: CounterRepository
) {

    fun reset() {
        repository.resetCount()
    }
}