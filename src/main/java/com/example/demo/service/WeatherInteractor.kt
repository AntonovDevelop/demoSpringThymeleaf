package com.example.demo.service

import com.example.demo.data.WeatherDTO

class WeatherInteractor() {
    fun getTemperatures(weatherDTO: WeatherDTO): List<String> {
        return weatherDTO.hourly.temperature_2m.take(10).map { it.toString() + "C" }
    }
}