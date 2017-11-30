package com.example.ilijaangeleski.weatherapp.manager;

import android.util.Log;

import com.example.ilijaangeleski.weatherapp.api.NetworkApi;
import com.example.ilijaangeleski.weatherapp.callback.WeatherCallback;
import com.example.ilijaangeleski.weatherapp.model.WeatherResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ilija Angeleski on 11/28/2017.
 */

public class MainManager {
    private NetworkApi networkApi;

    public MainManager(NetworkApi networkApi) {
        this.networkApi = networkApi;
    }

    public void getWeatherData(String city,final WeatherCallback weatherCallback){
        Call<List<WeatherResponse>> call = networkApi.getWeather(NetworkApi.appID,city);
        call.enqueue(new Callback<List<WeatherResponse>>() {
            @Override
            public void onResponse(Call<List<WeatherResponse>> call, Response<List<WeatherResponse>> response) {
                weatherCallback.onSuccess(response.body());
                Log.d("getWeatherData","Success");
            }

            @Override
            public void onFailure(Call<List<WeatherResponse>> call, Throwable t) {
                weatherCallback.onFailure(t);
                Log.d("getWeatherData","Failure");
            }
        });

    }


}
