package com.weather.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PincodeResponse {
    public int pincode;
    public String area;
    public double lat;
    public double lng;
    public String district;
    public String state;
}
