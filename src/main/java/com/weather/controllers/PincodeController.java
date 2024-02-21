package com.weather.controllers;

import com.weather.exceptions.InvalidPincodeException;
import com.weather.requests.PincodeWithDateRequest;
import com.weather.responses.PincodeResponse;
import com.weather.responses.WeatherResponse;
import com.weather.services.PincodeProcessingClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class PincodeController {

    @Autowired
    private PincodeProcessingClient pincodeProcessingClient;

    @GetMapping("/pincode_date")
    public ResponseEntity<List<PincodeResponse>> getWeather(@RequestParam Integer pincode) {
        List<PincodeResponse> cityUsingPincode = pincodeProcessingClient.getCityUsingPincode(pincode);
        return new ResponseEntity<>(cityUsingPincode, HttpStatus.OK);
    }
}
