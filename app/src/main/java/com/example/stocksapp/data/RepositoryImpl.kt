package com.example.stocksapp.data

import com.example.stocksapp.data.network.ApiFactory
import com.example.stocksapp.domain.Repository
import com.example.stocksapp.domain.Bar
import com.example.stocksapp.presentation.TimeFrame

class RepositoryImpl: Repository {
    private val mapper = Mapper()
    private val apiService = ApiFactory.apiService

    override suspend fun getStock(tf: TimeFrame): List<Bar> {
        val timeFrame = mapper.mapStringToTimeFrame(tf)
        return mapper.mapListDtoToEntity(apiService.loadBars(timeFrame).barList)
    }
}