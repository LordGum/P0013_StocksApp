package com.example.stocksapp.domain

import com.example.stocksapp.presentation.TimeFrame

class GetBarsUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(tf: TimeFrame): List<Bar> = repository.getStock(tf)
}