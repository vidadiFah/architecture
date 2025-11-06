package com.example.architecture.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.architecture.domain.models.Count
import com.example.architecture.domain.usecases.DecrementUseCase
import com.example.architecture.domain.usecases.GetCountUseCase
import com.example.architecture.domain.usecases.IncrementUseCase
import com.example.architecture.domain.usecases.ResetCountUseCase

class CountViewModel(
    private val incrementUseCase: IncrementUseCase,
    private val decrementUseCase: DecrementUseCase,
    private val resetCountUseCase: ResetCountUseCase,
    private val getCountUseCase: GetCountUseCase
) : ViewModel() {
    private val _countData = MutableLiveData<Count>()
    val countData: LiveData<Count> = _countData

    fun increment() {
        incrementUseCase.increment()
    }

    fun decrement() {
        decrementUseCase.decrement()
    }

    fun resetCount() {
        resetCountUseCase.reset()
    }

    private fun getCount() {
        val response = getCountUseCase.getCount()
        _countData.value = response
    }
}