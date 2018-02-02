package com.example.ilijaangeleski.weatherapp.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ilijaangeleski.weatherapp.R;
import com.example.ilijaangeleski.weatherapp.model.WeatherDTO;
import com.example.ilijaangeleski.weatherapp.model.WeatherResponse;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ilija Angeleski on 12/5/2017.
 */

public class WeatherDetailsActivity extends AppCompatActivity {
    @BindView(R.id.cityName)
    TextView cityName;
    @BindView(R.id.icon)
    ImageView icon;
    @BindView(R.id.temp)
    TextView temp;
    @BindView(R.id.condition)
    TextView condition;
    String name;

    public static final String GET_CITY = "getCityName";
    public static final String GET_WEATHER_RESPONSE = "weatherResponse";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_details);
        ButterKnife.bind(this);
        if (getIntent().getExtras() != null
                && getIntent().hasExtra(GET_CITY)
                && getIntent().hasExtra(GET_WEATHER_RESPONSE)
        ) {
            name = getIntent().getExtras().getString(GET_CITY);
            WeatherResponse weatherResponse = (WeatherResponse) getIntent().getExtras().getSerializable(GET_WEATHER_RESPONSE);
            showWeatherData(weatherResponse);
        }
    }

    public void showWeatherData(WeatherResponse weatherResponse) {
        cityName.setText(weatherResponse.getCityName());
        temp.setText(weatherResponse.getMainDTO().getTemp() + " \u2103");
        WeatherDTO weather = weatherResponse.getWeatherData().get(0);
        condition.setText(weather.getDescription());
        icon.setImageResource(getResources().getIdentifier(
                "a_" + weather.getIcon(), "drawable", getPackageName()));
    }
}
