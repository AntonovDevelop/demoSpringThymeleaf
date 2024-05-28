package com.example.demo.controller;

import com.example.demo.data.SearchDTO;
import com.example.demo.service.WeatherInteractor;
import com.example.demo.service.WeatherService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    private final WeatherService weatherService;

    public MainController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("search", new SearchDTO(""));
        var data = weatherService.getApiData();
        var weatherInteractor = new WeatherInteractor();
        model.addAttribute("current", weatherInteractor.getTemperatures(data));
        return "index";
    }

    @PostMapping("/find")
    public String find(@ModelAttribute SearchDTO searchDTO, Model model) {
        return "redirect:/";
    }
}
