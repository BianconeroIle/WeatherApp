package com.example.ilijaangeleski.weatherapp.api;

import com.example.ilijaangeleski.weatherapp.model.WeatherResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Ilija Angeleski on 11/28/2017.
 */

public interface NetworkApi {

    String BASE_URL = "http://api.openweathermap.org";
    String APP_ID = "1c8952a3e7d2a5d7a5a322163a17a2f1";

    @GET("data/2.5/weather")
    Call<WeatherResponse> getWeather(@Query("q") String city, @Query("appId") String appID);
}
