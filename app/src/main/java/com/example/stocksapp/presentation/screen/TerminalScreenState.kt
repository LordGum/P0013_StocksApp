package com.example.stocksapp.presentation.screen

import com.example.stocksapp.domain.Bar
import com.example.stocksapp.presentation.TimeFrame

sealed class TerminalScreenState {
    object Initial: TerminalScreenState()
    object Loading: TerminalScreenState()
    data class Content(val barList: List<Bar>, val timeFrame: TimeFrame) : TerminalScreenState()
}