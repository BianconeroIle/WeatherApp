package com.example.ilijaangeleski.weatherapp.callback;

import com.example.ilijaangeleski.weatherapp.model.WeatherResponse;

import java.util.List;

/**
 * Created by Ilija Angeleski on 11/28/2017.
 */

public interface WeatherCallback {
    void onSuccess(WeatherResponse weatherResponses);
    void onFailure(Throwable t);
}
