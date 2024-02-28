package com.example.stocksapp.data

import com.example.stocksapp.data.network.model.BarDto
import com.example.stocksapp.domain.Bar
import com.example.stocksapp.presentation.TimeFrame

class Mapper {
    private fun mapDtoToEntity(barDto: BarDto): Bar {
        return Bar(
            open = barDto.open,
            close = barDto.close,
            low = barDto.low,
            high = barDto.high,
            time = barDto.time
        )
    }

    fun mapListDtoToEntity(listDto: List<BarDto>): List<Bar> {
        return listDto.map {
            mapDtoToEntity(it)
        }
    }

    fun mapStringToTimeFrame(timeFrame: TimeFrame): String {
        return when (timeFrame) {
            TimeFrame.MIN_5 -> "5/minute"
            TimeFrame.MIN_15 -> "15/minute"
            TimeFrame.MIN_30 -> "30/minute"
            TimeFrame.HOUR_1 -> "1/hour"
        }
    }
}