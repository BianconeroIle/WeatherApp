package com.example.ilijaangeleski.weatherapp.view;

import com.example.ilijaangeleski.weatherapp.callback.WeatherCallback;
import com.example.ilijaangeleski.weatherapp.model.WeatherResponse;

import java.util.List;

/**
 * Created by Ilija Angeleski on 11/28/2017.
 */

public interface MainView {
    void showWeatherData(WeatherResponse weatherResponse,String city);
    void setCityError();
    void errorGettingWeatherData();
}
