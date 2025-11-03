package com.example.architecture.data.models

import com.example.architecture.domain.models.TypeOfOperation
import java.sql.Date

data class CountDto(
    val count: Int? = null,
    val typeOfOperation: String? = null,
    val createdAt: Long? = null,
)