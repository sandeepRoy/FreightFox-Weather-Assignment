package com.weather.services;

import com.weather.constants.PincodeConstant;
import com.weather.responses.PincodeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;

@Service
public class PincodeProcessingClient {

    @Autowired
    private WebClient pincodeClient;

    private static String apiKey = "d4411cf861msh50b89239c2bc9dbp1a1a6ajsn4bdc6987ce5e";

    private static String apiHost = "india-pincode-with-latitude-and-longitude.p.rapidapi.com";

    // Get all data using uri, pincode and api
    // https://india-pincode-with-latitude-and-longitude.p.rapidapi.com/api/v1/pincode/756001

    public PincodeResponse getCityUsingPincode(Integer pincode) {

        List<PincodeResponse> block = pincodeClient
                .get()
                .uri(PincodeConstant.PINCODE_INPUT, pincode)
                .header("X-RapidAPI-Key", apiKey)
                .header("X-RapidAPI-Host", apiHost)
                .retrieve()
                .bodyToFlux(PincodeResponse.class)
                .collectList()
                .block();

        return block.get(0);
    }
}
