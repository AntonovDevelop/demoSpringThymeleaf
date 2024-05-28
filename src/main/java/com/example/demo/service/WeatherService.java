package com.example.demo.service;

import com.example.demo.data.ConstKt;
import com.example.demo.data.WeatherDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherDTO getApiData() {
        return restTemplate.getForObject(ConstKt.API_URL, WeatherDTO.class);
    }
}
