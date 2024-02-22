package com.weather.responses.weather;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Forecastday {
    public String date;
    public int date_epoch;
    public Day day;
}
