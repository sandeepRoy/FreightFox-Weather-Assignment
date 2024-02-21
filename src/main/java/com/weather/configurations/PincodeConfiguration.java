package com.weather.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class PincodeConfiguration {

    @Bean
    public WebClient pincodeClient() {
        return WebClient.builder().baseUrl("https://india-pincode-with-latitude-and-longitude.p.rapidapi.com/api/v1/pincode").build();
    }
}
