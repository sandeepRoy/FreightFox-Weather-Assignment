package com.weather.controllers;

import com.weather.responses.PincodeResponse;
import com.weather.responses.weather.WeatherResponse;
import com.weather.services.PincodeProcessingClient;
import com.weather.services.WeatherClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private PincodeProcessingClient pincodeProcessingClient;

    @Autowired
    private WeatherClient weatherClient;

    @GetMapping("/pincode_date")
    public ResponseEntity<WeatherResponse> getWeather(@RequestParam Integer pincode, @RequestParam LocalDate date_for) {
        System.out.println(pincode + " : " +date_for);
        PincodeResponse cityUsingPincode = pincodeProcessingClient.getCityUsingPincode(pincode);
        String district = cityUsingPincode.getDistrict();
        WeatherResponse weatherData = weatherClient.getWeatherData(district, date_for);
        return new ResponseEntity<>(weatherData, HttpStatus.OK);
    }
}
