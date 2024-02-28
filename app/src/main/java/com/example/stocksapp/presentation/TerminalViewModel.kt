package com.example.stocksapp.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stocksapp.data.RepositoryImpl
import com.example.stocksapp.domain.GetBarsUseCase
import com.example.stocksapp.presentation.screen.TerminalScreenState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TerminalViewModel: ViewModel() {

    private val repository = RepositoryImpl()
    private val getBarsUseCase = GetBarsUseCase(repository)

    private val _state = MutableStateFlow<TerminalScreenState>(TerminalScreenState.Initial)
    val state = _state.asStateFlow()
    private var lastState: TerminalScreenState = TerminalScreenState.Initial

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _state.value = lastState
        Log.d("ERROR", "error in TerminalVM: $throwable")
        //Todo add toast or SnackBar
    }


    init {
        loadListOfBars(TimeFrame.HOUR_1)
    }


    fun loadListOfBars(tf: TimeFrame) {
        lastState = _state.value
        _state.value = TerminalScreenState.Loading
        viewModelScope.launch(exceptionHandler) {
            val barList = getBarsUseCase(tf)
            _state.value = TerminalScreenState.Content(barList = barList, timeFrame = tf)
        }
    }
}