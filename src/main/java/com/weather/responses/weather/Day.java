package com.weather.responses.weather;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Day {
    public double maxtemp_c;
    public int maxtemp_f;
    public double mintemp_c;
    public double mintemp_f;
    public double avgtemp_c;
    public double avgtemp_f;
    public double maxwind_mph;
    public int maxwind_kph;
    public int totalprecip_mm;
    public int totalprecip_in;
    public int totalsnow_cm;
    public int avgvis_km;
    public int avgvis_miles;
    public int avghumidity;
    public int daily_will_it_rain;
    public int daily_chance_of_rain;
    public int daily_will_it_snow;
    public int daily_chance_of_snow;
    public Condition condition;
    public int uv;
}
