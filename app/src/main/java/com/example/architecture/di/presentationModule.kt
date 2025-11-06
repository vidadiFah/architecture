package com.example.architecture.di

import com.example.architecture.presentation.viewModel.CountViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        CountViewModel(
            incrementUseCase = get(),
            decrementUseCase = get(),
            resetCountUseCase = get(),
            getCountUseCase = get()
        )
    }
}