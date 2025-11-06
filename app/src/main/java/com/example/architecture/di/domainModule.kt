package com.example.architecture.di

import com.example.architecture.data.api.CountApi
import com.example.architecture.data.repository.CounterRepositoryImpl
import com.example.architecture.domain.repository.CounterRepository
import com.example.architecture.domain.usecases.DecrementUseCase
import com.example.architecture.domain.usecases.GetCountUseCase
import com.example.architecture.domain.usecases.IncrementUseCase
import com.example.architecture.domain.usecases.ResetCountUseCase
import org.koin.dsl.module

val domainModule = module {
    single { IncrementUseCase(repository = get()) }
    single { DecrementUseCase(repository = get()) }
    single { ResetCountUseCase (repository = get()) }
    single { GetCountUseCase(repository = get()) }
}