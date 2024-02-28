package com.example.stocksapp.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.Calendar
import java.util.Date

@Parcelize
data class Bar(
    val open: Float,
    val close: Float,
    val low: Float,
    val high: Float,
    val time: Long
): Parcelable {
    val calendar: Calendar
        get() {
            return Calendar.getInstance().apply {
                time = Date(this@Bar.time)
            }
        }
}