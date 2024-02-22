package com.weather.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WeatherConfiguration {
    @Bean
    public WebClient weatherDataClient() {
        return WebClient.builder().baseUrl("https://api.weatherapi.com/v1/history.json").build();
    }
}
