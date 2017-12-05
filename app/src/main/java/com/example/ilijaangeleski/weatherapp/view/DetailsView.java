package com.example.ilijaangeleski.weatherapp.view;

import com.example.ilijaangeleski.weatherapp.model.WeatherResponse;

/**
 * Created by Ilija Angeleski on 12/5/2017.
 */

public interface DetailsView {
    void showWeatherDetails(WeatherResponse weatherResponse);
    void errorGettingDetailsFromServer();
}
