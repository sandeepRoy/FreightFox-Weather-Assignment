package com.weather.services;

import com.weather.constants.WeatherConstant;
import com.weather.entities.Weather;
import com.weather.repositories.WeatherRepository;
import com.weather.responses.weather.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;
import java.util.List;

@Service
public class WeatherClient {

    @Autowired
    private WebClient weatherDataClient;

    @Autowired
    private WeatherRepository weatherRepository;

    private static String apiKey = "8d63e785f1014e8784a154426241902";

    // Get all data using uri, district, date & apiKey
    // https://api.weatherapi.com/v1/history.json?q=Kolkata&dt=2024-02-20&key=8d63e785f1014e8784a154426241902

    public Weather getWeatherData(String district, LocalDate date_for) {

        List<Weather> all = weatherRepository.findAll();

        for(Weather weather : all) {
            if(weather.getCity().equals(district)){
                System.out.println("Fetched from Database!");
                return weather;
            }
        }

        WeatherResponse block = weatherDataClient
                .get()
                .uri(WeatherConstant.GET_WEATHER_USING_CITY_DATE, district, date_for, apiKey)
                .retrieve()
                .bodyToMono(WeatherResponse.class)
                .block();

        String condition = block.forecast.forecastday.get(0).day.condition.getText();
        Weather created = new Weather();


        created.setCity(String.valueOf(block.location.name));
        created.setState(String.valueOf(block.location.region));
        created.setCountry(String.valueOf(block.location.country));
        created.setLatitude(String.valueOf(block.location.lat));
        created.setLongitude(String.valueOf(block.location.lon));
        created.setDate(String.valueOf(block.forecast.forecastday.get(0).date));
        created.setMaxtemp_c(String.valueOf(block.forecast.forecastday.get(0).day.maxtemp_c));
        created.setMintemp_c(String.valueOf(block.forecast.forecastday.get(0).day.mintemp_c));
        created.setAvgtemp_c(String.valueOf(block.forecast.forecastday.get(0).day.avgtemp_c));
        created.setMaxwind_kph(String.valueOf(block.forecast.forecastday.get(0).day.maxwind_kph));
        created.setAvghumidity(String.valueOf(block.forecast.forecastday.get(0).day.avghumidity));
        created.setWill_it_rain(String.valueOf(block.forecast.forecastday.get(0).day.daily_will_it_rain));
        created.setWill_it_snow(String.valueOf(block.forecast.forecastday.get(0).day.daily_will_it_snow));
        created.setSky(condition);
        created.setUv(String.valueOf(block.forecast.forecastday.get(0).day.uv));

        Weather save = weatherRepository.save(created);
        System.out.println("Created New!");
        return save;
    }
}
