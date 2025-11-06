package com.example.architecture.data.mapper

import com.example.architecture.data.models.CountDto
import com.example.architecture.domain.models.Count
import com.example.architecture.domain.models.TypeOfOperation

fun CountDto.mapToDomain(): Count {
    return Count(
        count = this.count ?:0,
        typeOfOperation = TypeOfOperation.toOperation(this.typeOfOperation),
        createdAt = this.createdAt ?: 0L
    )
}