package com.example.stocksapp.presentation.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.stocksapp.presentation.Terminal
import com.example.stocksapp.ui.theme.StocksAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StocksAppTheme {
                Terminal()
            }
        }
    }
}
