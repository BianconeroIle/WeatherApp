package com.example.ilijaangeleski.weatherapp.presenter;

import com.example.ilijaangeleski.weatherapp.api.NetworkApi;
import com.example.ilijaangeleski.weatherapp.callback.WeatherCallback;
import com.example.ilijaangeleski.weatherapp.manager.MainManager;
import com.example.ilijaangeleski.weatherapp.model.WeatherResponse;
import com.example.ilijaangeleski.weatherapp.view.MainView;

import java.lang.ref.WeakReference;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ilija Angeleski on 11/28/2017.
 */

public class MainPresenter {
    private MainManager mainManager;
    private WeakReference<MainView> weakReferenceMainView;

    public MainPresenter(MainView view){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NetworkApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        NetworkApi networkApi = retrofit.create(NetworkApi.class);
        this.mainManager= new MainManager(networkApi);
        this.weakReferenceMainView = new WeakReference<>(view);
    }

    public void validateCity(String city) {
        if (city == null || city.equals("")) {
            MainView view = weakReferenceMainView.get();
            if(view != null){
                view.setCityError();
            }
        } else {
            getWeatherDataByCity(city);
        }
    }

    public void getWeatherDataByCity(final String city){
        mainManager.getWeatherData(city, new WeatherCallback() {
            @Override
            public void onSuccess(List<WeatherResponse> weatherResponses) {
                MainView view = weakReferenceMainView.get();
                if(view != null){
                    view.showWeatherData(weatherResponses,city);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                MainView view = weakReferenceMainView.get();
                if(view != null){
                    view.errorGettingWeatherData();
                }
            }
        });
    }

}
