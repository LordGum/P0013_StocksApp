package com.example.stocksapp.domain

import com.example.stocksapp.presentation.TimeFrame

interface Repository {
    suspend fun getStock(tf: TimeFrame): List<Bar>
}