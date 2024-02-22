package com.weather.controllers;

import com.weather.entities.Weather;
import com.weather.responses.PincodeResponse;
import com.weather.services.PincodeProcessingClient;
import com.weather.services.WeatherClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private PincodeProcessingClient pincodeProcessingClient;

    @Autowired
    private WeatherClient weatherClient;

    @GetMapping("/pincode_date")
    public ResponseEntity<Weather> getWeather(@RequestParam Integer pincode, @RequestParam LocalDate date_for) {
        PincodeResponse cityUsingPincode = pincodeProcessingClient.getCityUsingPincode(pincode);
        String district = cityUsingPincode.getDistrict();
        Weather weatherData = weatherClient.getWeatherData(district, date_for);
        return new ResponseEntity<>(weatherData, HttpStatus.OK);
    }
}
