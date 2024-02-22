
# FreightFox-Weather-Assignment 

## Requirements

Backend Assignment - Weather Info for Pincode

You need to provide a single REST API for weather information for a particular day, 
and a Pincode

Input
   ```
   pincode: 411014,
   for_date: 2020-10-15
   ```
Response

Weather information for Pincode Save this information in DB(RDBMS)

```
1. Please save pincode lat, long separately
2. Also the weather information for the particular pincode
3. Next time we call the API then based on the information saved, API calls should
optimized
Ref: https://openweathermap.org/current

Optimized for API calls
● Pincode to lat long(Google Maps, Openweather Geocoding API)
● Lat long to Weather information (OpenWeather API)

Things to take care of
1. Only REST API - No UI
2. Testable by Postman/Swagger - No UI
3. Will prefer code structured in proper fashion
4. Will prefer Testcases (TDD)
```






## Run Locally

Clone the project using - ```https://github.com/sandeepRoy/FreightFox-Weather-Assignment.git```

Create database schema with given sql file(freightfox_weather.sql).

Please make sure to create a blank schema named 'freightfox_weather' before importing the sql file.

To create the jar file, run inside the cloned folder
 
```
mvn clean install

```
Inside target folder, Run the jar file using

```
java -jar FreightFox-Weather-0.0.1-SNAPSHOT.jar

```
To Test, use this Swagger Endpoint document

```
localhost:8080/swagger-ui/index.html

```
## API Reference

#### 1. Get WeatherData and Save

```http
  POST /weather/pincode_date
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `pincode` | `Integer` | **Required**. Pincode |
| `date_for` | `LocalDate` | **Required**. Date |


| Response Body| Type     | Description                |
| :-------- | :------- | :------------------------- |
| `{"id": 152, "city": "Bangalore", "state": "Karnataka", "country": "India", "latitude": "12.98", "longitude": "77.58", "date": "2024-02-20", "maxtemp_c": "32.8", "mintemp_c": "18.5", "avgtemp_c": "24.9", "maxwind_kph": "15", "avghumidity": "55", "will_it_rain": "0", "will_it_snow": "0", "sky": "Sunny", "uv": "8",}` | `Weather` | Weather Created Response |




## Note

The weather API used here is - https://app.swaggerhub.com/apis-docs/WeatherAPI.com/WeatherAPI/1.0.2#/APIs/history-weather

This is an **unsubscribed plan** and is restricted to have historical data of past 7 days from current date. Please use a date within that range to avoid failure to fetch weather data.

Valid date range for today, ```22nd Feb 2024 : 15th Feb 2024 to 21st Feb 2024```

**If required to access, historical data past 7+ days, requesting to register with a premium plan and replace the API key at : Line 23 : WeatherClient.java**


Thank You!

```
Sandeep Roy
Cell - 9178386506
Email - sandeep.roy2014@gmail.com
```