package com.weather.services;

import com.weather.constants.WeatherConstant;
import com.weather.entities.Weather;
import com.weather.repositories.WeatherRepository;
import com.weather.responses.weather.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;

@Service
public class WeatherClient {

    @Autowired
    private WebClient weatherDataClient;

    @Autowired
    private WeatherRepository weatherRepository;

    private static String apiKey = "8d63e785f1014e8784a154426241902";

    public WeatherResponse getWeatherData(String district, LocalDate date_for) {
        WeatherResponse block = weatherDataClient
                .get()
                .uri(WeatherConstant.GET_WEATHER_USING_CITY_DATE, district, date_for, apiKey)
                .retrieve()
                .bodyToMono(WeatherResponse.class)
                .block();

        String condition = block.forecast.forecastday.get(0).day.condition.getText();
        Weather weather = new Weather();

        weather.setCity(String.valueOf(block.location.name));
        weather.setState(String.valueOf(block.location.region));
        weather.setCountry(String.valueOf(block.location.country));
        weather.setLatitude(String.valueOf(block.location.lat));
        weather.setLongitude(String.valueOf(block.location.lon));
        weather.setDate(String.valueOf(block.forecast.forecastday.get(0).date));
        weather.setMaxtemp_c(String.valueOf(block.forecast.forecastday.get(0).day.maxtemp_c));
        weather.setMintemp_c(String.valueOf(block.forecast.forecastday.get(0).day.mintemp_c));
        weather.setAvgtemp_c(String.valueOf(block.forecast.forecastday.get(0).day.avgtemp_c));
        weather.setMaxwind_kph(String.valueOf(block.forecast.forecastday.get(0).day.maxwind_kph));
        weather.setAvghumidity(String.valueOf(block.forecast.forecastday.get(0).day.avghumidity));
        weather.setWill_it_rain(String.valueOf(block.forecast.forecastday.get(0).day.daily_will_it_rain));
        weather.setWill_it_snow(String.valueOf(block.forecast.forecastday.get(0).day.daily_will_it_snow));
        weather.setSky(condition);
        weather.setUv(String.valueOf(block.forecast.forecastday.get(0).day.uv));

        weatherRepository.save(weather);
        return block;

    }
}
