package com.weather.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "response_data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String city;
    private String state;
    private String country;
    private String latitude;
    private String longitude;
    private String date;
    private String maxtemp_c;
    private String mintemp_c;
    private String avgtemp_c;
    private String maxwind_kph;
    private String avghumidity;
    private String will_it_rain;
    private String will_it_snow;
    private String sky;
    private String uv;
}
